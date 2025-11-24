package edu.wcu.cs.gtgarcelon1.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import edu.wcu.cs.gtgarcelon1.project2.poker.Card;
import edu.wcu.cs.gtgarcelon1.project2.poker.Face;
import edu.wcu.cs.gtgarcelon1.project2.poker.Hand;
import edu.wcu.cs.gtgarcelon1.project2.poker.Suit;
import edu.wcu.cs.gtgarcelon1.project2.poker.WinHand;

/**
 * @author Matthew Agudelo
 */
public class Win extends AppCompatActivity {
    public String card_text;
    private static final int NUM_CARDS = 5;

    private ImageView[] cardViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        Bundle extras = getIntent().getExtras();
        String[] info = getResources().getStringArray(R.array.win_desc);
        card_text = extras.getString("text");
        TextView card_desc = this.findViewById(R.id.win_desc);
        TextView win_hand = this.findViewById(R.id.win_type);

        cardViews = new ImageView[NUM_CARDS];
        cardViews[0] = findViewById(R.id.cards1);
        cardViews[1] = findViewById(R.id.cards2);
        cardViews[2] = findViewById(R.id.cards3);
        cardViews[3] = findViewById(R.id.cards4);
        cardViews[4] = findViewById(R.id.cards5);

        if (extras != null) {
            /**
             * gets the text from array of values
             */
            win_hand.setText(card_text);
            WinHand[] hands = WinHand.values();
            for(int i = 0; i < hands.length; i++){
                if( hands[i].toString().equals(card_text)){
                    
                    card_desc.setText(info[i]);
                }
            }
            /**
             * sets the cards to the value of the text
             */
            Hand hand = new Hand();
            if (card_text.equals(WinHand.HIGHCARD.toString())) {
                hand.setCard(0, new Card(Face.ACE, Suit.DIAMONDS));
                hand.setCard(1, new Card(Face.NINE, Suit.SPADES));
                hand.setCard(2, new Card(Face.SEVEN, Suit.SPADES));
                hand.setCard(3, new Card(Face.FIVE, Suit.SPADES));
                hand.setCard(4, new Card(Face.THREE, Suit.DIAMONDS));
            } else if (card_text.equals(WinHand.PAIR.toString())) {
                hand.setCard(0, new Card(Face.KING, Suit.SPADES));
                hand.setCard(1, new Card(Face.KING, Suit.CLUBS));
                hand.setCard(2, new Card(Face.SIX, Suit.SPADES));
                hand.setCard(3, new Card(Face.THREE, Suit.SPADES));
                hand.setCard(4, new Card(Face.ACE, Suit.SPADES));
            } else if (card_text.equals(WinHand.TWOPAIR.toString())) {
                hand.setCard(0, new Card(Face.QUEEN, Suit.SPADES));
                hand.setCard(1, new Card(Face.QUEEN, Suit.HEARTS));
                hand.setCard(2, new Card(Face.FIVE, Suit.SPADES));
                hand.setCard(3, new Card(Face.FIVE, Suit.HEARTS));
                hand.setCard(4, new Card(Face.FOUR, Suit.DIAMONDS));
            } else if (card_text.equals(WinHand.THREEKIND.toString())) {
                hand.setCard(0, new Card(Face.ACE, Suit.DIAMONDS));
                hand.setCard(1, new Card(Face.ACE, Suit.CLUBS));
                hand.setCard(2, new Card(Face.ACE, Suit.HEARTS));
                hand.setCard(3, new Card(Face.DUECE, Suit.DIAMONDS));
                hand.setCard(4, new Card(Face.JACK, Suit.SPADES));
            } else if (card_text.equals(WinHand.STRAIGHT.toString())) {
                hand.setCard(0, new Card(Face.DUECE, Suit.SPADES));
                hand.setCard(1, new Card(Face.THREE, Suit.HEARTS));
                hand.setCard(2, new Card(Face.FOUR, Suit.CLUBS));
                hand.setCard(3, new Card(Face.FIVE, Suit.DIAMONDS));
                hand.setCard(4, new Card(Face.SIX, Suit.SPADES));
            } else if (card_text.equals(WinHand.FLUSH.toString())) {
                hand.setCard(0, new Card(Face.DUECE, Suit.SPADES));
                hand.setCard(1, new Card(Face.FOUR, Suit.SPADES));
                hand.setCard(2, new Card(Face.SIX, Suit.SPADES));
                hand.setCard(3, new Card(Face.EIGHT, Suit.SPADES));
                hand.setCard(4, new Card(Face.TEN, Suit.SPADES));
            } else if (card_text.equals(WinHand.FHOUSE.toString())) {
                hand.setCard(0, new Card(Face.ACE, Suit.SPADES));
                hand.setCard(1, new Card(Face.ACE, Suit.DIAMONDS));
                hand.setCard(2, new Card(Face.ACE, Suit.CLUBS));
                hand.setCard(3, new Card(Face.KING, Suit.SPADES));
                hand.setCard(4, new Card(Face.KING, Suit.HEARTS));
            } else if (card_text.equals(WinHand.FOURKIND.toString())) {
                hand.setCard(0, new Card(Face.ACE, Suit.SPADES));
                hand.setCard(1, new Card(Face.ACE, Suit.DIAMONDS));
                hand.setCard(2, new Card(Face.ACE, Suit.CLUBS));
                hand.setCard(3, new Card(Face.ACE, Suit.HEARTS));
                hand.setCard(4, new Card(Face.DUECE, Suit.SPADES));
            } else if (card_text.equals(WinHand.SFLUSH.toString())) {
                hand.setCard(0, new Card(Face.THREE, Suit.SPADES));
                hand.setCard(1, new Card(Face.FOUR, Suit.SPADES));
                hand.setCard(2, new Card(Face.FIVE, Suit.SPADES));
                hand.setCard(3, new Card(Face.SIX, Suit.SPADES));
                hand.setCard(4, new Card(Face.SEVEN, Suit.SPADES));
            } else if (card_text.equals(WinHand.RFLUSH.toString())) {
                hand.setCard(0, new Card(Face.TEN, Suit.SPADES));
                hand.setCard(1, new Card(Face.JACK, Suit.SPADES));
                hand.setCard(2, new Card(Face.QUEEN, Suit.SPADES));
                hand.setCard(3, new Card(Face.KING, Suit.SPADES));
                hand.setCard(4, new Card(Face.ACE, Suit.SPADES));
            }
            showCards(hand);
        }
    }

    /**
     * sets the card to the correct value
     * @param hand a refernce to the hand in the Hand.java
     */
    private void showCards(Hand hand) {

        Card[] cards = hand.getCards();
        for (int i = 0; i < cards.length; i++) {
            cardViews[i].setImageDrawable(CardURIs.getCardDrawable(this, cards[i]));
        }
    }
}



