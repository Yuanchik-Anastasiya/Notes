package com.yuanchik.notes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.yuanchik.notes.Moduls.Notes;

import java.util.Date;

public class NotesTakerActivity extends AppCompatActivity {

    EditText edit_text, edit_notes;
    ImageView image_save;
    Notes notes;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notes_taker);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edit_text = findViewById(R.id.edit_text);
        edit_notes = findViewById(R.id.edit_notes);
        image_save = findViewById(R.id.image_save);

        image_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edit_text.getText().toString();
                String description = edit_notes.getText().toString();

                if (description.isEmpty()){
                    Toast.makeText(NotesTakerActivity.this, "Please, enter description", Toast.LENGTH_SHORT).show();

                    return;
                }
                SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
                Date date = new Date();

                notes = new Notes();
                notes.setTitle(title);
                notes.setNotes(description);
                notes.setData(formatter.format(date));

                Intent intent = new Intent();
                intent.putExtra("note", notes);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });


    }
}