package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextInputEditText texteditPrincipalAmount, texteditInterest, texteditLoanTenure;

    Button btnCalculate;

    TextView textEmi, textAns;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texteditPrincipalAmount = findViewById(R.id.texteditPrincipalAmount);
        texteditInterest = findViewById(R.id.texteditInterest);
        texteditLoanTenure = findViewById(R.id.texteditLoanTenure);
        textEmi = findViewById(R.id.textEmi);
        textAns = findViewById(R.id.textAns);
        btnCalculate = findViewById(R.id.btnCalculate);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double PrincipalAmount = Integer.parseInt(texteditPrincipalAmount.getText().toString());
                double Intrest = Integer.parseInt(texteditInterest.getText().toString());
                double LoanTenure = Integer.parseInt(texteditLoanTenure.getText().toString());
                double Calculate;
                double monthlyInterestRate = Intrest / (12 * 100);
                double denominator = Math.pow(1 + monthlyInterestRate, LoanTenure) - 1;
                double emi = (PrincipalAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate,  LoanTenure)) / denominator;

                DecimalFormat df = new DecimalFormat("#.##");
                btnCalculate.setText("EMI: " + df.format(emi));
            }
        });

    }
}