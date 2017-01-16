package nb.scode.tanyasoal;

import android.os.Bundle;
import android.widget.GridView;

import butterknife.BindView;
import butterknife.ButterKnife;
import nb.scode.tanyasoal.adapter.TrfAtmAdapter;
import nb.scode.tanyasoal.baseAct.BaseActivity;
import nb.scode.tanyasoal.models.AtmCard;

public class TrfAtmActivity extends BaseActivity {

    @BindView(R.id.gridview) GridView gridView;

    private AtmCard cards[] = new AtmCard[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trf_atm);
        ButterKnife.bind(this);
        for(int i = 0;i<cards.length;i++){
            AtmCard card = new AtmCard("ATM BCA",R.drawable.logo_bca);
            cards[i] = card;
        }

        // Instance of ImageAdapter Class
        gridView.setAdapter(new TrfAtmAdapter(this, cards));
    }
}
