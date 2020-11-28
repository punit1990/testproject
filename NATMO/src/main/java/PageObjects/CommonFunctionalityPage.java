package PageObjects;

public class CommonFunctionalityPage {
	
	public static String policies = "//a[contains(text(),'Website Policies')]";
	public static String help = "//li[@class='menu-2999']//a[contains(text(),'Help')]";
	public static String contactUs = "//a[contains(text(),'Contact Us')]";
	public static String terms = "//a[contains(text(),'Terms & Conditions')]";
	public static String faq = "//a[contains(text(),'FAQ')]";
	
	public static String skipToMainContent="//a[text()=\"Skip to main content\" and @id='skipcontent']";
	//public static String skipToMainContent="//a[@id='skipcontent']";
	public static String skipToNavigation="//a[text()=\"Skip to Navigation\"]";
	
	public static String visit ="//li[contains(text(),'Visitor Count:')]";
	public static String visitNumber="//li[text()='Visitor Count:']//strong";
	
	public static String playImgSlide = "//i[@class='fa fa-play-circle']";
	public static String playImgSlide1="//div[@class='bx-controls-auto']";
	public static String pauseImgSlide = "//i[@class='fa fa-pause-circle']";
	
	public static String increaseFontSize= "//a[@title='Increase font size']";
	public static String resetFontSize= "//a[@title='Reset font size']";
	public static String decreaseFontSize= "//a[@title='Decrease font size']";
	
	public static String langHindi ="//a[@class=\"language-link\"]";
	public static String langHindiActive ="//a[@class=\"language-link active\"]";
	public static String langEng ="//a[@class=\"language-link\"]";
	public static String langEngActive ="//a[@class=\"language-link active\"]";
	
	public static String colorgreen ="//header//a[2]//img[1]";
	public static String coloryellow ="//header//div[@class='row']//a[3]//img[1]";
	public static String colorred ="//header//a[4]//img[1]";
	public static String colorwhite ="//li[@class='list-inline-item']//a[1]//img[1]";
	
	public static String screenReader ="//a[text()=\"Screen Reader Access\"]";
	
	//a

}
