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

public class BACnetConstructedDataNetworkPortMaxInfoFrames extends BACnetConstructedData
    implements Message {

  // Accessors for discriminator values.
  public BACnetObjectType getObjectTypeArgument() {
    return BACnetObjectType.NETWORK_PORT;
  }

  public BACnetPropertyIdentifier getPropertyIdentifierArgument() {
    return BACnetPropertyIdentifier.MAX_INFO_FRAMES;
  }

  // Properties.
  protected final BACnetApplicationTagUnsignedInteger maxInfoFrames;

  // Arguments.
  protected final Short tagNumber;
  protected final BACnetTagPayloadUnsignedInteger arrayIndexArgument;

  public BACnetConstructedDataNetworkPortMaxInfoFrames(
      BACnetOpeningTag openingTag,
      BACnetTagHeader peekedTagHeader,
      BACnetClosingTag closingTag,
      BACnetApplicationTagUnsignedInteger maxInfoFrames,
      Short tagNumber,
      BACnetTagPayloadUnsignedInteger arrayIndexArgument) {
    super(openingTag, peekedTagHeader, closingTag, tagNumber, arrayIndexArgument);
    this.maxInfoFrames = maxInfoFrames;
    this.tagNumber = tagNumber;
    this.arrayIndexArgument = arrayIndexArgument;
  }

  public BACnetApplicationTagUnsignedInteger getMaxInfoFrames() {
    return maxInfoFrames;
  }

  public BACnetApplicationTagUnsignedInteger getActualValue() {
    return (BACnetApplicationTagUnsignedInteger) (getMaxInfoFrames());
  }

  @Override
  protected void serializeBACnetConstructedDataChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetConstructedDataNetworkPortMaxInfoFrames");

    // Simple Field (maxInfoFrames)
    writeSimpleField("maxInfoFrames", maxInfoFrames, new DataWriterComplexDefault<>(writeBuffer));

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    BACnetApplicationTagUnsignedInteger actualValue = getActualValue();
    writeBuffer.writeVirtual("actualValue", actualValue);

    writeBuffer.popContext("BACnetConstructedDataNetworkPortMaxInfoFrames");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    BACnetConstructedDataNetworkPortMaxInfoFrames _value = this;

    // Simple field (maxInfoFrames)
    lengthInBits += maxInfoFrames.getLengthInBits();

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
    readBuffer.pullContext("BACnetConstructedDataNetworkPortMaxInfoFrames");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    BACnetApplicationTagUnsignedInteger maxInfoFrames =
        readSimpleField(
            "maxInfoFrames",
            new DataReaderComplexDefault<>(
                () ->
                    (BACnetApplicationTagUnsignedInteger)
                        BACnetApplicationTag.staticParse(readBuffer),
                readBuffer));
    BACnetApplicationTagUnsignedInteger actualValue =
        readVirtualField("actualValue", BACnetApplicationTagUnsignedInteger.class, maxInfoFrames);

    readBuffer.closeContext("BACnetConstructedDataNetworkPortMaxInfoFrames");
    // Create the instance
    return new BACnetConstructedDataNetworkPortMaxInfoFramesBuilderImpl(
        maxInfoFrames, tagNumber, arrayIndexArgument);
  }

  public static class BACnetConstructedDataNetworkPortMaxInfoFramesBuilderImpl
      implements BACnetConstructedData.BACnetConstructedDataBuilder {
    private final BACnetApplicationTagUnsignedInteger maxInfoFrames;
    private final Short tagNumber;
    private final BACnetTagPayloadUnsignedInteger arrayIndexArgument;

    public BACnetConstructedDataNetworkPortMaxInfoFramesBuilderImpl(
        BACnetApplicationTagUnsignedInteger maxInfoFrames,
        Short tagNumber,
        BACnetTagPayloadUnsignedInteger arrayIndexArgument) {

      this.maxInfoFrames = maxInfoFrames;
      this.tagNumber = tagNumber;
      this.arrayIndexArgument = arrayIndexArgument;
    }

    public BACnetConstructedDataNetworkPortMaxInfoFrames build(
        BACnetOpeningTag openingTag,
        BACnetTagHeader peekedTagHeader,
        BACnetClosingTag closingTag,
        Short tagNumber,
        BACnetTagPayloadUnsignedInteger arrayIndexArgument) {
      BACnetConstructedDataNetworkPortMaxInfoFrames bACnetConstructedDataNetworkPortMaxInfoFrames =
          new BACnetConstructedDataNetworkPortMaxInfoFrames(
              openingTag,
              peekedTagHeader,
              closingTag,
              maxInfoFrames,
              tagNumber,
              arrayIndexArgument);
      return bACnetConstructedDataNetworkPortMaxInfoFrames;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetConstructedDataNetworkPortMaxInfoFrames)) {
      return false;
    }
    BACnetConstructedDataNetworkPortMaxInfoFrames that =
        (BACnetConstructedDataNetworkPortMaxInfoFrames) o;
    return (getMaxInfoFrames() == that.getMaxInfoFrames()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getMaxInfoFrames());
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
