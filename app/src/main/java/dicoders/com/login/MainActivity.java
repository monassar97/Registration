package dicoders.com.login;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText uNameText;
    EditText pwdText;
    Button logInBtn;
    TextView tvRegister;
    DBConnection conn=new DBConnection(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setXmlRef();
        setListeners();
        //conn.insertRowParents("md","m@gmail.com","0797402031","123");
    }

    private void setXmlRef() {
        logInBtn=findViewById(R.id.button);
        uNameText=findViewById(R.id.editText1);
        pwdText=findViewById(R.id.editText2);
        tvRegister=findViewById(R.id.tv_register);

    }

    private void setListeners() {
        logInBtn.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                if(conn.checkUser(uNameText.getText().toString(),pwdText.getText().toString())){
                    Intent signUpIntent=new Intent(getApplicationContext(),Main4ActivityLogIn.class);
                    startActivity(signUpIntent);
                }
                else
                    Toast.makeText(this,"Incorrect User name or Password!",Toast.LENGTH_LONG).show();

                break;

            case R.id.tv_register:
                Intent signUpIntent=new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(signUpIntent);


                break;
        }
    }

}
