package id.alphareso.maidofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.effect.DropShadow;
import javafx.scene.shape.Rectangle;

public class RoundStage extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Membuat root pane
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: grey;"); // Set latar belakang abu-abu

        // Membuat scene dengan latar belakang transparan
        Scene scene = new Scene(root, 300, 200);
        scene.setFill(Color.TRANSPARENT);

        // Membuat stage dengan style transparan
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);

        // Membuat efek sudut membulat
        double radius = 20;
        Rectangle roundRect = new Rectangle(scene.getWidth(), scene.getHeight());
        roundRect.setArcWidth(radius * 2);
        roundRect.setArcHeight(radius * 2);
        root.setClip(roundRect);

        // Menambahkan listener untuk memperbarui bentuk rounded saat ukuran jendela berubah
        root.layoutBoundsProperty().addListener((observable, oldValue, newValue) -> {
            roundRect.setWidth(newValue.getWidth());
            roundRect.setHeight(newValue.getHeight());
            roundRect.setArcWidth(radius * 2);
            roundRect.setArcHeight(radius * 2);
        });

        // Menambahkan efek shadow (opsional)
        DropShadow shadow = new DropShadow();
        shadow.setRadius(10);
        shadow.setColor(Color.BLACK.deriveColor(0, 0, 0, 0.4));
        root.setEffect(shadow);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}