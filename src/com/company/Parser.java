package com.company;

import java.util.Scanner;

/**
 * @author ianw, bernhard
 * <p>
 * A very simple input line parser that parses each line written by the user to
 * the console. To use, create an object of this type, and then repeatedly call
 * getCommand.
 */
public class Parser {

    private Scanner input;

    public Parser() {
        input = new Scanner(System.in);
    }

    /**
     * Parse the input line, converting the first word encountered into a
     * command, and then passing any further arguments that make sense.
     *
     * @return the parsed command
     */
    public com.company.Command getCommand() {
        String inputLine = "";
        inputLine = input.nextLine();

        Scanner scanner = new Scanner(inputLine);
        if (scanner.hasNext()) {
            String str = scanner.next();
            com.company.CommandWord cw = com.company.CommandWord.getCommandWord(str);
            if (cw == com.company.CommandWord.UNKNOWN) {
                return new com.company.Command(cw, "Unknown command: " + str);
            } else if (cw == com.company.CommandWord.QUIT) {
                return new com.company.Command(cw, "Bye bye");
            } else if (cw == com.company.CommandWord.NEW) {
                if (scanner.hasNextInt()) {
                    int size = scanner.nextInt();
                    return new com.company.Command(cw, size, size);
                } else {
                    return new com.company.Command(com.company.CommandWord.NEW, cw.getWord() + " needs one integer argument");
                }
            } else {
                if (scanner.hasNextInt()) {
                    int row = scanner.nextInt();
                    if (scanner.hasNextInt()) {
                        int col = scanner.nextInt();
                        return new com.company.Command(cw, row, col);
                    }
                }
                return new com.company.Command(com.company.CommandWord.UNKNOWN, cw.getWord() + " needs two integer arguments");
            }
        } else {
            return new com.company.Command(com.company.CommandWord.UNKNOWN, "Please tell me what to do");
        }

    }

}