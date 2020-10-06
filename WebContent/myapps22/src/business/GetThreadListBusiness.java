package business;
import java.util.List;

import bean.AbstractBean;
import database.GetThreadList;


public class GetThreadListBusiness extends AbstractBusiness{

	@Override
	public List execute(AbstractBean bean) {



		 // DBから全てのスレッドを取得
        List threadAllList = GetThreadList.getQueryList();
        return threadAllList;
	}
}