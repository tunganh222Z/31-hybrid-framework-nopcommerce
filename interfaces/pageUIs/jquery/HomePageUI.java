package pageUIs.jquery;

public class HomePageUI {

    public static final String DYNAMIC_COLUMN_TEXTBOX_BY_NAME = "xpath=//div[text()='%s']/ancestor::div[@class='qgrd-header-wrap']/input";

    public static final String DYNAMIC_PAGINATION_BY_NUMBER = "XPATH=//a[text()='%s']/parent::li";

    public static final String DYNAMIC_PAGINATION_LINK_ACTIVE_BY_NUMBER = "XPATH=//a[@class='qgrd-pagination-page-link active' and text()='%s']";

    public static final String DYNAMIC_ROW_VALUES = "XPATH=//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";

    public static final String DYNAMIC_ROW_ACTIONS ="XPATH=//td[@data-key='country']/preceding-sibling::td/button[@class='qgrd-%s-row-btn']";

    public static final String ALL_PAGE_LINKS = "XPATH=//li[@class='qgrd-pagination-page']";

    public static final String COLUMN_INDEX_BY_NAME = "XPATH=//div[contains(text(),'%s')]/ancestor::th/preceding-sibling::th";

    public static final String ALL_VALUE_BY_COLUMN_INDEX ="XPATH=//tr/td[%s]";

    public static final String COLUMN_INDEX_BY_NAME_2 = "XPATH=//th[contains(text(),'%s')]/preceding-sibling::th";

    public static final String TEXT_BOX_BY_INDEX ="xpath=//tr/td[%s]/input[@id='tblAppendGrid_name_%s']";

    public static final String DROPDOWN_BY_INDEX ="XPATH=//tr/td[%s]//select[@id='tblAppendGrid_country_%s']";

}
