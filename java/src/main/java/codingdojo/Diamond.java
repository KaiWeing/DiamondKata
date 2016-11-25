package codingdojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Diamond {

    private final char middleLetter;

    public Diamond(char middleLetter) {
        if (middleLetter > 'Z' || middleLetter < 'A') {
            throw new IllegalArgumentException(middleLetter + " is not a character between A and Z");
        }

        this.middleLetter = middleLetter;
    }

    public List<List<Character>> getRows() {
        ArrayList<List<Character>> rows = new ArrayList<List<Character>>();
        for (Character c : charsUpToAndDownFrom(middleLetter)) {
            rows.add(getRow(c));
        }
        return rows;
    }

    private ArrayList<Character> getRow(char c) {
        ArrayList<Character> row = new ArrayList<Character>();
        row.addAll(spacesBefore(c));
        row.add(c);
        if (c > 'A') {
            row.addAll(spacesBetween(c));
            row.add(c);
        }
        return row;
    }

    private Collection<? extends Character> spacesBetween(char c) {
        return nSpaces ((c - 'A') * 2 - 1);
    }

    private List<Character> spacesBefore(char c) {
        return nSpaces(middleLetter - c);
    }

    private List<Character> nSpaces(int i) {
        return Collections.nCopies(i, ' ');
    }

    private List<Character> charsUpToAndDownFrom(char c) {
        ArrayList<Character> characters = new ArrayList<Character>();
        characters.addAll(charsUpTo(c));
        List<Character> charsDownFrom = charsUpTo((char) (c - 1));
        Collections.reverse(charsDownFrom);
        characters.addAll(charsDownFrom);
        return characters;
    }

    private List<Character> charsUpTo(char c) {
        ArrayList<Character> characters = new ArrayList<Character>();
        for (int i = 0; i < charToPos(c); i++) {
            characters.add(posToChar(i + 1));
        }
        return characters;
    }

    private char posToChar(int pos) {
        return (char) ('A' + pos - 1);
    }

    private int charToPos(char c) {
        return c - 'A' + 1;
    }

    public static String print(char middleLetter) {
        Diamond diamond = new Diamond(middleLetter);
        StringBuilder result = new StringBuilder();
        for (List<Character> chars : diamond.getRows()) {
            for (Character c: chars) {
                result.append(c);
            }
            result.append("\n");
        }
        result.deleteCharAt(result.length() - 1); // remove last \n
        return result.toString();
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            System.out.println(Diamond.print(args[0].charAt(0)));
        } else {
            System.out.println("please supply one argument: the char of the diamond middle");
        }

    }
}
