package com.de.enums;

public enum AdminAppSideLinks {

	Companies, Products, Vendors, Orders, Users;

	static enum Companies {
		Locations, 	Companies;
	}

	static enum Products {
		Product_Lists, Product_Categories, GL_Codes;
	}

	static enum Vendors {
		Vendors, Order_Guides;
	}

	static enum Orders {
		Orders, Purchases, Credit_Memos;
	}
}
