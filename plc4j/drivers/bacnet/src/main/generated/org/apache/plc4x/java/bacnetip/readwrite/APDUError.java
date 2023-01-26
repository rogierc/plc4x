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
package org.apache.plc4x.java.bacnetip.readwrite;

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

public class APDUError extends APDU implements Message {

  // Accessors for discriminator values.
  public ApduType getApduType() {
    return ApduType.ERROR_PDU;
  }

  // Properties.
  protected final short originalInvokeId;
  protected final BACnetConfirmedServiceChoice errorChoice;
  protected final BACnetError error;

  // Arguments.
  protected final Integer apduLength;
  // Reserved Fields
  private Byte reservedField0;

  public APDUError(
      short originalInvokeId,
      BACnetConfirmedServiceChoice errorChoice,
      BACnetError error,
      Integer apduLength) {
    super(apduLength);
    this.originalInvokeId = originalInvokeId;
    this.errorChoice = errorChoice;
    this.error = error;
    this.apduLength = apduLength;
  }

  public short getOriginalInvokeId() {
    return originalInvokeId;
  }

  public BACnetConfirmedServiceChoice getErrorChoice() {
    return errorChoice;
  }

  public BACnetError getError() {
    return error;
  }

  @Override
  protected void serializeAPDUChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("APDUError");

    // Reserved Field (reserved)
    writeReservedField(
        "reserved",
        reservedField0 != null ? reservedField0 : (byte) 0x00,
        writeUnsignedByte(writeBuffer, 4));

    // Simple Field (originalInvokeId)
    writeSimpleField("originalInvokeId", originalInvokeId, writeUnsignedShort(writeBuffer, 8));

    // Simple Field (errorChoice)
    writeSimpleEnumField(
        "errorChoice",
        "BACnetConfirmedServiceChoice",
        errorChoice,
        new DataWriterEnumDefault<>(
            BACnetConfirmedServiceChoice::getValue,
            BACnetConfirmedServiceChoice::name,
            writeUnsignedShort(writeBuffer, 8)));

    // Simple Field (error)
    writeSimpleField("error", error, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("APDUError");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    APDUError _value = this;

    // Reserved Field (reserved)
    lengthInBits += 4;

    // Simple field (originalInvokeId)
    lengthInBits += 8;

    // Simple field (errorChoice)
    lengthInBits += 8;

    // Simple field (error)
    lengthInBits += error.getLengthInBits();

    return lengthInBits;
  }

  public static APDUBuilder staticParseAPDUBuilder(ReadBuffer readBuffer, Integer apduLength)
      throws ParseException {
    readBuffer.pullContext("APDUError");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    Byte reservedField0 =
        readReservedField("reserved", readUnsignedByte(readBuffer, 4), (byte) 0x00);

    short originalInvokeId = readSimpleField("originalInvokeId", readUnsignedShort(readBuffer, 8));

    BACnetConfirmedServiceChoice errorChoice =
        readEnumField(
            "errorChoice",
            "BACnetConfirmedServiceChoice",
            new DataReaderEnumDefault<>(
                BACnetConfirmedServiceChoice::enumForValue, readUnsignedShort(readBuffer, 8)));

    BACnetError error =
        readSimpleField(
            "error",
            new DataReaderComplexDefault<>(
                () ->
                    BACnetError.staticParse(
                        readBuffer, (BACnetConfirmedServiceChoice) (errorChoice)),
                readBuffer));

    readBuffer.closeContext("APDUError");
    // Create the instance
    return new APDUErrorBuilderImpl(
        originalInvokeId, errorChoice, error, apduLength, reservedField0);
  }

  public static class APDUErrorBuilderImpl implements APDU.APDUBuilder {
    private final short originalInvokeId;
    private final BACnetConfirmedServiceChoice errorChoice;
    private final BACnetError error;
    private final Integer apduLength;
    private final Byte reservedField0;

    public APDUErrorBuilderImpl(
        short originalInvokeId,
        BACnetConfirmedServiceChoice errorChoice,
        BACnetError error,
        Integer apduLength,
        Byte reservedField0) {
      this.originalInvokeId = originalInvokeId;
      this.errorChoice = errorChoice;
      this.error = error;
      this.apduLength = apduLength;
      this.reservedField0 = reservedField0;
    }

    public APDUError build(Integer apduLength) {

      APDUError aPDUError = new APDUError(originalInvokeId, errorChoice, error, apduLength);
      aPDUError.reservedField0 = reservedField0;
      return aPDUError;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof APDUError)) {
      return false;
    }
    APDUError that = (APDUError) o;
    return (getOriginalInvokeId() == that.getOriginalInvokeId())
        && (getErrorChoice() == that.getErrorChoice())
        && (getError() == that.getError())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getOriginalInvokeId(), getErrorChoice(), getError());
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
