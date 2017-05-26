package action.user;


import com.opensymphony.xwork2.ActionContext;

public class Checkvfycode {
	private String VerifyCode;//页面传来验证码
	private boolean ok = false;
	public String execute(){
		String code = (String) ActionContext.getContext().getSession().get("code");
		if(code.equalsIgnoreCase(VerifyCode)){
			ok=true;
		}
		return "success";
		
	}
	public String getVerifyCode() {
		return VerifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		VerifyCode = verifyCode;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
}
