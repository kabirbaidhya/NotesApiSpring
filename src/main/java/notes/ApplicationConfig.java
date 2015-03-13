package notes;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.*;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ApplicationConfig {

	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/notesapp";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "GodBlessYou";

	
	@Bean
    public DataSource dataSource() {
        
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
         
        dataSource.setDriverClassName(DATABASE_DRIVER);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USERNAME);
        dataSource.setPassword(DATABASE_PASSWORD);
        
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {

    	return new JdbcTemplate(dataSource());
    }

    @Bean
	public NoteRepository noteRepo() {

    	return new NoteRepository(jdbcTemplate());
    }
}
