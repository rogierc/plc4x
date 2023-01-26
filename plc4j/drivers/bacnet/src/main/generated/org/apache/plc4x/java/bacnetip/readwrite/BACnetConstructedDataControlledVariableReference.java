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

public class BACnetConstructedDataControlledVariableReference extends BACnetConstructedData
    implements Message {

  // Accessors for discriminator values.
  public BACnetObjectType getObjectTypeArgument() {
    return null;
  }

  public BACnetPropertyIdentifier getPropertyIdentifierArgument() {
    return BACnetPropertyIdentifier.CONTROLLED_VARIABLE_REFERENCE;
  }

  // Properties.
  protected final BACnetObjectPropertyReference controlledVariableReference;

  // Arguments.
  protected final Short tagNumber;
  protected final BACnetTagPayloadUnsignedInteger arrayIndexArgument;

  public BACnetConstructedDataControlledVariableReference(
      BACnetOpeningTag openingTag,
      BACnetTagHeader peekedTagHeader,
      BACnetClosingTag closingTag,
      BACnetObjectPropertyReference controlledVariableReference,
      Short tagNumber,
      BACnetTagPayloadUnsignedInteger arrayIndexArgument) {
    super(openingTag, peekedTagHeader, closingTag, tagNumber, arrayIndexArgument);
    this.controlledVariableReference = controlledVariableReference;
    this.tagNumber = tagNumber;
    this.arrayIndexArgument = arrayIndexArgument;
  }

  public BACnetObjectPropertyReference getControlledVariableReference() {
    return controlledVariableReference;
  }

  public BACnetObjectPropertyReference getActualValue() {
    return (BACnetObjectPropertyReference) (getControlledVariableReference());
  }

  @Override
  protected void serializeBACnetConstructedDataChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetConstructedDataControlledVariableReference");

    // Simple Field (controlledVariableReference)
    writeSimpleField(
        "controlledVariableReference",
        controlledVariableReference,
        new DataWriterComplexDefault<>(writeBuffer));

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    BACnetObjectPropertyReference actualValue = getActualValue();
    writeBuffer.writeVirtual("actualValue", actualValue);

    writeBuffer.popContext("BACnetConstructedDataControlledVariableReference");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    BACnetConstructedDataControlledVariableReference _value = this;

    // Simple field (controlledVariableReference)
    lengthInBits += controlledVariableReference.getLengthInBits();

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
    readBuffer.pullContext("BACnetConstructedDataControlledVariableReference");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    BACnetObjectPropertyReference controlledVariableReference =
        readSimpleField(
            "controlledVariableReference",
            new DataReaderComplexDefault<>(
                () -> BACnetObjectPropertyReference.staticParse(readBuffer), readBuffer));
    BACnetObjectPropertyReference actualValue =
        readVirtualField(
            "actualValue", BACnetObjectPropertyReference.class, controlledVariableReference);

    readBuffer.closeContext("BACnetConstructedDataControlledVariableReference");
    // Create the instance
    return new BACnetConstructedDataControlledVariableReferenceBuilderImpl(
        controlledVariableReference, tagNumber, arrayIndexArgument);
  }

  public static class BACnetConstructedDataControlledVariableReferenceBuilderImpl
      implements BACnetConstructedData.BACnetConstructedDataBuilder {
    private final BACnetObjectPropertyReference controlledVariableReference;
    private final Short tagNumber;
    private final BACnetTagPayloadUnsignedInteger arrayIndexArgument;

    public BACnetConstructedDataControlledVariableReferenceBuilderImpl(
        BACnetObjectPropertyReference controlledVariableReference,
        Short tagNumber,
        BACnetTagPayloadUnsignedInteger arrayIndexArgument) {

      this.controlledVariableReference = controlledVariableReference;
      this.tagNumber = tagNumber;
      this.arrayIndexArgument = arrayIndexArgument;
    }

    public BACnetConstructedDataControlledVariableReference build(
        BACnetOpeningTag openingTag,
        BACnetTagHeader peekedTagHeader,
        BACnetClosingTag closingTag,
        Short tagNumber,
        BACnetTagPayloadUnsignedInteger arrayIndexArgument) {
      BACnetConstructedDataControlledVariableReference
          bACnetConstructedDataControlledVariableReference =
              new BACnetConstructedDataControlledVariableReference(
                  openingTag,
                  peekedTagHeader,
                  closingTag,
                  controlledVariableReference,
                  tagNumber,
                  arrayIndexArgument);
      return bACnetConstructedDataControlledVariableReference;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetConstructedDataControlledVariableReference)) {
      return false;
    }
    BACnetConstructedDataControlledVariableReference that =
        (BACnetConstructedDataControlledVariableReference) o;
    return (getControlledVariableReference() == that.getControlledVariableReference())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getControlledVariableReference());
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
