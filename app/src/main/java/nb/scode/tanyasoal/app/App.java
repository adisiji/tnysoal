package nb.scode.tanyasoal.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.crashlytics.android.Crashlytics;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.fabric.sdk.android.Fabric;
import nb.scode.tanyasoal.R;
import nb.scode.tanyasoal.baseAct.BaseActivity;
import nb.scode.tanyasoal.common.ApiLink;
import nb.scode.tanyasoal.models.AcademicLevels;
import nb.scode.tanyasoal.models.AcademicTypes;
import nb.scode.tanyasoal.models.Academics;
import nb.scode.tanyasoal.network.IApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by neobyte on 1/25/2017.
 */

public class App extends Application {

    private static App mInstance;
    private SharedPreferences sharedPref;
    private String username, fullname, accessToken, gcmToken;
    private int errorCode, state;
    private long id;
    private Retrofit retrofit = null;
    private IApi api = null;
    private String BASE_URL = ApiLink.API_DOMAIN + "api/" + ApiLink.API_VERSION + "/method";
    private List<AcademicTypes> jnsAkademik = new ArrayList<>();
    private List<AcademicLevels> tktAkademik = new ArrayList<>();

    @Override
    public void onCreate(){
        super.onCreate();

        Fabric.with(this, new Crashlytics());
        mInstance = this;
        sharedPref = this.getSharedPreferences(getString(R.string.settings_file), Context.MODE_PRIVATE);
        this.readData();
    }

    public static synchronized App getInstance(){
        return mInstance;
    }

    private Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public IApi getApi(){
        if(api == null) {
            api = getClient().create(IApi.class);
        }
        return api;
    }

    private void initAcademic(){
        Call<Academics> academicsCall = getApi().getAcademics();
        academicsCall.enqueue(new Callback<Academics>() {
            @Override
            public void onResponse(Call<Academics> call, Response<Academics> response) {
                Academics academics = response.body();
                setJnsAkademik(academics.getAcademicTypeList());
                setTktAkademik(academics.getAcademicLevelList());
            }

            @Override
            public void onFailure(Call<Academics> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public List<AcademicTypes> getJnsAkademik() {
        Log.d("Calling","getAPI");
        if(jnsAkademik.isEmpty())
            initAcademic();
        return jnsAkademik;
    }

    private void setJnsAkademik(List<AcademicTypes> jnsAkademik) {
        this.jnsAkademik = jnsAkademik;
    }

    public List<AcademicLevels> getTktAkademik() {
        if(tktAkademik.isEmpty())
            initAcademic();
        return tktAkademik;
    }

    private void setTktAkademik(List<AcademicLevels> tktAkademik) {
        this.tktAkademik = tktAkademik;
    }

    public long getId() {

        return this.id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public void setGcmToken(final String gcmToken) {

        this.gcmToken = gcmToken;
    }

    public String getGcmToken(){
        return gcmToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void readData() {

        this.setId(sharedPref.getLong(getString(R.string.settings_account_id), 0));
        this.setUsername(sharedPref.getString(getString(R.string.settings_account_username), ""));
        this.setAccessToken(sharedPref.getString(getString(R.string.settings_account_access_token), ""));
    }

    public void saveData() {

        sharedPref.edit().putLong(getString(R.string.settings_account_id), this.getId()).apply();
        sharedPref.edit().putString(getString(R.string.settings_account_username), this.getUsername()).apply();
        sharedPref.edit().putString(getString(R.string.settings_account_access_token), this.getAccessToken()).apply();
    }

    public void removeData() {

        sharedPref.edit().putLong(getString(R.string.settings_account_id), 0).apply();
        sharedPref.edit().putString(getString(R.string.settings_account_username), "").apply();
        sharedPref.edit().putString(getString(R.string.settings_account_access_token), "").apply();
    }
}
