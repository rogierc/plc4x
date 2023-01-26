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

public class BACnetConstructedDataBBMDBroadcastDistributionTable extends BACnetConstructedData
    implements Message {

  // Accessors for discriminator values.
  public BACnetObjectType getObjectTypeArgument() {
    return null;
  }

  public BACnetPropertyIdentifier getPropertyIdentifierArgument() {
    return BACnetPropertyIdentifier.BBMD_BROADCAST_DISTRIBUTION_TABLE;
  }

  // Properties.
  protected final List<BACnetBDTEntry> bbmdBroadcastDistributionTable;

  // Arguments.
  protected final Short tagNumber;
  protected final BACnetTagPayloadUnsignedInteger arrayIndexArgument;

  public BACnetConstructedDataBBMDBroadcastDistributionTable(
      BACnetOpeningTag openingTag,
      BACnetTagHeader peekedTagHeader,
      BACnetClosingTag closingTag,
      List<BACnetBDTEntry> bbmdBroadcastDistributionTable,
      Short tagNumber,
      BACnetTagPayloadUnsignedInteger arrayIndexArgument) {
    super(openingTag, peekedTagHeader, closingTag, tagNumber, arrayIndexArgument);
    this.bbmdBroadcastDistributionTable = bbmdBroadcastDistributionTable;
    this.tagNumber = tagNumber;
    this.arrayIndexArgument = arrayIndexArgument;
  }

  public List<BACnetBDTEntry> getBbmdBroadcastDistributionTable() {
    return bbmdBroadcastDistributionTable;
  }

  @Override
  protected void serializeBACnetConstructedDataChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetConstructedDataBBMDBroadcastDistributionTable");

    // Array Field (bbmdBroadcastDistributionTable)
    writeComplexTypeArrayField(
        "bbmdBroadcastDistributionTable", bbmdBroadcastDistributionTable, writeBuffer);

    writeBuffer.popContext("BACnetConstructedDataBBMDBroadcastDistributionTable");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    BACnetConstructedDataBBMDBroadcastDistributionTable _value = this;

    // Array field
    if (bbmdBroadcastDistributionTable != null) {
      for (Message element : bbmdBroadcastDistributionTable) {
        lengthInBits += element.getLengthInBits();
      }
    }

    return lengthInBits;
  }

  public static BACnetConstructedDataBuilder staticParseBACnetConstructedDataBuilder(
      ReadBuffer readBuffer,
      Short tagNumber,
      BACnetObjectType objectTypeArgument,
      BACnetPropertyIdentifier propertyIdentifierArgument,
      BACnetTagPayloadUnsignedInteger arrayIndexArgument)
      throws ParseException {
    readBuffer.pullContext("BACnetConstructedDataBBMDBroadcastDistributionTable");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    List<BACnetBDTEntry> bbmdBroadcastDistributionTable =
        readTerminatedArrayField(
            "bbmdBroadcastDistributionTable",
            new DataReaderComplexDefault<>(
                () -> BACnetBDTEntry.staticParse(readBuffer), readBuffer),
            () ->
                ((boolean)
                    (org.apache.plc4x.java.bacnetip.readwrite.utils.StaticHelper
                        .isBACnetConstructedDataClosingTag(readBuffer, false, tagNumber))));

    readBuffer.closeContext("BACnetConstructedDataBBMDBroadcastDistributionTable");
    // Create the instance
    return new BACnetConstructedDataBBMDBroadcastDistributionTableBuilderImpl(
        bbmdBroadcastDistributionTable, tagNumber, arrayIndexArgument);
  }

  public static class BACnetConstructedDataBBMDBroadcastDistributionTableBuilderImpl
      implements BACnetConstructedData.BACnetConstructedDataBuilder {
    private final List<BACnetBDTEntry> bbmdBroadcastDistributionTable;
    private final Short tagNumber;
    private final BACnetTagPayloadUnsignedInteger arrayIndexArgument;

    public BACnetConstructedDataBBMDBroadcastDistributionTableBuilderImpl(
        List<BACnetBDTEntry> bbmdBroadcastDistributionTable,
        Short tagNumber,
        BACnetTagPayloadUnsignedInteger arrayIndexArgument) {

      this.bbmdBroadcastDistributionTable = bbmdBroadcastDistributionTable;
      this.tagNumber = tagNumber;
      this.arrayIndexArgument = arrayIndexArgument;
    }

    public BACnetConstructedDataBBMDBroadcastDistributionTable build(
        BACnetOpeningTag openingTag,
        BACnetTagHeader peekedTagHeader,
        BACnetClosingTag closingTag,
        Short tagNumber,
        BACnetTagPayloadUnsignedInteger arrayIndexArgument) {
      BACnetConstructedDataBBMDBroadcastDistributionTable
          bACnetConstructedDataBBMDBroadcastDistributionTable =
              new BACnetConstructedDataBBMDBroadcastDistributionTable(
                  openingTag,
                  peekedTagHeader,
                  closingTag,
                  bbmdBroadcastDistributionTable,
                  tagNumber,
                  arrayIndexArgument);
      return bACnetConstructedDataBBMDBroadcastDistributionTable;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetConstructedDataBBMDBroadcastDistributionTable)) {
      return false;
    }
    BACnetConstructedDataBBMDBroadcastDistributionTable that =
        (BACnetConstructedDataBBMDBroadcastDistributionTable) o;
    return (getBbmdBroadcastDistributionTable() == that.getBbmdBroadcastDistributionTable())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getBbmdBroadcastDistributionTable());
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
