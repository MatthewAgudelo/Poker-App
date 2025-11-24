package edu.wcu.cs.gtgarcelon1.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import edu.wcu.cs.gtgarcelon1.project2.poker.WinHand;

/**
 * @author Matthew Agudelo
 */
public class WinList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_list);

        /**
         * gets the name of the card from the array
         */
        WinHand[] hands = WinHand.values();
        String[] handStrings = new String[hands.length];
        for (int i = 1; i < hands.length; i++) {
            handStrings[i] = hands[i].toString();
        }

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);//Performance boost.
        this.context = this;
        myAdapter = new MyAdapter(handStrings, this, context);
        recyclerView.setAdapter(myAdapter);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}