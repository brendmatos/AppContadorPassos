package br.ulbra.appcontadorp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtPassos;
    TextView txtResultado;

    RadioButton radioCurto;
    RadioButton radioMedio;
    RadioButton radioLongo;

    CheckBox checkCorrida;

    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtPassos = findViewById(R.id.edtPassos);

        txtResultado = findViewById(R.id.txtResultado);

        radioCurto = findViewById(R.id.radioCurto);

        radioMedio = findViewById(R.id.radioMedio);

        radioLongo = findViewById(R.id.radioLongo);

        checkCorrida = findViewById(R.id.checkCorrida);

        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (edtPassos.getText().toString().trim().isEmpty()) {

                    edtPassos.setError("Digite a quantidade de passos!");

                    return;
                }

                int passos = Integer.parseInt(
                        edtPassos.getText().toString()
                );

                if (passos <= 0) {

                    edtPassos.setError("Digite um número maior que zero!");

                    return;
                }

                double tamanhoPasso = 0;

                if (radioCurto.isChecked()) {

                    tamanhoPasso = 0.5;

                } else if (radioMedio.isChecked()) {

                    tamanhoPasso = 0.7;

                } else if (radioLongo.isChecked()) {

                    tamanhoPasso = 1.0;

                } else {

                    txtResultado.setText("Selecione um tipo de passo!");

                    return;
                }

                double distanciaTotal = passos * tamanhoPasso;

                if (checkCorrida.isChecked()) {

                    distanciaTotal = distanciaTotal * 1.10;
                }

                txtResultado.setText(
                        "Distância: " +
                                String.format("%.2f", distanciaTotal) +
                                " metros"
                );
            }
        });
    }
}