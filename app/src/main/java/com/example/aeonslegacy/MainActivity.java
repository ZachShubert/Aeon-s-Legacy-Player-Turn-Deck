package com.example.aeonslegacy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Random;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    int turnNumber = 0;
    TextView Player;
    int[] turnOrder = new int[6];
    Button resetDeck;

    ImageView Misa;
    ImageView Zelda;
    ImageView Jadez;
    ImageView WILD;
    ImageView Nemesis1;
    ImageView Nemesis2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        for (int i = 0; i < 6; i++) {
            turnOrder[i] = i;
        }
        turnOrder = Randomize(turnOrder);


        Cards[] Deck = {
                new Cards("Misa", getResources().getColor(R.color.Yellow)),
                new Cards("Zelda", getResources().getColor(R.color.Blue)),
                new Cards("Jadez", getResources().getColor(R.color.Green)),
                new Cards("WILD", getResources().getColor(R.color.white)),
                new Cards("Nemesis", getResources().getColor(R.color.Red)),
                new Cards("Nemesis Assault", getResources().getColor(R.color.Orange)),
        };

        Misa = (ImageView) findViewById(R.id.check1);
        Zelda = (ImageView) findViewById(R.id.check2);
        Jadez = (ImageView) findViewById(R.id.check3);
        WILD = (ImageView) findViewById(R.id.check4);
        Nemesis1 = (ImageView) findViewById(R.id.check5);
        Nemesis2 = (ImageView) findViewById(R.id.check6);

        SetInvisible();

        resetDeck = (Button) findViewById(R.id.resetDeck);
        resetDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turnNumber = 0;
                turnOrder = Randomize((turnOrder));
                SetInvisible();
                Player.setBackgroundColor(0xFFFFFFFF);
                Player.setText("Deck Reset");
            }
        });

        Player = (TextView) findViewById(R.id.TextPlayer);
        Player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (turnNumber == 6) {
                    turnNumber = 0;
                    turnOrder = Randomize(turnOrder);
                    SetInvisible();
                }
                Player.setText(Deck[turnOrder[turnNumber]].getName());
                View back = MainActivity.this.getWindow().getDecorView();
                Player.setBackgroundColor(Deck[turnOrder[turnNumber]].getColor());
                switch (turnOrder[turnNumber]){
                    case 0:
                        Misa.setVisibility(View.VISIBLE);

                    break;
                    case 1:
                        Zelda.setVisibility(View.VISIBLE);

                        break;
                    case 2:
                        Jadez.setVisibility(View.VISIBLE);

                        break;
                    case 3:
                        WILD.setVisibility(View.VISIBLE);

                        break;
                    case 4:
                        Nemesis1.setVisibility(View.VISIBLE);

                        break;
                    case 5:
                        Nemesis2.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
                turnNumber++;
            }
        });
    }

    public int[] Randomize(int[] turnOrder) {
        for (int i = 0; i < turnOrder.length; i++) {
            //int randomIndexToSwap = new Random().nextInt(6);
            int randomIndexToSwap = 1;
            int temp = turnOrder[randomIndexToSwap];
            turnOrder[randomIndexToSwap] = turnOrder[i];
            turnOrder[i] = temp;
        }
        return turnOrder;
    }

    public  void SetInvisible() {
        Misa.setVisibility(View.INVISIBLE);
        Zelda.setVisibility(View.INVISIBLE);
        Jadez.setVisibility(View.INVISIBLE);
        WILD.setVisibility(View.INVISIBLE);
        Nemesis1.setVisibility(View.INVISIBLE);
        Nemesis2.setVisibility(View.INVISIBLE);
    }
}

