package regData;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import data.FileException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;import java.util.List;
import java.util.Map;
import java.util.Scanner;

 public class RegistrationUser {
     private final String dir = "D:" + "\\" + "exams";
    private final Map<String, User> userMap = new HashMap<>();
    Scanner scanner = new Scanner(System.in);


    void startReg() throws IOException {
        RegistrationUser reg = new RegistrationUser();
        String select;
        do {
            reg.menu();
            select= scanner.nextLine();
            reg.userSelect(scanner,select);
        }while (!select.equals("3"));
    }

    private void menu() {
        System.out.println("""
                1. Registration
                2. Print all users
                3. Exit
                """);
    }
    private void userSelect(Scanner scanner, String select) throws IOException {
        switch (select) {
            case "1" -> userReg(scanner);
            case "2" -> readUser();
            case "3" -> System.out.println("Exit");
            default -> System.out.println("There is no such choice");
        }
    }
    private void userReg(Scanner scanner) throws IOException {
        RegistrationUser reg = new RegistrationUser();
        User user;
        String userName;
        do {
            System.out.println("Iveskite vartotojo userName");
            userName = scanner.nextLine();
            user = userMap.get(userName);
            if (user != null) {
                System.out.println("Toks vartotojas jau yra");
            }
        } while (user != null);
        System.out.println("Iveskite varda");
        String name = scanner.nextLine();
        System.out.println("Iveskite pavarde");
        String surname = scanner.nextLine();
        System.out.println("Iveskite asmenskoda");
        int personalCode;
        do {
            personalCode = scanner.nextInt();
        } while (equals(0));
            user = new User(name, surname, personalCode);
            userMap.put(userName, user);
            reg.writeUser(user);
        }
        private void writeUser(User user) throws IOException {
            ObjectMapper mapper =  new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            File file = FileException.fileExceptionTool(dir + "\\" + "userList.json");
            mapper.writeValue(file,user);
            System.out.println("UserList israsyti i faila");
        }
        private void readUser() throws IOException {
        User user;
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = FileException.fileExceptionTool(dir + "\\" + "userList.json");
        user = mapper.readValue(file, User.class);
        System.out.println(user);
        }
}

