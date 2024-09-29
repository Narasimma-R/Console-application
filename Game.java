package Game;

import java.util.*;

public class Game {

    public static void main(String[] args) throws Exception {
        HashSet<String> names = new HashSet<>();
        List<PlayerDetails> playerDetails = new ArrayList<>();
        Functions function = new Functions();
        OGGame og = new OGGame();
        Connectivity connection=new Connectivity();
        Scanner ip = new Scanner(System.in);
        String userName;
        while (true) {
            function.login();
            System.out.println("Enter Your Choice: ");
            int choice = ip.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter user Name : ");
                    ip.nextLine();
                    userName = ip.nextLine().toUpperCase().trim();
                    if (names.contains(userName)) {
                        for (PlayerDetails p : playerDetails) {
                            if (p.getUserName().equals(userName)) {
                                og.game(userName,ip,p);
                            }
                        }
                    } else if (connection.isUserExist(userName)) {
                        names.add(userName);
                        UUID uid=UUID.fromString(connection.getUserUid(userName));
                        int points=connection.getUserPoints(userName);
                        playerDetails.add(new PlayerDetails(uid,userName,points));
                        og.game(userName,ip,playerDetails.get(playerDetails.size()-1));
                    } else {
                        function.accountNotFound();
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Enter user Name : ");
                    ip.nextLine();
                    userName = ip.nextLine().toUpperCase().trim();
                    boolean bool = connection.isUserExist(userName);
                    if (names.contains(userName) || bool )
                        function.reTry();

                    if(!names.contains(userName) && !bool ) {
                        names.add(userName);
                        PlayerDetails newPlayer = new PlayerDetails(userName);
                        playerDetails.add(new PlayerDetails(userName));
                        connection.insertRecord(newPlayer.getUserUid(), newPlayer.getUserName());
                        function.accountCreationSuccessful(userName, newPlayer.getUserUid());
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    playerDetails.forEach(player ->{
                        try {
                            connection.updatePoints(player.getUserName(),player.getUserPoints());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
                    System.exit(0);
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }
}