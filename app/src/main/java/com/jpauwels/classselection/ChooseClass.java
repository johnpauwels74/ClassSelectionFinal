package com.jpauwels.classselection;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ChooseClass extends AppCompatActivity {
    private String firstName = "";
    private String lastname = "";
    private String phone = "";
    private String birthDate = "";
    private String isDegreeCert = "";
    private String degreeCert = "";

    private Toast toastError = null;

    private CheckedTextView ctv1;
    private CheckedTextView ctv2;
    private CheckedTextView ctv3;
    private CheckedTextView ctv4;

    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private RadioButton rb5;
    private RadioButton rb6;
    private RadioButton rb7;
    private RadioButton rb8;

    private RadioGroup rg1;
    private RadioGroup rg2;
    private RadioGroup rg3;
    private RadioGroup rg4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_class);

        ctv1 = (CheckedTextView) findViewById(R.id.ctv1);
        ctv2 = (CheckedTextView) findViewById(R.id.ctv2);
        ctv3 = (CheckedTextView) findViewById(R.id.ctv3);
        ctv4 = (CheckedTextView) findViewById(R.id.ctv4);

        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
        rb5 = (RadioButton) findViewById(R.id.rb5);
        rb6 = (RadioButton) findViewById(R.id.rb6);
        rb7 = (RadioButton) findViewById(R.id.rb7);
        rb8 = (RadioButton) findViewById(R.id.rb8);

        final Button btnNext = (Button) findViewById(R.id.btnNext);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            firstName = extras.getString("FirstName");
            lastname = extras.getString("LastName");
            phone = extras.getString("Phone");
            birthDate = extras.getString("BirthDate");
            isDegreeCert = extras.getString("isDegreeCert");
            degreeCert = extras.getString("degreeCert");
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton radioButton;

                String ctv1Text = "";
                String ctv2Text = "";
                String ctv3Text = "";
                String ctv4Text = "";

                String radio1Text = "";
                String radio2Text = "";
                String radio3Text = "";
                String radio4Text = "";

                rg1 = (RadioGroup) findViewById(R.id.radioGroup);
                rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
                rg3 = (RadioGroup) findViewById(R.id.radioGroup3);
                rg4 = (RadioGroup) findViewById(R.id.radioGroup4);
                int selectedTime1 = 0, selectedTime2 = 0, selectedTime3 = 0, selectedTime4 = 0;


                if (ctv1.isChecked()){
                    ctv1Text = ctv1.getText().toString();
                    selectedTime1 = rg1.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(selectedTime1);
                    radio1Text = radioButton.getText().toString();

                }

                if (ctv2.isChecked()){
                    ctv2Text = ctv2.getText().toString();
                    selectedTime2 = rg2.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(selectedTime2);
                    radio2Text = radioButton.getText().toString();

                }
                if (ctv3.isChecked()){
                    ctv3Text = ctv3.getText().toString();
                    selectedTime3 = rg3.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(selectedTime3);
                    radio3Text = radioButton.getText().toString();

                }
                if (ctv4.isChecked()){
                    ctv4Text = ctv4.getText().toString();
                    selectedTime4 = rg4.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(selectedTime4);
                    radio4Text = radioButton.getText().toString();

                }

                if(radioCheck(selectedTime1, selectedTime2, selectedTime3, selectedTime4)) {
                    // It is our 'intent' to pass data
                    // So we build the intent
                    Intent nextScreen = new Intent(ChooseClass.this, Summary.class);
                    nextScreen.putExtra("FirstName", firstName);
                    nextScreen.putExtra("LastName", lastname);
                    nextScreen.putExtra("Phone", phone);
                    nextScreen.putExtra("BirthDate", birthDate);
                    nextScreen.putExtra("isDegreeCert", isDegreeCert);
                    nextScreen.putExtra("degreeCert", degreeCert);

                    nextScreen.putExtra("Class1", ctv1Text);
                    nextScreen.putExtra("Selected1", radio1Text);

                    nextScreen.putExtra("Class2",ctv2Text);
                    nextScreen.putExtra("Selected2", radio2Text);

                    nextScreen.putExtra("Class3", ctv3Text);
                    nextScreen.putExtra("Selected3",radio3Text);

                    nextScreen.putExtra("Class4", ctv4Text);
                    nextScreen.putExtra("Selected4", radio4Text);


                    //Start the activity
                    startActivity(nextScreen);
                } else {
                    toastError.makeText(getApplicationContext(),"Timeslot conflict.",toastError.LENGTH_SHORT).show();
                }
            }
        });

        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rb1.setError(null);
                rb2.setError(null);
                rb3.setError(null);
                rb4.setError(null);
                rb5.setError(null);
                rb6.setError(null);
                rb7.setError(null);
                rb8.setError(null);
            }
        });

        rb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rb1.setError(null);
                rb2.setError(null);
                rb3.setError(null);
                rb4.setError(null);
                rb5.setError(null);
                rb6.setError(null);
                rb7.setError(null);
                rb8.setError(null);
            }
        });

        rb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rb1.setError(null);
                rb2.setError(null);
                rb3.setError(null);
                rb4.setError(null);
                rb5.setError(null);
                rb6.setError(null);
                rb7.setError(null);
                rb8.setError(null);
            }
        });
        rb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rb1.setError(null);
                rb2.setError(null);
                rb3.setError(null);
                rb4.setError(null);
                rb5.setError(null);
                rb6.setError(null);
                rb7.setError(null);
                rb8.setError(null);
            }
        });
        rb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rb1.setError(null);
                rb2.setError(null);
                rb3.setError(null);
                rb4.setError(null);
                rb5.setError(null);
                rb6.setError(null);
                rb7.setError(null);
                rb8.setError(null);
            }
        });
        rb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rb1.setError(null);
                rb2.setError(null);
                rb3.setError(null);
                rb4.setError(null);
                rb5.setError(null);
                rb6.setError(null);
                rb7.setError(null);
                rb8.setError(null);
            }
        });
        rb7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rb1.setError(null);
                rb2.setError(null);
                rb3.setError(null);
                rb4.setError(null);
                rb5.setError(null);
                rb6.setError(null);
                rb7.setError(null);
                rb8.setError(null);
            }
        });
        rb8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rb1.setError(null);
                rb2.setError(null);
                rb3.setError(null);
                rb4.setError(null);
                rb5.setError(null);
                rb6.setError(null);
                rb7.setError(null);
                rb8.setError(null);
            }
        });


        ctv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ctv1.isChecked())
                    enableDisable(ctv1,rb1,rb2, Color.WHITE,false);
                else
                    enableDisable(ctv1,rb1,rb2, Color.GRAY,true);
            }
        });

        ctv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ctv2.isChecked())
                    enableDisable(ctv2,rb3,rb4, Color.WHITE,false);
                else
                    enableDisable(ctv2,rb3,rb4, Color.GRAY,true);
            }
        });

        ctv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ctv3.isChecked())
                    enableDisable(ctv3,rb5,rb6, Color.WHITE,false);
                else
                    enableDisable(ctv3,rb5,rb6, Color.GRAY,true);
            }
        });
        ctv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ctv4.isChecked())
                    enableDisable(ctv4,rb7,rb8, Color.WHITE,false);
                else
                    enableDisable(ctv4,rb7,rb8, Color.GRAY,true);
            }
        });
    }


    public void enableDisable(CheckedTextView ctv, RadioButton rb1, RadioButton rb2, Integer bgColor, Boolean state){
        ctv.setChecked(state);
        ctv.setBackgroundColor(bgColor);
        rb1.setEnabled(state);
        rb2.setEnabled(state);

        rb1.setChecked(state);

        if (!state) {
            rb1.setChecked(state);
            rb2.setChecked(state);
        }

    }
    public boolean radioCheck(int selectedTime1, int selectedTime2, int selectedTime3, int selectedTime4){

        if ((selectedTime1 == R.id.rb2) && (selectedTime4 == R.id.rb7)){
            rb2.setError("Timeslot conflict.");
            rb7.setError("Timeslot conflict.");
            return false;
        }

        if ((selectedTime1 == R.id.rb1) && (selectedTime2 == R.id.rb3)){
            rb1.setError("Timeslot conflict.");
            rb3.setError("Timeslot conflict.");
            return false;
        }
        if ((selectedTime3 == R.id.rb5) && (selectedTime4 == R.id.rb8)){
            rb5.setError("Timeslot conflict.");
            rb8.setError("Timeslot conflict.");
            return false;
        }




        return true;
    }
}