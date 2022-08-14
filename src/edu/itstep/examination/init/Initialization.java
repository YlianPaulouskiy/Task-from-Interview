package edu.itstep.examination.init;

import edu.itstep.examination.singleton.ConstantSingleton;

import java.util.HashMap;
import java.util.Map;


/**
 * Заполняет синглетон
 */
public class Initialization {

    /**
     * Заполняет Араб -> Рим значениями
     */
    public static void initArabToRim() {
        Map<String, String> tenMap = new HashMap<>();
        Map<String, String> unitMap = new HashMap<>();

        tenMap.put("10", "X");
        tenMap.put("20", "XX");
        tenMap.put("30", "XXX");
        tenMap.put("40", "XL");
        tenMap.put("50", "L");
        tenMap.put("60", "LX");
        tenMap.put("70", "LXX");
        tenMap.put("80", "LXXX");
        tenMap.put("90", "XC");
        tenMap.put("100", "C");


        unitMap.put("1", "I");
        unitMap.put("2", "II");
        unitMap.put("3", "III");
        unitMap.put("4", "IV");
        unitMap.put("5", "V");
        unitMap.put("6", "VI");
        unitMap.put("7", "VII");
        unitMap.put("8", "VIII");
        unitMap.put("9", "IX");

        ConstantSingleton.instance(tenMap, unitMap);
    }

    /**
     * Заполняет Рим -> Араб значениями
     */
    public static void initRimToArab() {
        Map<String, String> tenMap = new HashMap<>();
        Map<String, String> unitMap = new HashMap<>();

        tenMap.put("X", "10");
        tenMap.put("XX", "20");
        tenMap.put("XXX", "30");
        tenMap.put("XL", "40");
        tenMap.put("L", "50");
        tenMap.put("LX", "60");
        tenMap.put("LXX", "70");
        tenMap.put("LXXX", "80");
        tenMap.put("XC", "90");
        tenMap.put("C", "100");


        unitMap.put("I", "1");
        unitMap.put("II", "2");
        unitMap.put("III", "3");
        unitMap.put("IV", "4");
        unitMap.put("V", "5");
        unitMap.put("VI", "6");
        unitMap.put("VII", "7");
        unitMap.put("VIII", "8");
        unitMap.put("IX", "9");

        ConstantSingleton.instance(tenMap, unitMap);
    }
}
