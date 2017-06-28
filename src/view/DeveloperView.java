package view;

import controller.DeveloperController;

import java.util.Scanner;

import static java.lang.System.exit;

public class DeveloperView {
    DeveloperController controller = new DeveloperController();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Здравствуйте. Что будем делать с файлом разработчиков?");
        System.out.println("1. Добавить разработчика");
        System.out.println("2. Удалить разработчика");
        System.out.println("3. Изменить разработчика");
        System.out.println("4. Показать разработчика");
        System.out.println("5. Показать всех разработчиков");
        System.out.println("6. Выход");

        while (scanner.hasNext()) {
            String n = scanner.next();
            switch(n) {
                case "1":
                    controller.add();
                    start();
                    break;
                case "2":
                    controller.remove();
                    start();
                    break;
                case "3":
                    controller.update();
                    start();
                    break;
                case "4":
                    controller.show();
                    start();
                    break;
                case "5":
                    controller.showAll();
                    start();
                    break;
                case "6":
                    exit(1);
                    break;
                default:
                    System.out.println("Неправильный ввод. Поробуйте еще раз.");
            }
        }
    }
 }
