package nb.scode.tanyasoal;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import custom_font.*;
import nb.scode.tanyasoal.baseAct.FragmentDrawer;

public class LoginActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private TextViewMyriad create;
    private FragmentDrawer drawerFragment;

    @Override
    public void onDrawerItemSelected(View view, int position) {
        Log.d("Click Drawer","U Click "+position);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        drawerFragment = (FragmentDrawer) getFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        create = (TextViewMyriad)findViewById(R.id.btn_daftar);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(it);
            }
        });
        final MyEditText usr = (MyEditText)findViewById(R.id.myEditText);
        final MyEditText pass = (MyEditText)findViewById(R.id.myEditText2);

        TextViewMyriad btnLogin = (TextViewMyriad)findViewById(R.id.btn_login);

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
                    Log.d("yoo","you're a tutor");
                }
                else {
                    Log.d("Error","Not authorized user: "+mail+" pass: "+pss);
                }
            }
        });

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
