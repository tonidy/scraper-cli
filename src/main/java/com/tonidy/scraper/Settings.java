package com.tonidy.scraper;

import java.io.File;
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
    @Parameter(names = { "-f", "--fileType" }, description = "Output file type format")
    private FileType fileType = FileType.CSV;
    @Parameter(names = { "-o", "--output" }, description = "Output file name")
    private String outputFile = "output.csv";

    public boolean isHelp() {
        return help;
    }

    @Override
    public String toString() {
        return MessageFormat.format("""
        help={0}
        totalProducts={1}
        fileType={2}
        output={3}
        """,
        help, totalProducts, fileType, outputFile);
    }

    public Category getCategory() {
        return category;
    }

    public Integer getTotal() {
        return totalProducts;
    }

    public FileType getFileType() {
        return fileType;
    }

    public String getFriendlyCategory() {
        return category.toString().toLowerCase().replace("_", "-");
    }
}
