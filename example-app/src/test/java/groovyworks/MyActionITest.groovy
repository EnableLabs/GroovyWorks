package groovyworks;

class MyActionITest extends GroovyTestCase {

	void testExecute () {
		def action = new MyAction ();
		SpringContextTestFactory.autowireBeanProperties (action);
		action.execute ();
	}

	void testGetMessage () {
		def action = new MyAction ();
		SpringContextTestFactory.autowireBeanProperties (action);
		action.execute ();
		assertTrue ("Message is null.", action.getMessage () != null);
	}

	void testMessage () {
		def action = new MyAction ();
		SpringContextTestFactory.autowireBeanProperties (action);
		assertTrue ("Message should be null but wasn't.", action.message == null);
		action.execute ();
		assertTrue ("Message is wrong.", action.message == "Welcome to Groovy Works!");
	}

	void testServiceBeanIsInjected () {
		def action = new MyAction ();
		SpringContextTestFactory.autowireBeanProperties (action);
		assertTrue ("MyService bean was not injected.", action.myService != null);
	}
}
