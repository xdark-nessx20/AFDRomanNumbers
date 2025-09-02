package model;

public enum State {
    INI(false),
    VO(true),
    EWT(true),
    NM(true),
    VF(true),
    VS(true),
    OX(true),
    TX(true),
    JOF(true),
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
            case VO -> nextStateFromVU(romanNumber);
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

    private State nextStateFromVU(char romanNumber){
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
