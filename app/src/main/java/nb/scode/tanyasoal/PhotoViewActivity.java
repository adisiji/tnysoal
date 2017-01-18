package nb.scode.tanyasoal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import nb.scode.tanyasoal.models.dumFlower;
import nb.scode.tanyasoal.network.api;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.senab.photoview.PhotoViewAttacher;

public class PhotoViewActivity extends AppCompatActivity {


    private static final String TAG = "photo_view_activity";
    private static final String urlImage = "http://services.hanselandpetal.com/photos/";

    @BindView(R.id.photoImageView) ImageView photoView;
    @BindView(R.id.PhotoViewContentScreen) RelativeLayout mContentScreen;
    @BindView(R.id.PhotoViewLoadingScreen) RelativeLayout mLoadingScreen;

    PhotoViewAttacher mAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setElevation(0);
//
//        toolbar.getBackground().setAlpha(100);
        getSupportActionBar().setTitle("");

        showLoadingScreen();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://services.hanselandpetal.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api flowerApi = retrofit.create(api.class);
        Call<List<dumFlower>> flowerCall = flowerApi.getData();
        flowerCall.enqueue(new Callback<List<dumFlower>>() {
            @Override
            public void onResponse(Call<List<dumFlower>> call, Response<List<dumFlower>> response) {
                List<dumFlower> flowers = response.body();
                String load = urlImage + flowers.get(5).getPhoto();
                Glide.with(getApplicationContext()).load(load).asBitmap().into(photoView);
                mAttacher = new PhotoViewAttacher(photoView);
                showContentScreen();
            }

            @Override
            public void onFailure(Call<List<dumFlower>> call, Throwable t) {
                Log.e("Failure Image", "IDK");
                showContentScreen();
            }
        });

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
