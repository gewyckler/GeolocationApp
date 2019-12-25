import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFromFile {
    private static List<Employee> employeeList = new ArrayList<>();

    public static List<Employee> loadContentFromFile() {
        Gson gson = new Gson();
        Employee employee;
        try {
            employee = gson.fromJson(new FileReader(
                    "C:\\Users\\Filip\\Desktop\\test_sd_card\\config\\employees.txt"), Employees.class);
            employeeList.add(employee);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
