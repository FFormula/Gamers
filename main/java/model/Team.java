package model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Team
{
    @Expose private String name;
    @Expose private GameType gameType;
    @Expose private int games;
    private List<League> leagues;
    @Expose private List<Player> players;

    public Team (String name, GameType gameType)
    {
        this.name = name;
        this.gameType = gameType;
        this.games = 0;
        leagues = new ArrayList<League>();
        players = new ArrayList<Player>();
    }

    public String getName() { return name; }
    public GameType getGameType() { return gameType; }
    public int getGames() { return games; }

    public List<League> getLeagues() { return leagues; }

    public void addPlayer (Player player) throws GameException
    {
        if (gameType != player.getGameType())
            throw new GameException("GameTypes of Player and Team mismatch");
        players.add (player);
        player.setTeam (this);
    }

    public List<Player> getPlayers() { return players; }

    void addLeague (League league)
    {
        leagues.add (league);
    }

    public void addGame ()
    {
        games ++;
    }

    @Override
    public String toString()
    {
        return "Team [" + this.name + "]";
    }

    void restoreParentLeague (League league)
    {
        if (leagues == null)
            leagues = new ArrayList<League>();
        this.addLeague (league);
        for (Player player : players)
            player.restoreParentTeam (this);
    }
}
