package PageObjects;

public class GeoPortalPage {
	
	public static String mapAtlasService ="//a[text()=\"Map/Atlas Services\"]";
	public static String mapDropDown = "//li[@class=\"first leaf menu-link-all\"]/a[@title=\"All\"]";
	public static String search ="//input[@id='edit-query']";
	public static String apply= "//input[@id='edit-submit-dkan-datasets']";
	public static String Geoportal= "//a[text()=' Geoportal (1)']";
	public static String closeLegend ="//div[@class='x-tool x-tool-close']";
	public static String identifyLink ="//a[text()=' Identify']";
	public static String map ="//*[@id='OpenLayers_Layer_Vector_88_svgRoot']";
	public static String fetureInfo = "//div[@class=' gx-popup x-window x-resizable-pinned']";
	public static String btnClose="//div[@class='gx-popup x-window-header x-unselectable x-window-draggable']//div[@class='x-tool x-tool-close']";
	public static String featureResult = "(//div[@class='x-tab-panel-bwrap']//div[@class='xtb-text'])[1]";
	public static String clear = "(//button[@class=' x-btn-text icon-table-clear'])[1]";
	
	public static String zoomToExtent ="//a[@title='Zoom to full extent of map']";
	
	public static String MoistureRegion ="//span[text()='MOISTURE_REGION']";
	public static String swipe ="//a[@title='Swipe Feature']";
	public static String swipeByLayer ="//a[@title='Activate this tool to Swipe by Layer']";
	public static String swipeStart="(//div[@class='x-tool x-tool-close'])[3]";
}//a
