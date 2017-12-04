package model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeagueTest
{
    @Test(expected = GameException.class)
    public void addTeam() throws Exception
    {
        League league = new League ("Liga", GameType.Basketball);
        Team team = new Team ("Team", GameType.Football);
        league.addTeam (team);
    }
}