package com.pos.leonardo.imc_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Double altura;
    private Double peso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText _peso    = (EditText) findViewById(R.id.peso);
        final EditText _altura  = (EditText) findViewById(R.id.altura);
        final TextView _textimc  = (TextView) findViewById(R.id.textimc);
        Button btcalcular = (Button) findViewById(R.id.btcalcular);

        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!_peso.getText().toString().trim().isEmpty() && !_altura.getText().toString().trim().isEmpty()) {

                    altura = Double.parseDouble(_altura.getText().toString());
                    peso = Double.parseDouble(_peso.getText().toString());

                    //formula IMC = peso ÷ altura^2
                    Double imc = peso / Math.pow(altura, 2);

                    _textimc.setText(String.valueOf(imc));

                }
            }
        });
    }
}
