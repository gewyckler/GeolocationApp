import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class EmployeeFromFile {
    private static Employees employees;

    public static Employees loadContentFromFile() {
        String path = "C:\\Users\\Filip\\Desktop\\test_sd_card\\config\\employees.txt";
        Gson gson = new Gson();
        try {
            employees = gson.fromJson(new FileReader(path), Employees.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
