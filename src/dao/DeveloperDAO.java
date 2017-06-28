package dao;

import model.Developer;

import java.io.*;
import java.util.*;

public class DeveloperDAO {
    private String sep = System.getProperty("file.separator");
    private String user = System.getProperty("user.dir");
    File file = new File(user + sep + "Developers.txt");

    public void save (Developer developer) {
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(developer.toString());
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remove(Developer developer) {
        Collection<Developer> developers = new ArrayList<>();
        developers = getAll();

        if(getById(developer.getId()) == null) {
            System.out.println("Такой разработчик не найден");
            return;
        } else {
            file.delete();
            if(developers.contains(developer)) {
                developers.remove(developer);
            }
            for (Developer d: developers){
                save(d);
            }
        }
    }

    public void update(Developer developer) {
        if(getById(developer.getId()) == null) {
            System.out.println("Такой разработчик не найден");
            return;
        } else {
            remove(developer);
            save(developer);
        }
    }

    public Developer getById(Long id) {
        Developer developer = new Developer();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String tempDeveloper;

            while((tempDeveloper = bufferedReader.readLine()) != null) {
                String[] buffer = tempDeveloper.split(",");

                if((Long.parseLong(buffer[0]) == id)) {
                    developer.setId(Long.parseLong(buffer[0]));
                    developer.setFirstName(buffer[1]);
                    developer.setLastName(buffer[2]);
                    developer.setSpecialty(buffer[3]);
                    developer.setSalary(Double.parseDouble(buffer[4]));

                    return developer;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Разработчик с таким ИД не найден.");
        return null;
    }

    public Collection<Developer> getAll() {
        List<Developer> developers = new ArrayList<>();


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String tempDeveloper;

            while((tempDeveloper = bufferedReader.readLine()) != null) {
                Developer developer = new Developer();
                String[] buffer = tempDeveloper.split(",");

                developer.setId(Long.parseLong(buffer[0]));
                developer.setFirstName(buffer[1]);
                developer.setLastName(buffer[2]);
                developer.setSpecialty(buffer[3]);
                developer.setSalary(Double.parseDouble(buffer[4]));

                developers.add(developer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return developers;
    }
}
