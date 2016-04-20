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
		String actionName = invocation.getProxy().getActionName();
		String method = invocation.getProxy().getMethod();
		Role role = (Role) session.get("role");
		if ("log".equals(method) || "reg".equals(method)) {
			invocation.invoke();
		} else if (("userAction".equals(actionName)
				|| "institutionAction".equals(actionName)
				|| "districtAction".equals(actionName) || "logAction"
				.equals(actionName))
				&& "SA".equals(role.toString())) {
			invocation.invoke();
		} else if (("newsAction".equals(actionName) || "columnAction"
				.equals(actionName))
				&& ("SA".equals(role.toString())
						|| "WE".equals(role.toString()) || method
						.startsWith("search"))) {
			invocation.invoke();
		} else if (("knowledgeAction".equals(actionName)
				|| "statuteAction".equals(actionName) || "casesAction"
				.equals(actionName)|| "resourceAction".equals(actionName))
				&& ("SA".equals(role.toString())
						|| "RM".equals(role.toString()) || method
						.startsWith("search"))) {
			invocation.invoke();
		} else if ("commentAction".equals(actionName)
				&& ((role != null && (!"del".equals(method))) || ("del"
						.equals(method) && ("WE".equals(role.toString()) || "SA"
						.equals(role.toString()))))) {
			invocation.invoke();
		} else if (("courseAction".equals(actionName) || "questionAction"
				.equals(actionName))
				&& ("SA".equals(role.toString())
						|| "CM".equals(role.toString()) || method
						.startsWith("search"))) {
			invocation.invoke();
		} else if ("expertAction".equals(actionName)
				&& ("SA".equals(role.toString()) || method.startsWith("search"))) {
			invocation.invoke();
		} else if ("paperAction".equals(actionName)
				&& ("SA".equals(role.toString()) || "CM"
						.equals(role.toString()))) {
			invocation.invoke();
		}
		return "authorityDeny";
	}

}
