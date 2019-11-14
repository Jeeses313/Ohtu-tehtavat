package ohtu;

public class Player {

    private String name;
    private String team;
    private String nationality;
    private String birthdate;
    private int goals;
    private int assists;
    private int penalties;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getGoals() {
        return goals;
    }

    public String getNationality() {
        return nationality;
    }

    public int getAssists() {
        return assists;
    }

    public int getPoints() {
        return goals + assists;
    }

    @Override
    public String toString() {
        return name + " team " + team + " goals " + goals + " assists " + assists;
    }

}
