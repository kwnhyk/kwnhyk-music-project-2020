package kwnhyk.music.domain;

import java.io.Serializable;
import java.sql.Date;

public class MusicInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int no;
	private String title;
	private String artist;

	private String writer;
	private String genre;
	private Date startDate;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public static MusicInfo valueOf(String csv) {
		String[]data = csv.split(",");
		MusicInfo music = new MusicInfo();
		music.setNo(Integer.parseInt(data[0]));
		music.setTitle(data[1]);
		music.setArtist(data[2]);
		music.setWriter(data[3]);
		music.setGenre(data[4]);
		music.setStartDate(Date.valueOf(data[5]));
		return music;
	}
	public String toCsvString() {
		
		return String.format("%d,%s,%s,%s,%s,%s\n",this.getNo(),
				this.getTitle(),this.getArtist(),this.getWriter()
				,this.getGenre(),this.getStartDate());
	}

}