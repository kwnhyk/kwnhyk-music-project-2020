package kwnhyk.music.domain;

import java.sql.Date;


	public  class ArtistInfo {
		private int no;
		private String artist;
		private String realName;
		private Date bornDate;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	public static ArtistInfo valueOf(String csv) {
		String[] data = csv.split(",");
		
		ArtistInfo artist = new ArtistInfo();
		artist.setNo(Integer.parseInt(data[0]));
		artist.setArtist(data[1]);
		artist.setRealName(data[2]);
		artist.setBornDate(Date.valueOf(data[3]));
		return artist;
		
	}
	public String toCsvString() {
		
		return String.format("%d,%s,%s,%s",this.getNo()
				,this.getArtist(),this.getRealName()
				,this.getBornDate());
		
	}
	}

