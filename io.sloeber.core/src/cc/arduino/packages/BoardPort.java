/*
 * This file is part of Arduino.
 *
 * Arduino is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 * As a special exception, you may use this file as part of a free software
 * library without restriction.  Specifically, if other files instantiate
 * templates or use macros or inline functions from this file, or you compile
 * this file and link it with other files to produce an executable, this
 * file does not by itself cause the resulting executable to be covered by
 * the GNU General Public License.  This exception does not however
 * invalidate any other reasons why the executable file might be covered by
 * the GNU General Public License.
 *
 * Copyright 2013 Arduino LLC (http://www.arduino.cc/)
 */

package cc.arduino.packages;



public class BoardPort {

  private String address;
  private String protocol;
  private String boardName;
  private String vid;
  private String pid;
  private String iserial;
  private String label;
  private final PreferencesMap prefs;
  private boolean online;

  public BoardPort() {
    this.prefs = new PreferencesMap();
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getProtocol() {
    return this.protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public String getBoardName() {
    return this.boardName;
  }

  public void setBoardName(String boardName) {
    this.boardName = boardName;
  }

  public PreferencesMap getPrefs() {
    return this.prefs;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getLabel() {
    return this.label;
  }

  public void setOnlineStatus(boolean online) {
    this.online = online;
  }

  public boolean isOnline() {
    return this.online;
  }


  public String getVID() {
    return this.vid;
  }

  public String getPID() {
    return this.pid;
  }

  public void setISerial(String iserial) {
    this.iserial = iserial;
  }
  public String getISerial() {
    return this.iserial;
  }

  @Override
  public String toString() {
    return this.address+"_"+this.vid+"_"+this.pid;  //$NON-NLS-1$//$NON-NLS-2$
  }
}
