package edu.wcu.cs.gtgarcelon1.project2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import edu.wcu.cs.gtgarcelon1.project2.poker.WinHand;

/**
 * @author Matthew Agudelo
 * This is the file that sets and recycles text for the various screens
 * and makes them clickable
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private String[] data;
    private Context context;

    private AppCompatActivity parent;

    public MyAdapter(String[] data, AppCompatActivity parent, Context context) {
        this.data = data;
        this.parent = parent;
        this .context = context;

    }


    @NonNull
    @Override
    /**
     * gets the context from holder_layout
     */
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder((ViewGroup)
            LayoutInflater.from(
                parent.getContext()).inflate(R.layout.holder_layout, parent, false
            )
        );
    }

    @Override
    /**
     * sets the texts for the recycler view
     * @params  holder the holder is that the text
     * @params position the position of that view
     */
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    /**
     * the class that extends the recycler viewer and impliments onClick
     */
    public class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        public TextView tv;

        /**
         * sets the recycler view to show the possible hand combos.
         * also set the item to be clickable.
         * @param itemView the item to be to
         */
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ViewGroup group = (ViewGroup) itemView;
            tv = group.findViewById(R.id.holder_tv);
            tv.setOnClickListener(this);
        }

        /**
         * When the text view is clicked this method is called and passes the intent to the
         * Win.class
         * @param v the view to be clicked
         */
        public void onClick(View v) {
            Intent intent = new Intent(context, Win.class);
            TextView viewer = v.findViewById(R.id.holder_tv);
             String text =  viewer.getText().toString();
            intent.putExtra("text", text);
            context.startActivity(intent);

            //extra making sure it could work
            /*TextView tv = v.findViewById(R.id.holder_tv);
            Toast.makeText(
                parent.getApplicationContext(),
                tv.getText(),
                Toast.LEN*/

        }
    }
}

