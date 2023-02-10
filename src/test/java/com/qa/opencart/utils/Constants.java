package com.qa.opencart.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {
	public static final String FIREFOX="firefox";
	public static final String CHROME="chrome";
	public static final String IE="ie";
	public static final String EDGE="edge";
	public static final long IMPLICIT_WAIT=30;
	public static final long EXPLICIT_WAIT=60;
	public static final String USER_DIRECTORY=System.getProperty("user.dir");
	public static final String CONFIG_DIRECTORY=USER_DIRECTORY+"\\src\\test\\resources\\com\\qa\\opencart\\config\\config.properties";
	public static final String REPORT_OUTPUT_FOLDER = ".\\reports\\";
	public static final String REGISTRATION_PAGE_TITLE="Register Account";
	public static final String HOME_PAGE_TITLE="Your Store";
	public static final String LOGIN_PAGE_TITLE="Account Login";
	public static final String ALREADY_REG_ACC_ERR_MSG="Warning: E-Mail Address is already registered!";
	public static final String ACCOUNT_LOGOUT_PAGE_TITLE="Account Logout";
	public static final String YOUR_ACCOUNT_CREATED_HEADER="Your Account Has Been Created!";
	public static final String YOUR_ACCOUNT_CREATED_SUCC_MSG="Congratulations! Your new account has been successfully created!";
	public static final String MY_ACCOUNT_PAGE_TITLE="My Account";	
	public static final String TEST_DATA_FILE_PATH=USER_DIRECTORY+"\\src\\test\\resources\\data\\OpenCartAppTestData.xlsx";
	public static final String REGISTER_SHEET_NAME="register";
	public static final String LOGIN_PAGE_FRACTION_URL="route=account/login";
	public static final String MY_ACC_PAGE_FRACTION_URL="route=account/account";
	public static final String FORGOT_PWD_PAGE_TITLE="Forgot Your Password?";
	public static final List<String>EXP_MY_ACC_MENU_OPTION_LIST=Arrays.asList("My Account","Order History","Transactions","Downloads","Logout");
	public static final List<String>EXP_MY_ACC_HEADERTXT_LIST=Arrays.asList("My Account","My Orders","Newsletter");
	public static final String EMAIL_ADDRESS_NOT_FOUND_MSG="Warning: The E-Mail Address was not found in our records, please try again!";
	public static final String EMAIL_CONFORMATION_LINK_MSG="An email with a confirmation link has been sent your email address.";
	public static final String FORGOT_PWD_PAGE_FRACTION_URL="route=account/forgotten";
}
