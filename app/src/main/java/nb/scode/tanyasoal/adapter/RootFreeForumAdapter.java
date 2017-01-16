package nb.scode.tanyasoal.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import custom_font.TextViewMyriad;
import nb.scode.tanyasoal.R;
import nb.scode.tanyasoal.models.Question;

/**
 * Created by User on 1/7/2017.
 */

public class RootFreeForumAdapter extends RecyclerView.Adapter<RootFreeForumAdapter.MyViewHolder> {

    private List<Question> questionList;
    private ReplyFreeForumAdapter adapterReply;
    private Context context;
    private ActionRoot actionRoot;

    public void setActionRoot(ActionRoot actionRoot){
        this.actionRoot = actionRoot;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.content_freeforum) TextViewMyriad content;
        @BindView(R.id.rv_reply_freeforum) RecyclerView rv_reply;
        @BindView(R.id.dropdown_root_forum) ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }

    public RootFreeForumAdapter(Context context, List<Question> questions, ReplyFreeForumAdapter adapter){
        this.adapterReply = adapter;
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
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        LinearLayoutManager llm = new LinearLayoutManager(context);
        holder.rv_reply.setLayoutManager(llm);
        holder.rv_reply.setAdapter(adapterReply);
        Question q = questionList.get(position);
        holder.content.setText(q.getSoal());
        Glide.with(context).load(R.drawable.ic_arrow_drop_down_white_24dp)
                .asBitmap()
                .into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionRoot.onClickDrop(position, view);
            }
        });

    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    public interface ActionRoot{
        void onClickDrop(int position, View view);
    }

}
