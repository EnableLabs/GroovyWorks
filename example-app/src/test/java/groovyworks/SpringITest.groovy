package groovyworks;

class SpringITest extends GroovyTestCase {

	void testSpringStartUp () {
		SpringContextTestFactory.getContext ();
	}
}
