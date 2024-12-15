package org.example.mainfolder;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class TextFlagController {
    @FXML
    private TextField inputField; // Поле для ввода текста.
    @FXML
    private ComboBox<String> backgroundColorPicker; // Выпадающий список для выбора цвета фона.

    @FXML
    private RadioButton textColorRed, textColorBlue, textColorGreen; // Переключатели для выбора цвета текста.

    @FXML
    private AnchorPane rootPane; // Корневой контейнер для изменения цвета фона.

    @FXML
    public void initialize() {
        // Добавляем варианты цветов фона в ComboBox
        backgroundColorPicker.getItems().addAll("Белый", "Желтый", "Серый", "Черный");

        // Устанавливаем изначальный выбор (по умолчанию белый фон)
        backgroundColorPicker.setValue("Белый");
        rootPane.setStyle("-fx-background-color: white;");
    }

    // Метод для изменения фона
    @FXML
    private void changeBackground() {
        String selectedColor = backgroundColorPicker.getValue();
        String colorCode;

        switch (selectedColor) {
            case "Желтый":
                colorCode = "yellow";
                break;
            case "Серый":
                colorCode = "gray";
                break;
            case "Черный":
                colorCode = "black";
                break;
            default: // Белый
                colorCode = "white";
        }

        // Устанавливаем цвет фона для AnchorPane
        rootPane.setStyle("-fx-background-color: " + colorCode + ";");
    }

    // Метод для изменения цвета текста
    @FXML
    private void changeTextColor() {
        String colorCode;

        if (textColorRed.isSelected()) {
            colorCode = "red";
        } else if (textColorBlue.isSelected()) {
            colorCode = "blue";
        } else if (textColorGreen.isSelected()) {
            colorCode = "green";
        } else {
            return; // Если ни один RadioButton не выбран
        }

        // Устанавливаем цвет текста для TextField
        inputField.setStyle("-fx-text-fill: " + colorCode + ";");
    }
}
