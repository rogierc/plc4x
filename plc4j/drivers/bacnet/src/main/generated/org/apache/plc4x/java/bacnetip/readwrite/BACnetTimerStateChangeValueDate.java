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

public class BACnetTimerStateChangeValueDate extends BACnetTimerStateChangeValue
    implements Message {

  // Accessors for discriminator values.

  // Properties.
  protected final BACnetApplicationTagDate dateValue;

  // Arguments.
  protected final BACnetObjectType objectTypeArgument;

  public BACnetTimerStateChangeValueDate(
      BACnetTagHeader peekedTagHeader,
      BACnetApplicationTagDate dateValue,
      BACnetObjectType objectTypeArgument) {
    super(peekedTagHeader, objectTypeArgument);
    this.dateValue = dateValue;
    this.objectTypeArgument = objectTypeArgument;
  }

  public BACnetApplicationTagDate getDateValue() {
    return dateValue;
  }

  @Override
  protected void serializeBACnetTimerStateChangeValueChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetTimerStateChangeValueDate");

    // Simple Field (dateValue)
    writeSimpleField("dateValue", dateValue, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("BACnetTimerStateChangeValueDate");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    BACnetTimerStateChangeValueDate _value = this;

    // Simple field (dateValue)
    lengthInBits += dateValue.getLengthInBits();

    return lengthInBits;
  }

  public static BACnetTimerStateChangeValueBuilder staticParseBACnetTimerStateChangeValueBuilder(
      ReadBuffer readBuffer, BACnetObjectType objectTypeArgument) throws ParseException {
    readBuffer.pullContext("BACnetTimerStateChangeValueDate");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    BACnetApplicationTagDate dateValue =
        readSimpleField(
            "dateValue",
            new DataReaderComplexDefault<>(
                () -> (BACnetApplicationTagDate) BACnetApplicationTag.staticParse(readBuffer),
                readBuffer));

    readBuffer.closeContext("BACnetTimerStateChangeValueDate");
    // Create the instance
    return new BACnetTimerStateChangeValueDateBuilderImpl(dateValue, objectTypeArgument);
  }

  public static class BACnetTimerStateChangeValueDateBuilderImpl
      implements BACnetTimerStateChangeValue.BACnetTimerStateChangeValueBuilder {
    private final BACnetApplicationTagDate dateValue;
    private final BACnetObjectType objectTypeArgument;

    public BACnetTimerStateChangeValueDateBuilderImpl(
        BACnetApplicationTagDate dateValue, BACnetObjectType objectTypeArgument) {

      this.dateValue = dateValue;
      this.objectTypeArgument = objectTypeArgument;
    }

    public BACnetTimerStateChangeValueDate build(
        BACnetTagHeader peekedTagHeader, BACnetObjectType objectTypeArgument) {
      BACnetTimerStateChangeValueDate bACnetTimerStateChangeValueDate =
          new BACnetTimerStateChangeValueDate(peekedTagHeader, dateValue, objectTypeArgument);
      return bACnetTimerStateChangeValueDate;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetTimerStateChangeValueDate)) {
      return false;
    }
    BACnetTimerStateChangeValueDate that = (BACnetTimerStateChangeValueDate) o;
    return (getDateValue() == that.getDateValue()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getDateValue());
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
