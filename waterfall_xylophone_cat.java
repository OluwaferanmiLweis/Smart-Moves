import java.util.*;
import java.io.*;

public class ChessClub {
    //Private variables
    private String clubName;
    private int maxMembers;
    private List<String> members;
    private List<ChessGame> games;

    //Constructor
    public ChessClub(String name, int max) {
        this.clubName = name;
        this.maxMembers = max;
        this.members = new ArrayList<>();
        this.games = new ArrayList<>();
    }

    //Getters & Setters
    public String getClubName() {
        return this.clubName;
    }

    public void setClubName(String name) {
        this.clubName = name;
    }

    public int getMaxMembers() {
        return this.maxMembers;
    }

    public void setMaxMembers(int max) {
        this.maxMembers = max;
    }

    public List<String> getMembers() {
        return this.members;
    }

    public List<ChessGame> getGames() {
        return this.games;
    }

    //Member management
    public void addMember(String name) {
        if (members.size() < maxMembers) {
            members.add(name);
            System.out.println(name + " has been added to the chess club!");
        } else {
            System.out.println("Sorry, the club is full!");
        }
    }

    public void removeMember(String name) {
        if (members.contains(name)) {
            members.remove(name);
            System.out.println(name + " has been removed from the chess club!");
        } else {
            System.out.println(name + " is not a member of the chess club!");
        }
    }

    public void printMembers() {
        System.out.println("Members of " + this.clubName + ":");
        for (String member : members) {
            System.out.println(member);
        }
    }

    //Game management
    public void addGame(ChessGame game) {
        games.add(game);
    }

    public void removeGame(ChessGame game) {
        games.remove(game);
    }

    public void printGames() {
        System.out.println("Games in " + this.clubName + ":");
        for (ChessGame game : games) {
            game.printGame();
        }
    }

    public void saveGames() {
        try {
            PrintWriter writer = new PrintWriter("chess_games.txt");

            for (ChessGame game : games) {
                writer.println(game.toString());
            }

            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("Unable to save chess games. File not found.");
        }
    }

    public void loadGames() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("chess_games.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String player1 = data[0];
                String player2 = data[1];
                int moves = Integer.parseInt(data[2]);

                ChessGame game = new ChessGame(player1, player2, moves);
                games.add(game);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Unable to load chess games. File not found.");
        }
    }

    public void resetGames() {
        games.clear();
    }

}