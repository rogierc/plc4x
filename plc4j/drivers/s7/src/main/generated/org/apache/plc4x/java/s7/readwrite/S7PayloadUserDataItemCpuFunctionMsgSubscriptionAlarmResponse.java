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

public class S7PayloadUserDataItemCpuFunctionMsgSubscriptionAlarmResponse
    extends S7PayloadUserDataItem implements Message {

  // Accessors for discriminator values.
  public Byte getCpuFunctionType() {
    return (byte) 0x08;
  }

  public Short getCpuSubfunction() {
    return (short) 0x02;
  }

  public Integer getDataLength() {
    return (int) 0x05;
  }

  // Properties.
  protected final short result;
  protected final short reserved01;
  protected final AlarmType alarmType;
  protected final short reserved02;
  protected final short reserved03;

  public S7PayloadUserDataItemCpuFunctionMsgSubscriptionAlarmResponse(
      DataTransportErrorCode returnCode,
      DataTransportSize transportSize,
      short result,
      short reserved01,
      AlarmType alarmType,
      short reserved02,
      short reserved03) {
    super(returnCode, transportSize);
    this.result = result;
    this.reserved01 = reserved01;
    this.alarmType = alarmType;
    this.reserved02 = reserved02;
    this.reserved03 = reserved03;
  }

  public short getResult() {
    return result;
  }

  public short getReserved01() {
    return reserved01;
  }

  public AlarmType getAlarmType() {
    return alarmType;
  }

  public short getReserved02() {
    return reserved02;
  }

  public short getReserved03() {
    return reserved03;
  }

  @Override
  protected void serializeS7PayloadUserDataItemChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("S7PayloadUserDataItemCpuFunctionMsgSubscriptionAlarmResponse");

    // Simple Field (result)
    writeSimpleField("result", result, writeUnsignedShort(writeBuffer, 8));

    // Simple Field (reserved01)
    writeSimpleField("reserved01", reserved01, writeUnsignedShort(writeBuffer, 8));

    // Simple Field (alarmType)
    writeSimpleEnumField(
        "alarmType",
        "AlarmType",
        alarmType,
        new DataWriterEnumDefault<>(
            AlarmType::getValue, AlarmType::name, writeUnsignedShort(writeBuffer, 8)));

    // Simple Field (reserved02)
    writeSimpleField("reserved02", reserved02, writeUnsignedShort(writeBuffer, 8));

    // Simple Field (reserved03)
    writeSimpleField("reserved03", reserved03, writeUnsignedShort(writeBuffer, 8));

    writeBuffer.popContext("S7PayloadUserDataItemCpuFunctionMsgSubscriptionAlarmResponse");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    S7PayloadUserDataItemCpuFunctionMsgSubscriptionAlarmResponse _value = this;

    // Simple field (result)
    lengthInBits += 8;

    // Simple field (reserved01)
    lengthInBits += 8;

    // Simple field (alarmType)
    lengthInBits += 8;

    // Simple field (reserved02)
    lengthInBits += 8;

    // Simple field (reserved03)
    lengthInBits += 8;

    return lengthInBits;
  }

  public static S7PayloadUserDataItemBuilder staticParseS7PayloadUserDataItemBuilder(
      ReadBuffer readBuffer, Byte cpuFunctionType, Short cpuSubfunction) throws ParseException {
    readBuffer.pullContext("S7PayloadUserDataItemCpuFunctionMsgSubscriptionAlarmResponse");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    short result = readSimpleField("result", readUnsignedShort(readBuffer, 8));

    short reserved01 = readSimpleField("reserved01", readUnsignedShort(readBuffer, 8));

    AlarmType alarmType =
        readEnumField(
            "alarmType",
            "AlarmType",
            new DataReaderEnumDefault<>(AlarmType::enumForValue, readUnsignedShort(readBuffer, 8)));

    short reserved02 = readSimpleField("reserved02", readUnsignedShort(readBuffer, 8));

    short reserved03 = readSimpleField("reserved03", readUnsignedShort(readBuffer, 8));

    readBuffer.closeContext("S7PayloadUserDataItemCpuFunctionMsgSubscriptionAlarmResponse");
    // Create the instance
    return new S7PayloadUserDataItemCpuFunctionMsgSubscriptionAlarmResponseBuilderImpl(
        result, reserved01, alarmType, reserved02, reserved03);
  }

  public static class S7PayloadUserDataItemCpuFunctionMsgSubscriptionAlarmResponseBuilderImpl
      implements S7PayloadUserDataItem.S7PayloadUserDataItemBuilder {
    private final short result;
    private final short reserved01;
    private final AlarmType alarmType;
    private final short reserved02;
    private final short reserved03;

    public S7PayloadUserDataItemCpuFunctionMsgSubscriptionAlarmResponseBuilderImpl(
        short result, short reserved01, AlarmType alarmType, short reserved02, short reserved03) {

      this.result = result;
      this.reserved01 = reserved01;
      this.alarmType = alarmType;
      this.reserved02 = reserved02;
      this.reserved03 = reserved03;
    }

    public S7PayloadUserDataItemCpuFunctionMsgSubscriptionAlarmResponse build(
        DataTransportErrorCode returnCode, DataTransportSize transportSize) {
      S7PayloadUserDataItemCpuFunctionMsgSubscriptionAlarmResponse
          s7PayloadUserDataItemCpuFunctionMsgSubscriptionAlarmResponse =
              new S7PayloadUserDataItemCpuFunctionMsgSubscriptionAlarmResponse(
                  returnCode, transportSize, result, reserved01, alarmType, reserved02, reserved03);
      return s7PayloadUserDataItemCpuFunctionMsgSubscriptionAlarmResponse;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof S7PayloadUserDataItemCpuFunctionMsgSubscriptionAlarmResponse)) {
      return false;
    }
    S7PayloadUserDataItemCpuFunctionMsgSubscriptionAlarmResponse that =
        (S7PayloadUserDataItemCpuFunctionMsgSubscriptionAlarmResponse) o;
    return (getResult() == that.getResult())
        && (getReserved01() == that.getReserved01())
        && (getAlarmType() == that.getAlarmType())
        && (getReserved02() == that.getReserved02())
        && (getReserved03() == that.getReserved03())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(),
        getResult(),
        getReserved01(),
        getAlarmType(),
        getReserved02(),
        getReserved03());
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
