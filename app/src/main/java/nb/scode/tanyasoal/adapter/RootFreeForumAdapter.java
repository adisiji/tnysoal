package nb.scode.tanyasoal.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import custom_font.TextViewMyriad;
import nb.scode.tanyasoal.R;
import nb.scode.tanyasoal.models.question;
import nb.scode.tanyasoal.models.reply;

/**
 * Created by User on 1/7/2017.
 */

public class RootFreeForumAdapter extends RecyclerView.Adapter<RootFreeForumAdapter.MyViewHolder> {

    private List<question> questionList;
    private List<reply> replyList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextViewMyriad content;
        public RecyclerView rv_reply;

        public MyViewHolder(View view) {
            super(view);
            content = (TextViewMyriad) view.findViewById(R.id.content_freeforum);
            rv_reply = (RecyclerView)view.findViewById(R.id.rv_reply_freeforum);
        }
    }

    public RootFreeForumAdapter(Context context, List<question> questions, List<reply> replies){
        this.replyList = replies;
        this.questionList = questions;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_root_freeforum, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ReplyFreeForumAdapter adapter = new ReplyFreeForumAdapter(replyList);
        holder.rv_reply.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        holder.rv_reply.setLayoutManager(llm);
        question q = questionList.get(position);
        holder.content.setText(q.getSoal());
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }
}
