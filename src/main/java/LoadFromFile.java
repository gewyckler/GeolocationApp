import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.DailyEvents;
import model.Employee;
import model.Events;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*This class allow to read a Json format from file, of path given in parameter, and create an Employees object.*/
public class LoadFromFile {
    private static Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public static List<Employee> loadJsonToJavaObject(String employeesFilePath, String idFilePath, String eventFolderPath) {
//        Employees employees = new Employees();
        List<Employee> employeeList = new ArrayList<>();
// D:\java\GeolocationApp\test_sd_card\config\employees
        try (Reader reader = new FileReader(employeesFilePath)) {
            employeeList = gson.fromJson(reader, new TypeToken<List<Employee>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> realIdList = readFromIdFile(idFilePath);
        getEmployeesRealId(employeeList, realIdList);

        List<Events> eventsList = getEventList(eventFolderPath);
        getEmployeesEvents(employeeList, eventsList);

        return employeeList;
    }

    private static List<Employee> getEmployeesEvents(List<Employee> employeeList, List<Events> eventsList) {
        for (int i = 0; i < employeeList.size(); i++) {
            for (int j = 0; j < eventsList.size(); j++) {
                if (eventsList.get(j).getId().equals(employeeList.get(i).getId())) {
                    employeeList.get(i).setEvents(eventsList.get(j));
                    break;
                }
            }
        }
        return employeeList;
    }

    /*Load from folder "logs" folder named by employee id and add events to employee event list*/
    private static List<Events> getEventList(String eventFolderPath) {
        List eventList = new ArrayList();
        File file = new File(eventFolderPath);

        for (int i = 0; i < file.list().length; i++) {
            eventList.add(readEventsFromFolder(eventFolderPath + file.list()[i]));
        }

        return eventList;
    }

    private static Events readEventsFromFolder(String path) {
        File file = new File(path);
        Events events = new Events();
        List<DailyEvents> dailyEventsList = new ArrayList<>();

        for (int i = 0; i < file.list().length; i++) {
            events.setId(Long.valueOf(file.getName()));
            dailyEventsList.add(readEventsFromFile(path + "\\" + file.list()[i]));
        }
        events.setDailyEventsList(dailyEventsList);

        return events;
    }

    private static DailyEvents readEventsFromFile(String path) {
        DailyEvents dailyEvents = new DailyEvents();
        File file = new File(path);
        List<String> list = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            dailyEvents.setEventDate(file.getName());
            while (bf.ready()) {
                list.add(bf.readLine());
            }
            dailyEvents.setDescriptions(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dailyEvents;
    }

    /*Load from file "id" list of employees id and asign it to proper objects*/
    private static List<Employee> getEmployeesRealId(List<Employee> employeeList, List<String> realIdList) {
        for (int i = 0; i < employeeList.size(); i++) {
            for (int j = 0; j < realIdList.size(); j++) {
                if (realIdList.get(j).substring(0, 1).equals(String.valueOf(employeeList.get(i).getId()))) {
                    employeeList.get(i).setWorkerNumber(realIdList.get(j).substring(2));
                    break;
                }
            }
        }
        return employeeList;
    }

    private static List<String> readFromIdFile(String filePath) {
        List<String> list = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(filePath))) {
            while (bf.ready()) {
                list.add(bf.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
