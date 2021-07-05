package esCollezione;

public class DigitalRomance extends Romance {

	private static final long serialVersionUID = 1L;
	
	private String format;					//epub, mobi, pdf, azw
	private int byte_dimension;
	private String memorization;			//cd-rom, storage
	
	public DigitalRomance(String title, String author, int publish_date, String editor, String format, int byte_dimension, String memorization) {
		super(title, author, publish_date, editor);
		this.format = format;
		this.byte_dimension = byte_dimension;
		this.memorization = memorization;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getByte_dimension() {
		return byte_dimension;
	}

	public void setByte_dimension(int byte_dimension) {
		this.byte_dimension = byte_dimension;
	}

	public String getMemorization() {
		return memorization;
	}

	public void setMemorization(String memorizzazione) {
		this.memorization = memorizzazione;
	}

	@Override
	public String toString() {
		return super.toString() + "format=[" + format + "], dimension in bytes=[" + byte_dimension + "], memorization=["
				+ memorization + "]";
	}
	
}
