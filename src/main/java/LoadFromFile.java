import com.google.gson.Gson;
import model.Employees;
import model.Events;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*This class allow to read a Json format from file, of path given in parameter, and create an Employees object.*/
public class LoadFromFile {
    public static Employees loadJsonToJavaObject(String path) {
        Gson gson = new Gson();
        Employees employees = null;

        try (Reader reader = new FileReader(path)) {
            employees = gson.fromJson(reader, Employees.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static Events loadTextFromFileByLine(String path, String id) {
        Events events = new Events();
        List<String> eventsList = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            String line = bf.readLine();
            eventsList.add(line);

            while (line != null) {
                line = bf.readLine();
                eventsList.add(line);
            }
            events.setWorkerId(id);
            events.setEventsist(eventsList);
            System.out.println(events.getWorkerId());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return events;
    }
}
