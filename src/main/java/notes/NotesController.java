package notes;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    NoteRepository noteRepo;

	/**
	 * Fetches a collection of notes
	 */
	@RequestMapping(method = RequestMethod.GET)
    public List<Note> index() {

    	return noteRepo.fetchAll();

    }

    /**
	 * Fetches a Single note
	 */
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Note show(@PathVariable Integer id) {

        return noteRepo.fetch(id);

	}

	/**
	 * Creates a new Note
	 */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public Response store(@RequestBody Note note) {

    	Note createdItem = noteRepo.create(note);

    	return new Response("Note Created", createdItem);

    }

	/**
	 * Updates a note
	 */
	@RequestMapping(value="/{noteId}", method=RequestMethod.PUT, consumes = "application/json")
	public Response update(@PathVariable Integer noteId, @RequestBody Note note) {

		noteRepo.update(noteId, note);

        return new Response("Note Updated", note);

	}

	/**
	 * Deletes a note
	 */
    @RequestMapping(value="/{noteId}", method=RequestMethod.DELETE)
	public Response destroy(@PathVariable Integer noteId) {
 		
 		noteRepo.delete(noteId);

    	return new Response("Note Deleted");
        
	}
	
}