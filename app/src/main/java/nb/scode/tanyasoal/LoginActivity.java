package nb.scode.tanyasoal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.iid.FirebaseInstanceId;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import custom_font.*;
import nb.scode.tanyasoal.app.App;
import nb.scode.tanyasoal.baseAct.BaseFirstActivity;
import nb.scode.tanyasoal.util.SavedUser;

public class LoginActivity extends BaseFirstActivity {

    @BindView(R.id.btn_daftar) TextViewApple create;
    @BindView(R.id.logo) ImageView logoTop;
    @BindView(R.id.myEditText) EditTextApple usr;
    @BindView(R.id.myEditText2) EditTextApple pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        isHome = true;
        Glide.with(this).load(R.drawable.logo_fix).asBitmap().fitCenter().into(logoTop);
        getBack().setVisibility(View.GONE);
        getProfile().setVisibility(View.GONE);
        getMail().setVisibility(View.GONE);
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        App.getInstance().setGcmToken(refreshedToken);

    }

    @OnClick(R.id.btn_daftar)
    void daftar(){
        Intent it = new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(it);
    }

    @OnClick(R.id.btn_login)
    void login(){
        String mail = usr.getText().toString().trim();
        String pss = pass.getText().toString().trim();
        if(mail.equals("user") && pss.equals("user")) {
            Intent iu = new Intent(LoginActivity.this, HomePageActivity.class);
            SavedUser.putUser(getApplicationContext(), "user");
            startActivity(iu);
            finish();
        }
        else if(mail.equals("tutor") && pss.equals("tutor")) {
            Intent iu = new Intent(LoginActivity.this, AvailQuestionActivity.class);
            SavedUser.putUser(getApplicationContext(), "tutor");
            startActivity(iu);
            finish();
        }
        else {
            Log.d("Error","Not authorized user: "+mail+" pass: "+pss);
        }
    }

    @OnClick(R.id.forgotpwd)
    void forgot(){
        Intent i = new Intent(getApplicationContext(), LupaPassActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }

}