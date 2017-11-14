package com.traker.traker.beans.enums;

/**
 * Created by idoengel on 9/18/17.
 */

public enum RelationshipStatus {
    SINGLE("single"),
    IN_A_RELATIONSHIP("in a relationship"),
    ANONYMOUS("anonymous");

    private String friendlyName;

    RelationshipStatus(String friendlyName) {
        this.friendlyName = friendlyName;
    }
    @Override
    public String toString(){
        return friendlyName;
    }
}
