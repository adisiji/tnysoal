package nb.scode.tanyasoal.adapter;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import custom_font.TextViewMyriad;
import nb.scode.tanyasoal.R;
import nb.scode.tanyasoal.models.Question;

/**
 * Created by User on 1/16/2017.
 */

public class AvailQuestAdapter extends RecyclerView.Adapter<AvailQuestAdapter.MyViewHolder> {

    private List<Question> questionList;
    private availAction action;

    public void setAction(availAction action){
        this.action = action;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.content_subjek_q) TextViewMyriad subjek;
        @BindView(R.id.content_nama_q) TextViewMyriad nama;
        @BindView(R.id.content_level_q) TextViewMyriad level;
        @BindView(R.id.content_tutor_q) TextViewMyriad tutor;
        @BindView(R.id.content_periode_q) TextViewMyriad periode;
        @BindView(R.id.content_jawaban_q) TextViewMyriad jawaban;
        @BindView(R.id.content_sisawaktu_q) TextViewMyriad sisawaktu;
        @BindView(R.id.card_cl_avail_q) ConstraintLayout card;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }

    public AvailQuestAdapter(List<Question> questions){
        this.questionList = questions;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_avail_question, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final String addio = ": ";
        holder.subjek.setText(addio + questionList.get(position).getSubjek());
        holder.nama.setText(addio + questionList.get(position).getNama());
        holder.level.setText(addio + questionList.get(position).getLvl());
        holder.tutor.setText(addio + questionList.get(position).getTutor());
        holder.periode.setText(addio + String.valueOf(questionList.get(position).getPeriode())+ " jam");
        holder.jawaban.setText(addio + questionList.get(position).getJawaban());
        holder.sisawaktu.setText(addio + String.valueOf(questionList.get(position).getSisaw()));
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action.onClickCard(position, view);
            }
        });
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    public interface availAction{
        void onClickCard(int pos, View view);
    }
}
