package com.example.secondchallengefaizaankhan;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private EditText editTxtName, editTxtEmail, editTxtPassword, editTxtTextPasswordRepeat;
    private Button btnPickImage, btnRegister;
    private TextView txtWarnName, txtWarnEmail, txtWarnPassword, txtWarnPassRepeat;
    private Spinner spinner2;
    private RadioGroup rgGender;
    private CheckBox checkBox;
    private RelativeLayout lay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnPickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Yet to talk about", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initRegister();
            }
        });
    }
    private void initRegister(){
        Log.d(TAG, "initRegister: Started");
        if (validateData()){
            if (checkBox.isChecked()) {
                showSnackBar();

            }else {
                Toast.makeText(this, "You need to agree", Toast.LENGTH_LONG).show();
            }
        }
    }
    private void showSnackBar(){
        Log.d(TAG, "showSnackBar: Started");
        txtWarnName.setVisibility(View.GONE);
        txtWarnEmail.setVisibility(View.GONE);
        txtWarnPassword.setVisibility(View.GONE);
        txtWarnPassRepeat.setVisibility(View.GONE);

        String name = editTxtName.getText().toString();
        String email = editTxtEmail.getText().toString();
        String country = spinner2.getSelectedItem().toString();
        String gender = "";
        switch (rgGender.getCheckedRadioButtonId()){
            case R.id.radioButton5:
                gender = "Male";
                break;
            case R.id.radioButton4:
                gender = "Female";
                break;
            default:
                gender = "Alien";
                break;
        }
        String snackText = "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Gender: " + gender + "\n" +
                "Country: " + country;


        Snackbar.make(lay, snackText, Snackbar.LENGTH_INDEFINITE).setAction("Dismiss", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTxtName.setText("");
                editTxtEmail.setText("");
                editTxtPassword.setText("");
                editTxtTextPasswordRepeat.setText("");

            }
        }).show();
    }
    private boolean validateData() {
        Log.d(TAG, "validateData: Started");
        if (editTxtName.getText().toString().equals("")){
            txtWarnName.setVisibility(View.VISIBLE);
            txtWarnName.setText("Enter your Name");
            return false;
        }
        if (editTxtEmail.getText().toString().equals("")) {
            txtWarnEmail.setVisibility(View.VISIBLE);
            txtWarnEmail.setText("Enter your Email");
            return false;
        }
        if (editTxtPassword.getText().toString().equals("")) {
            txtWarnPassword.setVisibility(View.VISIBLE);
            txtWarnPassword.setText("Enter your Password");
            return false;
        }
        if (editTxtTextPasswordRepeat.getText().toString().equals("")) {
            txtWarnPassRepeat.setVisibility(View.VISIBLE);
            txtWarnPassRepeat.setText("Enter your Password again");
            return false;
        }
        if (!editTxtPassword.getText().toString().equals(editTxtTextPasswordRepeat.getText().toString())){
            txtWarnPassRepeat.setVisibility(View.VISIBLE);
            txtWarnPassRepeat.setText("Password no match");
            return false;

        }

        return true;

    }
    private void initViews() {
        Log.d(TAG, "initViews: Star");
        editTxtName = findViewById(R.id.editTxtName);
        editTxtEmail = findViewById(R.id.editTxtEmail);
        editTxtPassword = findViewById(R.id.editTxtPassword);
        editTxtTextPasswordRepeat = findViewById(R.id.editTxtTextPasswordRepeat);

        btnPickImage = findViewById(R.id.btnPickImage);
        btnRegister = findViewById(R.id.btnRegister);

        txtWarnName = findViewById(R.id.txtWarnName);
        txtWarnEmail = findViewById(R.id.txtWarnEmail);
        txtWarnPassword = findViewById(R.id.txtWarnPassword);
        txtWarnPassRepeat = findViewById(R.id.txtWarnPassRepeat);

        spinner2 = findViewById(R.id.spinner2);
        rgGender = findViewById(R.id.rgGender);
        checkBox = findViewById(R.id.checkBox);
        lay = findViewById(R.id.lay);
    }

}