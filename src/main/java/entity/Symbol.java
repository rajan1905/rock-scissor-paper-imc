package entity;

public enum Symbol {
    FIST("ROCKS"),
    OPEN("PAPER"),
    FINGER_INDEX_MIDDLE("SCISSORS");

    public final String value;

    Symbol(String value){
        this.value = value;
    }
}
