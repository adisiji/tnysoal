package nb.scode.tanyasoal;

import android.os.Bundle;

import butterknife.BindView;
import butterknife.OnClick;
import custom_font.EditTextMyriad;
import custom_font.TextViewMyriad;
import nb.scode.tanyasoal.baseAct.BaseActivity;

public class IsiVoucherActivity extends BaseActivity {

    @BindView(R.id.ed_kode_voucher) EditTextMyriad editTextVoucher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_voucher);
    }

    @OnClick(R.id.btn_kirim_voucher)
    void kirimVoucher(){

    }

    @OnClick(R.id.btn_batal_voucher)
    void batalVoucher(){

    }
}
