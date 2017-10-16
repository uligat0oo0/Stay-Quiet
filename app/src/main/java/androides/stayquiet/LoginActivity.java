package androides.stayquiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin, btnRegister;
    EditText etEmail, etPassword;
    String email, password;
    StayQuietDBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Intent intentLogin = new Intent(LoginActivity.this, HomeActivity.class);
        final Intent intentRegister = new Intent(LoginActivity.this,RegisterActivity.class);
        dbManager = new StayQuietDBManager(getApplicationContext());
        etEmail = (EditText) findViewById(R.id.etLogin_email);
        etPassword = (EditText) findViewById(R.id.etLogin_password);
        btnLogin = (Button)findViewById(R.id.btnLogin_login);
        btnRegister =(Button)findViewById(R.id.btnLogin_register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValues();

                Account account = new User(email, password);
                User user = dbManager.getUser(account);

                if ( user != null ) {
                    intentLogin.putExtra("user", user);

                    startActivity(intentLogin);
                } else {
                    Toast.makeText(getApplicationContext(), "Datos inválidos.",
                            Toast.LENGTH_LONG).show();
                }

                etPassword.setText("");
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentRegister);
            }
        });
    }

    private void getValues() {
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
    }
}
