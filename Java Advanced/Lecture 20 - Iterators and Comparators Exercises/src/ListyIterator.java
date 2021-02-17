import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class ListyIterator implements Iterator<String> {
    private List<String> listy;
    private int index = 0;

    public ListyIterator(String...strings) {
        this.listy = new ArrayList<>();
        if ((strings.length != 0)) {
            Collections.addAll(this.listy, strings);
        }
    }

    @Override
    public boolean hasNext() {
        return index < listy.size();
    }

//    @Override
//    public String next() {
//        return listy.get(index++);
//    }

    public boolean move() {
        index++;
        return index < listy.size();
    }

    public void print() {
        if (listy.size() > 0) {
            System.out.println(listy.get(index));
        } else {
            throw new NullPointerException("Invalid Operation!");
        }
    }
}
