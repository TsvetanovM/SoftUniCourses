package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Articles2 {
    String title;
    String content;
    String author;

    Articles2(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s",this.title, this.content, this.author);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Articles2> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(", ");
            list.add(new Articles2(input[0], input[1], input[2]));
        }
        String input = scan.nextLine();
        int comparator = -1;
        switch (input){
            case "title": comparator = 0; break;
            case "content": comparator = 1; break;
            case "author": comparator = 2;
        }
        if (comparator==0) {
            list.sort((o1, o2) -> o1.title.compareTo(o2.title));
        }
        else if (comparator==1){
            list.sort((o1, o2) -> o1.content.compareTo(o2.content));
        }
        else {
            list.sort((o1, o2) -> o1.author.compareTo(o2.author));
        }
        for (Articles2 article : list) {
            System.out.println(article.toString());
        }
    }
}
