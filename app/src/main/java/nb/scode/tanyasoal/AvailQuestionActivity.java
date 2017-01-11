package nb.scode.tanyasoal;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;

import custom_font.TextViewMyriad;
import nb.scode.tanyasoal.baseAct.BaseActivity;
import nb.scode.tanyasoal.models.question;

public class AvailQuestionActivity extends BaseActivity {

    private final int sdk = android.os.Build.VERSION.SDK_INT;

    private TableLayout tabelQuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avail_question);
        tabelQuest = (TableLayout)findViewById(R.id.table_avail_quest);
        setModelSoal();
    }

    private void setModelSoal(){
        for(int i = 0;i<50;i++){
            question q = new question();
            q.setTutor("Joni Handoko");
            q.setLvl(1);
            q.setNama("Ney Darmawan");
            q.setSubjek((i%5)+1);
            q.setSoal("Nomor 2 dan 3 ya kak");
            q.setPeriode(12);
            q.setJawaban(0);
            q.setSisaw(SystemClock.currentThreadTimeMillis());

            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            if(i%2==0){
                tableRow.setBackgroundColor(getResources().getColor(R.color.soft_grey));
            }
            tableRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), ChatroomTutorActivity.class);
                    startActivity(i);
                }
            });
            ArrayList<TextViewMyriad> ready = new ArrayList<>();
            TextViewMyriad subjek = new TextViewMyriad(this);
            subjek.setText(String.valueOf(q.getSubjek()));
            ready.add(subjek);
            TextViewMyriad lvl = new TextViewMyriad(this);
            lvl.setText(String.valueOf(q.getLvl()));
            ready.add(lvl);
            TextViewMyriad nama = new TextViewMyriad(this);
            nama.setText(q.getNama());
            ready.add(nama);
            TextViewMyriad tutor = new TextViewMyriad(this);
            tutor.setText(q.getTutor());
            ready.add(tutor);
            TextViewMyriad sisawkt = new TextViewMyriad(this);
            sisawkt.setText(String.valueOf(q.getSisaw()));
            ready.add(sisawkt);
            TextViewMyriad soal = new TextViewMyriad(this);
            soal.setText(q.getSoal());
            soal.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.blue_hx));
            ready.add(soal);
            TextViewMyriad periode = new TextViewMyriad(this);
            periode.setText(String.valueOf(q.getPeriode()));
            ready.add(periode);
            TextViewMyriad jawaban = new TextViewMyriad(this);
            jawaban.setText(String.valueOf(q.getJawaban()));
            ready.add(jawaban);
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
            tabelQuest.addView(tableRow);
        }
    }
}
