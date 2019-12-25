import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String fn;
    private String ln;
    private Long id;

    @Override
    public String toString() {
        return "id: " + id + " " +
                "fn: " + fn + " " +
                "ln: " + ln + "\n";

    }
}
