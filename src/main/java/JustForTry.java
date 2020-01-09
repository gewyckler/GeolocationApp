import java.io.File;

public class JustForTry {
    public static void main(String[] args) {
        String employeePath = "D:\\java\\GeolocationApp\\test_sd_card\\config\\employees.txt";
        String idPath = employeePath.trim().replace("employees.txt", "id.txt");
        String eventPath = employeePath.trim().replace("config\\employees.txt", "logs\\");
        Long cos = 123L;
        String nic = String.valueOf(cos);

        File file = new File(eventPath);
        for (int i = 0; i < file.list().length; i++) {
            if (file.list()[i].contains("1")) {
                System.out.println("Contains");
            } else {
                System.out.println("No");
            }
        }
        for (int i = 0; i < employeePath.length(); i++) {
            for (int j = 0; j < idPath.length(); j++) {
                if (employeePath.charAt(0) == idPath.charAt(0)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            }
        }

    }
}
