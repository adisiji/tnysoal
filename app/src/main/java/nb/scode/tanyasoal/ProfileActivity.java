package nb.scode.tanyasoal;

import android.os.Bundle;
import android.view.View;

import com.jaredrummler.materialspinner.MaterialSpinner;

import custom_font.MyEditText;
import custom_font.TextViewMyriad;
import nb.scode.tanyasoal.baseAct.BaseActivity;

public class ProfileActivity extends BaseActivity {

    private MyEditText namalkp,namatmp,gantipass,konfpass, sekolah, namalkp2, hp, tlh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        MaterialSpinner spinJenAkad = (MaterialSpinner) findViewById(R.id.txt_create_jenakad);
        spinJenAkad.setItems(getResources().getStringArray(R.array.jns_akademik_array));

        MaterialSpinner spinTktAkad = (MaterialSpinner) findViewById(R.id.spin_tingkat_akad);
        spinTktAkad.setItems(getResources().getStringArray(R.array.tkt_akademik_array));
        final String dummyText = getResources().getString(R.string.abc);
        namalkp = (MyEditText)findViewById(R.id.txt_ed_name);
        namatmp = (MyEditText)findViewById(R.id.txt_ed_nama_tampil);
        gantipass = (MyEditText) findViewById(R.id.txt_ganti_pass);
        konfpass = (MyEditText)findViewById(R.id.txt_ed_confpass);
        sekolah = (MyEditText)findViewById(R.id.txt_ed_sekolah);
        namalkp2 = (MyEditText)findViewById(R.id.txt_nama_lkp);
        hp = (MyEditText)findViewById(R.id.txt_no_hp);
        tlh = (MyEditText)findViewById(R.id.ed_tgl_lhr);
        setDummyText(dummyText);

        TextViewMyriad kembali = (TextViewMyriad)findViewById(R.id.btn_kembali);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

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
