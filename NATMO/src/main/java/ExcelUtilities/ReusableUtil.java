package ExcelUtilities;

public class ReusableUtil {
	

	//This method is used to adsd captcha value
	
	public static String captchaCode(String captchatxt) {
		
		String [] value = captchatxt.split(" ");
		int first = Integer.valueOf(value[0]);
		int second = Integer.valueOf(value[2]);
		int sum = first + second;
		String captchatotal =String.valueOf(sum);
		return captchatotal;
		
	}
		   
}
