package org.apache.karaf.weather.services;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ServiceActivator implements BundleActivator {

   public void start(BundleContext context) {
      System.out.println("Starting the Service bundle");
   }

   public void stop(BundleContext context) {
      System.out.println("Stopping the Service bundle");
   }
}
