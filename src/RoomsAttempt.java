
public class RoomsAttempt {
    private static final int MAP_SIZE = 3;
    private static final char EMPTY_TILE = '.';
    private static final char PLAYER_TILE = '@';

    private int playerX = 0;
    private int playerY = 0;
    private char[][] map = new char[MAP_SIZE][MAP_SIZE];
    private char prize; // Πρόσθεσε αυτό το πεδίο

    public RoomsAttempt(char prize) {
        this.prize = prize;
        initializeMap();
    }

    public void initializeMap() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = EMPTY_TILE;
            }
        }
        playerX = 0;
        playerY = 0;
        map[playerY][playerX] = PLAYER_TILE;
    }

    public void displayMap() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public boolean movePlayer(String direction) {
        direction = direction.trim().toUpperCase();

        switch (direction) {
            case "MOVE BACK":
                if (playerY > 0) {
                    map[playerY][playerX] = EMPTY_TILE;
                    playerY--;
                    map[playerY][playerX] = PLAYER_TILE;
                }
                break;
            case "MOVE LEFT":
                if (playerX > 0) {
                    map[playerY][playerX] = EMPTY_TILE;
                    playerX--;
                    map[playerY][playerX] = PLAYER_TILE;
                }
                break;
            case "MOVE FORWARD":
                if (playerY < MAP_SIZE - 1) {
                    map[playerY][playerX] = EMPTY_TILE;
                    playerY++;
                    map[playerY][playerX] = PLAYER_TILE;
                }
                break;
            case "MOVE RIGHT":
                if (playerX < MAP_SIZE - 1) {
                    map[playerY][playerX] = EMPTY_TILE;
                    playerX++;
                    map[playerY][playerX] = PLAYER_TILE;
                }
                break;
        }

        // Check if the player has reached the goal (2, 2)
        if (playerX == MAP_SIZE - 1 && playerY == MAP_SIZE - 1) {
            System.out.println("Congratulations! You have reached the goal! Prize: " + prize);
            return true;
        }
        return false;
    }

    public void displayRoomLetter() {
        System.out.println("Find letter " + prize);
    }
}
