package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestSuite extends BaseTest {

    String baseUrl = " https://www.amazon.co.uk/";

    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void amazonTest() {


        // Dell laptop
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Dell Laptop");
        searchBox.submit();


        // Click on the checkbox brand Dell
        WebElement dellCheckbox = driver.findElement(By.xpath("//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']"));
        dellCheckbox.click();

        // Verify number of products
        List<WebElement> products = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
        Assert.assertTrue(products.size() >= 30);

        // 5. Print all product names in the console
        for (WebElement product : products) {
            String productName = product.findElement(By.cssSelector("h2 span")).getText();
            System.out.println(productName);
        }

        // Click on the product name
        WebElement productLink = driver.findElement(By.xpath("//div[@class='rush-component s-featured-result-item s-expand-height']//span[@class='a-size-base-plus a-color-base a-text-normal'][contains(text(),'XPS 15 9530 15.6\" OLED 3.5K 400-Nit Touchscreen La')]"));
        productLink.click();

        // Verify the product name
        WebElement productTitle = driver.findElement(By.id("productTitle"));
        String actualProductName = productTitle.getText();
        String expectedProductName = "Dell XPS 15 9530 15.6\" OLED 3.5K 400-Nit Touchscreen Laptop...";
        assert actualProductName.equals(expectedProductName) : "Product name verification failed";
    }

    // Close the browser after the test
    @After
    public void tearDown() {

        driver.close();
    }
}










       