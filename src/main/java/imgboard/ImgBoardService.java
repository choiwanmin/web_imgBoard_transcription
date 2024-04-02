package imgboard;

import java.util.ArrayList;

public class ImgBoardService {
	private ImgBoardDao dao;
	public static String path = "C:\\Users\\user_0\\Documents\\dev_study_laptop_wm\\javaweb_9_kosta_laptop\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\imgs\\";

	public ImgBoardService() {
		dao = new ImgBoardDao();
	}

	public void addImgBoard(ImgBoard b) {
		dao.insert(b);
	}

	public ImgBoard getImgBoard(int num) {
		return dao.select(num);
	}

	public ArrayList<ImgBoard> getAll() {
		return dao.selectAll();
	}

	public void editImgBoard(ImgBoard b) {
		dao.update(b);
	}

	public void delImgBoard(int num) {
		dao.delete(num);
	}
}