package com.tonidy.scraper;

import java.text.MessageFormat;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class Settings {
    @Parameter(names = { "-h", "--help" }, help = true, description = "Help information")
    private boolean help;
    @Parameter(names = { "-t", "--total" }, description = "Number of total products")
    private Integer totalProducts = 100;
    @Parameter(names = { "-c", "--category" }, description = "Product Category")
    private Category category = Category.HANDPHONE_TABLET;
    @Parameter(names = { "-o", "--output" }, description = "Output file format")
    private OutputFile outputFile = OutputFile.CSV;

    public boolean isHelp() {
        return help;
    }

    @Override
    public String toString() {
        return MessageFormat.format("\nhelp={0}\ntotalProducts={1}\noutputFile={2}",
                help, totalProducts, outputFile);
    }

    public Category getCategory() {
        return category;
    }

    public String getFriendlyCategory() {
        return category.toString().toLowerCase().replace("_", "-");
    }
}
