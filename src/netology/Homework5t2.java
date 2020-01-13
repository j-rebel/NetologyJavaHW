/*
Задача 2. Сортировка массива вручную

1) Описание:
Вы пишете программу анализа цен в интернете. Ваш анализатор получил "сырой" список товаров. Вам необходимо отсортировать
этот список в порядке увеличения цен. Массив на вход — массив объектов, типа "Продукт" с полями "Имя, цена, описание".
Массив на выход — отсортированный по возрастанию цены массив продуктов. Нужно учесть, что:

- массив на вход может быть очень большим, а значит, алгоритм ручной сортировки должен быть эффективнее, чем "сортировка
пузырьком";
- цены могут совпадать.

2) Функционал программы:

- Создание массива и заполнение его продуктами;
- Сортировка входного массива по возрастанию цены (сортировка на выбор);
- Вывод отсортированного массива.
*/

package netology;

import java.util.Arrays;
import java.util.Collections;

public class Homework5t2 {

    public static void main(String[] args) {

        Product[] products = new Product[] {
                new Product(100, "Молоко", "Коровье"),
                new Product(152, "Рыба", "Лосось"),
                new Product(99, "Мясо", "Говядина"),
                new Product(112, "Хлеб", "Ржаной"),
                new Product(303, "Конфеты", "Аленка"),
                new Product(173, "Пироги", "С мясом"),
                new Product(99, "Пельмени", "Сибирские"),
                new Product(58, "Колбаса", "Сервелат"),
                new Product(270, "Икра", "Черная"),
                new Product(222, "Кефир", "Обезжиренный"),
        };

        System.out.println("Массив до сортировки:");
        System.out.println("=====================");
        printArr(products);
        System.out.println("\n\n");
        System.out.println("Массив после сортировки:");
        System.out.println("=====================");
        //sortArr(products);
        products = mergeSort(products, products.length);
        printArr(products);
    }

    public static void printArr(Product[] arr) {
        for (Product item : arr) {
            System.out.printf("%-10s %-10s %-10s\n", item.getPrice(), item.getName(), item.getDescription());
        }
    }

    public static void sortArr(Product[] arr) {
        Arrays.sort(arr);
    }

    static Product[] mergeSort(Product[] arr, int size) {
        if (size > 1) {
            int mid = size / 2;
            Product[] first = Arrays.copyOfRange(arr, 0, mid);
            first = mergeSort(first, mid); // recursive call for first half array
            Product[] second = Arrays.copyOfRange(arr, mid, size);
            second = mergeSort(second, size - mid); // recursive call for second half array
            arr = mergeArr(first, second, mid, size - mid);
        }
        return arr;
    }

    static Product[] mergeArr(Product[] first, Product[] second, int n, int m) {
        Product[] arr = new Product[n + m];
        int i = 0, f = 0, s = 0;
        while (f < n && s < m) {
            if (first[f].getPrice() < second[s].getPrice())
                arr[i++] = first[f++];
            else
                arr[i++] = second[s++];
        }
        while (f < n)
            arr[i++] = first[f++];
        while (s < m)
            arr[i++] = second[s++];
        return arr;
    }

    public static class Product implements Comparable<Product> {
        private String name;
        private int price;
        private String description;

        public Product(int price, String name, String description) {
            this.name = name;
            this.price = price;
            this.description = description;
        }

        @Override
        public int compareTo(Product o) {
            return this.price - o.price;
        }

        // getters and setters

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        public String getDescription() {
            return description;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }
}
