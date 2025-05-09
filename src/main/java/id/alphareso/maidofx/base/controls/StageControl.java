package id.alphareso.maidofx.base.controls;

import id.alphareso.maidofx.util.FileResource;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Objects;

public class StageControl extends HBox {

    public StageControl(Stage stage) {
        Button btnClose = createButton("/images/close-light.png", () -> stage.close());
        Button btnMinimize = createButton("/images/minimize-light.png", () -> stage.setIconified(true));
        Button btnMaximize = createButton("/images/maximize-light.png", () -> stage.setMaximized(!stage.isMaximized()));

        this.getChildren().addAll(btnMinimize, btnMaximize, btnClose);
        this.setSpacing(5);
    }

    private Button createButton(String iconPath, Runnable action) {
        ImageView icon = new ImageView(new Image(Objects.requireNonNull(FileResource.load(iconPath))));
        icon.setFitWidth(16);
        icon.setFitHeight(16);

        Button button = new Button();
        button.setGraphic(icon);
        button.setOnAction(e -> action.run());

        return button;
    }
}
