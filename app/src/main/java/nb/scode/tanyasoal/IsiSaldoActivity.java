package nb.scode.tanyasoal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import nb.scode.tanyasoal.baseAct.BaseActivity;

public class IsiSaldoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_saldo);

        FrameLayout btnTrfBank = (FrameLayout)findViewById(R.id.btn_trf_atm);
        FrameLayout btnInetBank = (FrameLayout)findViewById(R.id.btn_inetbank);
        FrameLayout btnVoucher = (FrameLayout)findViewById(R.id.btn_voucher);
        btnTrfBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), TrfAtmActivity.class);
                startActivity(i);
            }
        });
        btnInetBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), InetBankingActivity.class);
                startActivity(i);
            }
        });
        btnVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (getApplicationContext(), IsiVoucherActivity.class);
                startActivity(i);
            }
        });
    }
}
