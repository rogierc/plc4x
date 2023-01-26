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

public class BACnetConstructedDataOperationExpected extends BACnetConstructedData
    implements Message {

  // Accessors for discriminator values.
  public BACnetObjectType getObjectTypeArgument() {
    return null;
  }

  public BACnetPropertyIdentifier getPropertyIdentifierArgument() {
    return BACnetPropertyIdentifier.OPERATION_EXPECTED;
  }

  // Properties.
  protected final BACnetLifeSafetyOperationTagged lifeSafetyOperations;

  // Arguments.
  protected final Short tagNumber;
  protected final BACnetTagPayloadUnsignedInteger arrayIndexArgument;

  public BACnetConstructedDataOperationExpected(
      BACnetOpeningTag openingTag,
      BACnetTagHeader peekedTagHeader,
      BACnetClosingTag closingTag,
      BACnetLifeSafetyOperationTagged lifeSafetyOperations,
      Short tagNumber,
      BACnetTagPayloadUnsignedInteger arrayIndexArgument) {
    super(openingTag, peekedTagHeader, closingTag, tagNumber, arrayIndexArgument);
    this.lifeSafetyOperations = lifeSafetyOperations;
    this.tagNumber = tagNumber;
    this.arrayIndexArgument = arrayIndexArgument;
  }

  public BACnetLifeSafetyOperationTagged getLifeSafetyOperations() {
    return lifeSafetyOperations;
  }

  public BACnetLifeSafetyOperationTagged getActualValue() {
    return (BACnetLifeSafetyOperationTagged) (getLifeSafetyOperations());
  }

  @Override
  protected void serializeBACnetConstructedDataChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetConstructedDataOperationExpected");

    // Simple Field (lifeSafetyOperations)
    writeSimpleField(
        "lifeSafetyOperations", lifeSafetyOperations, new DataWriterComplexDefault<>(writeBuffer));

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    BACnetLifeSafetyOperationTagged actualValue = getActualValue();
    writeBuffer.writeVirtual("actualValue", actualValue);

    writeBuffer.popContext("BACnetConstructedDataOperationExpected");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    BACnetConstructedDataOperationExpected _value = this;

    // Simple field (lifeSafetyOperations)
    lengthInBits += lifeSafetyOperations.getLengthInBits();

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
    readBuffer.pullContext("BACnetConstructedDataOperationExpected");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    BACnetLifeSafetyOperationTagged lifeSafetyOperations =
        readSimpleField(
            "lifeSafetyOperations",
            new DataReaderComplexDefault<>(
                () ->
                    BACnetLifeSafetyOperationTagged.staticParse(
                        readBuffer, (short) (0), (TagClass) (TagClass.APPLICATION_TAGS)),
                readBuffer));
    BACnetLifeSafetyOperationTagged actualValue =
        readVirtualField(
            "actualValue", BACnetLifeSafetyOperationTagged.class, lifeSafetyOperations);

    readBuffer.closeContext("BACnetConstructedDataOperationExpected");
    // Create the instance
    return new BACnetConstructedDataOperationExpectedBuilderImpl(
        lifeSafetyOperations, tagNumber, arrayIndexArgument);
  }

  public static class BACnetConstructedDataOperationExpectedBuilderImpl
      implements BACnetConstructedData.BACnetConstructedDataBuilder {
    private final BACnetLifeSafetyOperationTagged lifeSafetyOperations;
    private final Short tagNumber;
    private final BACnetTagPayloadUnsignedInteger arrayIndexArgument;

    public BACnetConstructedDataOperationExpectedBuilderImpl(
        BACnetLifeSafetyOperationTagged lifeSafetyOperations,
        Short tagNumber,
        BACnetTagPayloadUnsignedInteger arrayIndexArgument) {

      this.lifeSafetyOperations = lifeSafetyOperations;
      this.tagNumber = tagNumber;
      this.arrayIndexArgument = arrayIndexArgument;
    }

    public BACnetConstructedDataOperationExpected build(
        BACnetOpeningTag openingTag,
        BACnetTagHeader peekedTagHeader,
        BACnetClosingTag closingTag,
        Short tagNumber,
        BACnetTagPayloadUnsignedInteger arrayIndexArgument) {
      BACnetConstructedDataOperationExpected bACnetConstructedDataOperationExpected =
          new BACnetConstructedDataOperationExpected(
              openingTag,
              peekedTagHeader,
              closingTag,
              lifeSafetyOperations,
              tagNumber,
              arrayIndexArgument);
      return bACnetConstructedDataOperationExpected;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetConstructedDataOperationExpected)) {
      return false;
    }
    BACnetConstructedDataOperationExpected that = (BACnetConstructedDataOperationExpected) o;
    return (getLifeSafetyOperations() == that.getLifeSafetyOperations())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getLifeSafetyOperations());
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
