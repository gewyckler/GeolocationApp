import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Employees;
import model.Events;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*This class allow to read a Json format from file, of path given in parameter, and create an Employees object.*/
public class LoadFromFile {
    private static Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public static Employees loadJsonToJavaObject(String employeesFilePath, String idFilePath) {
        Employees employees = new Employees();

        try (Reader reader = new FileReader(employeesFilePath)) {
            employees = gson.fromJson(reader, Employees.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> realIdList = readFileByLineAndLoadToList(idFilePath);
        for (int i = 0; i < employees.getEmployees().size() - 1; i++) {
            for (int j = 0; j < realIdList.size() - 1; j++) {
                if (realIdList.get(j).substring(0, 1).equals(String.valueOf(employees.getEmployees().get(i).getId()))) {
                    employees.getEmployees().get(i).setWorkerNumber(realIdList.get(j).substring(2));
                }
            }
        }

        return employees;
    }

    private static List<String> readFileByLineAndLoadToList(String filePath) {
        List<String> list = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(filePath))) {
            String line = bf.readLine();
            while (line != null) {
                line = bf.readLine();
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
