

package com.de.reporting.listeners;

import org.testng.*;

public interface Listener extends ITestListener, ISuiteListener, IInvokedMethodListener, IRetryAnalyzer, IAnnotationTransformer, IConfigurationListener, IExecutionListener {
}
