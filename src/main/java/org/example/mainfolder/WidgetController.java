package org.example.mainfolder;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WidgetController {
    // Виджеты для управления
    @FXML
    private Label label1;
    @FXML
    private Button button1;
    @FXML
    private TextField textField1;

    // Обработчики событий для чекбоксов
    @FXML
    private void toggleLabel() {
        label1.setVisible(!label1.isVisible()); // Скрыть/показать Виджет 1
    }

    @FXML
    private void toggleButton() {
        button1.setVisible(!button1.isVisible()); // Скрыть/показать Виджет 2
    }

    @FXML
    private void toggleTextField() {
        textField1.setVisible(!textField1.isVisible()); // Скрыть/показать Виджет 3
    }
}
