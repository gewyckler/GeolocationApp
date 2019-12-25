import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Employees extends Employee {
    private List<Employee> employees = new ArrayList<>();


}
