package com.yuanchik.notes;

import androidx.cardview.widget.CardView;

import com.yuanchik.notes.Moduls.Notes;

public interface NotesClickListener {

    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);
}
