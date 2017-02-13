package nb.scode.tanyasoal;

import android.content.Intent;
import android.os.Bundle;

import butterknife.OnClick;
import nb.scode.tanyasoal.baseAct.BaseActivity;

public class KomunitasActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komunitas);
        isBack = true;
    }

    @OnClick(R.id.btn_fforum)
    void FreeForum(){
        Intent i = new Intent(getApplicationContext(), FreeForumActivity.class);
        startActivity(i);
    }
}
