package androides.stayquiet;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by gerardo on 17/09/17.
 */

public class UserRgister extends AppCompatActivity {

    Button saveUser;
    EditText email, pass, name,lastName,phone,confPhone,confPass;
    DBConnect db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_register);

        db = new DBConnect(getApplicationContext());
        name =(EditText) findViewById(R.id.name);
        lastName = (EditText)findViewById(R.id.lastName);
        phone = (EditText)findViewById(R.id.phone);
        confPhone=(EditText)findViewById(R.id.confPhone);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        confPass=(EditText)findViewById(R.id.confPass);
        saveUser = (Button) findViewById(R.id.saveUser);
      final Intent intent = new Intent(UserRgister.this, Main2Activity.class);

        saveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((phone.getText().toString().compareTo(confPhone.getText().toString()) == 0 && pass.getText().toString().compareTo(confPass.getText().toString()) == 0)) {
                   db.addUser(name.toString() + lastName.toString(),email.toString(),pass.toString());
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "el telefono o la contaseña no coinciden.",
                            Toast.LENGTH_LONG).show();
                }

                pass.setText("");
                confPass.setText("");
            }
        });

    }
}