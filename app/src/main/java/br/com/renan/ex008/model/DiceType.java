package br.com.renan.ex008.model;

/*
*@author: renan santos carvalho
*/
public enum DiceType {
    D4("D4", 4),
    D6("D6", 6),
    D8("D8", 8),
    D10("D10", 10),
    D12("D12", 12),
    D20("D20", 20),
    D100("D100", 100);

    private final String description;
    private final int value;

    DiceType(String description, int value) {
        this.description = description;
        this.value = value;
    }

    public static DiceType getDiceType(int value) throws Exception {
        for(DiceType d : DiceType.values()) {
            if(d.getValue() == value) {
                return d;
            }
        }
        throw new Exception("Invalid dice type value " + value);
    }

    public String getDescription() {
        return this.description;
    }

    public int getValue() {
        return this.value;
    }
}
