

package com.de.reporting.reports;

import java.io.File;

public interface Report {
    void step(String var1, Object... var2);

    void info(String var1, Object... var2);

    void warn(String var1, Object... var2);

    void error(String var1, Object... var2);

    void attachHtml(File var1);

    void attachImage(File var1, String var2);
}
