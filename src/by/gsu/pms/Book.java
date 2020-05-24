package by.gsu.pms;

import java.io.IOException;

/**
 * Model of book.
 *
 */

public class Book {
    private final Line lines;
    private String filePath;

    public Book(String filePath) throws IOException {
        this.filePath = filePath;
        this.lines = new Line("Book");
        lines.addLines(Parser.getLinesFromBook(this));
    }

    public String getFilePath() {
        return filePath;
    }


    public String toStringAsCollection() {
        return lines.getLines();
    }

    @Override
    public String toString() {
        return lines.getLinesAsString();
    }
}
