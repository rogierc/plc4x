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
package org.apache.plc4x.java.knxnetip.readwrite;

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

public class ApduDataExtPropertyDescriptionResponse extends ApduDataExt implements Message {

  // Accessors for discriminator values.
  public Short getExtApciType() {
    return (short) 0x19;
  }

  // Properties.
  protected final short objectIndex;
  protected final short propertyId;
  protected final short index;
  protected final boolean writeEnabled;
  protected final KnxPropertyDataType propertyDataType;
  protected final int maxNrOfElements;
  protected final AccessLevel readLevel;
  protected final AccessLevel writeLevel;

  // Arguments.
  protected final Short length;
  // Reserved Fields
  private Byte reservedField0;
  private Byte reservedField1;

  public ApduDataExtPropertyDescriptionResponse(
      short objectIndex,
      short propertyId,
      short index,
      boolean writeEnabled,
      KnxPropertyDataType propertyDataType,
      int maxNrOfElements,
      AccessLevel readLevel,
      AccessLevel writeLevel,
      Short length) {
    super(length);
    this.objectIndex = objectIndex;
    this.propertyId = propertyId;
    this.index = index;
    this.writeEnabled = writeEnabled;
    this.propertyDataType = propertyDataType;
    this.maxNrOfElements = maxNrOfElements;
    this.readLevel = readLevel;
    this.writeLevel = writeLevel;
    this.length = length;
  }

  public short getObjectIndex() {
    return objectIndex;
  }

  public short getPropertyId() {
    return propertyId;
  }

  public short getIndex() {
    return index;
  }

  public boolean getWriteEnabled() {
    return writeEnabled;
  }

  public KnxPropertyDataType getPropertyDataType() {
    return propertyDataType;
  }

  public int getMaxNrOfElements() {
    return maxNrOfElements;
  }

  public AccessLevel getReadLevel() {
    return readLevel;
  }

  public AccessLevel getWriteLevel() {
    return writeLevel;
  }

  @Override
  protected void serializeApduDataExtChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("ApduDataExtPropertyDescriptionResponse");

    // Simple Field (objectIndex)
    writeSimpleField("objectIndex", objectIndex, writeUnsignedShort(writeBuffer, 8));

    // Simple Field (propertyId)
    writeSimpleField("propertyId", propertyId, writeUnsignedShort(writeBuffer, 8));

    // Simple Field (index)
    writeSimpleField("index", index, writeUnsignedShort(writeBuffer, 8));

    // Simple Field (writeEnabled)
    writeSimpleField("writeEnabled", writeEnabled, writeBoolean(writeBuffer));

    // Reserved Field (reserved)
    writeReservedField(
        "reserved",
        reservedField0 != null ? reservedField0 : (byte) 0x0,
        writeUnsignedByte(writeBuffer, 1));

    // Simple Field (propertyDataType)
    writeSimpleEnumField(
        "propertyDataType",
        "KnxPropertyDataType",
        propertyDataType,
        new DataWriterEnumDefault<>(
            KnxPropertyDataType::getValue,
            KnxPropertyDataType::name,
            writeUnsignedShort(writeBuffer, 8)));

    // Reserved Field (reserved)
    writeReservedField(
        "reserved",
        reservedField1 != null ? reservedField1 : (byte) 0x0,
        writeUnsignedByte(writeBuffer, 4));

    // Simple Field (maxNrOfElements)
    writeSimpleField("maxNrOfElements", maxNrOfElements, writeUnsignedInt(writeBuffer, 12));

    // Simple Field (readLevel)
    writeSimpleEnumField(
        "readLevel",
        "AccessLevel",
        readLevel,
        new DataWriterEnumDefault<>(
            AccessLevel::getValue, AccessLevel::name, writeUnsignedByte(writeBuffer, 4)));

    // Simple Field (writeLevel)
    writeSimpleEnumField(
        "writeLevel",
        "AccessLevel",
        writeLevel,
        new DataWriterEnumDefault<>(
            AccessLevel::getValue, AccessLevel::name, writeUnsignedByte(writeBuffer, 4)));

    writeBuffer.popContext("ApduDataExtPropertyDescriptionResponse");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    ApduDataExtPropertyDescriptionResponse _value = this;

    // Simple field (objectIndex)
    lengthInBits += 8;

    // Simple field (propertyId)
    lengthInBits += 8;

    // Simple field (index)
    lengthInBits += 8;

    // Simple field (writeEnabled)
    lengthInBits += 1;

    // Reserved Field (reserved)
    lengthInBits += 1;

    // Simple field (propertyDataType)
    lengthInBits += 8;

    // Reserved Field (reserved)
    lengthInBits += 4;

    // Simple field (maxNrOfElements)
    lengthInBits += 12;

    // Simple field (readLevel)
    lengthInBits += 4;

    // Simple field (writeLevel)
    lengthInBits += 4;

