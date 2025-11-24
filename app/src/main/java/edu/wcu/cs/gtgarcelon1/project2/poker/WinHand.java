package edu.wcu.cs.gtgarcelon1.project2.poker;

/**
 * @author Andrew Scott
 * @Version Spring 2021
 * 
 * This represents the win hands in a game of poker.
 */
public enum WinHand {
    INVALID("ERROR!!!", -1),
    HIGHCARD("High card", 0),         //The best card in your hand (if no other wins detected)
    PAIR("Pair", 5),                  //A pair of cards of the same rank.
    TWOPAIR("Two pair", 10),           //Two pairs of cards of the same rankin the same hand
    THREEKIND("Three of a kind", 20),  //Any 3 cards the same
    STRAIGHT("Straight", 25),         //Cards of any suit running in sequence
    FLUSH("Flush", 30),	              //All cards of the same suite.
    FHOUSE("Full house", 50),         //Two of one kind three of another
    FOURKIND("Four of a kind", 100),   //Four cards of the same rank
    SFLUSH("Straigh Flush", 250),      //Cards of the same suit running in sequence
    RFLUSH("Royal Flush", 1000);

	/**The name of the win hand**/
    private String name;
    private int value;

    /**Construct a WinHand enumeration element.
     * @param name The name of the win hand.
     */
    private WinHand(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Get the name of the win hand.
     * @return The name as words.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get a textual representation of this WinHand.
     * @return The WinHand name as a String.
     */
    public String toString() {

        return this.getName() +" - "+ getValueString();
    }

    public int getValue(){
        return this.value;
    }

    public String getValueString() {
        return "$" + this.value;
    }
}