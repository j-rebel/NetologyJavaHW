package netology.homework14t1;

import java.util.Comparator;

public class PriceComparator implements Comparator<Wish> {

    boolean sortAsc;

    public PriceComparator(boolean sortAsc) {
        this.sortAsc = sortAsc;
    }

    @Override
    public int compare(Wish o1, Wish o2) {
        if (this.sortAsc) {
            return (int) o1.getPrice() - (int) o2.getPrice();
        } else {
            return (int) o2.getPrice() - (int) o1.getPrice();
        }
    }
}
