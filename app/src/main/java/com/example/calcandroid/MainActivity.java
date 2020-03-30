package com.example.calcandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText screen;
    private String content = "";

    private List<Float> numbers = new ArrayList<>();
    private List<String> ops = new ArrayList<>();

    private Float result = 0f;

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonMais;
    private Button buttonMenos;
    private Button buttonDivide;
    private Button buttonVezes;
    private Button buttonVirgula;
    private Button buttonIgual;

    private Boolean isComma = false;
    private Boolean nextClean = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.result);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonMais = findViewById(R.id.buttonMais);
        buttonMenos = findViewById(R.id.buttonMenos);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonVezes = findViewById(R.id.buttonVezes);
        buttonIgual = findViewById(R.id.buttonIgual);
        buttonVirgula = findViewById(R.id.buttonVirgula);

        addListeners();
    }

    private void addListeners() {
        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickSaveValue("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickSaveValue("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickSaveValue("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickSaveValue("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickSaveValue("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickSaveValue("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickSaveValue("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickSaveValue("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickSaveValue("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickSaveValue("9");
            }
        });

        buttonVirgula.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickSaveValue(".");
            }
        });

        buttonMais.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numbers.add(Float.parseFloat(content));
                ops.add("mais");
                clearScreen();
            }
        });

        buttonMenos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numbers.add(Float.parseFloat(content));
                ops.add("menos");
                clearScreen();
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numbers.add(Float.parseFloat(content));
                ops.add("divisao");
                clearScreen();
            }
        });

        buttonVezes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numbers.add(Float.parseFloat(content));
                ops.add("multiplicacao");
                clearScreen();
            }
        });

        buttonIgual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numbers.add(Float.parseFloat(content));
                calc();
                screen.setText(result.toString());

                numbers.clear();
                ops.clear();

                nextClean = true;
            }
        });
    }

    private void calc() {
        for (int i =0; i < ops.size(); i++) {
            if (i == 0) {
                switch (ops.get(i)) {
                    case "mais":
                        result = numbers.get(i) + numbers.get(i+1);
                        break;
                    case "menos":
                        result = numbers.get(i) - numbers.get(i+1);
                        break;
                    case "multiplicacao":
                        result = numbers.get(i) * numbers.get(i+1);
                        break;
                    case "divisao":
                        result = numbers.get(i) / numbers.get(i+1);
                        break;
                    default:
                        break;
                }
            } else {
                switch (ops.get(i)) {
                    case "mais":
                        result += numbers.get(i+1);
                        break;
                    case "menos":
                        result -= numbers.get(i+1);
                        break;
                    case "multiplicacao":
                        result *= numbers.get(i+1);
                        break;
                    case "divisao":
                        result /= numbers.get(i+1);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void clearScreen() {
        content = "";
        screen.setText(content);
        isComma = false;
    }

    private void onClickSaveValue(String value) {
        if (value.equals(".")) {
            if (isComma) {
                return;
            } else {
                isComma = true;
            }
        }

        if (nextClean) {
            content = "";
            nextClean = false;
        }

        content += value;
        screen.setText(content);
    }
}
