package edu.itstep.examination.singleton;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
/**
 * Хранит значения для перевода из римской системы счисления
 * в арабскую и наооборот
 */
public class ConstantSingleton {

    private static ConstantSingleton instance;
    private final Map<String, String> tenMap;
    private final Map<String, String> unitMap;

    private ConstantSingleton(Map<String, String> tenMap, Map<String, String> unitMap) {
        this.tenMap = tenMap;
        this.unitMap = unitMap;
    }

    public static ConstantSingleton instance(Map<String, String> tenMap, Map<String, String> unitMap) {
        if (instance == null) {
            instance = new ConstantSingleton(new HashMap<>(), new HashMap<>());
        }
        if (tenMap != null & unitMap != null) {
            instance = new ConstantSingleton(tenMap, unitMap);
        }
        return instance;
    }

}
