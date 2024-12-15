package org.example.mainfolder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Widget extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/mainfolder/Widget.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Скрытие и показ виджетов");
        primaryStage.setMinWidth(300); // Устанавливает минимальную ширину окна
        primaryStage.setMinHeight(300); // Устанавливает минимальную высоту окна
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
