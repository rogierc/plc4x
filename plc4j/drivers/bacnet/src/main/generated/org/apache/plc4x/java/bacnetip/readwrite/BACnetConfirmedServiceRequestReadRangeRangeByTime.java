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

public class BACnetConfirmedServiceRequestReadRangeRangeByTime
    extends BACnetConfirmedServiceRequestReadRangeRange implements Message {

  // Accessors for discriminator values.

  // Properties.
  protected final BACnetDateTime referenceTime;
  protected final BACnetApplicationTagSignedInteger count;

  public BACnetConfirmedServiceRequestReadRangeRangeByTime(
      BACnetTagHeader peekedTagHeader,
      BACnetOpeningTag openingTag,
      BACnetClosingTag closingTag,
      BACnetDateTime referenceTime,
      BACnetApplicationTagSignedInteger count) {
    super(peekedTagHeader, openingTag, closingTag);
    this.referenceTime = referenceTime;
    this.count = count;
  }

  public BACnetDateTime getReferenceTime() {
    return referenceTime;
  }

  public BACnetApplicationTagSignedInteger getCount() {
    return count;
  }

  @Override
  protected void serializeBACnetConfirmedServiceRequestReadRangeRangeChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetConfirmedServiceRequestReadRangeRangeByTime");

    // Simple Field (referenceTime)
    writeSimpleField("referenceTime", referenceTime, new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (count)
    writeSimpleField("count", count, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("BACnetConfirmedServiceRequestReadRangeRangeByTime");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    BACnetConfirmedServiceRequestReadRangeRangeByTime _value = this;

    // Simple field (referenceTime)
    lengthInBits += referenceTime.getLengthInBits();

    // Simple field (count)
    lengthInBits += count.getLengthInBits();

    return lengthInBits;
  }

  public static BACnetConfirmedServiceRequestReadRangeRangeBuilder
      staticParseBACnetConfirmedServiceRequestReadRangeRangeBuilder(ReadBuffer readBuffer)
          throws ParseException {
    readBuffer.pullContext("BACnetConfirmedServiceRequestReadRangeRangeByTime");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    BACnetDateTime referenceTime =
        readSimpleField(
            "referenceTime",
            new DataReaderComplexDefault<>(
                () -> BACnetDateTime.staticParse(readBuffer), readBuffer));

    BACnetApplicationTagSignedInteger count =
        readSimpleField(
            "count",
            new DataReaderComplexDefault<>(
                () ->
                    (BACnetApplicationTagSignedInteger)
                        BACnetApplicationTag.staticParse(readBuffer),
                readBuffer));

    readBuffer.closeContext("BACnetConfirmedServiceRequestReadRangeRangeByTime");
    // Create the instance
    return new BACnetConfirmedServiceRequestReadRangeRangeByTimeBuilderImpl(referenceTime, count);
  }

  public static class BACnetConfirmedServiceRequestReadRangeRangeByTimeBuilderImpl
      implements BACnetConfirmedServiceRequestReadRangeRange
          .BACnetConfirmedServiceRequestReadRangeRangeBuilder {
    private final BACnetDateTime referenceTime;
    private final BACnetApplicationTagSignedInteger count;

    public BACnetConfirmedServiceRequestReadRangeRangeByTimeBuilderImpl(
        BACnetDateTime referenceTime, BACnetApplicationTagSignedInteger count) {

      this.referenceTime = referenceTime;
      this.count = count;
    }

    public BACnetConfirmedServiceRequestReadRangeRangeByTime build(
        BACnetTagHeader peekedTagHeader, BACnetOpeningTag openingTag, BACnetClosingTag closingTag) {
      BACnetConfirmedServiceRequestReadRangeRangeByTime
          bACnetConfirmedServiceRequestReadRangeRangeByTime =
              new BACnetConfirmedServiceRequestReadRangeRangeByTime(
                  peekedTagHeader, openingTag, closingTag, referenceTime, count);
      return bACnetConfirmedServiceRequestReadRangeRangeByTime;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetConfirmedServiceRequestReadRangeRangeByTime)) {
      return false;
    }
    BACnetConfirmedServiceRequestReadRangeRangeByTime that =
        (BACnetConfirmedServiceRequestReadRangeRangeByTime) o;
    return (getReferenceTime() == that.getReferenceTime())
        && (getCount() == that.getCount())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getReferenceTime(), getCount());
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
