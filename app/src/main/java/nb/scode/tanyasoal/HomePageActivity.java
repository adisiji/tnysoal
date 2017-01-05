package nb.scode.tanyasoal;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import custom_font.TextViewMyriad;
import nb.scode.tanyasoal.baseAct.BaseActivity;

public class HomePageActivity extends BaseActivity {

    private Boolean isDoubleBackToExit=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        FrameLayout btnTanyaTutor = (FrameLayout)findViewById(R.id.btn_tny_tutor);
        FrameLayout btnKomunitas = (FrameLayout)findViewById(R.id.btn_komunitas);
        TextViewMyriad btnIsiSaldo = (TextViewMyriad)findViewById(R.id.btn_isiSaldo);
        TextViewMyriad lht_cat_user = (TextViewMyriad)findViewById(R.id.cat_aktivitas_home);
        lht_cat_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LogUserActivity.class);
                startActivity(i);
            }
        });
        btnIsiSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), IsiSaldoActivity.class);
                startActivity(i);
            }
        });
        TextViewMyriad btnPaketSedia = (TextViewMyriad)findViewById(R.id.btn_paketsedia);
        btnPaketSedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PaketSediaActivity.class);
                startActivity(i);
            }
        });
        btnTanyaTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TanyaTutorActivity.class);
                startActivity(i);
            }
        });
        btnKomunitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), KomunitasActivity.class);
                startActivity(i);
            }
        });
        TextView bckbtn = (TextView)findViewById(R.id.toolbar_back_btn);
        bckbtn.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {

        if (drawerFragment.isDrawerOpen()) {

            drawerFragment.closeDrawer();

        } else {

            if (isDoubleBackToExit) {
                super.onBackPressed();
                finish();
            }
            if (!isDoubleBackToExit) {
                Toast.makeText(this, getString(R.string.tap_exit), Toast.LENGTH_SHORT).show();
            }
            this.isDoubleBackToExit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    isDoubleBackToExit = false;
                }
            }, 2000); //delay 2 detik
        }
    }
}
