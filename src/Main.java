import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
        task7();
    }

    //Task1
    //Напишите метод, вычисляющий сумму элементов
    //массива. Массив передаётся в качестве параметра.
    public static void task1() {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("Сумма элементов массива равна " + sumOfArray(arr));
    }

    public static int sumOfArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    //Task2
    //Напишите метод для нахождения максимума в массиве.
    // Массив передаётся в качестве параметра.
    public static void task2() {
        int[] arr = {1, 3, 5, 4, 2};

        System.out.println("Макисальный элемент массива равен " + maxOfArray(arr));
    }

    public static int maxOfArray(int[] array) {
        Arrays.sort(array);
        return array[array.length - 1];
    }

    //Task3
    //Напишите метод, определяющий количество чётных,
    //нечётных, положительных, отрицательных элементов
    //массива. Массив передаётся в качестве параметра.

    public static void task3() {
        int[] arr = {1, 2, -3, 4, 5, -6, 7, 8, -9, 10, 0};
        counter(arr);

    }

    public static void counter(int[] array) {
        int positive = 0;
        int negative = 0;
        int zero = 0;
        int odd = 0;
        int even = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
            if (array[i] > 0) {
                positive++;
            } else if (array[i] < 0) {
                negative++;
            } else {
                zero++;
            }
        }
        System.out.println("Кол-во четных элементов равно " + even);
        System.out.println("Кол-во нечетных элементов равно " + odd);
        System.out.println("Кол-во положительных элементов равно " + positive);
        System.out.println("Кол-во отрицательных элементов равно " + negative);
    }

    //Task4
    //Напишите метод, сортирующий массив по убы-
    //ванию или возрастанию в зависимости от выбора
    //пользователя.
    public static void task4() {
        int[] arr = {1, 2, -3, 4, 5, -6, 7, 8, -9, 10, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите направление сортировки (убывание/возрастание)");
        String direction = scanner.next();
        switch (direction) {
            case "возрастание" -> Arrays.sort(array);
            case "убывание" -> {
                Arrays.sort(array);
                int[] copy = Arrays.copyOf(array, array.length);
                for (int i = 0; i < array.length; i++) {
                    array[i] = copy[array.length - 1 - i];
                }
            }
        }
    }

    //Task5
    //Напишите метод, переворачивающий содержимое
    //массива.
    public static void task5() {
        int[] arr = {1, 2, -3, 4, 5, -6, 7, 8, -9, 10, 0};
        System.out.println(Arrays.toString(arr));
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        for (int i = 0; i < array.length; i++) {
            array[i] = copy[array.length - 1 - i];
        }
    }

    //Task6
    //Напишите метод, который ищет некоторое число
    //массиве с помощью двичного поиска
    public static void task6() {
        int[] arr = {1, 2, -3, 4, 5, -6, 7, 8, -9, 10, 0};
        int searchValue1 = 7;
        int searchValue2 = 100;
        binarySearch(arr, searchValue1);
        binarySearch(arr, searchValue2);
    }

    public static void binarySearch(int[] array, int searchValue) {
        Arrays.sort(array);
        int index = -1;
        int low = array[0];
        int high = array[array.length - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] < searchValue) {
                low = mid + 1;
            } else if (array[mid] > searchValue) {
                high = mid - 1;
            } else if (array[mid] == searchValue) {
                index = mid;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Элемент " + searchValue + " не найден.");
        } else {
            System.out.println("Элемент  " + searchValue + " найден.");
        }
    }

    //Task7
    //Напишите метод, высчитывающий факториал каж-
    //дого элемента массива. Метод возвращает новый массив,
    //содержащий полученные факториалы.
    public static void task7(){
        int[] array = {3,4,5,6};
        System.out.println(Arrays.toString(fact(array)));
    }
    public static int[] fact(int[] array){
        int[] result = Arrays.copyOf(array, array.length);
        for (int i = 0; i < array.length; i++) {
            if(array[i] < 0){
                System.out.println("Нельзя вычислить факториал отрицательного числа!");
                break;
            } else {
                result[i] = factorial(array[i]);
            }
        }
        return result;
    }
    public static int factorial(int num){
        if (num == 1) {
            return 1;
        } else if (num == 2) {
            return 2;
        } else {
            return factorial(num-1) * num;
        }
    }


}
