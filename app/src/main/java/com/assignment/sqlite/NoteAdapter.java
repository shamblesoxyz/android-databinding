package com.assignment.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.assignment.databinding.R;

import org.w3c.dom.Text;

import java.util.List;

public class NoteAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<NoteModel> notes;

    public NoteAdapter(Context context, int layout, List<NoteModel> notes) {
        this.context = context;
        this.layout = layout;
        this.notes = notes;
    }

    public NoteAdapter() {
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int i) {
        return notes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        NoteViewHolder noteViewHolder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            noteViewHolder = new NoteViewHolder();
            noteViewHolder.taskTextView = (TextView) view.findViewById(R.id.text_view_task);
            noteViewHolder.editImageButton = (ImageButton) view.findViewById(R.id.image_button_edit);
            noteViewHolder.deleteImageButton = (ImageButton) view.findViewById(R.id.image_button_delete);
            view.setTag(noteViewHolder);
        } else {
            noteViewHolder = (NoteViewHolder) view.getTag();
        }
        NoteModel note = notes.get(i);
        noteViewHolder.taskTextView.setText(note.getTask());
        return view;
    }

    private static class NoteViewHolder {
        TextView taskTextView;
        ImageButton editImageButton;
        ImageButton deleteImageButton;
    }
}
