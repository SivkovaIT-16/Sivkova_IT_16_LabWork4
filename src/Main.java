import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("Введите номер задачи (для завершения программы введите 0): ");
            n = scanner.nextInt();
            switch (n) {
                case 0:
                    System.out.println("Программа завершена.");
                    break;
                case 1: {
                    //1.1
                    GeneralizedBox<Integer> box1 = new GeneralizedBox<>();
                    box1.setObj(3);
                    System.out.println(box1);
                    Box(box1);
                    System.out.println(box1);
                    System.out.println();

                    GeneralizedBox<String> box2 = new GeneralizedBox<>("A");
                    try {
                        box2.setObj("B");
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    try {
                        System.out.println(box2);
                        System.out.println("Извлекаем значение: " + box2.take());
                        System.out.println(box2);
                        System.out.println("Извлекаем значение: " + box2.take());
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                }
                case 2: {
                    //1.3
                    ComparableNumber intVal = new ComparableNumber(10);      // Integer
                    ComparableNumber doubleVal = new ComparableNumber(3.14); // Double

                    System.out.println(intVal.compare(5.76));
                    System.out.println(intVal.compare(100));
                    System.out.println(doubleVal.compare(0.123));
                    System.out.println(doubleVal.compare(5));
                    System.out.println(intVal.compare(10.0));
                }
            }
        } while (n != 0);
    }
    private static void Box(GeneralizedBox <Integer> box) {
        Integer value= box.take();
        System.out.println("Из коробки извлекли значение: " + value);
    }
}