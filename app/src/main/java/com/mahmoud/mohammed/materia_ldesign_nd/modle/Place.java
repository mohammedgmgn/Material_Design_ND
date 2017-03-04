package com.mahmoud.mohammed.materia_ldesign_nd.modle;

import android.graphics.drawable.Drawable;

/**
 * Created by siko on 3/4/2017.
 */

public class Place {
   private String Tilte;
    private String Description;
    private Drawable Image;

    public Place() {
    }

    public String getTilte() {
        return Tilte;
    }

    public void setTilte(String yilte) {
        Tilte = yilte;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Drawable getImage() {
        return Image;
    }

    public void setImage(Drawable image) {
        Image = image;
    }
}
