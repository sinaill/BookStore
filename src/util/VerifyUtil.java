package util;

import java.util.Random;

public class VerifyUtil {
	
	public static String Createcode(){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<6;i++){
			int k = new Random().nextInt(10);
			sb.append(String.valueOf(k));
		}
		return sb.toString();
	}
	public static String Emailcontent(){
		return "欢迎注册当当网,您的验证码为:";
	}
	
	public static String FPWcontent(){
		return "正在申请修改密码，验证码为:";
	}
}
