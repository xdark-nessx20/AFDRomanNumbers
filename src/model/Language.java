package model;

import java.util.HashMap;
import java.util.Map;

public class Language {
    public static final Map<Character, Integer> ROMAN_NUMBERS = new HashMap<>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
    }};
}
