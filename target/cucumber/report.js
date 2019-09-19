$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("EndToEndOrdering.feature");
formatter.feature({
  "line": 1,
  "name": "this feature targets the end to end Ordering flow",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 4,
      "value": "# Background: Check service is up and running on server"
    }
  ],
  "line": 6,
  "name": "Application is UP",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;application-is-up",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@smoke"
    },
    {
      "line": 5,
      "name": "@endToEnd"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I have \"\u003chost\u003e\" server adminApp which is up",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I perform healthCheckUp operation of host on adminApp \"\u003cbrowser\u003e\" server of \"\u003cenv\u003e\" enivronment",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "adminApp Application must be up and running",
  "keyword": "Then "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;application-is-up;",
  "rows": [
    {
      "cells": [
        "host",
        "browser",
        "env"
      ],
      "line": 13,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;application-is-up;;1"
    },
    {
      "cells": [
        "http://admin.newdiningedge.baitek.org:8100/login",
        "chrome",
        "QA"
      ],
      "line": 14,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;application-is-up;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 14,
  "name": "Application is UP",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;application-is-up;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@smoke"
    },
    {
      "line": 5,
      "name": "@endToEnd"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I have \"http://admin.newdiningedge.baitek.org:8100/login\" server adminApp which is up",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I perform healthCheckUp operation of host on adminApp \"chrome\" server of \"QA\" enivronment",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "adminApp Application must be up and running",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://admin.newdiningedge.baitek.org:8100/login",
      "offset": 8
    }
  ],
  "location": "LoginStepDefinition.i_have_server_adminApp_which_is_up(String)"
});
formatter.result({
  "duration": 570481843,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "chrome",
      "offset": 55
    },
    {
      "val": "QA",
      "offset": 74
    }
  ],
  "location": "LoginStepDefinition.i_perform_healthCheckUp_operation_of_host_on_adminApp_server_of_enivronment(String,String)"
});
formatter.result({
  "duration": 5424169269,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.adminapp_Application_must_be_up_and_running()"
});
formatter.result({
  "duration": 5135588674,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 16,
      "value": "#test 1  check login"
    }
  ],
  "line": 18,
  "name": "Login Scenario",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;login-scenario",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 17,
      "name": "@Login"
    },
    {
      "line": 17,
      "name": "@smoke"
    },
    {
      "line": 17,
      "name": "@endToEnd"
    }
  ]
});
formatter.step({
  "line": 19,
  "name": "AdminApp url is open",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "I log in as an Admin user in AdminApp",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "I should be on AdminApp Home Page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinition.adminApp_url_is_open()"
});
formatter.result({
  "duration": 23825552,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.i_log_in_as_a_user_in_AdminApp()"
});
formatter.result({
  "duration": 14989238313,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.i_should_be_on_AdminApp_Home_Page()"
});
formatter.result({
  "duration": 4112664,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 24,
  "name": "Create a company",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-company",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 23,
      "name": "@createCompany"
    },
    {
      "line": 23,
      "name": "@smoke"
    },
    {
      "line": 23,
      "name": "@endToEnd"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "admin is on the AdminApp home page",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "create company with name \"\u003ccompanyName\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "admin click on Add companies",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "enter the company name on Add Companies page",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "click on Save Changes on Add Companies page",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "Company must be created",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "listed in the companies list with a company ID",
  "keyword": "And "
});
formatter.examples({
  "line": 33,
  "name": "",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-company;",
  "rows": [
    {
      "cells": [
        "companyName"
      ],
      "line": 34,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-company;;1"
    },
    {
      "cells": [
        "automationTest1"
      ],
      "line": 35,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-company;;2"
    },
    {
      "cells": [
        "automationTest2"
      ],
      "line": 36,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-company;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 35,
  "name": "Create a company",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-company;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 23,
      "name": "@createCompany"
    },
    {
      "line": 23,
      "name": "@smoke"
    },
    {
      "line": 23,
      "name": "@endToEnd"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "admin is on the AdminApp home page",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "create company with name \"automationTest1\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "admin click on Add companies",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "enter the company name on Add Companies page",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "click on Save Changes on Add Companies page",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "Company must be created",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "listed in the companies list with a company ID",
  "keyword": "And "
});
formatter.match({
  "location": "CommonStepDefinition.admin_is_on_the_AdminApp_home_page()"
});
formatter.result({
  "duration": 609715,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "automationTest1",
      "offset": 26
    }
  ],
  "location": "CompanyStepDefinition.create_company_with_name(String)"
});
formatter.result({
  "duration": 287364,
  "status": "passed"
});
formatter.match({
  "location": "CompanyStepDefinition.admin_click_on_Add_companies()"
});
formatter.result({
  "duration": 1219249840,
  "status": "passed"
});
formatter.match({
  "location": "CompanyStepDefinition.enter_the_company_name_on_Add_Companies_page()"
});
formatter.result({
  "duration": 243084722,
  "status": "passed"
});
formatter.match({
  "location": "CompanyStepDefinition.click_on_Save_Changes_on_Add_Companies_page()"
});
formatter.result({
  "duration": 1205202594,
  "status": "passed"
});
formatter.match({
  "location": "CompanyStepDefinition.company_must_be_created()"
});
formatter.result({
  "duration": 10220861131,
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of element located by By.xpath: //td[@data-label\u003d\u0027Name\u0027][contains(text(),\u0027automationTest1\u0027)] (tried for 10 second(s) with 1000 milliseconds interval)\r\n\tat org.openqa.selenium.support.ui.FluentWait.timeoutException(FluentWait.java:315)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:283)\r\n\tat com.de.adminApp.pages.GlobalPage.getCellFromList(GlobalPage.java:62)\r\n\tat com.de.adminApp.stepDefinitions.CompanyStepDefinition.company_must_be_created(CompanyStepDefinition.java:49)\r\n\tat ✽.Then Company must be created(EndToEndOrdering.feature:30)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Cannot locate an element using By.xpath: //td[@data-label\u003d\u0027Name\u0027][contains(text(),\u0027automationTest1\u0027)]\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.14.0\u0027, revision: \u0027aacccce0\u0027, time: \u00272018-08-02T20:19:58.91Z\u0027\nSystem info: host: \u0027SONY-PC\u0027, ip: \u0027172.20.10.5\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: driver.version: unknown\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.lambda$findElement$0(ExpectedConditions.java:896)\r\n\tat java.util.Optional.orElseThrow(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.findElement(ExpectedConditions.java:895)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:44)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:206)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:202)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:260)\r\n\tat com.de.adminApp.pages.GlobalPage.getCellFromList(GlobalPage.java:62)\r\n\tat com.de.adminApp.stepDefinitions.CompanyStepDefinition.company_must_be_created(CompanyStepDefinition.java:49)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:37)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:13)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:31)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:37)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:298)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:48)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:91)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.ExamplesRunner.run(ExamplesRunner.java:59)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.ScenarioOutlineRunner.run(ScenarioOutlineRunner.java:53)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:93)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:37)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:98)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "CompanyStepDefinition.listed_in_the_companies_list_with_a_company_ID()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 36,
  "name": "Create a company",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-company;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 23,
      "name": "@createCompany"
    },
    {
      "line": 23,
      "name": "@smoke"
    },
    {
      "line": 23,
      "name": "@endToEnd"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "admin is on the AdminApp home page",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "create company with name \"automationTest2\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "admin click on Add companies",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "enter the company name on Add Companies page",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "click on Save Changes on Add Companies page",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "Company must be created",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "listed in the companies list with a company ID",
  "keyword": "And "
});
formatter.match({
  "location": "CommonStepDefinition.admin_is_on_the_AdminApp_home_page()"
});
formatter.result({
  "duration": 64377,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "automationTest2",
      "offset": 26
    }
  ],
  "location": "CompanyStepDefinition.create_company_with_name(String)"
});
formatter.result({
  "duration": 138084,
  "status": "passed"
});
formatter.match({
  "location": "CompanyStepDefinition.admin_click_on_Add_companies()"
});
formatter.result({
  "duration": 94803983,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//a[contains(.,\u0027Add\u0027)]\"}\n  (Session info: chrome\u003d77.0.3865.90)\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.14.0\u0027, revision: \u0027aacccce0\u0027, time: \u00272018-08-02T20:19:58.91Z\u0027\nSystem info: host: \u0027SONY-PC\u0027, ip: \u0027172.20.10.5\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 77.0.3865.90, chrome: {chromedriverVersion: 77.0.3865.40 (f484704e052e0..., userDataDir: C:\\Users\\sony\\AppData\\Local...}, goog:chromeOptions: {debuggerAddress: localhost:59749}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 39fec6efa8b9cc7249dd2583ec560f0a\n*** Element info: {Using\u003dxpath, value\u003d//a[contains(.,\u0027Add\u0027)]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:548)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:322)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:424)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:314)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy14.click(Unknown Source)\r\n\tat com.de.adminApp.stepDefinitions.CompanyStepDefinition.admin_click_on_Add_companies(CompanyStepDefinition.java:32)\r\n\tat ✽.When admin click on Add companies(EndToEndOrdering.feature:27)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "CompanyStepDefinition.enter_the_company_name_on_Add_Companies_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CompanyStepDefinition.click_on_Save_Changes_on_Add_Companies_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CompanyStepDefinition.company_must_be_created()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CompanyStepDefinition.listed_in_the_companies_list_with_a_company_ID()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "line": 39,
  "name": "Create a User",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-user",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 38,
      "name": "@createLocation"
    },
    {
      "line": 38,
      "name": "@smoke"
    },
    {
      "line": 38,
      "name": "@endToEnd"
    }
  ]
});
formatter.step({
  "line": 40,
  "name": "admin is on the AdminApp home page",
  "keyword": "Given "
});
formatter.step({
  "line": 41,
  "name": "create User for company with \"\u003ccompanyName\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "admin click on Add Users",
  "keyword": "When "
});
formatter.step({
  "line": 43,
  "name": "select the \"\u003ccompanyName\u003e\" from company search bar on User Page",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "enter the \"\u003cfirstName\u003e\" and \"\u003cuserName\u003e\" and \"\u003cemail\u003e\" and \"\u003cRoles\u003e\" and password on Add User page",
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "click on Save Changes on Add User page",
  "keyword": "And "
});
formatter.step({
  "line": 46,
  "name": "User must be created",
  "keyword": "Then "
});
formatter.step({
  "line": 47,
  "name": "listed in the Users list with a User ID",
  "keyword": "And "
});
formatter.examples({
  "line": 49,
  "name": "",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-user;",
  "rows": [
    {
      "cells": [
        "companyName",
        "firstName",
        "userName",
        "email",
        "Roles"
      ],
      "line": 50,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-user;;1"
    },
    {
      "cells": [
        "automationCompany1",
        "testUser1",
        "autoUser111",
        "ashutoshsaxena06@gmail.com",
        "Both"
      ],
      "line": 51,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-user;;2"
    },
    {
      "cells": [
        "automationCompany2",
        "testUser2",
        "autoUser121",
        "ashutoshsaxena06@gmail.com",
        "Owner"
      ],
      "line": 52,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-user;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 51,
  "name": "Create a User",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-user;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 38,
      "name": "@smoke"
    },
    {
      "line": 38,
      "name": "@endToEnd"
    },
    {
      "line": 38,
      "name": "@createLocation"
    }
  ]
});
formatter.step({
  "line": 40,
  "name": "admin is on the AdminApp home page",
  "keyword": "Given "
});
formatter.step({
  "line": 41,
  "name": "create User for company with \"automationCompany1\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "admin click on Add Users",
  "keyword": "When "
});
formatter.step({
  "line": 43,
  "name": "select the \"automationCompany1\" from company search bar on User Page",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "enter the \"testUser1\" and \"autoUser111\" and \"ashutoshsaxena06@gmail.com\" and \"Both\" and password on Add User page",
  "matchedColumns": [
    1,
    2,
    3,
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "click on Save Changes on Add User page",
  "keyword": "And "
});
formatter.step({
  "line": 46,
  "name": "User must be created",
  "keyword": "Then "
});
formatter.step({
  "line": 47,
  "name": "listed in the Users list with a User ID",
  "keyword": "And "
});
formatter.match({
  "location": "CommonStepDefinition.admin_is_on_the_AdminApp_home_page()"
});
formatter.result({
  "duration": 59245,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "automationCompany1",
      "offset": 30
    }
  ],
  "location": "UserStepDefinition.create_User_for_company_with(String)"
});
formatter.result({
  "duration": 2360956,
  "status": "passed"
});
formatter.match({
  "location": "UserStepDefinition.admin_click_on_Add_Users()"
});
formatter.result({
  "duration": 44000741,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//a[contains(.,\u0027Add\u0027)]\"}\n  (Session info: chrome\u003d77.0.3865.90)\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.14.0\u0027, revision: \u0027aacccce0\u0027, time: \u00272018-08-02T20:19:58.91Z\u0027\nSystem info: host: \u0027SONY-PC\u0027, ip: \u0027172.20.10.5\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 77.0.3865.90, chrome: {chromedriverVersion: 77.0.3865.40 (f484704e052e0..., userDataDir: C:\\Users\\sony\\AppData\\Local...}, goog:chromeOptions: {debuggerAddress: localhost:59749}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 39fec6efa8b9cc7249dd2583ec560f0a\n*** Element info: {Using\u003dxpath, value\u003d//a[contains(.,\u0027Add\u0027)]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:548)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:322)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:424)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:314)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy14.click(Unknown Source)\r\n\tat com.de.adminApp.stepDefinitions.UserStepDefinition.admin_click_on_Add_Users(UserStepDefinition.java:34)\r\n\tat ✽.When admin click on Add Users(EndToEndOrdering.feature:42)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "automationCompany1",
      "offset": 12
    }
  ],
  "location": "UserStepDefinition.select_the_from_company_search_bar_on_User_Page(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "testUser1",
      "offset": 11
    },
    {
      "val": "autoUser111",
      "offset": 27
    },
    {
      "val": "ashutoshsaxena06@gmail.com",
      "offset": 45
    },
    {
      "val": "Both",
      "offset": 78
    }
  ],
  "location": "UserStepDefinition.enter_the_and_and_and_and_password_on_Add_User_page(String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "UserStepDefinition.click_on_Save_Changes_on_Add_User_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "UserStepDefinition.user_must_be_created()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "UserStepDefinition.listed_in_the_Users_list_with_a_User_ID()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 52,
  "name": "Create a User",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-user;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 38,
      "name": "@smoke"
    },
    {
      "line": 38,
      "name": "@endToEnd"
    },
    {
      "line": 38,
      "name": "@createLocation"
    }
  ]
});
formatter.step({
  "line": 40,
  "name": "admin is on the AdminApp home page",
  "keyword": "Given "
});
formatter.step({
  "line": 41,
  "name": "create User for company with \"automationCompany2\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "admin click on Add Users",
  "keyword": "When "
});
formatter.step({
  "line": 43,
  "name": "select the \"automationCompany2\" from company search bar on User Page",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "enter the \"testUser2\" and \"autoUser121\" and \"ashutoshsaxena06@gmail.com\" and \"Owner\" and password on Add User page",
  "matchedColumns": [
    1,
    2,
    3,
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "click on Save Changes on Add User page",
  "keyword": "And "
});
formatter.step({
  "line": 46,
  "name": "User must be created",
  "keyword": "Then "
});
formatter.step({
  "line": 47,
  "name": "listed in the Users list with a User ID",
  "keyword": "And "
});
formatter.match({
  "location": "CommonStepDefinition.admin_is_on_the_AdminApp_home_page()"
});
formatter.result({
  "duration": 63444,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "automationCompany2",
      "offset": 30
    }
  ],
  "location": "UserStepDefinition.create_User_for_company_with(String)"
});
formatter.result({
  "duration": 620911,
  "status": "passed"
});
formatter.match({
  "location": "UserStepDefinition.admin_click_on_Add_Users()"
});
formatter.result({
  "duration": 65664065,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//a[contains(.,\u0027Add\u0027)]\"}\n  (Session info: chrome\u003d77.0.3865.90)\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.14.0\u0027, revision: \u0027aacccce0\u0027, time: \u00272018-08-02T20:19:58.91Z\u0027\nSystem info: host: \u0027SONY-PC\u0027, ip: \u0027172.20.10.5\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 77.0.3865.90, chrome: {chromedriverVersion: 77.0.3865.40 (f484704e052e0..., userDataDir: C:\\Users\\sony\\AppData\\Local...}, goog:chromeOptions: {debuggerAddress: localhost:59749}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 39fec6efa8b9cc7249dd2583ec560f0a\n*** Element info: {Using\u003dxpath, value\u003d//a[contains(.,\u0027Add\u0027)]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:548)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:322)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:424)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:314)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy14.click(Unknown Source)\r\n\tat com.de.adminApp.stepDefinitions.UserStepDefinition.admin_click_on_Add_Users(UserStepDefinition.java:34)\r\n\tat ✽.When admin click on Add Users(EndToEndOrdering.feature:42)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "automationCompany2",
      "offset": 12
    }
  ],
  "location": "UserStepDefinition.select_the_from_company_search_bar_on_User_Page(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "testUser2",
      "offset": 11
    },
    {
      "val": "autoUser121",
      "offset": 27
    },
    {
      "val": "ashutoshsaxena06@gmail.com",
      "offset": 45
    },
    {
      "val": "Owner",
      "offset": 78
    }
  ],
  "location": "UserStepDefinition.enter_the_and_and_and_and_password_on_Add_User_page(String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "UserStepDefinition.click_on_Save_Changes_on_Add_User_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "UserStepDefinition.user_must_be_created()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "UserStepDefinition.listed_in_the_Users_list_with_a_User_ID()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 54,
      "value": "# test 4 creating New Locations from Admin portal"
    }
  ],
  "line": 56,
  "name": "Create a Location",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-location",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 55,
      "name": "@createLocation"
    },
    {
      "line": 55,
      "name": "@smoke"
    },
    {
      "line": 55,
      "name": "@endToEnd"
    }
  ]
});
formatter.step({
  "line": 57,
  "name": "admin is on the AdminApp home page",
  "keyword": "Given "
});
formatter.step({
  "line": 58,
  "name": "create Location for company with \"\u003ccompanyName\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 59,
  "name": "admin click on Add Locations",
  "keyword": "When "
});
formatter.step({
  "line": 60,
  "name": "select the \"\u003ccompanyName\u003e\" from company search bar on location page",
  "keyword": "And "
});
formatter.step({
  "line": 61,
  "name": "enter the \"\u003clocationName\u003e\" and \"\u003ctimeZone\u003e\" and \"\u003cproductList\u003e\" on Add Locations page",
  "keyword": "And "
});
formatter.step({
  "line": 62,
  "name": "click on Save Changes on Add Locations page",
  "keyword": "And "
});
formatter.step({
  "line": 63,
  "name": "Location must be created",
  "keyword": "Then "
});
formatter.step({
  "line": 64,
  "name": "listed in the Locations list with a Location ID",
  "keyword": "And "
});
formatter.examples({
  "line": 66,
  "name": "",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-location;",
  "rows": [
    {
      "cells": [
        "companyName",
        "locationName",
        "timeZone",
        "productList"
      ],
      "line": 67,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-location;;1"
    },
    {
      "cells": [
        "automationCompany1",
        "automationLoc1",
        "New York",
        "Shipwreck Bar and Grille"
      ],
      "line": 68,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-location;;2"
    },
    {
      "cells": [
        "automationCompany2",
        "automationLoc2",
        "Chicago",
        "Shipwreck Bar and Grille"
      ],
      "line": 69,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-location;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 68,
  "name": "Create a Location",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-location;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 55,
      "name": "@smoke"
    },
    {
      "line": 55,
      "name": "@endToEnd"
    },
    {
      "line": 55,
      "name": "@createLocation"
    }
  ]
});
formatter.step({
  "line": 57,
  "name": "admin is on the AdminApp home page",
  "keyword": "Given "
});
formatter.step({
  "line": 58,
  "name": "create Location for company with \"automationCompany1\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 59,
  "name": "admin click on Add Locations",
  "keyword": "When "
});
formatter.step({
  "line": 60,
  "name": "select the \"automationCompany1\" from company search bar on location page",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 61,
  "name": "enter the \"automationLoc1\" and \"New York\" and \"Shipwreck Bar and Grille\" on Add Locations page",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 62,
  "name": "click on Save Changes on Add Locations page",
  "keyword": "And "
});
formatter.step({
  "line": 63,
  "name": "Location must be created",
  "keyword": "Then "
});
formatter.step({
  "line": 64,
  "name": "listed in the Locations list with a Location ID",
  "keyword": "And "
});
formatter.match({
  "location": "CommonStepDefinition.admin_is_on_the_AdminApp_home_page()"
});
formatter.result({
  "duration": 62511,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "automationCompany1",
      "offset": 34
    }
  ],
  "location": "LocationStepDefinition.create_Location_for_company_with(String)"
});
formatter.result({
  "duration": 165141,
  "status": "passed"
});
formatter.match({
  "location": "LocationStepDefinition.admin_click_on_Add_Locations()"
});
formatter.result({
  "duration": 30789,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "automationCompany1",
      "offset": 12
    }
  ],
  "location": "LocationStepDefinition.select_the_from_company_search_bar_on_Location_page(String)"
});
formatter.result({
  "duration": 76040,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "automationLoc1",
      "offset": 11
    },
    {
      "val": "New York",
      "offset": 32
    },
    {
      "val": "Shipwreck Bar and Grille",
      "offset": 47
    }
  ],
  "location": "LocationStepDefinition.enter_the_and_and_on_Add_Locations_page(String,String,String)"
});
formatter.result({
  "duration": 118024,
  "status": "passed"
});
formatter.match({
  "location": "LocationStepDefinition.click_on_Save_Changes_on_Add_Locations_page()"
});
formatter.result({
  "duration": 23792,
  "status": "passed"
});
formatter.match({
  "location": "LocationStepDefinition.location_must_be_created()"
});
formatter.result({
  "duration": 23792,
  "status": "passed"
});
formatter.match({
  "location": "LocationStepDefinition.listed_in_the_Locations_list_with_a_Location_ID()"
});
formatter.result({
  "duration": 22392,
  "status": "passed"
});
formatter.scenario({
  "line": 69,
  "name": "Create a Location",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;create-a-location;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 55,
      "name": "@smoke"
    },
    {
      "line": 55,
      "name": "@endToEnd"
    },
    {
      "line": 55,
      "name": "@createLocation"
    }
  ]
});
formatter.step({
  "line": 57,
  "name": "admin is on the AdminApp home page",
  "keyword": "Given "
});
formatter.step({
  "line": 58,
  "name": "create Location for company with \"automationCompany2\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 59,
  "name": "admin click on Add Locations",
  "keyword": "When "
});
formatter.step({
  "line": 60,
  "name": "select the \"automationCompany2\" from company search bar on location page",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 61,
  "name": "enter the \"automationLoc2\" and \"Chicago\" and \"Shipwreck Bar and Grille\" on Add Locations page",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 62,
  "name": "click on Save Changes on Add Locations page",
  "keyword": "And "
});
formatter.step({
  "line": 63,
  "name": "Location must be created",
  "keyword": "Then "
});
formatter.step({
  "line": 64,
  "name": "listed in the Locations list with a Location ID",
  "keyword": "And "
});
formatter.match({
  "location": "CommonStepDefinition.admin_is_on_the_AdminApp_home_page()"
});
formatter.result({
  "duration": 73707,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "automationCompany2",
      "offset": 34
    }
  ],
  "location": "LocationStepDefinition.create_Location_for_company_with(String)"
});
formatter.result({
  "duration": 108695,
  "status": "passed"
});
formatter.match({
  "location": "LocationStepDefinition.admin_click_on_Add_Locations()"
});
formatter.result({
  "duration": 24258,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "automationCompany2",
      "offset": 12
    }
  ],
  "location": "LocationStepDefinition.select_the_from_company_search_bar_on_Location_page(String)"
});
formatter.result({
  "duration": 66243,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "automationLoc2",
      "offset": 11
    },
    {
      "val": "Chicago",
      "offset": 32
    },
    {
      "val": "Shipwreck Bar and Grille",
      "offset": 46
    }
  ],
  "location": "LocationStepDefinition.enter_the_and_and_on_Add_Locations_page(String,String,String)"
});
formatter.result({
  "duration": 113359,
  "status": "passed"
});
formatter.match({
  "location": "LocationStepDefinition.click_on_Save_Changes_on_Add_Locations_page()"
});
formatter.result({
  "duration": 19127,
  "status": "passed"
});
formatter.match({
  "location": "LocationStepDefinition.location_must_be_created()"
});
formatter.result({
  "duration": 19593,
  "status": "passed"
});
formatter.match({
  "location": "LocationStepDefinition.listed_in_the_Locations_list_with_a_Location_ID()"
});
formatter.result({
  "duration": 22392,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 71,
      "value": "#test 1  check login"
    }
  ],
  "line": 73,
  "name": "Login Scenario",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;login-scenario",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 72,
      "name": "@Login"
    },
    {
      "line": 72,
      "name": "@smoke"
    },
    {
      "line": 72,
      "name": "@endToEnd"
    }
  ]
});
formatter.step({
  "line": 74,
  "name": "I am in DiningEdge url",
  "keyword": "Given "
});
formatter.step({
  "line": 75,
  "name": "I log in as a \"Admin\" user",
  "keyword": "When "
});
formatter.step({
  "line": 76,
  "name": "I should be on Home Page",
  "keyword": "Then "
});
formatter.match({
  "location": "DEHomeStepDefinition.i_am_in_DiningEdge_url()"
});
formatter.result({
  "duration": 220188,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Admin",
      "offset": 15
    }
  ],
  "location": "DEHomeStepDefinition.i_log_in_as_a_user(String)"
});
formatter.result({
  "duration": 15380468954,
  "status": "passed"
});
formatter.match({
  "location": "DEHomeStepDefinition.i_should_be_on_Home_Page()"
});
formatter.result({
  "duration": 5032139513,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//div[@title\u003d\u0027Dashboard\u0027]/a\"}\n  (Session info: chrome\u003d77.0.3865.90)\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.14.0\u0027, revision: \u0027aacccce0\u0027, time: \u00272018-08-02T20:19:58.91Z\u0027\nSystem info: host: \u0027SONY-PC\u0027, ip: \u0027172.20.10.5\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 77.0.3865.90, chrome: {chromedriverVersion: 77.0.3865.40 (f484704e052e0..., userDataDir: C:\\Users\\sony\\AppData\\Local...}, goog:chromeOptions: {debuggerAddress: localhost:59749}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 39fec6efa8b9cc7249dd2583ec560f0a\n*** Element info: {Using\u003dxpath, value\u003d//div[@title\u003d\u0027Dashboard\u0027]/a}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:548)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:322)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:424)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:314)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy14.isDisplayed(Unknown Source)\r\n\tat com.de.deApp.stepdefinition.DEHomeStepDefinition.i_should_be_on_Home_Page(DEHomeStepDefinition.java:83)\r\n\tat ✽.Then I should be on Home Page(EndToEndOrdering.feature:76)\r\n",
  "status": "failed"
});
formatter.scenario({
  "comments": [
    {
      "line": 78,
      "value": "#test 2  check link count on home page"
    }
  ],
  "line": 80,
  "name": "check link count on home page",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;check-link-count-on-home-page",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 79,
      "name": "@Home"
    },
    {
      "line": 79,
      "name": "@Links"
    },
    {
      "line": 79,
      "name": "@functional"
    },
    {
      "line": 79,
      "name": "@smoke"
    },
    {
      "line": 79,
      "name": "@endToEnd"
    }
  ]
});
formatter.step({
  "line": 81,
  "name": "I am in DiningEdge homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 82,
  "name": "I check click on all links on this page",
  "keyword": "When "
});
formatter.step({
  "line": 83,
  "name": "get count",
  "keyword": "And "
});
formatter.step({
  "line": 84,
  "name": "I should be able to click on all links",
  "keyword": "Then "
});
formatter.step({
  "line": 85,
  "name": "Get total number of links on a page",
  "keyword": "And "
});
formatter.match({
  "location": "DEHomeStepDefinition.i_am_in_DiningEdge_homepage()"
});
formatter.result({
  "duration": 5026261614,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//h3[text()\u003d\u0027Dining edge\u0027]\"}\n  (Session info: chrome\u003d77.0.3865.90)\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.14.0\u0027, revision: \u0027aacccce0\u0027, time: \u00272018-08-02T20:19:58.91Z\u0027\nSystem info: host: \u0027SONY-PC\u0027, ip: \u0027172.20.10.5\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 77.0.3865.90, chrome: {chromedriverVersion: 77.0.3865.40 (f484704e052e0..., userDataDir: C:\\Users\\sony\\AppData\\Local...}, goog:chromeOptions: {debuggerAddress: localhost:59749}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 39fec6efa8b9cc7249dd2583ec560f0a\n*** Element info: {Using\u003dxpath, value\u003d//h3[text()\u003d\u0027Dining edge\u0027]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:548)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:322)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:424)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:314)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy14.isDisplayed(Unknown Source)\r\n\tat com.de.deApp.stepdefinition.DEHomeStepDefinition.i_am_in_DiningEdge_homepage(DEHomeStepDefinition.java:98)\r\n\tat ✽.Given I am in DiningEdge homepage(EndToEndOrdering.feature:81)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "DEHomeStepDefinition.i_check_click_on_all_links_on_this_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DEHomeStepDefinition.get_count()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DEHomeStepDefinition.i_should_be_able_to_click_on_all_links()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DEHomeStepDefinition.get_total_number_of_links_on_a_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 87,
      "value": "#test 4  check side bar options"
    }
  ],
  "line": 89,
  "name": "check side bar options",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;check-side-bar-options",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 88,
      "name": "@SideBar"
    },
    {
      "line": 88,
      "name": "@functional"
    },
    {
      "line": 88,
      "name": "@smoke"
    },
    {
      "line": 88,
      "name": "@endToEnd"
    }
  ]
});
formatter.step({
  "line": 90,
  "name": "I am in DiningEdge homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 91,
  "name": "I go to side bar \"\u003coption\u003e\" available on homepage",
  "keyword": "When "
});
formatter.step({
  "line": 92,
  "name": "\"\u003caction\u003e\" on side bar option",
  "keyword": "And "
});
formatter.step({
  "line": 93,
  "name": "I should be able to click on \"\u003coption\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 94,
  "name": "new page linked to that option should be displayed",
  "keyword": "And "
});
formatter.examples({
  "line": 96,
  "name": "",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;check-side-bar-options;",
  "rows": [
    {
      "cells": [
        "option",
        "action"
      ],
      "line": 97,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;check-side-bar-options;;1"
    },
    {
      "cells": [
        "Order Edge",
        "click"
      ],
      "line": 98,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;check-side-bar-options;;2"
    },
    {
      "cells": [
        "Order from OG",
        "click"
      ],
      "line": 99,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;check-side-bar-options;;3"
    },
    {
      "cells": [
        "Pending Orders",
        "click"
      ],
      "line": 100,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;check-side-bar-options;;4"
    },
    {
      "cells": [
        "Orders Guides",
        "click"
      ],
      "line": 101,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;check-side-bar-options;;5"
    },
    {
      "cells": [
        "Reports",
        "click"
      ],
      "line": 102,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;check-side-bar-options;;6"
    },
    {
      "cells": [
        "Manage Items",
        "click"
      ],
      "line": 103,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;check-side-bar-options;;7"
    },
    {
      "cells": [
        "Purchases",
        "click"
      ],
      "line": 104,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;check-side-bar-options;;8"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 98,
  "name": "check side bar options",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;check-side-bar-options;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 88,
      "name": "@SideBar"
    },
    {
      "line": 88,
      "name": "@smoke"
    },
    {
      "line": 88,
      "name": "@endToEnd"
    },
    {
      "line": 88,
      "name": "@functional"
    }
  ]
});
formatter.step({
  "line": 90,
  "name": "I am in DiningEdge homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 91,
  "name": "I go to side bar \"Order Edge\" available on homepage",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 92,
  "name": "\"click\" on side bar option",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 93,
  "name": "I should be able to click on \"Order Edge\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 94,
  "name": "new page linked to that option should be displayed",
  "keyword": "And "
});
formatter.match({
  "location": "DEHomeStepDefinition.i_am_in_DiningEdge_homepage()"
});
formatter.result({
  "duration": 5029006033,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//h3[text()\u003d\u0027Dining edge\u0027]\"}\n  (Session info: chrome\u003d77.0.3865.90)\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.14.0\u0027, revision: \u0027aacccce0\u0027, time: \u00272018-08-02T20:19:58.91Z\u0027\nSystem info: host: \u0027SONY-PC\u0027, ip: \u0027172.20.10.5\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 77.0.3865.90, chrome: {chromedriverVersion: 77.0.3865.40 (f484704e052e0..., userDataDir: C:\\Users\\sony\\AppData\\Local...}, goog:chromeOptions: {debuggerAddress: localhost:59749}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 39fec6efa8b9cc7249dd2583ec560f0a\n*** Element info: {Using\u003dxpath, value\u003d//h3[text()\u003d\u0027Dining edge\u0027]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:548)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:322)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:424)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:314)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy14.isDisplayed(Unknown Source)\r\n\tat com.de.deApp.stepdefinition.DEHomeStepDefinition.i_am_in_DiningEdge_homepage(DEHomeStepDefinition.java:98)\r\n\tat ✽.Given I am in DiningEdge homepage(EndToEndOrdering.feature:90)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Order Edge",
      "offset": 18
    }
  ],
  "location": "DEHomeStepDefinition.i_go_to_side_bar_available_on_homepage(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "click",
      "offset": 1
    }
  ],
  "location": "DEHomeStepDefinition.on_side_bar_option(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Order Edge",
      "offset": 30
    }
  ],
  "location": "DEHomeStepDefinition.i_should_be_able_to_click_on(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DEHomeStepDefinition.new_page_linked_to_that_option_should_be_displayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 99,
  "name": "check side bar options",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;check-side-bar-options;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 88,
      "name": "@SideBar"
    },
    {
      "line": 88,
      "name": "@smoke"
    },
    {
      "line": 88,
      "name": "@endToEnd"
    },
    {
      "line": 88,
      "name": "@functional"
    }
  ]
});
formatter.step({
  "line": 90,
  "name": "I am in DiningEdge homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 91,
  "name": "I go to side bar \"Order from OG\" available on homepage",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 92,
  "name": "\"click\" on side bar option",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 93,
  "name": "I should be able to click on \"Order from OG\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 94,
  "name": "new page linked to that option should be displayed",
  "keyword": "And "
});
formatter.match({
  "location": "DEHomeStepDefinition.i_am_in_DiningEdge_homepage()"
});
