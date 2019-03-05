package dicoders.com.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{

    Button registerButton;
    EditText txtName;
    EditText txtEmail;
    EditText txtPhone;
    EditText txtPwd;
    EditText txtRPwd;
    DBConnection conn=new DBConnection(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setXmlRef();
        setListeners();
    }

    private void setXmlRef() {
        registerButton=findViewById(R.id.btnRegister);
        txtName=findViewById(R.id.editTextName);
        txtEmail=findViewById(R.id.editTextEmail);
        txtPhone=findViewById(R.id.editTextPhone);
        txtPwd=findViewById(R.id.editTextPassword);
        txtRPwd=findViewById(R.id.editTextRetryPassword);
    }

    private void setListeners() {
        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegister:
                if(!((txtPwd.getText().toString()).equals((txtRPwd.getText().toString())))){
                    Toast.makeText(this,"password does not match",Toast.LENGTH_LONG).show();
                }
                else if(txtName.getText().toString()==null&&txtEmail.getText().toString()==null&&txtPhone.getText().toString()==null&&txtPwd.getText().toString()==null){
                    Toast.makeText(this,"Fill blanks",Toast.LENGTH_LONG).show();
                }else if((conn.checkUser(txtName.getText().toString()))){
                    Toast.makeText(this,"Name Already Exist!",Toast.LENGTH_LONG).show();
                }else if(conn.checkUserEmail(txtEmail.getText().toString())){
                    Toast.makeText(this,"E-mail Already Exist!",Toast.LENGTH_LONG).show();

                }else if(conn.checkUserPhoneNumber(txtPhone.getText().toString())){
                    Toast.makeText(this,"Phone Number Already Exist!",Toast.LENGTH_LONG).show();

                }
                else{
                    Parent parent=new Parent(txtName.getText().toString(),txtEmail.getText().toString(),txtPhone.getText().toString(),txtPwd.getText().toString());
                    conn.addParent(parent);
                    //conn.insertRowParents(txtName.getText().toString(),txtEmail.getText().toString(),txtPhone.getText().toString(),txtPwd.getText().toString());
                    Toast.makeText(this,"Registration Completed",Toast.LENGTH_LONG).show();
                    Intent signUpIntent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(signUpIntent);
                }


                break;
        }
    }
}
