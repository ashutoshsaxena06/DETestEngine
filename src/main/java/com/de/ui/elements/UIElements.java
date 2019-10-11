

package com.de.ui.elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.de.core.DriverManager;

public class UIElements {
    public UIElements() {
    }

    public static List<UIElement> getMultiple(By by, String pageName, String elementName) {
        int index = 0;
        List<UIElement> list = new ArrayList();
        WebDriver driver = DriverManager.getDriver();
        List<WebElement> elements = driver.findElements(by);
        Iterator var7 = elements.iterator();

        while (var7.hasNext()) {
            WebElement ele = (WebElement) var7.next();
//            list.add(new 1 (ele, pageName, elementName + "[" + index + "]"))
        }

        return list;
    }

    public static List<TextBox> getTextBoxes(By by, String pageName, String elementName) {
        int index = 0;
        List<TextBox> list = new ArrayList();
        WebDriver driver = DriverManager.getDriver();
        List<WebElement> elements = driver.findElements(by);
        Iterator var7 = elements.iterator();

        while (var7.hasNext()) {
            WebElement ele = (WebElement) var7.next();
//            list.add(new 1 (ele, pageName, elementName + "[" + index + "]"))
        }

        return list;
    }
    public static List<Button> getButtons(By by, String pageName, String elementName) {
        int index = 0;
        List<Button> list = new ArrayList();
        WebDriver driver = DriverManager.getDriver();
        List<WebElement> elements = driver.findElements(by);
        Iterator var7 = elements.iterator();

        while (var7.hasNext()) {
            WebElement ele = (WebElement) var7.next();
            list.add(new Button(ele, pageName, elementName + "[" + index + "]"));
        }

        return list;
    }

    public static List<CheckBox> getCheckBoxes(By by, String pageName, String elementName) {
        int index = 0;
        List<CheckBox> list = new ArrayList();
        WebDriver driver = DriverManager.getDriver();
        List<WebElement> elements = driver.findElements(by);
        Iterator var7 = elements.iterator();

        while (var7.hasNext()) {
            WebElement ele = (WebElement) var7.next();
            list.add(new CheckBox(ele, pageName, elementName + "[" + index + "]"));
        }

        return list;
    }

    public static List<RadioButton> getRadioButton(By by, String pageName, String elementName) {
        int index = 0;
        List<RadioButton> list = new ArrayList();
        WebDriver driver = DriverManager.getDriver();
        List<WebElement> elements = driver.findElements(by);
        Iterator var7 = elements.iterator();

        while (var7.hasNext()) {
            WebElement ele = (WebElement) var7.next();
            list.add(new RadioButton(ele, pageName, elementName + "[" + index + "]"));
        }

        return list;
    }
}
