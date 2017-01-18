package nb.scode.tanyasoal;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import nb.scode.tanyasoal.adapter.AvailQuestAdapter;
import nb.scode.tanyasoal.baseAct.BaseActivity;
import nb.scode.tanyasoal.models.Question;

public class AvailQuestionActivity extends BaseActivity {

    private final int sdk = android.os.Build.VERSION.SDK_INT;
    @BindArray(R.array.tkt_akademik_array) String[] tingkat;
    @BindArray(R.array.subjekItems)String[] subjeks;
    @BindView(R.id.rv_avail_question) RecyclerView rv_q;
    private List<Question> questions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avail_question);
        ButterKnife.bind(this);
        getBackToolbar().setEnabled(false);
        setModelSoal();
        AvailQuestAdapter adapter = new AvailQuestAdapter(questions);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv_q.setLayoutManager(mLayoutManager);
        rv_q.setItemAnimator(new DefaultItemAnimator());
        adapter.setAction(new AvailQuestAdapter.availAction() {
            @Override
            public void onClickCard(int pos, View view) {
                Intent i = new Intent(getApplicationContext(), ChatroomTutorActivity.class);
                startActivity(i);
            }
        });
        rv_q.setAdapter(adapter);
    }

    private void setModelSoal(){
        for(int i = 0;i<50;i++){
            Question q = new Question();
            q.setTutor("Joni Handoko");
            q.setLvl(tingkat[i%5]);
            q.setNama("Ney Darmawan");
            q.setSubjek(subjeks[i%5]);
            q.setSoal("Nomor 2 dan 3 ya kak");
            q.setPeriode(12);
            if(i%2==0){
                q.setJawaban("Foto");
            }
            else {
                q.setJawaban("Video");
            }
            q.setSisaw(SystemClock.currentThreadTimeMillis());
            questions.add(q);
        }
    }
}