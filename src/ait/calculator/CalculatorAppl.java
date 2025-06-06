package ait.calculator;

import ait.calculator.infra.Calculator;

public class CalculatorAppl {
    public static void main(String[] args) {

        // проверка - передаём три аргумента: число, число, действие
        if (args.length != 3) {
            System.out.println("Wrong number of arguments");
            return;
        }
        try {
            // вызываем метод calculate (преобразует строки в числа, создаёт нужный класс по имени, выполняет действие)
            double res = Calculator.calculate(args[0], args[1], args[2]);
            System.out.println("Result = " + res);
        }
        // обрабатываем исключения (неправильный формат числа, неправильная операция)
        catch (NumberFormatException e) {
            System.out.println("Wrong number format");
        } catch (Exception e) {
            System.out.println("Wrong operation");
        }

    }
}
