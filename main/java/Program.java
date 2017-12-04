import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.*;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class Program {

    Database db;

    public static void main(String[] args) throws Exception
    {
        Program program = new Program ();
        program.init ();
        String json = program.save ();
        System.out.println (json);
        program.load (json);
        program.print();
    }

    void print ()
    {
        for (League league : db.getLeagues ())
        {
            System.out.println (league);
            for (Team team : league.getTeams ())
            {
                System.out.println (team);
                for (Player player : team.getPlayers ())
                    System.out.println (player);
            }
        }
    }

    void load (String json)
    {
        db = Database.deserialize (json);
    }

    String save() throws IOException
    {
        return db.serialize ();
    }

    void init() throws GameException
    {
        db = new Database ();

        League leagueBask = new League ("Krepsinio Liga", GameType.Basketball);
        db.addLeague (leagueBask);
        addBaskerballTeam1 (leagueBask);
        addBaskerballTeam2 (leagueBask);
        addBaskerballTeam3 (leagueBask);

        League leagueFoot = new League ("Futbolo Liga", GameType.Football);
        db.addLeague (leagueFoot);
        addFootballTeam1 (leagueFoot);
        addFootballTeam2 (leagueFoot);
        addFootballTeam3 (leagueFoot);
    }

    void addBaskerballTeam1(League leagueBask) throws GameException {
        Team teamBask = new Team ("Lietuvos Rytas", GameType.Basketball);
        leagueBask.addTeam (teamBask);
        BasketballPlayer[] playersBask = new BasketballPlayer[5];
        playersBask[0] = new BasketballPlayer ("Josh", "Akognon", BasketballPosition.Defender);
        playersBask[1] = new BasketballPlayer ("Chris", "Kramer", BasketballPosition.Defender);
        playersBask[2] = new BasketballPlayer ("Taylor", "Brown", BasketballPosition.Forwarder);
        playersBask[3] = new BasketballPlayer ("Travis", "Peterson", BasketballPosition.Forwarder);
        playersBask[4] = new BasketballPlayer ("Artūras", "Gudaitis", BasketballPosition.Center);
        for (BasketballPlayer player : playersBask)
            teamBask.addPlayer (player);
    }

    void addBaskerballTeam2(League leagueBask) throws GameException {
        Team teamBask = new Team ("Žalgiris", GameType.Basketball);
        leagueBask.addTeam (teamBask);
        BasketballPlayer[] playersBask = new BasketballPlayer[5];
        playersBask[0] = new BasketballPlayer ("Rolandas", "Alijevas", BasketballPosition.Defender);
        playersBask[1] = new BasketballPlayer ("Dalius", "Lubys", BasketballPosition.Defender);
        playersBask[2] = new BasketballPlayer ("Justinas", "Pavlavičius", BasketballPosition.Forwarder);
        playersBask[3] = new BasketballPlayer ("Nerijus", "Strazdauskas", BasketballPosition.Forwarder);
        playersBask[4] = new BasketballPlayer ("Jonas", "Mačiulis", BasketballPosition.Center);
        for (BasketballPlayer player : playersBask)
            teamBask.addPlayer (player);
    }

    void addBaskerballTeam3(League leagueBask) throws GameException {
        Team teamBask = new Team ("Palanga", GameType.Basketball);
        leagueBask.addTeam (teamBask);
        BasketballPlayer[] playersBask = new BasketballPlayer[5];
        playersBask[0] = new BasketballPlayer ("Laurynas", "Beliauskas", BasketballPosition.Defender);
        playersBask[1] = new BasketballPlayer ("Mindaugas", "Reminas", BasketballPosition.Defender);
        playersBask[2] = new BasketballPlayer ("Antanas", "Montrimavičius", BasketballPosition.Forwarder);
        playersBask[3] = new BasketballPlayer ("Vitalijus", "Kozys", BasketballPosition.Forwarder);
        playersBask[4] = new BasketballPlayer ("Kadeem", "Green", BasketballPosition.Center);
        for (BasketballPlayer player : playersBask)
            teamBask.addPlayer (player);
    }

    void addFootballTeam1(League leagueFoot) throws GameException
    {
        Team teamFoot = new Team ("Vilnius", GameType.Football);
        leagueFoot.addTeam (teamFoot);
        FootballPlayer [] playersFoot = new FootballPlayer[5];
        playersFoot [0] = new FootballPlayer ("Carlos", "Bacca", FootballPosition.Defender);
        playersFoot [1] = new FootballPlayer ("Kevin", "Gameiro", FootballPosition.Defender);
        playersFoot [2] = new FootballPlayer ("Samuel", "Umtiti", FootballPosition.Forwarder);
        playersFoot [3] = new FootballPlayer ("Ilkay", "Gundogan", FootballPosition.Forwarder);
        playersFoot [4] = new FootballPlayer ("Honourable", "Mentions", FootballPosition.Goalkeeper);
        for (FootballPlayer player : playersFoot)
            teamFoot.addPlayer (player);
    }

    void addFootballTeam2(League leagueFoot) throws GameException
    {
        Team teamFoot = new Team ("Visaginas", GameType.Football);
        leagueFoot.addTeam (teamFoot);
        FootballPlayer [] playersFoot = new FootballPlayer[5];
        playersFoot [0] = new FootballPlayer ("Lionel", "Messi", FootballPosition.Defender);
        playersFoot [1] = new FootballPlayer ("Cristiano", "Ronaldo", FootballPosition.Defender);
        playersFoot [2] = new FootballPlayer ("Luis", "Suarez", FootballPosition.Forwarder);
        playersFoot [3] = new FootballPlayer ("Sergio", "Aguero", FootballPosition.Forwarder);
        playersFoot [4] = new FootballPlayer ("Jeroen", "Zoet", FootballPosition.Goalkeeper);
        for (FootballPlayer player : playersFoot)
            teamFoot.addPlayer (player);
    }

    void addFootballTeam3(League leagueFoot) throws GameException
    {
        Team teamFoot = new Team ("Kaunas", GameType.Football);
        leagueFoot.addTeam (teamFoot);
        FootballPlayer [] playersFoot = new FootballPlayer[5];
        playersFoot [0] = new FootballPlayer ("Manuel", "Neuer", FootballPosition.Defender);
        playersFoot [1] = new FootballPlayer ("Gareth", "Bale", FootballPosition.Defender);
        playersFoot [2] = new FootballPlayer ("Andres", "Iniesta", FootballPosition.Forwarder);
        playersFoot [3] = new FootballPlayer ("Arjen", "Robben", FootballPosition.Forwarder);
        playersFoot [4] = new FootballPlayer ("Diego", "Alves", FootballPosition.Goalkeeper);
        for (FootballPlayer player : playersFoot)
            teamFoot.addPlayer (player);
    }

}
