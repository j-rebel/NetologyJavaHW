/*
Задача 1. Поворот матрицы на 90 градусов по часовой стрелке

1) Описание:

Научимся поворачивать матрицу с равными сторонами. Этот алгоритм мог бы быть использован в графических редакторах вроде
Photoshop для поворота изображений.

Дано: двумерная матрица 8 на 8 из случайных чисел от 0 до 255 (спектр цветов GrayScale). Напишите алгоритм "поворота"
такой матрицы на 90 градусов по часовой стрелке.

2) Функционал программы:

- Создание матрицы в программе;
- Вывод матрицы до поворота;
- Разворот матрицы;
- Вывод матрицы после поворота на 90 градусов.

3) Пример:

- Дана следующая матрица:

114 112 148  83 204  22 125  31
192 231 245 128  63 246 139  17
61 128 224  45  91  57 239  34
219 237 167 191 236 146 144 117
35 199 102 124 208 195  21 147
52 229 126  32  24 145  19  39
107  43 190  43  47 172  18  19
62 221   6 208 241 198 187  85

- Вывод:

62 107  52  35 219  61 192 114
221  43 229 199 237 128 231 112
6 190 126 102 167 224 245 148
208  43  32 124 191  45 128  83
241  47  24 208 236  91  63 204
198 172 145 195 146  57 246  22
187  18  19  21 144 239 139 125
85  19  39 147 117  34  17  31
*/


package netology;

import java.util.Random;
import java.util.Scanner;

public class Homework6t1 {

    public static void main(String[] args) {

        while (true) {

            int rotationScale = scanRotationScale();

            if (rotationScale % 90 == 0 && rotationScale <= 270 && rotationScale > 0) {

                int matrix[][] = createRandomMatrix(8, 256);

                printRandomMatrix(matrix);

                int rotatedMatrix[][] = createRotatedMatrix(matrix, rotationScale);

                printRotatedMatrix(rotatedMatrix, rotationScale);

            } else {
                System.out.println("Введен некорректный угол! Попробуйте снова.");
                System.out.println("===========================================\n");
                continue;
            }

        }

    }

    public static int scanRotationScale() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите угол поворота матрицы (90/180/270):");

        int rotationScale = 0;

        try {
            rotationScale = scanner.nextInt();
        } catch (Exception e) {

        }
        return rotationScale;
    }

    public static int[][] createRandomMatrix(int matrixSize, int randomBound) {

        int[][] matrix = new int[matrixSize][matrixSize];

        Random random = new Random();

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = random.nextInt(randomBound);
            }
        }

        return matrix;

    }

    public static void printRandomMatrix(int matrix[][]) {

        System.out.println("Исходная матрица, заполненная случайными значениями:");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.format("%4d", matrix[i][j]);
            }
            System.out.println();
        }

    }

    public static int[][] createRotatedMatrix(int matrix[][], int rotationScale) {

        int[][] rotatedMatrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (rotationScale == 90) {
                    rotatedMatrix[i][j] = matrix[matrix.length - 1 - j][i];
                } else if (rotationScale == 180) {
                    rotatedMatrix[i][j] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                } else if (rotationScale == 270) {
                    rotatedMatrix[i][j] = matrix[j][matrix.length - 1 - i];
                } else {
                    break;
                }
            }
        }
        return rotatedMatrix;
    }

    public static void printRotatedMatrix(int rotatedMatrix[][], int rotationScale) {

        System.out.println("\nПоворот матрицы на " + rotationScale + " градусов:\n");

        for (int i = 0; i < rotatedMatrix.length; i++) {
            for (int j = 0; j < rotatedMatrix.length; j++) {
                System.out.format("%4d", rotatedMatrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n");
    }

}
