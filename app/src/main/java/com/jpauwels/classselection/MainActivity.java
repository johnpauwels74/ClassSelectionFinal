package com.jpauwels.classselection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public enum LoginSuccess{
        login(1),
        password(2),
        success(0);
        private int intValue;
        LoginSuccess(int value){
            intValue = value;
        }
        public int getIntValue(){
            return intValue;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txtLogin = (TextView) findViewById(R.id.idLoginText);
        final TextView txtPassword = (TextView) findViewById(R.id.idPasswordText);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toastError = null;
                LoginSuccess isOK  = null;
                switch(CheckLogin(txtLogin.getText().toString(),txtPassword.getText().toString())){
                    case login:
                        toastError.makeText(getApplicationContext(),getString(R.string.errMessageLogin), toastError.LENGTH_SHORT).show();
                        txtLogin.requestFocus();
                        break;
                    case password:
                        toastError.makeText(getApplicationContext(),getString(R.string.errMessagePassword), toastError.LENGTH_SHORT).show();
                        txtPassword.requestFocus();
                        break;
                    default:
                        startActivity(new Intent(MainActivity.this, MainClassList.class));
                        break;
                }
            }

        });
    }

    LoginSuccess CheckLogin(String txtLogin, String txtPassword){
        String holdLogin = "John";
        String holdPass = "password";
        if(!(holdLogin.equals(txtLogin))){
            return LoginSuccess.login;
        }
        if (!(holdPass.equals(txtPassword))){
            return LoginSuccess.password;
        }
        return LoginSuccess.success;
    }
}
