package model;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Expose(serialize = false)
    private String fn;
    @Expose(serialize = false)
    private String ln;
    @Expose(serialize = false)
    private Long id;

    private String workerNumber;
    private Events events;

    @Override
    public String toString() {
        return id + ". " + fn + " " + ln;

    }
}
