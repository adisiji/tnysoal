package nb.scode.tanyasoal;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import nb.scode.tanyasoal.baseAct.BaseActivity;

public class HomePageActivity extends BaseActivity {

    private Boolean isDoubleBackToExit=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        ButterKnife.bind(this);
        isHome = true;
        getBackToolbar().setVisibility(View.GONE);
    }

    @OnClick(R.id.btn_paketsedia)
    void paketSedia(){
        Intent i = new Intent(getApplicationContext(), PaketSediaActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.btn_tny_tutor)
    void tanyaTutor(){
        Intent i = new Intent(getApplicationContext(),LayananTanyaTutorAct.class);
        startActivity(i);
    }

    @OnClick(R.id.btn_komunitas)
    void keKomunitas(){
        Intent i = new Intent(getApplicationContext(), KomunitasActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.btn_isiSaldo)
    void isiSaldo(){
        Intent i = new Intent(getApplicationContext(), IsiSaldoActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.cat_aktivitas_home)
    void catAktivitas(){
        Intent i = new Intent(getApplicationContext(), LogUserActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {

        if (drawerFragment.isDrawerOpen()) {

            drawerFragment.closeDrawer();

        } else {

            if (isDoubleBackToExit) {
                super.onBackPressed();
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
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
