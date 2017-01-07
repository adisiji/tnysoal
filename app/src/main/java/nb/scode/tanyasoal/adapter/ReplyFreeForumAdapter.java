package nb.scode.tanyasoal.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import custom_font.EditTextMyriad;
import nb.scode.tanyasoal.R;
import nb.scode.tanyasoal.models.reply;

/**
 * Created by User on 1/7/2017.
 */

public class ReplyFreeForumAdapter extends RecyclerView.Adapter<ReplyFreeForumAdapter.MyViewHolder> {

    private List<reply> replyList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public EditTextMyriad content;

        public MyViewHolder(View view) {
            super(view);
            content = (EditTextMyriad) view.findViewById(R.id.ed_child_reply);

        }
    }

    public ReplyFreeForumAdapter(List<reply> replies){
        this.replyList = replies;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_reply_freeforum, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        reply q = replyList.get(position);
        holder.content.setText(q.getContent());
    }

    @Override
    public int getItemCount() {
        return replyList.size();
    }
}
