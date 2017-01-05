package nb.scode.tanyasoal;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import custom_font.TextViewMyriad;
import nb.scode.tanyasoal.baseAct.BaseActivity;
import nb.scode.tanyasoal.models.LogUserAct;

public class LogUserActivity extends BaseActivity {

    private final int sdk = android.os.Build.VERSION.SDK_INT;

    private TableLayout tabelAktivitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_user);
        tabelAktivitas = (TableLayout)findViewById(R.id.table_cat_aktivitas);
        setModelAktivitas();
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);

    private void setModelAktivitas(){
        for(int i = 0;i<50;i++){
            LogUserAct q = new LogUserAct();
            long now = System.currentTimeMillis()/1000;
            String currentDateTime = dateFormat.format(now); // Find todays date
            q.setWaktu(now);
            if(i%2==0) {
                q.setAksi("Tanya Tutor");
                q.setSaldo_ptg("Rp"+String.valueOf(4000+i*2000)+",-"); }
            else {
                q.setAksi("Isi Saldo");
                q.setSaldo_ptg("");
            }

            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            if(i%2==0){
                tableRow.setBackgroundColor(getResources().getColor(R.color.soft_grey));
            }
            ArrayList<TextViewMyriad> ready = new ArrayList<>();
            TextViewMyriad waktu = new TextViewMyriad(this);
            waktu.setText(currentDateTime);
            ready.add(waktu);
            TextViewMyriad aksi = new TextViewMyriad(this);
            aksi.setText(q.getAksi());
            ready.add(aksi);
            TextViewMyriad saldo = new TextViewMyriad(this);
            saldo.setText(String.valueOf(q.getSaldo_ptg()));
            ready.add(saldo);
            int j = ready.size();
            for(int k = 0; k<j; k++) {
                if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    ready.get(k).setBackgroundDrawable( getResources().getDrawable(R.drawable.cellborder) );
                } else {
                    ready.get(k).setBackground( getResources().getDrawable(R.drawable.cellborder));
                }
                ready.get(k).setLayoutParams(new TableRow.LayoutParams(50, ViewGroup.LayoutParams.MATCH_PARENT));
                ready.get(k).setPadding(3,3,3,3);
                ready.get(k).setGravity(Gravity.CENTER_HORIZONTAL);
                tableRow.addView(ready.get(k));
            }
            tabelAktivitas.addView(tableRow);
        }
    }
}
