package model;

import com.google.gson.annotations.Expose;

public class FootballPlayer extends Player
{
    @Expose private FootballPosition position;
    @Expose private int goals;

    public FootballPlayer (
            String firstname,
            String lastname,
            FootballPosition position)
    {
        super (firstname, lastname, GameType.Football);
        this.position = position;
        this.goals = 0;
    }

    public FootballPosition getPosition () { return position; }

    public void addGame (int playersGoals)
    {
        games ++;
        goals += playersGoals;
    }

    public int getPoints (int points)
    {
        return points;
    }
}
