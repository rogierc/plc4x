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
package org.apache.plc4x.java.cbus.readwrite;

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

public class TelephonyDataLineOffHook extends TelephonyData implements Message {

  // Accessors for discriminator values.

  // Properties.
  protected final LineOffHookReason reason;
  protected final String number;

  public TelephonyDataLineOffHook(
      TelephonyCommandTypeContainer commandTypeContainer,
      byte argument,
      LineOffHookReason reason,
      String number) {
    super(commandTypeContainer, argument);
    this.reason = reason;
    this.number = number;
  }

  public LineOffHookReason getReason() {
    return reason;
  }

  public String getNumber() {
    return number;
  }

  @Override
  protected void serializeTelephonyDataChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("TelephonyDataLineOffHook");

    // Simple Field (reason)
    writeSimpleEnumField(
        "reason",
        "LineOffHookReason",
        reason,
        new DataWriterEnumDefault<>(
            LineOffHookReason::getValue,
            LineOffHookReason::name,
            writeUnsignedShort(writeBuffer, 8)));

    // Simple Field (number)
    writeSimpleField(
        "number",
        number,
        writeString(writeBuffer, (((commandTypeContainer.getNumBytes()) - (2))) * (8)));

    writeBuffer.popContext("TelephonyDataLineOffHook");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    TelephonyDataLineOffHook _value = this;

    // Simple field (reason)
    lengthInBits += 8;

    // Simple field (number)
    lengthInBits += (((commandTypeContainer.getNumBytes()) - (2))) * (8);

    return lengthInBits;
  }

  public static TelephonyDataBuilder staticParseTelephonyDataBuilder(
      ReadBuffer readBuffer, TelephonyCommandTypeContainer commandTypeContainer)
      throws ParseException {
    readBuffer.pullContext("TelephonyDataLineOffHook");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    LineOffHookReason reason =
        readEnumField(
            "reason",
            "LineOffHookReason",
            new DataReaderEnumDefault<>(
                LineOffHookReason::enumForValue, readUnsignedShort(readBuffer, 8)));

    String number =
        readSimpleField(
            "number", readString(readBuffer, (((commandTypeContainer.getNumBytes()) - (2))) * (8)));

    readBuffer.closeContext("TelephonyDataLineOffHook");
    // Create the instance
    return new TelephonyDataLineOffHookBuilderImpl(reason, number);
  }

  public static class TelephonyDataLineOffHookBuilderImpl
      implements TelephonyData.TelephonyDataBuilder {
    private final LineOffHookReason reason;
    private final String number;

    public TelephonyDataLineOffHookBuilderImpl(LineOffHookReason reason, String number) {

      this.reason = reason;
      this.number = number;
    }

    public TelephonyDataLineOffHook build(
        TelephonyCommandTypeContainer commandTypeContainer, byte argument) {
      TelephonyDataLineOffHook telephonyDataLineOffHook =
          new TelephonyDataLineOffHook(commandTypeContainer, argument, reason, number);
      return telephonyDataLineOffHook;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TelephonyDataLineOffHook)) {
      return false;
    }
    TelephonyDataLineOffHook that = (TelephonyDataLineOffHook) o;
    return (getReason() == that.getReason())
        && (getNumber() == that.getNumber())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getReason(), getNumber());
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
