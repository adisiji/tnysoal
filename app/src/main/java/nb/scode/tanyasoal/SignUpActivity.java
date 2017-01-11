package nb.scode.tanyasoal;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jaredrummler.materialspinner.MaterialSpinner;

import nb.scode.tanyasoal.baseAct.BaseFirstAct;

public class SignUpActivity extends BaseFirstAct {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        MaterialSpinner spinJenAkad = (MaterialSpinner) findViewById(R.id.txt_create_jenakad);
        spinJenAkad.setItems(getResources().getStringArray(R.array.jns_akademik_array));

        MaterialSpinner spinTktAkad = (MaterialSpinner) findViewById(R.id.spin_tingkat_akad);
        spinTktAkad.setItems(getResources().getStringArray(R.array.tkt_akademik_array));

        getMail().setVisibility(View.GONE);
    }

    @Override
    protected boolean getToolbar(){
        return false;
    }
}
