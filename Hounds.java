package org.example;

import java.util.Random;

public class Hounds {
    char[][] gameboard;
    int x;
    int y;

    Hounds(char[][] board, int x, int y) {
        this.gameboard = board;
        this.x = x;
        this.y = y;
        this.gameboard[x][y] = 'H';
    }

    void Move() {
        int x = 1;
        int y = -1;
        double start = System.nanoTime();
        while (!isValid(x, y)) {
            if (System.nanoTime() - start >= 500000000) {
                break;
            }
            Random RANDOM = new Random();
            x = 1;
            y = RANDOM.nextInt(2) == 0 ? -1 : 1;
        }
        this.setHoundPOS((this.x + x), (this.y + y));

    }

    void setHoundPOS(int x, int y) {
        this.gameboard[this.x][this.y] = '.';
        this.x = x;
        this.y = y;
        this.gameboard[this.x][this.y] = 'H';
    }

    public boolean isValid(int x, int y) {
        if (((this.x + x) - 1) > 7 || ((this.y + y) - 1) < 0 || ((this.y + y) - 1) > 7) {
            return false;
        }
        if (this.gameboard[(this.x + x)][(this.y + y)] != '.') {
            return false;
        }
        return true;
    }
}
