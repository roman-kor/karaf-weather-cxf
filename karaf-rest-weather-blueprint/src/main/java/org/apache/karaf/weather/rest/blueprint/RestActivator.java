package org.apache.karaf.weather.rest.blueprint;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class RestActivator implements BundleActivator {
   public void start(BundleContext context) {
      System.out.println("Starting the Rest bundle");
   }

   public void stop(BundleContext context) {
      System.out.println("Stopping the Rest bundle");
   }
}
