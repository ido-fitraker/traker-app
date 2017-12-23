package com.traker.traker.beans;


import com.traker.traker.beans.enums.FitnessGoal;
import com.traker.traker.beans.enums.RelationshipStatus;

/**
 * Created by idoengel on 7/20/17.
 */


public class TrakerUser {
    private long id;
    private String fullName;
    private long phone;
    private String profileImageURI;
    private String email;
    private String gender;
    private long birthday;
    private long facebookId;
    private long tokenId;
    private int socialRating;
    private int systemRating;
    private long goalsId;
    private int points;
    private long level;
    private long coachId;
    private long typeId;
    private int age;
    private RelationshipStatus status;
    private FitnessGoal fitnessGoal;
    private int coins;
    private long height;
    private long weight;

    public TrakerUser() {
    }

    public TrakerUser(long id, String fullName, long phone, String profileImageURI, String email, String gender,
                      long birthday, long facebookId, long tokenId, int socialRating, int systemRating, long goalsId,
                      int points, long level, long coachId, long typeId, int age, RelationshipStatus status, int coins) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.profileImageURI = profileImageURI;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.facebookId = facebookId;
        this.tokenId = tokenId;
        this.socialRating = socialRating;
        this.systemRating = systemRating;
        this.goalsId = goalsId;
        this.points = points;
        this.level = level;
        this.coachId = coachId;
        this.typeId = typeId;
        this.age = age;
        this.status = status;
        this.coins = coins;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getProfileImageURI() {
        return profileImageURI;
    }

    public void setProfileImageURI(String profileImageURI) {
        this.profileImageURI = profileImageURI;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public long getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(long facebookId) {
        this.facebookId = facebookId;
    }

    public long getTokenId() {
        return tokenId;
    }

    public void setTokenId(long tokenId) {
        this.tokenId = tokenId;
    }

    public int getSocialRating() {
        return socialRating;
    }

    public void setSocialRating(int socialRating) {
        this.socialRating = socialRating;
    }

    public int getSystemRating() {
        return systemRating;
    }

    public void setSystemRating(int systemRating) {
        this.systemRating = systemRating;
    }

    public long getGoalsId() {
        return goalsId;
    }

    public void setGoalsId(long goalsId) {
        this.goalsId = goalsId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public long getCoachId() {
        return coachId;
    }

    public void setCoachId(long coachId) {
        this.coachId = coachId;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public void setAge(int age) { this.age = age; }

    public int getAge() { return age; };

    public void setStatus(RelationshipStatus status) { this.status = status; }

    public RelationshipStatus getStatus() { return status; }

    public FitnessGoal getFitnessGoal() { return fitnessGoal; }

    public void setFitnessGoal(FitnessGoal fitnessGoal) { this.fitnessGoal = fitnessGoal; }

    @Override
    public String toString() {
        return "TrakerUser{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phone=" + phone +
                ", profileImageURI='" + profileImageURI + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", facebookId=" + facebookId +
                ", tokenId=" + tokenId +
                ", socialRating=" + socialRating +
                ", systemRating=" + systemRating +
                ", goalsId=" + goalsId +
                ", points=" + points +
                ", level=" + level +
                ", coachId=" + coachId +
                ", typeId=" + typeId +
                ", age=" + age +
                ", status=" + status +
                ", fitnessGoal=" + fitnessGoal +
                '}';
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}