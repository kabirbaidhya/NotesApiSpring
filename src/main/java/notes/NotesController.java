package notes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
public class NotesController {

	@RequestMapping(method = RequestMethod.GET)
    public Note[] index() {

        return new Note[] {
        	new Note(1, "Item 1"),
        	new Note(2, "Item 2"),
        	new Note(3, "Item 3"),
        };
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Note show(@PathVariable Integer id) {

        return new Note(id, "Item");

	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Note update(@PathVariable Integer id) {

        return new Note(1, "Item");

	}

    @RequestMapping(method = RequestMethod.POST)
    public Note store(Note note) {

    	return note;

    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public Note destroy(@PathVariable Integer id) {
    	
    	return new Note(1, "Item");
        
	}
}