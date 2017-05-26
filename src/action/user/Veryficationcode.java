package action.user;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;


import com.opensymphony.xwork2.ActionContext;

import util.ImageUtil;

public class Veryficationcode {
	private InputStream input;
	public String execute() throws Exception{
		Map<String, BufferedImage> map = 
			 ImageUtil.createImage();
		String code = map.keySet().iterator().next();
		ActionContext.getContext().getSession().put("code", code);
		BufferedImage image = map.get(code);
		input = ImageUtil.getInputStream(image);
		input.close();
		return "success";
	}
	
	public InputStream getInput() {
		return input;
	}
	public void setInput(InputStream input) {
		this.input = input;
	}
}
