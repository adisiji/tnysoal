package nb.scode.tanyasoal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nb.scode.tanyasoal.baseAct.BaseActivity;

public class ChatroomTutorActivity extends BaseActivity {
    @BindView(R.id.img_main_soal_chat) ImageView mainsoal;
    @BindView(R.id.img_jawaban1) ImageView jawaban1;
    @BindView(R.id.img_jawaban2) ImageView jawaban2;
    @BindView(R.id.cek_selesai_jawab_soal)
    CheckBox checkBoxJawab;
    @BindView(R.id.root_soalterjawab)
    LinearLayout layoutterjawab;

    Bitmap jawab1,jawab2,soal; //we will send this pict via intent

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom_tutor);
        ButterKnife.bind(this);
        Context context = getApplicationContext();
        isBack = true;
        Glide.with(context).load(R.drawable.jawab_soal1)
                .asBitmap()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
                        jawaban1.setImageBitmap(resource);
                        jawab1 = resource;
                    }
                });

        Glide.with(context)
                .load(R.drawable.jawab_soal1)
                .asBitmap()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
                        jawaban2.setImageBitmap(resource);
                        jawab2 = resource;
                    }
                });

        Glide.with(context)
                .load(R.drawable.pict_soal1)
                .asBitmap()
                .fitCenter()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
                        mainsoal.setImageBitmap(resource);
                        soal = resource;
                    }
                });
        checkBoxJawab.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    layoutterjawab.setVisibility(View.VISIBLE);
                }
                else {
                    layoutterjawab.setVisibility(View.GONE);
                }
            }
        });
    }

    @OnClick({R.id.img_jawaban1,R.id.img_jawaban2})
    void viewPhoto(){
        Intent i = new Intent(getApplicationContext(), PhotoViewActivity.class);
        i.putExtra("pict",jawab1);
        startActivity(i);
    }

    @OnClick(R.id.img_main_soal_chat)
    void viewSoal(){
        Intent i = new Intent(getApplicationContext(), PhotoViewActivity.class);
        i.putExtra("pict", soal);
        startActivity(i);
    }
}
