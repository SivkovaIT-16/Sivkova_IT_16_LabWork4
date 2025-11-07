import ru.sivkova.box.*;
import ru.sivkova.comparable.*;
import ru.sivkova.filter.*;
import ru.sivkova.function.*;
import ru.sivkova.reduction.*;
import ru.sivkova.collecting.*;
import ru.sivkova.validator.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        do {
            System.out.println("Введите номер задачи:\n" +
                    "0.Завершить программу.\n" +
                    "1.Обобщённая коробка.\n" +
                    "2.Сравнимое.\n" +
                    "3.Поиск максимума.\n" +
                    "4.Функция.\n" +
                    "5.Фильтр.\n" +
                    "6.Сокращение.\n" +
                    "7.Коллекционирование.");
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
                        System.out.println("Введите номер действия:\n " +
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
                        System.out.println("Введите номер действия:\n " +
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
                case 3: {
                    //2.2
                    List<GeneralizedBox<? extends Number>> boxes = new ArrayList<>();
                    int m;
                    do {
                        System.out.println("Введите номер действия:\n " +
                                "0.Завершить программу поиска максимума.\n " +
                                "1.Просмотр текущих коробок.\n " +
                                "2.Создать коробку с числом.\n " +
                                "3.Найти максимальное значение.");
                        m = scanner.nextInt();
                        scanner.nextLine();
                        switch (m) {
                            case 0:
                                System.out.println("Работа программы поиска максимума завершена.");
                                break;
                            case 1:
                                if (boxes.isEmpty()) {
                                    System.out.println("Нет добавленных коробок!");
                                    continue;
                                }
                                for (int i = 0; i < boxes.size(); i++) {
                                    System.out.println((i + 1) + ". " + boxes.get(i));
                                }
                                break;
                            case 2:
                                while(true) {
                                    System.out.print("Введите число, которое необходимо добавить в созданную коробку: ");
                                    String str = scanner.nextLine();
                                    if (!Validator.valIsNumber(str)) {
                                        System.out.println("Ошибка: введите корректное число!");
                                    } else {
                                        if (Validator.valIsInt(str)) {
                                            GeneralizedBox<Integer> box = new GeneralizedBox(parseNumber(str));
                                            boxes.add(box);
                                        } else if (Validator.valIsDouble(str)) {
                                            GeneralizedBox<Double> box = new GeneralizedBox(parseNumber(str));
                                            boxes.add(box);
                                        }
                                        System.out.println("Коробка со значением " + parseNumber(str) + " создана.");
                                        break;
                                    }
                                }
                                break;
                            case 3:
                                if (boxes.isEmpty()) {
                                    System.out.println("Нет коробок для поиска максимума!");
                                }
                                try {
                                    double max = Maximum.findMax(boxes);
                                    System.out.println("Максимальное значение: " + max);
                                } catch (Exception e) {
                                    System.out.println("Ошибка: " + e.getMessage());
                                }
                                break;
                            default:
                                System.out.println("Неверный номер действия!");
                                break;
                        }
                    } while (m != 0);
                    break;
                }
                case 4: {
                    int m;
                    do {
                        System.out.println("Введите номер действия:\n " +
                                "0.Завершить работу программы \"Функция\".\n " +
                                "1.Найти длины строк.\n " +
                                "2.Преобразовать числа в положительные.\n " +
                                "3.Найти максимальные значения в массивах.");
                        m = scanner.nextInt();
                        scanner.nextLine();
                        switch (m) {
                            case 0:
                                System.out.println("Работа программы \"Функция\" завершена.");
                                break;
                            case 1:
                                List<String> input1 = new ArrayList<>();
                                inputString(input1);
                                String3_1 function1 = new String3_1(input1);
                                System.out.println(function1);
                                break;
                            case 2:
                                List<Number> input2 = new ArrayList<>();
                                inputNumber(input2);
                                Number3_1 function2 = new Number3_1(input2);
                                System.out.println(function2);
                                break;
                            case 3:
                                List<int[]> input3 = new ArrayList<>();
                                inputIntegerMas(input3);
                                IntegerMas3_1 function3 = new IntegerMas3_1(input3);
                                System.out.println(function3);
                                break;
                            default:
                                System.out.println("Неверный номер действия!");
                                break;
                        }
                    } while (m != 0);
                    break;
                }
                case 5: {
                    int m;
                    do {
                        System.out.println("Введите номер действия:\n " +
                                "0.Завершить работу программы \"Фильтр\".\n " +
                                "1.Отфильтровать строки.\n " +
                                "2.Отфильтровать числа.\n " +
                                "3.Отфильтровать массивы.");
                        m = scanner.nextInt();
                        scanner.nextLine();
                        switch (m) {
                            case 0:
                                System.out.println("Работа программы \"Фильтр\" завершена.");
                                break;
                            case 1:
                                List<String> input1 = new ArrayList<>();
                                inputString(input1);
                                String3_2 filter1 = new String3_2(input1);
                                System.out.println(filter1);
                                break;
                            case 2:
                                List<Number> input2 = new ArrayList<>();
                                inputNumber(input2);
                                Number3_2 filter2 = new Number3_2(input2);
                                System.out.println(filter2);
                                break;
                            case 3:
                                List<int[]> input3 = new ArrayList<>();
                                inputIntegerMas(input3);
                                IntegerMas3_2 filter3 = new IntegerMas3_2(input3);
                                System.out.println(filter3);
                                break;
                            default:
                                System.out.println("Неверный номер действия!");
                                break;
                        }
                    } while (m != 0);
                    break;
                }
                case 6: {
                    int m;
                    do {
                        System.out.println("Введите номер действия:\n " +
                                "0.Завершить работу программы \"Сокращение\".\n " +
                                "1.Сократить строки.\n " +
                                "2.Сократить числа.\n " +
                                "3.Сократить массивы.");
                        m = scanner.nextInt();
                        scanner.nextLine();
                        switch (m) {
                            case 0:
                                System.out.println("Работа программы \"Сокращение\" завершена.");
                                break;
                            case 1:
                                List<String> input1 = new ArrayList<>();
                                inputString(input1);
                                String3_3 reduction1 = new String3_3(input1);
                                System.out.println(reduction1);
                                break;
                            case 2:
                                List<Number> input2 = new ArrayList<>();
                                inputNumber(input2);
                                Number3_3 reduction2 = new Number3_3(input2);
                                System.out.println(reduction2);
                                break;
                            case 3:
                                List<int[]> input3 = new ArrayList<>();
                                inputIntegerMas(input3);
                                IntegerMas3_3 reduction3 = new IntegerMas3_3(input3);
                                System.out.println(reduction3);
                                break;
                            default:
                                System.out.println("Неверный номер действия!");
                                break;
                        }
                    } while (m != 0);
                    break;
                }
                case 7: {
                    int m;
                    do {
                        System.out.println("Введите номер действия:\n " +
                                "0.Завершить работу программы \"Коллекционирование\".\n " +
                                "1.Коллекционировать строки по длине.\n " +
                                "2.Коллекционировать числа.\n " +
                                "3.Коллекционировать уникальные строки.");
                        m = scanner.nextInt();
                        scanner.nextLine();
                        switch (m) {
                            case 0:
                                System.out.println("Работа программы \"Коллекционирование\" завершена.");
                                break;
                            case 1:
                                List<String> input1 = new ArrayList<>();
                                inputString(input1);
                                StringSize collecting1 = new StringSize(input1);
                                System.out.println(collecting1);
                                break;
                            case 2:
                                List<Number> input2 = new ArrayList<>();
                                inputNumber(input2);
                                Number3_4 collecting2 = new Number3_4(input2);
                                System.out.println(collecting2);
                                break;
                            case 3:
                                List<String> input3 = new ArrayList<>();
                                inputString(input3);
                                StringUnique collecting3 = new StringUnique(input3);
                                System.out.println(collecting3);
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
        if (Validator.valIsInt(str)) {
            return Integer.parseInt(str);
        } else {
            return Double.parseDouble(str);
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

    private static void inputString(List<String> input) {
        int count;
        while (true) {
            System.out.print("Введите количество строк: ");
            String c = scanner.nextLine();
            if (!Validator.valIsInt(c) || Integer.parseInt(c) < 0) {
                System.out.println("Ошибка: количество строк должно быть целым числом.");
            } else {
                count = Integer.parseInt(c);
                for (int i = 0; i < count; i++) {
                    System.out.print("Введите " + (i + 1) + " строку: ");
                    String str = scanner.nextLine();
                    input.add(str);
                }
                break;
            }
        }
    }

    public static void inputNumber(List<Number> input) {
        int count;
        while (true) {
            System.out.print("Введите количество чисел: ");
            String c = scanner.nextLine();
            if (!Validator.valIsInt(c) || Integer.parseInt(c) < 0) {
                System.out.println("Ошибка: количество строк должно быть целым числом.");
            } else {
                count = Integer.parseInt(c);
                for (int i = 0; i < count; i++) {
                    while (true) {
                        System.out.print("Введите " + (i + 1) + " число: ");
                        String str = scanner.nextLine();
                        if (!Validator.valIsNumber(str)) {
                            System.out.println("Ошибка: введите корректное число.");
                        } else {
                            input.add(parseNumber(str));
                            break;
                        }
                    }
                }
                break;
            }
        }
    }

    public static void inputIntegerMas(List<int[]> input) {
        int count;
        while (true) {
            System.out.print("Введите количество массивов: ");
            String c = scanner.nextLine();
            if (!Validator.valIsInt(c) || Integer.parseInt(c) < 0) {
                System.out.println("Ошибка: количество массивов должно быть целым числом.");
            } else {
                count = Integer.parseInt(c);
                break;
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.print("Введите " + (i + 1) + " массив. ");
            int size;
            while (true) {
                System.out.print("Введите количество элементов в " + (i + 1) + " массиве: ");
                String sizeStr = scanner.nextLine();
                if (!Validator.valIsInt(sizeStr) || Integer.parseInt(sizeStr) <= 0) {
                    System.out.println("Ошибка: введите корректное количество элементов " + (i + 1) + " массива.");
                } else {
                    size = Integer.parseInt(sizeStr);
                    break;
                }
            }
            int[] mas = new int[size];
            for (int j = 0; j < size; j++) {
                while (true) {
                    System.out.print("Ведите " + (j + 1) + " элемент массива: ");
                    String str = scanner.nextLine();
                    if (!Validator.valIsInt(str)) {
                        System.out.println("Ошибка: введите целое число.");
                    } else {
                        mas[j] = Integer.parseInt(str);
                        break;
                    }
                }
            }
            input.add(mas);
        }
    }
}