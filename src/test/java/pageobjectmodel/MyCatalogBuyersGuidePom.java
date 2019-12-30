package pageobjectmodel;

import java.io.File;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utility.Baseclass;

public class MyCatalogBuyersGuidePom extends Baseclass {

	public MyCatalogBuyersGuidePom() {
		// this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	// <My Catalogs> menu link
	@FindBy(xpath = "//a[@id=\"ucMenu_rptLevel1_lnkLink1_4\"]")
	@CacheLookup
	public WebElement MyCatalogs;

	// <Buyers Guide> submenu link
	@FindBy(xpath = "//a[@id=\"ucMenu_rptLevel1_rptLevel2_4_lnkLink2_1\"]")
	public WebElement BuyersGuide;
	
	// <Buyers Guide> Application link
	@FindBy(xpath = "//i[@class=\"fas fa-clock theme_txt_clr sec_lv_menu\"]")
	public WebElement ApplicationsLink;	
	
	// <PartNumber> fetched from application details
	@FindBy(xpath = "//span[@id=\"lblLastPartAdded\"]")
	public WebElement FetchPartNumber;
	
	// <PartNumber> search box
	@FindBy(xpath = "//input[@id=\"MainContent_txtMelling\"]")
	public WebElement PartNumberSearchBox;
	
	// <Complete Part Number>
	@FindBy(xpath = "//li[@class=\"autocomplete_listItem\"]")
	public WebElement CompletePartNumber;
	
	// <Search> button
	@FindBy(xpath = "//input[@name=\"ctl00$MainContent$btnSearch\"]")
	public WebElement SearchButton;
	
	// <Header Text>
	@FindBy(xpath = "//span[@class=\"quick_part_descriptionQuickEdit\"]")
	public WebElement HeaderText;		
	
	
	// <Part Number> AS <DPO930019A> search box
	@FindBy(xpath = "//input[@id=\"MainContent_txtMelling\"]")
	public WebElement PartNumber;
	
	// <View Application Data> button
	@FindBy(xpath = "//a[@id=\"MainContent_GVData_hylAppln_0\"]")
	public WebElement ViewApplicationDataButton;
	
	// Highlighted Record
	@FindBy(xpath = "//span[@id=\"MainContent_GVData_lblEngineBase_0\"]")
	public WebElement HighlightedRecord;
	
	// <Back> button
	@FindBy(xpath = "//button[@id=\"MainContent_btnBack\"]")
	public WebElement BackButton;
	
	// <View Part Data> button
	@FindBy(xpath = "//a[@id=\"MainContent_GVData_hylPartno_0\"]")
	public WebElement ViewPartDataButton;
	
	// Verify part details (Attributes)
	@FindBy(xpath = "(//div[@class=\"panel-title\"])[2]")
	public WebElement Attributes;
	
	// Verify part details (Interchanges)
	@FindBy(xpath = "(//div[@class=\"panel-title\"])[6]")
	public WebElement Interchanges;
	
	// Generate Excel Button
	@FindBy(xpath = "//input[@value=\"Generate Excel\"]")
	public WebElement GenerateExcel;
	
	// Excel Download Button
	@FindBy(xpath = "//input[@id=\"MainContent_btngenerate\"]")
	public WebElement ExcelDownloadButton;
	
	// Excel Download Cancel Button
	@FindBy(xpath = "//input[@id=\"MainContent_imgbtnCancel\"]")
	public WebElement ExcelDownloadCancelButton;
	
	// List Item
	// @FindBy(xpath = "//li[@class=\"autocomplete_listItem\"]")
	@FindBy(xpath = "(//li[@class=\"autocomplete_listItem\"])[1]")	
	public WebElement ListItem;	
	
	// Select Excel Generation
	@FindBy(name = "ctl00$MainContent$drpProdcategory")
	public WebElement SelectExcelGen;
	
	
	// Logout Button
	@FindBy(xpath = "//a[@id=\"hylLogout\"]")
	public WebElement LogoutButton;	
	
	
	/* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
	/* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */

		
	public void MyCatalogsClick() throws Exception {
		MyCatalogs.click();
		Thread.sleep(5000);
	}
	
	public void BuyersGuideClick() throws Exception {
		BuyersGuide.click();
		Thread.sleep(5000);
	}
	
	public void ApplicationsLinkClick() throws Exception {
		ApplicationsLink.click();
		Thread.sleep(5000);
	}
	
	public void EnterPartNumber() throws Exception {
		PartNumber.sendKeys(pro.getProperty("ParttNumberr"));
		Thread.sleep(5000);
		ListItem.click();
		Thread.sleep(5000);
	}
	
	String PartNumberFetched = "";
	String PartNumberFetched2 = "";
	public void FetchPartNumber() throws Exception {
		PartNumberFetched = FetchPartNumber.getText();
		
	}
	
	
	public void TrimEnterPartNumber() throws Exception {
		PartNumberFetched2 = PartNumberFetched.substring(0, 2);
		PartNumberSearchBox.sendKeys(PartNumberFetched2);
		Thread.sleep(5000);
		CompletePartNumber.click();
	}

	
	public void ClickSearchButton(){		
		SearchButton.click();		
	}
	
	public void ClickViewApplicationDataButton() {
		ViewApplicationDataButton.click();
	}
	
	public void VerifyHighlightedRecord() {
		try {
		String highlightText = HighlightedRecord.getText();
		System.out.println("PASS :: The engine base details is >>>>>>> " + highlightText );
		} catch (Exception e) {
			System.out.println("FAIL :: No records are found >>>>>>> ");
		}
		
	}
	
	public void ClickBackButton() {
		BackButton.click();		
	}
	
	public void ClickViewPartDataButton() {
		ViewPartDataButton.click();
	}
	
	public void DisplayHeaderDetails() {
		try {
		String HeaderTextDetail = HeaderText.getText();
		System.out.println("PASS :: The header text is >>>>>>>>>>>>>>>>> " + HeaderTextDetail);
		} catch(Exception e) {
			System.out.println("FAIL :: There is no header text is >>>>>>>>>>>>>>>>>");
		}
	}
	
	public void ClickBackNavigationButton() throws Exception {
		driver.navigate().back();
		Thread.sleep(5000);
	}
	
	public void ClickLogoutButton() {
		LogoutButton.click();
	}
	
	public void GenerateExcelReport() throws Exception {
		GenerateExcel.click();
		Thread.sleep(5000);
		
		/* To be commented for ZIACHEN */
		Select GenExcel = new Select(SelectExcelGen);
		GenExcel.selectByValue(pro.getProperty("GenExcelValue"));
		/* To be commented for ZIACHEN */
		
		ExcelDownloadButton.click();
		
		Thread.sleep(10000);
		ExcelDownloadCancelButton.click();
		Thread.sleep(10000);		
	}	
}