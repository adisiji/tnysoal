package nb.scode.tanyasoal;

import android.os.Bundle;
import android.widget.GridView;

import nb.scode.tanyasoal.adapter.TrfAtmAdapter;
import nb.scode.tanyasoal.baseAct.BaseActivity;
import nb.scode.tanyasoal.models.AtmCard;

public class InetBankingActivity extends BaseActivity {

    private AtmCard cards[] = new AtmCard[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inet_banking);
        GridView gridView = (GridView) findViewById(R.id.gridview);

        for(int i = 0;i<cards.length;i++){
            AtmCard card = new AtmCard("ATM BCA",R.drawable.logo_bca);
            cards[i] = card;
        }

        // Instance of ImageAdapter Class
        gridView.setAdapter(new TrfAtmAdapter(this, cards));
    }
}
