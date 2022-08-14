package edu.itstep.examination.lines;

import edu.itstep.examination.calc.Calculate;
import edu.itstep.examination.calc.impl.Division;
import edu.itstep.examination.calc.impl.Multiplication;
import edu.itstep.examination.calc.impl.Subtraction;
import edu.itstep.examination.calc.impl.Sum;
import edu.itstep.examination.converter.Converter;
import edu.itstep.examination.exception.NegativeNumberException;
import edu.itstep.examination.utils.StringUtils;

import java.util.Arrays;

public class LineOperation {

    public String getResult(String line) {
        if (LineCheck.check(line)) {
            //чистим строку от пробелов
            line = StringUtils.removeSpaces(line);
            //находим операцию, которая нам необходима
            Calculate calculate = getOperation(line);
            String[] stringNumbers = StringUtils.getNumbers(line);
            //вычисления
            // проверка арабские или римские числа
            if (LineCheck.isArabNumber(stringNumbers[0])) {
                //для арабских чисел
                int[] numbers = getNumbers(stringNumbers);
                return String.valueOf(calculate.getResult(numbers[0], numbers[1]));
            } else {
                //для римских чисел
                //переводим в арбские
                for (int i = 0; i < stringNumbers.length; i++) {
                    stringNumbers[i] = Converter.RimToArab(stringNumbers[i]);
                }
                //получаем массив чисел из массива строк
                int[] numbers = getNumbers(stringNumbers);
                int result = calculate.getResult(numbers[0], numbers[1]);
                //если число не отрицательное то выводим
                if (result > 0) {
                    return Converter.ArabToRim(String.valueOf(result));
                } else {
                    throw new NegativeNumberException();
                }
            }
        }
        return "что-то пошло не так";
    }

    private int[] getNumbers(String ...numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
    }

    private Calculate getOperation(String line) {
        if (line.contains("+")) {
            return new Sum();
        } else if (line.contains("-")) {
            return new Subtraction();
        } else if (line.contains("*")) {
            return new Multiplication();
        } else {
            return new Division();
        }
    }
}
