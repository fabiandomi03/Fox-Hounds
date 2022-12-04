package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Szeretnél játszani? i/n");


        Scanner beSzoveg = new Scanner(System.in);
        Scanner beSzam = new Scanner(System.in);
        String choice = beSzoveg.nextLine();

        while(choice.equals("i")){
            System.out.println("Milyen méretű táblában szeretnél játszani? (4x4 - 12x12)");

            int choice2 = beSzam.nextInt();

            int[][] game = new int[choice2][choice2];

            for (int i = 0; i < game.length; i++) {
                for (int j = 0; j < game.length; j++) {
                    game[i][j] = 0;
                }
            }

            final int dog = 5;
            final int fox = 1;

            for (int i = 0; i < game.length; i++) {
                if((i+1) % 2 == 0)
                    game[0][i] = dog;

            }

            int choiceRow = choice2-1;
            int choiceColumn = 0;

            game[choiceRow][choiceColumn] = fox;

            int continuegame = 0;

            kiir(game);
            game[choiceRow][choiceColumn] = 0;

            int szam1 = 0;
            int szam2 = 0;

            boolean state = false;

            while(!state) {

                state = false;

                System.out.println("Következő lépés? 1 - jobbra fel; 2 - balra fel; 3 jobbra le; 4 - balra le");
                int choice4 = beSzam.nextInt();
                game[choiceRow][choiceColumn] = 0;

                int[] lepes = makeStep(choice4);


                if (choiceRow + lepes[0] < 0 || choiceRow + lepes[0] > choice2-1 || choiceColumn + lepes[1] < 0 || choiceColumn + lepes[1] > choice2-1)
                    System.out.println("Hibás lépés");
                else if (game[choiceRow + lepes[0]][choiceColumn + lepes[1]] == dog) {
                    System.out.println("Vége a játéknak.");
                    state = true;
                }
                else {
                    if(choiceRow + lepes[0] == 0)
                    {
                        System.out.println("Gratulálok, nyertél!");
                        state = true;
                    }
                    else {
                        game[choiceRow + lepes[0]][choiceColumn + lepes[1]] = fox;
                        choiceRow += lepes[0];
                        choiceColumn += lepes[1];
                        continuegame++;
                        kiir(game);
                        }
                    }
                }

            System.out.println("Szeretnél játszani? i/n");
            choice = beSzoveg.nextLine();
        }

    }

    static void kiir(int[][]t){
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t.length; j++) {
                if(t[i][j] == 0)
                    System.out.print("? ");
                if(t[i][j] == 5)
                    System.out.print("K ");
                if(t[i][j] == 1)
                    System.out.print("R ");

            }

            System.out.println("");

        }
    }

    static int randomizeDogs(int sizeOfTable){
        int step = 0;
        return step;
    }

    static int[] makeStep(int sz){
        int[] szam1 = new int[2];
        int szam2 = 0;

        if (sz == 1) {
            szam1[0] = -1;
            szam1[1] = 1;
        }
        if (sz == 2) {
            szam1[0] = -1;
            szam1[1] = -1;
        }
        if (sz == 3) {
            szam1[0] = 1;
            szam1[1] = 1;
        }
        if (sz == 4) {
            szam1[0] = 1;
            szam1[1] = -1;

        }


        return szam1;
    }

    static void makeDogStep(int[][] t){

    }

}
