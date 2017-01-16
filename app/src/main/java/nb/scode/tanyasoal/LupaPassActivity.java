package nb.scode.tanyasoal;

import android.content.Intent;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import custom_font.EditTextMyriad;
import nb.scode.tanyasoal.baseAct.BaseFirstActivity;

public class LupaPassActivity extends BaseFirstActivity {

    @BindView(R.id.txt_lp_email) EditTextMyriad email;
    @BindView(R.id.txt_lp_nama_lkp) EditTextMyriad namalkp;
    @BindView(R.id.txt_lp_no_hp) EditTextMyriad hp;
    @BindView(R.id.lp_tgl_lhr) EditTextMyriad tlh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_pass);
        ButterKnife.bind(this);
        final String dummyText = getResources().getString(R.string.abc);
        setDummy(dummyText);
    }

    @OnClick(R.id.btn_kirim_sandi)
    void kirimSandi(){
        Intent i = new Intent(getApplicationContext(), GantiPassActivity.class);
        startActivity(i);
    }

    @Override
    protected boolean getToolbar(){
        return false;
    }

    private void setDummy(String dt){
        email.setText(dt+"@gmail.com");
        namalkp.setText(dt);
        hp.setText("1234567");
        tlh.setText("1/1/2016");
    }
}