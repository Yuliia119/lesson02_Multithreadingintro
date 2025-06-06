package ait.calculator.infra;

public class Calculator {
    // указываем папку, где находятся все классы операций (Add, Mul, Sub)
    private static final String PACKAGE = "ait.calculator.model.";

    // объявляем статический метод, принимаем три параметра: число+число+операция, добавляем исключения
    public static double calculate(String operand1, String operand2, String oper) throws Exception {

        // метод принимает строку и преобразует его в число типа double
        double a = Double.parseDouble(operand1);
        double b = Double.parseDouble(operand2);

        // через рефлексию ищем класс с именем
        Class<?> clazz = Class.forName(PACKAGE + oper);

        // создаём новый объект нужного класса, приводим к интерфейсу
        Action calc = (Action) clazz.getDeclaredConstructor().newInstance();

        // вызываем метод execute в интерфейсе и возвращаем результат
        double res = calc.execute(a, b);
        return res;

    }
}
