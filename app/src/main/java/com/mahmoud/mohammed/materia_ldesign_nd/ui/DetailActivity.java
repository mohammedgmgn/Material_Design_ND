package com.mahmoud.mohammed.materia_ldesign_nd.ui;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mahmoud.mohammed.materia_ldesign_nd.R;

public class DetailActivity extends AppCompatActivity {
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String POSTION = "postion";
    public static final String MY_PREFS_NAME = "favorites";


    CollapsingToolbarLayout collapsingToolbar;
    ImageView imageView;
    TextView detail;
    TextView description;
FloatingActionButton fab;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        sharedPreferences=getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        final SharedPreferences.Editor editor=sharedPreferences.edit();

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         imageView=(ImageView)findViewById(R.id.image);
         collapsingToolbar = (CollapsingToolbarLayout)
                findViewById(R.id.collapsing_toolbar);
         detail=(TextView)findViewById(R.id.place_detail);
        description=(TextView)findViewById(R.id.descriptionid);
        fab=(FloatingActionButton)findViewById(R.id.favor);
        collapsingToolbar.setTitle(getString(R.string.item_title));
      final String title= getData();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         if(sharedPreferences.contains(title))
         {
             editor.remove(title);
             fab.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this, R.drawable.ic_like_outline));
             Snackbar.make(view, "removed from Favourites",Snackbar.LENGTH_LONG).show();
             editor.commit();
         }
         else
         {
             editor.putString(title,title);
             fab.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this, R.drawable.ic_like));
             Snackbar.make(view, "Add to Favourites",Snackbar.LENGTH_LONG).show();
             editor.commit();
         }
            }
        });

    }
    private String getData() {
        String title=getIntent().getStringExtra(TITLE);
        if(sharedPreferences.contains(title))
        {
            fab.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this, R.drawable.ic_like));
        }
        else
        {
            fab.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this, R.drawable.ic_like_outline));

        }
        String desc=getIntent().getStringExtra(DESCRIPTION);
        int postion=getIntent().getIntExtra(POSTION,0);
        Resources resources = getResources();
        //TypedArray mtitlesArray = resources.obtainTypedArray(R.array.places);
        Typeface customfont=Typeface.createFromAsset(getAssets(),"Raleway-ExtraBold.ttf");
        Typeface customfont2=Typeface.createFromAsset(getAssets(),"Fonty.ttf");

        description.setTypeface(customfont);
        detail.setTypeface(customfont2);
        detail.setText(desc);
        TypedArray mPlacePicturesArray = resources.obtainTypedArray(R.array.places_picture);
        imageView.setImageDrawable(mPlacePicturesArray.getDrawable(postion));
        collapsingToolbar.setTitle(title);
return title;
    }

}
