package spitter.web.models;

/**
 * Created by nkim on 5/11/2017.
 */
public class Lesson {
    private int id;
    private String title;
    private int time;

    public Lesson(){

    }
    public Lesson(int id, String title, int tiem){
        this.id = id;
        this.title = title;
        this.time = time;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
