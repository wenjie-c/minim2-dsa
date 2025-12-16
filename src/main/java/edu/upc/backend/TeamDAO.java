package edu.upc.backend;

import edu.upc.backend.models.Member;
import edu.upc.backend.models.Team;

import java.util.LinkedList;
import java.util.List;

/**
 * DAO de ejemplo
 */
public class TeamDAO implements  IModel{

    List<Team> _teams;

    static private TeamDAO _instance;
    static public TeamDAO getInstance()
    {
        if(_instance == null) _instance = new TeamDAO();
        return _instance;
    }
    private TeamDAO()
    {
        _teams = new LinkedList<>();
        Member[] members = new Member[]
                {
                        new Member("Juan","https://cdn.pixabay.com/photo/2017/07/11/15/51/kermit-2493979_1280.png",250),
                        new Member("Palomo","..",200)
                };
        Team example = new Team("porxinos",members);
        _teams.add(example);
    }

    @Override
    public Team find(int id) {
        return _teams.get(id);
    }
}
