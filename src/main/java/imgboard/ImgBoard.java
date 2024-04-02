package imgboard;

import java.sql.Date;
import java.util.ArrayList;

import reps.Rep;

public class ImgBoard {
	private int num;
	private String writer;
	private Date wdate;
	private String title;
	private String content;
	private String img;
	private ArrayList<Rep> reps;

	public ImgBoard() {

	}

	@Override
	public String toString() {
		return "ImgBoard [num=" + num + ", writer=" + writer + ", wdate=" + wdate + ", title=" + title + ", content="
				+ content + ", img=" + img + "]";
	}

	public ImgBoard(int num, String writer, Date wdate, String title, String content, String img) {
		super();
		this.num = num;
		this.writer = writer;
		this.wdate = wdate;
		this.title = title;
		this.content = content;
		this.img = img;
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

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public ArrayList<Rep> getReps() {
		return reps;
	}

	public void setReps(ArrayList<Rep> reps) {
		this.reps = reps;
	}

}
