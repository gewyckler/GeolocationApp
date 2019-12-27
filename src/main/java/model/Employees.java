package model;

import lombok.Getter;

import java.util.List;

@Getter
public class Employees {
    private List<Employee> employees;

    @Override
    public String toString() {
        return employees + "\n";
    }
}
