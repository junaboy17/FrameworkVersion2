package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.LogInPage;

public class TC_BHOPS_11849_Forgot_Password_Page_Error_Msg extends LogInPage {
	
	@Test(priority=1)
	public void TC_Login_Forgot_Password_001() {
		SoftAssert = new SoftAssert();
		String username = "OITFPEXPIREDACCOUNT";
		
		try {
			/*
			SeleniumHelper.log.info("OITFPEXPIREDACCOUNT exists - Getting resultset to confirm account status and resetting appropriate columns");
			try
			{
				DBConnect.connect().createStatement().executeQuery("DELETE FROM EISPH.USER_ATTEMPTS WHERE USERNAME LIKE '%OITFPEXPIREDACCOUNT%'");
				DBConnect.connect().createStatement().executeQuery("DELETE FROM EISPH.USER_PASSWORD_HISTORY WHERE USER_ID IN (SELECT USER_ID FROM EISPH.USER_REC WHERE USERNAME LIKE '%OITFPEXPIREDACCOUNT%')");
				DBConnect.connect().createStatement().executeQuery("DELETE FROM EISPH.USR_X_ROLE WHERE USER_ID IN (SELECT USER_ID FROM EISPH.USER_REC WHERE USERNAME LIKE '%OITFPEXPIREDACCOUNT%')");
				DBConnect.connect().createStatement().executeQuery("DELETE FROM EISPH.usr_x_srvce_ppltn WHERE USER_ID IN (SELECT USER_ID FROM EISPH.USER_REC WHERE USERNAME LIKE '%OITFPEXPIREDACCOUNT%')");
				DBConnect.connect().createStatement().executeQuery("DELETE FROM EISPH.usr_x_bse_loc WHERE USER_ID IN (SELECT USER_ID FROM EISPH.USER_REC WHERE USERNAME LIKE '%OITFPEXPIREDACCOUNT%')");
				DBConnect.connect().createStatement().executeQuery("DELETE FROM EISPH.usr_x_addtnl_loc WHERE USER_ID IN (SELECT USER_ID FROM EISPH.USER_REC WHERE USERNAME LIKE '%OITFPEXPIREDACCOUNT%')");
				DBConnect.connect().createStatement().executeQuery("DELETE FROM EISPH.USER_REC WHERE USERNAME LIKE '%OITFPEXPIREDACCOUNT%'");
				Source.DBConnect().executeScript(insertOITFORGOTTENPASSWORD);
			}catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}catch (Exception e) {
				e.printStackTrace();
			}
			*/
			
			
			SeleniumHelper.log.info("Confirm Navigation to Forgot Password");	
			Expected = "Reset Forgotten Password\nfor EIS.";
			Actual = Source		.LogInPage()	
								.clickForgotPassword()
								.GetSource()
								.ForgotPasswordPage()
								.readForgotPasswordTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("EXPIRED ACCOUNT EMAIL");
			Expected = "EXPIRED ACCOUNT EMAIL";
			Actual = Source		.ForgotPasswordPage()	
								.setUsername(username, EmptyString)
								.setVerificationCodeOnScreen()
								.clickEmailMeMyForgottenPasswordBtn()
								.readSuccessMessageHeader();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("An email has been sent to your email on file with the next steps to reactivate your account.");
			Expected = "An email has been sent to your email on file with the next steps to reactivate your account.";
			Actual = Source		.ForgotPasswordPage()	
								.readSuccessMessage();
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}	
}	
	

