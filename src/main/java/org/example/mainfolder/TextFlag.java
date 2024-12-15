package org.example.mainfolder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TextFlag extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Загрузка FXML файла
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/mainfolder/TextFlag.fxml"));

        // Создание сцены из загруженного интерфейса
        Scene scene = new Scene(loader.load());

        // Настройка окна приложения
        primaryStage.setScene(scene); // Устанавливаем сцену
        primaryStage.setTitle("Текстовый флаг"); // Заголовок окна
        primaryStage.setResizable(false); // Запрещаем изменение размера окна
        primaryStage.show(); // Показываем окно
    }

    public static void main(String[] args) {
        launch(args); // Запуск приложения
    }
}
