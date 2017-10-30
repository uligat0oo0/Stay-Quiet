package androides.stayquiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private String firstName, lastName, phoneNumber, email;
    private TextView tvNameMine, tvEmailMine;
    private Button btnMapExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final Intent intentMaps = new Intent(HomeActivity.this, MapsActivity.class);
        tvNameMine = (TextView) findViewById(R.id.tvNameMine);
        tvEmailMine = (TextView) findViewById(R.id.tvEmailMine);

        getParams();

        tvNameMine.setText(firstName + " " + lastName);
        tvEmailMine.setText(email);

        btnMapExample = (Button)findViewById(R.id.btn_mapExample);
        btnMapExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentMaps);
            }
        });
    }

    private void getParams(){
        User user = (User) getIntent().getExtras().getSerializable("user");

        firstName = user.getFirstName();
        lastName = user.getLastName();
        phoneNumber = user.getPhoneNumber();
        email = user.getEmail();
    }
}
