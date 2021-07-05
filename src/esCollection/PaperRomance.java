package esCollection;

public class PaperRomance extends Romance {

	private static final long serialVersionUID = 1L;
	
	private String cover_type;		//stiff, soft
	private String conservation_state;	//excellent, good, ruined
	private int number_of_pages;
	
	public PaperRomance(String title, String author, int publish_date, String editor, String cover_type, String conservation_state, int number_of_pages) {
		super(title, author, publish_date, editor);
		this.cover_type = cover_type;
		this.conservation_state = conservation_state;
		this.number_of_pages = number_of_pages;
	}

	public String getCover_type() {
		return cover_type;
	}

	public void setCover_type(String tipoCopertina) {
		this.cover_type = tipoCopertina;
	}

	public String getConservation_state() {
		return conservation_state;
	}

	public void setConservation_state(String conservation_state) {
		this.conservation_state = conservation_state;
	}

	public int getNumber_of_pages() {
		return number_of_pages;
	}

	public void setNumber_of_pages(int number_of_pages) {
		this.number_of_pages = number_of_pages;
	}

	@Override
	public String toString() {
		return super.toString() + "cover type=[" + cover_type + "], conservation state=[" + conservation_state
				+ "], number of pages=[" + number_of_pages + "]";
	}
}
