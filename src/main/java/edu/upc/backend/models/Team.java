package edu.upc.backend.models;

public class Team {
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Member[] getMembers() {
        return members;
    }

    public void setMembers(Member[] members) {
        this.members = members;
    }

    String team;
    Member[] members;

    public Team(){}
    public Team(String team, Member[] members)
    {
        setTeam(team);
        setMembers(members);
    }

    @Override
    public String toString()
    {
        String res = String.format("Team: %s",team);
        for(Member m : members)
        {
            res += "\n" + m.toString();
        }
        return  res;
    }


}
