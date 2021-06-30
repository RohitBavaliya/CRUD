package com.example.firebasedataretrive;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyViewHolder extends RecyclerView.ViewHolder
{
    CircleImageView img;
    TextView name, email, course;
    ImageView edit, delete;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        img = (CircleImageView) itemView.findViewById(R.id.rowImage);
        name = (TextView) itemView.findViewById(R.id.rowName);
        email = (TextView) itemView.findViewById(R.id.rowEmail);
        course = (TextView) itemView.findViewById(R.id.rowCourse);

        edit = (ImageView) itemView.findViewById(R.id.edit);
        delete = (ImageView) itemView.findViewById(R.id.delete);
    }
}
