package org.example.mainfolder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class TextFlagController {

    // Группы для радио-кнопок
    @FXML
    private ToggleGroup colorGroup1;

    @FXML
    private ToggleGroup colorGroup2;

    @FXML
    private ToggleGroup colorGroup3;

    // Метка для отображения результата
    @FXML
    private Label resultLabel;

    // Радио-кнопки (если нужно ссылаться напрямую)
    @FXML
    private RadioButton firstColorRed, firstColorGreen, firstColorBlue;
    @FXML
    private RadioButton secondColorYellow, secondColorWhite, secondColorOrange;
    @FXML
    private RadioButton thirdColorBlack, thirdColorPurple, thirdColorGray;

    // Метод, вызываемый при нажатии на кнопку "Нарисовать"
    @FXML
    private void drawFlag() {
        RadioButton selectedColor1 = (RadioButton) colorGroup1.getSelectedToggle();
        RadioButton selectedColor2 = (RadioButton) colorGroup2.getSelectedToggle();
        RadioButton selectedColor3 = (RadioButton) colorGroup3.getSelectedToggle();

        if (selectedColor1 == null || selectedColor2 == null || selectedColor3 == null) {
            resultLabel.setText("Пожалуйста, выберите цвета для всех полос.");
            resultLabel.setTextFill(Color.RED);
            return;
        }

        // Текст выбранных цветов
        String colorText1 = selectedColor1.getText();
        String colorText2 = selectedColor2.getText();
        String colorText3 = selectedColor3.getText();

        // Отображение результата
        resultLabel.setText("Выбранные цвета: " + colorText1 + ", " + colorText2 + ", " + colorText3);
        resultLabel.setTextFill(Color.BLACK); // Установим стандартный цвет текста
    }
}
