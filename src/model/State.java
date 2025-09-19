package model;

public enum State {
    INI(false),
    VO(true), //ValueOne
    EWT(true), //EndWIthTwo
    NM(true), //NoMore
    VF(true), //ValueFive
    VS(true), //ValueSix
    OX(true), //OneX
    TX(true), //TwoX
    JOF(true), //JustOneOrFive
    ERROR(false)
    ;

    private final boolean acceptationState;

    State(boolean acceptationState) {
        this.acceptationState = acceptationState;
    }

    public boolean isAcceptationState() {
        return acceptationState;
    }

    public static State getInitialState() {
        return INI;
    }

    public State nextState(char romanNumber){
        return switch (this){
            case INI -> nextStateFromINI(romanNumber);
            case VO -> nextStateFromVO(romanNumber);
            case EWT -> nextStateFromEWT(romanNumber);
            case VF -> nextStateFromVF(romanNumber);
            case VS -> nextStateFromVS(romanNumber);
            case OX -> nextStateFromOX(romanNumber);
            case TX -> nextStateFromTX(romanNumber);
            case JOF -> nextStateFromJOF(romanNumber);
            default -> ERROR;
        };
    }

    private State nextStateFromINI(char romanNumber){
        return switch (romanNumber) {
            case 'I' -> VO;
            case 'V' -> VF;
            case 'X' -> OX;
            case 'L' -> NM;
            default -> ERROR;
        };
    }

    private State nextStateFromVO(char romanNumber){
        return switch (romanNumber) {
            case 'I' -> EWT;
            case 'V', 'X' -> NM;
            default -> ERROR;
        };
    }

    private State nextStateFromEWT(char romanNumber){
        return (romanNumber == 'I')? NM : ERROR;
    }

    private State nextStateFromVF(char romanNumber){
        return (romanNumber == 'I')? VS : ERROR;
    }

    private State nextStateFromVS(char romanNumber){
        return (romanNumber == 'I')? EWT : ERROR;
    }

    private State nextStateFromOX(char romanNumber){
        return switch (romanNumber){
            case 'I' -> VO;
            case 'V' -> VF;
            case 'X' -> TX;
            case 'L' -> JOF;
            default -> ERROR;
        };
    }

    private State nextStateFromTX(char romanNumber){
        return switch (romanNumber){
            case 'I' -> VO;
            case 'V' -> VF;
            case 'X' -> JOF;
            default -> ERROR;
        };
    }

    private State nextStateFromJOF(char romanNumber){
        return switch (romanNumber){
            case 'I' -> VO;
            case 'V' -> VF;
            default -> ERROR;
        };
    }
}
