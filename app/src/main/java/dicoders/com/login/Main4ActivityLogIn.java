package dicoders.com.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main4ActivityLogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4_log_in);

        Toast.makeText(this,"Welcome!",Toast.LENGTH_LONG).show();
    }
}
