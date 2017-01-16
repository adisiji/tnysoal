package nb.scode.tanyasoal.baseAct;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import custom_font.TextViewApple;
import nb.scode.tanyasoal.ProfileActivity;
import nb.scode.tanyasoal.R;

/**
 * Created by User on 12/24/2016.
 */

public class BaseActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.btn_mail_toolbar) ImageView mail;
    @BindView(R.id.toolbar_back_btn) TextViewApple btnBack;
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
        ButterKnife.bind(this,fullView);
        drawerFragment = (FragmentDrawer) getFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        setSupportActionBar(toolbar);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);
        toolbar.setTitle("");

    }

    @OnClick(R.id.toolbar_back_btn)
    void back(){
        onBackPressed();
    }

    @OnClick(R.id.pict_profile_toolbar)
    public void showProfile(){
        if(getToolbar()){
            Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivity(i);
        }
    }

    protected TextView getBackToolbar() {
        return btnBack;
    }

    protected boolean getToolbar(){
        return true;
    }

    protected ImageView getMail(){
        return mail;
    }

}