package com.example.demo.enums;

/**
 * <h1>List of Constants</h1>
 */
public class Constants {

	private Constants() {
	}

	public static final String JIRA_URL_SUFFIX = "/rest/api/2/search?jql=";
	public static final String JIRA_URL_FOR_FIELD_ID = "@jira_URL@/rest/api/2/field";
	public static final String JIRA = "JIRA";
	public static final String ALL_TASKS = "ALL TASKS";
	public static final String DEFECT = "DEFECT";
	public static final String SPRINT = "SPRINT";
	public static final String CURRENT_SPRINT = "currentsprint";

	public static final String GET_CLOSED_STORIES = "GET CLOSED STORIES";
	public static final String GET_CLOSED_STORIES_OF_ASSIGNEE = "GET_CLOSED_STORIES_OF_ASSIGNEE";

	// Jira query replacements
	public static final String JQL_JIRA_URL = "@jira_URL@";
	public static final String JQL_PROJECT = "@project@";
	public static final String JQL_SPRIN_ID = "@SprintID@";
	public static final String JQL_ASSIGNEE = "@assignee@";
	public static final String JQL_START_DATE = "@start_date@";
	public static final String JQL_END_DATE = "@end_date@";

	public static final String SONAR_COMPONENT = "measures/component?component=";
	public static final String COVERAGE_DETAIL = "measures/component_tree?metricSortFilter=withMeasuresOnly&asc=true&ps=100&metricSort=coverage&s=metric&baseComponentKey=";
	public static final String COVERAGE_METRIC = "&metricKeys=coverage";
	public static final String HEALTH_METRIC = "&metricKeys=alert_status";
	public static final String JSON = "application/json";
	public static final String REPORT_FILE = "//report.json";

	public static final String POM_FILE = "\\pom.xml";
	// JSON names

	public static final String STORY_ID = "storyID";
	public static final String STORY_DESCRIPTION = "storyDescription";
	public static final String STORY_STATUS = "storyStatus";
	public static final String STORY_POINTS = "storyPoints";
	public static final String ASSIGNEE = "assignee";
	public static final String OPEN_STORIES = "openStories";
	public static final String CLOSED_STORIES = "closedStories";
	public static final String TOTAL_STORY_POINTS = "totalStoryPoints";
	public static final String RESULTS = "results";
	public static final String STORY_POINT_NOT_AVAILABLE = "storyPointNotAvailable";
	public static final String OPEN_STORY_POINTS = "openStoryPoints";
	public static final String DC_PERCENTAGE = "dcPercentage";
	public static final String VELOCITY = "velocity";
	public static final String SPRINT_NAME = "sprintName";
	public static final String USERNAME = "username";
	public static final String HASH = "hash";
	public static final String TOKEN_PREFIX = "Bearer";
	public static final String HEADER_STRING = "Authorization";
	public static final Long EXPIRATION_TIME = 1000 * 60 * 60L; // 1 hour

	public static final String SLASH = "/";
	public static final String PLATO_COVERAGE_DIR = "coverage/";
	public static final String PLATO_REPORT_FILENAME = "index.html";

	public static final String JIRA_AGILE_BOARD = "/rest/agile/1.0/board";
	public static final String JIRA_AGILE_BOARD_SPRINT = "/sprint";
	public static final String JIRA_AGILE_BOARD_ISSUE = "/issue";

	public static final String ACCOUNT_NAME = "accountName";
	public static final String PROJECTS = "projects";

	public static final Integer HEALTH_CRITICAL = 3;
	public static final Integer HEALTH_LOW = 2;
	public static final Integer HEALTH_GOOD = 1;

	public static final String TOOL_PLATO = "Plato";
	public static final String TOOL_SONAR = "SonarQube";
	public static final String TOTAL_DEFECTS = "Total Defects";
	public static final String VALID_DEFECTS = "Valid Defects";
	public static final String INVALID_DEFECTS = "Invalid Defects";
	public static final String TECHNOLOGY_DOTNET = "DOTNET";
	public static final String TECHNOLOGY_JAVA = "JAVA";

	public static final String CLONE_TYPE_HTTP = "HTTP";
	public static final String CLONE_TYPE_SSH = "SSH";

	public static final String OPERATING_SYSTEM = "os.name";
	public static final String WINDOWS = "windows";
	public static final String COMMAND_PROMPT = "cmd.exe";
	public static final String MONO_BEGIN = " ; mono /opt/sonarscanner/sonar-scanner-msbuild/SonarScanner.MSBuild.dll begin /k:\"";
	public static final String MONO_END = " ; mono /opt/sonarscanner/sonar-scanner-msbuild/SonarScanner.MSBuild.dll end";
	public static final String DOTNET_BEGIN = " && dotnet sonarscanner begin /k:\"";
	public static final String DOTNET_BUILD = " && dotnet build ";
	public static final String DOTNET_END = " && dotnet sonarscanner end ";
	public static final String DEFAULT_JAVA = "08";
	/******* Common Messages *******/
	public static final String MESSAGE_EXCEPTION_OCCURRECD = "Exception Occurred.";
	public static final String MESSAGE_BAD_REQUEST = "Bad Request performed.";
	public static final String MESSAGE_RESOURCE_NOT_FOUND = "Requested resource not found.";
	public static final String RESPONSE_FAIL = "fail";
	public static final String SUCCESS_RESPONSE = "Success";
	public static final String RESPONSE_SUCCESS = "success";
	public static final String JSON_ERR_MSG = "Unable to parse JSON";

	public static final String ERROR_DESC = "errorDesc";
	public static final String ERROR_CODE = "errorCode";
	public static final String DATA_NOT_FOUND = "Data not found";
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String EXCEPTION_OCCURED = "Exception occured.. {}";
	
	public static final String UNAUTHORISED = "Unauthorized";
}
