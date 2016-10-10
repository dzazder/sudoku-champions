package dev.lampart.bartosz.sudokuchampions.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

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
}
