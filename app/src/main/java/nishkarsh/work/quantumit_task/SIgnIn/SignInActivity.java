package nishkarsh.work.quantumit_task.SIgnIn;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.SignInButton;

import nishkarsh.work.quantumit_task.Google_SignIn;
import nishkarsh.work.quantumit_task.R;
import nishkarsh.work.quantumit_task.View.MainActivity;

import static nishkarsh.work.quantumit_task.Constants.AppConstants.PREFS_NAME;

public class SignInActivity  extends AppCompatActivity {
    Button signup;
    Button signin;
    Button login;
    Button register,registerbottom,loginbottom;
    SignInButton signingoogle;
    FrameLayout fsignup,fsignin;
    EditText Name,emailnew,passwordnew,phonenum,emailid,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinlayout);



        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if(preferences.getString("loggedin", "no").equals("yes")){
            startActivity(new Intent(SignInActivity.this, MainActivity.class));
        }

        signup=findViewById(R.id.Signup);
        signin= findViewById(R.id.Login);
        fsignup=findViewById(R.id.fsignup);
        fsignin=findViewById(R.id.fsigin);
        login=findViewById(R.id.loginbottom);
        register= findViewById(R.id.Registerbottom);
        signingoogle= (SignInButton)findViewById(R.id.signingoogle);
        Name=findViewById(R.id.name);
        emailnew= findViewById(R.id.emailnew);
        passwordnew=findViewById(R.id.passnew);
        phonenum=(EditText) findViewById(R.id.contactnum);
        registerbottom=findViewById(R.id.Registerbottom);
        loginbottom=findViewById(R.id.loginbottom);
        emailid=findViewById(R.id.loginname);
        password=findViewById(R.id.password);



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fsignin.setVisibility(View.INVISIBLE);
                fsignup.setVisibility(View.VISIBLE);
                login.setVisibility(View.INVISIBLE);
                register.setVisibility(View.VISIBLE);

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fsignup.setVisibility(View.INVISIBLE);
                fsignin.setVisibility(View.VISIBLE);
                login.setVisibility(View.VISIBLE);
                register.setVisibility(View.INVISIBLE);
            }
        });


        signingoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInActivity.this, Google_SignIn.class));
            }
        });
        registerbottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("loggedin", "yes");
                editor.putString("username", Name.getText().toString());
                editor.putString("password", passwordnew.getText().toString());
                editor.putString("email", emailnew.getText().toString());
                editor.putString("number", phonenum.getText().toString());
                editor.commit();



                Toast.makeText(getApplicationContext(),"Signed Up Succesfully",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignInActivity.this, MainActivity.class));

            }
        });
        loginbottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String em=preferences.getString("email", "");
                String ps=preferences.getString("password", "");
                Log.d("+++++",em);
                Log.d("++++","hjhihiii"+preferences.getString("loggedin",""));
                if(emailid.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Email or password can not be empty",Toast.LENGTH_SHORT).show();
                }else
                if(emailid.getText().toString().equals(em) && password.getText().toString().equals(ps)){

                    Toast.makeText(getApplicationContext(),"Succesfully loggedIN",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignInActivity.this, MainActivity.class));
                }else{
                    Toast.makeText(getApplicationContext(),"Wrong id or pass",Toast.LENGTH_SHORT).show();

                }

            }
        });



    }
}
