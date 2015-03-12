package notes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {

    private Integer id;
    private String content;
    private Date createdAt;
    private Date updatedAt;

    public Note() {}

    public Note(Integer id, String content) {
        this.setId(id);
        this.setContent(content);
        createdAt = updatedAt = new Date();
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getCreatedAt() {
    	return getFormattedDate(createdAt);
    }

    public String getUpdatedAt() {
    	return getFormattedDate(updatedAt);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content =  content;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public void setUpdatedAt(Date date) {
        this.updatedAt = date;
    }

    private static String getFormattedDate(Date date) {

    	SimpleDateFormat formatter = new SimpleDateFormat("D, MMM Y");

        return formatter.format(date);
    }

}