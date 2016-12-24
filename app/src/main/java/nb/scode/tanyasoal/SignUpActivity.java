package nb.scode.tanyasoal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;

import custom_font.TextViewMyriad;
import nb.scode.tanyasoal.baseAct.FragmentDrawer;


public class SignUpActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private TextViewMyriad signin;
    private FragmentDrawer drawerFragment;

    @Override
    public void onDrawerItemSelected(View view, int position) {

        Log.d("Click Drawer","U Click "+position);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar mToolbar = (Toolbar)findViewById(R.id.toolbar_create);
        setSupportActionBar(mToolbar);

        drawerFragment = (FragmentDrawer) getFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        TextView bckbtn = (TextView)findViewById(R.id.toolbar_back_btn);
        bckbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        MaterialSpinner spinJenAkad = (MaterialSpinner) findViewById(R.id.txt_create_jenakad);
        spinJenAkad.setItems(getResources().getStringArray(R.array.jns_akademik_array));

        MaterialSpinner spinTktAkad = (MaterialSpinner) findViewById(R.id.spin_tingkat_akad);
        spinTktAkad.setItems(getResources().getStringArray(R.array.tkt_akademik_array));

    }
}
