public class Topic_04_Rest_Parameter {

    String sidebarLink = "//div[@class='side-2'//a[text()='%s']";

    public void clickToElement (String locatorValue, String... pageName){
        locatorValue = sidebarLink;
        // Ép kiểu tường minh từ String -> Objec[]
        System.out.println(String.format(locatorValue, (Object[]) pageName) + "locator dynamic");
        System.out.println(locatorValue + "locator static");
    }
}
