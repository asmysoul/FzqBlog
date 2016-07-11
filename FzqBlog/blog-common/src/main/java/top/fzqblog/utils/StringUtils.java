package top.fzqblog.utils;

/**
 * 
 * @author CL
 *
 */
public class StringUtils {
	//判断字符串是否为空
	public static boolean isEmpty(String str){
		if(str==null || "".equals(str)){
			return true;
		}
		else if ("".equals(str.trim())) {
			return true;
		}
		return false;
	}
	
	//判断是否是数字
	public static boolean isNumber(String str){
		String checkNumber = "^[0-9]+$";
		if(str == null){
			return false;
		}
		if(!str.matches(checkNumber)){
			return false;
		}
		return true;
	}
	
	//判断是否为邮箱
	public static boolean isEmail(String str){
		String checkEmail = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$";
		if(!isEmpty(str)){
			return str.matches(checkEmail);
		}
		else {
			return false;
		}
	}
	
	//判断是否是用户名
	public static boolean isUserName(String str){
		String checkUserName = "^[\\w\\u4e00-\\u9fa5]+$";
		if(!isEmpty(str)){
			return str.matches(checkUserName);
		}
		else {
			return false;
		}
	}
	
	//判断是否是密码
	public static boolean isPassword(String str){
		String checkPassword = "^[0-9a-zA-Z]+$";
		if(!isEmpty(str)){
			return str.matches(checkPassword);
		}
		else {
			return false;
		}
	}
}
