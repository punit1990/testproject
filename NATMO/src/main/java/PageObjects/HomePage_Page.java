package PageObjects;

public class HomePage_Page {
	
	public static String logo = "//div[@class='col-md-7']//img[@class='img-responsive']";
	public static String logoFullName = "//header//h2[1]//strong";
	public static String aboutUs ="//a[text()='About Us']";
	public static String home ="//a[text()='Home']";
	public static String ebookServices="//a[text()='Ebook Services']";
	public static String mapService ="//a[text()='Map/Atlas Services']";
	public static String themes ="//a[text()='Themes']";
	
	
	public static String atlasMapSearchBox="//input[@placeholder='Atlas / Map Service']";
	public static String searchBtn = "//button[@id='search_filter']";
	public static String verifySearchedTxt = "//h4[@class='dataset-title']";
	public static String sliderNext = "//a[@class='bx-next']";
	public static String sliderPrev = "//a[@class='bx-prev']";
	
	public static String mouseHover= "//a[@class='nolink'][contains(text(),'Map')]";
	public static String mouseHoverDropdown = "(//ul[@class='list-inline'])[3]";
	public static String selectDropDownValue = "//a[text()=\"National School Atlas\"]";
	public static String checkbox_NSA = "//a[@id='facetapi-link--67']";
	
	public static String contactUs = "//a[contains(text(),'Contact Us')]";
	public static String help = "//li[@class='menu-2999']//a[contains(text(),'Help')]";
	public static String terms = "//a[contains(text(),'Terms & Conditions')]";
	public static String policies = "//a[contains(text(),'Website Policies')]";
	public static String faq = "//a[contains(text(),'FAQ')]";
	
	public static String screenReader ="//a[text()=\"Screen Reader Access\"]";
	public static String skipToMainContent="//a[text()=\"Skip to main content\" and @id='skipcontent']";
	public static String skipToNavigation="//a[text()=\"Skip to Navigation\"]";
	public static String langHindi ="//a[@class=\"language-link\"]";
	public static String langHindiActive ="//a[@class=\"language-link active\"]";
	public static String langEng ="//a[@class=\"language-link\"]";
	public static String langEngActive ="//a[@class=\"language-link active\"]";
	public static String signIn ="//a[text()=\" Sign  In\"]";
	public static String register ="//a[text()=\" Register\"]";
	
	public static String colorgreen ="//header//a[2]//img[1]";
	public static String coloryellow ="//header//div[@class='row']//a[3]//img[1]";
	public static String colorred ="//header//a[4]//img[1]";
	public static String colorwhite ="//li[@class='list-inline-item']//a[1]//img[1]";
	
	public static String copyRights="//li[@class='col-sm-5 text-left']";
	public static String bestView = "//li[@class='col-sm-7 text-right']";
	public static String visit ="//li[contains(text(),'Visitor Count:')]";
	public static String visitNumber="//li[text()='Visitor Count:']//strong";
	
	//a
}
