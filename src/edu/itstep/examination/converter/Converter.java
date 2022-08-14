package edu.itstep.examination.converter;

import edu.itstep.examination.init.Initialization;
import edu.itstep.examination.singleton.ConstantSingleton;

import java.util.Map;

public class Converter {

    public static String ArabToRim(String arabNumber) {
        Initialization.initArabToRim();
        Map<String, String> tenMap = ConstantSingleton.instance(null, null).getTenMap();
        Map<String, String> unitMap = ConstantSingleton.instance(null, null).getUnitMap();
        if (arabNumber.length() == 1) {
            return unitMap.get(arabNumber);
        } else if (arabNumber.length() == 2) {
            String tenPart = arabNumber.substring(0, 1).concat("0");
            String unitPart = arabNumber.substring(1, 2);
            String result = tenMap.get(tenPart);
            return result.concat(unitMap.getOrDefault(unitPart, ""));
        } else {
            return tenMap.get("100");
        }
    }

    public static String RimToArab(String rimNumber) {
        Initialization.initRimToArab();
        Map<String, String> tenMap = ConstantSingleton.instance(null, null).getTenMap();
        Map<String, String> unitMap = ConstantSingleton.instance(null, null).getUnitMap();
        String result = "";
        String tenPart = "";
        for (int i = rimNumber.length(); i > 0; i--) {
            tenPart = rimNumber.substring(0, i);
            if (tenMap.containsKey(tenPart)) {
                result = result.concat(tenMap.get(tenPart));
                break;
            }
            tenPart = "";
        }
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
