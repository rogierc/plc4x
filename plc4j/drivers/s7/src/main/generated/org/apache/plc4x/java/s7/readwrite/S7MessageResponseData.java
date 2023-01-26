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

public class S7MessageResponseData extends S7Message implements Message {

  // Accessors for discriminator values.
  public Short getMessageType() {
    return (short) 0x03;
  }

  // Properties.
  protected final short errorClass;
  protected final short errorCode;

  public S7MessageResponseData(
      int tpduReference,
      S7Parameter parameter,
      S7Payload payload,
      short errorClass,
      short errorCode) {
    super(tpduReference, parameter, payload);
    this.errorClass = errorClass;
    this.errorCode = errorCode;
  }

  public short getErrorClass() {
    return errorClass;
  }

  public short getErrorCode() {
    return errorCode;
  }

  @Override
  protected void serializeS7MessageChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("S7MessageResponseData");

    // Simple Field (errorClass)
    writeSimpleField("errorClass", errorClass, writeUnsignedShort(writeBuffer, 8));

    // Simple Field (errorCode)
    writeSimpleField("errorCode", errorCode, writeUnsignedShort(writeBuffer, 8));

    writeBuffer.popContext("S7MessageResponseData");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    S7MessageResponseData _value = this;

    // Simple field (errorClass)
    lengthInBits += 8;

    // Simple field (errorCode)
    lengthInBits += 8;

    return lengthInBits;
  }

  public static S7MessageBuilder staticParseS7MessageBuilder(ReadBuffer readBuffer)
      throws ParseException {
    readBuffer.pullContext("S7MessageResponseData");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    short errorClass = readSimpleField("errorClass", readUnsignedShort(readBuffer, 8));

    short errorCode = readSimpleField("errorCode", readUnsignedShort(readBuffer, 8));

    readBuffer.closeContext("S7MessageResponseData");
    // Create the instance
    return new S7MessageResponseDataBuilderImpl(errorClass, errorCode);
  }

  public static class S7MessageResponseDataBuilderImpl implements S7Message.S7MessageBuilder {
    private final short errorClass;
    private final short errorCode;

    public S7MessageResponseDataBuilderImpl(short errorClass, short errorCode) {

      this.errorClass = errorClass;
      this.errorCode = errorCode;
    }

    public S7MessageResponseData build(
        int tpduReference, S7Parameter parameter, S7Payload payload) {
      S7MessageResponseData s7MessageResponseData =
          new S7MessageResponseData(tpduReference, parameter, payload, errorClass, errorCode);
      return s7MessageResponseData;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof S7MessageResponseData)) {
      return false;
    }
    S7MessageResponseData that = (S7MessageResponseData) o;
    return (getErrorClass() == that.getErrorClass())
        && (getErrorCode() == that.getErrorCode())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getErrorClass(), getErrorCode());
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
