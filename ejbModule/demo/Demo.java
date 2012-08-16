package demo;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Viktor Pekar
 * 
 *         Aug 14, 2012
 */

@Stateless
public class Demo implements IDemo {

	private static final Logger logger = (Logger) LoggerFactory
			.getLogger(Demo.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see demo.IDemo#printHelloWorld()
	 */
	@Override
	public void printHelloWorld() {
		logger.info("######## TEST SUCCESS ##########");

		try {
			IDemo2 demo2 = (IDemo2) new InitialContext()
					.lookup("java:global/DemoService2/Demo2");

			demo2.printOutHelloWorld2();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
