import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
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
                    System.out.println("Создана коробка box1 для целых чисел.");
                    int m;
                    do {
                        System.out.println("Введите номер дейсвия:\n " +
                                "0.Завершить действия с коробкой.\n " +
                                "1.Положить объект в коробку.\n " +
                                "2.Взять объект из коробки.\n " +
                                "3.Посмотреть содержимое коробки.");
                        m = scanner.nextInt();
                        scanner.nextLine();
                        switch (m) {
                            case 0:
                                System.out.println("Работа с коробкой box 1 завершена.");
                                break;
                            case 1:
                                try {
                                    setBox(box1);
                                } catch (Exception e) {
                                    System.out.println("Ошибка: " + e.getMessage());
                                }
                                break;
                            case 2:
                                try {
                                takeBox(box1);
                                } catch (Exception e) {
                                    System.out.println("Ошибка: " + e.getMessage());
                                }
                                break;
                            case 3:
                                System.out.println(box1);
                                break;
                            default:
                                System.out.println("Неверный номер действия!");
                        }
                    } while (m != 0);
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

    private static void setBox(GeneralizedBox <Integer> box) {
        int value;
        while (true) {
            System.out.print("Введите целое число, которое необходимо добавить в box1: ");
            String str = scanner.nextLine();
            if (!Validator.valIsInt(str)) {
                System.out.println("Ошибка: введите корректное целое число!");
            } else {
                value = Integer.parseInt(str);
                break;
            }
        }
        box.setObj(value);
        System.out.println("Число " + value + " добавлено в коробку box1.");
    }

    private static void takeBox(GeneralizedBox <Integer> box) {
        Integer value= box.take();
        System.out.println("Из коробки извлекли значение: " + value);
    }

}