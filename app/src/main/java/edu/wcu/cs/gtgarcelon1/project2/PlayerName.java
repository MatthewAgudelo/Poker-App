package edu.wcu.cs.gtgarcelon1.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author Matthew Agudelo
 */
public class PlayerName extends AppCompatActivity implements View.OnClickListener {

    private EditText nameInput;
    private Button setBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name);

        nameInput = findViewById(R.id.edit_player_name);
        setBtn = findViewById(R.id.set_name_btn);

        setBtn.setOnClickListener(this);

    }


    /**
     * When the go button is clicked make taost and set player name in Game.java
     * @param view the view that is used to check if the butoon was clicked
     */
    @Override
    public void onClick(View view) {
        String name = nameInput.getText().toString();
        String toastText = "Unknown Action";
        if (view == setBtn) {
            if (!name.isEmpty()) {
                PokerApp app = (PokerApp) getApplication();
                app.setPlayerName(name);
                toastText = "Hello " + app.getPlayerName();
                finish();
            } else {
                toastText = "Name cannot be empty";
            }

        }
        Toast.makeText(
                getApplicationContext(),
                toastText,
                Toast.LENGTH_SHORT
        ).show();

    }
}