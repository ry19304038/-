package business;

import java.util.ArrayList;
import java.util.List;

import bean.AbstractBean;
import bean.ThreadListProfile;
import database.CreateThread;

public class CreateThreadBusiness extends AbstractBusiness{

	@Override
	public List execute(AbstractBean bean) {

		ThreadListProfile profile=(ThreadListProfile)bean;

//		スレッドを作成する
		// TODO 自動生成されたメソッド・スタブ
		CreateThread.executeInsert(profile);

//		戻り値を合わせるためだけのreturn ;
		return new ArrayList();
	}
}
