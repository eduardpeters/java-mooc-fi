
public class Game {

    private final String homeTeam;
    private final String visitingTeam;
    private final int homeTeamScore;
    private final int visitingTeamScore;

    public Game(String homeTeam, String visitingTeam, int homeTeamScore, int visitingTeamScore) {
        this.homeTeam = homeTeam;
        this.visitingTeam = visitingTeam;
        this.homeTeamScore = homeTeamScore;
        this.visitingTeamScore = visitingTeamScore;
    }

    public String getHomeTeam() {
        return this.homeTeam;
    }

    public String getVisitingTeam() {
        return this.visitingTeam;
    }

    public String getWinner() {
        if (this.homeTeamScore > this.visitingTeamScore) {
            return this.homeTeam;
        } else {
            return this.visitingTeam;
        }
    }
}
