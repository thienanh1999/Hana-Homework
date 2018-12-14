package com.example.user.lab04;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NoteItemAdapter extends RecyclerView.Adapter<NoteItemAdapter.NoteItemViewHolder> {
    private static final String TAG = "NoteItemAdapter";
    private List<NoteModel> noteModels;

    public NoteItemAdapter(List<NoteModel> noteModels)
    {
        this.noteModels = noteModels;
    }

    @Override
    public NoteItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_note_title,parent,false);
        return new NoteItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( NoteItemViewHolder holder, int position) {
        holder.setData(noteModels.get(position));
    }

    @Override
    public int getItemCount() {
        return noteModels.size();
    }

    public class NoteItemViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView tvNoteTitle;

        public NoteItemViewHolder(View itemView) {
            super(itemView);
            view = itemView;
        }

        public void setData(NoteModel noteModel) {
            tvNoteTitle = view.findViewById(R.id.tv_note_title);
            tvNoteTitle.setText(noteModel.getTitle());
        }
    }
}
