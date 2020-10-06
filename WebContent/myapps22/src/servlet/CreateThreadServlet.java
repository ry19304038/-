package servlet;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ThreadListProfile;
import business.AbstractBusiness;
import factory.Factory;
import show.ShowClass;

public class CreateThreadServlet extends HttpServlet{
  public void doGet(HttpServletRequest req,HttpServletResponse res)
  throws IOException,ServletException{

	  doPost(req,res);
  }

  public void doPost(HttpServletRequest req,HttpServletResponse res)
  throws IOException,ServletException{


    req.setCharacterEncoding("UTF-8");

//    パラメータを受け取り、Bean にセットする
    String th_title=req.getParameter("th_title");
    String th_name=req.getParameter("th_name");
    String th_category=req.getParameter("c1");
    String th_description=req.getParameter("th_description");

    ThreadListProfile threadListProfile = new ThreadListProfile();
    threadListProfile.setTh_title(th_title);
    threadListProfile.setTh_name(th_name);
    threadListProfile.setTh_category(th_category);
    threadListProfile.setTh_description(th_description);


    ShowClass.actionShowClassName(this);




//    CreateThread.executeInsert(threadListProfile);

    AbstractBusiness createThreadBusiness=(AbstractBusiness)Factory.createInstance("CreateThreadBusiness");
    createThreadBusiness.execute(threadListProfile);

    RequestDispatcher dispatcher=
    req.getRequestDispatcher("ThreadListServlet");

    dispatcher.forward(req,res);


    }


}
