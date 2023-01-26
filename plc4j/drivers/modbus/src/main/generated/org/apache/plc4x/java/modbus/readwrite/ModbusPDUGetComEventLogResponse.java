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
package org.apache.plc4x.java.modbus.readwrite;

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

public class ModbusPDUGetComEventLogResponse extends ModbusPDU implements Message {

  // Accessors for discriminator values.
  public Boolean getErrorFlag() {
    return (boolean) false;
  }

  public Short getFunctionFlag() {
    return (short) 0x0C;
  }

  public Boolean getResponse() {
    return (boolean) true;
  }

  // Properties.
  protected final int status;
  protected final int eventCount;
  protected final int messageCount;
  protected final byte[] events;

  public ModbusPDUGetComEventLogResponse(
      int status, int eventCount, int messageCount, byte[] events) {
    super();
    this.status = status;
    this.eventCount = eventCount;
    this.messageCount = messageCount;
    this.events = events;
  }

  public int getStatus() {
    return status;
  }

  public int getEventCount() {
    return eventCount;
  }

  public int getMessageCount() {
    return messageCount;
  }

  public byte[] getEvents() {
    return events;
  }

  @Override
  protected void serializeModbusPDUChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("ModbusPDUGetComEventLogResponse");

    // Implicit Field (byteCount) (Used for parsing, but its value is not stored as it's implicitly
    // given by the objects content)
    short byteCount = (short) ((COUNT(getEvents())) + (6));
    writeImplicitField("byteCount", byteCount, writeUnsignedShort(writeBuffer, 8));

    // Simple Field (status)
    writeSimpleField("status", status, writeUnsignedInt(writeBuffer, 16));

    // Simple Field (eventCount)
    writeSimpleField("eventCount", eventCount, writeUnsignedInt(writeBuffer, 16));

    // Simple Field (messageCount)
    writeSimpleField("messageCount", messageCount, writeUnsignedInt(writeBuffer, 16));

    // Array Field (events)
    writeByteArrayField("events", events, writeByteArray(writeBuffer, 8));

    writeBuffer.popContext("ModbusPDUGetComEventLogResponse");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    ModbusPDUGetComEventLogResponse _value = this;

    // Implicit Field (byteCount)
    lengthInBits += 8;

    // Simple field (status)
    lengthInBits += 16;

    // Simple field (eventCount)
    lengthInBits += 16;

    // Simple field (messageCount)
    lengthInBits += 16;

    // Array field
    if (events != null) {
      lengthInBits += 8 * events.length;
    }

    return lengthInBits;
  }

  public static ModbusPDUBuilder staticParseModbusPDUBuilder(
      ReadBuffer readBuffer, Boolean response) throws ParseException {
    readBuffer.pullContext("ModbusPDUGetComEventLogResponse");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    short byteCount = readImplicitField("byteCount", readUnsignedShort(readBuffer, 8));

    int status = readSimpleField("status", readUnsignedInt(readBuffer, 16));

    int eventCount = readSimpleField("eventCount", readUnsignedInt(readBuffer, 16));

    int messageCount = readSimpleField("messageCount", readUnsignedInt(readBuffer, 16));

    byte[] events = readBuffer.readByteArray("events", Math.toIntExact((byteCount) - (6)));

    readBuffer.closeContext("ModbusPDUGetComEventLogResponse");
    // Create the instance
    return new ModbusPDUGetComEventLogResponseBuilderImpl(status, eventCount, messageCount, events);
  }

  public static class ModbusPDUGetComEventLogResponseBuilderImpl
      implements ModbusPDU.ModbusPDUBuilder {
    private final int status;
    private final int eventCount;
    private final int messageCount;
    private final byte[] events;

    public ModbusPDUGetComEventLogResponseBuilderImpl(
        int status, int eventCount, int messageCount, byte[] events) {

      this.status = status;
      this.eventCount = eventCount;
      this.messageCount = messageCount;
      this.events = events;
    }

    public ModbusPDUGetComEventLogResponse build() {
      ModbusPDUGetComEventLogResponse modbusPDUGetComEventLogResponse =
          new ModbusPDUGetComEventLogResponse(status, eventCount, messageCount, events);
      return modbusPDUGetComEventLogResponse;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ModbusPDUGetComEventLogResponse)) {
      return false;
    }
    ModbusPDUGetComEventLogResponse that = (ModbusPDUGetComEventLogResponse) o;
    return (getStatus() == that.getStatus())
        && (getEventCount() == that.getEventCount())
        && (getMessageCount() == that.getMessageCount())
        && (getEvents() == that.getEvents())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(), getStatus(), getEventCount(), getMessageCount(), getEvents());
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
