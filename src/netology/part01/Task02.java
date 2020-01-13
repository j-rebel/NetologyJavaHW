/*Задание 1
Посмотрите пример использования переменных разных типов здесь и создайте свой пример в repl.it.

Продемонстрируйте как минимум 5 операций над переменными разных типов.

Задание 2
Закомментируйте ненужные строки кода, чтобы на экран вывелась надпись:
3 плюс 6 равно 9. Для этого:

Сделайте fork этого примера в свой repl;
Закомментируйте нужные строки кода в своем repl.
Примечание: комментировать строки с объявлением переменных нельзя.

Все свои вопросы вы можете задавать в канале slack (ссылку вы получите на почту).*/

package netology.part01;

public class Task02 {
    public static void main(String[] args) {

        /*Задание 1*/

        int a = 2;
        byte d = 5;
        int b = 3;
        double c = 7.3;
        short e = 100;
        float f = 5.4f;
        long l = 100000L;

        System.out.println(b * c);
        System.out.println(a * d);
        System.out.println(e * c);
        System.out.println(f * b);
        System.out.println(l * c);

        /*Задание 2*/

            int aa = 3, bb = 6;

            //System.out.print("три");
            System.out.print(aa);
            System.out.print(" плюс ");
            //System.out.print(" минус ");
            System.out.print(bb);
            //System.out.print("шесть");
            System.out.print(" равно ");
            //System.out.print(" будет ");
            //System.out.print("девять");
            System.out.print(aa + bb);
    }
}
