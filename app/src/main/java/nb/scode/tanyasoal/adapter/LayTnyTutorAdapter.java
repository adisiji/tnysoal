package nb.scode.tanyasoal.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import custom_font.TextViewMyriad;
import nb.scode.tanyasoal.R;
import nb.scode.tanyasoal.models.Question;

/**
 * Created by User on 1/6/2017.
 */

public class LayTnyTutorAdapter extends BaseAdapter {

    private Context mContext;
    private Question[] questionz;
    private LayoutInflater inflater;
    private ActionCard actionCard;

    public LayTnyTutorAdapter(Context context, Question[] atmCards) {
        this.mContext = context;
        this.questionz = atmCards;
        inflater = LayoutInflater.from(context);
    }

    public void SetActionCard(ActionCard actionCard){
        this.actionCard = actionCard;
    }

    @Override
    public int getCount() {
        return questionz.length;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return questionz[position];
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        Question card = questionz[position];
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        }
        else {
            convertView = inflater.inflate(R.layout.card_lay_tanya_tutor,parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        holder.ratingBar.setRating(4);
        holder.soal.setText(card.getSoal());
        holder.rl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    holder.rl.setBackground(holder.white_pressed);
                    holder.ll1.setBackground(holder.blue_pressed);
                    holder.ll2.setBackground(holder.blue_pressed);
                    Log.d("DEBUG::", "ACTION DOWN=======");
                }
                else if(event.getAction() == MotionEvent.ACTION_MOVE){
                    holder.rl.setBackground(holder.white_normal);
                    holder.ll1.setBackground(holder.blue_normal);
                    holder.ll2.setBackground(holder.blue_normal);
                    Log.d("DEBUG::", "ACTION MOVE=======");
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    holder.rl.setBackground(holder.white_normal);
                    holder.ll1.setBackground(holder.blue_normal);
                    holder.ll2.setBackground(holder.blue_normal);
                    actionCard.onClick(position);
                    Log.d("DEBUG::", "ACTION UP=======");
                }
                return true;
            }
        });

        return convertView;
    }

    static class ViewHolder{
        @BindView(R.id.isi_soal_layanan) TextViewMyriad soal;
        @BindView(R.id.rating_tanya) RatingBar ratingBar;
        @BindView(R.id.rl_root_laytanya)
        RelativeLayout rl;
        @BindView(R.id.row2_card_tanya)
        LinearLayout ll1;
        @BindView(R.id.card_rating_bar)
        LinearLayout ll2;
        @BindDrawable(R.drawable.dark_soft_blue_box)
        Drawable blue_pressed;
        @BindDrawable(R.drawable.soft_blue_box)
        Drawable blue_normal;
        @BindDrawable(R.drawable.white_box_grey_stroke)
        Drawable white_normal;
        @BindDrawable(R.drawable.white_box_greystr_selected)
        Drawable white_pressed;
        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public interface ActionCard {
        void onClick(int position);
    }

}