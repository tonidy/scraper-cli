package com.tonidy.scraper.CLI;

import java.text.MessageFormat;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.tonidy.scraper.CLI.Converter.CategoryConverter;
import com.tonidy.scraper.CLI.Converter.FileTypeConverter;

@Parameters(separators = "=")
public class Settings {
    @Parameter(names = { "-h", "--help" }, help = true, description = "Help information")
    private boolean help;
    @Parameter(names = { "-t", "--total" }, description = "Number of total products")
    private Integer totalProducts = 100;
    @Parameter(names = { "-c", "--category" }, description = "Product Category", converter = CategoryConverter.class)
    private Category category = Category.HANDPHONE_TABLET;
    @Parameter(names = { "-f", "--fileType" }, description = "Output file type format", converter = FileTypeConverter.class)
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
