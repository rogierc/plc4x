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

public class COTPParameterTpduSize extends COTPParameter implements Message {

  // Accessors for discriminator values.
  public Short getParameterType() {
    return (short) 0xC0;
  }

  // Properties.
  protected final COTPTpduSize tpduSize;

  // Arguments.
  protected final Short rest;

  public COTPParameterTpduSize(COTPTpduSize tpduSize, Short rest) {
    super(rest);
    this.tpduSize = tpduSize;
    this.rest = rest;
  }

  public COTPTpduSize getTpduSize() {
    return tpduSize;
  }

  @Override
  protected void serializeCOTPParameterChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("COTPParameterTpduSize");

    // Simple Field (tpduSize)
    writeSimpleEnumField(
        "tpduSize",
        "COTPTpduSize",
        tpduSize,
        new DataWriterEnumDefault<>(
            COTPTpduSize::getValue, COTPTpduSize::name, writeUnsignedShort(writeBuffer, 8)));

    writeBuffer.popContext("COTPParameterTpduSize");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    COTPParameterTpduSize _value = this;

    // Simple field (tpduSize)
    lengthInBits += 8;

    return lengthInBits;
  }

  public static COTPParameterBuilder staticParseCOTPParameterBuilder(
      ReadBuffer readBuffer, Short rest) throws ParseException {
    readBuffer.pullContext("COTPParameterTpduSize");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    COTPTpduSize tpduSize =
        readEnumField(
            "tpduSize",
            "COTPTpduSize",
            new DataReaderEnumDefault<>(
                COTPTpduSize::enumForValue, readUnsignedShort(readBuffer, 8)));

    readBuffer.closeContext("COTPParameterTpduSize");
    // Create the instance
    return new COTPParameterTpduSizeBuilderImpl(tpduSize, rest);
  }

  public static class COTPParameterTpduSizeBuilderImpl
      implements COTPParameter.COTPParameterBuilder {
    private final COTPTpduSize tpduSize;
    private final Short rest;

    public COTPParameterTpduSizeBuilderImpl(COTPTpduSize tpduSize, Short rest) {

      this.tpduSize = tpduSize;
      this.rest = rest;
    }

    public COTPParameterTpduSize build(Short rest) {

      COTPParameterTpduSize cOTPParameterTpduSize = new COTPParameterTpduSize(tpduSize, rest);
      return cOTPParameterTpduSize;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof COTPParameterTpduSize)) {
      return false;
    }
    COTPParameterTpduSize that = (COTPParameterTpduSize) o;
    return (getTpduSize() == that.getTpduSize()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getTpduSize());
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
