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
package org.apache.plc4x.java.profinet.readwrite;

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

public abstract class DceRpc_InterfaceUuid implements Message {

  // Abstract accessors for discriminator values.
  public abstract Long getInterfaceType();

  // Constant values.
  public static final Integer DATA1 = 0x6C97;
  public static final Integer DATA2 = 0x11D1;
  public static final Integer DATA3 = 0x8271;
  public static final Integer DATA4 = 0x00A0;
  public static final Integer DATA5 = 0x2442;
  public static final Integer DATA6 = 0xDF7D;

  public DceRpc_InterfaceUuid() {
    super();
  }

  public int getData1() {
    return DATA1;
  }

  public int getData2() {
    return DATA2;
  }

  public int getData3() {
    return DATA3;
  }

  public int getData4() {
    return DATA4;
  }

  public int getData5() {
    return DATA5;
  }

  public int getData6() {
    return DATA6;
  }

  protected abstract void serializeDceRpc_InterfaceUuidChild(WriteBuffer writeBuffer)
      throws SerializationException;

  public void serialize(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("DceRpc_InterfaceUuid");

    // Discriminator Field (interfaceType) (Used as input to a switch field)
    writeDiscriminatorField(
        "interfaceType", getInterfaceType(), writeUnsignedLong(writeBuffer, 32));

    // Const Field (data1)
    writeConstField("data1", DATA1, writeUnsignedInt(writeBuffer, 16));

    // Const Field (data2)
    writeConstField("data2", DATA2, writeUnsignedInt(writeBuffer, 16));

    // Const Field (data3)
    writeConstField(
        "data3",
        DATA3,
        writeUnsignedInt(writeBuffer, 16),
        WithOption.WithByteOrder(ByteOrder.BIG_ENDIAN));

    // Const Field (data4)
    writeConstField(
        "data4",
        DATA4,
        writeUnsignedInt(writeBuffer, 16),
        WithOption.WithByteOrder(ByteOrder.BIG_ENDIAN));

    // Const Field (data5)
    writeConstField(
        "data5",
        DATA5,
        writeUnsignedInt(writeBuffer, 16),
        WithOption.WithByteOrder(ByteOrder.BIG_ENDIAN));

    // Const Field (data6)
    writeConstField(
        "data6",
        DATA6,
        writeUnsignedInt(writeBuffer, 16),
        WithOption.WithByteOrder(ByteOrder.BIG_ENDIAN));

    // Switch field (Serialize the sub-type)
    serializeDceRpc_InterfaceUuidChild(writeBuffer);

    writeBuffer.popContext("DceRpc_InterfaceUuid");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = 0;
    DceRpc_InterfaceUuid _value = this;

    // Discriminator Field (interfaceType)
    lengthInBits += 32;

    // Const Field (data1)
    lengthInBits += 16;

    // Const Field (data2)
    lengthInBits += 16;

    // Const Field (data3)
    lengthInBits += 16;

    // Const Field (data4)
    lengthInBits += 16;

    // Const Field (data5)
    lengthInBits += 16;

    // Const Field (data6)
    lengthInBits += 16;

    // Length of sub-type elements will be added by sub-type...

    return lengthInBits;
  }

  public static DceRpc_InterfaceUuid staticParse(ReadBuffer readBuffer, Object... args)
      throws ParseException {
    PositionAware positionAware = readBuffer;
    return staticParse(readBuffer);
  }

  public static DceRpc_InterfaceUuid staticParse(ReadBuffer readBuffer) throws ParseException {
    readBuffer.pullContext("DceRpc_InterfaceUuid");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    long interfaceType = readDiscriminatorField("interfaceType", readUnsignedLong(readBuffer, 32));

    int data1 =
        readConstField("data1", readUnsignedInt(readBuffer, 16), DceRpc_InterfaceUuid.DATA1);

    int data2 =
        readConstField("data2", readUnsignedInt(readBuffer, 16), DceRpc_InterfaceUuid.DATA2);

    int data3 =
        readConstField(
            "data3",
            readUnsignedInt(readBuffer, 16),
            DceRpc_InterfaceUuid.DATA3,
            WithOption.WithByteOrder(ByteOrder.BIG_ENDIAN));

    int data4 =
        readConstField(
            "data4",
            readUnsignedInt(readBuffer, 16),
            DceRpc_InterfaceUuid.DATA4,
            WithOption.WithByteOrder(ByteOrder.BIG_ENDIAN));

    int data5 =
        readConstField(
            "data5",
            readUnsignedInt(readBuffer, 16),
            DceRpc_InterfaceUuid.DATA5,
            WithOption.WithByteOrder(ByteOrder.BIG_ENDIAN));

    int data6 =
        readConstField(
            "data6",
            readUnsignedInt(readBuffer, 16),
            DceRpc_InterfaceUuid.DATA6,
            WithOption.WithByteOrder(ByteOrder.BIG_ENDIAN));

    // Switch Field (Depending on the discriminator values, passes the instantiation to a sub-type)
    DceRpc_InterfaceUuidBuilder builder = null;
    if (EvaluationHelper.equals(interfaceType, (long) 0xDEA00001L)) {
      builder =
          DceRpc_InterfaceUuid_DeviceInterface.staticParseDceRpc_InterfaceUuidBuilder(readBuffer);
    } else if (EvaluationHelper.equals(interfaceType, (long) 0xDEA00002L)) {
      builder =
          DceRpc_InterfaceUuid_ControllerInterface.staticParseDceRpc_InterfaceUuidBuilder(
              readBuffer);
    } else if (EvaluationHelper.equals(interfaceType, (long) 0xDEA00003L)) {
      builder =
          DceRpc_InterfaceUuid_SupervisorInterface.staticParseDceRpc_InterfaceUuidBuilder(
              readBuffer);
    } else if (EvaluationHelper.equals(interfaceType, (long) 0xDEA00004L)) {
      builder =
          DceRpc_InterfaceUuid_ParameterInterface.staticParseDceRpc_InterfaceUuidBuilder(
              readBuffer);
    }
    if (builder == null) {
      throw new ParseException(
          "Unsupported case for discriminated type"
              + " parameters ["
              + "interfaceType="
              + interfaceType
              + "]");
    }

    readBuffer.closeContext("DceRpc_InterfaceUuid");
    // Create the instance
    DceRpc_InterfaceUuid _dceRpc_InterfaceUuid = builder.build();
    return _dceRpc_InterfaceUuid;
  }

  public interface DceRpc_InterfaceUuidBuilder {
    DceRpc_InterfaceUuid build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DceRpc_InterfaceUuid)) {
      return false;
    }
    DceRpc_InterfaceUuid that = (DceRpc_InterfaceUuid) o;
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
