package bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlayerBoard {
    protected String[][] grilled;

    public PlayerBoard(int taille) {
        this.grilled = new String[taille][taille];
        this.board();
    }

    public void board() {
        this.grilled = new String[10][10];
        int i;
        for (i = 0; i < 10; i++) {
            Arrays.fill(grilled[i], "~ ");
        }
    }

    public void display() {
        System.out.print("  1 2 3 4 5 6 7 8 9 10");
        System.out.println("");
        for (int x = 0; x < 10; x++) {
            if (x < 9){
                System.out.print("0" + (x + 1) + " ");
            }else{
                System.out.print((x + 1) + " ");
            }
            for (int y = 0; y < grilled.length; y++) {
                System.out.print(this.grilled[x][y]);
            }
            System.out.println("");
        }
    }

    public void displayAttackBoard() {
        System.out.print("  1 2 3 4 5 6 7 8 9 10");
        System.out.println("");
        for (int x = 0; x < 10; x++) {
            if (x < 9){
                System.out.print("0" + (x + 1) + " ");
            }else{
                System.out.print((x + 1) + " ");
            }
            for (int y = 0; y < grilled.length; y++) {
                System.out.print(this.grilled[x][y]);
            }
            System.out.println("");
        }
    }

    public void checkAttack(PlayerBoard opponentBoard, int x, int y) {
        if (opponentBoard.grilled[x][y].equals("~ ") || opponentBoard.grilled[x][y].equals("W ") ) {
            this.grilled[x][y] = "W ";
        } else {
            this.grilled[x][y] = "H ";
        }
    }
}


