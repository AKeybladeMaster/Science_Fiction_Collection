package esCollection;

import java.io.Serializable;

public class Romance implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String title;
	private String author;
	int publish_date;
	private String editor;
	
	public Romance(String title, String author, int publish_date, String editor) {
		this.title = title;
		this.author = author;
		this.publish_date = publish_date;
		this.editor = editor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(int publish_date) {
		this.publish_date = publish_date;
	}

	public String getEditore() {
		return editor;
	}

	public void setEditore(String editore) {
		this.editor = editore;
	}

	@Override
	public String toString() {
		return "title=[" + title + "], author=[" + author + "], publish date=[" + publish_date
				+ "], editor=[" + editor + "], ";
	}
	
	
}
