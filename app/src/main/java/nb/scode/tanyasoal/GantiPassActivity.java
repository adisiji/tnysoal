package nb.scode.tanyasoal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.BindString;
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

public class GantiPassActivity extends BaseFirstActivity {

    @BindView(R.id.txt_create_password)
    EditTextMyriad et_pass;
    @BindView(R.id.txt_create_confpass)
    EditTextMyriad et_conf_pass;
    @BindString(R.string.error_password_match)
    String errorPass;

    private String email="",pass="",confpass="";
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganti_pass);
        ButterKnife.bind(this);
        email = getIntent().getStringExtra("email");
    }

    @OnClick(R.id.btn_simpan)
    void changePass(){
        getData();
        if(validForm()){
            Call<BaseApiResponse> call = App.getInstance().getApi().resetpwd(email,pass,confpass);
            call.enqueue(new Callback<BaseApiResponse>() {
                @Override
                public void onResponse(Call<BaseApiResponse> call, Response<BaseApiResponse> response) {
                    if(response.body().getSuccess()){
                        Intent i = new Intent(GantiPassActivity.this, LoginActivity.class);
                        startActivity(i);
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),response.body().getMessage(),Toast.LENGTH_LONG).show();
                    }
                    mDialog.dismiss();
                }

                @Override
                public void onFailure(Call<BaseApiResponse> call, Throwable t) {
                    mDialog.dismiss();
                }
            });
        }
    }

    private void getData(){
        pass = et_pass.getText().toString();
        confpass = et_conf_pass.getText().toString();
        if(mDialog == null) {
            mDialog = new ProgressDialog(this);
            mDialog.setMessage("Please wait...");
            mDialog.setCancelable(false);
        }
        mDialog.show();
    }

    public boolean validForm(){
        Helper helper = new Helper();

        if (pass.length() == 0) {

            et_pass.setError(getString(R.string.error_field_empty));

            return false;
        }

        if (pass.length() < 6) {

            et_pass.setError(getString(R.string.error_min_6_char));

            return false;
        }

        if (!helper.isValidPassword(pass)) {

            et_pass.setError(getString(R.string.error_wrong_format));

            return false;
        }

        if(!pass.equals(confpass)){

            et_conf_pass.setError(errorPass);

            return false;
        }

        return true;
    }

    @Override
    protected boolean getToolbar(){
        return false;
    }
}
