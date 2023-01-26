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

public class BACnetEventParameterBufferReady extends BACnetEventParameter implements Message {

  // Accessors for discriminator values.

  // Properties.
  protected final BACnetOpeningTag openingTag;
  protected final BACnetContextTagUnsignedInteger notificationThreshold;
  protected final BACnetContextTagUnsignedInteger previousNotificationCount;
  protected final BACnetClosingTag closingTag;

  public BACnetEventParameterBufferReady(
      BACnetTagHeader peekedTagHeader,
      BACnetOpeningTag openingTag,
      BACnetContextTagUnsignedInteger notificationThreshold,
      BACnetContextTagUnsignedInteger previousNotificationCount,
      BACnetClosingTag closingTag) {
    super(peekedTagHeader);
    this.openingTag = openingTag;
    this.notificationThreshold = notificationThreshold;
    this.previousNotificationCount = previousNotificationCount;
    this.closingTag = closingTag;
  }

  public BACnetOpeningTag getOpeningTag() {
    return openingTag;
  }

  public BACnetContextTagUnsignedInteger getNotificationThreshold() {
    return notificationThreshold;
  }

  public BACnetContextTagUnsignedInteger getPreviousNotificationCount() {
    return previousNotificationCount;
  }

  public BACnetClosingTag getClosingTag() {
    return closingTag;
  }

  @Override
  protected void serializeBACnetEventParameterChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetEventParameterBufferReady");

    // Simple Field (openingTag)
    writeSimpleField("openingTag", openingTag, new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (notificationThreshold)
    writeSimpleField(
        "notificationThreshold",
        notificationThreshold,
        new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (previousNotificationCount)
    writeSimpleField(
        "previousNotificationCount",
        previousNotificationCount,
        new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (closingTag)
    writeSimpleField("closingTag", closingTag, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("BACnetEventParameterBufferReady");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    BACnetEventParameterBufferReady _value = this;

    // Simple field (openingTag)
    lengthInBits += openingTag.getLengthInBits();

    // Simple field (notificationThreshold)
    lengthInBits += notificationThreshold.getLengthInBits();

    // Simple field (previousNotificationCount)
    lengthInBits += previousNotificationCount.getLengthInBits();

    // Simple field (closingTag)
    lengthInBits += closingTag.getLengthInBits();

    return lengthInBits;
  }

  public static BACnetEventParameterBuilder staticParseBACnetEventParameterBuilder(
      ReadBuffer readBuffer) throws ParseException {
    readBuffer.pullContext("BACnetEventParameterBufferReady");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    BACnetOpeningTag openingTag =
        readSimpleField(
            "openingTag",
            new DataReaderComplexDefault<>(
                () -> BACnetOpeningTag.staticParse(readBuffer, (short) (10)), readBuffer));

    BACnetContextTagUnsignedInteger notificationThreshold =
        readSimpleField(
            "notificationThreshold",
            new DataReaderComplexDefault<>(
                () ->
                    (BACnetContextTagUnsignedInteger)
                        BACnetContextTag.staticParse(
                            readBuffer,
                            (short) (0),
                            (BACnetDataType) (BACnetDataType.UNSIGNED_INTEGER)),
                readBuffer));

    BACnetContextTagUnsignedInteger previousNotificationCount =
        readSimpleField(
            "previousNotificationCount",
            new DataReaderComplexDefault<>(
                () ->
                    (BACnetContextTagUnsignedInteger)
                        BACnetContextTag.staticParse(
                            readBuffer,
                            (short) (1),
                            (BACnetDataType) (BACnetDataType.UNSIGNED_INTEGER)),
                readBuffer));

    BACnetClosingTag closingTag =
        readSimpleField(
            "closingTag",
            new DataReaderComplexDefault<>(
                () -> BACnetClosingTag.staticParse(readBuffer, (short) (10)), readBuffer));

    readBuffer.closeContext("BACnetEventParameterBufferReady");
    // Create the instance
    return new BACnetEventParameterBufferReadyBuilderImpl(
        openingTag, notificationThreshold, previousNotificationCount, closingTag);
  }

  public static class BACnetEventParameterBufferReadyBuilderImpl
      implements BACnetEventParameter.BACnetEventParameterBuilder {
    private final BACnetOpeningTag openingTag;
    private final BACnetContextTagUnsignedInteger notificationThreshold;
    private final BACnetContextTagUnsignedInteger previousNotificationCount;
    private final BACnetClosingTag closingTag;

    public BACnetEventParameterBufferReadyBuilderImpl(
        BACnetOpeningTag openingTag,
        BACnetContextTagUnsignedInteger notificationThreshold,
        BACnetContextTagUnsignedInteger previousNotificationCount,
        BACnetClosingTag closingTag) {

      this.openingTag = openingTag;
      this.notificationThreshold = notificationThreshold;
      this.previousNotificationCount = previousNotificationCount;
      this.closingTag = closingTag;
    }

    public BACnetEventParameterBufferReady build(BACnetTagHeader peekedTagHeader) {
      BACnetEventParameterBufferReady bACnetEventParameterBufferReady =
          new BACnetEventParameterBufferReady(
              peekedTagHeader,
              openingTag,
              notificationThreshold,
              previousNotificationCount,
              closingTag);
      return bACnetEventParameterBufferReady;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetEventParameterBufferReady)) {
      return false;
    }
    BACnetEventParameterBufferReady that = (BACnetEventParameterBufferReady) o;
    return (getOpeningTag() == that.getOpeningTag())
        && (getNotificationThreshold() == that.getNotificationThreshold())
        && (getPreviousNotificationCount() == that.getPreviousNotificationCount())
        && (getClosingTag() == that.getClosingTag())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(),
        getOpeningTag(),
        getNotificationThreshold(),
        getPreviousNotificationCount(),
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
