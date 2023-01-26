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

public class RequestDirectCommandAccess extends Request implements Message {

  // Accessors for discriminator values.

  // Constant values.
  public static final Byte AT = 0x40;

  // Properties.
  protected final CALData calData;
  protected final Alpha alpha;

  // Arguments.
  protected final CBusOptions cBusOptions;

  public RequestDirectCommandAccess(
      RequestType peekedByte,
      RequestType startingCR,
      RequestType resetMode,
      RequestType secondPeek,
      RequestTermination termination,
      CALData calData,
      Alpha alpha,
      CBusOptions cBusOptions) {
    super(peekedByte, startingCR, resetMode, secondPeek, termination, cBusOptions);
    this.calData = calData;
    this.alpha = alpha;
    this.cBusOptions = cBusOptions;
  }

  public CALData getCalData() {
    return calData;
  }

  public Alpha getAlpha() {
    return alpha;
  }

  public CALData getCalDataDecoded() {
    return (CALData) (getCalData());
  }

  public byte getAt() {
    return AT;
  }

  @Override
  protected void serializeRequestChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("RequestDirectCommandAccess");

    // Const Field (at)
    writeConstField("at", AT, writeByte(writeBuffer, 8));

    // Manual Field (calData)
    writeManualField(
        "calData",
        () ->
            org.apache.plc4x.java.cbus.readwrite.utils.StaticHelper.writeCALData(
                writeBuffer, calData),
        writeBuffer);

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    CALData calDataDecoded = getCalDataDecoded();
    writeBuffer.writeVirtual("calDataDecoded", calDataDecoded);

    // Optional Field (alpha) (Can be skipped, if the value is null)
    writeOptionalField("alpha", alpha, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("RequestDirectCommandAccess");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    RequestDirectCommandAccess _value = this;

    // Const Field (at)
    lengthInBits += 8;

    // Manual Field (calData)
    lengthInBits += (((calData.getLengthInBytes()) * (2))) * (8);

    // A virtual field doesn't have any in- or output.

    // Optional Field (alpha)
    if (alpha != null) {
      lengthInBits += alpha.getLengthInBits();
    }

    return lengthInBits;
  }

  public static RequestBuilder staticParseRequestBuilder(
      ReadBuffer readBuffer, CBusOptions cBusOptions) throws ParseException {
    readBuffer.pullContext("RequestDirectCommandAccess");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    byte at = readConstField("at", readByte(readBuffer, 8), RequestDirectCommandAccess.AT);

    CALData calData =
        readManualField(
            "calData",
            readBuffer,
            () ->
                (CALData)
                    (org.apache.plc4x.java.cbus.readwrite.utils.StaticHelper.readCALData(
                        readBuffer)));
    CALData calDataDecoded = readVirtualField("calDataDecoded", CALData.class, calData);

    Alpha alpha =
        readOptionalField(
            "alpha",
            new DataReaderComplexDefault<>(() -> Alpha.staticParse(readBuffer), readBuffer));

    readBuffer.closeContext("RequestDirectCommandAccess");
    // Create the instance
    return new RequestDirectCommandAccessBuilderImpl(calData, alpha, cBusOptions);
  }

  public static class RequestDirectCommandAccessBuilderImpl implements Request.RequestBuilder {
    private final CALData calData;
    private final Alpha alpha;
    private final CBusOptions cBusOptions;

    public RequestDirectCommandAccessBuilderImpl(
        CALData calData, Alpha alpha, CBusOptions cBusOptions) {

      this.calData = calData;
      this.alpha = alpha;
      this.cBusOptions = cBusOptions;
    }

    public RequestDirectCommandAccess build(
        RequestType peekedByte,
        RequestType startingCR,
        RequestType resetMode,
        RequestType secondPeek,
        RequestTermination termination,
        CBusOptions cBusOptions) {
      RequestDirectCommandAccess requestDirectCommandAccess =
          new RequestDirectCommandAccess(
              peekedByte,
              startingCR,
              resetMode,
              secondPeek,
              termination,
              calData,
              alpha,
              cBusOptions);
      return requestDirectCommandAccess;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RequestDirectCommandAccess)) {
      return false;
    }
    RequestDirectCommandAccess that = (RequestDirectCommandAccess) o;
    return (getCalData() == that.getCalData())
        && (getAlpha() == that.getAlpha())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getCalData(), getAlpha());
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
