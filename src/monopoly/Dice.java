package monopoly;

import java.util.Random;

// Class designed to replicate the behaviour of a pair of six sided dice. Checks included to ensure die are only read once per roll.
public class Dice {

    //Upper limit on individual die roll
    private int diceMax;

    // Individual and total die values
    private int diceVal1;
    private int diceVal2;
    private int diceTotal;

    // flags for if dice read
    private boolean read1;
    private boolean read2;

    // Instantiate dice with arbitrary number of sides with initial stored values of zero
    public Dice(){

        diceVal1 = 0;
        diceVal2 = 0;
        diceTotal = 0;
        diceMax = 6;
        read1 = false;
        read2 = false;
    }

    // Roll the dice
    public void roll(){

        // Roll both die and set values
        Random diceRoll = new Random();
        diceVal1 = diceRoll.nextInt(diceMax);
        diceVal2 = diceRoll.nextInt(diceMax);
        diceTotal = diceVal1 + diceVal2;

        // Dice are both set as unread
        read1 = false;
        read2 = false;
    }

    // methods for reading die individually
    public int readDie1(){

        read1 = true;
        return diceVal1;
    }

    public int readDie2(){

        read2 = true;
        return diceVal2;
    }

    // read dice together
    public int getDiceTotal() throws Exception {

        // Check if already read (die can only be read once)
        if (read1||read2){

           throw new Exception("One or more die have already been individually read.");

        }
        else{

            read1 = true;
            return diceTotal;
        }

    }

}
