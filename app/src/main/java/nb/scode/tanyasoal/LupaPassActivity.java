package nb.scode.tanyasoal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import custom_font.EditTextMyriad;
import custom_font.TextViewMyriad;
import nb.scode.tanyasoal.baseAct.BaseActivity;

public class LupaPassActivity extends BaseActivity {

    private EditTextMyriad email, namalkp, hp, tlh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_pass);
        final String dummyText = getResources().getString(R.string.abc);
        email = (EditTextMyriad)findViewById(R.id.txt_lp_email);
        namalkp = (EditTextMyriad)findViewById(R.id.txt_lp_nama_lkp);
        hp = (EditTextMyriad)findViewById(R.id.txt_lp_no_hp);
        tlh = (EditTextMyriad)findViewById(R.id.lp_tgl_lhr);
        setDummy(dummyText);

        TextViewMyriad kirim = (TextViewMyriad)findViewById(R.id.btn_kirim_sandi);
        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), GantiPassActivity.class);
                startActivity(i);
            }
        });
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
