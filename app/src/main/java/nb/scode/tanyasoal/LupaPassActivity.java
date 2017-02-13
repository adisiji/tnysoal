package nb.scode.tanyasoal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import custom_font.EditTextMyriad;
import nb.scode.tanyasoal.app.App;
import nb.scode.tanyasoal.baseAct.BaseFirstActivity;
import nb.scode.tanyasoal.modelRetro.BaseApiResponse;
import nb.scode.tanyasoal.util.Helper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LupaPassActivity extends BaseFirstActivity {

    @BindView(R.id.txt_lp_email) EditTextMyriad et_email;
    @BindView(R.id.txt_lp_nama_lkp) EditTextMyriad et_first_name;
    @BindView(R.id.txt_lp_no_hp) EditTextMyriad et_hp;
    @BindView(R.id.lp_tgl_lhr) EditTextMyriad et_tlh;

    private Helper helper;
    
    String email, first_name, phone, bod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_pass);
        ButterKnife.bind(this);
        isBack = true;
        helper = new Helper();
        et_tlh.addTextChangedListener(helper.tw(et_tlh));
    }

    @OnClick(R.id.btn_kirim_sandi)
    void kirimSandi(){
        getData();
        if(verifyForm()){
            Call<BaseApiResponse> call =  App.getInstance().getApi()
                    .forgotpwd(email,first_name, phone, bod);
            call.enqueue(new Callback<BaseApiResponse>() {
                @Override
                public void onResponse(Call<BaseApiResponse> call, Response<BaseApiResponse> response) {
                    if(response.body().getSuccess()){
                        Intent i = new Intent(LupaPassActivity.this, GantiPassActivity.class);
                        i.putExtra("email",email);
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),response.body().getMessage(),Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<BaseApiResponse> call, Throwable t) {

                }
            });
        }
        else
        {
            mDialog.dismiss();
        }

    }

    @Override
    protected boolean getToolbar(){
        return false;
    }

    private void getData(){
        email = et_email.getText().toString();
        first_name = et_first_name.getText().toString();
        phone = et_hp.getText().toString();
        bod = et_tlh.getText().toString();
        mDialog.show();
    }
    
    private boolean verifyForm(){
        et_email.setError(null);
        et_first_name.setError(null);
        et_hp.setError(null);
        et_tlh.setError(null);

        if (email.length() == 0) {

            et_email.setError(getString(R.string.error_field_empty));

            return false;
        }

        if (!helper.isValidEmail(email)) {

            et_email.setError(getString(R.string.error_wrong_format));

            return false;
        }

        if (first_name.length() == 0) {

            et_first_name.setError(getString(R.string.error_field_empty));

            return false;
        }

        if (first_name.length() < 2) {

            et_first_name.setError(getString(R.string.error_min_2_char));

            return false;
        }

        if(phone.length() == 0){
            et_hp.setError(getString(R.string.error_field_empty));

            return false;
        }

        if(!helper.isValidPhone(phone)) {
            et_hp.setError(getString(R.string.error_wrong_format));

            return false;

        }

        if(bod.length() == 0){
            et_tlh.setError(getString(R.string.error_field_empty));

            return false;
        }

        return true;
    }
}