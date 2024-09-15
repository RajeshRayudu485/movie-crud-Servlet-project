package movie_crud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data
public class Movie {
	@Id
	@GeneratedValue
	private int id;
	private String movieName;
	private String description;
	private String language;
	private int rating;
	private String[] gener;
	@Lob
	private byte[] poster;

}
