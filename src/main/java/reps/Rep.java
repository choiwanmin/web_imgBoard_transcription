package reps;

public class Rep {
	private int num;
	private String writer;
	private String content;
	private int imgBoardNum;

	public Rep() {

	}

	@Override
	public String toString() {
		return "Reps [num=" + num + ", writer=" + writer + ", content=" + content + ", imgBoardNum=" + imgBoardNum
				+ "]";
	}

	public Rep(int num, String writer, String content, int imgBoardNum) {
		super();
		this.num = num;
		this.writer = writer;
		this.content = content;
		this.imgBoardNum = imgBoardNum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getImgBoardNum() {
		return imgBoardNum;
	}

	public void setImgBoardNum(int imgBoardNum) {
		this.imgBoardNum = imgBoardNum;
	}

}
