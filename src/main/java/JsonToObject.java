import com.google.gson.Gson;
import model.Employees;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonToObject {
//    private final static String path = "C:\\Users\\Filip\\Desktop\\test_sd_card\\config\\employees.txt";

    public static Employees loadContentFromFile(String path) {
        Gson gson = new Gson();
        Employees employees = null;

        try (Reader reader = new FileReader(path)) {
            employees = gson.fromJson(reader, Employees.class);
            return employees;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
