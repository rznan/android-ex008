package br.com.renan.ex008.model;

/*
*@author: renan santos carvalho
*/
public class Dado {
    private final DiceType type;
    private int lastRoll;

    public Dado(DiceType type) {
        this.type = type;
        this.lastRoll = roll();
    }

    public int roll() {
        this.lastRoll = (int) (Math.random() * type.getValue()) + 1;
        return lastRoll;
    }

    public int getLastRoll() {
        return this.lastRoll;
    }
}
