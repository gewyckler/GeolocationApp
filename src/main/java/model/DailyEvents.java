package model;

import lombok.*;

import java.util.List;

@Data
public class DailyEvents {
    private String eventDate;
    private List<String> descriptions;

    @Override
    public String toString() {
        return "" + eventDate;
    }
}

