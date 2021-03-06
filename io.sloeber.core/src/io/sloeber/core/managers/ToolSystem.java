/*******************************************************************************
 * Copyright (c) 2015 QNX Software Systems and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package io.sloeber.core.managers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

public class ToolSystem {

	private String host;
	private String archiveFileName;
	private String url;
	private String checksum;
	private String size;

	private transient Tool tool;

	public void setOwner(Tool tool) {
		this.tool = tool;
	}

	public String getHost() {
		return this.host;
	}

	public String getArchiveFileName() {
		return this.archiveFileName;
	}

	public String getUrl() {
		return this.url;
	}

	public String getChecksum() {
		return this.checksum;
	}

	public String getSize() {
		return this.size;
	}

	
	
	/**
	 * Is the tool compatible with the system sloeber is running on
	 * 
	 * code as taken from arduino HostDependentDownloadableContribution 
	 * https://github.com/arduino/Arduino/blob/master/arduino-core/src/cc/arduino/contributions/packages/HostDependentDownloadableContribution.java
	 * 
	 * @return true if ok; false if not
	 */
	@SuppressWarnings("nls")
	public boolean isApplicable() {

		String osName =System.getProperty("os.name");
	    String osArch =System.getProperty("os.arch");

	    if (osName.contains("Linux")) {
	      if (osArch.equals("arm")) {
	        // Raspberry PI, BBB or other ARM based host

	        // PI: "arm-linux-gnueabihf"
	        // Arch-linux on PI2: "armv7l-unknown-linux-gnueabihf"
	        // Raspbian on PI2: "arm-linux-gnueabihf"
	        // Ubuntu Mate on PI2: "arm-linux-gnueabihf"
	        // Debian 7.9 on BBB: "arm-linux-gnueabihf"
	        // Raspbian on PI Zero: "arm-linux-gnueabihf"
	        return host.matches("arm.*-linux-gnueabihf");
	      } else if (osArch.contains("aarch64")) {
	        return host.matches("aarch64.*-linux-gnu*");
	      } else if (osArch.contains("amd64")) {
	        return host.matches("x86_64-.*linux-gnu");
	      } else {
	        return host.matches("i[3456]86-.*linux-gnu");
	      }
	    }

	    if (osName.contains("Windows")) {
	      return host.matches("i[3456]86-.*mingw32") || host.matches("i[3456]86-.*cygwin");
	    }

	    if (osName.contains("Mac")) {
	      if (osArch.contains("x86_64")) {
	        return host.matches("x86_64-apple-darwin.*") || host.matches("i[3456]86-apple-darwin.*");
	      }
		return host.matches("i[3456]86-apple-darwin.*");
	    }

	    if (osName.contains("FreeBSD")) {
	      if (osArch.contains("arm")) {
	        return host.matches("arm.*-freebsd[0-9]*");
	      }
		return host.matches(osArch + "-freebsd[0-9]*");
	    }

	    return false;
	}

	public IStatus install(IProgressMonitor monitor) {
		return InternalPackageManager.downloadAndInstall(this.url, this.archiveFileName, this.tool.getInstallPath(),
				false, monitor);
	}

}
