package org.example.mainfolder;

import javafx.fxml.FXML; // Импорт аннотации для связывания элементов из FXML.
import javafx.scene.control.Button; // Импорт кнопки для взаимодействия с интерфейсом.
import javafx.scene.control.TextField; // Импорт текстовых полей.

public class WordSwitcherController {
    // Связываем элементы FXML с контроллером
    @FXML
    private TextField field1, field2; // Первое и второе текстовые поля.
    @FXML
    private Button switchButton; // Кнопка для переключения текста.

    // Флаг для отслеживания направления переноса текста:
    // true - из field1 в field2, false - наоборот.
    private boolean isLeftToRight = true;

    // Метод инициализации, вызывается автоматически после загрузки FXML
    @FXML
    public void initialize() {
        // Устанавливаем подсказки для текстовых полей
        field1.setPromptText("Писать сюда, там не пишется");
        field2.setPromptText("Тут не писать, здесь появится");

        // Делаем второе поле недоступным для редактирования изначально
        field2.setEditable(false);
    }

    // Обработчик события нажатия на кнопку
    @FXML
    private void handleButtonClick() {
        if (isLeftToRight) {
            // Если направление переноса текста из field1 в field2:
            field2.setText(field1.getText()); // Переносим текст из field1 в field2.
            field1.clear(); // Очищаем первое поле.
            field1.setEditable(false); // Делаем первое поле недоступным для ввода.
            field2.setEditable(true); // Делаем второе поле доступным для ввода.
            switchButton.setText("сюда"); // Меняем текст кнопки на "сюда".
        } else {
            // Если направление переноса текста из field2 в field1:
            field1.setText(field2.getText()); // Переносим текст из field2 в field1.
            field2.clear(); // Очищаем второе поле.
            field2.setEditable(false); // Делаем второе поле недоступным для ввода.
            field1.setEditable(true); // Делаем первое поле доступным для ввода.
            switchButton.setText("туда"); // Меняем текст кнопки на "туда".
        }

        // Меняем направление переноса текста
        isLeftToRight = !isLeftToRight;
    }
}
