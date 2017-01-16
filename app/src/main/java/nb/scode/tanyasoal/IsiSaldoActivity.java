package nb.scode.tanyasoal;

import android.content.Intent;
import android.os.Bundle;

import butterknife.OnClick;
import nb.scode.tanyasoal.baseAct.BaseActivity;

public class IsiSaldoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_saldo);

    }

    @OnClick(R.id.btn_trf_atm)
    void viaTransfer(){
        Intent i = new Intent(getApplicationContext(), TrfAtmActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.btn_inetbank)
    void viaIBanking(){
        Intent i = new Intent(getApplicationContext(), InetBankingActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.btn_voucher)
    void viaVoucher(){
        Intent i = new Intent (getApplicationContext(), IsiVoucherActivity.class);
        startActivity(i);
    }
}
