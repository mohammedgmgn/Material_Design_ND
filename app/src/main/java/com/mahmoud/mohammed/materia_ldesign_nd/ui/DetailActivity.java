package com.mahmoud.mohammed.materia_ldesign_nd.ui;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.mahmoud.mohammed.materia_ldesign_nd.R;

public class DetailActivity extends AppCompatActivity {
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String POSTION = "postion";

    CollapsingToolbarLayout collapsingToolbar;
    ImageView imageView;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         imageView=(ImageView)findViewById(R.id.image);
         collapsingToolbar = (CollapsingToolbarLayout)
                findViewById(R.id.collapsing_toolbar);
         description=(TextView)findViewById(R.id.place_detail);
        collapsingToolbar.setTitle(getString(R.string.item_title));
        getData();

    }

    private void getData() {
        String title=getIntent().getStringExtra(TITLE);
        String desc=getIntent().getStringExtra(DESCRIPTION);
        int postion=getIntent().getIntExtra(POSTION,0);
        Resources resources = getResources();
        //TypedArray mtitlesArray = resources.obtainTypedArray(R.array.places);

        description.setText(desc);

        TypedArray mPlacePicturesArray = resources.obtainTypedArray(R.array.places_picture);
        imageView.setImageDrawable(mPlacePicturesArray.getDrawable(postion));
        collapsingToolbar.setTitle(title);

    }

}
