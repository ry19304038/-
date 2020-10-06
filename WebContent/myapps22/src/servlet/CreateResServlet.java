package servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ResProfile;
import bean.ThreadListProfile;
import business.AbstractBusiness;
import exception.NoidException;
import factory.Factory;
import show.ShowClass;


public class CreateResServlet extends HttpServlet{
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{

//	  確認用にSystem.out.printlnを行うメソッドを呼び出す
	  ShowClass.actionShowClassName(this);

    // レス用のサーブレット
    req.setCharacterEncoding("UTF-8");



    // レスの情報を取得
    String th_id=req.getParameter("id");
    String res_name=req.getParameter("res_name");
    String res_text=req.getParameter("res_text");


//    Bean に値をセットする
    ResProfile resProfile = new ResProfile();
    resProfile.setRes_name(res_name);
    resProfile.setRes_text(res_text);
    resProfile.setTh_id(th_id);

    System.out.println("th_idは"+th_id+"です");

//    例外の判定を行っている
    if(th_id.equals("null")||res_text.isEmpty()||res_name.isEmpty()) {
    	System.out.println("CreateResServletのException");
    	throw new NoidException();
    }else {
//    Insertを行うビジネスロジックレイヤの呼び出し
    	System.out.println("Insertを行うビジネスロジックレイヤの呼び出し");



    	AbstractBusiness createResBusiness=(AbstractBusiness)Factory.createInstance("CreateResBusiness");
    	createResBusiness.execute(resProfile);




//    th_idをもとに全てのレスを取得する
    	AbstractBusiness getResListBusiness=(AbstractBusiness)Factory.createInstance("GetResListBusiness");
    	List<ResProfile>resList=getResListBusiness.execute(resProfile);
    	req.setAttribute("ResList",resList);






    	AbstractBusiness getThreadListBusines=(AbstractBusiness)Factory.createInstance("GetThreadListBusiness");


//    全てのスレッドを取得する
//    	引数は必要ないが、コンパイルエラーのために引数を渡す
    	List<ThreadListProfile>threadList=getThreadListBusines.execute( new ThreadListProfile());

    	req.setAttribute("ThreadList",threadList);

    	req.setAttribute("th_id",th_id);
    	RequestDispatcher dis = req.getRequestDispatcher("iti?th_id="+th_id);
    	dis.forward(req, res);




    }


  }
}
