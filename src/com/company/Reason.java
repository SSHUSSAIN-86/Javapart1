package com.company;

abstract public class Reason {
    String reason;

    abstract void toString(MarupekeGrid puzzleToString, int size);

}
class ReasonDiagonal extends Reason{
    void toString(MarupekeGrid puzzleToString, int size) {
        System.out.print(reason);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (puzzleToString.grid[i][j] == '\0') {
                    System.out.print("D");
                } else {
                    System.out.print(puzzleToString.grid[i][j]);
                }

            }
            System.out.print("\n\r");
        }
    }

}

class ReasonX extends Reason{
    void toString(MarupekeGrid puzzleToString, int size) {
        System.out.print(reason);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (puzzleToString.grid[i][j] == '\0') {
                    System.out.print("RX");
                } else {
                    System.out.print(puzzleToString.grid[i][j]);
                }

            }
            System.out.print("\n\r");
        }
    }

}

class ReasonO extends Reason{
    void toString(MarupekeGrid puzzleToString, int size) {
        System.out.print(reason);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (puzzleToString.grid[i][j] == '\0') {
                    System.out.print("RO");
                } else {
                    System.out.print(puzzleToString.grid[i][j]);
                }

            }
            System.out.print("\n\r");
        }
    }

}
class ReasonVerticle extends Reason{
    void toString(MarupekeGrid puzzleToString, int size) {
        System.out.print(reason);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (puzzleToString.grid[i][j] == '\0') {
                    System.out.print("V");
                } else {
                    System.out.print(puzzleToString.grid[i][j]);
                }

            }
            System.out.print("\n\r");
        }
    }

}
class ReasonHorizontal extends Reason{
    void toString(MarupekeGrid puzzleToString, int size) {
        System.out.print(reason);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (puzzleToString.grid[i][j] == '\0') {
                    System.out.print("H");
                } else {
                    System.out.print(puzzleToString.grid[i][j]);
                }

            }
            System.out.print("\n\r");
        }
    }

}


class ReasonNumFill extends Reason{
    void toString(MarupekeGrid puzzleToString, int size) {
        //reason = "Number to fill X and O should be within constraints";
        System.out.print(reason);
    }
}

