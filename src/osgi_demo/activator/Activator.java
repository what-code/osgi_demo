package osgi_demo.activator;

import java.util.*;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import osgi_demo.Hello;
import osgi_demo.impl.HelloImpl;

public class Activator implements BundleActivator {

	private static BundleContext context;
	
	private List<ServiceRegistration> registrations = new ArrayList<ServiceRegistration>();

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		registrations.add(bundleContext.registerService(Hello.class.getName(),new HelloImpl("Hello, OSGi"), null));
		Activator.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		for (ServiceRegistration registration : registrations) {
	        System.out.println("unregistering: "+ registration);
	        registration.unregister();
	    }
		//Activator.context = null;
	}

}
