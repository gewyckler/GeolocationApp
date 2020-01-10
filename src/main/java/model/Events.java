package model;

import lombok.Data;

import java.util.List;

@Data
public class Events {
    private Long id;
    private List<DailyEvents> dailyEventsList;


}
