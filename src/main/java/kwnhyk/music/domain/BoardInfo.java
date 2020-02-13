package kwnhyk.music.domain;

public class BoardInfo {

	private String title;
	private String contents;
	private int num;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	public static BoardInfo valueOf(String csv) {
		String[] data = csv.split(",");
		BoardInfo board = new BoardInfo();
		board.setNum(Integer.parseInt(data[0]));
		board.setTitle(data[1]);
		board.setContents(data[2]);
		return board;
		
	}
	public String toCsvString() {
		return String.format("%d,%s,%s",this.getNum()
				,this.getTitle(),this.getContents());
		
	}
	
}
