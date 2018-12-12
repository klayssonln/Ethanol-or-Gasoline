package com.android.klayssonleite.ethanolorgasoline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText priceEthanol;
    private EditText priceGas;
    private TextView priceResult;
    private Button buttonCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        priceEthanol = (EditText) findViewById(R.id.priceEthanolId);
        priceGas = (EditText) findViewById(R.id.priceGasId);
        priceResult = (TextView) findViewById(R.id.textResultId);
        buttonCheck = (Button) findViewById(R.id.buttonId);

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtEthanol = priceEthanol.getText().toString();
                String txtGas = priceGas.getText().toString();

                if(txtEthanol.isEmpty() || txtEthanol.isEmpty()){
                    priceResult.setText("");
                    Toast.makeText(getApplicationContext(), "Please inform both prices.", Toast.LENGTH_SHORT).show();
                } else {
                    txtEthanol = txtEthanol.replace(",",".");
                    txtGas = txtGas.replace(",",".");

                    double valueEthanol = Double.parseDouble(txtEthanol);
                    double valueGas = Double.parseDouble(txtGas);

                    if(valueEthanol == 0 || valueGas == 0){
                        priceResult.setText("");
                        Toast.makeText(getApplicationContext(), "Invalid value.", Toast.LENGTH_SHORT).show();
                    } else {
                        double result = valueEthanol/valueGas * 100;
                        if(result > 70){
                            priceResult.setText("You should use Gasoline.");
                        } else {
                            priceResult.setText("You should use Ethanol.");
                        }
                    }
                }
            }
        });
    }
}
