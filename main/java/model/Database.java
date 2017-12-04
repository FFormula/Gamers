package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Database
{
    @Expose
    private List<League> leagues;

    public Database()
    {
        leagues = new ArrayList<League> ();
    }

    public void addLeague (League league)
    {
        leagues.add(league);
    }

    public List<League> getLeagues ()
    {
        return leagues;
    }

    public String serialize()
    {
        Gson gson = new GsonBuilder ()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation ()
                .create();
        return gson.toJson(this);
    }

    static public Database deserialize(String json)
    {
        Database db = new Gson().fromJson(json, Database.class);
        for (League league : db.leagues)
            league.restoreTeamsParentLeagues();
        return db;
    }
}
