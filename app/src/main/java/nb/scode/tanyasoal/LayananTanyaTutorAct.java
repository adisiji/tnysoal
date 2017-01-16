package nb.scode.tanyasoal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;

import butterknife.OnClick;
import nb.scode.tanyasoal.adapter.LayTnyTutorAdapter;
import nb.scode.tanyasoal.baseAct.BaseActivity;
import nb.scode.tanyasoal.models.Question;

public class LayananTanyaTutorAct extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layanan_tanya_tutor);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        Question cards[] = new Question[50];
        for(int i = 0;i<cards.length;i++){
            Question card = new Question();
            card.setSoal("Apa nama benda ini ?");
            cards[i] = card;
        }

        LayTnyTutorAdapter adapter = new LayTnyTutorAdapter(this,cards);

        // Instance of ImageAdapter Class
        gridView.setAdapter(adapter);

        adapter.SetActionCard(new LayTnyTutorAdapter.ActionCard() {
            @Override
            public void onClick(int position) {
                Log.e("User click = ",String.valueOf(position));
                Intent i = new Intent(getApplicationContext(),ChatroomTanyaTutorActivity.class);
                startActivity(i);
            }
        });

    }

    @OnClick(R.id.btn_tanya_tutor)
    void TanyaTutor(){
        Intent i = new Intent(getApplicationContext(), TanyaTutorActivity.class);
        startActivity(i);
    }
}
