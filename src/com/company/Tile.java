package com.company;

public enum Tile {
    BLANK('\0'),
    SOLID('#'),
    X('x'),
    O('o');


    Tile(char c) {
    }

    public Tile getMarupekeTile(String s) {
        switch (s) {
            case "\0":
                return Tile.BLANK;
            case "#":
                return Tile.SOLID;
            case "x":
                return Tile.X;
            case "o":
                return Tile.O;
            default:
                return Tile.BLANK;
        }
    }
}


