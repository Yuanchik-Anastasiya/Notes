package com.yuanchik.notes.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.yuanchik.notes.Moduls.Notes;
import com.yuanchik.notes.NotesClickListener;
import com.yuanchik.notes.R;

import java.util.List;

public class NotesListAdapter extends RecyclerView.Adapter<NotesListHolder> {

    Context context;
    List<Notes> list;

    NotesClickListener listener;

    public NotesListAdapter(Context context, List<Notes> list, NotesClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NotesListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesListHolder(LayoutInflater.from(context).inflate(R.layout.notes_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesListHolder holder, int position) {

        holder.text_title.setText(list.get(position).getTitle());
        holder.text_title.setSelected(true);

        holder.text_notes.setText(list.get(position).getNotes());

        holder.text_date.setText(list.get(position).getData());
        holder.text_date.setSelected(true);

        if (list.get(position).isPinned()){
            holder.image_pin.setImageResource(R.drawable.pin);
        } else {
            holder.image_pin.setImageResource(0);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class NotesListHolder extends RecyclerView.ViewHolder{

    CardView notes_container;
    TextView text_title, text_notes, text_date;
    ImageView image_pin;

    public NotesListHolder(@NonNull View itemView) {
        super(itemView);

        notes_container = itemView.findViewById(R.id.notes_container);
        text_title = itemView.findViewById(R.id.text_title);
        text_notes = itemView.findViewById(R.id.text_notes);
        text_date = itemView.findViewById(R.id.text_date);
        image_pin = itemView.findViewById(R.id.image_pin);
    }
}