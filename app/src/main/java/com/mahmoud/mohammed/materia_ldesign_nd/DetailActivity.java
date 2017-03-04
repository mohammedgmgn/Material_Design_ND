package com.mahmoud.mohammed.materia_ldesign_nd;

import android.content.res.Resources;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String IMAGE = "image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
// Set title of Detail page

        collapsingToolbar.setTitle(getString(R.string.item_title));
        String title=getIntent().getStringExtra(TITLE);
        String desc=getIntent().getStringExtra(DESCRIPTION);
        int image=getIntent().getIntExtra(IMAGE,R.drawable.a);

        collapsingToolbar.setTitle(title);

    }
}
