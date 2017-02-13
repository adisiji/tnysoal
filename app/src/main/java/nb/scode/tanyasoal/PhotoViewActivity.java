package nb.scode.tanyasoal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoViewAttacher;

public class PhotoViewActivity extends AppCompatActivity {


    private static final String TAG = "photo_view_activity";

    @BindView(R.id.photoImageView) ImageView photoView;
    @BindView(R.id.PhotoViewContentScreen) RelativeLayout mContentScreen;
    @BindView(R.id.PhotoViewLoadingScreen) RelativeLayout mLoadingScreen;
    Bitmap bmp;
    PhotoViewAttacher mAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        ButterKnife.bind(this);
        Intent intent = this.getIntent();
        bmp = intent.getParcelableExtra("pict");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setElevation(0);
//
//        toolbar.getBackground().setAlpha(100);
        getSupportActionBar().setTitle("");
        showLoadingScreen();
        photoView.setImageBitmap(bmp);
        mAttacher = new PhotoViewAttacher(photoView);
        showContentScreen();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {

            case android.R.id.home: {

                finish();
                return true;
            }

            default: {

                return super.onOptionsItemSelected(item);
            }
        }
    }


    public void showLoadingScreen() {

        mContentScreen.setVisibility(View.GONE);
        mLoadingScreen.setVisibility(View.VISIBLE);
    }

    public void showContentScreen() {

        mLoadingScreen.setVisibility(View.GONE);
        mContentScreen.setVisibility(View.VISIBLE);
    }
}
