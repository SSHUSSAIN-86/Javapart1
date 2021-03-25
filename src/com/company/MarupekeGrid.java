package com.company;

import java.util.List;
import java.util.Scanner;

public class MarupekeGrid {

    // Marupeke grid field declaration
    int size;
    MarupekeTile[][] marupekeTile;
    boolean isLegalGrid;
    char[][] grid;

    List<Reason> illegalitiesInGrid;

    //Default constructor
   public MarupekeGrid() {
   }

    // Constructor takes size as parameter
    public MarupekeGrid(int size) {

        //condition to check if the size is greater than 10 we set the default to size 10
        if (size > 10) {
            this.size = 10;
            this.grid = new char[10][10];
            this.marupekeTile = new MarupekeTile[10][10];
            isLegalGrid=false;
            ReasonDiagonal reasonDiagonal = new ReasonDiagonal();
            reasonDiagonal.reason="Diagonal size cannot be greater then 10";
            illegalitiesInGrid.add(reasonDiagonal);
        }

        //condition to check if the size is less than 3 we set the default to size 3
        else if (size < 3) {
            this.size = 3;
            this.grid = new char[3][3];
            this.marupekeTile = new MarupekeTile[3][3];
            isLegalGrid=false;
            ReasonDiagonal reasonDiagonal = new ReasonDiagonal();
            reasonDiagonal.reason = "Diagonal size cannot be less than 3";
            illegalitiesInGrid.add(reasonDiagonal);
        } else {
            this.size = size;
            this.grid = new char[size][size];
            this.marupekeTile = new MarupekeTile[size][size];
        }

    }

    //setSolid method
    boolean setSolid(int x, int y) {
        if (grid[x][y] == 'x' || grid[x][y] == 'o') {
            return false;
        } else {
            grid[x][y]='#';
            System.out.println( marupekeTile[x][y]);
            //
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
            //grid[x][y] = 'o';
            return true;
        } else {
            return false;
        }
    }

    // randomPuzzle is refactored
    public static MarupekeGrid randomPuzzle(int size, int numFill, int numX, int numO) {

        boolean[][] editable = new boolean[10][10];

        if (numFill > size * size) {
            ReasonNumFill reasonNumFill = new ReasonNumFill();
            reasonNumFill.reason = "NumFill cannot be greater then size";
            return null;
        }
        else if(numX>numFill){
            ReasonX reasonX = new ReasonX();
            reasonX.reason = "number of x cannot be more then numFill \n\r";

            Tile tile=Tile.X;
            MarupekeTile marupekeTile = new MarupekeTile(tile,true);
            MarupekeGrid marupekeGrid = new MarupekeGrid(size);
            reasonX.toString(marupekeGrid, size);
            return marupekeGrid;
        }
        else if(numO>numFill){
            ReasonO reasonO = new ReasonO();
            reasonO.reason = "number of o cannot be more then numFill \n\r";

            Tile tile=Tile.O;
            MarupekeTile marupekeTile = new MarupekeTile(tile,true);
            MarupekeGrid marupekeGrid = new MarupekeGrid(size);
            reasonO.toString(marupekeGrid, size);
            return marupekeGrid;
        } else {

            // Displaying the number
            System.out.println("The size of grid entered by player is: " + size);
            Tile tile=Tile.BLANK;
            MarupekeTile marupekeTile = new MarupekeTile(tile,true);
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

    //markX method to enter 'X' on the grid location x and y
    public static boolean markX(Tile tile, int x, int y, boolean canEdit) {
        if (canEdit) {
            tile=Tile.X;
            return true;
        } else {
            return false;
        }
    }

    //markO method to enter 'O' on the grid location x and y
    public static boolean markO(Tile tile, int x, int y, boolean canEdit) {
        if (canEdit) {
            tile=Tile.O;
            return true;
        } else {
            return false;
        }
    }



    // isPuzzleComplete checks whether all tiles are filled with legal values
    public static boolean isPuzzleComplete(MarupekeGrid checkPuzzle, int size){
        if(checkPuzzle.isLegalGrid==true){
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    if (checkPuzzle.marupekeTile[i][j].tile==Tile.SOLID ||
                            checkPuzzle.marupekeTile[i][j].tile==Tile.O ||
                            checkPuzzle.marupekeTile[i][j].tile==Tile.X
                    ){
                        return true;
                    }
                }
            }
            return true;

        }
        else{
            return false;
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


        //Initialize Tile
        Tile tile=Tile.BLANK;

        MarupekeTile marupekeTile = new MarupekeTile(tile,true);


        //Instantiating tests for all marupekeGrid
        MarupekeGrid marupekeGrid = randomPuzzle(size,2,1,1);
        MarupekeGrid marupekeGrid1 = randomPuzzle(size,2,3,1);
        MarupekeGrid marupekeGrid2 = randomPuzzle(size,2,1,3);

        //testing solid method
        marupekeGrid.setSolid(4,4);

        //Calling Puzzle to string method for testing
        toString(marupekeGrid, size);
        toString(marupekeGrid1, size);
        toString(marupekeGrid2, size);

        System.out.print("is the Puzzle Complete: " + isPuzzleComplete(randomPuzzle(size,2,1,1),size));





    }
}
