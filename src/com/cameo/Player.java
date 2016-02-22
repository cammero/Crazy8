package com.cameo;

/**
 * Created by Cameo on 11/20/2015.
 */
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

