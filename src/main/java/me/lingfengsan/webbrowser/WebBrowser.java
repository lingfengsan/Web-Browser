package me.lingfengsan.webbrowser;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;

/**
 * @author: 元昱
 * @create: 2018-08-15 21:23
 **/
public class WebBrowser {
    private JPanel webPanel;
    private static WebEngine eng;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final String URL_START = "http://";
    private static final String URL_START_0 = "https://";

    public JPanel getWebPanel() {
        webPanel.add(getComponent(), BorderLayout.CENTER);
        return webPanel;
    }

    public static void openUrl(String url){
        Platform.runLater(()->{
            eng.load(url);
        });
    }
    public static JFXPanel getComponent() {

        final JFXPanel webBrowser = new JFXPanel();

        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                Group root = new Group();
                Scene scene = new Scene(root, WIDTH, HEIGHT);
                webBrowser.setScene(scene);
                Double widthDouble = new Integer(WIDTH).doubleValue();
                Double heightDouble = new Integer(HEIGHT).doubleValue();

                VBox box = new VBox(10);
                HBox urlBox = new HBox(10);
                final TextField urlTextField = new TextField();
                urlTextField.setText(WebBrowserSetting.indexPageUrl);
                Button go = new Button("go");
                urlTextField.setPrefWidth(WIDTH - 70);
                urlBox.getChildren().addAll(urlTextField, go);

                WebView view = new WebView();
                view.setMinSize(widthDouble, heightDouble);
                view.setPrefSize(widthDouble, heightDouble);
                eng = view.getEngine();
                eng.load(WebBrowserSetting.indexPageUrl);
                root.getChildren().add(view);

                box.getChildren().add(urlBox);
                box.getChildren().add(view);
                root.getChildren().add(box);

                go.setOnAction(event -> {
                    String tempUrl = urlTextField.getText();
                    if (!(tempUrl.startsWith(URL_START) || tempUrl.startsWith(URL_START_0))) {
                        eng.load(URL_START + urlTextField.getText());
                    } else {
                        eng.load(urlTextField.getText());
                    }
                });
            }
        });
        return webBrowser;
    }
}
