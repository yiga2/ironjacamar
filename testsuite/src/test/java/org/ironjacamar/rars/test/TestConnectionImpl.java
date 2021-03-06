/*
 * IronJacamar, a Java EE Connector Architecture implementation
 * Copyright 2015, Red Hat Inc, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the Eclipse Public License 1.0 as
 * published by the Free Software Foundation.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse
 * Public License for more details.
 *
 * You should have received a copy of the Eclipse Public License 
 * along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.ironjacamar.rars.test;

import org.ironjacamar.core.workmanager.WorkManagerImpl;

import javax.resource.spi.BootstrapContext;
import javax.resource.spi.work.WorkManager;

/**
 * TestConnectionImpl
 */
public class TestConnectionImpl implements TestConnection
{
   /** ManagedConnection */
   private TestManagedConnection mc;

   /** ManagedConnectionFactory */
   private TestManagedConnectionFactory mcf;

   /**
    * Default constructor
    * @param mc TestManagedConnection
    * @param mcf TestManagedConnectionFactory
    */
   public TestConnectionImpl(TestManagedConnection mc, TestManagedConnectionFactory mcf)
   {
      this.mc = mc;
      this.mcf = mcf;
   }

   /**
    * {@inheritDoc}
    */
   public int getCreateFailureCount()
   {
      if (mc != null)
         return mc.getCreateFailureCount();

      return -1;
   }

   /**
    * {@inheritDoc}
    */
   public int getInvalidConnectionFailureCount()
   {
      if (mc != null)
         return mc.getInvalidConnectionFailureCount();

      return -1;
   }

   /**
    * Close
    */
   public void close()
   {
      if (mc != null)
      {
         mc.closeHandle(this);
         mc = null;
      }
   }

   /**
    * Set ManagedConnection
    * @param mc The value
    */
   void setManagedConnection(TestManagedConnection mc)
   {
      this.mc = mc;
   }

   /**
    * {@inheritDoc}
    */
   public WorkManager getWorkManager()
   {
      return mc.getWorkManager();
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String getWorkManagerName()
   {
      return ((WorkManagerImpl) getWorkManager()).getName();
   }

   @Override
   public BootstrapContext getBootstrapContext()
   {
      return mc.getBootstrapContext();
   }

}
