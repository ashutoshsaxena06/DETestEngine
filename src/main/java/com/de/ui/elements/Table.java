package com.de.ui.elements;

import com.de.reporting.Assertion;
import com.de.reporting.Utility;
import org.fest.assertions.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Table extends UIElement {
    /**
     * @deprecated
     */
    @Deprecated
    public Table(By by, String pageName) {
        super(by, pageName);
    }

    public Table(By by, String pageName, String elementName) {
        super(by, pageName, elementName);
    }

    @Utility
    public int getRowCount() {
        return this.getRows().size();
    }

    @Utility
    public int getColumnCount() {
        return this.getWrappedElement().findElements(By.cssSelector("th")).size();
    }

    @Utility
    public WebElement getCellAtIndex(int rowIdx, int colIdx) {
        WebElement row = this.getRows().get(rowIdx);
        List cells;
        if ((cells = row.findElements(By.tagName("td"))).size() > 0) {
            return (WebElement) cells.get(colIdx - 1);
        } else if ((cells = row.findElements(By.tagName("th"))).size() > 0) {
            return (WebElement) cells.get(colIdx - 1);
        } else {
            String error = String.format("Could not find cell at row: %s column: %s", rowIdx, colIdx);
            throw new RuntimeException(error);
        }
    }

    @Utility
    public String getRowValue(String rowName) {
        return null;
    }

    @Utility
    public String getCellTextAtIndex(int rowIdx, int colIdx) {
        return this.getCellAtIndex(rowIdx, colIdx).getText();
    }

    @Utility
    private List<WebElement> getRows() {
        List<WebElement> rows = new ArrayList();
        List<WebElement> headerRows = this.getWrappedElement().findElements(By.cssSelector("thead tr"));
        if (headerRows.size() > 0) {
            rows.add(headerRows.get(0));
        } else {
            rows.add(null);
        }

        List<WebElement> bodyRows = this.getWrappedElement().findElements(By.cssSelector("tbody tr"));
        if (bodyRows.size() > 0) {
            rows.addAll(bodyRows);
        }

        return rows;
    }

    @Utility
    public List<WebElement> getCells(WebElement row) {
        List cells;
        if ((cells = row.findElements(By.tagName("td"))).size() > 0) {
            return cells;
        } else if ((cells = row.findElements(By.tagName("th"))).size() > 0) {
            return cells;
        } else {
            String error = String.format("Could not find any cell.");
            throw new RuntimeException(error);
        }
    }

    @Utility
    public List<String> getRowValue(int row) {
        List<WebElement> cellsElements = this.getCells(this.getRows().get(row));
        List<String> value = new ArrayList();
        Iterator var4 = cellsElements.iterator();

        while (var4.hasNext()) {
            WebElement ele = (WebElement) var4.next();
            value.add(ele.getText());
        }

        return value;
    }

    @Utility
    public int getColIdx(String colHeader) {
        try {
            int idx;
            for (idx = 1; !this.getCellTextAtIndex(0, idx).equalsIgnoreCase(colHeader); ++idx) {
            }

            return idx;
        } catch (ArrayIndexOutOfBoundsException var3) {
            throw new RuntimeException("Column header not found");
        }
    }

    @Assertion
    public void assertCellText(int rowIdx, int colIdx, String text) {
        this.report.info("Assert [" + this.getElementName() + "] cell[" + rowIdx + "][" + colIdx + "] text equals [" + text + "on [" + this.getPageName() + "]");
        Assertions.assertThat(this.getCellAtIndex(rowIdx, colIdx).getText().trim()).isEqualToIgnoringCase(text);
    }

    @Assertion
    public void assertCellText(int rowIdx, String colHeader, String text) {
        this.report.info("Assert [" + this.getElementName() + "] cell[" + rowIdx + "][" + colHeader + "] text equals [" + text + "on [" + this.getPageName() + "]");
        Assertions.assertThat(this.getCellAtIndex(rowIdx, this.getColIdx(colHeader)).getText().trim()).isEqualToIgnoringCase(text);
    }

    @Assertion
    public void assertCellContainsText(int rowIdx, int colIdx, String text) {
        this.report.info("Assert [" + this.getElementName() + "] cell[" + rowIdx + "][" + colIdx + "] contains text [" + text + "on [" + this.getPageName() + "]");
        Assertions.assertThat(this.getCellAtIndex(rowIdx, colIdx).getText().trim()).containsIgnoringCase(text);
    }

    @Assertion
    public void assertCellContainsText(int rowIdx, String colHeader, String text) {
        this.report.info("Assert [" + this.getElementName() + "] cell[" + rowIdx + "][" + colHeader + "] contains text [" + text + "on [" + this.getPageName() + "]");
        Assertions.assertThat(this.getCellAtIndex(rowIdx, this.getColIdx(colHeader)).getText().trim()).containsIgnoringCase(text);
    }

    @Assertion
    public void assertCellDoesNotContainText(int rowIdx, int colIdx, String text) {
        this.report.info("Assert [" + this.getElementName() + "] cell[" + rowIdx + "][" + colIdx + "] doesn't contain text [" + text + "on [" + this.getPageName() + "]");
        Assertions.assertThat(this.getCellAtIndex(rowIdx, colIdx).getText().trim()).doesNotContain(text);
    }

    @Assertion
    public void assertCellDoesNotContainText(int rowIdx, String colHeader, String text) {
        this.report.info("Assert [" + this.getElementName() + "] cell[" + rowIdx + "][" + colHeader + "] doesn't contain text [" + text + "on [" + this.getPageName() + "]");
        Assertions.assertThat(this.getCellAtIndex(rowIdx, this.getColIdx(colHeader)).getText().trim()).doesNotContain(text);
    }

    @Utility
    private boolean isSortIconDisplayed(int colIdx) {
        try {
            return this.getCellAtIndex(0, colIdx).findElement(By.xpath(".//span[contains(@class, 'DataTables_sort_icon')]")).isDisplayed();
        } catch (NoSuchElementException var3) {
            return false;
        }
    }

    @Assertion
    public void assertColumnSortable(int colIdx) {
        this.report.info("Assert column " + colIdx + " is sortable on [" + this.getPageName());
        Assertions.assertThat(this.isSortIconDisplayed(colIdx)).isTrue();
    }

    @Assertion
    public void assertColumnSortable(String colHeader) {
        this.report.info("Assert column " + colHeader + " is sortable on [" + this.getPageName());
        Assertions.assertThat(this.isSortIconDisplayed(this.getColIdx(colHeader))).isTrue();
    }

    @Assertion
    public void assertColumnNotSortable(int colIdx) {
        this.report.info("Assert column " + colIdx + " is not sortable on [" + this.getPageName());
        Assertions.assertThat(this.isSortIconDisplayed(colIdx)).isFalse();
    }

    @Assertion
    public void assertColumnNotSortable(String colHeader) {
        this.report.info("Assert column " + colHeader + " is sortable on [" + this.getPageName());
        Assertions.assertThat(this.isSortIconDisplayed(this.getColIdx(colHeader))).isFalse();
    }
}
