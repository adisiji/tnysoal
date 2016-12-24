package nb.scode.tanyasoal;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import nb.scode.tanyasoal.baseAct.BaseActivity;

public class TanyaTutorActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanya_tutor);

        TextView bckbtn = (TextView)findViewById(R.id.toolbar_back_btn);
        bckbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}