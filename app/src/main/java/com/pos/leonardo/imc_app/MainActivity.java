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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText _input_nome  = (EditText) findViewById(R.id.input_nome);
        final LinearLayout dialog = (LinearLayout)findViewById(R.id.dialognome);
        Button   btok = (Button) findViewById(R.id.btok);

        // se esppera dialog.setVisibility(view.VISIBLE); ao clicar em cálcular

        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               dialog.setVisibility(view.GONE);
               _input_nome.getText().toString();
            }
        });
    }
}
