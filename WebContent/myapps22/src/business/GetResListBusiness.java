package business;
import java.util.List;

import bean.AbstractBean;
import bean.ResProfile;
import database.ResListQuery;

public class GetResListBusiness extends AbstractBusiness{

	@Override
	public List execute(AbstractBean bean) {

		ResProfile resProfile=(ResProfile)bean;

		// TODO 自動生成されたメソッド・スタブ

//		 同一スレッドのレスを取得する

	    // ビジネスロジックレイヤ
	    String th_id=resProfile.getTh_id();

	    System.out.println("GetResListBusiness で受け取ったth_idは		"+th_id);
	    List<ResProfile> resList = ResListQuery.getQueryList(th_id);
	    return resList;
	}


}
