package org.example.mainfolder;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.converter.IntegerStringConverter;

public class OrderController {

    @FXML
    private CheckBox pivoCheckBox;
    @FXML
    private CheckBox viskiCheckBox;
    @FXML
    private CheckBox vodkaCheckBox;

    @FXML
    private Spinner<Integer> pivoSpinner;
    @FXML
    private Spinner<Integer> viskiSpinner;
    @FXML
    private Spinner<Integer> vodkaSpinner;

    @FXML
    private Button calculateButton;

    @FXML
    private TextArea receipt;

    @FXML
    public void initialize() {
        // Обработчик события нажатия кнопки
        calculateButton.setOnAction(event -> {
            double total = 0;
            StringBuilder receiptText = new StringBuilder("Ваш заказ:\n");

            if (pivoCheckBox.isSelected()) {
                int qty = pivoSpinner.getValue();
                double cost = 500 * qty;
                total += cost;
                receiptText.append("Пиво: ").append(qty).append(" шт. = ").append(cost).append(" руб.\n");
            }
            if (viskiCheckBox.isSelected()) {
                int qty = viskiSpinner.getValue();
                double cost = 300 * qty;
                total += cost;
                receiptText.append("Виски: ").append(qty).append(" шт. = ").append(cost).append(" руб.\n");
            }
            if (vodkaCheckBox.isSelected()) {
                int qty = vodkaSpinner.getValue();
                double cost = 200 * qty;
                total += cost;
                receiptText.append("Водка: ").append(qty).append(" шт. = ").append(cost).append(" руб.\n");
            }

            receiptText.append("Итого: ").append(total).append(" руб.");
            receipt.setText(receiptText.toString());
        });


        // Устанавливаем TextFormatter для ограничения ввода только цифрами
        pivoSpinner.getEditor().setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), 1, change -> {
            String newText = change.getControlNewText();
            return newText.matches("\\d*") ? change : null;
        })); //Регулярное выражение \\d* соответствует строкам, содержащим ноль или более цифр.
        viskiSpinner.getEditor().setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), 1, change -> {
            String newText = change.getControlNewText();
            return newText.matches("\\d*") ? change : null;
        }));
        vodkaSpinner.getEditor().setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), 1, change -> {
            String newText = change.getControlNewText();
            return newText.matches("\\d*") ? change : null;
        }));
    }
}
