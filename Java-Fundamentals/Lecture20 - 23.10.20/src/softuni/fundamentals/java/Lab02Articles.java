package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab02Articles {
    String title;
    String content;
    String author;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    Lab02Articles(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s", this.title, this.content, this.author);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] initialInput = scan.nextLine().split(", ");
        Lab02Articles article = new Lab02Articles(initialInput[0], initialInput[1], initialInput[2]);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(": ");
            String command = input[0];
            String changedPart = input[1];
            switch (command){
                case "Edit":
                    article.setContent(changedPart);
                    break;
                case "ChangeAuthor":
                    article.setAuthor(changedPart);
                    break;
                case "Rename":
                    article.setTitle(changedPart);
            }
        }
        System.out.println(article.toString());
    }
}
