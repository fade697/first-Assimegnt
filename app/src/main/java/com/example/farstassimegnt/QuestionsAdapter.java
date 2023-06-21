package com.example.farstassimegnt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.ViewHolder> {

    private List<Questions> questionsList;

    public QuestionsAdapter(List<Questions> questionsList) {
        this.questionsList = questionsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Questions question = questionsList.get(position);
        holder.questionText.setText(question.getElement());
    }

    @Override
    public int getItemCount() {
        return questionsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView questionText;
        EditText answerEditText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            questionText = itemView.findViewById(R.id.questionText);
            answerEditText = itemView.findViewById(R.id.answerEditText);
        }
    }
}
