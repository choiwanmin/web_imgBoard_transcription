package reps;

import java.util.ArrayList;

public class RepService {
	private RepDao dao;

	public RepService() {
		dao = new RepDao();
	}

	public void addReps(Rep r) {
		dao.insert(r);
	}

	public ArrayList<Rep> getReps(int ImgBoardNum) {
		return dao.selectbyImgBoardNum(ImgBoardNum);
	}
}
