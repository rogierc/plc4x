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
package org.apache.plc4x.java.canopen.readwrite;

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

public class SDOSegmentDownloadResponse extends SDOResponse implements Message {

  // Accessors for discriminator values.
  public SDOResponseCommand getCommand() {
    return SDOResponseCommand.SEGMENT_DOWNLOAD;
  }

  // Properties.
  protected final boolean toggle;
  // Reserved Fields
  private Byte reservedField0;
  private Long reservedField1;

  public SDOSegmentDownloadResponse(boolean toggle) {
    super();
    this.toggle = toggle;
  }

  public boolean getToggle() {
    return toggle;
  }

  @Override
  protected void serializeSDOResponseChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("SDOSegmentDownloadResponse");

    // Simple Field (toggle)
    writeSimpleField("toggle", toggle, writeBoolean(writeBuffer));

    // Reserved Field (reserved)
    writeReservedField(
        "reserved",
        reservedField0 != null ? reservedField0 : (byte) 0x00,
        writeUnsignedByte(writeBuffer, 4));

    // Reserved Field (reserved)
    writeReservedField(
        "reserved",
        reservedField1 != null ? reservedField1 : (long) 0x00,
        writeSignedLong(writeBuffer, 56));

    writeBuffer.popContext("SDOSegmentDownloadResponse");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    SDOSegmentDownloadResponse _value = this;

    // Simple field (toggle)
    lengthInBits += 1;

    // Reserved Field (reserved)
    lengthInBits += 4;

    // Reserved Field (reserved)
    lengthInBits += 56;

    return lengthInBits;
  }

  public static SDOResponseBuilder staticParseSDOResponseBuilder(
      ReadBuffer readBuffer, SDOResponseCommand command) throws ParseException {
    readBuffer.pullContext("SDOSegmentDownloadResponse");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    boolean toggle = readSimpleField("toggle", readBoolean(readBuffer));

    Byte reservedField0 =
        readReservedField("reserved", readUnsignedByte(readBuffer, 4), (byte) 0x00);

    Long reservedField1 =
        readReservedField("reserved", readSignedLong(readBuffer, 56), (long) 0x00);

    readBuffer.closeContext("SDOSegmentDownloadResponse");
    // Create the instance
    return new SDOSegmentDownloadResponseBuilderImpl(toggle, reservedField0, reservedField1);
  }

  public static class SDOSegmentDownloadResponseBuilderImpl
      implements SDOResponse.SDOResponseBuilder {
    private final boolean toggle;
    private final Byte reservedField0;
    private final Long reservedField1;

    public SDOSegmentDownloadResponseBuilderImpl(
        boolean toggle, Byte reservedField0, Long reservedField1) {
      this.toggle = toggle;
      this.reservedField0 = reservedField0;
      this.reservedField1 = reservedField1;
    }

    public SDOSegmentDownloadResponse build() {
      SDOSegmentDownloadResponse sDOSegmentDownloadResponse =
          new SDOSegmentDownloadResponse(toggle);
      sDOSegmentDownloadResponse.reservedField0 = reservedField0;
      sDOSegmentDownloadResponse.reservedField1 = reservedField1;
      return sDOSegmentDownloadResponse;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SDOSegmentDownloadResponse)) {
      return false;
    }
    SDOSegmentDownloadResponse that = (SDOSegmentDownloadResponse) o;
    return (getToggle() == that.getToggle()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getToggle());
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
