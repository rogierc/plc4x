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

public class COTPParameterDisconnectAdditionalInformation extends COTPParameter implements Message {

  // Accessors for discriminator values.
  public Short getParameterType() {
    return (short) 0xE0;
  }

  // Properties.
  protected final byte[] data;

  // Arguments.
  protected final Short rest;

  public COTPParameterDisconnectAdditionalInformation(byte[] data, Short rest) {
    super(rest);
    this.data = data;
    this.rest = rest;
  }

  public byte[] getData() {
    return data;
  }

  @Override
  protected void serializeCOTPParameterChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("COTPParameterDisconnectAdditionalInformation");

    // Array Field (data)
    writeByteArrayField("data", data, writeByteArray(writeBuffer, 8));

    writeBuffer.popContext("COTPParameterDisconnectAdditionalInformation");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    COTPParameterDisconnectAdditionalInformation _value = this;

    // Array field
    if (data != null) {
      lengthInBits += 8 * data.length;
    }

    return lengthInBits;
  }

  public static COTPParameterBuilder staticParseCOTPParameterBuilder(
      ReadBuffer readBuffer, Short rest) throws ParseException {
    readBuffer.pullContext("COTPParameterDisconnectAdditionalInformation");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    byte[] data = readBuffer.readByteArray("data", Math.toIntExact(rest));

    readBuffer.closeContext("COTPParameterDisconnectAdditionalInformation");
    // Create the instance
    return new COTPParameterDisconnectAdditionalInformationBuilderImpl(data, rest);
  }

  public static class COTPParameterDisconnectAdditionalInformationBuilderImpl
      implements COTPParameter.COTPParameterBuilder {
    private final byte[] data;
    private final Short rest;

    public COTPParameterDisconnectAdditionalInformationBuilderImpl(byte[] data, Short rest) {

      this.data = data;
      this.rest = rest;
    }

    public COTPParameterDisconnectAdditionalInformation build(Short rest) {

      COTPParameterDisconnectAdditionalInformation cOTPParameterDisconnectAdditionalInformation =
          new COTPParameterDisconnectAdditionalInformation(data, rest);
      return cOTPParameterDisconnectAdditionalInformation;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof COTPParameterDisconnectAdditionalInformation)) {
      return false;
    }
    COTPParameterDisconnectAdditionalInformation that =
        (COTPParameterDisconnectAdditionalInformation) o;
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
