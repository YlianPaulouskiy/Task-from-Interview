package edu.itstep.examination.utils;

import edu.itstep.examination.exception.InvalidFormatSourceLineException;

public class StringUtils {

    public static String removeSpaces(String source) {
        if (source != null && source.length() > 2) {
            return source.replace(" ", "");
        } else {
            throw new InvalidFormatSourceLineException();
        }
    }

    /**ПАрсит выражение на числа
     *
     * @param line строка с выражением
     * @return массив чисел
     */
    public static String[] getNumbers(String line) {
        return line.split("[+|*|\\-|/]");
    }
}
