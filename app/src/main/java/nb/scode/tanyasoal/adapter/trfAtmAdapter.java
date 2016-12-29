package nb.scode.tanyasoal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import custom_font.TextViewMyriad;
import nb.scode.tanyasoal.R;
import nb.scode.tanyasoal.models.AtmCard;

/**
 * Created by User on 12/27/2016.
 */

public class trfAtmAdapter extends BaseAdapter{

    private Context mContext;
    private AtmCard[] atms;
    private LayoutInflater inflater;

    public trfAtmAdapter(Context context, AtmCard[] atmCards) {
        this.mContext = context;
        this.atms = atmCards;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return atms.length;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return atms[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        AtmCard card = atms[position];
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.model_atm_card,parent, false);
        }

        final TextViewMyriad title = (TextViewMyriad)convertView.findViewById(R.id.title_atm_card);
        final ImageView iv_card = (ImageView)convertView.findViewById(R.id.img_atm_card);
        title.setText(card.getName());
        Glide.with(mContext)
                .load(card.getImg())
                .asBitmap()
                .into(iv_card);
        return convertView;
    }

}

