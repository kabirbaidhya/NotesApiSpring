package notes;

public class Response {
    
    private String message;
    private Note note;

    public Response(String text) {
    	setMessage(text);
    }

    public Response(String text, Note note) {
    	setMessage(text);
    	setNote(note);
    }

    public String getMessage() {
    	return message;
    }

    public Note getNote() {
    	return note;
    }

    public void setMessage(String text) {
    	this.message = text;
    }

    public void setNote(Note note) {
    	this.note = note;
    }
}
