package groovyworks;

import com.opensymphony.xwork2.ActionSupport;

class MyAction extends ActionSupport {

	MyService myService;

	String message

	String execute () throws Exception {
		message = myService.getMessage ();
		return SUCCESS;
	}
}
