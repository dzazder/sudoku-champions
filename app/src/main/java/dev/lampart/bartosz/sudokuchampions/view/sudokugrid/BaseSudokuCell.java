package dev.lampart.bartosz.sudokuchampions.view.sudokugrid;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by bartek on 11.10.2016.
 */
public class BaseSudokuCell extends View {
    private int value;

    public BaseSudokuCell(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    public void setValue(int value) {
        this.value = value;
        invalidate();
    }

    public int getValue() {
        return value;
    }
}
