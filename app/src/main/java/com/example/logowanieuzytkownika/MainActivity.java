package com.example.logowanieapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.logowanieuzytkownika.R;

public class MainActivity extends AppCompatActivity {

    EditText emailInput, passwordInput;
    Button loginButton;
    TextView messageText;

    private final String correctEmail = "szymonskk@taulodz.pl";
    private final String correctPassword = "pracapoprawanazaliczenie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        messageText = findViewById(R.id.messageText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString();

                if (!isValidEmail(email)) {
                    messageText.setText("Nieprawidłowy format loginu (e-mail).");
                } else if (!email.equals(correctEmail)) {
                    messageText.setText("Brak użytkownika o podanym loginie.");
                } else if (!password.equals(correctPassword)) {
                    messageText.setText("Nieprawidłowe hasło.");
                } else {
                    messageText.setText("Zalogowano pomyślnie!");
                }
            }
        });
    }

    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
