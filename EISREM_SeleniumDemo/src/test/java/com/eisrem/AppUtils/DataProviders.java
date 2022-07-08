package com.eisrem.AppUtils;

import org.testng.annotations.DataProvider;

public class DataProviders extends Data{

	
	@DataProvider(name=MyHomePage)
	public Object [][] getData(){
		return new Object[][] {
			{MyHomePage}
		};
	}
	
	@DataProvider(name=Reports)
	public Object [][] getData_1st(){
		return new Object[][] {
			{Reports}
		};
	}
	
	@DataProvider(name=People)
	public Object [][] getData_2nd(){
		return new Object[][] {
			{People}
		};
	}
	
	@DataProvider(name=Organization)
	public Object [][] getData_3rd(){
		return new Object[][] {
			{Organization}
		};
	}
	
	@DataProvider(name=AssessmentForms)
	public Object [][] getData_4th(){
		return new Object[][] {
			{AssessmentForms}
		};
	}
	
	@DataProvider(name=Authorization)
	public Object [][] getData_5th(){
		return new Object[][] {
			{Authorization}
		};
	}
	
	@DataProvider(name=Notes)
	public Object [][] getData_6th(){
		return new Object[][] {
			{Notes}
		};
	}
	
	@DataProvider(name=Planning)
	public Object [][] getData_7th(){
		return new Object[][] {
				{Planning}
			};
	}
	
	@DataProvider(name=ReportableEvent)
	public Object [][] getData_8th(){
		return new Object[][] {
				{ReportableEvent}
			};
	}
	
	@DataProvider(name=Search)
	public Object [][] getData_9th(){
		return new Object[][] {
				{Search}
			};
	}
	
	@DataProvider(name=Agreement)
	public Object [][] getData_10th(){
		return new Object[][] {
				{Agreement}
			};
	}
	
	@DataProvider(name=Classes)
	public Object [][] getData_11th(){
		return new Object[][] {
				{Classes}
			};
	}
	
	@DataProvider(name=QuickLinks)
	public Object [][] getData_12th(){
		return new Object[][] {
				{QuickLinks}
			};
	}
	
	@DataProvider(name=Administrator)
	public Object [][] getData_13th(){
		return new Object[][] {
				{Administrator}
			};
	}
}
