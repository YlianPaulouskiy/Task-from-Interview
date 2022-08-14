package edu.itstep.examination.converter;

import edu.itstep.examination.init.Initialization;
import edu.itstep.examination.singleton.ConstantSingleton;

import java.util.Map;

/**
 * Нужен для перевода с одной системы счисления в другую
 */
public class Converter {

    /**
     * Переводит арабские числа в римские
     *
     * @param arabNumber арабское число
     * @return римское число
     */

    public static String ArabToRim(String arabNumber) {
        //заполняем синглетов мапами для перевода из араб в рим
        Initialization.initArabToRim();
        Map<String, String> tenMap = ConstantSingleton.instance(null, null).getTenMap();
        Map<String, String> unitMap = ConstantSingleton.instance(null, null).getUnitMap();
        // если однозначное число то берем без десятков
        if (arabNumber.length() == 1) {
            return unitMap.get(arabNumber);
        } else if (arabNumber.length() == 2) {
            //если число двузначное, то разбиваем на десятки и единицы и склеиваем
            String tenPart = arabNumber.substring(0, 1).concat("0");
            String unitPart = arabNumber.substring(1, 2);
            String result = tenMap.get(tenPart);
            return result.concat(unitMap.getOrDefault(unitPart, ""));
        } else {
            //если трехзначное, то
            return tenMap.get("100");
        }
    }

    /**
     * переводит римские числа в арабские
     *
     * @param rimNumber римское число
     * @return арабское число
     */
    public static String RimToArab(String rimNumber) {
        //заполняем синглетов мапами для перевода из рим в араб
        Initialization.initRimToArab();
        Map<String, String> tenMap = ConstantSingleton.instance(null, null).getTenMap();
        Map<String, String> unitMap = ConstantSingleton.instance(null, null).getUnitMap();
        String result = "";
        String tenPart = "";
        //ищем совпадения в части десятков и когда находим, то выпадаем из цикла
        for (int i = rimNumber.length(); i > 0; i--) {
            tenPart = rimNumber.substring(0, i);
            if (tenMap.containsKey(tenPart)) {
                result = result.concat(tenMap.get(tenPart));
                break;
            }
            // если не нашли совпадения по десяткам, т.е. число меньше  10,
            // то устанавливаем длину = 0
            tenPart = "";
        }
        //если длина десятков и сомого пришедшего числа не равны, то будем добавляеть еще единицы
        if (tenPart.length() != rimNumber.length() && tenPart.length() > 0) {
            //result == 20 --> 2
            result = result.substring(0, 1);
            // 2 + unitPart
            return result.concat(unitMap.get(rimNumber.substring(result.length())));
        } else {
            //если числа - десятки
            if (result.length() == 3 || result.length() == 2) {
                return result;
            } else {
                //для чисел < 10
                return result.concat(unitMap.getOrDefault(rimNumber.substring(result.length()), ""));
            }
        }
    }
}
