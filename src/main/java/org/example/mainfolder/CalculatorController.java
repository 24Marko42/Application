package org.example.mainfolder;

// Импорты необходимых классов JavaFX
import javafx.fxml.FXML; // Для использования аннотации @FXML
import javafx.scene.control.TextField; // Для текстового поля

public class CalculatorController { // Контроллер для обработки действий на интерфейсе калькулятора
    @FXML
    private TextField resultField;
    // Поле для отображения текущего выражения или результата.
    // Оно связывается с элементом TextField в FXML-файле.

    private StringBuilder currentInput = new StringBuilder();
    // Строка для хранения текущего вводимого выражения.
    // Используем StringBuilder для удобного и эффективного изменения строки.

    private boolean lastInputWasOperator = false;
    // Флаг для отслеживания, был ли последний введённый символ оператором.
    // Нужен, чтобы запретить ввод двух операторов подряд.

    private boolean hasDot = false;
    // Флаг для проверки наличия десятичной точки в текущем числе.
    // Нужен, чтобы предотвратить ввод более одной точки в число.

    // Метод для обработки нажатия кнопок с числами
    @FXML
    private void handleNumber(javafx.event.ActionEvent event) {
        String value = ((javafx.scene.control.Button) event.getSource()).getText();
        // Получаем текст с кнопки, на которую нажал пользователь (например, "1", "2" и т.д.).

        currentInput.append(value);
        // Добавляем это число в строку текущего выражения.

        lastInputWasOperator = false;
        // Устанавливаем флаг: последний ввод не является оператором.

        resultField.setText(currentInput.toString());
        // Обновляем поле вывода с новым выражением.
    }

    // Метод для обработки операторов (+, -, *, /)
    @FXML
    private void handleOperator(javafx.event.ActionEvent event) {
        String operator = ((javafx.scene.control.Button) event.getSource()).getText();
        // Получаем текст оператора с нажатой кнопки.

        if (!lastInputWasOperator && currentInput.length() > 0) {
            // Проверяем, что перед оператором уже есть число
            // и оператор не является первым символом строки.

            currentInput.append(" ").append(operator).append(" ");
            // Добавляем оператор в строку с пробелами перед и после,
            // чтобы удобнее разделять токены в будущем.

            lastInputWasOperator = true;
            // Устанавливаем флаг: последний ввод является оператором.

            hasDot = false;
            // Сбрасываем флаг точки, так как начинается ввод нового числа.
        }

        resultField.setText(currentInput.toString());
        // Обновляем поле вывода с текущим выражением.
    }

    // Метод для обработки десятичной точки (.)
    @FXML
    private void handleDot() {
        if (!hasDot && !lastInputWasOperator) {
            // Проверяем, что точка не была уже добавлена в текущее число
            // и что предыдущий ввод не был оператором.

            currentInput.append(".");
            // Добавляем точку в строку текущего выражения.

            hasDot = true;
            // Устанавливаем флаг: точка добавлена.

            resultField.setText(currentInput.toString());
            // Обновляем поле вывода.
        }
    }

    // Метод для удаления последнего символа
    @FXML
    private void deleteLast() {
        if (currentInput.length() > 0) {
            // Проверяем, что строка текущего ввода не пуста.

            char lastChar = currentInput.charAt(currentInput.length() - 1);
            // Получаем последний символ строки.

            if (lastChar == '.') {
                // Если удаляем точку, сбрасываем флаг точки.
                hasDot = false;
            }

            if (lastChar == ' ') {
                // Если удаляем пробел (обычно перед оператором), удаляем также весь оператор.
                currentInput.delete(currentInput.length() - 3, currentInput.length());
                // Удаляем последние три символа: пробел, оператор и пробел.
                lastInputWasOperator = false;
                // Сбрасываем флаг, так как оператор удалён.
            } else {
                currentInput.deleteCharAt(currentInput.length() - 1);
                // Удаляем последний символ.
            }

            resultField.setText(currentInput.toString());
            // Обновляем поле вывода.
        }
    }

    // Метод для полной очистки ввода
    @FXML
    private void clearAll() {
        currentInput.setLength(0);
        // Полностью очищаем строку текущего выражения.

        lastInputWasOperator = false;
        // Сбрасываем флаг оператора.

        hasDot = false;
        // Сбрасываем флаг точки.

        resultField.clear();
        // Очищаем поле вывода.
    }

    // Метод для вычисления результата
    @FXML
    private void calculateResult() {
        try {
            String expression = currentInput.toString();
            // Получаем текущую строку выражения.

            double result = evaluate(expression);
            // Вызываем метод для вычисления выражения.

            resultField.setText(String.valueOf(result));
            // Обновляем поле вывода результатом.

            currentInput.setLength(0);
            // Очищаем строку текущего выражения.

            currentInput.append(result);
            // Сохраняем результат как новое значение в строке ввода.

            hasDot = resultField.getText().contains(".");
            // Проверяем, содержит ли результат точку, и обновляем флаг.

            lastInputWasOperator = false;
            // Сбрасываем флаг оператора, так как результат не является оператором.
        } catch (Exception e) {
            resultField.setText("Ошибка");
            // Если при вычислении произошла ошибка (например, деление на 0), выводим "Ошибка".
        }
    }

    // Метод для вычисления математического выражения
    private double evaluate(String expression) {
        // Разбиваем строку выражения на токены (операнды и операторы)
        String[] tokens = expression.split(" ");
        double result = Double.parseDouble(tokens[0]);
        // Первый токен — начальное число, преобразуем его в число.

        for (int i = 1; i < tokens.length; i += 2) {
            // Итерируем через операторы и соответствующие операнды.
            String operator = tokens[i];
            // Получаем оператор (например, "+", "-", "*", "/").

            double operand = Double.parseDouble(tokens[i + 1]);
            // Получаем следующий операнд.

            switch (operator) {
                // Выполняем соответствующую математическую операцию.
                case "+" -> result += operand;
                case "-" -> result -= operand;
                case "*" -> result *= operand;
                case "/" -> {
                    if (operand == 0) throw new ArithmeticException("Деление на ноль");
                    // Обработка деления на ноль.
                    result /= operand;
                }
            }
        }

        return result;
        // Возвращаем итоговый результат вычисления.
    }
}
