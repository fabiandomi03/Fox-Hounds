package org.example;

public class Player {
    char[][] gameboard;
    int x;
    int y;
    boolean WIN = false;
    boolean LOSE = false;
    char EMPTY = '.';
    char FOX = 'F';

    Player(char[][] board, int x, int y) {
        this.gameboard = board;
        this.x = x;
        this.y = y;
        this.gameboard[x][y] = FOX;
    }

    void Move(int type) {
        int x = this.x;
        int y = this.y;
        this.gameboard[x][y] = EMPTY;
        if (type == 1) {
            if (!isValidMove(x - 1, y + 1)) {
                this.gameboard[x][y] = FOX;
            } else {
                setPlayerPOS((this.x - 1), (this.y + 1));
            }
        } else if (type == 2) {
            if (!isValidMove(x - 1, y - 1)) {
                this.gameboard[x][y] = FOX;
            } else {
                setPlayerPOS((this.x - 1), (this.y - 1));
            }
        } else if (type == 3) {
            if (!isValidMove(x + 1, y + 1)) {
                this.gameboard[x][y] = FOX;
            } else {
                setPlayerPOS((this.x + 1), (this.y + 1));
            }
        } else if (type == 4) {
            if (!isValidMove(x + 1, y - 1)) {
                this.gameboard[x][y] = FOX;
            } else {
                setPlayerPOS((this.x + 1), (this.y - 1));
            }
        }
    }

    void setPlayerPOS(int x, int y) {
        this.gameboard[this.x][this.y] = '.';
        this.x = x;
        this.y = y;
        this.gameboard[this.x][this.y] = FOX;
        isPlayerWin();

        if (isValidMove((this.x - 1), (this.y + 1)) && isValidMove((this.x - 1), (this.y - 1)) && isValidMove((this.x + 1), (this.y + 1))
                && isValidMove((this.x + 1), (this.y - 1))) {
            if (this.gameboard[(this.x - 1)][(this.y + 1)] == 'H' || this.gameboard[(this.x - 1)][(this.y - 1)] == 'H'
                    || this.gameboard[(this.x + 1)][(this.y + 1)] == 'H'
                    || this.gameboard[(this.x + 1)][(this.y - 1)] == 'H') {
                LOSE = true;
            }
        }
    }

    private boolean isValidMove(int COL, int ROW) {
        if (ROW > (this.gameboard.length - 1) || this.gameboard.length < 0) {
            return false;
        }
        if (COL > (this.gameboard.length - 1) || COL < 0) {
            return false;
        }
        if (this.gameboard[COL][ROW] != EMPTY) {
            return false;
        }
        return true;
    }

    void isPlayerWin() {
        if (this.x == 0) {
            this.WIN = true;
        }
    }
}
