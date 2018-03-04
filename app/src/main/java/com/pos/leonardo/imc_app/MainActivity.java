package com.pos.leonardo.imc_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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
        final EditText _input_nome  = (EditText) findViewById(R.id.input_nome);
        final TextView _textimc  = (TextView) findViewById(R.id.textimc);
        final LinearLayout dialog = (LinearLayout)findViewById(R.id.dialognome);
        Button   btcalcular = (Button) findViewById(R.id.btcalcular);
        Button   btok = (Button) findViewById(R.id.btok);


        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!_peso.getText().toString().trim().isEmpty() && !_altura.getText().toString().trim().isEmpty()){

                    altura = Double.parseDouble(_altura.getText().toString());
                    peso   = Double.parseDouble(_peso.getText().toString());
                    if (peso>0 && altura >0){
                        dialog.setVisibility(view.VISIBLE);
                    }else {
                        Toast.makeText(MainActivity.this, "" +
                                "Uhh.. esses dados não parecem corretos.", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Relaxa! isso  vai ficar só fica entre nós.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!_input_nome.getText().toString().trim().isEmpty()){
                    //formula IMC = peso ÷ altura^2
                    Double imc =  peso/Math.pow(altura, 2);
                    dialog.setVisibility(view.GONE);

                    _textimc.setText("Olá "+_input_nome.getText().toString()+" SEU IMC É: "+String.valueOf(imc));
                    _textimc.setVisibility(view.VISIBLE);
                }else {
                    Toast.makeText(MainActivity.this, "RG sem nome! OMG!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
