package org.example;

import java.util.Scanner;

public final class PizzaMaster {
    public void cook() {
        Pizza pizza = new Pizza();
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Попробуйте приготовить свою пиццу с нашим приложением PizzaMaster!\s
                1 - добавить новый компонент (в формате 'продукт количество единица измерения')
                2 - удалить компонент (по названию)
                3 - проверить, содержит ли пицца определённый компонент (по названию)
                4 - узнать, сколько какого-либо компонента содержится в пицце (в формате 'число + единица измерения')
                5 - получить пиццу
                6 - удалить  пиццу и начать сначала
                7 - завершить приготовление
                Удачи!""");
        Scanner sc1 = new Scanner(System.in);
        int param = 0;
        while (param != 7) {
            param = sc.nextInt();
            switch (param) {
                case 1 -> {
                    System.out.println("Введите продукт");
                    String prod = sc1.nextLine();
                    System.out.println("Введите количество - число больше нуля");
                    int quant = sc.nextInt();
                    if (quant <= 0) {
                        System.out.println("Некорректное количество");
                        quant = sc.nextInt();
                    }
                    System.out.println("Введите единицу измерения");
                    String dim = sc1.nextLine();
                    pizza.add(new Component(prod, quant, dim));
                    System.out.println("Компонент успешно добавлен");
                }
                case 2 -> {
                    System.out.println("Введите продукт");
                    String prod = sc1.nextLine();
                    pizza.delete(prod);
                    System.out.println("Компонент успешно удалён");
                }
                case 3 -> {
                    System.out.println("Введите продукт");
                    String prod = sc1.nextLine();
                    if (pizza.contains(prod)) System.out.println("Продукт " + prod + " содержится в пицце");
                    else System.out.println("Продукт " + prod + " не содержится в пицце");
                }
                case 4 -> {
                    System.out.println("Введите продукт");
                    String prod = sc1.nextLine();
                    System.out.println("В пицце содержится " + pizza.quantity(prod) + " продукта " + prod);
                }
                case 5 -> {
                    System.out.println(pizza);
                }
                case 6 -> {
                    pizza.deleteAll();
                    System.out.println("Пицца удалена. Можете начать сначала или завершить работу.");
                }
                case 7 -> {
                    System.out.println("Поздравляю, Вы приготовили свою первую пиццу! На этом всё, до свидания!");
                    break;
                }
                default -> {
                    System.out.println("Введите число от 1 до 7 согласно правилам");
                    param = sc.nextInt();
                }
            }
        }
    }
}
