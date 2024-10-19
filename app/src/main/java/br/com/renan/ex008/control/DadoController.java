package br.com.renan.ex008.control;

import br.com.renan.ex008.model.Dado;
import br.com.renan.ex008.model.DiceType;

/*
*@author: renan santos carvalho
*/
public class DadoController {
    private DiceType diceType = DiceType.D6;
    private int numberOfDice  = 1;


    public DadoController(int diceValue, int numberOfDice) {
        setNumberOfDice(numberOfDice);
        setDiceType(diceValue);
    }

    public DadoController setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
        return this;
    }

    public DadoController setDiceType(int diceValue) {
        try {
            this.diceType = DiceType.getDiceType(diceValue);
        } catch (Exception e) {
            this.diceType = DiceType.D6;
        }
        return this;
    }

    public int[] roll() {
        int[] resultArray = new int[numberOfDice];
        Dado[] dados = getDados();
        int c = 0;

        for (Dado d : dados) {
            resultArray[c++] = d.roll();
        }

        return resultArray;
    }

    private Dado[] getDados() {
        Dado[] dados = new Dado[numberOfDice];
        for(int i = 0; i < numberOfDice; i++) {
            dados[i] = new Dado(diceType);
        }
        return dados;
    }

}
