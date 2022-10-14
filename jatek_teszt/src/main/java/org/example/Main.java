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

            int szam;
            szam = (int)(Math.random() * (choice2-1)) + 0;

            int choiceRow = choice2-1;
            int choiceColumn = 0;

            game[choiceRow][choiceColumn] = fox;

            int continuegame = 0;

            kiir(game);
            game[choiceRow][choiceColumn] = 0;

            int szam1 = 0;
            int szam2 = 0;


            while(continuegame < 5){

                boolean hibas = false;

                System.out.println("Következő lépés? 1 - jobbra fel; 2 - balra fel; 3 jobbra le; 4 - balra le");
                int choice4 = beSzam.nextInt();
                game[choiceRow][choiceColumn] = 0;

                if(choice4 == 1){
                    szam1 = -1;
                    szam2 = 1;
                }
                if(choice4 == 2){
                    szam1 = -1;
                    szam2 = -1;
                }
                if(choice4 == 3){
                    szam1 = 1;
                    szam2 = 1;
                }
                if(choice4 == 4){
                    szam1 = 1;
                    szam2 = -1;

                }
                if(choiceRow + szam1 < 0 || choiceRow + szam1 > choice2 || choiceColumn + szam2 < 0 || choiceColumn + szam2 > choice2 || game[choiceRow + szam1][choiceColumn + szam2] == dog)
                    System.out.println("Hibás lépés");
                else{
                    game[choiceRow + szam1][choiceColumn + szam2] = fox;
                    choiceRow += szam1;
                    choiceColumn += szam2;
                    continuegame++;
                    kiir(game);
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

}
