package com.example.educator;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.viewholder> {
    ArrayList<Student> studentArrayList;
    private Context context;

    public StudentAdapter(ArrayList<Student> list, Context context) {
        studentArrayList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_card_view, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.viewholder holder, int position) {
        holder.tv_name.setText(studentArrayList.get(position).getName().toString());
        Glide.with(context).asBitmap().load(studentArrayList.get(position).getImageURL().toString()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return ApplicationClass.students.size();
    }


    public class viewholder extends RecyclerView.ViewHolder {
        TextView tv_name;
        ImageView img;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_studentname);
            img = itemView.findViewById(R.id.studentimg);
        }
    }
}
