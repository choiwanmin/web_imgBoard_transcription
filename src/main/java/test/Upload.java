package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/upload/upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Upload() {
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
		String path = "C:\\Users\\user_0\\Documents\\dev_study_laptop_wm\\javaweb_9_kosta_laptop\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\imgs\\";
		int size = 100 * 1024 * 1024; // 100M

		MultipartRequest multipart = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
		String title = multipart.getParameter("title");
		String fname = multipart.getOriginalFileName("f");

		System.out.println("title:" + title);
		System.out.println("fname:" + fname);
		
		RequestDispatcher dis = request.getRequestDispatcher("/upload/list");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
