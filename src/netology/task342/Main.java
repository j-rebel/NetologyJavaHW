package netology.task342;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        for (Event event: getCinemaEvents()) {
            validEvent(event);
        }
        for (Event event: getTheatreEvents()) {
            validEvent(event);
        }
        System.out.println("Все события корректны");
    }

    public static ArrayList<CinemaEvent> getCinemaEvents() {
        return new ArrayList<CinemaEvent> (Arrays.asList(
            new CinemaEvent("Джентельмены", 2020, 16),
            new CinemaEvent("Большой куш", 2000, 16),
            new CinemaEvent("Карты, деньги, два ствола", 1998, 16),
            new CinemaEvent("Револьвер", 2005, 16),
            new CinemaEvent("Рок-н-рольщик", 2008, 16)
            )
        );
    }

    public static ArrayList<TheatreEvent> getTheatreEvents() {
        return new ArrayList<TheatreEvent> (Arrays.asList(
                new TheatreEvent("Король Лир", 2020, 16),
                new TheatreEvent("Антоний и Клеопатра", 2019, 16),
                new TheatreEvent("Отелло", 2018, 16),
                new TheatreEvent("Макбет", 2017, 16),
                new TheatreEvent("Гамлет", 2016, 16)
        )
        );
    }

    public static void validEvent(Event event) {
        if(
            event.getAge() == 0 ||
            event.getReleaseYear() == 0 ||
            event.getTitle() == null ||
            event.getTitle().equals("")
        ) {
            throw new RuntimeException();
        }
    }

}
