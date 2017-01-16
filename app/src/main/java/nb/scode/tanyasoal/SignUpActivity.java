package nb.scode.tanyasoal;

import android.os.Bundle;
import android.view.View;

import com.jaredrummler.materialspinner.MaterialSpinner;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import nb.scode.tanyasoal.baseAct.BaseFirstActivity;

public class SignUpActivity extends BaseFirstActivity {

    @BindView(R.id.txt_create_jenakad) MaterialSpinner spinJenAkad;
    @BindView(R.id.spin_tingkat_akad) MaterialSpinner spinTktAkad;

    @BindArray(R.array.jns_akademik_array) String[] jnsAkademik;
    @BindArray(R.array.tkt_akademik_array) String[] tktAkademik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        spinJenAkad.setItems(jnsAkademik);
        spinTktAkad.setItems(tktAkademik);
        getMail().setVisibility(View.GONE);
    }

    @Override
    protected boolean getToolbar(){
        return false;
    }
}