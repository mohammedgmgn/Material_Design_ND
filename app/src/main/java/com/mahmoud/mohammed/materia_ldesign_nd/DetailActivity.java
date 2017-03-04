package com.mahmoud.mohammed.materia_ldesign_nd;

import android.content.res.Resources;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_POSITION = "position";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
// Set title of Detail page

        collapsingToolbar.setTitle(getString(R.string.item_title));
        int postion = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Resources resources = getResources();
       // String[] places = resources.getStringArray(R.array.places);
        //collapsingToolbar.setTitle(places[postion]);

    }
}
