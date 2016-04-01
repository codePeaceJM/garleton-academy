package interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import common.Common.Role;

public class AccessController implements Interceptor {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init() {
		// TODO Auto-generated method stub

	}

	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map session = invocation.getInvocationContext().getSession();
		String actionName=invocation.getProxy().getActionName();
		String method = invocation.getProxy().getMethod();
		Role role =(Role) session.get("role");
		if("log".equals(method)||"reg".equals(method)){
			invocation.invoke();
		} else if("userAction".equals(actionName)&&"SA".equals(role.toString())) {
			invocation.invoke();
		}
		return "authorityDeny";
	}

}
