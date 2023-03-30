
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("File:");
        String file = scan.nextLine();

        ArrayList<Game> games = readGamesFromFile(file);

        System.out.println("Team:");
        String team = scan.nextLine();
        printTeamStatistics(games, team);
    }

    public static ArrayList<Game> readGamesFromFile(String file) {
        ArrayList<Game> games = new ArrayList<>();

        try ( Scanner fileScanner = new Scanner(Paths.get(file))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                String[] splitLine = line.split(",");
                String homeTeam = splitLine[0];
                String visitingTeam = splitLine[1];
                int homeTeamPoints = Integer.valueOf(splitLine[2]);
                int visitingTeamPoints = Integer.valueOf(splitLine[3]);

                games.add(new Game(homeTeam, visitingTeam, homeTeamPoints, visitingTeamPoints));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return games;
    }

    public static void printTeamStatistics(ArrayList<Game> games, String team) {
        int gameCount = 0;
        int wins = 0;

        for (Game game : games) {
            if (team.equals(game.getHomeTeam()) || team.equals(game.getVisitingTeam())) {
                gameCount++;
                if (team.equals(game.getWinner())) {
                    wins++;
                }
            }
        }

        System.out.println("Games: " + gameCount);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + (gameCount - wins));
    }
}
