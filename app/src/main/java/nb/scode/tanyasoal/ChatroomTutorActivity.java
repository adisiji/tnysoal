package nb.scode.tanyasoal;

import android.content.Context;
import android.os.Bundle;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import nb.scode.tanyasoal.baseAct.BaseActivity;
import uk.co.senab.photoview.PhotoView;

public class ChatroomTutorActivity extends BaseActivity {
    @BindView(R.id.img_main_soal_chat) PhotoView mainsoal;
    @BindView(R.id.img_jawaban1) PhotoView jawaban1;
    @BindView(R.id.img_jawaban2) PhotoView jawaban2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom_tutor);

        Context context = getApplicationContext();

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
    }
}
