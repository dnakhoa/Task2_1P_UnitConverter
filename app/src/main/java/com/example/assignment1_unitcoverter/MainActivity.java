package com.example.assignment1_unitcoverter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText inputValue;

    TextView value1;
    TextView value2;
    TextView value3;
    TextView unit1;
    TextView unit2;
    TextView unit3;

    ImageView length;
    ImageView temp;
    ImageView weight;

    String currentItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create Spinner
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //Variable Declaration For Views
        inputValue = findViewById(R.id.editText);

        length = findViewById(R.id.lengthView);
        temp = findViewById(R.id.tempView);
        weight = findViewById(R.id.weightView);

        value1 = findViewById(R.id.value1);
        value2 = findViewById(R.id.value2);
        value3 = findViewById(R.id.value3);

        unit1 = findViewById(R.id.unit1);
        unit2 = findViewById(R.id.unit2);
        unit3 = findViewById(R.id.unit3);

        length.setOnClickListener(new MetreButtonOnClickListener());
        temp.setOnClickListener(new TempButtonOnClickListener());
        weight.setOnClickListener(new WeightButtonOnClickListener());

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        currentItem = text;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private class TempButtonOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
           if (currentItem.equals("Celsius")) {
               String value = inputValue.getText().toString();
               double number = Double.parseDouble(value);
               unit1.setVisibility(View.INVISIBLE);
               value1.setVisibility(View.INVISIBLE);

               DecimalFormat twoDForm = new DecimalFormat("#.00");

               double Fahrenheit = (number * 1.8) + 32;
               double Kelvin = number + 273.15;

               value2.setText("" + twoDForm.format(Fahrenheit));
               value2.setVisibility(View.VISIBLE);
               value3.setText("" + twoDForm.format(Kelvin));
               value3.setVisibility(View.VISIBLE);

               unit1.setText("Fahrenheit");
               unit1.setVisibility(View.VISIBLE);
               unit2.setText("Kelvin");
               unit2.setVisibility(View.VISIBLE);
           }
           else
           {
               String text ="Please chose the correct Scale";
               Context context = getApplicationContext();
               Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
           }
        }
    }

    private class MetreButtonOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (currentItem.equals("Metre")) {

            String value = inputValue.getText().toString();
            double number = Double.parseDouble(value);
            DecimalFormat twoDForm = new DecimalFormat("#.00");

            double Cm = number * 100;
            double Ft = number * 3.2808;
            Ft = Double.valueOf(twoDForm.format(Ft));
            double in = number * 39.70;
            in = Double.valueOf(twoDForm.format(in));

            value1.setText("" + Cm);
            value1.setVisibility(View.VISIBLE);
            value2.setText("" + Ft);
            value2.setVisibility(View.VISIBLE);
            value3.setText("" + in);
            value3.setVisibility(View.VISIBLE);

            unit1.setText("Centimetre");
            unit1.setVisibility(View.VISIBLE);
            unit2.setText("Foot");
            unit2.setVisibility(View.VISIBLE);
            unit3.setText("Inch");
            unit3.setVisibility(View.VISIBLE);
            }
           else
            {
            String text ="Please chose the correct Scale";
            Context context = getApplicationContext();
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
            }

        }
    }

    private class WeightButtonOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (currentItem.equals("Kilograms")) {
            String value = inputValue.getText().toString();
            double number = Double.parseDouble(value);
            DecimalFormat twoDForm = new DecimalFormat("#.00");

            double Gram = number * 1000;
            double Oz = number * 35.274;
            Oz = Double.parseDouble(twoDForm.format(Oz));
            double lB = number * 2.2046;
            lB = Double.parseDouble((twoDForm.format(lB)));

            value1.setText("" + Gram);
            value1.setVisibility(View.VISIBLE);
            value2.setText("" + Oz);
            value2.setVisibility(View.VISIBLE);
            value3.setText("" + lB);
            value3.setVisibility(View.VISIBLE);

            unit1.setText("Gram");
            unit1.setVisibility(View.VISIBLE);
            unit2.setText("Ounce(Oz)");
            unit2.setVisibility(View.VISIBLE);
            unit3.setText("Pound(lB)");
            unit3.setVisibility(View.VISIBLE);
            }
           else
            {
            String text ="Please chose the correct Scale";
            Context context = getApplicationContext();
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
            }

    }
    }
}
