package edu.itstep.examination;


import edu.itstep.examination.lines.LineCheck;
import edu.itstep.examination.lines.LineOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        LineOperation lineOperation = new LineOperation();


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите выражение для вычисления");
        try {
            System.out.println("Ответ: " + lineOperation.getResult(bufferedReader.readLine()));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

}
