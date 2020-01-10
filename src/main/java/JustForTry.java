import model.Employee;
import model.Employees;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JustForTry {
    public static void main(String[] args) {
        String employeePath = "D:\\java\\GeolocationApp\\test_sd_card\\config\\employees.txt";
        String idPath = employeePath.trim().replace("employees.txt", "id.txt");
        String eventPath = employeePath.trim().replace("config\\employees.txt", "logs\\");
        try (BufferedReader bf = new BufferedReader(new FileReader(employeePath))) {
            int i = 1;
            while (bf.readLine() != null) {
                System.out.println(i);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        File file = new File(eventPath);
//        for (int i = 0; i < file.list().length; i++) {
//            if (file.list()[i].contains("1")) {
//                System.out.println("Contains");
//            } else {
//                System.out.println("No");
//            }
//        }

        for (int i = 0; i < employeePath.length(); i++) {
            for (int j = 0; j < idPath.length(); j++) {
                if (employeePath.charAt(0) == idPath.charAt(0)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            }
        }
//        List<Long> employeeId = new ArrayList<>();
//        employeeId.add(1L);
//        employeeId.add(3L);
//        employeeId.add(5L);
//
//        List<String> realId = new ArrayList<>();
//        realId.add("1 5E9C6AD0");
//        realId.add("2 1AD6B9A3");
//        realId.add("3 1AD356A3");
//        realId.add("4 1A150DA3");
//        realId.add("5 1A9419A3");
//
//        for (int i = 0; i < employeeId.size(); i++) {
//            for (int j = 0; j < realId.size(); j++) {
//                if (realId.get(j).substring(0, 1).equals(String.valueOf(employeeId.get(i)))) {
//                    System.out.println("Found!");
//                    break;
//                }
//            }
//        }
    }
}
