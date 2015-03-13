package notes;

import java.util.List;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.beans.factory.annotation.Autowired;

public class NoteRepository {

	protected JdbcTemplate jdbc;

    public NoteRepository(JdbcTemplate jdbc) {
    	this.jdbc = jdbc;
    }

    public List<Note> fetchAll() {

    	String query = "select * from notes";

    	List<Note> notes = jdbc.query(query, this.rowMapper());

        return notes;
    }

    public Note fetch(Integer noteId) {

    	String query = "select * from notes where id = ?";
    	
    	Note note = jdbc.queryForObject(query, new Object[]{noteId}, this.rowMapper());

        return note;
    }

    public Note create(Note item) {

    	KeyHolder keyHolder = new GeneratedKeyHolder();

    	String query = "insert into notes (title, text) values (?, ?)";

		jdbc.update(
		    new PreparedStatementCreator() {
		        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		            PreparedStatement ps = connection.prepareStatement(query, new String[] {"id"});
		            ps.setString(1, item.getTitle());
		            ps.setString(2, item.getText());
		            return ps;
		        }
		    }, keyHolder);

		int noteId = keyHolder.getKey().intValue();

		Note createdItem = this.fetch(noteId);
		return createdItem;
    }

    public Note update(int noteId, Note item) {

    	String query = "update notes set title = ?, text = ? where id = ?";

    	jdbc.update(
		    new PreparedStatementCreator() {
		        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		            PreparedStatement ps = connection.prepareStatement(query);
		            ps.setString(1, item.getTitle());
		            ps.setString(2, item.getText());
		            ps.setInt(3, noteId);
		            return ps;
		        }
		    });

    	return this.fetch(noteId);
    }

    public void delete(int noteId) {

    	String query = "delete from notes where id = ?";

    	jdbc.update(query, noteId);
    }

    private RowMapper<Note> rowMapper() {

    	return new RowMapper<Note>() {
            public Note mapRow(ResultSet rs, int rowNum) throws SQLException {

                Note item = new Note();
                
                item.setId(rs.getInt("id"));
                item.setTitle(rs.getString("title"));
                item.setText(rs.getString("text"));
                item.setCreatedAt(rs.getTimestamp("created_at"));

                return item;
            }
        };
    }

}