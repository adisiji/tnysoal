package nb.scode.tanyasoal;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;

import org.json.JSONObject;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import custom_font.EditTextMyriad;
import nb.scode.tanyasoal.app.App;
import nb.scode.tanyasoal.baseAct.BaseFirstActivity;
import nb.scode.tanyasoal.modelRetro.BaseApiResponse;
import nb.scode.tanyasoal.models.AcademicLevels;
import nb.scode.tanyasoal.models.AcademicTypes;
import nb.scode.tanyasoal.util.Helper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends BaseFirstActivity {

    @BindView(R.id.txt_create_jenakad)
    MaterialSpinner spinJenAkad;
    @BindView(R.id.spin_tingkat_akad)
    MaterialSpinner spinTktAkad;
    @BindView(R.id.txt_create_email)
    EditTextMyriad tv_email;
    @BindView(R.id.txt_create_nama)
    EditTextMyriad tv_nama;
    @BindView(R.id.txt_create_password)
    EditTextMyriad tv_pass;
    @BindView(R.id.txt_create_confpass)
    EditTextMyriad tv_confpass;
    @BindView(R.id.txt_create_sekolah)
    EditTextMyriad tv_sekolah;
    @BindView(R.id.txt_kd_promo)
    EditTextMyriad tv_promo;
    @BindView(R.id.txt_nama_lkp)
    EditTextMyriad tv_nama_lkp;
    @BindView(R.id.txt_no_hp)
    EditTextMyriad tv_no_hp;
    @BindView(R.id.daftar_tgl_lhr)
    EditTextMyriad tv_tgl;

    @BindString(R.string.error_email_taken)
    String emailTaken;
    @BindString(R.string.error_login_taken)
    String nameTaken;
    @BindString(R.string.error_field_empty)
    String emptyfield;

    private String nama, email, pass, confpass, sekolah, promo, namalkp, hp;
    private String tgl, bln, thn;
    private ProgressDialog mDialog = null;
    private int jenakad, tktakad;

    private Helper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        isBack = true;
        helper = new Helper();
        List<AcademicTypes> jnsAkademik = App.getInstance().getJnsAkademik();
        List<AcademicLevels> tktAkademik = App.getInstance().getTktAkademik();
        if(!jnsAkademik.isEmpty() && !tktAkademik.isEmpty()){
            spinJenAkad.setItems(jnsAkademik);
            spinTktAkad.setItems(tktAkademik);
        }
        tv_tgl.addTextChangedListener(helper.tw(tv_tgl));
        getMail().setVisibility(View.GONE);
    }

    private void getData(){
        email = tv_email.getText().toString();
        nama = tv_nama.getText().toString();
        pass = tv_pass.getText().toString();
        confpass = tv_confpass.getText().toString();
        jenakad = spinJenAkad.getSelectedIndex();
        tktakad = spinTktAkad.getSelectedIndex();
        sekolah = tv_sekolah.getText().toString();
        promo = tv_promo.getText().toString();
        namalkp = tv_nama_lkp.getText().toString();
        hp = tv_no_hp.getText().toString();
        tgl = tv_tgl.getText().toString();
        if(mDialog==null){
            mDialog = new ProgressDialog(this);
            mDialog.setMessage("Please wait...");
            mDialog.setCancelable(false);
        }
        mDialog.show();
    }

    @Override
    protected boolean getToolbar(){
        return false;
    }

    @OnClick(R.id.btn_daftar)
    void daftar(){
        getData();
        if(verifyRegForm()) {
            Call<BaseApiResponse> call = App.getInstance().getApi().signUp(email, nama, pass,
                    jenakad, tktakad, promo, sekolah,
                    namalkp, hp, tgl);
            call.enqueue(new Callback<BaseApiResponse>() {
                @Override
                public void onResponse(Call<BaseApiResponse> call, Response<BaseApiResponse> response) {
                    if(response.body().getSuccess()){
                        //TODO: go to tutor / siswa
                    }
                    else {
                        Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                    mDialog.dismiss();
                }

                @Override
                public void onFailure(Call<BaseApiResponse> call, Throwable t) {
                    t.printStackTrace();
                    mDialog.dismiss();
                }
            });

        }
        else {
            mDialog.dismiss();
            Toast.makeText(this, "Please fill the field", Toast.LENGTH_SHORT).show();
        }

    }

    public Boolean verifyRegForm() {

        tv_nama.setError(null);
        tv_nama_lkp.setError(null);
        tv_pass.setError(null);
        tv_confpass.setError(null);
        tv_email.setError(null);
        tv_sekolah.setError(null);
        tv_no_hp.setError(null);

        if (email.length() == 0) {

            tv_email.setError(emptyfield);

            return false;
        }

        if (!helper.isValidEmail(email)) {

            tv_email.setError(getString(R.string.error_wrong_format));

            return false;
        }

        if (nama.length() == 0) {

            tv_nama.setError(emptyfield);

            return false;
        }

        if (nama.length() < 5) {

            tv_nama.setError(getString(R.string.error_min_5_char));

            return false;
        }

        if (!helper.isValidLogin(nama)) {

            tv_nama.setError(getString(R.string.error_wrong_format));

            return false;
        }

        if (pass.length() == 0) {

            tv_pass.setError(emptyfield);

            return false;
        }

        if (pass.length() < 6) {

            tv_pass.setError(getString(R.string.error_min_6_char));

            return false;
        }

        if (!helper.isValidPassword(pass)) {

            tv_pass.setError(getString(R.string.error_wrong_format));

            return false;
        }

        if(sekolah.length()==0){
            tv_sekolah.setError(emptyfield);

            return false;

        }

        if(sekolah.length() < 5 ) {
            tv_sekolah.setError(getString(R.string.error_min_5_char));

            return false;
        }

        if (namalkp.length() == 0) {

            tv_nama_lkp.setError(emptyfield);

            return false;
        }

        if (namalkp.length() < 2) {

            tv_nama_lkp.setError(getString(R.string.error_min_2_char));

            return false;
        }

        if(hp.length()==0){

            tv_no_hp.setError(emptyfield);

            return false;
        }

        if(!helper.isValidPhone(hp)) {

            tv_no_hp.setError(getString(R.string.error_phone));

            return false;
        }

        return true;
    }

}