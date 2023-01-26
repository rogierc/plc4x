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

public class BACnetFaultParameterFaultLifeSafety extends BACnetFaultParameter implements Message {

  // Accessors for discriminator values.

  // Properties.
  protected final BACnetOpeningTag openingTag;
  protected final BACnetFaultParameterFaultLifeSafetyListOfFaultValues listOfFaultValues;
  protected final BACnetDeviceObjectPropertyReferenceEnclosed modePropertyReference;
  protected final BACnetClosingTag closingTag;

  public BACnetFaultParameterFaultLifeSafety(
      BACnetTagHeader peekedTagHeader,
      BACnetOpeningTag openingTag,
      BACnetFaultParameterFaultLifeSafetyListOfFaultValues listOfFaultValues,
      BACnetDeviceObjectPropertyReferenceEnclosed modePropertyReference,
      BACnetClosingTag closingTag) {
    super(peekedTagHeader);
    this.openingTag = openingTag;
    this.listOfFaultValues = listOfFaultValues;
    this.modePropertyReference = modePropertyReference;
    this.closingTag = closingTag;
  }

  public BACnetOpeningTag getOpeningTag() {
    return openingTag;
  }

  public BACnetFaultParameterFaultLifeSafetyListOfFaultValues getListOfFaultValues() {
    return listOfFaultValues;
  }

  public BACnetDeviceObjectPropertyReferenceEnclosed getModePropertyReference() {
    return modePropertyReference;
  }

  public BACnetClosingTag getClosingTag() {
    return closingTag;
  }

  @Override
  protected void serializeBACnetFaultParameterChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetFaultParameterFaultLifeSafety");

    // Simple Field (openingTag)
    writeSimpleField("openingTag", openingTag, new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (listOfFaultValues)
    writeSimpleField(
        "listOfFaultValues", listOfFaultValues, new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (modePropertyReference)
    writeSimpleField(
        "modePropertyReference",
        modePropertyReference,
        new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (closingTag)
    writeSimpleField("closingTag", closingTag, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("BACnetFaultParameterFaultLifeSafety");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    BACnetFaultParameterFaultLifeSafety _value = this;

    // Simple field (openingTag)
    lengthInBits += openingTag.getLengthInBits();

    // Simple field (listOfFaultValues)
    lengthInBits += listOfFaultValues.getLengthInBits();

    // Simple field (modePropertyReference)
    lengthInBits += modePropertyReference.getLengthInBits();

    // Simple field (closingTag)
    lengthInBits += closingTag.getLengthInBits();

    return lengthInBits;
  }

  public static BACnetFaultParameterBuilder staticParseBACnetFaultParameterBuilder(
      ReadBuffer readBuffer) throws ParseException {
    readBuffer.pullContext("BACnetFaultParameterFaultLifeSafety");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    BACnetOpeningTag openingTag =
        readSimpleField(
            "openingTag",
            new DataReaderComplexDefault<>(
                () -> BACnetOpeningTag.staticParse(readBuffer, (short) (3)), readBuffer));

    BACnetFaultParameterFaultLifeSafetyListOfFaultValues listOfFaultValues =
        readSimpleField(
            "listOfFaultValues",
            new DataReaderComplexDefault<>(
                () ->
                    BACnetFaultParameterFaultLifeSafetyListOfFaultValues.staticParse(
                        readBuffer, (short) (0)),
                readBuffer));

    BACnetDeviceObjectPropertyReferenceEnclosed modePropertyReference =
        readSimpleField(
            "modePropertyReference",
            new DataReaderComplexDefault<>(
                () ->
                    BACnetDeviceObjectPropertyReferenceEnclosed.staticParse(
                        readBuffer, (short) (1)),
                readBuffer));

    BACnetClosingTag closingTag =
        readSimpleField(
            "closingTag",
            new DataReaderComplexDefault<>(
                () -> BACnetClosingTag.staticParse(readBuffer, (short) (3)), readBuffer));

    readBuffer.closeContext("BACnetFaultParameterFaultLifeSafety");
    // Create the instance
    return new BACnetFaultParameterFaultLifeSafetyBuilderImpl(
        openingTag, listOfFaultValues, modePropertyReference, closingTag);
  }

  public static class BACnetFaultParameterFaultLifeSafetyBuilderImpl
      implements BACnetFaultParameter.BACnetFaultParameterBuilder {
    private final BACnetOpeningTag openingTag;
    private final BACnetFaultParameterFaultLifeSafetyListOfFaultValues listOfFaultValues;
    private final BACnetDeviceObjectPropertyReferenceEnclosed modePropertyReference;
    private final BACnetClosingTag closingTag;

    public BACnetFaultParameterFaultLifeSafetyBuilderImpl(
        BACnetOpeningTag openingTag,
        BACnetFaultParameterFaultLifeSafetyListOfFaultValues listOfFaultValues,
        BACnetDeviceObjectPropertyReferenceEnclosed modePropertyReference,
        BACnetClosingTag closingTag) {

      this.openingTag = openingTag;
      this.listOfFaultValues = listOfFaultValues;
      this.modePropertyReference = modePropertyReference;
      this.closingTag = closingTag;
    }

    public BACnetFaultParameterFaultLifeSafety build(BACnetTagHeader peekedTagHeader) {
      BACnetFaultParameterFaultLifeSafety bACnetFaultParameterFaultLifeSafety =
          new BACnetFaultParameterFaultLifeSafety(
              peekedTagHeader, openingTag, listOfFaultValues, modePropertyReference, closingTag);
      return bACnetFaultParameterFaultLifeSafety;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetFaultParameterFaultLifeSafety)) {
      return false;
    }
    BACnetFaultParameterFaultLifeSafety that = (BACnetFaultParameterFaultLifeSafety) o;
    return (getOpeningTag() == that.getOpeningTag())
        && (getListOfFaultValues() == that.getListOfFaultValues())
        && (getModePropertyReference() == that.getModePropertyReference())
        && (getClosingTag() == that.getClosingTag())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(),
        getOpeningTag(),
        getListOfFaultValues(),
        getModePropertyReference(),
        getClosingTag());
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
