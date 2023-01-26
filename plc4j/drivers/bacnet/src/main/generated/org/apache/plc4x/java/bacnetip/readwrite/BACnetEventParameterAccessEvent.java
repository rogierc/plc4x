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

public class BACnetEventParameterAccessEvent extends BACnetEventParameter implements Message {

  // Accessors for discriminator values.

  // Properties.
  protected final BACnetOpeningTag openingTag;
  protected final BACnetEventParameterAccessEventListOfAccessEvents listOfAccessEvents;
  protected final BACnetDeviceObjectPropertyReferenceEnclosed accessEventTimeReference;
  protected final BACnetClosingTag closingTag;

  public BACnetEventParameterAccessEvent(
      BACnetTagHeader peekedTagHeader,
      BACnetOpeningTag openingTag,
      BACnetEventParameterAccessEventListOfAccessEvents listOfAccessEvents,
      BACnetDeviceObjectPropertyReferenceEnclosed accessEventTimeReference,
      BACnetClosingTag closingTag) {
    super(peekedTagHeader);
    this.openingTag = openingTag;
    this.listOfAccessEvents = listOfAccessEvents;
    this.accessEventTimeReference = accessEventTimeReference;
    this.closingTag = closingTag;
  }

  public BACnetOpeningTag getOpeningTag() {
    return openingTag;
  }

  public BACnetEventParameterAccessEventListOfAccessEvents getListOfAccessEvents() {
    return listOfAccessEvents;
  }

  public BACnetDeviceObjectPropertyReferenceEnclosed getAccessEventTimeReference() {
    return accessEventTimeReference;
  }

  public BACnetClosingTag getClosingTag() {
    return closingTag;
  }

  @Override
  protected void serializeBACnetEventParameterChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetEventParameterAccessEvent");

    // Simple Field (openingTag)
    writeSimpleField("openingTag", openingTag, new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (listOfAccessEvents)
    writeSimpleField(
        "listOfAccessEvents", listOfAccessEvents, new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (accessEventTimeReference)
    writeSimpleField(
        "accessEventTimeReference",
        accessEventTimeReference,
        new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (closingTag)
    writeSimpleField("closingTag", closingTag, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("BACnetEventParameterAccessEvent");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    BACnetEventParameterAccessEvent _value = this;

    // Simple field (openingTag)
    lengthInBits += openingTag.getLengthInBits();

    // Simple field (listOfAccessEvents)
    lengthInBits += listOfAccessEvents.getLengthInBits();

    // Simple field (accessEventTimeReference)
    lengthInBits += accessEventTimeReference.getLengthInBits();

    // Simple field (closingTag)
    lengthInBits += closingTag.getLengthInBits();

    return lengthInBits;
  }

  public static BACnetEventParameterBuilder staticParseBACnetEventParameterBuilder(
      ReadBuffer readBuffer) throws ParseException {
    readBuffer.pullContext("BACnetEventParameterAccessEvent");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    BACnetOpeningTag openingTag =
        readSimpleField(
            "openingTag",
            new DataReaderComplexDefault<>(
                () -> BACnetOpeningTag.staticParse(readBuffer, (short) (13)), readBuffer));

    BACnetEventParameterAccessEventListOfAccessEvents listOfAccessEvents =
        readSimpleField(
            "listOfAccessEvents",
            new DataReaderComplexDefault<>(
                () ->
                    BACnetEventParameterAccessEventListOfAccessEvents.staticParse(
                        readBuffer, (short) (0)),
                readBuffer));

    BACnetDeviceObjectPropertyReferenceEnclosed accessEventTimeReference =
        readSimpleField(
            "accessEventTimeReference",
            new DataReaderComplexDefault<>(
                () ->
                    BACnetDeviceObjectPropertyReferenceEnclosed.staticParse(
                        readBuffer, (short) (1)),
                readBuffer));

    BACnetClosingTag closingTag =
        readSimpleField(
            "closingTag",
            new DataReaderComplexDefault<>(
                () -> BACnetClosingTag.staticParse(readBuffer, (short) (13)), readBuffer));

    readBuffer.closeContext("BACnetEventParameterAccessEvent");
    // Create the instance
    return new BACnetEventParameterAccessEventBuilderImpl(
        openingTag, listOfAccessEvents, accessEventTimeReference, closingTag);
  }

  public static class BACnetEventParameterAccessEventBuilderImpl
      implements BACnetEventParameter.BACnetEventParameterBuilder {
    private final BACnetOpeningTag openingTag;
    private final BACnetEventParameterAccessEventListOfAccessEvents listOfAccessEvents;
    private final BACnetDeviceObjectPropertyReferenceEnclosed accessEventTimeReference;
    private final BACnetClosingTag closingTag;

    public BACnetEventParameterAccessEventBuilderImpl(
        BACnetOpeningTag openingTag,
        BACnetEventParameterAccessEventListOfAccessEvents listOfAccessEvents,
        BACnetDeviceObjectPropertyReferenceEnclosed accessEventTimeReference,
        BACnetClosingTag closingTag) {

      this.openingTag = openingTag;
      this.listOfAccessEvents = listOfAccessEvents;
      this.accessEventTimeReference = accessEventTimeReference;
      this.closingTag = closingTag;
    }

    public BACnetEventParameterAccessEvent build(BACnetTagHeader peekedTagHeader) {
      BACnetEventParameterAccessEvent bACnetEventParameterAccessEvent =
          new BACnetEventParameterAccessEvent(
              peekedTagHeader,
              openingTag,
              listOfAccessEvents,
              accessEventTimeReference,
              closingTag);
      return bACnetEventParameterAccessEvent;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetEventParameterAccessEvent)) {
      return false;
    }
    BACnetEventParameterAccessEvent that = (BACnetEventParameterAccessEvent) o;
    return (getOpeningTag() == that.getOpeningTag())
        && (getListOfAccessEvents() == that.getListOfAccessEvents())
        && (getAccessEventTimeReference() == that.getAccessEventTimeReference())
        && (getClosingTag() == that.getClosingTag())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(),
        getOpeningTag(),
        getListOfAccessEvents(),
        getAccessEventTimeReference(),
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
