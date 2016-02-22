package com.cameo;

/**
 * Created by Cameo on 11/20/2015.
 */

//TODO this class is currently not in use. Version 2 would use it to name and keep a running total of player points
public class Player {

    String name;
    int totalPoints;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void addTotalPoints(int pointsForHand) {
        totalPoints += pointsForHand;
    }

}

