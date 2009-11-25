/*
 * This file derives from the Apache Struts 2 Project.
 *
 * See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  This file is licensed
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package net.vitarara.groovyworks;

import java.util.Collections;
import java.util.HashMap;
import java.io.InputStream;
import java.util.Map;
import javax.servlet.ServletContext;

import groovy.lang.GroovyClassLoader;
import org.codehaus.groovy.control.CompilerConfiguration;

import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.spring.SpringObjectFactory;
import com.opensymphony.xwork2.util.ClassLoaderUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsConstants;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.ConfigurableWebApplicationContext;

public class GroovyStrutsSpringObjectFactory extends SpringObjectFactory {

	private static final Log log = LogFactory.getLog(GroovyStrutsSpringObjectFactory.class);

	private GroovyClassLoader gcl;

    private String autoWire;
    private boolean useClassCache = true;
    
    @Inject(value=StrutsConstants.STRUTS_OBJECTFACTORY_SPRING_AUTOWIRE,required=false)
    public void setAutoWire(String val) {
        autoWire = val;
    }
    
    @Inject(value=StrutsConstants.STRUTS_OBJECTFACTORY_SPRING_USE_CLASS_CACHE,required=false)
    public void setUseClassCache(String val) {
        useClassCache = "true".equals(val);
    }
    
    @Inject
    public void setServletContext(ServletContext servletContext) {
		log.info ("Groovy Spring Plugin: Initializing");

		// Create the Groovy classloader and make it a child of the current thread's class loader.
		CompilerConfiguration cc = new CompilerConfiguration ();
		cc.setRecompileGroovySource (true);
		gcl = new GroovyClassLoader (Thread.currentThread().getContextClassLoader (), cc);
		gcl.setShouldRecompile (true);
		// gcl = new GroovyClassLoader (Thread.currentThread().getContextClassLoader () );
		// gcl.setShouldRecompile (false);
		log.info ("GroovyClassLoader recompilation set to: " + gcl.isShouldRecompile () );

        log.info("Initializing Struts-Spring integration...");

        ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        if (appContext == null) {
            // uh oh! looks like the lifecycle listener wasn't installed. Let's inform the user
            String message = "********** FATAL ERROR STARTING UP SPRING-STRUTS INTEGRATION **********\n" +
                    "Looks like the Spring listener was not configured for your web app! \n" +
                    "Nothing will work until WebApplicationContextUtils returns a valid ApplicationContext.\n" +
                    "You might need to add the following to web.xml: \n" +
                    "    <listener>\n" +
                    "        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>\n" +
                    "    </listener>";
            log.fatal(message);
            return;
        }

        this.setApplicationContext(appContext);

        int type = AutowireCapableBeanFactory.AUTOWIRE_BY_NAME;   // default
        if ("name".equals(autoWire)) {
            type = AutowireCapableBeanFactory.AUTOWIRE_BY_NAME;
        } else if ("type".equals(autoWire)) {
            type = AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE;
        } else if ("auto".equals(autoWire)) {
            type = AutowireCapableBeanFactory.AUTOWIRE_AUTODETECT;
        } else if ("constructor".equals(autoWire)) {
            type = AutowireCapableBeanFactory.AUTOWIRE_CONSTRUCTOR;
        }
        this.setAutowireStrategy(type);

        this.setUseClassCache(useClassCache);

        log.info("... initialized Struts-Spring integration successfully");

		// Set the appContext's class loader to the GroovyClassLoader. The refresh the context.
		// ((org.springframework.core.io.DefaultResourceLoader) appContext).setClassLoader (gcl);
		// ((ConfigurableWebApplicationContext) appContext).refresh ();

		log.info ("Groovy Spring Plugin: Initialization complete");
    }

	/** 
	 * If the requested classname ends in .groovy use the GroovyClassLoader to return an instance of the class.
	 * If the className ends in .groovy and the GroovyClassLoader does not return a class instance this method 
	 * will throw a ClassNotFoundException. If the className does not end in .groovy it will simply delegate 
	 * precessing to its super class.
	 */
	public Class getClassInstance (String className) throws ClassNotFoundException {

		if (className.endsWith (".groovy") ) {
			log.debug ("Groovy Works: Attempting to load a Groovy script: " + className);
			
			// Managle the className into something usable by the GroovyClassLoader by removing the .groovy from the end.
			className = className.substring(0, className.length() - ".groovy".length()); // Remove .groovy from the end of the className.

			// Use the GroovyCLassLoader to load the class.
			Class clazz = gcl.loadClass (className, true, false);
			// log.debug ("clazz = " + clazz.hashCode () );
			return clazz;
		} else {
			return super.getClassInstance (className);
		}

    }
}
