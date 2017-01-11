package nb.scode.tanyasoal.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

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
    private ReplyFreeForumAdapter adapterReply;
    private Context context;
    private ActionRoot actionRoot;

    public void setActionRoot(ActionRoot actionRoot){
        this.actionRoot = actionRoot;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextViewMyriad content;
        public RecyclerView rv_reply;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            content = (TextViewMyriad) view.findViewById(R.id.content_freeforum);
            rv_reply = (RecyclerView)view.findViewById(R.id.rv_reply_freeforum);
            imageView = (ImageView)view.findViewById(R.id.dropdown_root_forum);
        }
    }

    public RootFreeForumAdapter(Context context, List<question> questions, ReplyFreeForumAdapter adapter){
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
        question q = questionList.get(position);
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
