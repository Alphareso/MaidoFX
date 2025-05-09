package id.alphareso.maidofx.base.stages;

import id.alphareso.maidofx.base.titles.StageTitle;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.StageStyle;

public class CornerStage extends CoreStage {

    private final double minWidth;
    private final double minHeight;
    private final double cornerRadius;

    private final StageTitle titleBar;
    private final NavigationStage navigationPane;
    private final ContentStage contentPane;

    public CornerStage(double minWidth, double minHeight, double cornerRadius) {
        this.minWidth = minWidth;
        this.minHeight = minHeight;
        this.cornerRadius = cornerRadius;

        this.setMinWidth(minWidth);
        this.setMinHeight(minHeight);

        initStyle(StageStyle.TRANSPARENT);

        titleBar = new StageTitle(this);
        navigationPane = new NavigationStage();
        contentPane = new ContentStage();

        BorderPane root = new BorderPane();
        root.setTop(titleBar);
        root.setLeft(navigationPane);
        root.setCenter(contentPane);
        root.setPadding(new Insets(0));

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        this.setScene(scene);

        // Create the rounded rectangle effect
        Rectangle mask = new Rectangle(scene.getWidth(), scene.getHeight());
        mask.setArcWidth(cornerRadius * 2);
        mask.setArcHeight(cornerRadius * 2);
        root.setClip(mask);

        // Update the mask and shadow on resize and maximize
        root.layoutBoundsProperty().addListener((ov, w, h) -> {
            mask.setWidth(h.getWidth());
            mask.setHeight(h.getHeight());
            mask.setArcWidth(cornerRadius * 2);
            mask.setArcHeight(cornerRadius * 2);
        });

        this.maximizedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                // When maximized, set mask to screen bounds
                Screen screen = Screen.getPrimary();
                Rectangle2D bounds = screen.getVisualBounds();
                mask.setWidth(bounds.getWidth());
                mask.setHeight(bounds.getHeight());
                mask.setArcWidth(0); // No rounded corners when maximized
                mask.setArcHeight(0);
                root.setClip(mask); // Re-apply the mask
            } else {
                // When unmaximized, reset to original size
                mask.setWidth(this.getWidth());
                mask.setHeight(this.getHeight());
                mask.setArcWidth(cornerRadius * 2);
                mask.setArcHeight(cornerRadius * 2);
                root.setClip(mask); // Re-apply the mask
            }
        });

        // Add a shadow for better visual appeal (optional)
        DropShadow shadow = new DropShadow();
        shadow.setRadius(10.0);
        //shadow.setOpacity(0.5);
        root.setEffect(shadow);
    }

    public void showTitleBar(boolean show) {
        ((BorderPane) this.getScene().getRoot()).setTop(show ? titleBar : null);
    }

    public void showNavigation(boolean show) {
        ((BorderPane) this.getScene().getRoot()).setLeft(show ? navigationPane : null);
    }

    public void showContent(boolean show) {
        ((BorderPane) this.getScene().getRoot()).setCenter(show ? contentPane : null);
    }

    public StageTitle getStageTitle() {
        return titleBar;
    }

    public NavigationStage getNavigationPane() {
        return navigationPane;
    }

    public ContentStage getContentPane() {
        return contentPane;
    }
}
