package nb.scode.tanyasoal;

import android.os.Bundle;

import nb.scode.tanyasoal.baseAct.BaseFirstActivity;

public class GantiPassActivity extends BaseFirstActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganti_pass);
    }

    @Override
    protected boolean getToolbar(){
        return false;
    }
}
