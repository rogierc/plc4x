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

public class BACnetNotificationParametersChangeOfDiscreteValueNewValueDatetime
    extends BACnetNotificationParametersChangeOfDiscreteValueNewValue implements Message {

  // Accessors for discriminator values.

  // Properties.
  protected final BACnetDateTimeEnclosed dateTimeValue;

  // Arguments.
  protected final Short tagNumber;

  public BACnetNotificationParametersChangeOfDiscreteValueNewValueDatetime(
      BACnetOpeningTag openingTag,
      BACnetTagHeader peekedTagHeader,
      BACnetClosingTag closingTag,
      BACnetDateTimeEnclosed dateTimeValue,
      Short tagNumber) {
    super(openingTag, peekedTagHeader, closingTag, tagNumber);
    this.dateTimeValue = dateTimeValue;
    this.tagNumber = tagNumber;
  }

  public BACnetDateTimeEnclosed getDateTimeValue() {
    return dateTimeValue;
  }

  @Override
  protected void serializeBACnetNotificationParametersChangeOfDiscreteValueNewValueChild(
      WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetNotificationParametersChangeOfDiscreteValueNewValueDatetime");

    // Simple Field (dateTimeValue)
    writeSimpleField("dateTimeValue", dateTimeValue, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("BACnetNotificationParametersChangeOfDiscreteValueNewValueDatetime");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    BACnetNotificationParametersChangeOfDiscreteValueNewValueDatetime _value = this;

    // Simple field (dateTimeValue)
    lengthInBits += dateTimeValue.getLengthInBits();

    return lengthInBits;
  }

  public static BACnetNotificationParametersChangeOfDiscreteValueNewValueBuilder
      staticParseBACnetNotificationParametersChangeOfDiscreteValueNewValueBuilder(
          ReadBuffer readBuffer, Short tagNumber) throws ParseException {
    readBuffer.pullContext("BACnetNotificationParametersChangeOfDiscreteValueNewValueDatetime");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    BACnetDateTimeEnclosed dateTimeValue =
        readSimpleField(
            "dateTimeValue",
            new DataReaderComplexDefault<>(
                () -> BACnetDateTimeEnclosed.staticParse(readBuffer, (short) (0)), readBuffer));

    readBuffer.closeContext("BACnetNotificationParametersChangeOfDiscreteValueNewValueDatetime");
    // Create the instance
    return new BACnetNotificationParametersChangeOfDiscreteValueNewValueDatetimeBuilderImpl(
        dateTimeValue, tagNumber);
  }

  public static class BACnetNotificationParametersChangeOfDiscreteValueNewValueDatetimeBuilderImpl
      implements BACnetNotificationParametersChangeOfDiscreteValueNewValue
          .BACnetNotificationParametersChangeOfDiscreteValueNewValueBuilder {
    private final BACnetDateTimeEnclosed dateTimeValue;
    private final Short tagNumber;

    public BACnetNotificationParametersChangeOfDiscreteValueNewValueDatetimeBuilderImpl(
        BACnetDateTimeEnclosed dateTimeValue, Short tagNumber) {

      this.dateTimeValue = dateTimeValue;
      this.tagNumber = tagNumber;
    }

    public BACnetNotificationParametersChangeOfDiscreteValueNewValueDatetime build(
        BACnetOpeningTag openingTag,
        BACnetTagHeader peekedTagHeader,
        BACnetClosingTag closingTag,
        Short tagNumber) {
      BACnetNotificationParametersChangeOfDiscreteValueNewValueDatetime
          bACnetNotificationParametersChangeOfDiscreteValueNewValueDatetime =
              new BACnetNotificationParametersChangeOfDiscreteValueNewValueDatetime(
                  openingTag, peekedTagHeader, closingTag, dateTimeValue, tagNumber);
      return bACnetNotificationParametersChangeOfDiscreteValueNewValueDatetime;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetNotificationParametersChangeOfDiscreteValueNewValueDatetime)) {
      return false;
    }
    BACnetNotificationParametersChangeOfDiscreteValueNewValueDatetime that =
        (BACnetNotificationParametersChangeOfDiscreteValueNewValueDatetime) o;
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