    return lengthInBits;
  }

  public static ApduDataExtBuilder staticParseApduDataExtBuilder(
      ReadBuffer readBuffer, Short length) throws ParseException {
    readBuffer.pullContext("ApduDataExtPropertyDescriptionResponse");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    short objectIndex = readSimpleField("objectIndex", readUnsignedShort(readBuffer, 8));

    short propertyId = readSimpleField("propertyId", readUnsignedShort(readBuffer, 8));

    short index = readSimpleField("index", readUnsignedShort(readBuffer, 8));

    boolean writeEnabled = readSimpleField("writeEnabled", readBoolean(readBuffer));

    Byte reservedField0 =
        readReservedField("reserved", readUnsignedByte(readBuffer, 1), (byte) 0x0);

    KnxPropertyDataType propertyDataType =
        readEnumField(
            "propertyDataType",
            "KnxPropertyDataType",
            new DataReaderEnumDefault<>(
                KnxPropertyDataType::enumForValue, readUnsignedShort(readBuffer, 8)));

    Byte reservedField1 =
        readReservedField("reserved", readUnsignedByte(readBuffer, 4), (byte) 0x0);

    int maxNrOfElements = readSimpleField("maxNrOfElements", readUnsignedInt(readBuffer, 12));

    AccessLevel readLevel =
        readEnumField(
            "readLevel",
            "AccessLevel",
            new DataReaderEnumDefault<>(
                AccessLevel::enumForValue, readUnsignedByte(readBuffer, 4)));

    AccessLevel writeLevel =
        readEnumField(
            "writeLevel",
            "AccessLevel",
            new DataReaderEnumDefault<>(
                AccessLevel::enumForValue, readUnsignedByte(readBuffer, 4)));

    readBuffer.closeContext("ApduDataExtPropertyDescriptionResponse");
    // Create the instance
    return new ApduDataExtPropertyDescriptionResponseBuilderImpl(
        objectIndex,
        propertyId,
        index,
        writeEnabled,
        propertyDataType,
        maxNrOfElements,
        readLevel,
        writeLevel,
        length,
        reservedField0,
        reservedField1);
  }

  public static class ApduDataExtPropertyDescriptionResponseBuilderImpl
      implements ApduDataExt.ApduDataExtBuilder {
    private final short objectIndex;
    private final short propertyId;
    private final short index;
    private final boolean writeEnabled;
    private final KnxPropertyDataType propertyDataType;
    private final int maxNrOfElements;
    private final AccessLevel readLevel;
    private final AccessLevel writeLevel;
    private final Short length;
    private final Byte reservedField0;
    private final Byte reservedField1;

    public ApduDataExtPropertyDescriptionResponseBuilderImpl(
        short objectIndex,
        short propertyId,
        short index,
        boolean writeEnabled,
        KnxPropertyDataType propertyDataType,
        int maxNrOfElements,
        AccessLevel readLevel,
        AccessLevel writeLevel,
        Short length,
        Byte reservedField0,
        Byte reservedField1) {
      this.objectIndex = objectIndex;
      this.propertyId = propertyId;
      this.index = index;
      this.writeEnabled = writeEnabled;
      this.propertyDataType = propertyDataType;
      this.maxNrOfElements = maxNrOfElements;
      this.readLevel = readLevel;
      this.writeLevel = writeLevel;
      this.length = length;
      this.reservedField0 = reservedField0;
      this.reservedField1 = reservedField1;
    }

    public ApduDataExtPropertyDescriptionResponse build(Short length) {

      ApduDataExtPropertyDescriptionResponse apduDataExtPropertyDescriptionResponse =
          new ApduDataExtPropertyDescriptionResponse(
              objectIndex,
              propertyId,
              index,
              writeEnabled,
              propertyDataType,
              maxNrOfElements,
              readLevel,
              writeLevel,
              length);
      apduDataExtPropertyDescriptionResponse.reservedField0 = reservedField0;
      apduDataExtPropertyDescriptionResponse.reservedField1 = reservedField1;
      return apduDataExtPropertyDescriptionResponse;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ApduDataExtPropertyDescriptionResponse)) {
      return false;
    }
    ApduDataExtPropertyDescriptionResponse that = (ApduDataExtPropertyDescriptionResponse) o;
    return (getObjectIndex() == that.getObjectIndex())
        && (getPropertyId() == that.getPropertyId())
        && (getIndex() == that.getIndex())
        && (getWriteEnabled() == that.getWriteEnabled())
        && (getPropertyDataType() == that.getPropertyDataType())
        && (getMaxNrOfElements() == that.getMaxNrOfElements())
        && (getReadLevel() == that.getReadLevel())
        && (getWriteLevel() == that.getWriteLevel())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(),
        getObjectIndex(),
        getPropertyId(),
        getIndex(),
        getWriteEnabled(),
        getPropertyDataType(),
        getMaxNrOfElements(),
        getReadLevel(),
        getWriteLevel());
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
