package reps.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import reps.Rep;
import reps.RepService;

/**
 * Servlet implementation class RepAdd
 */
@WebServlet("/rep/add")
public class RepsAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RepsAdd() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		int imgBoardNum = Integer.parseInt(request.getParameter("imgBoardNum"));

		RepService service = new RepService();
		service.addReps(new Rep(0, writer, content, imgBoardNum));

		ArrayList<Rep> list = service.getReps(imgBoardNum);

		JSONArray arr = new JSONArray();
		for (Rep r : list) {
			JSONObject obj = new JSONObject();
			obj.put("writer", r.getWriter());
			obj.put("content", r.getContent());
			arr.add(obj);
		}

		response.getWriter().append(arr.toString());

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
