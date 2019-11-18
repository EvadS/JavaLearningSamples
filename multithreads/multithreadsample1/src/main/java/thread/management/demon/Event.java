package thread.management.demon;

import java.util.Date;

/**
 * stores information about the events our program will work with
 */
public class Event {
    private Date date;
    private String event;

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }
}
