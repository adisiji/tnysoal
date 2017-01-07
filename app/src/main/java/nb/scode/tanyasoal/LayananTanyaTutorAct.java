package nb.scode.tanyasoal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.RatingBar;

import nb.scode.tanyasoal.adapter.LayTnyTutorAdapter;
import nb.scode.tanyasoal.baseAct.BaseActivity;
import nb.scode.tanyasoal.models.question;

public class LayananTanyaTutorAct extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layanan_tanya_tutor);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        question cards[] = new question[50];
        for(int i = 0;i<cards.length;i++){
            question card = new question();
            card.setSoal("Apa nama benda ini ?");
            cards[i] = card;
        }

        // Instance of ImageAdapter Class
        gridView.setAdapter(new LayTnyTutorAdapter(this, cards));

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
