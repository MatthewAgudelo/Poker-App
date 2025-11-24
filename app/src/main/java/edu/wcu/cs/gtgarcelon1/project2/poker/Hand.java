package edu.wcu.cs.gtgarcelon1.project2.poker;

import java.util.Arrays;

/**
 * @author Grant Garcelon
 */
public class Hand {

    private Card[] hand;
    private WinHand handType;

    public static final int NUM_CARDS = 5;
    
    public Hand(int numCards) {
    	hand = new Card[numCards];
    }
    public Hand() {
    	this(NUM_CARDS);
    }
    //changes any card to the card that is passed as a param.
    public void setCard(int replaceIndex, Card newCard) {
    	this.hand[replaceIndex] = newCard;
    }

    public Card[] getCards() {
    	return hand;
	}

	public WinHand getWinType() {
		calcHandType();
		return this.handType;
	}


	private void calcHandType() {
		boolean flush = this.flush(),
				straight = this.straight();

		if (flush || straight) {
			if (flush) {
				if (this.royalFlush()) {
					this.handType = WinHand.RFLUSH;
				} else if (straight) { this.handType = WinHand.SFLUSH;
				} else { this.handType = WinHand.FLUSH; }
			} else {
				this.handType = WinHand.STRAIGHT;
			}
		} else {
			int numMatch = this.matchCounter();
			switch (numMatch) {
				case 7:
					this.handType = WinHand.PAIR;
					break;
				case 9:
					this.handType = WinHand.TWOPAIR;
					break;
				case 11:
					this.handType = WinHand.THREEKIND;
					break;
				case 13:
					this.handType = WinHand.FHOUSE;
					break;
				case 17:
					this.handType = WinHand.FOURKIND;
					break;
				default:
					this.handType = WinHand.HIGHCARD;
					break;
			}
		}
	}



    public boolean royalFlush() {
    	//flush has already been tested for
	    	boolean hasTen = false,
	    			hasJack = false,
	    			hasQueen = false,
	    			hasKing = false,
	    			hasAce = false;
	    	for (Card card : this.hand) {
	    		if (card.getFace() == Face.TEN) {
	    			hasTen = true;
	    		} else if (card.getFace() == Face.JACK) {
	    			hasJack = true;
	    		} else if (card.getFace() == Face.QUEEN) {
	    			hasQueen = true;
	    		} else if (card.getFace() == Face.KING) {
	    			hasKing = true;
	    		} else if (card.getFace() == Face.ACE) {
	    			hasAce = true;
	    		}
	    	}
	    	if (hasTen && hasJack && hasQueen && hasKing && hasAce) {
				return true;
	    	} else {
	    		return false;
	    	}
   	}
     
    
    public boolean straight() {//works!
    	boolean straight = true;
    	this.sort();
    	int lowestRank = this.hand[0].rank();
    	for (Card card : this.hand) {
    		if (card.rank() != lowestRank++) {
    			straight = false;
    		}
    	}
    	return straight;
    }
    
    public boolean flush() {//works!!
    	Suit handSuit = this.hand[0].getSuit();
    	for (Card card : this.hand) {
    		if (card.getSuit() != handSuit) {
    			return false;
    		}
    	}
    	return true;    		
    }
    
    public int matchCounter() {
    	int matchCount = 0;
    	for (Card card : this.hand) {
    		Face faceMatch = card.getFace();
    		for (Card testCard : this.hand) {
    			if (faceMatch == testCard.getFace()){
    				matchCount++;
    			}
    		}
    	}
    	return matchCount;
    }
    
    /**
     * This method will sort a hand into ascending order. Will only work in Java 8 or higher.
     * It makes the assumption that you have an array of N Cards named 'cards'; cards
     * is a field within this class.
     */
    public void sort() {
        Arrays.sort(hand, (Card u1, Card u2) -> u1.compareTo(u2));
    }
    
    public Card[] getHand() {
    	return hand;
	}
    

    public static void main(String[] args){
    	Hand hand = new Hand(5);
        hand.setCard(4, new Card(Face.FOUR, Suit.SPADES));
        hand.setCard(3, new Card(Face.FOUR, Suit.DIAMONDS));
        hand.setCard(2, new Card(Face.SIX, Suit.CLUBS));
        hand.setCard(1, new Card(Face.SIX, Suit.HEARTS));
        hand.setCard(0, new Card(Face.SEVEN, Suit.DIAMONDS));
        
        System.out.println(hand.getWinType());
    }
}