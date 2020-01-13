package netology.homework14t1;

import java.util.Scanner;
import java.util.TreeSet;

public class WishList {

    private TreeSet<Wish> wishList = new TreeSet<Wish>();

    public void printWishList() {
        for (Wish wish : this.wishList) {
            System.out.println(wish);
        }
    }

    public void addWishes() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите информацию или нажмите <enter> для выхода:");
            System.out.println("Введите название:");
            String name = scanner.nextLine();
            if ("".equals(name)) {
                break;
            }
            System.out.println("Введите описание:");
            String description = scanner.nextLine();
            if ("".equals(description)) {
                break;
            }
            System.out.println("Введите цену:");
            String price = scanner.nextLine();
            if ("".equals(price)) {
                break;
            }
            System.out.println("Введите url:");
            String url = scanner.nextLine();
            if ("".equals(url)) {
                break;
            }
            System.out.println("Введите приоритет:");
            String priority = scanner.nextLine();
            if ("".equals(priority)) {
                break;
            }
            Wish newWish = new Wish(name, description, Double.parseDouble(price), url, Integer.parseInt(priority));
            this.wishList.add(newWish);
            System.out.println("Добавлено - " + newWish);
        }
    }

    public void sortDescPrice () {
        System.out.println("Сортировка по убыванию цены\n");;
        TreeSet<Wish> descPriceSortedWishlist = new TreeSet<>(new PriceComparator(false));
        descPriceSortedWishlist.addAll(this.wishList);
        this.wishList = descPriceSortedWishlist;
    }

    public void sortAscPrice () {
        System.out.println("Сортировка по возрастанию цены\n");
        TreeSet<Wish> ascPriceSortedWishlist = new TreeSet<>(new PriceComparator(true));
        ascPriceSortedWishlist.addAll(this.wishList);
        this.wishList = ascPriceSortedWishlist;
    }

    public void sortDescPriority () {
        System.out.println("Сортировка по приоритету от самого важного\n");
        TreeSet<Wish> descPrioritySortedWishlist = new TreeSet<>(new PriorityComparaotr(false));
        descPrioritySortedWishlist.addAll(wishList);
        this.wishList = descPrioritySortedWishlist;
    }

    public void sortAscPriority () {
        System.out.println("Сортировка по приоритету от низкого приоритета\n");
        TreeSet<Wish> ascPrioritySortedWishlist = new TreeSet<>(new PriorityComparaotr(true));
        ascPrioritySortedWishlist.addAll(wishList);
        this.wishList = ascPrioritySortedWishlist;
    }

}
