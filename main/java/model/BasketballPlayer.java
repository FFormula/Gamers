package model;

import com.google.gson.annotations.Expose;

public class BasketballPlayer extends Player
{
    @Expose private BasketballPosition position;
    @Expose private int points;

    public BasketballPlayer (
        String firstname,
        String lastname,
        BasketballPosition position)
    {
        super (firstname, lastname, GameType.Basketball);
        this.position = position;
        this.points = points;
    }

    public BasketballPosition getPosition () { return position; }

    public void addGame (int playerPoints)
    {
        games ++;
        points += playerPoints;
    }

    public int getPoints (int points)
    {
        return points;
    }
}
