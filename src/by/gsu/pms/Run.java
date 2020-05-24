package by.gsu.pms;

import java.io.IOException;

public class Run {
    public static void main(String[] args) throws IOException {
        Book book = new Book("src/in.txt");
        System.out.println(book.toStringAsCollection());
    }
}
