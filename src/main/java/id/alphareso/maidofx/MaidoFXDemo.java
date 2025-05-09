package id.alphareso.maidofx;

import id.alphareso.maidofx.base.stages.CornerStage;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MaidoFXDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        CornerStage cornerStage = new CornerStage(800, 600, 20);
        cornerStage.setTitle("MaidoFX Demo");
        //cornerStage.initStyle(StageStyle.TRANSPARENT);
        cornerStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
