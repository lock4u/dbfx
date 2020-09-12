package cn.navigational.dbfx.dialog;

import cn.navigational.dbfx.FXMLHelper;
import cn.navigational.dbfx.config.AppConstantsKt;
import cn.navigational.dbfx.tool.svg.SvgImageTranscoder;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;


/**
 * A decorated dialog
 *
 * @param <T> Dialog return turn
 * @author yangkui
 * @since 1.0
 */
public class UnDecoratedDialog<T> extends Dialog<T> {

    /**
     * Dialog pane default class
     */
    private static final String DEFAULT_DIALOG_PANE_CLASS = "undecorated-dialog";
    /**
     * Dialog pane content style class
     */
    private static final String DEFAULT_PANE_CONTENT_CLASS = "undecorated-dialog-pane-content";
    /**
     * Default dialog header class
     */
    private static final String DEFAULT_HEADER_CLASS = "undecorated-dialog-header";

    private final StackPane dialogHeader = new StackPane();

    public UnDecoratedDialog(String title) {
        this(title, true);
    }

    public UnDecoratedDialog(String title, boolean closeable) {
        var label = new Label(title);
        var close = new Button();
        this.initStyle(StageStyle.DECORATED);
        StackPane.setAlignment(label, Pos.CENTER);
        if (closeable) {
            this.dialogHeader.getChildren().add(close);
            StackPane.setAlignment(close, Pos.CENTER_RIGHT);
        }
        this.dialogHeader.getChildren().add(label);
        this.dialogHeader.getStyleClass().add(DEFAULT_HEADER_CLASS);
        this.setDialogPane(new DialogPane());
        this.getDialogPane().getStyleClass().add(DEFAULT_DIALOG_PANE_CLASS);
        this.getDialogPane().getStylesheets().add(AppConstantsKt.APP_STYLE);
        this.initStyle(StageStyle.UNDECORATED);
        close.setOnAction(e -> closeDialog());
        close.setGraphic(SvgImageTranscoder.svgToImageView(AppConstantsKt.DIALOG_CLOSE_ICON));
    }

    public UnDecoratedDialog(String title, boolean closeable, String fxml) {
        this(title, closeable);
        var node = (Node) FXMLHelper.loadFxml(fxml, this);
        var vBox = new VBox();
        vBox.getChildren().addAll(dialogHeader, node);
        this.getDialogPane().setContent(vBox);
        node.getStyleClass().add(DEFAULT_PANE_CONTENT_CLASS);
    }

    public UnDecoratedDialog(String title, String fxml) {
        this(title, true, fxml);
    }

    /**
     * When current dialog close call that function
     */
    public void closeDialog() {
    }
}
