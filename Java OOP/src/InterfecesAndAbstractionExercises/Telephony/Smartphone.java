package InterfecesAndAbstractionExercises.Telephony;

import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Callable, Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = new ArrayList<>();
        this.urls = new ArrayList<>();
        setNumbers(numbers);
        setUrls(urls);
    }

    public void setNumbers(List<String> numbers) {
        for (String number : numbers) {
            boolean isValid = true;
            for (int i = 0; i < number.length(); i++) {
                if (!Character.isDigit(number.charAt(i))) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                this.numbers.add(number);
            }
        }
    }

    public void setUrls(List<String> urls) {
        for (String url : urls) {
            boolean isValid = true;
            for (int i = 0; i < url.length(); i++) {
                if (Character.isDigit(url.charAt(i))) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                this.urls.add(url);
            }
        }
    }

    @Override
    public String browse() {
        StringBuilder output = new StringBuilder();
        for (String url : urls) {
            output.append("Browsing: ").append(url).append("!");
            output.append(System.lineSeparator());
        }
        return output.toString();
    }

    @Override
    public String call() {
        StringBuilder output = new StringBuilder();
        for (String number : numbers) {
            output.append("Calling... ").append(number);
            output.append(System.lineSeparator());
        }
        return output.toString();
    }
}
