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

public class ParameterValueInterfaceOptions2 extends ParameterValue implements Message {

  // Accessors for discriminator values.
  public ParameterType getParameterType() {
    return ParameterType.INTERFACE_OPTIONS_2;
  }

  // Properties.
  protected final InterfaceOptions2 value;
  protected final byte[] data;

  // Arguments.
  protected final Short numBytes;

  public ParameterValueInterfaceOptions2(InterfaceOptions2 value, byte[] data, Short numBytes) {
    super(numBytes);
    this.value = value;
    this.data = data;
    this.numBytes = numBytes;
  }

  public InterfaceOptions2 getValue() {
    return value;
  }

  public byte[] getData() {
    return data;
  }

  @Override
  protected void serializeParameterValueChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("ParameterValueInterfaceOptions2");

    // Simple Field (value)
    writeSimpleField("value", value, new DataWriterComplexDefault<>(writeBuffer));

    // Array Field (data)
    writeByteArrayField("data", data, writeByteArray(writeBuffer, 8));

    writeBuffer.popContext("ParameterValueInterfaceOptions2");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    ParameterValueInterfaceOptions2 _value = this;

    // Simple field (value)
    lengthInBits += value.getLengthInBits();

    // Array field
    if (data != null) {
      lengthInBits += 8 * data.length;
    }

    return lengthInBits;
  }

  public static ParameterValueBuilder staticParseParameterValueBuilder(
      ReadBuffer readBuffer, ParameterType parameterType, Short numBytes) throws ParseException {
    readBuffer.pullContext("ParameterValueInterfaceOptions2");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;
    // Validation
    if (!((numBytes) >= (1))) {
      throw new ParseValidationException("InterfaceOptions2 has exactly one byte");
    }

    InterfaceOptions2 value =
        readSimpleField(
            "value",
            new DataReaderComplexDefault<>(
                () -> InterfaceOptions2.staticParse(readBuffer), readBuffer));

    byte[] data = readBuffer.readByteArray("data", Math.toIntExact((numBytes) - (1)));

    readBuffer.closeContext("ParameterValueInterfaceOptions2");
    // Create the instance
    return new ParameterValueInterfaceOptions2BuilderImpl(value, data, numBytes);
  }

  public static class ParameterValueInterfaceOptions2BuilderImpl
      implements ParameterValue.ParameterValueBuilder {
    private final InterfaceOptions2 value;
    private final byte[] data;
    private final Short numBytes;

    public ParameterValueInterfaceOptions2BuilderImpl(
        InterfaceOptions2 value, byte[] data, Short numBytes) {

      this.value = value;
      this.data = data;
      this.numBytes = numBytes;
    }

    public ParameterValueInterfaceOptions2 build(Short numBytes) {

      ParameterValueInterfaceOptions2 parameterValueInterfaceOptions2 =
          new ParameterValueInterfaceOptions2(value, data, numBytes);
      return parameterValueInterfaceOptions2;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ParameterValueInterfaceOptions2)) {
      return false;
    }
    ParameterValueInterfaceOptions2 that = (ParameterValueInterfaceOptions2) o;
    return (getValue() == that.getValue())
        && (getData() == that.getData())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getValue(), getData());
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
