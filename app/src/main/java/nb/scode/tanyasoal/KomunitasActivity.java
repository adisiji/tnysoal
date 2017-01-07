package nb.scode.tanyasoal;

import android.content.Intent;
import android.os.Bundle;

import com.andexert.library.RippleView;

import nb.scode.tanyasoal.baseAct.BaseActivity;

public class KomunitasActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komunitas);
        RippleView btnFreeForum = (RippleView)findViewById(R.id.btn_fforum);
        btnFreeForum.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Intent i = new Intent(getApplicationContext(), FreeForumActivity.class);
                startActivity(i);
            }
        });
    }
}
