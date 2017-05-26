package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import entity.User;

@SuppressWarnings("serial")
public class Userinterceptor implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		User user = (User) invocation.getInvocationContext().getSession().get("user");
		if(user == null){
			return "fail";
		}
		return invocation.invoke();
	}


	

}
