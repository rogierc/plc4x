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

public class BACnetConfirmedServiceRequestConfirmedCOVNotification
    extends BACnetConfirmedServiceRequest implements Message {

  // Accessors for discriminator values.
  public BACnetConfirmedServiceChoice getServiceChoice() {
    return BACnetConfirmedServiceChoice.CONFIRMED_COV_NOTIFICATION;
  }

  // Properties.
  protected final BACnetContextTagUnsignedInteger subscriberProcessIdentifier;
  protected final BACnetContextTagObjectIdentifier initiatingDeviceIdentifier;
  protected final BACnetContextTagObjectIdentifier monitoredObjectIdentifier;
  protected final BACnetContextTagUnsignedInteger lifetimeInSeconds;
  protected final BACnetPropertyValues listOfValues;

  // Arguments.
  protected final Long serviceRequestLength;

  public BACnetConfirmedServiceRequestConfirmedCOVNotification(
      BACnetContextTagUnsignedInteger subscriberProcessIdentifier,
      BACnetContextTagObjectIdentifier initiatingDeviceIdentifier,
      BACnetContextTagObjectIdentifier monitoredObjectIdentifier,
      BACnetContextTagUnsignedInteger lifetimeInSeconds,
      BACnetPropertyValues listOfValues,
      Long serviceRequestLength) {
    super(serviceRequestLength);
    this.subscriberProcessIdentifier = subscriberProcessIdentifier;
    this.initiatingDeviceIdentifier = initiatingDeviceIdentifier;
    this.monitoredObjectIdentifier = monitoredObjectIdentifier;
    this.lifetimeInSeconds = lifetimeInSeconds;
    this.listOfValues = listOfValues;
    this.serviceRequestLength = serviceRequestLength;
  }

  public BACnetContextTagUnsignedInteger getSubscriberProcessIdentifier() {
    return subscriberProcessIdentifier;
  }

  public BACnetContextTagObjectIdentifier getInitiatingDeviceIdentifier() {
    return initiatingDeviceIdentifier;
  }

  public BACnetContextTagObjectIdentifier getMonitoredObjectIdentifier() {
    return monitoredObjectIdentifier;
  }

  public BACnetContextTagUnsignedInteger getLifetimeInSeconds() {
    return lifetimeInSeconds;
  }

  public BACnetPropertyValues getListOfValues() {
    return listOfValues;
  }

  @Override
  protected void serializeBACnetConfirmedServiceRequestChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetConfirmedServiceRequestConfirmedCOVNotification");

    // Simple Field (subscriberProcessIdentifier)
    writeSimpleField(
        "subscriberProcessIdentifier",
        subscriberProcessIdentifier,
        new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (initiatingDeviceIdentifier)
    writeSimpleField(
        "initiatingDeviceIdentifier",
        initiatingDeviceIdentifier,
        new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (monitoredObjectIdentifier)
    writeSimpleField(
        "monitoredObjectIdentifier",
        monitoredObjectIdentifier,
        new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (lifetimeInSeconds)
    writeSimpleField(
        "lifetimeInSeconds", lifetimeInSeconds, new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (listOfValues)
    writeSimpleField("listOfValues", listOfValues, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("BACnetConfirmedServiceRequestConfirmedCOVNotification");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    BACnetConfirmedServiceRequestConfirmedCOVNotification _value = this;

    // Simple field (subscriberProcessIdentifier)
    lengthInBits += subscriberProcessIdentifier.getLengthInBits();

    // Simple field (initiatingDeviceIdentifier)
    lengthInBits += initiatingDeviceIdentifier.getLengthInBits();

    // Simple field (monitoredObjectIdentifier)
    lengthInBits += monitoredObjectIdentifier.getLengthInBits();

    // Simple field (lifetimeInSeconds)
    lengthInBits += lifetimeInSeconds.getLengthInBits();

    // Simple field (listOfValues)
    lengthInBits += listOfValues.getLengthInBits();

    return lengthInBits;
  }

  public static BACnetConfirmedServiceRequestBuilder
      staticParseBACnetConfirmedServiceRequestBuilder(
          ReadBuffer readBuffer, Long serviceRequestLength) throws ParseException {
    readBuffer.pullContext("BACnetConfirmedServiceRequestConfirmedCOVNotification");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    BACnetContextTagUnsignedInteger subscriberProcessIdentifier =
        readSimpleField(
            "subscriberProcessIdentifier",
            new DataReaderComplexDefault<>(
                () ->
                    (BACnetContextTagUnsignedInteger)
                        BACnetContextTag.staticParse(
                            readBuffer,
                            (short) (0),
                            (BACnetDataType) (BACnetDataType.UNSIGNED_INTEGER)),
                readBuffer));

    BACnetContextTagObjectIdentifier initiatingDeviceIdentifier =
        readSimpleField(
            "initiatingDeviceIdentifier",
            new DataReaderComplexDefault<>(
                () ->
                    (BACnetContextTagObjectIdentifier)
                        BACnetContextTag.staticParse(
                            readBuffer,
                            (short) (1),
                            (BACnetDataType) (BACnetDataType.BACNET_OBJECT_IDENTIFIER)),
                readBuffer));

    BACnetContextTagObjectIdentifier monitoredObjectIdentifier =
        readSimpleField(
            "monitoredObjectIdentifier",
            new DataReaderComplexDefault<>(
                () ->
                    (BACnetContextTagObjectIdentifier)
                        BACnetContextTag.staticParse(
                            readBuffer,
                            (short) (2),
                            (BACnetDataType) (BACnetDataType.BACNET_OBJECT_IDENTIFIER)),
                readBuffer));

    BACnetContextTagUnsignedInteger lifetimeInSeconds =
        readSimpleField(
            "lifetimeInSeconds",
            new DataReaderComplexDefault<>(
                () ->
                    (BACnetContextTagUnsignedInteger)
                        BACnetContextTag.staticParse(
                            readBuffer,
                            (short) (3),
                            (BACnetDataType) (BACnetDataType.UNSIGNED_INTEGER)),
                readBuffer));

    BACnetPropertyValues listOfValues =
        readSimpleField(
            "listOfValues",
            new DataReaderComplexDefault<>(
                () ->
                    BACnetPropertyValues.staticParse(
                        readBuffer,
                        (short) (4),
                        (BACnetObjectType) (monitoredObjectIdentifier.getObjectType())),
                readBuffer));

    readBuffer.closeContext("BACnetConfirmedServiceRequestConfirmedCOVNotification");
    // Create the instance
    return new BACnetConfirmedServiceRequestConfirmedCOVNotificationBuilderImpl(
        subscriberProcessIdentifier,
        initiatingDeviceIdentifier,
        monitoredObjectIdentifier,
        lifetimeInSeconds,
        listOfValues,
        serviceRequestLength);
  }

  public static class BACnetConfirmedServiceRequestConfirmedCOVNotificationBuilderImpl
      implements BACnetConfirmedServiceRequest.BACnetConfirmedServiceRequestBuilder {
    private final BACnetContextTagUnsignedInteger subscriberProcessIdentifier;
    private final BACnetContextTagObjectIdentifier initiatingDeviceIdentifier;
    private final BACnetContextTagObjectIdentifier monitoredObjectIdentifier;
    private final BACnetContextTagUnsignedInteger lifetimeInSeconds;
    private final BACnetPropertyValues listOfValues;
    private final Long serviceRequestLength;

    public BACnetConfirmedServiceRequestConfirmedCOVNotificationBuilderImpl(
        BACnetContextTagUnsignedInteger subscriberProcessIdentifier,
        BACnetContextTagObjectIdentifier initiatingDeviceIdentifier,
        BACnetContextTagObjectIdentifier monitoredObjectIdentifier,
        BACnetContextTagUnsignedInteger lifetimeInSeconds,
        BACnetPropertyValues listOfValues,
        Long serviceRequestLength) {

      this.subscriberProcessIdentifier = subscriberProcessIdentifier;
      this.initiatingDeviceIdentifier = initiatingDeviceIdentifier;
      this.monitoredObjectIdentifier = monitoredObjectIdentifier;
      this.lifetimeInSeconds = lifetimeInSeconds;
      this.listOfValues = listOfValues;
      this.serviceRequestLength = serviceRequestLength;
    }

    public BACnetConfirmedServiceRequestConfirmedCOVNotification build(Long serviceRequestLength) {

      BACnetConfirmedServiceRequestConfirmedCOVNotification
          bACnetConfirmedServiceRequestConfirmedCOVNotification =
              new BACnetConfirmedServiceRequestConfirmedCOVNotification(
                  subscriberProcessIdentifier,
                  initiatingDeviceIdentifier,
                  monitoredObjectIdentifier,
                  lifetimeInSeconds,
                  listOfValues,
                  serviceRequestLength);
      return bACnetConfirmedServiceRequestConfirmedCOVNotification;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetConfirmedServiceRequestConfirmedCOVNotification)) {
      return false;
    }
    BACnetConfirmedServiceRequestConfirmedCOVNotification that =
        (BACnetConfirmedServiceRequestConfirmedCOVNotification) o;
    return (getSubscriberProcessIdentifier() == that.getSubscriberProcessIdentifier())
        && (getInitiatingDeviceIdentifier() == that.getInitiatingDeviceIdentifier())
        && (getMonitoredObjectIdentifier() == that.getMonitoredObjectIdentifier())
        && (getLifetimeInSeconds() == that.getLifetimeInSeconds())
        && (getListOfValues() == that.getListOfValues())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(),
        getSubscriberProcessIdentifier(),
        getInitiatingDeviceIdentifier(),
        getMonitoredObjectIdentifier(),
        getLifetimeInSeconds(),
        getListOfValues());
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
