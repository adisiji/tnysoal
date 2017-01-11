package nb.scode.tanyasoal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.bumptech.glide.Glide;

import nb.scode.tanyasoal.baseAct.BaseActivity;
import uk.co.senab.photoview.PhotoView;

public class ChatroomTanyaTutorActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom_tanya_tutor);
        Context context = getApplicationContext();
        PhotoView mainsoal = (PhotoView) findViewById(R.id.img_main_soal_chat);
        PhotoView jawaban1 = (PhotoView)findViewById(R.id.img_jawaban1);
        PhotoView jawaban2 = (PhotoView) findViewById(R.id.img_jawaban2);

        Glide.with(context).load(R.drawable.jawab_soal1)
                .asBitmap()
                .into(jawaban1);
        Glide.with(context)
                .load(R.drawable.jawab_soal1)
                .asBitmap()
                .into(jawaban2);
        Glide.with(context)
                .load(R.drawable.pict_soal1)
                .asBitmap()
                .fitCenter()
                .into(mainsoal);

        FrameLayout btnTanyaTutor = (FrameLayout)findViewById(R.id.btn_tanya_tutor);
        btnTanyaTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), TanyaTutorActivity.class);
                startActivity(i);
            }
        });
    }
}
