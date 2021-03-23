package com.company;

import java.util.Scanner;

public class MarupekeGrid {

    // Marupeke grid field declaration
    int size;
    char[][] grid;

    //Default constructor
    public MarupekeGrid() {
    }

    // Constructor takes size as parameter
    public MarupekeGrid(int size) {

        //condition to check if the size is greater than 10 we set the default to size 10
        if (size > 10) {
            this.size = 10;
            this.grid = new char[10][10];
        }

        //condition to check if the size is less than 3 we set the default to size 3
        else if (size < 3) {
            this.size = 3;
            this.grid = new char[3][3];
        } else {
            this.size = size;
            this.grid = new char[size][size];
        }

    }

    //setSolid method
    boolean setSolid(int x, int y) {
        if (grid[x][y] == 'x' || grid[x][y] == 'o') {
            return false;
        } else {
            grid[x][y]='#';
            return true;
        }

    }

    //setX method to enter 'X' on the grid location x and y
    boolean setX(int x, int y, boolean canEdit) {
        if (canEdit) {
            grid[x][y] = 'x';
            return true;
        } else {
            return false;
        }
    }

    //setO method to enter 'O' on the grid location x and y
    boolean setO(int x, int y, boolean canEdit) {
        if (canEdit) {
            grid[x][y] = 'o';
            return true;
        } else {
            return false;
        }
    }

    public static MarupekeGrid randomPuzzle(int size, int numFill, int numX, int numO) {

        boolean[][] editable = new boolean[10][10];

        if (numFill > size * size) {
            return null;
        } else {

            // Displaying the number
            System.out.println("The size of grid entered by player is: " + size);
            MarupekeGrid marupekeGrid = new MarupekeGrid(size);
            System.out.println("The size of MarupekeGrid grid is: " + marupekeGrid.size);


            System.out.println("is Set0 edited: " + marupekeGrid.setO(2, 2, true));
            System.out.println("is SetX edited: " + marupekeGrid.setX(3, 3, true));


            return marupekeGrid;
        }

    }

    // toString method to convert MarupekeGrid in proper format
    public static void toString(MarupekeGrid puzzleToString, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (puzzleToString.grid[i][j] == '\0') {
                    System.out.print("_");
                } else {
                    System.out.print(puzzleToString.grid[i][j]);
                }

            }
            System.out.print("\n\r");
        }
    }


    public static void main(String[] args){
        int size;

        /*  This reads the size of grid
         *  provided by player
         */
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size of grid: ");

        // This method reads the number provided
        size = scan.nextInt();

        // Closing Scanner after the use
        scan.close();

        //Instantiating marupekeGrid
        MarupekeGrid marupekeGrid = randomPuzzle(size,2,1,1);

        //testing solid method
        marupekeGrid.setSolid(4,4);

        //Calling Puzzle to string method
        toString(marupekeGrid, size);

    }
}
