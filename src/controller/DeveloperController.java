package controller;

import dao.DeveloperDAO;
import model.Developer;
import view.DeveloperView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class DeveloperController {
    DeveloperDAO dao = new DeveloperDAO();
    Scanner scanner = new Scanner(System.in);

    public void add() {
        Developer developer = new Developer();

        System.out.println("Введите данные разработчика в следующем виде:");
        System.out.println("ИД,Имя,Фамилия,Специальность,Оклад");
        String temp = scanner.next();
        String[] buffer = temp.split(",");
        developer.setId(Long.parseLong(buffer[0]));
        developer.setFirstName(buffer[1]);
        developer.setLastName(buffer[2]);
        developer.setSpecialty(buffer[3]);
        developer.setSalary(Double.parseDouble(buffer[4]));

        dao.save(developer);
    }

    public void remove() {
        Developer developer = new Developer();

        System.out.println("Введите ИД разработчика, которого хотите удалить");
        long id = scanner.nextLong();

        developer = dao.getById(id);

        dao.remove(developer);
    }

    public void update() {
        Developer developer = new Developer();

        System.out.println("Введите ИД разработчика, которого хотите обновить");
        long id = scanner.nextLong();

        developer = dao.getById(id);

        System.out.println("Введите новые данные разработчика в следующем виде:");
        System.out.println("Имя,Фамилия,Специальность,Оклад");
        String temp = scanner.next();
        String[] buffer = temp.split(",");
        developer.setFirstName(buffer[0]);
        developer.setLastName(buffer[1]);
        developer.setSpecialty(buffer[2]);
        developer.setSalary(Double.parseDouble(buffer[3]));

        dao.update(developer);
    }

    public void show() {
        Developer developer = new Developer();

        System.out.println("Введите ИД разработчика, которого хотите увидеть");
        long id = scanner.nextLong();

        developer = dao.getById(id);

        System.out.println(developer.toString());
    }

    public void showAll() {
        Collection<Developer> developers = new ArrayList<Developer>();

        developers = dao.getAll();

        System.out.println(developers.toString());
    }
}
