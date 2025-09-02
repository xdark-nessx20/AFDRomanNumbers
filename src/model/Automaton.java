package model;

import static model.Language.ROMAN_NUMBERS;

public class Automaton {
    private State currentState;

    public Automaton() {
        this.currentState = State.INI;
    }

    public String verify(String number){
        number = number.trim().replace(" ", "").toUpperCase();
        int sum = 0;

        try {
            for(int i = 0; i < number.length(); i++){
                char c = number.charAt(i);
                currentState = currentState.nextState(c);

                if(currentState == State.ERROR) throw new Exception("Invalid string at char: " + c + ", number " + (++i));

                sum += processValue(number, c, i);
            }
            return "Valid string. Total value: " + sum;
        } catch(Exception e){
            return e.getMessage();
        }
        finally{
            currentState = State.getInitialState();
        }
    }

    private int processValue(String num, char c, int idx){
        int currentValue = ROMAN_NUMBERS.get(c);
        if(idx + 1 >= num.length()) return currentValue;

        char nextC = num.charAt(idx+1);
        return switch(c){
            case 'I' -> (nextC == 'V' || nextC == 'X')? -currentValue:currentValue;
            case 'X' -> (nextC == 'L')? -currentValue:currentValue;
            default -> currentValue;
        };
    }
}
