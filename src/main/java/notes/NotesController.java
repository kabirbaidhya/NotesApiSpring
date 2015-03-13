package notes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
public class NotesController {

	/**
	 * Fetches a collection of notes
	 */
	@RequestMapping(method = RequestMethod.GET)
    public Note[] index() {

        return new Note[] {
        	new Note("Item 1", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et"),
        	new Note("Item 2", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et"),
        	new Note("Item 3", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et")
        };

    }

    /**
	 * Fetches a Single note
	 */
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Note show(@PathVariable Integer id) {

        return new Note("Item 1", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et");

	}

	/**
	 * Creates a new Note
	 */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public Response store(@RequestBody Note note) {

    	return new Response("Note Created", note);

    }

	/**
	 * Updates a note
	 */
	@RequestMapping(value="/{noteId}", method=RequestMethod.PUT, consumes = "application/json")
	public Response update(@PathVariable Integer noteId, @RequestBody Note note) {

        return new Response("Note Updated", note);

	}

	/**
	 * Deletes a note
	 */
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public Response destroy(@PathVariable Integer id) {
    	
    	return new Response("Note Deleted");
        
	}
}