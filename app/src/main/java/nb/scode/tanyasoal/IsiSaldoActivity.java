package nb.scode.tanyasoal;

import android.content.Intent;
import android.os.Bundle;

import com.andexert.library.RippleView;

import nb.scode.tanyasoal.baseAct.BaseActivity;

public class IsiSaldoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_saldo);

        RippleView btnTrfBank = (RippleView)findViewById(R.id.btn_trf_atm);
        RippleView btnInetBank = (RippleView)findViewById(R.id.btn_inetbank);
        RippleView btnVoucher = (RippleView)findViewById(R.id.btn_voucher);
        btnTrfBank.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Intent i = new Intent(getApplicationContext(), TrfAtmActivity.class);
                startActivity(i);
            }
        });
        btnInetBank.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Intent i = new Intent(getApplicationContext(), InetBankingActivity.class);
                startActivity(i);
            }
        });
        btnVoucher.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Intent i = new Intent (getApplicationContext(), IsiVoucherActivity.class);
                startActivity(i);
            }
        });
    }
}
