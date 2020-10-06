 package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ThreadListProfile;
import business.AbstractBusiness;
import factory.Factory;

public class ThreadListServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		doPost(req,res);
	}
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

    req.setCharacterEncoding("UTF-8");

//    ビジネスロジックレイヤ
//    List<ThreadListProfile> ThreadList = GetThreadList.getQueryList();
    AbstractBusiness getThreadListBusiness=(AbstractBusiness)Factory.createInstance("GetThreadListBusiness");
    List<ThreadListProfile>threadList=getThreadListBusiness.execute(new ThreadListProfile());


//    req.setAttribute("ThreadList", ThreadList);
    req.setAttribute("ThreadList", threadList);



    System.out.println("ThreadListServlet");
    RequestDispatcher dis = req.getRequestDispatcher("iti");

    dis.forward(req, res);
  }
}
