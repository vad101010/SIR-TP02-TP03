package metier;

import javax.persistence.*;
import java.util.List;

@Entity
public class Survey {

    private long id;
    private Meeting meeting;
    private List<Date> availableDates;

    @Id
    @GeneratedValue
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    @ManyToOne
    public Meeting getMeeting()
    {
        return meeting;
    }

    public void setMeeting(Meeting meeting)
    {
        this.meeting = meeting;
    }

    @OneToMany
    public List<Date> getAvailableDates()
    {
        return availableDates;
    }

    public void setAvailableDates(List<Date> availableDates)
    {
        this.availableDates = availableDates;
    }
}
