package org.example;

import java.util.Scanner;
import java.util.Random;

public class GameController {
    public static final int ROWS = 8;
    public static final int COLUMNS = 8;
    public static final char EMPTY = '.';
    private static char[][] board;
    private static Hounds[] Enemy = new Hounds[4];
    private static Player[] Player = new Player[1];

    public GameController() {
        board = new char[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = EMPTY;
            }
        }
        /* board[7][4] = FOX; */
        Player[0] = new Player(board, ROWS-1, 4);
        Enemy[0] = new Hounds(board, 0, 1);
        Enemy[1] = new Hounds(board, 0, 3);
        Enemy[2] = new Hounds(board, 0, 5);
        Enemy[3] = new Hounds(board, 0, COLUMNS-1);
    }

    public void Draw() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        int winCounter = 0;
        int loseCounter = 0;

        System.out.println("Szeretnél játszani? i/n");
        Scanner startScanner = new Scanner(System.in);
        String start = startScanner.nextLine();

        while(start.equals("i")){

        Scanner scanner = new Scanner(System.in);
        GameController game = new GameController();

        Player[0].WIN = false;
        Player[0].LOSE = false;

        while (!Player[0].WIN && !Player[0].LOSE) {
            game.Draw();
            System.out.println("Input:");
            int move = scanner.nextInt();
            System.out.println();
            if (move == 1) {
                Player[0].Move(1);
            } else if (move == 2) {
                Player[0].Move(2);
            } else if (move == 3) {
                Player[0].Move(3);
            } else if (move == 4) {
                Player[0].Move(4);
            } else if (move == 0) {
                Player[0].LOSE = true;
                break;
            }
            Random rnd = new Random();
            Enemy[rnd.nextInt(4)].Move();
        }
            System.out.println("GAME OVER");
            System.out.println(Player[0].WIN ? "Gratulálok nyertél" : "Sajnos vesztettél");

            if(Player[0].WIN)
                winCounter++;
            if(Player[0].LOSE)
                loseCounter++;

            System.out.println("Győzelmeid száma: " + winCounter + " Veszteségeid száma: " + loseCounter);

            System.out.println("Szeretnél játszani? i/n");
            start = startScanner.nextLine();
            }
        }
    }

