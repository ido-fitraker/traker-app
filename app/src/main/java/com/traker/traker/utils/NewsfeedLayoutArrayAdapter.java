package com.traker.traker.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.traker.traker.components.TrakerNewsfeedPost;

/**
 * Created by idoroiengel on 12/23/17.
 */

public class NewsfeedLayoutArrayAdapter extends ArrayAdapter {

    private TrakerNewsfeedPost mPost;

    public NewsfeedLayoutArrayAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return new TrakerNewsfeedPost(TrakerApplication.getContext());
    }
}
