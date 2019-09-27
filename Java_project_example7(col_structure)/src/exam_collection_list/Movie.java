package exam_collection_list;

public class Movie {
	private String title;
	private String score;
	private String director;
	private String date;
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String title, String score, String director, String date) {
		super();
		this.title = title;
		this.score = score;
		this.director = director;
		this.date = date;
	}

	public final String getTitle() {
		return title;
	}

	public final void setTitle(String title) {
		this.title = title;
	}

	public final String getScore() {
		return score;
	}

	public final void setScore(String score) {
		this.score = score;
	}

	public final String getDirector() {
		return director;
	}

	public final void setDirector(String director) {
		this.director = director;
	}

	public final String getDate() {
		return date;
	}

	public final void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", score=" + score + ", director=" + director + ", date=" + date + "]";
	}
	
	
}
