package nb.scode.tanyasoal;

import android.os.Bundle;

import nb.scode.tanyasoal.baseAct.BaseActivity;

public class PaketSediaActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paket_sedia);
        isBack = true;
    }
}
