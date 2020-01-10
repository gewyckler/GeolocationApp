package model;

import lombok.Data;

import java.util.List;

@Data
public class DailyEvents {
    private String eventDate;
    private List<String> descriptions;
}
