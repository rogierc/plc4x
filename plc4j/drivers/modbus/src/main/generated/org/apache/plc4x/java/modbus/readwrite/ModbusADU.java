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

public abstract class ModbusADU implements Message {

  // Abstract accessors for discriminator values.
  public abstract DriverType getDriverType();

  // Arguments.
  protected final Boolean response;

  public ModbusADU(Boolean response) {
    super();
    this.response = response;
  }

  protected abstract void serializeModbusADUChild(WriteBuffer writeBuffer)
      throws SerializationException;

  public void serialize(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("ModbusADU");

    // Switch field (Serialize the sub-type)
    serializeModbusADUChild(writeBuffer);

    writeBuffer.popContext("ModbusADU");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = 0;
    ModbusADU _value = this;

    // Length of sub-type elements will be added by sub-type...

    return lengthInBits;
  }

  public static ModbusADU staticParse(ReadBuffer readBuffer, Object... args) throws ParseException {
    PositionAware positionAware = readBuffer;
    if ((args == null) || (args.length != 2)) {
      throw new PlcRuntimeException(
          "Wrong number of arguments, expected 2, but got " + args.length);
    }
    DriverType driverType;
    if (args[0] instanceof DriverType) {
      driverType = (DriverType) args[0];
    } else if (args[0] instanceof String) {
      driverType = DriverType.valueOf((String) args[0]);
    } else {
      throw new PlcRuntimeException(
          "Argument 0 expected to be of type DriverType or a string which is parseable but was "
              + args[0].getClass().getName());
    }
    Boolean response;
    if (args[1] instanceof Boolean) {
      response = (Boolean) args[1];
    } else if (args[1] instanceof String) {
      response = Boolean.valueOf((String) args[1]);
    } else {
      throw new PlcRuntimeException(
          "Argument 1 expected to be of type Boolean or a string which is parseable but was "
              + args[1].getClass().getName());
    }
    return staticParse(readBuffer, driverType, response);
  }

  public static ModbusADU staticParse(
      ReadBuffer readBuffer, DriverType driverType, Boolean response) throws ParseException {
    readBuffer.pullContext("ModbusADU");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    // Switch Field (Depending on the discriminator values, passes the instantiation to a sub-type)
    ModbusADUBuilder builder = null;
    if (EvaluationHelper.equals(driverType, DriverType.MODBUS_TCP)) {
      builder = ModbusTcpADU.staticParseModbusADUBuilder(readBuffer, driverType, response);
    } else if (EvaluationHelper.equals(driverType, DriverType.MODBUS_RTU)) {
      builder = ModbusRtuADU.staticParseModbusADUBuilder(readBuffer, driverType, response);
    } else if (EvaluationHelper.equals(driverType, DriverType.MODBUS_ASCII)) {
      builder = ModbusAsciiADU.staticParseModbusADUBuilder(readBuffer, driverType, response);
    }
    if (builder == null) {
      throw new ParseException(
          "Unsupported case for discriminated type"
              + " parameters ["
              + "driverType="
              + driverType
              + "]");
    }

    readBuffer.closeContext("ModbusADU");
    // Create the instance
    ModbusADU _modbusADU = builder.build(response);

    return _modbusADU;
  }

  public interface ModbusADUBuilder {
    ModbusADU build(Boolean response);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ModbusADU)) {
      return false;
    }
    ModbusADU that = (ModbusADU) o;
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash();
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
