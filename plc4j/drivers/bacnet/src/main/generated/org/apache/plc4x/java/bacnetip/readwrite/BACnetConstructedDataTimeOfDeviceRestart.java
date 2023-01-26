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

public class BACnetConstructedDataTimeOfDeviceRestart extends BACnetConstructedData
    implements Message {

  // Accessors for discriminator values.
  public BACnetObjectType getObjectTypeArgument() {
    return null;
  }

  public BACnetPropertyIdentifier getPropertyIdentifierArgument() {
    return BACnetPropertyIdentifier.TIME_OF_DEVICE_RESTART;
  }

  // Properties.
  protected final BACnetTimeStamp timeOfDeviceRestart;

  // Arguments.
  protected final Short tagNumber;
  protected final BACnetTagPayloadUnsignedInteger arrayIndexArgument;

  public BACnetConstructedDataTimeOfDeviceRestart(
      BACnetOpeningTag openingTag,
      BACnetTagHeader peekedTagHeader,
      BACnetClosingTag closingTag,
      BACnetTimeStamp timeOfDeviceRestart,
      Short tagNumber,
      BACnetTagPayloadUnsignedInteger arrayIndexArgument) {
    super(openingTag, peekedTagHeader, closingTag, tagNumber, arrayIndexArgument);
    this.timeOfDeviceRestart = timeOfDeviceRestart;
    this.tagNumber = tagNumber;
    this.arrayIndexArgument = arrayIndexArgument;
  }

  public BACnetTimeStamp getTimeOfDeviceRestart() {
    return timeOfDeviceRestart;
  }

  public BACnetTimeStamp getActualValue() {
    return (BACnetTimeStamp) (getTimeOfDeviceRestart());
  }

  @Override
  protected void serializeBACnetConstructedDataChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetConstructedDataTimeOfDeviceRestart");

    // Simple Field (timeOfDeviceRestart)
    writeSimpleField(
        "timeOfDeviceRestart", timeOfDeviceRestart, new DataWriterComplexDefault<>(writeBuffer));

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    BACnetTimeStamp actualValue = getActualValue();
    writeBuffer.writeVirtual("actualValue", actualValue);

    writeBuffer.popContext("BACnetConstructedDataTimeOfDeviceRestart");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    BACnetConstructedDataTimeOfDeviceRestart _value = this;

    // Simple field (timeOfDeviceRestart)
    lengthInBits += timeOfDeviceRestart.getLengthInBits();

    // A virtual field doesn't have any in- or output.

    return lengthInBits;
  }

  public static BACnetConstructedDataBuilder staticParseBACnetConstructedDataBuilder(
      ReadBuffer readBuffer,
      Short tagNumber,
      BACnetObjectType objectTypeArgument,
      BACnetPropertyIdentifier propertyIdentifierArgument,
      BACnetTagPayloadUnsignedInteger arrayIndexArgument)
      throws ParseException {
    readBuffer.pullContext("BACnetConstructedDataTimeOfDeviceRestart");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    BACnetTimeStamp timeOfDeviceRestart =
        readSimpleField(
            "timeOfDeviceRestart",
            new DataReaderComplexDefault<>(
                () -> BACnetTimeStamp.staticParse(readBuffer), readBuffer));
    BACnetTimeStamp actualValue =
        readVirtualField("actualValue", BACnetTimeStamp.class, timeOfDeviceRestart);

    readBuffer.closeContext("BACnetConstructedDataTimeOfDeviceRestart");
    // Create the instance
    return new BACnetConstructedDataTimeOfDeviceRestartBuilderImpl(
        timeOfDeviceRestart, tagNumber, arrayIndexArgument);
  }

  public static class BACnetConstructedDataTimeOfDeviceRestartBuilderImpl
      implements BACnetConstructedData.BACnetConstructedDataBuilder {
    private final BACnetTimeStamp timeOfDeviceRestart;
    private final Short tagNumber;
    private final BACnetTagPayloadUnsignedInteger arrayIndexArgument;

    public BACnetConstructedDataTimeOfDeviceRestartBuilderImpl(
        BACnetTimeStamp timeOfDeviceRestart,
        Short tagNumber,
        BACnetTagPayloadUnsignedInteger arrayIndexArgument) {

      this.timeOfDeviceRestart = timeOfDeviceRestart;
      this.tagNumber = tagNumber;
      this.arrayIndexArgument = arrayIndexArgument;
    }

    public BACnetConstructedDataTimeOfDeviceRestart build(
        BACnetOpeningTag openingTag,
        BACnetTagHeader peekedTagHeader,
        BACnetClosingTag closingTag,
        Short tagNumber,
        BACnetTagPayloadUnsignedInteger arrayIndexArgument) {
      BACnetConstructedDataTimeOfDeviceRestart bACnetConstructedDataTimeOfDeviceRestart =
          new BACnetConstructedDataTimeOfDeviceRestart(
              openingTag,
              peekedTagHeader,
              closingTag,
              timeOfDeviceRestart,
              tagNumber,
              arrayIndexArgument);
      return bACnetConstructedDataTimeOfDeviceRestart;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetConstructedDataTimeOfDeviceRestart)) {
      return false;
    }
    BACnetConstructedDataTimeOfDeviceRestart that = (BACnetConstructedDataTimeOfDeviceRestart) o;
    return (getTimeOfDeviceRestart() == that.getTimeOfDeviceRestart())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getTimeOfDeviceRestart());
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
