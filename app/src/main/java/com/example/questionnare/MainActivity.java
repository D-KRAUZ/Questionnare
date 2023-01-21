package com.example.questionnare;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


String[] rjesenja = new String[]{"Zagreb","Beograd","Moskva"};
String[] Pitanja = new String[]{"Glavni Grad Srbije","Glavni Grad Rusije"};
int question_n0=1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tv1 = (TextView) findViewById(R.id.tv1);
        EditText et1 = (EditText) findViewById(R.id.et1);
        TextView bt1 = (Button) findViewById(R.id.bt1);



        bt1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (question_n0<3)
                {
                    if(checker_func(et1.getText().toString(),question_n0))
                    {
                        et1.setText("");
                        tv1.setText(Pitanja[question_n0-2]);
                        Toast.makeText(getApplicationContext(),"Tocno!",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Netocno!",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    tv1.setText("Bravo! Dosao si do kraja kviza.");
                    et1.setVisibility(View.INVISIBLE);
                    bt1.setVisibility(View.INVISIBLE);
                }

            }
        });
    }
    public boolean checker_func(String s, int i)
    {
        boolean p = false;
        int k=0;
        for (int ip=0;ip<rjesenja.length;ip++)
        {
            if (s.toCharArray()[ip] == rjesenja[question_n0-1].toCharArray()[ip])
            {
                k++;
                if (k==rjesenja.length)
                {
                    question_n0++;
                    p = true;

                }

            }
            else
            {
                p = false;
            }
        }
        return p;
    };
}