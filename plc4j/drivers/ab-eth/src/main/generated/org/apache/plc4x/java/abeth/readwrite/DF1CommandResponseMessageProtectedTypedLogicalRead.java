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
package org.apache.plc4x.java.abeth.readwrite;

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

public class DF1CommandResponseMessageProtectedTypedLogicalRead extends DF1ResponseMessage
    implements Message {

  // Accessors for discriminator values.
  public Short getCommandCode() {
    return (short) 0x4F;
  }

  // Properties.
  protected final List<Short> data;

  // Arguments.
  protected final Integer payloadLength;

  public DF1CommandResponseMessageProtectedTypedLogicalRead(
      short destinationAddress,
      short sourceAddress,
      short status,
      int transactionCounter,
      List<Short> data,
      Integer payloadLength) {
    super(destinationAddress, sourceAddress, status, transactionCounter, payloadLength);
    this.data = data;
    this.payloadLength = payloadLength;
  }

  public List<Short> getData() {
    return data;
  }

  @Override
  protected void serializeDF1ResponseMessageChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("DF1CommandResponseMessageProtectedTypedLogicalRead");

    // Array Field (data)
    writeSimpleTypeArrayField("data", data, writeUnsignedShort(writeBuffer, 8));

    writeBuffer.popContext("DF1CommandResponseMessageProtectedTypedLogicalRead");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    DF1CommandResponseMessageProtectedTypedLogicalRead _value = this;

    // Array field
    if (data != null) {
      lengthInBits += 8 * data.size();
    }

    return lengthInBits;
  }

  public static DF1ResponseMessageBuilder staticParseDF1ResponseMessageBuilder(
      ReadBuffer readBuffer, Integer payloadLength) throws ParseException {
    readBuffer.pullContext("DF1CommandResponseMessageProtectedTypedLogicalRead");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    List<Short> data =
        readLengthArrayField("data", readUnsignedShort(readBuffer, 8), (payloadLength) - (8));

    readBuffer.closeContext("DF1CommandResponseMessageProtectedTypedLogicalRead");
    // Create the instance
    return new DF1CommandResponseMessageProtectedTypedLogicalReadBuilderImpl(data, payloadLength);
  }

  public static class DF1CommandResponseMessageProtectedTypedLogicalReadBuilderImpl
      implements DF1ResponseMessage.DF1ResponseMessageBuilder {
    private final List<Short> data;
    private final Integer payloadLength;

    public DF1CommandResponseMessageProtectedTypedLogicalReadBuilderImpl(
        List<Short> data, Integer payloadLength) {

      this.data = data;
      this.payloadLength = payloadLength;
    }

    public DF1CommandResponseMessageProtectedTypedLogicalRead build(
        short destinationAddress,
        short sourceAddress,
        short status,
        int transactionCounter,
        Integer payloadLength) {
      DF1CommandResponseMessageProtectedTypedLogicalRead
          dF1CommandResponseMessageProtectedTypedLogicalRead =
              new DF1CommandResponseMessageProtectedTypedLogicalRead(
                  destinationAddress,
                  sourceAddress,
                  status,
                  transactionCounter,
                  data,
                  payloadLength);
      return dF1CommandResponseMessageProtectedTypedLogicalRead;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DF1CommandResponseMessageProtectedTypedLogicalRead)) {
      return false;
    }
    DF1CommandResponseMessageProtectedTypedLogicalRead that =
        (DF1CommandResponseMessageProtectedTypedLogicalRead) o;
    return (getData() == that.getData()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getData());
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
