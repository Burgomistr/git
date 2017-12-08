/** Homework for Lesson 5. TicTacToe using class.
 *
 * @author: Dmitry Zhuravlev
 * @version 1.0, date 08.12.2017
 * @link to github: https://github.com/Burgomistr/git
*/
import java.util.Random;
import java.util.Scanner;

public class HW5TicTacToe {
    public static void main(String[] args){
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}

class TicTacToe {
    public void playGame() {
        MapClass cell = new MapClass(3);
        Human human = new Human(cell);
        Ai ai = new Ai(cell);
        cell.initMap();
        cell.printMap();
        while (true) {
            human.humanTurn();
            cell.printMap();
            if (cell.checkWin(cell.DOT_X)) {
                System.out.println("Human WINS!!!");
                break;
            }
            if (cell.isMapFull()) {
                System.out.println("Sorry, DRAW.");
                break;
            }
            ai.aiTurn();
            cell.printMap();
            if (cell.checkWin(cell.DOT_O)) {
                System.out.println("Computer WINS!!!");
                break;
            }
            if (cell.isMapFull()) {
                System.out.println("Sorry, DRAW.");
                break;
            }
        }
    }


    class MapClass {
        final int SIZE;
        final char DOT_EMPTY = '•';
        final char DOT_X = 'X';
        final char DOT_O = 'O';
        char[][] map;

        MapClass(int SIZE) {
            this.SIZE = SIZE;
            this.map = new char[SIZE][SIZE];
        }

        void initMap() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        void printMap() {
            for (int i = 0; i <= SIZE; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            for (int i = 0; i < SIZE; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        boolean isCellValid(int x, int y) {
            if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
            if (map[y][x] == DOT_EMPTY) return true;
            return false;
        }

        boolean checkWin(char symb) {
            int aiX = 0, aiY = 0, var = 0;
            boolean columns, rows;
            for (int i = 0; i < SIZE; i++) {
                columns = true;
                rows = true;
                for (int j = 0; j < SIZE; j++) {
                    columns = columns & (map[i][j] == symb);//Check columns for fullfilling with the only one symbol
                    rows = rows & (map[j][i] == symb);//Check rows for fullfilling with the only one symbol
                }
                if (columns || rows) return true;
            }
            boolean leftDiag = true;
            boolean rightDiag = true;
            for (int i = 0; i < SIZE; i++) {
                leftDiag = leftDiag & (map[i][i] == symb);//Check the from-left-to-right diagonal
                rightDiag = rightDiag & (map[SIZE - i - 1][i] == symb);//Check the from-right-to-left diagonal
            }
            if (leftDiag || rightDiag) return true;
            return false;
        }

        boolean isMapFull() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == DOT_EMPTY) return false;
                }
            }
            return true;
        }
    }

    class Human {
        MapClass cell;
        Scanner sc = new Scanner(System.in);

        Human(MapClass cell) {
            this.cell = cell;
        }

        void humanTurn() {
            int x, y;
            do {
                System.out.println("Please, enter coordinates like X Y");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            } while (!cell.isCellValid(x, y)); // while(isCellValid(x, y) == false)
            cell.map[y][x] = cell.DOT_X;
        }
    }

    class Ai {
        MapClass cell;

        Ai(MapClass cell) {
            this.cell = cell;
        }

        void aiTurn() {
            Random rand = new Random();
            int x, y;
            do {
                x = rand.nextInt(cell.SIZE);
                y = rand.nextInt(cell.SIZE);
            } while (!cell.isCellValid(x, y));
            System.out.println("Computer's turn to the point " + (x + 1) + " " + (y + 1));
            cell.map[y][x] = cell.DOT_O;
        }
    }
}
