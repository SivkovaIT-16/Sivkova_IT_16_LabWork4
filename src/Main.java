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
                    int m;
                    do {
                        System.out.println("Введите номер дейсвия:\n " +
                                "0.Завершить программу для сравнения.\n " +
                                "1.Сравнить два числа.\n " +
                                "2.Сравнить две строки.");
                        m = scanner.nextInt();
                        scanner.nextLine();
                        switch (m) {
                            case 0:
                                System.out.println("Работа программы для сравнения завершена.");
                                break;
                            case 1:
                                ComparableNumber val1, val2;
                                while (true) {
                                    System.out.print("Введите первое число: ");
                                    String str1 = scanner.nextLine();
                                    if (!Validator.valIsNumber(str1)) {
                                        System.out.println("Ошибка: введите корректное число!");
                                    } else {
                                        val1 = new ComparableNumber(parseNumber(str1));
                                        break;
                                    }
                                }
                                while (true) {
                                    System.out.print("Введите второе число: ");
                                    String str2 = scanner.nextLine();
                                    if (!Validator.valIsNumber(str2)) {
                                        System.out.println("Ошибка: введите корректное число!");
                                    } else {
                                        val2 = new ComparableNumber(parseNumber(str2));
                                        break;
                                    }
                                }
                                int resNum = val1.compare(val2.getValue());
                                System.out.println(val1.getValue() + " " + resultCompare(resNum) + " " + val2.getValue());
                                break;
                            case 2:
                                System.out.print("Введите первую строку: ");
                                ComparableString str1 = new ComparableString(scanner.nextLine());

                                System.out.print("Введите вторую строку: ");
                                ComparableString str2 = new ComparableString(scanner.nextLine());

                                int resStr = str1.compare(str2.getStr());
                                System.out.println(str1.getStr() + " " + resultCompare(resStr) + " " + str2.getStr());
                                break;
                            default:
                                System.out.println("Неверный номер действия!");
                                break;
                        }
                    } while (m != 0);
                    break;
                }
                default: {
                    System.out.println("Некорректный номер задачи.");
                    break;
                }
            }
        } while (n != 0);
    }

    private static void setBox(GeneralizedBox<Integer> box) {
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

    private static void takeBox(GeneralizedBox<Integer> box) {
        Integer value = box.take();
        System.out.println("Из коробки извлекли значение: " + value);
    }

    private static Number parseNumber(String str) {
        if (Validator.valIsDouble(str)) {
            return Double.parseDouble(str);
        } else {
            return Integer.parseInt(str);
        }
    }

    private static String resultCompare(int result) {
        switch (result) {
            case 1:
                return ">";
            case -1:
                return "<";
            case 0:
                return "=";
            default:
                return " ";
        }
    }
}