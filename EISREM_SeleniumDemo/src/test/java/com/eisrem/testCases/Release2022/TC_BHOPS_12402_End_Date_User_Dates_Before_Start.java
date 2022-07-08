package com.eisrem.testCases.Release2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_12402_End_Date_User_Dates_Before_Start extends BaseHook{

	@Test(priority=1,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_End_Date_User_Dates_Before_Start(String Module) {
		SoftAssert = new SoftAssert();
		
		String username = "OIT" + SeleniumHelper.generateRandomAlpha(10);
		String insertUser = "BEGIN INSERT INTO EISPH.USER_REC (USER_ID,ORG_ID,STRT_DT,END_DT,DESCR,TERM_DT,EMP_DT,F_NME,L_NME,EMAL,TITL,TEL_NMBR,SPRVSR,USERNAME,PASSWORD,ACCOUNTNONEXPIRED,ACCOUNTNONLOCKED,CREDENTIALSNONEXPIRED,ENABLED,STAFF_FLAG,CRTD_DT,CRTD_BY,UPTD_DT,UPTD_BY,PASSWORD_UPDATED_DATE,PASSWORD_UPDATED_BY,PASSWORD_EXPIRATION_DATE,STATE_STAFF_FLAG,LST_LGN_DT) values (EISPH.USER_REC_ID.NEXTVAL,1,to_date('DEC-20 00:00:00','MON-RR HH24:MI:SS'),null,null,null,null,'MAT','" + username + "','roy.sawyer@maine.gov',null,null,null,'" + username + "','$2a$10$YqHK1ZUdbXGfxgG9YHNR.eDJkTAf/BGkUWBWOal25kX/usprLejr6',1,1,1,1,'Y',SYSDATE,540958,SYSDATE,1,SYSDATE,1,SYSDATE,'Y',SYSDATE);"
			+ "	Insert into EISPH.USR_X_ROLE (USER_X_ROLE_ID,USER_ID,ROLE_ID,STRT_DT,END_DT,DESCR,CRTD_DT,CRTD_BY,UPTD_DT,UPTD_BY,ACTV_FLAG,RCRD_SRCE) values (EISPH.USER_X_ROLE_ID.NEXTVAL,EISPH.USER_REC_ID.CURRVAL,1,to_date('DEC-20 00:00:00','MON-RR HH24:MI:SS'),null,null,to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),1,to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),1,'Y',null);"
			+ " INSERT INTO eisph.usr_x_bse_loc (user_x_bse_id,user_id,loc_id,strt_dt,crtd_dt, crtd_by, uptd_dt,uptd_by,actv_flag) VALUES ( eisph.user_x_loc_id.nextval,eisph.user_rec_id.currval,1,SYSDATE - 3000,SYSDATE - 3000,1,SYSDATE - 3000,1, 'Y');"
			+ " INSERT INTO eisph.usr_x_addtnl_loc (usr_x_addtnl_loc_id,user_id, loc_id, strt_dt,crtd_dt,crtd_by,uptd_dt,uptd_by,actv_flag) VALUES (eisph.usr_x_addtnl_loc_id.nextval,eisph.user_rec_id.currval,1,SYSDATE - 3000,SYSDATE - 3000,1,SYSDATE - 3000,1,'Y');END;;";
		try
		{
			SeleniumHelper.log.info("Run Script to create a user with start date after location and base location start dates");
			Source.DBConnect().executeScript(insertUser);
		}catch (Exception e) {
			e.printStackTrace();
		}

		try {
			SeleniumHelper.log.info("Verifying Home office start is in past (" + SeleniumHelper.dateOnlyPast(3000) + ")");
			Expected = SeleniumHelper.dateOnlyPast(3000);
			Actual = Source.NavigationMenuBar()
								.clickOrganization()
								.setSearch(OrgDHHS, Clear)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickUsersStaff()
								.setSearch(username, Clear)
								.clickFirstRow()
								.clickEdit()
								.UserStaffPage()
								.toggleStaffActive(F)
								.clickUserInfoAccord()
								.clickUserActiveToggle()
								.GetSource()
								.UserHomeOfficeAccord()
								.readUserHomeOfficeFirstRowStartDate();
			
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Additional Location start is in past (" + SeleniumHelper.dateOnlyPast(3000) + ")");
			Expected = SeleniumHelper.dateOnlyPast(3000);
			Actual = Source
								.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.readAdditionalOrgLocFirstRowStartDate();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("End Date User click submit and read success popup");
			Expected = Success;
			Actual = Source
								.UserStaffPage()
								.setEndDate(Today, Clear)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			//Work still here
			SeleniumHelper.log.info("Verifying Home office end dated is in today (" + SeleniumHelper.Today + ")");
			Expected = SeleniumHelper.Today;
			Actual = Source		.DataTable()
								.clickPopupOk()
								.NavigationMenuBar()
								.clickOrganization()
								.setSearch(OrgDHHS, Clear)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickUsersStaff()
								.setSearch(username, Clear)
								.clickFirstRow()
								.clickView()
								.UserStaffPage()
								.clickUserInfoAccord()
								.GetSource()
								.UserHomeOfficeAccord()
								.readUserHomeOfficeFirstRowEndDate();
			
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Additional Location  end dated is in today (" + SeleniumHelper.Today + ")");
			Expected = SeleniumHelper.Today;
			Actual = Source
								.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.readAdditionalOrgLocFirstRowEndDate();
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}
