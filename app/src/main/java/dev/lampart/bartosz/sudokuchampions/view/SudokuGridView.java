package dev.lampart.bartosz.sudokuchampions.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import dev.lampart.bartosz.sudokuchampions.GameEngine;
import dev.lampart.bartosz.sudokuchampions.R;
import dev.lampart.bartosz.sudokuchampions.SudokuGenerator;

/**
 * Created by bartek on 10.10.2016.
 */
public class SudokuGridView extends GridView {

    private Context context;

    public SudokuGridView(final Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;

        SudokuGridViewAdapter gridViewAdapter = new SudokuGridViewAdapter(context);
        setAdapter(gridViewAdapter);

        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int x = position % SudokuGenerator.SIZE;
                int y = position / SudokuGenerator.SIZE;

                Toast.makeText(context, "Selected item - x: " + x  + " y: " + y, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    class SudokuGridViewAdapter extends BaseAdapter {

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
            return GameEngine.getInstance().getGrid().getItem(position);
        }
    }

}
