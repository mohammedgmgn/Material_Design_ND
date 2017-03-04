package com.mahmoud.mohammed.materia_ldesign_nd;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.api.services.books.Books;
import com.mahmoud.mohammed.materia_ldesign_nd.modle.Place;
import com.mahmoud.mohammed.materia_ldesign_nd.ui.Myadabter;

import java.util.ArrayList;
import java.util.List;


public class TitleContentFragment extends Fragment {
List<Place> places=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
            fillPlaces(places);
        Myadabter myadabter=new Myadabter(places, getContext(), new Myadabter.RecyclerViewClickListener() {
            @Override
            public void recyclerViewListClicked(View v, int position) {
                Intent i=new Intent(getContext(),DetailActivity.class);
                i.putExtra(DetailActivity.TITLE,places.get(position).getTilte());
                i.putExtra(DetailActivity.DESCRIPTION,places.get(position).getDescription());
                i.putExtra(DetailActivity.IMAGE,places.get(position).getImage());
                startActivity(i);
            }
        });
        recyclerView.setAdapter(myadabter);
        recyclerView.setHasFixedSize(true);
        int tilePadding = getResources().getDimensionPixelSize(R.dimen.tile_padding);
        recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        return recyclerView;

    }

    private void fillPlaces(List<Place> places) {
         String[] mtitles;
         final Drawable[] mPlacePictures;
        Resources resources = getContext().getResources();
        int images[]={
                R.drawable.a,
                R.drawable.abusimbel,
                R.drawable.abydostempleofosiris,
                R.drawable.alexandria,
                R.drawable.aswannile,
                R.drawable.cairo,
                R.drawable.egyptianmuseum,
                R.drawable.katherinesmonastery,
                R.drawable.luxorkarnaktemple,
                R.drawable.pyramids,
                R.drawable.slamicmosque,
                R.drawable.southsinaibeach,
                R.drawable.whitedesert,};
for(int i=0;i<images.length;i++)
{
    Place p=new Place();
    p.setTilte(getString(R.string.siwaoasis));
    p.setDescription(getString(R.string.detail_desc));
    p.setImage(images[i]);
    places.add(p);

}
       // TypedArray mtitlesArray = resources.obtainTypedArray(R.array.places);
        //TypedArray mPlacePicturesArray = resources.obtainTypedArray(R.array.places_picture);
       // TypedArray mPlaceDescriptionArray = resources.obtainTypedArray(R.array.discription);

        //  mPlacePictures=new Drawable[mPlacePicturesArray.length()];
//        mtitles=new String[mtitlesArray.length()];
/*
        for(int i=0;i<mtitles.length;i++)
        {
            Place place=new Place();
            place.setTilte(mtitlesArray.getString(i));
            place.setImage(mPlacePicturesArray.getDrawable(i));
         //   place.setDescription(mPlaceDescriptionArray.getString(i));
            places.add(place);

        }
*/
    }


}
