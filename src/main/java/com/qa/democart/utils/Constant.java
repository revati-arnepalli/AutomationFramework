package com.qa.democart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constant {
   public static final String Login_Page_Title="Account Login";
   public static final int FORGOTTEN_PASSWORD_LINK_COUNT= 2;
   public static final String ACCOUNTS_PAGE_TITLE="My Account";
   public static final String ACCOUNTS_PAGE_HEADER__TITLE="Your Store";
   public static final String ACCOUNTS_CREATION_SUCESS_MSG="Your Account Has Been Created!";
   public static final String REGISTER_SHEET_NAME="RegistrationForm";
   public static final String SEARCH_SHEET_NAME="Search";
   public static final String INVALID_USERNAME_PASSWORD="InvalidCred";
   public static List<String> accessList;
   
   public static List<String> getExpectedAccountSectionsList(){
	   accessList=new ArrayList<String>();
	   accessList.add("My Account");
	   accessList.add("My Orders");
	   accessList.add("My Affiliate Account");
	   accessList.add("Newsletter");
	   return accessList;
   }
}
