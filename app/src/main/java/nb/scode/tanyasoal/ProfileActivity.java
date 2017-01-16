package nb.scode.tanyasoal;

import android.content.Intent;
import android.os.Bundle;

import com.jaredrummler.materialspinner.MaterialSpinner;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import custom_font.EditTextMyriad;
import nb.scode.tanyasoal.baseAct.BaseActivity;

public class ProfileActivity extends BaseActivity {

    @BindView(R.id.txt_ed_name) EditTextMyriad namalkp;
    @BindView(R.id.txt_ed_nama_tampil) EditTextMyriad namatmp;
    @BindView(R.id.txt_ganti_pass) EditTextMyriad gantipass;
    @BindView(R.id.txt_ed_confpass) EditTextMyriad konfpass;
    @BindView(R.id.txt_ed_sekolah) EditTextMyriad sekolah;
    @BindView(R.id.txt_nama_lkp) EditTextMyriad namalkp2;
    @BindView(R.id.txt_no_hp) EditTextMyriad hp;
    @BindView(R.id.ed_tgl_lhr) EditTextMyriad tlh;
    @BindView(R.id.txt_create_jenakad) MaterialSpinner spinJenAkad;
    @BindView(R.id.spin_tingkat_akad) MaterialSpinner spinTktAkad;

    @BindArray(R.array.jns_akademik_array) String[] jnsAkademik;
    @BindArray(R.array.tkt_akademik_array) String[] tktAkademik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        spinJenAkad.setItems(jnsAkademik);
        spinTktAkad.setItems(tktAkademik);
        final String dummyText = getResources().getString(R.string.abc);
        setDummyText(dummyText);
    }

    @OnClick(R.id.cat_aktivitas_profile)
    void lihatCat(){
        Intent i = new Intent(getApplicationContext(), LogUserActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.btn_kembali)
    void back(){
        onBackPressed();
    }

    private void setDummyText(String dt){
        namalkp.setText(dt);
        namatmp.setText(dt);
        gantipass.setText(dt);
        konfpass.setText(dt);
        sekolah.setText("SMA Negeri 1 Jakarta");
        namalkp2.setText(dt);
        hp.setText("1234567");
        tlh.setText("1/1/2016");
    }

    @Override
    protected boolean getToolbar(){
        return false;
    }

}
