import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class EmployeeFromFile {
    private static List<Employee> employeeList;

    public static List<Employee> loadContentFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Filip\\Desktop\\test_sd_card\\config\\employees.txt"));
            Employee employee = new Gson().fromJson(br, Employee.class);
//            employeeList.add(employee);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
