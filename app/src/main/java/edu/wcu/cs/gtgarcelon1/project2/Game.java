package edu.wcu.cs.gtgarcelon1.project2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import edu.wcu.cs.gtgarcelon1.project2.poker.*;

/**
 * @author Grant Garcelon
 */
public class Game extends AppCompatActivity implements View.OnClickListener{
    /** Text views */
    private TextView gamesPlayed;
    private TextView bank;
    private TextView playerName;

    /** Image and button arrays */
    private ImageView[] cardViews;
    private Button[] throwHoldBtns;

    /** The application class */
    private PokerApp app;

    /** The number of cards in a hand */
    private static final int NUM_CARDS = 5;

    /** main buttons */
    private Button menuBtn;
    private Button dealBtn;
    private Button winsBtn;

    /** OnClick listeners for deal */
    private View.OnClickListener startHand;
    private View.OnClickListener finishHand;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        app = (PokerApp) getApplication();

        gamesPlayed = findViewById(R.id.hands_played);
        bank = findViewById(R.id.bank);
        playerName = findViewById(R.id.handName);

        cardViews = new ImageView[NUM_CARDS];
        cardViews[0] = findViewById(R.id.card1);
        cardViews[1] = findViewById(R.id.card2);
        cardViews[2] = findViewById(R.id.card3);
        cardViews[3] = findViewById(R.id.card4);
        cardViews[4] = findViewById(R.id.card5);


        updateBanner();

        menuBtn = findViewById(R.id.menu_btn);
        dealBtn = findViewById(R.id.deal_btn);
        winsBtn = findViewById(R.id.wins_btn);
        menuBtn.setOnClickListener(this);
        winsBtn.setOnClickListener(this);

        startHand = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == dealBtn) {
                    playHand();
                }
            }
        };
        finishHand = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == dealBtn) {
                    finishHand();
                }
            }
        };

        if (app.getDealt()) {
            showCards();
            dealBtn.setOnClickListener(finishHand);
        } else {
            hideCards();
            dealBtn.setOnClickListener(startHand);
        }

        initBtns();
    }


    /**
     * Resets the text for the textViews in the banner
     */
    private void updateBanner() {
        gamesPlayed.setText(getText(R.string.hands_played) + " " + String.valueOf(this.app.getGamesPlayed()));
        bank.setText(getText(R.string.bank) + String.valueOf(this.app.getPlayerBalance()));
        playerName.setText(String.valueOf(this.app.getPlayerName()) + getText(R.string.player_hand));
    }

    /**
     * initializes the buttons that throw and hold cards
     */
    private void initBtns() {
        throwHoldBtns = new Button[NUM_CARDS];
        throwHoldBtns[0] = findViewById(R.id.hold_btn0);
        throwHoldBtns[1] = findViewById(R.id.hold_btn1);
        throwHoldBtns[2] = findViewById(R.id.hold_btn2);
        throwHoldBtns[3] = findViewById(R.id.hold_btn3);
        throwHoldBtns[4] = findViewById(R.id.hold_btn4);

        enableButtons(app.getDealt());
    }

    /**
     * enables or disables the throw and hold buttons
     * @param enable to enable or disable
     */
    private void enableButtons(boolean enable) {
        for (Button button : throwHoldBtns) {
            if (enable) {
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        for (Button button : throwHoldBtns) {
                            if (button == view) {
                                button.setText(
                                    button.getText() == getText(R.string.hold_card) ?
                                    R.string.throw_card :
                                    R.string.hold_card
                                );
                            }
                        }
                    }

                });
            } else {
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
                button.setText(R.string.hold_card);
            }
        }
    }

    /**
     * The click listener for the menu and wins buttons
     * @param view
     */
    @Override
    public void onClick(View view) {

        if (view == menuBtn) {
            finish();
        } else if (view == winsBtn) {
            Intent intent = new Intent(this, WinList.class);
            startActivity(intent);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Unknown Action",
                    Toast.LENGTH_SHORT
            ).show();
        }

    }

    /**
     * this is called when the deal button is initally clicked
     */
    private void playHand() {
        deal();

        dealBtn.setOnClickListener(finishHand);
        dealBtn.setText(R.string.deal_btn);
    }

    /**
     * swaps the requested cards
     */
    private void doSwaps() {
        boolean[] swaps = getSwaps();
        for (int i = 0; i < swaps.length; i++) {
            if (swaps[i]) {
                app.getGame().swapCard(i);
            }
        }
    }

    /**
     * gets a boolean array for which cards to swap
     * @return
     */
    private boolean[] getSwaps() {
        boolean[] swaps = new boolean[throwHoldBtns.length];
        for (int i = 0; i < throwHoldBtns.length; i++) {
            swaps[i] = throwHoldBtns[i].getText().equals(getResources().getText(R.string.throw_card));
        }
        return swaps;
    }

    /**
     * deals a new hand
     */
    private void deal() {
        app.getGame().deal();
        showCards();
        app.setDealt(true);
        enableButtons(true);
    }

    /**
     * updates the cards that are being displayed based on which cards are in the hand
     */
    private void showCards() {
        Card[] cards = app.getGame().getHand().getCards();
        for (int i = 0; i < cards.length; i++) {
            cardViews[i].setImageDrawable(CardURIs.getCardDrawable(this, cards[i]));
        }
    }

    /**
     * turns all cards face down
     */
    private void hideCards() {
        for (int i = 0; i < cardViews.length; i++) {
            cardViews[i].setImageDrawable(getResources().getDrawable(R.drawable.back));
        }
    }

    /**
     * gets the game ready for the next hand
     */
    private void finishHand() {
        dealBtn.setOnClickListener(startHand);
        doSwaps();
        app.setDealt(false);
        showCards();
        WinHand winHand = app.getGame().getHand().getWinType();
        dealBtn.setText(R.string.new_hand);
        showWin(winHand);
        updateApp(winHand);
        enableButtons(false);
    }

    /**
     * Modifies the fields of the application class based on the result of this game.
     * @param win
     */
    private void updateApp(WinHand win) {
        app.getGame().endHand();
        app.incrementGamesPlayed();
        app.increaseBalence(win.getValue());
        updateBanner();
    }

    /**
     * shows a popup dialog showing the result of the hand
     * @param win
     */
    private void showWin(WinHand win) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(win.toString()).setTitle(R.string.result_title);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}