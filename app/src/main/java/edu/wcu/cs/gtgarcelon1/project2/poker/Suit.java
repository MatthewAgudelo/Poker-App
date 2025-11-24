package edu.wcu.cs.gtgarcelon1.project2.poker;

/**
 * @author Andrew Scott
 * @version Spring 2021
 * 
 * This enumeration represents a face of a card for which 
 * there are four: Spades, Hearts, Clubs and Diamonds.
 */
public enum Suit {
    SPADES("spades"),
    HEARTS("hearts"),
    CLUBS("clubs"),
    DIAMONDS("diamonds");

	/**The name of this suit as words**/
    private String name;

    /**Constructs a suit with a name
     * @param name The name of the suit as text.
     */
    private Suit(String name) {
        this.name = name; 
    }

    /**
     * Get the name of the suit.
     * @return The name of the suit as a String.
     */
    public String getName() {
        return name;
    }

    /**
     * Return a textual representation of this suit.
     * @return A string containing the suit name,
     */
    public String toString() {
        return this.getName();
    }
}