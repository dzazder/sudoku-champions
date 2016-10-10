package dev.lampart.bartosz.sudokuchampions.view;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import dev.lampart.bartosz.sudokuchampions.GameEngine;
import dev.lampart.bartosz.sudokuchampions.R;
import dev.lampart.bartosz.sudokuchampions.SudokuGenerator;

/**
 * Created by bartek on 10.10.2016.
 */
public class SudokuGridViewAdapter extends BaseAdapter {

    private Context context;

    public SudokuGridViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return SudokuGenerator.SIZE * SudokuGenerator.SIZE;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            v = inflater.inflate(R.layout.cell, parent, false);
        }

        int x = position % SudokuGenerator.SIZE;
        int y = position / SudokuGenerator.SIZE;

        SudokuCell cell = (SudokuCell)v;
        cell.setNumber(GameEngine.getInstance().getSudoku()[x][y]);
        return v;
    }
}
