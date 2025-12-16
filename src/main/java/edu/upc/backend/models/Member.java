package edu.upc.backend.models;

public class Member {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    String name;
    String avatar;
    int points;

    public Member(){}
    public Member(String name, String avatar, Integer points){
        setName(name);
        setAvatar(avatar);
        setPoints(points);
    }

    @Override
    public String toString()
    {
        return String.format("Name: %s, Avatar: %s, Points: %d", name,avatar,points);
    }
}
