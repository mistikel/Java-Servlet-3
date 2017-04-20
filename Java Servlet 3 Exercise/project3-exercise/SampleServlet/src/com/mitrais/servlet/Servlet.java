package com.mitrais.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet(description = "This is example servlet", urlPatterns = { "/Servlet" })
public class Servlet extends HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		List<Data> a = new ArrayList<Data>();
		for(int i=0; i<5; i++){
			Data data = new Data();
			data.setId(i+1);
			data.setName("name"+(i+1));
			a.add(data);
		}
		Gson json = new Gson();
		String jsonWithGson = json.toJson(a);
		//write with Gson
		String object = "{\"data\":["+jsonWithGson+"],\"message\":\"hello from servlet\"}";
		writer.println(object);
	}
}

