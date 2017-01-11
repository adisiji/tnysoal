package nb.scode.tanyasoal;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import nb.scode.tanyasoal.adapter.ReplyFreeForumAdapter;
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
        ReplyFreeForumAdapter adapter2 = new ReplyFreeForumAdapter(replies, getApplicationContext());
        RootFreeForumAdapter adapter = new RootFreeForumAdapter(getApplicationContext(), questions, adapter2);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        adapter2.SetActionReply(new ReplyFreeForumAdapter.ActionReply() {
            @Override
            public void onClickDrop(int position, View view) {
                showPopup(view);
            }
        });
        adapter.setActionRoot(new RootFreeForumAdapter.ActionRoot() {
            @Override
            public void onClickDrop(int position, View view) {
                showPopup(view);
            }
        });
        rv.setAdapter(adapter);
    }

    private void showPopup(View view){
        PopupMenu popup = new PopupMenu(FreeForumActivity.this, view);
        //Inflating the Popup using xml file
        popup.getMenuInflater().inflate(R.menu.popup_menu_forum, popup.getMenu());

        //registering popup with OnMenuItemClickListener
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(FreeForumActivity.this,"You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        popup.show();//showing popup menu
    }
}
