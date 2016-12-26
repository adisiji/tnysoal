package nb.scode.tanyasoal.baseAct;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import custom_font.TextViewApple;
import nb.scode.tanyasoal.ProfileActivity;
import nb.scode.tanyasoal.R;

/**
 * Created by User on 12/24/2016.
 */

public class BaseActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    protected FragmentDrawer drawerFragment;

    @Override
    public void onDrawerItemSelected(View view, int position) {
        Log.d("Click Drawer","U Click "+position);
    }

    @Override
    public void setContentView(int layoutResID)
    {
        DrawerLayout fullView = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        FrameLayout activityContainer = (FrameLayout) fullView.findViewById(R.id.activity_content);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);
        super.setContentView(fullView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerFragment = (FragmentDrawer) getFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);
        toolbar.setTitle("");
        TextViewApple btnBack = (TextViewApple)findViewById(R.id.toolbar_back_btn);
        ImageView profile = (ImageView)findViewById(R.id.pict_profile_toolbar);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(i);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

}
