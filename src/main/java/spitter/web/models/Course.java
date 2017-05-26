package spitter.web.models;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import spitter.web.services.Converter.VNDateFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nttao on 5/5/2017.
 */
@XmlRootElement(name="course")
public class Course {
   private int id;
   private String title;
   private String description;
   //@VNDateFormat(pattern = "dd/MM/yyyy")
   //@DateTimeFormat(pattern = "dd/MM/yyyy")
   private Date startDate;
   //@VNDateFormat(pattern = "dd/MM/yyyy")
   //@DateTimeFormat(pattern = "dd/MM/yyyy")
   private Date endDate;
   private int pax;
   private boolean active;
   private List<Lesson> lessons;


   public Course(){

   }

    public Course(int id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }

   public Course(int id, String title, String description,
                 Date startDate, Date endDate, int pax, boolean isActive, List<Lesson> lessons ){
       this.id = id;
       this.title = title;
       this.description = description;
       this.startDate = startDate;
       this.endDate = endDate;
       this.pax = pax;
       this.active = isActive;
       this.lessons = lessons;
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getPax() {
        return pax;
    }

    public void setPax(int pax) {
        this.pax = pax;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", pax=" + pax +
                ", active=" + active +
                ", lessons=" + lessons +
                '}';
    }
}
