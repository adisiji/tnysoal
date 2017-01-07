package nb.scode.tanyasoal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import nb.scode.tanyasoal.baseAct.BaseActivity;

public class KomunitasActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komunitas);
        FrameLayout btnFreeForum = (FrameLayout) findViewById(R.id.btn_fforum);
        btnFreeForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), FreeForumActivity.class);
                startActivity(i);
            }
        });
    }
}
