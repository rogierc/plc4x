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
package org.apache.plc4x.java.firmata.readwrite;

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

public class FirmataCommandProtocolVersion extends FirmataCommand implements Message {

  // Accessors for discriminator values.
  public Byte getCommandCode() {
    return (byte) 0x9;
  }

  // Properties.
  protected final short majorVersion;
  protected final short minorVersion;

  // Arguments.
  protected final Boolean response;

  public FirmataCommandProtocolVersion(short majorVersion, short minorVersion, Boolean response) {
    super(response);
    this.majorVersion = majorVersion;
    this.minorVersion = minorVersion;
    this.response = response;
  }

  public short getMajorVersion() {
    return majorVersion;
  }

  public short getMinorVersion() {
    return minorVersion;
  }

  @Override
  protected void serializeFirmataCommandChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("FirmataCommandProtocolVersion");

    // Simple Field (majorVersion)
    writeSimpleField("majorVersion", majorVersion, writeUnsignedShort(writeBuffer, 8));

    // Simple Field (minorVersion)
    writeSimpleField("minorVersion", minorVersion, writeUnsignedShort(writeBuffer, 8));

    writeBuffer.popContext("FirmataCommandProtocolVersion");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    FirmataCommandProtocolVersion _value = this;

    // Simple field (majorVersion)
    lengthInBits += 8;

    // Simple field (minorVersion)
    lengthInBits += 8;

    return lengthInBits;
  }

  public static FirmataCommandBuilder staticParseFirmataCommandBuilder(
      ReadBuffer readBuffer, Boolean response) throws ParseException {
    readBuffer.pullContext("FirmataCommandProtocolVersion");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    short majorVersion = readSimpleField("majorVersion", readUnsignedShort(readBuffer, 8));

    short minorVersion = readSimpleField("minorVersion", readUnsignedShort(readBuffer, 8));

    readBuffer.closeContext("FirmataCommandProtocolVersion");
    // Create the instance
    return new FirmataCommandProtocolVersionBuilderImpl(majorVersion, minorVersion, response);
  }

  public static class FirmataCommandProtocolVersionBuilderImpl
      implements FirmataCommand.FirmataCommandBuilder {
    private final short majorVersion;
    private final short minorVersion;
    private final Boolean response;

    public FirmataCommandProtocolVersionBuilderImpl(
        short majorVersion, short minorVersion, Boolean response) {

      this.majorVersion = majorVersion;
      this.minorVersion = minorVersion;
      this.response = response;
    }

    public FirmataCommandProtocolVersion build(Boolean response) {

      FirmataCommandProtocolVersion firmataCommandProtocolVersion =
          new FirmataCommandProtocolVersion(majorVersion, minorVersion, response);
      return firmataCommandProtocolVersion;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof FirmataCommandProtocolVersion)) {
      return false;
    }
    FirmataCommandProtocolVersion that = (FirmataCommandProtocolVersion) o;
    return (getMajorVersion() == that.getMajorVersion())
        && (getMinorVersion() == that.getMinorVersion())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getMajorVersion(), getMinorVersion());
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
