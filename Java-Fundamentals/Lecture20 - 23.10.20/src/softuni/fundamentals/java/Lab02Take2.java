package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab02Take2 {

    static class Article {
        String title;
        String content;
        String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.author = author;
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getContent() {
            return content;
        }

        public void renameTitle(String title) {
            this.title = title;
        }

        public void changeAuthor(String author) {
            this.author = author;
        }

        public void editContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", getTitle(), getContent(), getAuthor());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] data = scan.nextLine().split(", ");
        String title = data[0];
        String content = data[1];
        String author = data[2];

        Article article = new Article(title, content, author);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(": ");
            String command = input[0];

            switch (command) {
                case "Edit":
                    article.editContent(input[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(input[1]);
                    break;
                case "Rename":
                    article.renameTitle(input[1]);
                    break;
            }
        }

        System.out.println(article.toString());
    }
}
