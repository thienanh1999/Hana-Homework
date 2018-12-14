package com.example.user.lab04;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<NoteModel> noteModels;
    private NoteItemAdapter noteItemAdapter;
    RecyclerView rcNoteTitle;

    FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteModels = new ArrayList<>();
        NoteModel noteModel = new NoteModel("Go to shopping", "deo");
        NoteModel noteModel1 = new NoteModel("Send an email to boss", "");
        NoteModel noteModel2 = new NoteModel("Submit assignment", "");
        noteModels.add(noteModel);
        noteModels.add(noteModel1);
        noteModels.add(noteModel2);

        rcNoteTitle = findViewById(R.id.rv_list_note);
        noteItemAdapter = new NoteItemAdapter(noteModels);
        rcNoteTitle.setAdapter(noteItemAdapter);
        rcNoteTitle.setLayoutManager(new LinearLayoutManager(this));

        fabAdd = findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateNewNoteActivity.class);
                startActivity(intent);
            }
        });
    }
}
