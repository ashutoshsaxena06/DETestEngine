package com.de.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(plugin = { "pretty", "html:target/cucumber",
		"json:target/cucumber/vendors.json" },
	features = {"src/test/resources/"},
	glue = {"com.de.stepDefinitions"},
	monochrome = true,
	dryRun = false,
	strict = false,
	tags = "@manageVendors")

public class locationRunner {
/*
	 * public static String mailSmtpHost = "uksmtp.markit.partners"; public static
	 * String envpath = "env.properties"; public static String mailTo = ""; public
	 * static String mailCc = ""; public static String mailFrom = ""; public static
	 * String emailMessage=""; public static String reportFile=
	 * System.getProperty("user.dir") + File.separator +
	 * "extentsReport/Report.html";
	 * 
	 * 
	 * @AfterClass public static void sendReport(){ Mailing smail = new
	 * Mailing(mailSmtpHost); Properties pro = new Properties(); try { pro.load(new
	 * FileInputStream(envpath)); mailTo = pro.getProperty("Email_TO"); mailCc =
	 * pro.getProperty("Email_CC"); mailFrom = pro.getProperty("Email_from");
	 * 
	 * } catch (FileNotFoundException e1) { e1.printStackTrace(); } catch
	 * (IOException e1) { e1.printStackTrace(); } try { String emailMsg =
	 * "USAgg Membership/ Calculation API Automation Status:\n"; if
	 * (!emailMessage.equals("")) { emailMsg = emailMsg + "\n" + emailMessage +
	 * "\n"; } smail.addMessage(emailMsg); smail.attachFile(reportFile); //
	 * smail.attachFile(); smail.setContent();
	 * smail.addSubject("USAgg Membership/ Calculation API Automation Test Status");
	 * smail.setAddress(RecipientType.TO, mailTo);
	 * smail.setAddress(RecipientType.CC, mailCc); smail.sendAction(mailFrom); }
	 * catch (Exception e) { e.printStackTrace(); } finally {
	 * System.out.println("Finished ####"); }
	 * System.out.println("Email Sent with Attachment"); }
	 */
}
