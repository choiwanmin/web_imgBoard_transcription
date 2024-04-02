package imgboard.controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import imgboard.ImgBoard;
import imgboard.ImgBoardService;

/**
 * Servlet implementation class ImgBoardAdd
 */
@WebServlet("/imgboard/add")
public class ImgBoardAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImgBoardAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dis = request.getRequestDispatcher("/imgboard/add.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		int size = 100 * 1024 * 1024;

		MultipartRequest multipart = new MultipartRequest(request, ImgBoardService.path, size, "utf-8",
				new DefaultFileRenamePolicy());

		String writer = multipart.getParameter("writer");
		String title = multipart.getParameter("title");
		String content = multipart.getParameter("content");
		File imgf = multipart.getFile("img");// 업로드된 파일의 파일 객체 반환
		String img = imgf.getName();// 업로드된 파일명

		ImgBoard b = new ImgBoard(0, writer, null, title, content, "/imgs/" + img);
		System.out.println(b);

		ImgBoardService service = new ImgBoardService();
		service.addImgBoard(b);

		response.sendRedirect(request.getContextPath() + "/imgboard/list");
	}

}
