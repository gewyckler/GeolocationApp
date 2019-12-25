import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
public class Employees {
    private List<Employee> employee = new ArrayList<>();

    @Override
    public String toString() {
        return employee + "\n";
    }
}
