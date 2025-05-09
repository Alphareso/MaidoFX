package id.alphareso.maidofx.base.titles;

import id.alphareso.maidofx.base.controls.StageControl;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StageTitle extends BorderPane {

    private final ImageView icon;
    private final StageControl controlButtons;

    public StageTitle(Stage stage) {
        this.setPadding(new Insets(5));
        this.setStyle("-fx-background-color: #2c3e50;");

        // STIcon
        icon = new ImageView(); // Placeholder, bisa diganti
        icon.setFitWidth(16);
        icon.setFitHeight(16);
        setLeft(icon);
        BorderPane.setAlignment(icon, Pos.CENTER_LEFT);

        // STControlButton
        controlButtons = new StageControl(stage);
        setRight(controlButtons);
        BorderPane.setAlignment(controlButtons, Pos.CENTER_RIGHT);
    }
}
