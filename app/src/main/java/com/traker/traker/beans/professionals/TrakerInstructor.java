package com.traker.traker.beans.professionals;

import android.media.Image;
import android.net.Uri;



/**
 * Created by idoroiengel on 12/13/17.
 */

public class TrakerInstructor implements ProfessionalStaffPerson{

    private String name;
    private Uri imageUri;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }
}
