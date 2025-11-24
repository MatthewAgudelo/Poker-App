package edu.wcu.cs.gtgarcelon1.project2;

import android.content.Context;
import android.graphics.drawable.Drawable;

import edu.wcu.cs.gtgarcelon1.project2.poker.Card;

/**
 * @author Grant Garcelon
 * This file will get drawables from a card
 */
public class CardURIs { ;

    /**
     * Given a context and a card return the drawable for that card
     * @param context the calling context
     * @param card the card to get
     * @return the drawable of that card
     */
    public static Drawable getCardDrawable(Context context, Card card) {
        int imageResource = context.getResources().getIdentifier("@drawable/" + card.toString(), null, context.getPackageName());

        return context.getResources().getDrawable(imageResource);
    }
}
