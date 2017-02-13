package nb.scode.tanyasoal.baseAct;

/**
 * Created by User on 1/11/2017.
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import custom_font.TextViewApple;
import nb.scode.tanyasoal.LoginActivity;
import nb.scode.tanyasoal.R;
import nb.scode.tanyasoal.util.SavedUser;

/**
 * Created by User on 12/24/2016.
 */

public class BaseFirstActivity extends AppCompatActivity implements FragDrawer2.FragmentDrawerListener {

    @BindView(R.id.btn_mail_toolbar) ImageView mail;
    @BindView(R.id.pict_profile_toolbar) ImageView profile;
    @BindView(R.id.toolbar_back_btn) TextViewApple btnBack;

    protected FragDrawer2 drawerFragment;
    protected ProgressDialog mDialog = null;
    protected boolean isHome = false;
    protected boolean isBack = false;

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    @Override
    public void setContentView(int layoutResID)
    {
        DrawerLayout fullView = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_first_base, null);
        FrameLayout activityContainer = (FrameLayout) fullView.findViewById(R.id.activity_content);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);
        super.setContentView(fullView);
        ButterKnife.bind(this,fullView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerFragment = (FragDrawer2) getFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);
        toolbar.setTitle("");
        if(mDialog == null) {
            mDialog = new ProgressDialog(this);
            mDialog.setMessage("Please wait...");
            mDialog.setCancelable(false);
        }
    }

    private void displayView(int pos){
        switch (pos) {
            case 0: { //home
                if (!isHome && !isBack)
                {
                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(i);
                }
                else if(isBack)
                    onBackPressed();
                break;
            }
            case 1: { //layanan kami
                break;
            }
            case 2:{ //syllabus
                break;
            }
            case 3: { //FAQ
                break;
            }
            case 4: { //Tentang kami
                break;
            }
        }
    }

    @OnClick(R.id.toolbar_back_btn)
    void back(){
        onBackPressed();
    }

    protected boolean getToolbar(){
        return true;
    }

    protected ImageView getMail(){
        return mail;
    }

    protected ImageView getProfile() {
        return profile;
    }

    protected TextViewApple getBack() {
        return btnBack;
    }

}