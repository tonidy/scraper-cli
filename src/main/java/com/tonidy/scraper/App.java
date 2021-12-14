package com.tonidy.scraper;

import java.text.MessageFormat;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.tonidy.scraper.CLI.Settings;

/**
 * Main app
 *
 */
public class App {
    final static Settings settings = new Settings();

    public static void main(String[] args) {
        var command = new JCommander(settings);
        command.setProgramName("scrapee");

        try {
            command.parse(args);
        } catch (ParameterException exception) {
            System.out.println(exception.getMessage());
            showUsage(command);
        }
        if (settings.isHelp()) {
            showUsage(command);
        }

        try (var playwright = Playwright.create()) {
            var browserType = new BrowserType.LaunchOptions().setHeadless(false);
            var browser = playwright.chromium().launch(browserType);
            var page = browser.newPage();
            page.navigate(MessageFormat.format("https://www.tokopedia.com/p/{0}", settings.getFriendlyCategory()));
            System.out.println(page.title());
            // System.out.println(page.content());
            // System.out.println(settings);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void showUsage(JCommander command) {
        command.usage();
        System.exit(0);
    }
}
