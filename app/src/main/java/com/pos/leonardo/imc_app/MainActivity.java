package com.pos.leonardo.imc_app;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
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

        final ConstraintLayout  _telaPrincpal = (ConstraintLayout)findViewById(R.id.telaPrincpal);

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
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                if(!_input_nome.getText().toString().trim().isEmpty()){
                    //formula IMC = peso ÷ altura^2
                    Double imc =  peso/Math.pow(altura, 2);
                    dialog.setVisibility(view.GONE);

                     String[] notificacao = checkImc(imc);

                     _textimc.setText("Maoiê "+_input_nome.getText().toString()+"! SEU IMC É: "+String.valueOf(Math.round(imc *100.0)/100.0)
                                                                                +"\n"+notificacao[0]);
                    _telaPrincpal.setBackgroundColor(Color.parseColor(String.valueOf(notificacao[1])));
                    _textimc.setVisibility(view.VISIBLE);

                }else {
                    Toast.makeText(MainActivity.this, "RG sem nome! OMG!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public String[] checkImc(Double imc){
            String peso = "";
            String corTela ="";
        if(imc <16){
             peso = "Baixo peso muito grave";
             corTela = "#1c1363";
        }
        else if(imc >= 16 && imc <= 16.99){
            peso = "Baixo peso grave";
            corTela = "#0156a6";
        }
        else if(imc >= 17 && imc <= 18.49){
            peso = "Baixo peso ";
            corTela = "#00b0f7";
        }
        else if(imc >= 18.50 && imc <= 24.99){
            peso = "Peso normal";
            corTela = "#00a64c";
        }
        else if(imc >= 25 && imc <= 29.99){
            peso = "Sobrepeso";
            corTela = "#fae501";
        }
        else if(imc >= 30.50 && imc <= 34.99){
            peso = "Obesidade grau I";
            corTela = "#ff9a03";
        }
        else if(imc >= 35 && imc <= 39.99){
            peso = "Obesidade grau II";
            corTela = "#cf4702";
        }
        else if(imc >= 40){
            peso = "Obesidade grau III (obesidade mórbida)";
            corTela = "#a00001";
        }
        return new String[]{peso, corTela};
    }
}

