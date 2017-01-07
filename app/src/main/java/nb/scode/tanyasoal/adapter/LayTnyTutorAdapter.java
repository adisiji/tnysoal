package nb.scode.tanyasoal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;

import custom_font.TextViewMyriad;
import nb.scode.tanyasoal.R;
import nb.scode.tanyasoal.models.question;

/**
 * Created by User on 1/6/2017.
 */

public class LayTnyTutorAdapter extends BaseAdapter {

    private Context mContext;
    private question[] questionz;
    private LayoutInflater inflater;

    public LayTnyTutorAdapter(Context context, question[] atmCards) {
        this.mContext = context;
        this.questionz = atmCards;
        inflater = LayoutInflater.from(context);
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
    public View getView(int position, View convertView, ViewGroup parent) {

        question card = questionz[position];
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.card_lay_tanya_tutor,parent, false);
        }

        final TextViewMyriad soal = (TextViewMyriad)convertView.findViewById(R.id.isi_soal_layanan);
        RatingBar ratingBar = (RatingBar)convertView.findViewById(R.id.rating_tanya);
        ratingBar.setRating(4);
        soal.setText(card.getSoal());

        return convertView;
    }

}
