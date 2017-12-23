package com.traker.traker.beans.enums;

import com.traker.traker.R;

/**
 * Created by idoroiengel on 12/14/17.
 */

public enum TrakerClassEnum {
        AEROBIC(R.string.traker_class_explorer_traker_class_enum_aerobic_text,
                R.drawable.weight_goal_icon),
        BODY_BUILDING(R.string.traker_class_explorer_traker_class_enum_body_building_text,
                R.drawable.weight_goal_icon),
        STRESS_RELIEF(R.string.traker_class_explorer_traker_class_enum_stress_relief_text,
                R.drawable.weight_goal_icon);

    private int name;
    private int imageUri;

    TrakerClassEnum(int name, int imageUri) {
        this.name = name;
        this.imageUri = imageUri;
    }



    public int getName() {
        return name;
    }

    private int getImageUri() {
        return imageUri;
    }

}