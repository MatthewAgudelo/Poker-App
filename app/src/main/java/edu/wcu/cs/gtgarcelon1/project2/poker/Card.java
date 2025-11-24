package edu.wcu.cs.gtgarcelon1.project2.poker;

/**
 * You must comment all fields and methods in this file.
 * @author William Kreahling
 */
public class Card {
    private Face face;//name of card(Face)
    private Suit suit;//suit of card

    public Card(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
    }
//returns name
    public Face getFace() {
        return face;
    }
//returns suit
    public Suit getSuit() {
        return suit;
    }
//returns rank
    public int rank() {
        return face.getRank();
    }
//returns value
    public int value() {
        return face.value();
    }

//formats a string to represent the card and returns it
    public String toString() {
        return String.format("%s_of_%s", face.toString(), suit.toString());
    }

    /**
     * Compare the ranks of two cards.
     * @return a value less than 0 if the rank of 'this' card is less than the one passed in, 0 if
     * the ranks of the cards are equal and a value greater than 0 if the rank of 'this' card is
     * greater than the rank of the one passed in.
     *
     * Note: This method works ONLY if another Card object is passed in as a parameter.
     */
    //compares the rank of a card against a card passed as a parameter
    public int compareTo(Object other) {
        return this.face.getRank() - ((Card)other).face.getRank();
    }

    public static void main(String args[]) {

        Card one = new Card(Face.QUEEN, Suit.HEARTS);
        Card two = new Card(Face.JACK, Suit.DIAMONDS);

        if (one.compareTo(two) < 0) {
            System.out.println(one + "\n\tis less than than\n" + two);
        } else if (one.compareTo(two) > 0) {
            System.out.println(one + "\n\tis greater than\n" + two);
        } else {
            System.out.println(one + "\nand\n" + two + "\nARE EQUAL");;
        }
    }
}