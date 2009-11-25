package groovyworks;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

class SpringContextTestFactory {

	private static final context;

	public static ApplicationContext getContext () {
		if (context == null) {
			context = new ClassPathXmlApplicationContext ("classpath*:applicationContext.xml");
		}
		return context;
	}

	public static void autowireBeanProperties (Object bean) {
		getContext().getAutowireCapableBeanFactory().autowireBeanProperties (bean, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);
	}
}
