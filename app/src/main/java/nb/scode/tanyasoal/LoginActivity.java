package nb.scode.tanyasoal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import custom_font.*;
import nb.scode.tanyasoal.baseAct.BaseFirstAct;

public class LoginActivity extends BaseFirstAct {

    private TextViewApple create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        create = (TextViewApple)findViewById(R.id.btn_daftar);
        ImageView logoTop = (ImageView)findViewById(R.id.logo);
        Glide.with(this).load(R.drawable.logo_fix).asBitmap().fitCenter().into(logoTop);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(it);
            }
        });
        final EditTextApple usr = (EditTextApple)findViewById(R.id.myEditText);
        final EditTextApple pass = (EditTextApple)findViewById(R.id.myEditText2);

        TextViewApple btnLogin = (TextViewApple)findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = usr.getText().toString().trim();
                String pss = pass.getText().toString().trim();
                if(mail.equals("user") && pss.equals("user")) {
                    Intent iu = new Intent(LoginActivity.this, HomePageActivity.class);
                    startActivity(iu);
                    finish();
                }
                else if(mail.equals("tutor") && pss.equals("tutor")) {
                    Intent iu = new Intent(LoginActivity.this, AvailQuestionActivity.class);
                    startActivity(iu);
                    finish();
                }
                else {
                    Log.d("Error","Not authorized user: "+mail+" pass: "+pss);
                }
            }
        });

        getBack().setVisibility(View.GONE);
        getProfile().setVisibility(View.GONE);
        getMail().setVisibility(View.GONE);

        TextViewApple lupaPass = (TextViewApple)findViewById(R.id.forgotpwd);
        lupaPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LupaPassActivity.class);
                startActivity(i);
            }
        });
    }

}
