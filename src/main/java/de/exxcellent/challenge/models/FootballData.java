package de.exxcellent.challenge.models;

public class FootballData {
    private String team;
    private int goals;
    private int goalsAllowed;

    public FootballData(String team, int goals, int goalsAllowed) {
        this.team = team;
        this.goals = goals;
        this.goalsAllowed = goalsAllowed;
    }  

    public String getTeam() {
        return this.team;
    } 

    public int getGoalSpread() {
        return Math.abs(this.goals - this.goalsAllowed);
    }
}
