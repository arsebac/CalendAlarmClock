package arsebac.alarm.clock.model;

/**
 * @author Francois Melkonian
 */

public class CalendarInfos {
    private final Long id;
    private final String name;
    private final int color;

    public CalendarInfos(Long id, String name, int color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "CalendarInfos{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color=" + color +
                '}';
    }
}
