/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.plc4x.java.knxnetip.readwrite;

import static org.apache.plc4x.java.spi.codegen.fields.FieldReaderFactory.*;
import static org.apache.plc4x.java.spi.codegen.fields.FieldWriterFactory.*;
import static org.apache.plc4x.java.spi.codegen.io.DataReaderFactory.*;
import static org.apache.plc4x.java.spi.codegen.io.DataWriterFactory.*;
import static org.apache.plc4x.java.spi.generation.StaticHelper.*;

import java.time.*;
import java.util.*;
import org.apache.plc4x.java.api.exceptions.*;
import org.apache.plc4x.java.api.value.*;
import org.apache.plc4x.java.spi.codegen.*;
import org.apache.plc4x.java.spi.codegen.fields.*;
import org.apache.plc4x.java.spi.codegen.io.*;
import org.apache.plc4x.java.spi.generation.*;

// Code generated by code-generation. DO NOT EDIT.

public class KnxNetIpTunneling extends ServiceId implements Message {

  // Accessors for discriminator values.
  public Short getServiceType() {
    return (short) 0x04;
  }

  // Properties.
  protected final short version;

  public KnxNetIpTunneling(short version) {
    super();
    this.version = version;
  }

  public short getVersion() {
    return version;
  }

  @Override
  protected void serializeServiceIdChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("KnxNetIpTunneling");

    // Simple Field (version)
    writeSimpleField("version", version, writeUnsignedShort(writeBuffer, 8));

    writeBuffer.popContext("KnxNetIpTunneling");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    KnxNetIpTunneling _value = this;

    // Simple field (version)
    lengthInBits += 8;

    return lengthInBits;
  }

  public static ServiceIdBuilder staticParseServiceIdBuilder(ReadBuffer readBuffer)
      throws ParseException {
    readBuffer.pullContext("KnxNetIpTunneling");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    short version = readSimpleField("version", readUnsignedShort(readBuffer, 8));

    readBuffer.closeContext("KnxNetIpTunneling");
    // Create the instance
    return new KnxNetIpTunnelingBuilderImpl(version);
  }

  public static class KnxNetIpTunnelingBuilderImpl implements ServiceId.ServiceIdBuilder {
    private final short version;

    public KnxNetIpTunnelingBuilderImpl(short version) {

      this.version = version;
    }

    public KnxNetIpTunneling build() {
      KnxNetIpTunneling knxNetIpTunneling = new KnxNetIpTunneling(version);
      return knxNetIpTunneling;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof KnxNetIpTunneling)) {
      return false;
    }
    KnxNetIpTunneling that = (KnxNetIpTunneling) o;
    return (getVersion() == that.getVersion()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getVersion());
  }

  @Override
  public String toString() {
    WriteBufferBoxBased writeBufferBoxBased = new WriteBufferBoxBased(true, true);
    try {
      writeBufferBoxBased.writeSerializable(this);
    } catch (SerializationException e) {
      throw new RuntimeException(e);
    }
    return "\n" + writeBufferBoxBased.getBox().toString() + "\n";
  }
}
