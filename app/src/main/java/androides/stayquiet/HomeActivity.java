package androides.stayquiet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private String firstName, lastName, phoneNumber, email;
    private TextView tvNameMine, tvEmailMine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvNameMine = (TextView) findViewById(R.id.tvNameMine);
        tvEmailMine = (TextView) findViewById(R.id.tvEmailMine);

        getParams();

        tvNameMine.setText(firstName + " " + lastName);
        tvEmailMine.setText(email);
    }

    private void getParams(){
        User user = (User) getIntent().getExtras().getSerializable("user");

        firstName = user.getFirstName();
        lastName = user.getLastName();
        phoneNumber = user.getPhoneNumber();
        email = user.getEmail();
    }
}
