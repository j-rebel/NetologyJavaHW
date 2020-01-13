package netology.homework14t1;

import java.util.Comparator;

public class PriorityComparaotr implements Comparator<Wish> {

    boolean sortAsc;

    public PriorityComparaotr(boolean sortAsc) {
        this.sortAsc = sortAsc;
    }

    @Override
    public int compare(Wish o1, Wish o2) {
        if (this.sortAsc) {
            return (int) o1.getPriority() - (int) o2.getPriority();
        } else {
            return (int) o2.getPriority() - (int) o1.getPriority();
        }
    }
}
