package com.de.reporting.listeners;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.testng.IInvokedMethod;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.collections.Lists;
import org.testng.internal.Utils;
import org.testng.log4testng.Logger;
import org.testng.xml.XmlSuite;


public class CustomizedEmailableReport implements IReporter {
    private static final Logger L = Logger.getLogger(CustomizedEmailableReport.class);
    private PrintWriter out;
    private int row;
    private Integer testIndex;
    private int methodIndex;
    private Scanner scanner;
    private List<String> failedMethods = new ArrayList();

    public CustomizedEmailableReport() {
    }

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outdir) {
        try {
            this.out = this.createWriter(outdir);
        } catch (IOException var5) {
            L.error("output file", var5);
            return;
        }

        this.startHtml(this.out);
        this.generateSuiteSummaryReport(suites);
        this.generateMethodSummaryReport(suites);
        this.endHtml(this.out);
        this.out.flush();
        this.out.close();
    }

    protected PrintWriter createWriter(String outdir) throws IOException {
        (new File(outdir)).mkdirs();
        return new PrintWriter(new BufferedWriter(new FileWriter(new File(outdir, "customized-emailable-report.html"))));
    }

    protected void generateMethodSummaryReport(List<ISuite> suites) {
        this.methodIndex = 0;
        this.startResultSummaryTable("methodOverview");
        int testIndex = 1;
        Iterator var3 = suites.iterator();

        while(var3.hasNext()) {
            ISuite suite = (ISuite)var3.next();
            if (suites.size() >= 1) {
                this.titleRow(suite.getName(), 5);
            }

            Map<String, ISuiteResult> r = suite.getResults();

            for(Iterator var6 = r.values().iterator(); var6.hasNext(); ++testIndex) {
                ISuiteResult r2 = (ISuiteResult)var6.next();
                ITestContext testContext = r2.getTestContext();
                String testName = testContext.getName();
                this.testIndex = testIndex;
                this.resultSummary(suite, testContext.getFailedConfigurations(), testName, "failed", " (configuration methods)");
                this.resultSummary(suite, testContext.getFailedTests(), testName, "failed", "");
                this.resultSummary(suite, testContext.getPassedTests(), testName, "passed", "");
                this.resultSummary(suite, this.getactualSkippedTests(testContext), testName, "skipped", "");
            }
        }

        this.out.println("</table>");
    }

    private IResultMap getactualSkippedTests(ITestContext testContext) {
        IResultMap skippedTests = testContext.getSkippedTests();
        IResultMap failedTests = testContext.getFailedTests();
        IResultMap passedTests = testContext.getPassedTests();
        Iterator var5 = failedTests.getAllResults().iterator();

        ITestResult result;
        while(var5.hasNext()) {
            result = (ITestResult)var5.next();
            skippedTests.removeResult(result.getMethod());
        }

        var5 = passedTests.getAllResults().iterator();

        while(var5.hasNext()) {
            result = (ITestResult)var5.next();
            skippedTests.removeResult(result.getMethod());
        }

        return skippedTests;
    }

    protected void generateMethodDetailReport(List<ISuite> suites) {
        this.methodIndex = 0;
        Iterator var2 = suites.iterator();

        while(var2.hasNext()) {
            ISuite suite = (ISuite)var2.next();
            Map<String, ISuiteResult> r = suite.getResults();
            Iterator var5 = r.values().iterator();

            while(var5.hasNext()) {
                ISuiteResult r2 = (ISuiteResult)var5.next();
                ITestContext testContext = r2.getTestContext();
                if (r.values().size() > 0) {
                    this.out.println("<h1>" + testContext.getName() + "</h1>");
                }

                this.resultDetail(testContext.getFailedConfigurations());
                this.resultDetail(testContext.getFailedTests());
                this.resultDetail(testContext.getSkippedConfigurations());
                this.resultDetail(testContext.getSkippedTests());
                this.resultDetail(testContext.getPassedTests());
            }
        }

    }

    private void resultSummary(ISuite suite, IResultMap tests, String testname, String style, String details) {
        if (tests.getAllResults().size() > 0) {
            StringBuffer buff = new StringBuffer();
            String lastClassName = "";
            int mq = 0;
            int cq = 0;
            Iterator var10 = this.getMethodSet(tests, suite).iterator();

            label120:
            while(var10.hasNext()) {
                ITestNGMethod method = (ITestNGMethod)var10.next();
                ++this.row;
                ++this.methodIndex;
                ITestClass testClass = method.getTestClass();
                String className = testClass.getName();
                if (mq == 0) {
                    String id = this.testIndex == null ? null : "t" + Integer.toString(this.testIndex);
                    this.titleRow(testname + " &#8212; " + style + details, 5, id);
                    this.testIndex = null;
                }

                if (!className.equalsIgnoreCase(lastClassName)) {
                    if (mq > 0) {
                        ++cq;
                        this.out.print("<tr class=\"" + style + (cq % 2 == 0 ? "even" : "odd") + "\"><td");
                        if (mq > 1) {
                            this.out.print(" rowspan=\"" + mq + "\"");
                        }

                        this.out.println(">" + lastClassName + "</td>" + buff);
                    }

                    mq = 0;
                    buff.setLength(0);
                    lastClassName = className;
                }

                Set<ITestResult> resultSet = tests.getResults(method);
                long end = -9223372036854775808L;
                long start = 9223372036854775807L;
                long startMS = 0L;
                String firstLine = "";
                Iterator var22 = tests.getResults(method).iterator();

                while(true) {
                    List msgs;
                    boolean hasReporterOutput;
                    do {
                        ITestResult testResult;
                        Throwable exception;
                        boolean hasThrowable;
                        do {
                            if (!var22.hasNext()) {
                                DateFormat formatter = new SimpleDateFormat("kk:mm:ss");
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTimeInMillis(startMS);
                                ++mq;
                                if (mq > 1) {
                                    buff.append("<tr class=\"" + style + (cq % 2 == 0 ? "odd" : "even") + "\">");
                                }

                                String description = method.getDescription();
                                String testInstanceName = ((ITestResult[])resultSet.toArray(new ITestResult[0]))[0].getTestName();
                                buff.append("<td>" + this.qualifiedName(method) + " " + (description != null && description.length() > 0 ? "(\"" + description + "\")" : "") + (null == testInstanceName ? "" : "<br>(" + testInstanceName + ")") + "</td><td class=\"numi\" style=\"text-align:left;padding-right:2em\">" + firstLine + "<br/></td><td style=\"text-align:right\">" + formatter.format(calendar.getTime()) + "</td><td class=\"numi\">" + this.millisToTimeConversion(end - start) + "</td></tr>");
                                continue label120;
                            }

                            testResult = (ITestResult)var22.next();
                            if (testResult.getEndMillis() > end) {
                                end = testResult.getEndMillis() / 1000L;
                            }

                            if (testResult.getStartMillis() < start) {
                                startMS = testResult.getStartMillis();
                                start = startMS / 1000L;
                            }

                            exception = testResult.getThrowable();
                            hasThrowable = exception != null;
                        } while(!hasThrowable);

                        String str = Utils.stackTrace(exception, true)[0];
                        this.scanner = new Scanner(str);
                        firstLine = this.scanner.nextLine();
                        msgs = Reporter.getOutput(testResult);
                        hasReporterOutput = msgs.size() > 0;
                    } while(!hasReporterOutput);

                    String var30;
                    for(Iterator var29 = msgs.iterator(); var29.hasNext(); var30 = (String)var29.next()) {
                    }
                }
            }

            if (mq > 0) {
                ++cq;
                this.out.print("<tr class=\"" + style + (cq % 2 == 0 ? "even" : "odd") + "\"><td");
                if (mq > 1) {
                    this.out.print(" rowspan=\"" + mq + "\"");
                }

                this.out.println(">" + lastClassName + "</td>" + buff);
            }
        }

    }

    private String millisToTimeConversion(long seconds) {
        int MINUTES_IN_AN_HOUR = 0;
        int SECONDS_IN_A_MINUTE = 0;
        int minutes = (int)(seconds / 60L);
        seconds -= (long)(minutes * 60);
        int hours = minutes / 60;
        minutes -= hours * 60;
        return this.prefixZeroToDigit(hours) + ":" + this.prefixZeroToDigit(minutes) + ":" + this.prefixZeroToDigit((int)seconds);
    }

    private String prefixZeroToDigit(int num) {
        if (num <= 9) {
            String sNumber = "0" + num;
            return sNumber;
        } else {
            return "" + num;
        }
    }

    private void startResultSummaryTable(String style) {
        this.tableStart(style, "summary");
        this.out.println("<tr><th>Class</th><th>Method</th><th>Exception </th><th>Start Time </th><th>Time<br/>(hh:mm:ss)</th></tr>");
        this.row = 0;
    }

    private String qualifiedName(ITestNGMethod method) {
        StringBuilder addon = new StringBuilder();
        String[] groups = method.getGroups();
        int length = groups.length;
        if (length > 0 && !"basic".equalsIgnoreCase(groups[0])) {
            addon.append("(");

            for(int i = 0; i < length; ++i) {
                if (i > 0) {
                    addon.append(", ");
                }

                addon.append(groups[i]);
            }

            addon.append(")");
        }

        return "<b>" + method.getMethodName() + "</b> " + addon;
    }

    private void resultDetail(IResultMap tests) {
        Set<ITestResult> testResults = tests.getAllResults();
        List<ITestResult> list = new ArrayList(testResults);
//        Collections.sort(list, new com.de.reporting.listeners.CustomizedEmailableReport.TestResultsSorter(this, (1)null));
        Iterator var4 = list.iterator();

        while(var4.hasNext()) {
            ITestResult result = (ITestResult)var4.next();
            ITestNGMethod method = result.getMethod();
            ++this.methodIndex;
            String cname = method.getTestClass().getName();
            this.out.println("<h2 id=\"m" + this.methodIndex + "\">" + cname + ":" + method.getMethodName() + "</h2>");
            Set<ITestResult> resultSet = tests.getResults(method);
            this.generateForResult(result, method, resultSet.size());
            this.out.println("<p class=\"totop\"><a href=\"#summary\">back to summary</a></p>");
        }

    }

    private void generateForResult(ITestResult ans, ITestNGMethod method, int resultSetSize) {
        Object[] parameters = ans.getParameters();
        boolean hasParameters = parameters != null && parameters.length > 0;
        if (hasParameters) {
            this.tableStart("result", (String)null);
            this.out.print("<tr class=\"param\">");

            for(int x = 1; x <= parameters.length; ++x) {
                this.out.print("<th>Param." + x + "</th>");
            }

            this.out.println("</tr>");
            this.out.print("<tr class=\"param stripe\">");
            Object[] var12 = parameters;
            int var7 = parameters.length;

            for(int var8 = 0; var8 < var7; ++var8) {
                Object p = var12[var8];
                this.out.println("<td>" + Utils.escapeHtml(Utils.toString(p)) + "</td>");
            }

            this.out.println("</tr>");
        }

        List<String> msgs = Reporter.getOutput(ans);
        boolean hasReporterOutput = msgs.size() > 0;
        Throwable exception = ans.getThrowable();
        boolean hasThrowable = exception != null;
        if (hasReporterOutput || hasThrowable) {
            if (hasParameters) {
                this.out.print("<tr><td");
                if (parameters.length > 1) {
                    this.out.print(" colspan=\"" + parameters.length + "\"");
                }

                this.out.println(">");
            } else {
                this.out.println("<div>");
            }

            if (hasReporterOutput) {
                if (hasThrowable) {
                    this.out.println("<h3>Test Messages</h3>");
                }

                Iterator var10 = msgs.iterator();

                while(var10.hasNext()) {
                    String line = (String)var10.next();
                    this.out.println(line + "<br/>");
                }
            }

            if (hasThrowable) {
                boolean wantsMinimalOutput = ans.getStatus() == 1;
                if (hasReporterOutput) {
                    this.out.println("<h3>" + (wantsMinimalOutput ? "Expected Exception" : "Failure") + "</h3>");
                }

                this.generateExceptionReport(exception, method);
            }

            if (hasParameters) {
                this.out.println("</td></tr>");
            } else {
                this.out.println("</div>");
            }
        }

        if (hasParameters) {
            this.out.println("</table>");
        }

    }

    private void getParameters(IResultMap tests) {
        Iterator var2 = tests.getAllResults().iterator();

        while(true) {
            Object[] parameters;
            boolean hasParameters;
            do {
                if (!var2.hasNext()) {
                    return;
                }

                ITestResult result = (ITestResult)var2.next();
                ++this.methodIndex;
                parameters = result.getParameters();
                hasParameters = parameters != null && parameters.length > 0;
            } while(!hasParameters);

            Object[] var6 = parameters;
            int var7 = parameters.length;

            for(int var8 = 0; var8 < var7; ++var8) {
                Object p = var6[var8];
                this.out.println(Utils.escapeHtml(Utils.toString(p)) + " | ");
            }
        }
    }

    protected void generateExceptionReport(Throwable exception, ITestNGMethod method) {
        this.out.print("<div class=\"stacktrace\">");
        this.out.print(Utils.stackTrace(exception, true)[0]);
        this.out.println("</div>");
    }

    private Collection<ITestNGMethod> getMethodSet(IResultMap tests, ISuite suite) {
        List<IInvokedMethod> r = Lists.newArrayList();
        List<IInvokedMethod> invokedMethods = suite.getAllInvokedMethods();
        Iterator var5 = invokedMethods.iterator();

        while(var5.hasNext()) {
            IInvokedMethod im = (IInvokedMethod)var5.next();
            if (tests.getAllMethods().contains(im.getTestMethod())) {
                r.add(im);
            }
        }

//        Collections.sort(r, new com.de.reporting.listeners.CustomizedEmailableReport.TestSorter(this, (1)null));
        List<ITestNGMethod> result = Lists.newArrayList();
        Iterator var11 = r.iterator();

        Iterator var8;
        ITestNGMethod m;
        while(var11.hasNext()) {
            IInvokedMethod m2 = (IInvokedMethod)var11.next();
            var8 = result.iterator();

            while(var8.hasNext()) {
                m2 = (IInvokedMethod)var8.next();
                if (!m2.equals(m2.getTestMethod())) {
                    result.add(m2.getTestMethod());
                }
            }
        }

        Collection<ITestNGMethod> allMethodsCollection = tests.getAllMethods();
        List<ITestNGMethod> allMethods = new ArrayList(allMethodsCollection);
//        Collections.sort(allMethods, new CustomizedEmailableReport.TestMethodSorter(this, (1)null));
        var8 = allMethods.iterator();

        while(var8.hasNext()) {
			m = (ITestNGMethod) var8.next();
			if (!result.contains(m)) {
                result.add(m);
            }
        }

        return result;
    }

    public void generateSuiteSummaryReport(List<ISuite> suites) {
        this.tableStart("testOverview", (String)null);
        this.out.print("<tr>");
        this.tableColumnStart("Test");
        this.tableColumnStart("# passed");
        this.tableColumnStart("# skipped");
        this.tableColumnStart("# failed");
        this.tableColumnStart("Start<br/>Time");
        this.tableColumnStart("End<br/>Time");
        this.tableColumnStart("Total<br/>Time(hh:mm:ss)");
        this.tableColumnStart("Included<br/>Groups");
        this.tableColumnStart("Excluded<br/>Groups");
        this.out.println("</tr>");
        new DecimalFormat("#,##0.0");
        int qty_tests = 0;
        int qty_pass_m = 0;
        int qty_pass_s = 0;
        int qty_skip = 0;
        int qty_fail = 0;
        long time_start = 9223372036854775807L;
        long time_end = -9223372036854775808L;
        this.testIndex = 1;
        Iterator var12 = suites.iterator();

        while(var12.hasNext()) {
            ISuite suite = (ISuite)var12.next();
            if (suites.size() >= 1) {
                this.titleRow(suite.getName(), 10);
            }

            Map<String, ISuiteResult> tests = suite.getResults();

            Integer var21;
            for(Iterator var15 = tests.values().iterator(); var15.hasNext(); var21 = this.testIndex = this.testIndex + 1) {
                ISuiteResult r = (ISuiteResult)var15.next();
                ++qty_tests;
                ITestContext overview = r.getTestContext();
                this.startSummaryRow(overview.getName());
                int q = this.getMethodSet(overview.getPassedTests(), suite).size();
                qty_pass_m += q;
                this.summaryCell(q, 2147483647);
                q = this.getMethodSet(overview.getSkippedTests(), suite).size();
                qty_skip += q;
                this.summaryCell(q, 0);
                q = this.getMethodSet(overview.getFailedTests(), suite).size();
                qty_fail += q;
                this.summaryCell(q, 0);
                SimpleDateFormat summaryFormat = new SimpleDateFormat("kk:mm:ss");
                this.summaryCell(summaryFormat.format(overview.getStartDate()), true);
                this.out.println("</td>");
                this.summaryCell(summaryFormat.format(overview.getEndDate()), true);
                this.out.println("</td>");
                time_start = Math.min(overview.getStartDate().getTime(), time_start);
                time_end = Math.max(overview.getEndDate().getTime(), time_end);
                this.summaryCell(this.millisToTimeConversion((overview.getEndDate().getTime() - overview.getStartDate().getTime()) / 1000L), true);
                this.summaryCell(overview.getIncludedGroups());
                this.summaryCell(overview.getExcludedGroups());
                this.out.println("</tr>");
                Integer var20 = this.testIndex;
            }
        }

        if (qty_tests > 1) {
            this.out.println("<tr class=\"total\"><td>Total</td>");
            this.summaryCell(qty_pass_m, 2147483647);
            this.summaryCell(qty_skip, 0);
            this.summaryCell(qty_fail, 0);
            this.summaryCell(" ", true);
            this.summaryCell(" ", true);
            this.summaryCell(this.millisToTimeConversion((time_end - time_start) / 1000L), true);
            this.out.println("<td colspan=\"3\">&nbsp;</td></tr>");
        }

        this.out.println("</table>");
    }

    private void summaryCell(String[] val) {
        StringBuffer b = new StringBuffer();
        String[] var3 = val;
        int var4 = val.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String v = var3[var5];
            b.append(v + " ");
        }

        this.summaryCell(b.toString(), true);
    }

    private void summaryCell(String v, boolean isgood) {
        this.out.print("<td class=\"numi" + (isgood ? "" : "_attn") + "\">" + v + "</td>");
    }

    private void startSummaryRow(String label) {
        ++this.row;
        this.out.print("<tr" + (this.row % 2 == 0 ? " class=\"stripe\"" : "") + "><td style=\"text-align:left;padding-right:2em\"><a href=\"#t" + this.testIndex + "\"><b>" + label + "</b></a></td>");
    }

    private void summaryCell(int v, int maxexpected) {
        this.summaryCell(String.valueOf(v), v <= maxexpected);
    }

    private void tableStart(String cssclass, String id) {
        this.out.println("<table cellspacing=\"0\" cellpadding=\"0\"" + (cssclass != null ? " class=\"" + cssclass + "\"" : " style=\"padding-bottom:2em\"") + (id != null ? " id=\"" + id + "\"" : "") + ">");
        this.row = 0;
    }

    private void tableColumnStart(String label) {
        this.out.print("<th>" + label + "</th>");
    }

    private void titleRow(String label, int cq) {
        this.titleRow(label, cq, (String)null);
    }

    private void titleRow(String label, int cq, String id) {
        this.out.print("<tr");
        if (id != null) {
            this.out.print(" id=\"" + id + "\"");
        }

        this.out.println("><th colspan=\"" + cq + "\">" + label + "</th></tr>");
        this.row = 0;
    }

    protected void startHtml(PrintWriter out) {
        out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
        out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
        out.println("<head>");
        out.println("<title>TestNG Report</title>");
        out.println("<style type=\"text/css\">");
        out.println("table {margin-bottom:10px;border-collapse:collapse;empty-cells:show}");
        out.println("td,th {border:1px solid #009;padding:.25em .5em}");
        out.println(".result th {vertical-align:bottom}");
        out.println(".param th {padding-left:1em;padding-right:1em}");
        out.println(".param td {padding-left:.5em;padding-right:2em}");
        out.println(".stripe td,.stripe th {background-color: #E6EBF9}");
        out.println(".numi,.numi_attn {text-align:right}");
        out.println(".total td {font-weight:bold}");
        out.println(".passedodd td {background-color: #0A0}");
        out.println(".passedeven td {background-color: #3F3}");
        out.println(".skippedodd td {background-color: #CCC}");
        out.println(".skippedodd td {background-color: #DDD}");
        out.println(".failedodd td,.numi_attn {background-color: #F33}");
        out.println(".failedeven td,.stripe .numi_attn {background-color: #D00}");
        out.println(".stacktrace {white-space:pre;font-family:monospace}");
        out.println(".totop {font-size:85%;text-align:center;border-bottom:2px solid #000}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
    }

    protected void endHtml(PrintWriter out) {
        out.println("</body></html>");
    }
}
