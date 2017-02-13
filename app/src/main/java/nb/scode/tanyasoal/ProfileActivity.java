package nb.scode.tanyasoal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;

import org.json.JSONObject;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import custom_font.EditTextMyriad;
import nb.scode.tanyasoal.app.App;
import nb.scode.tanyasoal.baseAct.BaseActivity;
import nb.scode.tanyasoal.modelRetro.BaseApiResponse;
import nb.scode.tanyasoal.models.AcademicLevels;
import nb.scode.tanyasoal.models.AcademicTypes;
import nb.scode.tanyasoal.util.Helper;
import nb.scode.tanyasoal.util.SavedUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends BaseActivity {

    @BindView(R.id.txt_ed_name) EditTextMyriad et_namalkp;
    @BindView(R.id.txt_ed_nama_tampil) EditTextMyriad et_username;
    @BindView(R.id.txt_ganti_pass) EditTextMyriad et_gantipass;
    @BindView(R.id.txt_ed_confpass) EditTextMyriad et_konfpass;
    @BindView(R.id.txt_ed_sekolah) EditTextMyriad et_sekolah;
    @BindView(R.id.txt_nama_lkp) EditTextMyriad et_fullname;
    @BindView(R.id.txt_no_hp) EditTextMyriad et_hp;
    @BindView(R.id.ed_tgl_lhr) EditTextMyriad et_tlh;
    @BindView(R.id.txt_create_jenakad) MaterialSpinner spinJenAkad;
    @BindView(R.id.spin_tingkat_akad) MaterialSpinner spinTktAkad;
    @BindViews({R.id.root_jnsAkad,R.id.root_sekolah,R.id.root_tktAkad})
    List<LinearLayout> layoutList;
    @BindViews({R.id.cat_aktivitas_profile,R.id.header_profile })
    List<TextView> textViewHeader;
    
    @BindString(R.string.error_field_empty)
    String emptyfield;
    @BindString(R.string.failed_profile_edit)
    String failedEdit;
    @BindString(R.string.success_profile_edit)
    String successEdit;
    
    private String username, email, pass, confpass, sekolah, nama, fullnameb, hp, bod;
    private int jenakad, tktakad;
    private Helper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        helper = new Helper();
        List<AcademicTypes> jnsAkademik = App.getInstance().getJnsAkademik();
        List<AcademicLevels> tktAkademik = App.getInstance().getTktAkademik();
        if(!jnsAkademik.isEmpty() && !tktAkademik.isEmpty()){
            spinJenAkad.setItems(jnsAkademik);
            spinTktAkad.setItems(tktAkademik);
        }
        et_tlh.addTextChangedListener(helper.tw(et_tlh));
        String mode = SavedUser.getUser(getApplicationContext());
        if(mode.equals("tutor")){
            ButterKnife.apply(layoutList, DISABLE);
            ButterKnife.apply(textViewHeader, DISABLE);
        }
    }

    static final ButterKnife.Action<View> DISABLE = new ButterKnife.Action<View>() {
        @Override public void apply(final View view, int index) {
            view.setVisibility(View.GONE);
        }
    };

    @OnClick(R.id.cat_aktivitas_profile)
    void lihatCat(){
        Intent i = new Intent(getApplicationContext(), LogUserActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.btn_simpan)
    void simpan(){
        getData();
        if(verifyForm()){
            Call<BaseApiResponse> call = App.getInstance().getApi().setProfile(
                    App.getInstance().getAccessToken(),email,username,hp,bod,jenakad,tktakad,sekolah);
            call.enqueue(new Callback<BaseApiResponse>() {
                @Override
                public void onResponse(Call<BaseApiResponse> call, Response<BaseApiResponse> response) {
                    mDialog.dismiss();
                    if(response.body().getSuccess()){
                        Toast.makeText(getApplicationContext(),successEdit,Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),response.body().getMessage(),Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<BaseApiResponse> call, Throwable t) {
                    t.printStackTrace();
                    mDialog.dismiss();
                }
            });
        }
        else
            mDialog.dismiss();
    }

    @OnClick(R.id.btn_kembali)
    void back(){
        onBackPressed();
    }

    private void getData(){
        mDialog.show();
        nama = et_namalkp.getText().toString().trim();
        username = et_username.getText().toString().trim();
        pass = et_gantipass.getText().toString().trim();
        confpass = et_konfpass.getText().toString().trim();
        jenakad = spinJenAkad.getSelectedIndex();
        tktakad = spinTktAkad.getSelectedIndex();
        sekolah = et_sekolah.getText().toString().trim();
        bod = et_tlh.getText().toString().trim();
        fullnameb = et_fullname.getText().toString().trim();
        hp = et_hp.getText().toString().trim();
    }

    public Boolean verifyForm() {
        et_namalkp.setError(null);
        et_username.setError(null);
        et_gantipass.setError(null);
        et_konfpass.setError(null);
        et_sekolah.setError(null);
        et_fullname.setError(null);
        et_hp.setError(null);

        if (nama.length() == 0) {

            et_namalkp.setError(emptyfield);

            return false;
        }

        if (nama.length() < 5) {

            et_namalkp.setError(getString(R.string.error_min_5_char));

            return false;
        }

        if (username.length() == 0) {

            et_username.setError(emptyfield);

            return false;
        }

        if (username.length() < 5) {

            et_username.setError(getString(R.string.error_min_5_char));

            return false;
        }

        if (!helper.isValidLogin(username)) {

            et_namalkp.setError(getString(R.string.error_wrong_format));

            return false;
        }


        if (pass.length() == 0) {

            et_gantipass.setError(emptyfield);

            return false;
        }

        if (pass.length() < 6) {

            et_gantipass.setError(getString(R.string.error_min_6_char));

            return false;
        }

        if (!helper.isValidPassword(pass)) {

            et_gantipass.setError(getString(R.string.error_wrong_format));

            return false;
        }

        if(!pass.equals(confpass)){

            et_konfpass.setError(getString(R.string.error_password_match));

            return false;
        }
        
        if(sekolah.length()==0){
            et_sekolah.setError(emptyfield);

            return false;

        }

        if(sekolah.length() < 5 ) {
            et_sekolah.setError(getString(R.string.error_min_5_char));

            return false;
        }

        if (fullnameb.length() == 0) {

            et_fullname.setError(emptyfield);

            return false;
        }

        if (fullnameb.length() < 2) {

            et_fullname.setError(getString(R.string.error_min_2_char));

            return false;
        }
        
        if(!helper.isValidPhone(hp)) {
            
            et_hp.setError(getString(R.string.error_phone));
            
            return false;
        }
        
        return true;
    }

    @Override
    protected boolean getToolbar(){
        return false;
    }

}
