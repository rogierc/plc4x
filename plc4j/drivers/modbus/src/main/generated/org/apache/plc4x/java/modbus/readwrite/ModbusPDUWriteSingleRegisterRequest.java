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

public class ModbusPDUWriteSingleRegisterRequest extends ModbusPDU implements Message {

  // Accessors for discriminator values.
  public Boolean getErrorFlag() {
    return (boolean) false;
  }

  public Short getFunctionFlag() {
    return (short) 0x06;
  }

  public Boolean getResponse() {
    return (boolean) false;
  }

  // Properties.
  protected final int address;
  protected final int value;

  public ModbusPDUWriteSingleRegisterRequest(int address, int value) {
    super();
    this.address = address;
    this.value = value;
  }

  public int getAddress() {
    return address;
  }

  public int getValue() {
    return value;
  }

  @Override
  protected void serializeModbusPDUChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("ModbusPDUWriteSingleRegisterRequest");

    // Simple Field (address)
    writeSimpleField("address", address, writeUnsignedInt(writeBuffer, 16));

    // Simple Field (value)
    writeSimpleField("value", value, writeUnsignedInt(writeBuffer, 16));

    writeBuffer.popContext("ModbusPDUWriteSingleRegisterRequest");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    ModbusPDUWriteSingleRegisterRequest _value = this;

    // Simple field (address)
    lengthInBits += 16;

    // Simple field (value)
    lengthInBits += 16;

    return lengthInBits;
  }

  public static ModbusPDUBuilder staticParseModbusPDUBuilder(
      ReadBuffer readBuffer, Boolean response) throws ParseException {
    readBuffer.pullContext("ModbusPDUWriteSingleRegisterRequest");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    int address = readSimpleField("address", readUnsignedInt(readBuffer, 16));

    int value = readSimpleField("value", readUnsignedInt(readBuffer, 16));

    readBuffer.closeContext("ModbusPDUWriteSingleRegisterRequest");
    // Create the instance
    return new ModbusPDUWriteSingleRegisterRequestBuilderImpl(address, value);
  }

  public static class ModbusPDUWriteSingleRegisterRequestBuilderImpl
      implements ModbusPDU.ModbusPDUBuilder {
    private final int address;
    private final int value;

    public ModbusPDUWriteSingleRegisterRequestBuilderImpl(int address, int value) {

      this.address = address;
      this.value = value;
    }

    public ModbusPDUWriteSingleRegisterRequest build() {
      ModbusPDUWriteSingleRegisterRequest modbusPDUWriteSingleRegisterRequest =
          new ModbusPDUWriteSingleRegisterRequest(address, value);
      return modbusPDUWriteSingleRegisterRequest;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ModbusPDUWriteSingleRegisterRequest)) {
      return false;
    }
    ModbusPDUWriteSingleRegisterRequest that = (ModbusPDUWriteSingleRegisterRequest) o;
    return (getAddress() == that.getAddress())
        && (getValue() == that.getValue())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getAddress(), getValue());
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
