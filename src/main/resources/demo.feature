package com.xyz.framework.api;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyz.framework.api.BaseApi.1;
import com.xyz.framework.api.curlloggingutil.CurlLoggingRestAssuredConfigBuilder;
import com.xyz.framework.reporting.Reporter;
import com.xyz.framework.reporting.reports.Report;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.fest.assertions.api.Assertions;
import org.json.simple.parser.ParseException;

public class BaseApi {
private CustomRequestSpecBuilder requestSpecBuilder = new CustomRequestSpecBuilder();
private com.xyz.framework.api.BaseApi.MethodType method;
private Report report;

public BaseApi(Report report) {
this.report = Reporter.report;
this.report = report;
}

public BaseApi() {
this.report = Reporter.report;
}

public com.xyz.framework.api.BaseApi.MethodType getMethod() {
return this.method;
}

public void setMethod(com.xyz.framework.api.BaseApi.MethodType method) {
this.method = method;
}

public CustomRequestSpecBuilder getRequestSpecBuilder() {
return this.requestSpecBuilder;
}

public Response execute() {
RequestSpecification requestSpecification = this.requestSpecBuilder.build();
RestAssured.defaultParser = Parser.JSON;
RestAssuredConfig config = (new CurlLoggingRestAssuredConfigBuilder()).build();
Response response;
switch(1.$SwitchMap$com$xyz$framework$api$BaseApi$MethodType[this.method.ordinal()]) {
case 1:
response = (Response)RestAssured.given().config(config).spec(requestSpecification).when().get();
break;
case 2:
response = (Response)RestAssured.given().config(config).spec(requestSpecification).when().post();
break;
case 3:
response = (Response)RestAssured.given().config(config).spec(requestSpecification).when().put();
break;
case 4:
response = (Response)RestAssured.given().config(config).spec(requestSpecification).when().delete();
break;
case 5:
response = (Response)RestAssured.given().config(config).spec(requestSpecification).when().patch();
break;
default:
throw new RuntimeException("API method not specified");
}

this.printResponse(response);
return response;
}

public Response executeUntilExpectedConditionMet(String expectedJSONKey, String expectedJSONValue, int pollingTimeInSec, int pollingCountInSec) {
Response response = null;
String actualJSONValue = "";

try {
for(int i = 0; i < pollingCountInSec; ++i) {
response = this.execute();
actualJSONValue = response.jsonPath().get(expectedJSONKey).toString();
if (expectedJSONValue.equalsIgnoreCase(actualJSONValue)) {
break;
}

Thread.sleep((long)(pollingTimeInSec * 1000));
}
} catch (InterruptedException var8) {
var8.printStackTrace();
}

Assertions.assertThat(actualJSONValue).isEqualToIgnoringCase(expectedJSONValue);
return response;
}

private void printResponse(Response response) {
String contentType = response.contentType();
if (!contentType.toLowerCase().contains("text/html") && !contentType.toLowerCase().contains("text/plain")) {
this.report.info("API Response:" + response.getBody().prettyPrint(), new Object[0]);
} else {
DateFormat timeFormat = new SimpleDateFormat("MM.dd.yyyy HH-mm-ss");
String fileName = org.testng.Reporter.getCurrentTestResult().getMethod().getMethodName() + "_" + timeFormat.format(new Date()) + ".html";
String outputDir = org.testng.Reporter.getCurrentTestResult().getTestContext().getOutputDirectory();
outputDir = outputDir.substring(0, outputDir.lastIndexOf(File.separator)) + "/html";
File file = new File(outputDir + File.separator + fileName);
if (file.getParentFile() != null) {
file.getParentFile().mkdirs();
}

PrintWriter writer = null;

try {
file.createNewFile();
writer = new PrintWriter(file);
writer.write(response.asString());
writer.flush();
this.report.attachHtml(file);
} catch (Throwable var12) {
throw new RuntimeException(var12);
} finally {
writer.close();
}
}

}

public BaseApi setBodyOmitNullValueAttributes(Object obj) {
String request = "";
ObjectMapper mapper = new ObjectMapper();
mapper.configure(MapperFeature.USE_ANNOTATIONS, false);
mapper.setSerializationInclusion(Include.NON_NULL);

try {
request = mapper.writeValueAsString(obj);
} catch (Throwable var5) {
throw new RuntimeException(var5);
}

this.requestSpecBuilder.setBody(request);
return this;
}

public BaseApi setBodyKeepNullValueAttributes(Object obj) {
String request = "";
ObjectMapper mapper = new ObjectMapper();
mapper.configure(MapperFeature.USE_ANNOTATIONS, false);
mapper.setSerializationInclusion(Include.ALWAYS);

try {
request = mapper.writeValueAsString(obj);
} catch (Exception var5) {
throw new RuntimeException(var5);
}

this.requestSpecBuilder.setBody(request);
return this;
}

public BaseApi setBody(Object obj) {
this.requestSpecBuilder.setBody(obj);
return this;
}

public BaseApi setBody(String jsonFilePath, Map<String, String> keysToUpdate) throws IOException, ParseException {
this.requestSpecBuilder.setBody(jsonFilePath, keysToUpdate);
return this;
}
}
