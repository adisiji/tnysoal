package nb.scode.tanyasoal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

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
        ViewHolder holder;
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
        holder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionCard.onClick(position);
            }
        });

        return convertView;
    }

    static class ViewHolder{
        @BindView(R.id.isi_soal_layanan) TextViewMyriad soal;
        @BindView(R.id.rating_tanya) RatingBar ratingBar;
        @BindView(R.id.rl_root_laytanya) RelativeLayout rl;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public interface ActionCard {
        void onClick(int position);
    }

}