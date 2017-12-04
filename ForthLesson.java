/** Homework for Lesson 4.
 *
 * @author: Dmitry Zhuravlev
 * @version 1.0, date 04.12.2017
 * @link to github: 
 */

import java.util.Random;
import java.util.Scanner;

public class ForthLesson {
    public static int SIZE = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Human WINS");
                break;
            }
            if (isMapFull()) {
                System.out.println("DRAW");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Computer WINS");
                break;
            }
            if (isMapFull()) {
                System.out.println("DRAW");
                break;
            }
        }
        System.out.println("CAME OVER");
    }
    public static boolean checkWin(char symb) {
        //Task 2. Try to use different method for winner checkin (i.e. - cycles).
        if (checkLines(symb)|| checkDiags(symb)) return true;
        return false;
    }
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Computer's turn to the point " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Please, enter coordinates like X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
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
    //We're checking all vertical and horizontal lines, using boolean expressions, for fullfilling with 'X' or 'O'.
    //In case of different symbols in a row or in a column this method returns 'false'
    public static boolean checkLines(char symb) {
        int aiX=0, aiY=0, var = 0;
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
            return false;
        }
    //We're checking two diagonal lines, using boolean expressions, for fullfilling with 'X' or 'O'.
    //In case of different symbols in a line this method returns 'false'
        public static boolean checkDiags(char symb) {
            boolean leftDiag = true;
            boolean rightDiag = true;
            for (int i=0; i<SIZE;i++) {
                leftDiag = leftDiag & (map[i][i] == symb);//Check the from-left-to-right diagonal
                rightDiag = rightDiag & (map[SIZE - i - 1][i] == symb);//Check the from-right-to-left diagonal
            }
                if (leftDiag || rightDiag) return true;
                return false;
        }
}

