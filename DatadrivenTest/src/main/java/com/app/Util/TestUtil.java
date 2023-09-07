package com.app.Util;

import java.util.ArrayList;

public class TestUtil {

	static XlsReader reader;

	public static ArrayList<Object[]> getDataFromExcel() throws Exception{

		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new XlsReader();
			reader.setExcelFile("C:\\Users\\rachanam\\eclipse-workspace\\DatadrivenTest\\src\\main\\java\\com\\app\\Sheet\\DatadrivenTesting.xlsx", "Sheet1");
		}catch(Exception e) {
			e.printStackTrace();
		}

		int rowCount = reader.getRows("Sheet1");

		for(int i=1;i<=rowCount/2-1;i++) {
			String Fn = reader.getCellData("FirstName", i);
			String Ln = reader.getCellData("LastName", i);
			String Add = reader.getCellData("Address", i);
			String Email = reader.getCellData("Email", i);
			String Ph = reader.getCellData("Phone", i);
			String gender = reader.getCellData("Gender", i);
			String hobby = reader.getCellData("Hobby1", i);
			String hobby1 = reader.getCellData("Hobby2", i);
			String hobby2 = reader.getCellData("Hobby3", i);
			String Lang = reader.getCellData("Language", i);
			String Skills = reader.getCellData("Skills", i);
			String Country = reader.getCellData("Country", i);
			String BirthYear = reader.getCellData("BirthYear", i);
			String BirthMonth = reader.getCellData("BirthMonth", i);
			String BirthDay = reader.getCellData("BirthDay", i);
			String Pswd = reader.getCellData("Password", i);
			String ConfPswd = reader.getCellData("ConfirmPswd", i);
			
			Object ob[] = {Fn, Ln, Add, Email, Ph, gender, hobby, hobby1, hobby2, Lang, Skills,
					        Country, BirthYear, BirthMonth, BirthDay, Pswd, ConfPswd};
			myData.add(ob);
			}

			return myData;

		}

	}
