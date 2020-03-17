package com.example.dicerollerapp.MenuItem;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dicerollerapp.R;

public class ItemMenuView extends LinearLayout {

    public ItemMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.recycler_view_item, this);

        TextView funcaoText = findViewById(R.id.tituloItem);
        ImageView funcaoImage = findViewById(R.id.imagemItem);

        int[] sets = {R.attr.funcaoText, R.attr.funcaoImage};

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.ItemMenuCardView);

        funcaoText.setText(attributes.getString(R.styleable.ItemMenuCardView_funcaoText));
        funcaoImage.setImageDrawable(attributes.getDrawable(R.styleable.ItemMenuCardView_funcaoImage));

        attributes.recycle();
    }

}
