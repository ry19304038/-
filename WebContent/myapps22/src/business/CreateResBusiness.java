package business;

import java.util.ArrayList;
import java.util.List;

import bean.AbstractBean;
import bean.ResProfile;
import database.ResInsert;
import show.ShowClass;

public class CreateResBusiness extends AbstractBusiness{


	@Override
	public List execute(AbstractBean bean){
		// TODO 自動生成されたメソッド・スタブ

		ResProfile resProfile=(ResProfile)bean;

		String res_name=resProfile.getRes_name();
		String res_text=resProfile.getRes_text();

		System.out.println("CreateResBusiness のname は	"+res_name+res_text);


		ShowClass.actionShowClassName(this);
		ResInsert.executeInsert(resProfile);

//		とりあえず戻り地を戻す
		return new ArrayList();
	}

}
