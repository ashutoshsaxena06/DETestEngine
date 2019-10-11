$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("EtoEfromOrderEdge.feature");
formatter.feature({
  "line": 2,
  "name": "this feature targets the end to end Ordering flow",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@EndToEndOrdering"
    }
  ]
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 7,
      "value": "# And check if the User and Company exists"
    }
  ],
  "line": 9,
  "name": "Ordering for one vendor : Place order from Order edge",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;ordering-for-one-vendor-:-place-order-from-order-edge",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 8,
      "name": "@EndToEndOrdering"
    },
    {
      "line": 8,
      "name": "@Ordering"
    },
    {
      "line": 8,
      "name": "@OrderEdge"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "user is on adminApp home page",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "Create a new Company \"\u003ccompanyName\u003e\" in adminApp",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Create \"\u003cuserName\u003e\" and assign \"\u003ccompanyName\u003e\" in adminApp",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Login DE webApp with \"\u003cuserName\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Go to settings page",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 15,
      "value": "#And Add company Logo"
    }
  ],
  "line": 16,
  "name": "Create a new location \"\u003clocationName\u003e\" with required basic and notification tab details",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Verify the created location",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "Create a new vendor \"\u003cvendorName\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "Verify the created vendor \"\u003cvendorName\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "Edit vendor to add the Order notification E-mail addresses",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "Navigate to manage product list",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "Create a new product list as \"\u003cproductList\u003e\" and assign to \"\u003clocationName\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "Verify the created productList",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "Navigate to product list in manage items",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "Import a valid product list file",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "Verify the count of products imported from product list file",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "Switch to adminApp",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "Go to order guides in vendors in adminApp",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "Create a new order guide with file \"\u003corderGuide\u003e\" in adminApp",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "Verify the created order guide in adminApp",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "Switch to DE webApp",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "Verify the created order guide in DE webApp",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "Add comparable for a product",
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "Select quantity \"\u003cproductQuantity\u003e\" to order",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "Go to cart using cart icon",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "Verify the product details on checkout page",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "Submit the Order on checkout page",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "Verify the Order details on review page",
  "keyword": "Then "
});
formatter.examples({
  "line": 40,
  "name": "",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;ordering-for-one-vendor-:-place-order-from-order-edge;",
  "rows": [
    {
      "cells": [
        "companyName",
        "userName",
        "locationName",
        "vendorName",
        "productList",
        "orderGuide",
        "productQuantity"
      ],
      "line": 41,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;ordering-for-one-vendor-:-place-order-from-order-edge;;1"
    },
    {
      "cells": [
        "testCompany6Oct19",
        "testUser6Oct19",
        "6Oct",
        "US Foods",
        "productList1",
        "USF GP",
        "10"
      ],
      "line": 42,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;ordering-for-one-vendor-:-place-order-from-order-edge;;2"
    },
    {
      "cells": [
        "testCompany7Oct19",
        "testUser7Oct19",
        "7Oct",
        "Sysco",
        "productList2",
        "sysco gp",
        "20"
      ],
      "line": 43,
      "id": "this-feature-targets-the-end-to-end-ordering-flow;ordering-for-one-vendor-:-place-order-from-order-edge;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "login to admin app",
  "keyword": "Given "
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.login_to_admin_app()"
});
formatter.result({
  "duration": 34795934247,
  "status": "passed"
});
formatter.scenario({
  "line": 42,
  "name": "Ordering for one vendor : Place order from Order edge",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;ordering-for-one-vendor-:-place-order-from-order-edge;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@EndToEndOrdering"
    },
    {
      "line": 8,
      "name": "@OrderEdge"
    },
    {
      "line": 8,
      "name": "@Ordering"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "user is on adminApp home page",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "Create a new Company \"testCompany6Oct19\" in adminApp",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Create \"testUser6Oct19\" and assign \"testCompany6Oct19\" in adminApp",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Login DE webApp with \"testUser6Oct19\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Go to settings page",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 15,
      "value": "#And Add company Logo"
    }
  ],
  "line": 16,
  "name": "Create a new location \"6Oct\" with required basic and notification tab details",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Verify the created location",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "Create a new vendor \"US Foods\"",
  "matchedColumns": [
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "Verify the created vendor \"US Foods\"",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "Edit vendor to add the Order notification E-mail addresses",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "Navigate to manage product list",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "Create a new product list as \"productList1\" and assign to \"6Oct\"",
  "matchedColumns": [
    2,
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "Verify the created productList",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "Navigate to product list in manage items",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "Import a valid product list file",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "Verify the count of products imported from product list file",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "Switch to adminApp",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "Go to order guides in vendors in adminApp",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "Create a new order guide with file \"USF GP\" in adminApp",
  "matchedColumns": [
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "Verify the created order guide in adminApp",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "Switch to DE webApp",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "Verify the created order guide in DE webApp",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "Add comparable for a product",
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "Select quantity \"10\" to order",
  "matchedColumns": [
    6
  ],
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "Go to cart using cart icon",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "Verify the product details on checkout page",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "Submit the Order on checkout page",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "Verify the Order details on review page",
  "keyword": "Then "
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.user_is_on_adminApp_home_page()"
});
formatter.result({
  "duration": 124289226,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testCompany6Oct19",
      "offset": 22
    }
  ],
  "location": "EtoEfromOrderEdgeStepDefinition.create_a_new_Company_in_adminApp(String)"
});
formatter.result({
  "duration": 4661611960,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testUser6Oct19",
      "offset": 8
    },
    {
      "val": "testCompany6Oct19",
      "offset": 36
    }
  ],
  "location": "EtoEfromOrderEdgeStepDefinition.create_and_assign_in_adminApp(String,String)"
});
formatter.result({
  "duration": 8161616859,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testUser6Oct19",
      "offset": 22
    }
  ],
  "location": "EtoEfromOrderEdgeStepDefinition.login_DE_webApp_with(String)"
});
formatter.result({
  "duration": 60049931588,
  "error_message": "org.openqa.selenium.TimeoutException: timeout\n  (Session info: chrome\u003d77.0.3865.90)\n  (Driver info: chromedriver\u003d77.0.3865.40 (f484704e052e0b556f8030b65b953dce96503217-refs/branch-heads/3865@{#442}),platform\u003dWindows NT 6.1.7601 SP1 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 60.03 seconds\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027sony-PC\u0027, ip: \u0027192.168.1.26\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, timeouts\u003d{implicit\u003d0, pageLoad\u003d300000, script\u003d30000}, hasTouchScreen\u003dfalse, platform\u003dXP, acceptSslCerts\u003dfalse, goog:chromeOptions\u003d{debuggerAddress\u003dlocalhost:57090}, acceptInsecureCerts\u003dfalse, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003dignore, applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d77.0.3865.40 (f484704e052e0b556f8030b65b953dce96503217-refs/branch-heads/3865@{#442}), userDataDir\u003dC:\\Users\\sony\\AppData\\Local\\Temp\\scoped_dir6056_2127911997}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, strictFileInteractability\u003dfalse, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d77.0.3865.90, browserConnectionEnabled\u003dfalse, proxy\u003d{}, nativeEvents\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: a93c42b4446a89dd114e00a06e59adb4\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.get(RemoteWebDriver.java:316)\r\n\tat com.de.base.page.BasePage.launch(BasePage.java:115)\r\n\tat com.de.deApp.pageObjects.DELogin.launchURL(DELogin.java:55)\r\n\tat com.de.deApp.stepdefinition.EtoEfromOrderEdgeStepDefinition.login_DE_webApp_with(EtoEfromOrderEdgeStepDefinition.java:118)\r\n\tat ✽.And Login DE webApp with \"testUser6Oct19\"(EtoEfromOrderEdge.feature:13)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.go_to_settings_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "6Oct",
      "offset": 23
    }
  ],
  "location": "EtoEfromOrderEdgeStepDefinition.create_a_new_location_with_required_basic_and_notification_tab_details(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.verify_the_created_location()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "US Foods",
      "offset": 21
    }
  ],
  "location": "EtoEfromOrderEdgeStepDefinition.create_a_new_vendor(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "US Foods",
      "offset": 27
    }
  ],
  "location": "EtoEfromOrderEdgeStepDefinition.verify_the_created_vendor(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.edit_vendor_to_add_the_Order_notification_E_mail_addresses()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.navigate_to_manage_product_list()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "productList1",
      "offset": 30
    },
    {
      "val": "6Oct",
      "offset": 59
    }
  ],
  "location": "EtoEfromOrderEdgeStepDefinition.create_a_new_product_list_as_and_assign_to(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.verify_the_created_productList()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.navigate_to_product_list_in_manage_items()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.import_a_valid_product_list_file()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.verify_the_count_of_products_imported_from_product_list_file()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.switch_to_adminApp()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.go_to_order_guides_in_vendors_in_adminApp()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "USF GP",
      "offset": 36
    }
  ],
  "location": "EtoEfromOrderEdgeStepDefinition.create_a_new_order_guide_with_file_in_adminApp(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.verify_the_created_order_guide_in_adminApp()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.switch_to_DE_webApp()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.verify_the_created_order_guide_in_DE_webApp()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.add_comparable_for_a_product()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 17
    }
  ],
  "location": "EtoEfromOrderEdgeStepDefinition.select_quantity_to_order(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.go_to_cart_using_cart_icon()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.verify_the_product_details_on_checkout_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.submit_the_Order_on_checkout_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.verify_the_Order_details_on_review_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "login to admin app",
  "keyword": "Given "
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.login_to_admin_app()"
});
formatter.result({
  "duration": 13975360291,
  "status": "passed"
});
formatter.scenario({
  "line": 43,
  "name": "Ordering for one vendor : Place order from Order edge",
  "description": "",
  "id": "this-feature-targets-the-end-to-end-ordering-flow;ordering-for-one-vendor-:-place-order-from-order-edge;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@EndToEndOrdering"
    },
    {
      "line": 8,
      "name": "@OrderEdge"
    },
    {
      "line": 8,
      "name": "@Ordering"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "user is on adminApp home page",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "Create a new Company \"testCompany7Oct19\" in adminApp",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Create \"testUser7Oct19\" and assign \"testCompany7Oct19\" in adminApp",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Login DE webApp with \"testUser7Oct19\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Go to settings page",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 15,
      "value": "#And Add company Logo"
    }
  ],
  "line": 16,
  "name": "Create a new location \"7Oct\" with required basic and notification tab details",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Verify the created location",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "Create a new vendor \"Sysco\"",
  "matchedColumns": [
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "Verify the created vendor \"Sysco\"",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "Edit vendor to add the Order notification E-mail addresses",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "Navigate to manage product list",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "Create a new product list as \"productList2\" and assign to \"7Oct\"",
  "matchedColumns": [
    2,
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "Verify the created productList",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "Navigate to product list in manage items",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "Import a valid product list file",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "Verify the count of products imported from product list file",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "Switch to adminApp",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "Go to order guides in vendors in adminApp",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "Create a new order guide with file \"sysco gp\" in adminApp",
  "matchedColumns": [
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "Verify the created order guide in adminApp",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "Switch to DE webApp",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "Verify the created order guide in DE webApp",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "Add comparable for a product",
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "Select quantity \"20\" to order",
  "matchedColumns": [
    6
  ],
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "Go to cart using cart icon",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "Verify the product details on checkout page",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "Submit the Order on checkout page",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "Verify the Order details on review page",
  "keyword": "Then "
});
formatter.match({
  "location": "EtoEfromOrderEdgeStepDefinition.user_is_on_adminApp_home_page()"
});
formatter.result({
  "duration": 143807675,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testCompany7Oct19",
      "offset": 22
    }
  ],
  "location": "EtoEfromOrderEdgeStepDefinition.create_a_new_Company_in_adminApp(String)"
});
