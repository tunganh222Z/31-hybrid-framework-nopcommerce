package pageObjects.saucelab;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import saucelab.ProductPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductPageObject extends BasePage {
    WebDriver driver;
    public ProductPageObject (WebDriver driver){
        this.driver = driver;
    }

    public void selectItemInSortDropdown(String sortItem) {
        waitForElementClickable(driver, ProductPageUI.SORT_DROPDOWN);
        selectItemInDefaultDropdown(driver, ProductPageUI.SORT_DROPDOWN, sortItem);
    }

    public boolean isProductSortByAscending() {

            List<WebElement> allProductNameText = getListWebElements(driver, ProductPageUI.PRODUCT_NAME_TEXT);

            List<String> actualProductName = new ArrayList<String>();

            List<String> expectedProductName = new ArrayList<String>();

            for (WebElement productNameText : allProductNameText){

                // Lấy hết product name lưu lại
               actualProductName.add(productNameText.getText());

                // clone data từ bước 1 ra thành 1 dữ liệu mới
               expectedProductName.add(productNameText.getText());
            }

        // sort dữ liệu bước 2
        Collections.sort(expectedProductName);

        // verify dữ liệu trước và sau khi sort
        return actualProductName.equals(expectedProductName);
    }

    public boolean isProductSortByDescending() {

        List<WebElement> allProductNameText = getListWebElements(driver, ProductPageUI.PRODUCT_NAME_TEXT);

        List<String> actualProductName = new ArrayList<String>();

        List<String> expectedProductName = new ArrayList<String>();

        for (WebElement productNameText : allProductNameText){

            // Lấy hết product name lưu lại
            actualProductName.add(productNameText.getText());

            // clone data từ bước 1 ra thành 1 dữ liệu mới
            expectedProductName.add(productNameText.getText());
        }

        // sort dữ liệu bước 2
        Collections.sort(expectedProductName);
        Collections.reverse(expectedProductName);

        // verify dữ liệu trước và sau khi sort
        return actualProductName.equals(expectedProductName);
    }
}
