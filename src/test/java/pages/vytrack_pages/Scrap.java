package pages.vytrack_pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Scrap {
    public static void main(String[] args) {
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM d, yyy"));
        System.out.println(expectedDate);
    }
}
