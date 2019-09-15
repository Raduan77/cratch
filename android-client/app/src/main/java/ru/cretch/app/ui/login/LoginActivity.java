package ru.cretch.app.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import ru.cretch.app.App;
import ru.cretch.app.R;
import ru.cretch.app.ui.MainActivity;


public class LoginActivity extends AppCompatActivity {

    private EditText loginED;
    private EditText passwordED;

    public LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        App.getInstance().getComponent().inject(viewModel);

        loginED = findViewById(R.id.login);
        passwordED = findViewById(R.id.password);
        Button button = findViewById(R.id.signin);
        button.setOnClickListener(this::signin);


        viewModel.getLoginResult().observe(this, loginResult->{
            if (loginResult == null)
                return;

            findViewById(R.id.loadingPanel).setVisibility(View.GONE);

            if (loginResult.getSuccess() != null && loginResult.getSuccess()){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else {
                new AlertDialog.Builder(LoginActivity.this)
                        .setMessage("Ошибка авторизации")
                        .setPositiveButton("Ок", (d, b) -> {
                            d.dismiss();
                        })
                        .setCancelable(true)
                        .show();
            }
        });
    }

    private void signin(View view){
        String login = loginED.getText().toString();
        String password = passwordED.getText().toString();
        viewModel.login(login, password);
        findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);

    }
}
