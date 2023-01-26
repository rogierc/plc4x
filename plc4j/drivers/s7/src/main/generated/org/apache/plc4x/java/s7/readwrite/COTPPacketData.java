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
package org.apache.plc4x.java.s7.readwrite;

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

public class COTPPacketData extends COTPPacket implements Message {

  // Accessors for discriminator values.
  public Short getTpduCode() {
    return (short) 0xF0;
  }

  // Properties.
  protected final boolean eot;
  protected final short tpduRef;

  // Arguments.
  protected final Integer cotpLen;

  public COTPPacketData(
      List<COTPParameter> parameters,
      S7Message payload,
      boolean eot,
      short tpduRef,
      Integer cotpLen) {
    super(parameters, payload, cotpLen);
    this.eot = eot;
    this.tpduRef = tpduRef;
    this.cotpLen = cotpLen;
  }

  public boolean getEot() {
    return eot;
  }

  public short getTpduRef() {
    return tpduRef;
  }

  @Override
  protected void serializeCOTPPacketChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("COTPPacketData");

    // Simple Field (eot)
    writeSimpleField("eot", eot, writeBoolean(writeBuffer));

    // Simple Field (tpduRef)
    writeSimpleField("tpduRef", tpduRef, writeUnsignedShort(writeBuffer, 7));

    writeBuffer.popContext("COTPPacketData");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    COTPPacketData _value = this;

    // Simple field (eot)
    lengthInBits += 1;

    // Simple field (tpduRef)
    lengthInBits += 7;

    return lengthInBits;
  }

  public static COTPPacketBuilder staticParseCOTPPacketBuilder(
      ReadBuffer readBuffer, Integer cotpLen) throws ParseException {
    readBuffer.pullContext("COTPPacketData");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    boolean eot = readSimpleField("eot", readBoolean(readBuffer));

    short tpduRef = readSimpleField("tpduRef", readUnsignedShort(readBuffer, 7));

    readBuffer.closeContext("COTPPacketData");
    // Create the instance
    return new COTPPacketDataBuilderImpl(eot, tpduRef, cotpLen);
  }

  public static class COTPPacketDataBuilderImpl implements COTPPacket.COTPPacketBuilder {
    private final boolean eot;
    private final short tpduRef;
    private final Integer cotpLen;

    public COTPPacketDataBuilderImpl(boolean eot, short tpduRef, Integer cotpLen) {

      this.eot = eot;
      this.tpduRef = tpduRef;
      this.cotpLen = cotpLen;
    }

    public COTPPacketData build(
        List<COTPParameter> parameters, S7Message payload, Integer cotpLen) {
      COTPPacketData cOTPPacketData =
          new COTPPacketData(parameters, payload, eot, tpduRef, cotpLen);
      return cOTPPacketData;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof COTPPacketData)) {
      return false;
    }
    COTPPacketData that = (COTPPacketData) o;
    return (getEot() == that.getEot())
        && (getTpduRef() == that.getTpduRef())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getEot(), getTpduRef());
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
