package com.ck.namunews;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;

import com.google.android.material.tabs.TabLayout;

public class MyTabLayout extends TabLayout {
    public MyTabLayout(@NonNull Context context) {
        super(context);
    }

    public MyTabLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTabLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    @Override
    public void addTab(@NonNull Tab tab, int position, boolean setSelected) {
        super.addTab(tab, position, setSelected);
        View customView = LayoutInflater.from(getContext()).inflate(R.layout.my_tab_layout, tab.view, false);
        TextView tabTextView = customView.findViewById(R.id.tv_category);
        String tabText = (tab.getText() == null) ? "NullText" : tab.getText().toString().trim();
        if(!TextUtils.isEmpty(tabText)){
            tabTextView.setText(tabText);
        }
        tab.view.setPadding(0,0,0,0);

        AppCompatImageView layout = customView.findViewById(R.id.background);

        layout.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.selector_tab_center));
        setSelectedTabIndicator(R.color.black);
        tab.setCustomView(customView);

    }

    public void setText(int position, String category) {
        Tab tab = getTabAt(position);
        if (tab != null) {
            View customView = tab.getCustomView();
            if (customView != null) {
                TextView tv = customView.findViewById(R.id.tv_category);
                if (tv != null) {
                    tv.setText(category);
                }
            }
        }
    }
}