package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ResProfile;
import business.AbstractBusiness;
import factory.Factory;
import show.ShowClass;


public class ResListServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		doPost(req,res);
	}
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

    req.setCharacterEncoding("UTF-8");

	String th_id=req.getParameter("th_id");
	ResProfile resProfile=new ResProfile();
	resProfile.setTh_id(th_id);



	AbstractBusiness getResListBusiness=(AbstractBusiness)Factory.createInstance("GetResListBusiness");
    List<ResProfile>resList=getResListBusiness.execute(resProfile);


    req.setAttribute("ResList", resList);







//	List<ThreadListProfile> ThreadList = GetThreadList.getQueryList();
    AbstractBusiness getThreadListBusiness=(AbstractBusiness)Factory.createInstance("GetThreadListBusiness");
    List threadList=getThreadListBusiness.execute(resProfile);


//    req.setAttribute("ThreadList", ThreadList);
    req.setAttribute("ThreadList", threadList);



    ShowClass.actionShowClassName(this);
    RequestDispatcher dis = req.getRequestDispatcher("iti");

    dis.forward(req, res);
  }
}
