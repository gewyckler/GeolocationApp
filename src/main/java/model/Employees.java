package model;

import com.google.gson.annotations.Expose;
import lombok.Getter;

import java.util.List;

@Getter
public class Employees {
    @Expose/*(serialize = false)*/
    private List<Employee> employees;

    @Override
    public String toString() {
        return employees + "\n";
    }
}
