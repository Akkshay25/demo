package com.example.demo.enums;

import org.json.JSONObject;

public enum ErrorConstants {
	INTERNAL_ERROR_OCCURED(1000, "Server encountered an error while processing the request"),
	INVALID_LOGIN_CRIDENTIALS(1002, "Please Enter valid username/password") ,
	NO_VALID_OLD_PASSWORD(1003, "Please enter valid old-password"),
	MANDATORY_FIELD(1004, "Please enter password"),
	NO_MODULE_EXIST(1005, "No modules exists"),
	NO_EMAILID_EXIST(1006,"Please enter valid email-id"),
	FILE_UPLOAD_FAILED(2001, "No Multipart File is uploaded or uploaded file is Empty"),
	NO_SCAN_RESULTS(3001, "No scan results found"),
	JSON_PROCESSING_EXCEPTION(5000, "Exception Occured while processing the json"),
	ACCOUNT_NOT_ADDED(5001, "Account is not added in DB"),
	PROJECT_NOT_ADDED(5002, "Project is not added in DB"),
	CODECOVERAGE_NOT_AVAILABLE(5003, "Code coverage is not available"),
	PROPERTY_FILE_READ_ISSUE(5004, "Unable to read property file"), 
	EMAILID_ALREADY_EXISTS( 5005, "This Email id is already registered" ), 
	PROJECT_ALREADY_REGISTERED( 5006, "This project is already registered" ), 
	JIRA_DEFECTS_NOT_AVAILABLE( 5007, "Defects data is not available from jira" ), 
	JIRA_DC_PERCENTAGE_NOT_AVAILABLE( 5008, "DC percentage data is not available from jira" ), 
	JIRA_VELOCITY_NOT_AVAILABLE( 5009, "Velocity data is not available from jira" ), 
	JIRA_TASK_NOT_AVAILABLE( 5010, "Jira tasks are not availble" ),
	JIRA_CONNECTION_UNSUCCESSFUL( 5011, "Connection unsuccessfull" ), 
	UNAUTHORISED( 5012, "Jira username/password is invalid" ), 
	JIRA_INVALID_URL( 5013, "Jira URL entered is invalid" ), 
	JIRA_INVALID_PROJECT ( 5014, "Please verify the Jira Project name" );


	private final Integer errCode;
	private final String errDesc;

	private ErrorConstants(int errCode, String errDesc) {
		this.errCode=errCode;
		this.errDesc=errDesc;
	}

	public Integer getErrCode() {
		return errCode;
	}

	public String getErrDesc() {
		return errDesc;
	}

	public static String getAsJson( ErrorConstants constants ) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("responseText", "Failure");
		jsonObject.put(Constants.ERROR_CODE,  constants.getErrCode());
		jsonObject.put(Constants.ERROR_DESC, constants.getErrDesc());
		return jsonObject.toString();
	}
}