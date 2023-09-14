package com.example.myoperaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtn1,txtn2;
    Spinner cbooperacion;
    Button btncalcular;
    TextView lblresultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtn1 = (EditText)findViewById(R.id.txtn1);
        txtn2 = (EditText)findViewById(R.id.txtn2);
        cbooperacion = (Spinner) findViewById(R.id.cbooperacion);
        btncalcular = (Button)findViewById(R.id.btncalcular);
        lblresultado = (TextView)findViewById(R.id.lblresultado);
        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(txtn1.getText().toString());
                int n2 = Integer.parseInt(txtn2.getText().toString());
                String operacion = cbooperacion.getSelectedItem().toString();
                float resultado=0;// = (operacion=="Sumar")?(n1+n2):((operacion=="Restar")?(n1-n2):((operacion=="Multiplicar")?(n1*n2):n1/n2));



                switch (operacion){
                    case "Sumar": resultado = n1+n2; break;
                    case "Restar": resultado = n1-n2; break;
                    case "Multiplicar": resultado = n1*n2; break;
                    case "Dividir": resultado = (float)n1/n2; break;
                }
                lblresultado.setText(""+resultado);
                Toast.makeText(getApplicationContext(),""+resultado,Toast.LENGTH_LONG).show();
                /*if(operacion=="Sumar"){
                    resultado = n1 + n2;
                }
                if(operacion=="Resta"){
                    resultado = n1 - n2;
                }
                if(operacion=="Multiplicar"){
                    resultado = n1 * n2;
                }
                if(operacion=="Dividir"){
                    resultado = n1 / n2;
                }*/
            }
        });
    }
}