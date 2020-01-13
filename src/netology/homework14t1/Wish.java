package netology.homework14t1;

import java.util.Objects;

public class Wish implements Comparable<Wish>{

    private String name;
    private String description;
    private double price;
    private String url;
    private int priority;

    public Wish(String name, String description, double price, String url, int priority) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.url = url;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wish wish = (Wish) o;
        return Double.compare(wish.price, price) == 0 &&
                priority == wish.priority &&
                Objects.equals(name, wish.name) &&
                Objects.equals(description, wish.description) &&
                Objects.equals(url, wish.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price, url, priority);
    }

    @Override
    public String toString() {
        return " - " +
                "Название: " + name +
                ", описание: " + description +
                ", цена: " + price +
                ", url: " + url +
                ", приоритет: " + priority;
    }

    @Override
    public int compareTo(Wish o) {
        return this.getPriority() - o.getPriority();
    }
}
