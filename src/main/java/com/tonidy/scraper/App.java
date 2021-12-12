package com.tonidy.scraper;

import java.text.MessageFormat;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

/**
 * Main app
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try(var playwright = Playwright.create()) 
        {
            var browserType = new BrowserType.LaunchOptions().setHeadless(false);
            var browser = playwright.webkit().launch(browserType);
            var page = browser.newPage();
            var category = "handphone-tablet";
            page.navigate(MessageFormat.format("https://www.tokopedia.com/p/{0}", category));
            System.out.println(page.title());
            //System.out.println(page.content());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
