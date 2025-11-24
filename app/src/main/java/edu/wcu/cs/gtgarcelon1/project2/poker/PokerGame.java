package edu.wcu.cs.gtgarcelon1.project2.poker;

import static edu.wcu.cs.gtgarcelon1.project2.poker.Hand.NUM_CARDS;

import java.util.Random;
//import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Grant Garcelon
 */
public class PokerGame {

	private Card[] deck;
	private int deckSize;
	private int topCardOnDeck;
	private Hand hand;


	public PokerGame() {

	}

	private void generateDeck() {
		topCardOnDeck = 0;
		Suit[] suits = Suit.values();
		Face[] faces = Face.values();
		deckSize = suits.length * faces.length;
		deck = new Card[deckSize];
		int deckIndex = 0;
		for (Suit s : suits) {
			for (Face f : faces) {
				deck[deckIndex++] = new Card(f, s);
			}
		}
		this.shuffle(this.deck);
	}

	public void shuffle(Card[] cards) {
		int n = cards.length;
		Random r = new Random();
		for (int i = n - 1; i > 0; i--) {
			int j = r.nextInt(i + 1);

			Card temp = cards[i];
			cards[i] = cards[j];
			cards[j] = temp;
		}

	}

	public void deal() {
		this.hand = new Hand();
		if (deckSize - topCardOnDeck < NUM_CARDS) {
			generateDeck();
		}
		for (int i = 0; i < NUM_CARDS; i++) {
			hand.setCard(i, getTopCard());
		}
	}

	public Card getTopCard() {
		return deck[topCardOnDeck++];
	}

	public Hand getHand() {
		return hand;
	}

	public void swapCard(int i) {
		if (0 <= i && i < deckSize) {
			hand.setCard(i, getTopCard());
		}
	}

	public void endHand() {
		hand = null;
	}
}
	
