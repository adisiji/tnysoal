package nb.scode.tanyasoal.adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.List;

import custom_font.EditTextMyriad;
import nb.scode.tanyasoal.R;
import nb.scode.tanyasoal.models.reply;

/**
 * Created by User on 1/7/2017.
 */

public class ReplyFreeForumAdapter extends RecyclerView.Adapter<ReplyFreeForumAdapter.MyViewHolder> {

    private List<reply> replyList;
    private Context context;
    private ActionReply actionReply;

    public void SetActionReply(ActionReply actionReply){
        this.actionReply = actionReply;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public EditTextMyriad content;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            content = (EditTextMyriad) view.findViewById(R.id.ed_child_reply);
            imageView = (ImageView)view.findViewById(R.id.dropdown_reply_forum);
        }
    }

    public ReplyFreeForumAdapter(List<reply> replies, Context context){
        this.replyList = replies;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_reply_freeforum, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        reply q = replyList.get(position);
        holder.content.setText(q.getContent());
        Glide.with(context).load(R.drawable.ic_arrow_drop_down_white_24dp)
                .asBitmap()
                .into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionReply.onClickDrop(position, view);
            }
        });
    }

    @Override
    public int getItemCount() {
        return replyList.size();
    }

    public interface ActionReply{
        void onClickDrop(int position, View view);
    }
}
