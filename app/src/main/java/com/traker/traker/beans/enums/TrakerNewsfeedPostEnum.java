package com.traker.traker.beans.enums;

import com.traker.traker.R;

/**
 * Created by idoroiengel on 12/7/17.
 */

public enum TrakerNewsfeedPostEnum {

    LIKE_BUTTON(R.drawable.traker_newsfeed_post_like_icon, R.drawable.weight_goal_icon),
    COMMENT_BUTTON(R.drawable.traker_newsfeed_post_comment_icon, R.drawable.build_goal_icon),
    SHARE_BUTTON(R.drawable.traker_newsfeed_post_share_icon, R.drawable.peaceful_life_goal_icon);

    private final int id;
    private final int pressedId;

    TrakerNewsfeedPostEnum(int id, int pressedId) {
        this.id = id;
        this.pressedId = pressedId;
    }

    public int getId() {
        return id;
    }

    public int getPressedId() {
        return pressedId;
    }
}
