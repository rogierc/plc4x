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

public class CANOpenHeartbeatPayload extends CANOpenPayload implements Message {

  // Accessors for discriminator values.
  public CANOpenService getService() {
    return CANOpenService.HEARTBEAT;
  }

  // Properties.
  protected final NMTState state;

  public CANOpenHeartbeatPayload(NMTState state) {
    super();
    this.state = state;
  }

  public NMTState getState() {
    return state;
  }

  @Override
  protected void serializeCANOpenPayloadChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("CANOpenHeartbeatPayload");

    // Simple Field (state)
    writeSimpleEnumField(
        "state",
        "NMTState",
        state,
        new DataWriterEnumDefault<>(
            NMTState::getValue, NMTState::name, writeUnsignedShort(writeBuffer, 8)));

    writeBuffer.popContext("CANOpenHeartbeatPayload");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    CANOpenHeartbeatPayload _value = this;

    // Simple field (state)
    lengthInBits += 8;

    return lengthInBits;
  }

  public static CANOpenPayloadBuilder staticParseCANOpenPayloadBuilder(
      ReadBuffer readBuffer, CANOpenService service) throws ParseException {
    readBuffer.pullContext("CANOpenHeartbeatPayload");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    NMTState state =
        readEnumField(
            "state",
            "NMTState",
            new DataReaderEnumDefault<>(NMTState::enumForValue, readUnsignedShort(readBuffer, 8)));

    readBuffer.closeContext("CANOpenHeartbeatPayload");
    // Create the instance
    return new CANOpenHeartbeatPayloadBuilderImpl(state);
  }

  public static class CANOpenHeartbeatPayloadBuilderImpl
      implements CANOpenPayload.CANOpenPayloadBuilder {
    private final NMTState state;

    public CANOpenHeartbeatPayloadBuilderImpl(NMTState state) {

      this.state = state;
    }

    public CANOpenHeartbeatPayload build() {
      CANOpenHeartbeatPayload cANOpenHeartbeatPayload = new CANOpenHeartbeatPayload(state);
      return cANOpenHeartbeatPayload;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CANOpenHeartbeatPayload)) {
      return false;
    }
    CANOpenHeartbeatPayload that = (CANOpenHeartbeatPayload) o;
    return (getState() == that.getState()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getState());
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
