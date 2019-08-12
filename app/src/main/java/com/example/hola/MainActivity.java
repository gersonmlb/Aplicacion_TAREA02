package com.example.hola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtHoras = findViewById(R.id.txtHoras);
    private Button btnAceptar = findViewById(R.id.btnCalcular);

    int hour = txtHoras.getText().length();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int salarioHora = 40;

                do {
                    if (hour <= 0 || hour > 60) {
                        Toast.makeText(getApplicationContext(), "Error, no ha ingresado un rango correcto de horas laborales maximo son 60 horas, intentelo de nuevo", Toast.LENGTH_LONG).show();
                    }
                } while (hour <= 0 || hour > 60);
                do {
                    if (salarioHora <= 0) {
                        Toast.makeText(getApplicationContext(), "El salario base por hora no puede ser negativo, intentelo nuevamente", Toast.LENGTH_LONG).show();
                    }
                } while (salarioHora < 0);

                int salarioSemanalbase = (salarioHora * 40);
                if (hour <= 40)
                    {
                        int salarioSemanal = (salarioHora * hour);
                        Toast.makeText(getApplicationContext(), "el salario semanal es: $" + salarioSemanal, Toast.LENGTH_LONG).show();
                    }else if (hour > 40 && hour < 50) {

                       int salarioSemanal = (((hour - 40) * 2 * salarioHora) + salarioSemanalbase);
                        Toast.makeText(getApplicationContext(), "el salario semanal es: $" + salarioSemanal, Toast.LENGTH_LONG).show();
                    } else {
                        int salarioSemanal = (((hour - 40) * 3 * salarioHora) + salarioSemanalbase);
                        Toast.makeText(getApplicationContext(), "el salario semanal es: $" + salarioSemanal, Toast.LENGTH_LONG).show();
                    }

                }
        });

    }
}
