package notes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {

	final static String DATE_FORMAT = "MMM dd, Y";
	final static int PREVIEW_TEXT_SIZE = 50;

    private Integer id = null;
    private String title = "";
    private String text = "";
    private Date createdAt = new Date();

    public Note() {}

    public Note(String title, String text) {
        this.setTitle(title);
        this.setText(text);
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getPreviewText() {
        return shortenString(text, PREVIEW_TEXT_SIZE);
    }

    public String getCreatedAt() {
    	return formatDate(createdAt);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title =  title;
    }

    public void setText(String text) {
        this.text =  text;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    private static String formatDate(Date date) {

    	SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);

        return formatter.format(date);
    }

    private static String shortenString(String originalText, int maxSize) {
        
        return (originalText.length() <= maxSize) ? originalText : originalText.substring(0, maxSize) + "...";
    }
    
}