package nb.scode.tanyasoal;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nb.scode.tanyasoal.adapter.RootFreeForumAdapter;
import nb.scode.tanyasoal.baseAct.BaseActivity;
import nb.scode.tanyasoal.models.question;
import nb.scode.tanyasoal.models.reply;

public class FreeForumActivity extends BaseActivity {

    private List<question> questions = new ArrayList<>();
    private List<reply> replies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_forum);

        for(int i = 0;i<50;i++){
            question q = new question();
            q.setSoal("Pertanyaan ke-"+i);
            questions.add(q);
        }
        for(int i = 0;i<5;i++){
            reply r = new reply();
            r.setContent("Ini reply ke-"+i);
            replies.add(r);
        }
        RecyclerView rv = (RecyclerView)findViewById(R.id.rv_free_forum);
        RootFreeForumAdapter adapter = new RootFreeForumAdapter(getApplicationContext(), questions, replies);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
    }
}
