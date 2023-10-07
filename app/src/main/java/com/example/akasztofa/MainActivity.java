package com.example.akasztofa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

private Button buttonPlus;
private Button buttonMinus;
private TextView textViewGuess;
private TextView textViewCorrect;
private ImageView imageViewFail;
private int index;
private String helyesSzo;
private int betuIndex;
private int helyesSzoHossz;
private String megoldas;
private List<String> betuk;
private String charSelected;
private Button buttonTipp;
private StringBuilder StringBuilder;
private int fail;
private AlertDialog.Builder alertGameOver;
private String StringB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        szo();
        helyes();


        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(betuIndex == 25)
                {
                    betuIndex = 0;
                }
                else
                {
                    betuIndex = betuIndex +1;
                }
                charSelected = betuk.get(betuIndex);
                textViewGuess.setText(charSelected);
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(betuIndex == 0)
                {
                    betuIndex = 25;
                }
                else
                {
                    betuIndex = betuIndex -1;
                }
                charSelected = betuk.get(betuIndex);
                textViewGuess.setText(charSelected);
            }
        });


        buttonTipp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tippel();
            }
        });


    }

    public void init()
    {
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        textViewCorrect = findViewById(R.id.textViewCorrect);
        textViewGuess = findViewById(R.id.textViewGuess);
        imageViewFail = findViewById(R.id.imageViewFail);
        buttonTipp = findViewById(R.id.buttonTipp);
        index = 0;
        betuIndex = 0;
        fail = 0;
        StringB = "";
        megoldas = "";
        betuk = Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z");
        textViewGuess.setText(betuk.get(0));
        charSelected = "a";
        alertGameOver = new AlertDialog.Builder(MainActivity.this);
        alertGameOver.setTitle("Játék Vége")
                .setMessage("Újra akarod kezdeni?")
                .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        newGame();
                    }
                })
                .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setCancelable(false)
                .create();

    }


    public void szo()
    {
        ArrayList<String> szavak = new ArrayList<String>();
        szavak.add("kutya");
        szavak.add("macska");
        szavak.add("kapu");
        szavak.add("akaszt");
        szavak.add("gomb");
        szavak.add("megold");
        szavak.add("zebra");
        szavak.add("android");
        szavak.add("pontos");
        szavak.add("szavak");

        Random random = new Random();
        index = random.nextInt(10);

        helyesSzo = szavak.get(index);
    }

    public void helyes()
    {
        helyesSzoHossz = helyesSzo.length();

        for(int i = 0; i < helyesSzoHossz; i++)
        {
            megoldas = megoldas + "_";
        }
        StringBuilder = new StringBuilder(megoldas);
        textViewCorrect.setText(megoldas);
    }

    public void tippel()
    {
        boolean contains = false;

        for(int i = 0; i < helyesSzoHossz; i++)
        {
            if (charSelected.charAt(0) == helyesSzo.charAt(i))
            {
                StringBuilder.setCharAt(i, helyesSzo.charAt(i));
                contains = true;
            }
        }

        if (contains)
        {
            textViewCorrect.setText(StringBuilder);
            String StringB = StringBuilder.toString();
            if (!StringB.contains("_"))
            {
                alertGameOver.setTitle("Gratulálok, győztél!").create().show();
            }
        }
        else
        {
            fail++;
            switch (fail)
            {
                case 1:
                    imageViewFail.setImageResource(R.drawable.akasztofa01);
                    break;
                case 2:
                    imageViewFail.setImageResource(R.drawable.akasztofa02);
                    break;
                case 3:
                    imageViewFail.setImageResource(R.drawable.akasztofa03);
                    break;
                case 4:
                    imageViewFail.setImageResource(R.drawable.akasztofa04);
                    break;
                case 5:
                    imageViewFail.setImageResource(R.drawable.akasztofa05);
                    break;
                case 6:
                    imageViewFail.setImageResource(R.drawable.akasztofa06);
                    break;
                case 7:
                    imageViewFail.setImageResource(R.drawable.akasztofa07);
                    break;
                case 8:
                    imageViewFail.setImageResource(R.drawable.akasztofa08);
                    break;
                case 9:
                    imageViewFail.setImageResource(R.drawable.akasztofa09);
                    break;
                case 10:
                    imageViewFail.setImageResource(R.drawable.akasztofa10);
                    break;
                case 11:
                    imageViewFail.setImageResource(R.drawable.akasztofa11);
                    break;
                case 12:
                    imageViewFail.setImageResource(R.drawable.akasztofa12);
                    break;
                case 13:
                    imageViewFail.setImageResource(R.drawable.akasztofa13);
                    alertGameOver.show();
                    break;
            }
        }
    }

    private void newGame()
    {
        index = 0;
        betuIndex = 0;
        fail = 0;
        StringB = "";
        megoldas = "";
        betuk = Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z");
        textViewGuess.setText(betuk.get(0));
        charSelected = "a";
        szo();
        helyes();
        imageViewFail.setImageResource(R.drawable.akasztofa00);
        alertGameOver.setTitle("Játék vége").create();
    }

}