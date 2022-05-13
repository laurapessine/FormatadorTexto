package com.example.formatadortexto;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView lblTexto1;
    private TextView lblTexto2;
    private EditText txtTexto1;
    private EditText txtTexto2;
    private Button btnGravaTxt1;
    private Button btnGravaTxt2;
    private RadioButton rad1;
    private RadioButton rad2;
    private EditText txtTam;
    private Button btnGravaTam;
    private Button btnRed;
    private Button btnBlue;
    private Button btnGreen;
    private CheckBox chkBold;
    private CheckBox chkItalic;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblTexto1 = findViewById(R.id.lblTexto1);
        lblTexto2 = findViewById(R.id.lblTexto2);
        txtTexto1 = findViewById(R.id.txtTexto1);
        txtTexto2 = findViewById(R.id.txtTexto2);
        btnGravaTxt1 = findViewById(R.id.btnGravaTxt1);
        btnGravaTxt2 = findViewById(R.id.btnGravaTxt2);
        rad1 = findViewById(R.id.rad1);
        rad2 = findViewById(R.id.rad2);
        txtTam = findViewById(R.id.txtTam);
        btnGravaTam = findViewById(R.id.btnGravaTam);
        btnRed = findViewById(R.id.btnRed);
        btnBlue = findViewById(R.id.btnBlue);
        btnGreen = findViewById(R.id.btnGreen);
        chkBold = findViewById(R.id.chkBold);
        chkItalic = findViewById(R.id.chkItalic);

        btnRed.setOnClickListener(new EscutadorBotaoCor());
        btnBlue.setOnClickListener(new EscutadorBotaoCor());
        btnGreen.setOnClickListener(new EscutadorBotaoCor());
        chkBold.setOnClickListener(new EscutadorCheckBox());
        chkItalic.setOnClickListener(new EscutadorCheckBox());

        btnGravaTxt1.setOnClickListener(view -> {
            if (txtTexto1.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Texto não informado!", Toast.LENGTH_SHORT).show();
            } else {
                lblTexto1.setText(txtTexto1.getText().toString());
            }
        });

        btnGravaTxt2.setOnClickListener(view -> {
            if (txtTexto2.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Texto não informado!", Toast.LENGTH_SHORT).show();
            } else {
                lblTexto2.setText(txtTexto2.getText().toString());
            }
        });

        btnGravaTam.setOnClickListener(view -> {
            if (rad1.isChecked()) {
                if (txtTam.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Tamanho não informado!", Toast.LENGTH_SHORT).show();
                } else if (lblTexto1.getText().equals("TextView")) {
                    Toast.makeText(getApplicationContext(), "Texto não informado!", Toast.LENGTH_SHORT).show();
                } else {
                    lblTexto1.setTextSize(Float.parseFloat(txtTam.getText().toString()));
                }

            } else if (rad2.isChecked()) {
                if (txtTam.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Tamanho não informado!", Toast.LENGTH_SHORT).show();
                } else if (lblTexto2.getText().toString().equals("TextView")) {
                    Toast.makeText(getApplicationContext(), "Texto não informado!", Toast.LENGTH_SHORT).show();
                } else {
                    lblTexto2.setTextSize(Float.parseFloat(txtTam.getText().toString()));
                }
            } else {
                Toast.makeText(getApplicationContext(), "Radio não informado!", Toast.LENGTH_SHORT).show();
            }
        });

        // quando qualquer um dos radios for clicado...
        rad1.setOnClickListener(view -> {
            if (!lblTexto1.getText().equals("TextView")) {
                if (chkBold.isChecked() && chkItalic.isChecked()) {
                    lblTexto1.setTypeface(null, Typeface.BOLD_ITALIC);
                } else if (chkBold.isChecked()) {
                    lblTexto1.setTypeface(null, Typeface.BOLD);
                } else if (chkItalic.isChecked()) {
                    lblTexto1.setTypeface(null, Typeface.ITALIC);
                } else {
                    lblTexto1.setTypeface(null, Typeface.NORMAL);
                }
            }
        });
        rad2.setOnClickListener(view -> {
            if (!lblTexto2.getText().equals("TextView")) {
                if (chkBold.isChecked() && chkItalic.isChecked()) {
                    lblTexto2.setTypeface(null, Typeface.BOLD_ITALIC);
                } else if (chkBold.isChecked()) {
                    lblTexto2.setTypeface(null, Typeface.BOLD);
                } else if (chkItalic.isChecked()) {
                    lblTexto2.setTypeface(null, Typeface.ITALIC);
                } else {
                    lblTexto2.setTypeface(null, Typeface.NORMAL);
                }
            }
        });
        // verifica se algum dos checks está marcado
        // se estiver, aplica as alterações
        // se o usuário desselecionar alguma das opções, voltar para o normal

    }

    private class EscutadorBotaoCor implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.btnRed) {
                if ((rad1.isChecked()) && (!lblTexto1.getText().equals("TextView"))) {
                    lblTexto1.setTextColor(Color.RED);
                } else if ((rad2.isChecked()) && (!lblTexto2.getText().equals("TextView"))) {
                    lblTexto2.setTextColor(Color.RED);
                } else {
                    Toast.makeText(MainActivity.this, "Radio ou texto não informado!", Toast.LENGTH_SHORT).show();
                }
            } else if (id == R.id.btnBlue) {
                if ((rad1.isChecked()) && (!lblTexto1.getText().equals("TextView"))) {
                    lblTexto1.setTextColor(Color.BLUE);
                } else if ((rad2.isChecked()) && (!lblTexto2.getText().equals("TextView"))) {
                    lblTexto2.setTextColor(Color.BLUE);
                } else {
                    Toast.makeText(MainActivity.this, "Radio ou texto não informado!", Toast.LENGTH_SHORT).show();
                }
            } else if (id == R.id.btnGreen) {
                if ((rad1.isChecked()) && (!lblTexto1.getText().equals("TextView"))) {
                    lblTexto1.setTextColor(Color.GREEN);
                } else if ((rad2.isChecked()) && (!lblTexto2.getText().equals("TextView"))) {
                    lblTexto2.setTextColor(Color.GREEN);
                } else {
                    Toast.makeText(MainActivity.this, "Radio ou texto não informado!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private class EscutadorCheckBox implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (!lblTexto1.getText().equals("TextView")) {
                if (chkBold.isChecked() && chkItalic.isChecked()) {
                    if (rad1.isChecked()) {
                        lblTexto1.setTypeface(null, Typeface.BOLD_ITALIC);
                    } else if (rad2.isChecked()) {
                        lblTexto2.setTypeface(null, Typeface.BOLD_ITALIC);
                    } else {
                        Toast.makeText(MainActivity.this, "Radio não informado!", Toast.LENGTH_SHORT).show();
                    }
                } else if (chkBold.isChecked()) {
                    if (rad1.isChecked()) {
                        lblTexto1.setTypeface(null, Typeface.BOLD);
                    } else if (rad2.isChecked()) {
                        lblTexto2.setTypeface(null, Typeface.BOLD);
                    } else {
                        Toast.makeText(MainActivity.this, "Radio não informado!", Toast.LENGTH_SHORT).show();
                    }
                } else if (chkItalic.isChecked()) {
                    if (rad1.isChecked()) {
                        lblTexto1.setTypeface(null, Typeface.ITALIC);
                    } else if (rad2.isChecked()) {
                        lblTexto2.setTypeface(null, Typeface.ITALIC);
                    } else {
                        Toast.makeText(MainActivity.this, "Radio não informado!", Toast.LENGTH_SHORT).show();
                    }
                } else if ((!chkBold.isChecked()) && (!chkItalic.isChecked())) {
                    if (rad1.isChecked()) {
                        lblTexto1.setTypeface(null, Typeface.NORMAL);
                    } else if (rad2.isChecked()) {
                        lblTexto2.setTypeface(null, Typeface.NORMAL);
                    } else {
                        Toast.makeText(MainActivity.this, "Radio não informado!", Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                Toast.makeText(MainActivity.this, "Texto não informado!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}