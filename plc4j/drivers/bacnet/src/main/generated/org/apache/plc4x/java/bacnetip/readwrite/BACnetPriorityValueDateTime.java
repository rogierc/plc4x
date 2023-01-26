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

public class BACnetPriorityValueDateTime extends BACnetPriorityValue implements Message {

  // Accessors for discriminator values.

  // Properties.
  protected final BACnetDateTimeEnclosed dateTimeValue;

  // Arguments.
  protected final BACnetObjectType objectTypeArgument;

  public BACnetPriorityValueDateTime(
      BACnetTagHeader peekedTagHeader,
      BACnetDateTimeEnclosed dateTimeValue,
      BACnetObjectType objectTypeArgument) {
    super(peekedTagHeader, objectTypeArgument);
    this.dateTimeValue = dateTimeValue;
    this.objectTypeArgument = objectTypeArgument;
  }

  public BACnetDateTimeEnclosed getDateTimeValue() {
    return dateTimeValue;
  }

  @Override
  protected void serializeBACnetPriorityValueChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetPriorityValueDateTime");

    // Simple Field (dateTimeValue)
    writeSimpleField("dateTimeValue", dateTimeValue, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("BACnetPriorityValueDateTime");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    BACnetPriorityValueDateTime _value = this;

    // Simple field (dateTimeValue)
    lengthInBits += dateTimeValue.getLengthInBits();

    return lengthInBits;
  }

  public static BACnetPriorityValueBuilder staticParseBACnetPriorityValueBuilder(
      ReadBuffer readBuffer, BACnetObjectType objectTypeArgument) throws ParseException {
    readBuffer.pullContext("BACnetPriorityValueDateTime");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    BACnetDateTimeEnclosed dateTimeValue =
        readSimpleField(
            "dateTimeValue",
            new DataReaderComplexDefault<>(
                () -> BACnetDateTimeEnclosed.staticParse(readBuffer, (short) (1)), readBuffer));

    readBuffer.closeContext("BACnetPriorityValueDateTime");
    // Create the instance
    return new BACnetPriorityValueDateTimeBuilderImpl(dateTimeValue, objectTypeArgument);
  }

  public static class BACnetPriorityValueDateTimeBuilderImpl
      implements BACnetPriorityValue.BACnetPriorityValueBuilder {
    private final BACnetDateTimeEnclosed dateTimeValue;
    private final BACnetObjectType objectTypeArgument;

    public BACnetPriorityValueDateTimeBuilderImpl(
        BACnetDateTimeEnclosed dateTimeValue, BACnetObjectType objectTypeArgument) {

      this.dateTimeValue = dateTimeValue;
      this.objectTypeArgument = objectTypeArgument;
    }

    public BACnetPriorityValueDateTime build(
        BACnetTagHeader peekedTagHeader, BACnetObjectType objectTypeArgument) {
      BACnetPriorityValueDateTime bACnetPriorityValueDateTime =
          new BACnetPriorityValueDateTime(peekedTagHeader, dateTimeValue, objectTypeArgument);
      return bACnetPriorityValueDateTime;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetPriorityValueDateTime)) {
      return false;
    }
    BACnetPriorityValueDateTime that = (BACnetPriorityValueDateTime) o;
    return (getDateTimeValue() == that.getDateTimeValue()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getDateTimeValue());
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
