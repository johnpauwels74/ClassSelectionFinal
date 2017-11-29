package com.jpauwels.classselection;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CompoundButton;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.Switch;
        import android.widget.TextView;

public class MainClassList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_class_list);
        //create connections to interface components
        final Switch swDegreeCert = (Switch) findViewById(R.id.swDegreeCert);
        final Spinner spnDegree = (Spinner) findViewById(R.id.spnDegree);
        final Spinner spnCertificate = (Spinner) findViewById(R.id.spnCertificate);
        final TextView txtCertificate = (TextView) findViewById(R.id.lblCert);
        final TextView txtDegree = (TextView) findViewById(R.id.lblMajor);
        final Button btnNext = (Button) findViewById(R.id.btnNext);
        final EditText firstName = (EditText) findViewById(R.id.txtFirstName);
        final EditText lastName = (EditText) findViewById(R.id.txtLastName);
        final EditText phone = (EditText) findViewById(R.id.txtPhone);
        final Spinner spMonth = (Spinner) findViewById(R.id.spnMonth);
        final EditText txtDay = (EditText) findViewById(R.id.txtDay);
        final EditText txtYear = (EditText) findViewById(R.id.txtYear);

        firstName.requestFocus();

        swDegreeCert.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    spnDegree.setVisibility(View.VISIBLE);
                    txtDegree.setVisibility(View.VISIBLE);
                    spnCertificate.setVisibility(View.GONE);
                    txtCertificate.setVisibility(View.GONE);
                } else {
                    spnDegree.setVisibility(View.GONE);
                    txtDegree.setVisibility(View.GONE);
                    spnCertificate.setVisibility(View.VISIBLE);
                    txtCertificate.setVisibility(View.VISIBLE);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkData()){
                    String doBirth = "";
                    doBirth = spMonth.getSelectedItem().toString() + "/" + txtDay.getText().toString() + "/" + txtYear.getText().toString();

                    Intent nextScreen = new Intent(MainClassList.this, ChooseClass.class);
                    nextScreen.putExtra("FirstName", firstName.getText().toString());
                    nextScreen.putExtra("LastName", lastName.getText().toString());
                    nextScreen.putExtra("Phone", phone.getText().toString());
                    nextScreen.putExtra("BirthDate", doBirth);

                    if (spnDegree.getVisibility() == View.VISIBLE){
                        nextScreen.putExtra("isDegreeCert","Degree");
                        nextScreen.putExtra("degreeCert", spnDegree.getSelectedItem().toString());

                    } else {
                        nextScreen.putExtra("isDegreeCert","Certificate");
                        nextScreen.putExtra("degreeCert", spnCertificate.getSelectedItem().toString());
                    }
                    //Start Activity
                    startActivity(nextScreen);
                }
            }
        });
    }



    private boolean checkData(){
        final EditText firstName = (EditText) findViewById(R.id.txtFirstName);
        final EditText lastName = (EditText) findViewById(R.id.txtLastName);
        final EditText phone = (EditText) findViewById(R.id.txtPhone);
        final EditText txtDay = (EditText) findViewById(R.id.txtDay);
        final EditText txtYear = (EditText) findViewById(R.id.txtYear);

        if(firstName.getText().toString().isEmpty()){
            //error
            firstName.setError("Invalid First Name");
            firstName.requestFocus();
            return false;
        }

        if(lastName.getText().toString().isEmpty()){
            lastName.setError("Invalid Last Name");
            lastName.requestFocus();
            return false;
        }

        if(phone.getText().toString().isEmpty()){
            phone.setError("Invalid Phone Number");
            phone.requestFocus();
            return false;
        }

        if(txtDay.getText().toString().isEmpty()){
            txtDay.setError("Invalid Date Selection");
            txtDay.requestFocus();
            return false;
        }
        if(txtYear.getText().toString().isEmpty()){
            txtYear.setError("Invalid Date Selection");
            txtYear.requestFocus();
            return false;
        }
        return true;
    }
}
