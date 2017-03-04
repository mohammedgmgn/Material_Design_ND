package com.mahmoud.mohammed.materia_ldesign_nd.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mahmoud.mohammed.materia_ldesign_nd.R;
import com.mahmoud.mohammed.materia_ldesign_nd.modle.Place;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by gmgn on 8/9/2016.
 */

public class Myadabter extends RecyclerView.Adapter<Myadabter.myholder> {

    List<Place> places = new ArrayList<>();
    Context ctx;
    RecyclerViewClickListener itemListener;

    public Myadabter(List<Place> mylist, Context ctx, RecyclerViewClickListener listener) {
        this.places = mylist;
        this.ctx=ctx;
        this.itemListener=listener;
    }

    @Override
    public myholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.title_card_row,parent,false);
        myholder holder=new myholder(row);

        return holder;
    }

    @Override
    public void onBindViewHolder(myholder holder, final int position) {
        String title=places.get(position).getTilte();
       // String description=places.get(position).getDescription();
        Drawable imageDrawable=places.get(position).getImage();
        holder.title.setText(title);
        holder.image.setImageDrawable(imageDrawable);


    }


    @Override
    public int getItemCount() {
        return places.size();
    }

    class myholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        ImageView image;
        public myholder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.tile_title);
            image=(ImageView) itemView.findViewById(R.id.tile_picture);

            itemView.setOnClickListener(this);


        }
        @Override
        public void onClick(View view) {
            itemListener.recyclerViewListClicked(view,this.getLayoutPosition());

        }

    }
    public interface RecyclerViewClickListener
    {

        void recyclerViewListClicked(View v, int position);
    }

}
