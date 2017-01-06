package org.concordion.selenium;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.concordion.ext.ScreenshotTaker;
import org.concordion.ext.ScreenshotUnavailableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Takes screenshots of the system under test.
 */
public class SeleniumScreenshotTaker implements ScreenshotTaker {
    private final WebDriver driver;

    SeleniumScreenshotTaker(Browser browser) {
        this.driver = browser.getDriver();
    }

    public Dimension writeScreenshotTo(OutputStream outputStream) throws IOException {
        byte[] screenshot;

        try {
            screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (ClassCastException e) {
            throw new ScreenshotUnavailableException("driver does not implement TakesScreenshot");
        }

        outputStream.write(screenshot);

        return getImageDimension(screenshot);
    }

    private Dimension getImageDimension(byte[] screenshot) throws IOException {
        InputStream in = new ByteArrayInputStream(screenshot);
        BufferedImage buf = ImageIO.read(in);

        return new Dimension(buf.getWidth(), buf.getHeight());
    }

    public String getFileExtension() {
        return "png";
    }
}