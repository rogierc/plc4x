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

public class BACnetConfirmedServiceRequestAcknowledgeAlarm extends BACnetConfirmedServiceRequest
    implements Message {

  // Accessors for discriminator values.
  public BACnetConfirmedServiceChoice getServiceChoice() {
    return BACnetConfirmedServiceChoice.ACKNOWLEDGE_ALARM;
  }

  // Properties.
  protected final BACnetContextTagUnsignedInteger acknowledgingProcessIdentifier;
  protected final BACnetContextTagObjectIdentifier eventObjectIdentifier;
  protected final BACnetEventStateTagged eventStateAcknowledged;
  protected final BACnetTimeStampEnclosed timestamp;
  protected final BACnetContextTagCharacterString acknowledgmentSource;
  protected final BACnetTimeStampEnclosed timeOfAcknowledgment;

  // Arguments.
  protected final Long serviceRequestLength;

  public BACnetConfirmedServiceRequestAcknowledgeAlarm(
      BACnetContextTagUnsignedInteger acknowledgingProcessIdentifier,
      BACnetContextTagObjectIdentifier eventObjectIdentifier,
      BACnetEventStateTagged eventStateAcknowledged,
      BACnetTimeStampEnclosed timestamp,
      BACnetContextTagCharacterString acknowledgmentSource,
      BACnetTimeStampEnclosed timeOfAcknowledgment,
      Long serviceRequestLength) {
    super(serviceRequestLength);
    this.acknowledgingProcessIdentifier = acknowledgingProcessIdentifier;
    this.eventObjectIdentifier = eventObjectIdentifier;
    this.eventStateAcknowledged = eventStateAcknowledged;
    this.timestamp = timestamp;
    this.acknowledgmentSource = acknowledgmentSource;
    this.timeOfAcknowledgment = timeOfAcknowledgment;
    this.serviceRequestLength = serviceRequestLength;
  }

  public BACnetContextTagUnsignedInteger getAcknowledgingProcessIdentifier() {
    return acknowledgingProcessIdentifier;
  }

  public BACnetContextTagObjectIdentifier getEventObjectIdentifier() {
    return eventObjectIdentifier;
  }

  public BACnetEventStateTagged getEventStateAcknowledged() {
    return eventStateAcknowledged;
  }

  public BACnetTimeStampEnclosed getTimestamp() {
    return timestamp;
  }

  public BACnetContextTagCharacterString getAcknowledgmentSource() {
    return acknowledgmentSource;
  }

  public BACnetTimeStampEnclosed getTimeOfAcknowledgment() {
    return timeOfAcknowledgment;
  }

  @Override
  protected void serializeBACnetConfirmedServiceRequestChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetConfirmedServiceRequestAcknowledgeAlarm");

    // Simple Field (acknowledgingProcessIdentifier)
    writeSimpleField(
        "acknowledgingProcessIdentifier",
        acknowledgingProcessIdentifier,
        new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (eventObjectIdentifier)
    writeSimpleField(
        "eventObjectIdentifier",
        eventObjectIdentifier,
        new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (eventStateAcknowledged)
    writeSimpleField(
        "eventStateAcknowledged",
        eventStateAcknowledged,
        new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (timestamp)
    writeSimpleField("timestamp", timestamp, new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (acknowledgmentSource)
    writeSimpleField(
        "acknowledgmentSource", acknowledgmentSource, new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (timeOfAcknowledgment)
    writeSimpleField(
        "timeOfAcknowledgment", timeOfAcknowledgment, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("BACnetConfirmedServiceRequestAcknowledgeAlarm");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    BACnetConfirmedServiceRequestAcknowledgeAlarm _value = this;

    // Simple field (acknowledgingProcessIdentifier)
    lengthInBits += acknowledgingProcessIdentifier.getLengthInBits();

    // Simple field (eventObjectIdentifier)
    lengthInBits += eventObjectIdentifier.getLengthInBits();

    // Simple field (eventStateAcknowledged)
    lengthInBits += eventStateAcknowledged.getLengthInBits();

    // Simple field (timestamp)
    lengthInBits += timestamp.getLengthInBits();

    // Simple field (acknowledgmentSource)
    lengthInBits += acknowledgmentSource.getLengthInBits();

    // Simple field (timeOfAcknowledgment)
    lengthInBits += timeOfAcknowledgment.getLengthInBits();

    return lengthInBits;
  }

  public static BACnetConfirmedServiceRequestBuilder
      staticParseBACnetConfirmedServiceRequestBuilder(
          ReadBuffer readBuffer, Long serviceRequestLength) throws ParseException {
    readBuffer.pullContext("BACnetConfirmedServiceRequestAcknowledgeAlarm");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    BACnetContextTagUnsignedInteger acknowledgingProcessIdentifier =
        readSimpleField(
            "acknowledgingProcessIdentifier",
            new DataReaderComplexDefault<>(
                () ->
                    (BACnetContextTagUnsignedInteger)
                        BACnetContextTag.staticParse(
                            readBuffer,
                            (short) (0),
                            (BACnetDataType) (BACnetDataType.UNSIGNED_INTEGER)),
                readBuffer));

    BACnetContextTagObjectIdentifier eventObjectIdentifier =
        readSimpleField(
            "eventObjectIdentifier",
            new DataReaderComplexDefault<>(
                () ->
                    (BACnetContextTagObjectIdentifier)
                        BACnetContextTag.staticParse(
                            readBuffer,
                            (short) (1),
                            (BACnetDataType) (BACnetDataType.BACNET_OBJECT_IDENTIFIER)),
                readBuffer));

    BACnetEventStateTagged eventStateAcknowledged =
        readSimpleField(
            "eventStateAcknowledged",
            new DataReaderComplexDefault<>(
                () ->
                    BACnetEventStateTagged.staticParse(
                        readBuffer, (short) (2), (TagClass) (TagClass.CONTEXT_SPECIFIC_TAGS)),
                readBuffer));

    BACnetTimeStampEnclosed timestamp =
        readSimpleField(
            "timestamp",
            new DataReaderComplexDefault<>(
                () -> BACnetTimeStampEnclosed.staticParse(readBuffer, (short) (3)), readBuffer));

    BACnetContextTagCharacterString acknowledgmentSource =
        readSimpleField(
            "acknowledgmentSource",
            new DataReaderComplexDefault<>(
                () ->
                    (BACnetContextTagCharacterString)
                        BACnetContextTag.staticParse(
                            readBuffer,
                            (short) (4),
                            (BACnetDataType) (BACnetDataType.CHARACTER_STRING)),
                readBuffer));

    BACnetTimeStampEnclosed timeOfAcknowledgment =
        readSimpleField(
            "timeOfAcknowledgment",
            new DataReaderComplexDefault<>(
                () -> BACnetTimeStampEnclosed.staticParse(readBuffer, (short) (5)), readBuffer));

    readBuffer.closeContext("BACnetConfirmedServiceRequestAcknowledgeAlarm");
    // Create the instance
    return new BACnetConfirmedServiceRequestAcknowledgeAlarmBuilderImpl(
        acknowledgingProcessIdentifier,
        eventObjectIdentifier,
        eventStateAcknowledged,
        timestamp,
        acknowledgmentSource,
        timeOfAcknowledgment,
        serviceRequestLength);
  }

  public static class BACnetConfirmedServiceRequestAcknowledgeAlarmBuilderImpl
      implements BACnetConfirmedServiceRequest.BACnetConfirmedServiceRequestBuilder {
    private final BACnetContextTagUnsignedInteger acknowledgingProcessIdentifier;
    private final BACnetContextTagObjectIdentifier eventObjectIdentifier;
    private final BACnetEventStateTagged eventStateAcknowledged;
    private final BACnetTimeStampEnclosed timestamp;
    private final BACnetContextTagCharacterString acknowledgmentSource;
    private final BACnetTimeStampEnclosed timeOfAcknowledgment;
    private final Long serviceRequestLength;

    public BACnetConfirmedServiceRequestAcknowledgeAlarmBuilderImpl(
        BACnetContextTagUnsignedInteger acknowledgingProcessIdentifier,
        BACnetContextTagObjectIdentifier eventObjectIdentifier,
        BACnetEventStateTagged eventStateAcknowledged,
        BACnetTimeStampEnclosed timestamp,
        BACnetContextTagCharacterString acknowledgmentSource,
        BACnetTimeStampEnclosed timeOfAcknowledgment,
        Long serviceRequestLength) {

      this.acknowledgingProcessIdentifier = acknowledgingProcessIdentifier;
      this.eventObjectIdentifier = eventObjectIdentifier;
      this.eventStateAcknowledged = eventStateAcknowledged;
      this.timestamp = timestamp;
      this.acknowledgmentSource = acknowledgmentSource;
      this.timeOfAcknowledgment = timeOfAcknowledgment;
      this.serviceRequestLength = serviceRequestLength;
    }

    public BACnetConfirmedServiceRequestAcknowledgeAlarm build(Long serviceRequestLength) {

      BACnetConfirmedServiceRequestAcknowledgeAlarm bACnetConfirmedServiceRequestAcknowledgeAlarm =
          new BACnetConfirmedServiceRequestAcknowledgeAlarm(
              acknowledgingProcessIdentifier,
              eventObjectIdentifier,
              eventStateAcknowledged,
              timestamp,
              acknowledgmentSource,
              timeOfAcknowledgment,
              serviceRequestLength);
      return bACnetConfirmedServiceRequestAcknowledgeAlarm;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetConfirmedServiceRequestAcknowledgeAlarm)) {
      return false;
    }
    BACnetConfirmedServiceRequestAcknowledgeAlarm that =
        (BACnetConfirmedServiceRequestAcknowledgeAlarm) o;
    return (getAcknowledgingProcessIdentifier() == that.getAcknowledgingProcessIdentifier())
        && (getEventObjectIdentifier() == that.getEventObjectIdentifier())
        && (getEventStateAcknowledged() == that.getEventStateAcknowledged())
        && (getTimestamp() == that.getTimestamp())
        && (getAcknowledgmentSource() == that.getAcknowledgmentSource())
        && (getTimeOfAcknowledgment() == that.getTimeOfAcknowledgment())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(),
        getAcknowledgingProcessIdentifier(),
        getEventObjectIdentifier(),
        getEventStateAcknowledged(),
        getTimestamp(),
        getAcknowledgmentSource(),
        getTimeOfAcknowledgment());
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
