/*
Задача 1. Покупка товаров

1) Описание:

Вы пишете программу, планирующую продуктовую корзину.

У вас есть список доступных продуктов в одном массиве и соответствующая им цена в другом массиве. Пользователь вводит
номер продукта из первого списка и количество продуктов этого вида, которое хочет купить. Программа добавляет стоимость
продукта, умноженную на его количество, в итоговую сумму продуктовой корзины. Действие повторяется до тех пор, пока
пользователь не введет команду "end".

2) Функционал программы:

- Создание массива продуктов внутри программы (без пользовательского ввода);
- Создание массива цен на продукты (без пользовательского ввода);
- Вывод списка доступных для покупки продуктов на экран;
- Возможность ввода пользователем номера продукта и количества для добавления в корзину;
- Вывод всех покупок, их общую стоимость и количество на экран.

3) Пример:

Список возможных товаров для покупки
1. Молоко
2. Хлеб
3. Гречневая крупа
Выберите товар и количество или введите `end`
1 10 <enter>
Выберите товар и количество или введите `end`
3 1 <enter>
Выберите товар и количество или введите `end`
end <enter>
Ваша корзина:
Наименование товара   Количество  Цена/за.ед  Общая стоимость
Молоко                10          60          600
Гречневая крупа       1           50          50
                                  Итого       650
*/

package netology;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Homework5t1 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] products = new String[]{"Хлеб", "Яблоки", "Молоко"};
        int[] prices = new int[]{100, 200, 300};

        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i]);
        }

        while (true) {

            System.out.println("Выберите товар и количество или введите `end`");

            String input = scanner.nextLine();
            int itemID = -1;

            if ("end".equals(input)) {
                scanner.close();
                break;
            }

            String inputItem = input.substring(0, input.indexOf(" "));
            try {
            itemID = Integer.parseInt(inputItem) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число");
            }

            if (itemID > products.length - 1 || itemID < 0) {
                System.out.println("Неверный идентификатор товара!");
                continue;
            }

            String inputQty = input.substring(input.indexOf(" ") + 1, input.length());
            int qty = Integer.parseInt(inputQty);

            new BasketItem(products[itemID], prices[itemID], qty);

        }

        if (BasketItem.basket.isEmpty()) {
            System.out.println("Ваша корзина пуста!");
        } else {
            System.out.println("Ваша корзина:");
            System.out.println("+--------------------------------------------------------------------------------+");
            System.out.println("|   Наименование товара    |   Количество    |   Цена/за.ед    | Общая стоимость |");
            System.out.println("+--------------------------------------------------------------------------------+");

            for (BasketItem item : BasketItem.basket) {
                //System.out.println(item.name + " " + item.qty + " " + item.costPerPiece + " " + item.costTotal);
                System.out.printf(
                        "| %-24s | %-15s | %-15s | %-15s |\n",
                        item.getName(),
                        item.getQty(),
                        item.getCostPerPiece(),
                        item.getCostTotal()
                );
                System.out.println("+--------------------------------------------------------------------------------+");
            }

            System.out.printf(
                    "| %60s | %-15s |\n",
                    "Итого",
                    BasketItem.getTotalBasketSum()
            );
            System.out.printf("+--------------------------------------------------------------------------------+");
        }
    }

    public static class BasketItem {

        private static ArrayList<BasketItem> basket = new ArrayList<>();
        private static int totalBasketSum = 0;

        private String name;
        private int costPerPiece;
        private int qty;
        private int costTotal;

        public BasketItem(String name, int costPerPiece, int qty) {
            this.name = name;
            this.costPerPiece = costPerPiece;
            this.qty = qty;
            this.costTotal = costPerPiece * qty;
            totalBasketSum += costTotal;
            if (basket.isEmpty()) {
                basket.add(this);
            } else if (searchForNameMatch(name) == null) {
                basket.add(this);
            } else {
                searchForNameMatch(name).setQty(searchForNameMatch(name).getQty() + qty);
                searchForNameMatch(name).setCostTotal(searchForNameMatch(name).getCostTotal() + costPerPiece * qty);
            }
        }

        public static ArrayList<BasketItem> getBasket() {
            return basket;
        }

        public static int getTotalBasketSum() {
            return totalBasketSum;
        }

        public String getName() {
            return name;
        }

        public int getCostPerPiece() {
            return costPerPiece;
        }

        public int getQty() {
            return qty;
        }

        public int getCostTotal() {
            return costTotal;
        }

        public static void setBasket(ArrayList<BasketItem> basket) {
            BasketItem.basket = basket;
        }

        public static void setTotalBasketSum(int totalBasketSum) {
            BasketItem.totalBasketSum = totalBasketSum;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCostPerPiece(int costPerPiece) {
            this.costPerPiece = costPerPiece;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public void setCostTotal(int costTotal) {
            this.costTotal = costTotal;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BasketItem that = (BasketItem) o;
            return name.equals(that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        public BasketItem searchForNameMatch(String name) {
            for (BasketItem item : basket) {
                if (item.getName().equals(name)) {
                    return item;
                }
            }
            return null;
        }
    }
}
