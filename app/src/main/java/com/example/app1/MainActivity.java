package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcular(View view){
        EditText edtPeso = (EditText) findViewById(R.id.editTextTextPeso);
        EditText edtSexo = (EditText) findViewById(R.id.editTextSexo);
        EditText edtCopos = (EditText) findViewById(R.id.editTextCopo);
        EditText edtjejum = (EditText) findViewById(R.id.editTextJejum);

        Intent it = new Intent("Bafometro");

        it.putExtra("peso", Double.parseDouble(edtPeso.getText().toString()));
        it.putExtra("sexo", edtSexo.getText().toString());
        it.putExtra("copos", Integer.parseInt(edtCopos.getText().toString()));
        it.putExtra("jejum", edtjejum.getText().toString());

        startActivityForResult(it, 7);

    }

    @Override
    protected void onActivityResult(int codReq, int CodRes, Intent it) {
        super.onActivityResult(codReq, CodRes, it);

        if( it ==    null){
            Toast.makeText(this, "NENHUM VALOR", Toast.LENGTH_LONG).show();
            return;
        }
        else{
            double ta = it.getDoubleExtra("taxa", 0);
            String c = it.getStringExtra("c");

            Toast.makeText(this, "TAxa de Alcoolemia: "+ ta + "\nClassificação: " + c, Toast.LENGTH_LONG).show();
        }
    }
}