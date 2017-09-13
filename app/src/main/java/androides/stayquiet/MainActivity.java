package androides.stayquiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText email, pass;
    DBConnect db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBConnect(getApplicationContext());
        email = (EditText) findViewById(R.id.etEmail);
        pass = (EditText) findViewById(R.id.etPass);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        final Intent intent = new Intent(MainActivity.this, Main2Activity.class);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( db.checkUser(email.getText().toString(),
                        pass.getText().toString()) ) {
                    startActivity(intent);
                    email.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña inválido. (" +
                                    email.getText().toString() + ", " + pass.getText().toString() + ")",
                            Toast.LENGTH_LONG).show();
                }

                pass.setText("");
            }
        });
    }
}
