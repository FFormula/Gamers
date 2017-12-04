package model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class League
{
    @Expose private String name;
    @Expose private GameType gameType;
    @Expose private List<Team> teams;

    public League (String name, GameType gameType)
    {
        this.name = name;
        this.gameType = gameType;
        teams = new ArrayList<Team>();
    }

    public String getName () { return name; }

    public GameType getGameType () { return gameType; }

    public void addTeam (Team team) throws GameException
    {
        if (gameType != team.getGameType())
            throw new GameException("GameTypes of Leauge and Team mismatch");
        teams.add (team);
        team.addLeague(this);
    }

    public List<Team> getTeams () { return teams; }

    @Override
    public String toString()
    {
        return "LEAGUE [" + name + "] - " + gameType.toString() + " - " + teams.size() + " command(s)";
    }

    void restoreTeamsParentLeagues()
    {
        for (Team team : teams)
            team.restoreParentLeague (this);
    }
}
