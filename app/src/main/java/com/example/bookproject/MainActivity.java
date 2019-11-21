package com.example.bookproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    TextView soroborno,banjonborno,number,alphabet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final HashMap<String,String> sorobornolist=new HashMap<>();
        sorobornolist.put("অ","অজগর");
        sorobornolist.put("আ","আম");

        soroborno = findViewById(R.id.tvSorborno);
        banjonborno = findViewById(R.id.tvBanjon);
        number = findViewById(R.id.tvDigit);
        alphabet = findViewById(R.id.tvABC);

        soroborno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ShowData.class);
                i.putExtra("data",sorobornolist);
                startActivity(i);
            }
        });

    }
}
