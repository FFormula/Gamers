package model;

import com.google.gson.annotations.Expose;

public class Player
{
    @Expose private String firstname;
    @Expose private String lastname;
    @Expose private GameType gameType;
    private Team team;
    @Expose int games;

    Player (
            String firstname,
            String lastname,
            GameType gameType)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gameType = gameType;
        this.team = null;
        this.games = 0;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public GameType getGameType() {
        return gameType;
    }

    void setTeam (Team team)
    {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    @Override
    public String toString()
    {
        return "Player [" +
                firstname + " " + lastname + "] of " +
                gameType + " member of Team [" +
                team + "]";
    }

    public int getGames () { return games; }

    void restoreParentTeam(Team team)
    {
        this.team = team;
    }
}
