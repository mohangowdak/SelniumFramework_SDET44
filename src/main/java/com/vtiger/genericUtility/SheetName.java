package com.vtiger.genericUtility;

/**
 * This enum provides sheet names of excel
 * @author MOHAN GOWDA
 *
 */
public enum SheetName {

	CONTACTS("Contacts"), ORGANIZATION("Organization");

	private String sheetName;
	//setter (constructor)
	private SheetName(String sheetName) {
		this.sheetName=sheetName;
	}
	//getter
	public String convertToString() {
		return sheetName.toString();
	}

}
