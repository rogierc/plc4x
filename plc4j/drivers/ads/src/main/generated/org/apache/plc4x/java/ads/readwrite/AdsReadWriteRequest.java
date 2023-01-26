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
package org.apache.plc4x.java.ads.readwrite;

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

public class AdsReadWriteRequest extends AmsPacket implements Message {

  // Accessors for discriminator values.
  public CommandId getCommandId() {
    return CommandId.ADS_READ_WRITE;
  }

  public Boolean getResponse() {
    return (boolean) false;
  }

  // Properties.
  protected final long indexGroup;
  protected final long indexOffset;
  protected final long readLength;
  protected final List<AdsMultiRequestItem> items;
  protected final byte[] data;

  public AdsReadWriteRequest(
      AmsNetId targetAmsNetId,
      int targetAmsPort,
      AmsNetId sourceAmsNetId,
      int sourceAmsPort,
      long errorCode,
      long invokeId,
      long indexGroup,
      long indexOffset,
      long readLength,
      List<AdsMultiRequestItem> items,
      byte[] data) {
    super(targetAmsNetId, targetAmsPort, sourceAmsNetId, sourceAmsPort, errorCode, invokeId);
    this.indexGroup = indexGroup;
    this.indexOffset = indexOffset;
    this.readLength = readLength;
    this.items = items;
    this.data = data;
  }

  public long getIndexGroup() {
    return indexGroup;
  }

  public long getIndexOffset() {
    return indexOffset;
  }

  public long getReadLength() {
    return readLength;
  }

  public List<AdsMultiRequestItem> getItems() {
    return items;
  }

  public byte[] getData() {
    return data;
  }

  @Override
  protected void serializeAmsPacketChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("AdsReadWriteRequest");

    // Simple Field (indexGroup)
    writeSimpleField("indexGroup", indexGroup, writeUnsignedLong(writeBuffer, 32));

    // Simple Field (indexOffset)
    writeSimpleField("indexOffset", indexOffset, writeUnsignedLong(writeBuffer, 32));

    // Simple Field (readLength)
    writeSimpleField("readLength", readLength, writeUnsignedLong(writeBuffer, 32));

    // Implicit Field (writeLength) (Used for parsing, but its value is not stored as it's
    // implicitly given by the objects content)
    long writeLength =
        (long)
            ((((COUNT(getItems())) * ((((((getIndexGroup()) == (61570))) ? 16L : 12L)))))
                + (COUNT(getData())));
    writeImplicitField("writeLength", writeLength, writeUnsignedLong(writeBuffer, 32));

    // Array Field (items)
    writeComplexTypeArrayField("items", items, writeBuffer);

    // Array Field (data)
    writeByteArrayField("data", data, writeByteArray(writeBuffer, 8));

    writeBuffer.popContext("AdsReadWriteRequest");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    AdsReadWriteRequest _value = this;

    // Simple field (indexGroup)
    lengthInBits += 32;

    // Simple field (indexOffset)
    lengthInBits += 32;

    // Simple field (readLength)
    lengthInBits += 32;

    // Implicit Field (writeLength)
    lengthInBits += 32;

    // Array field
    if (items != null) {
      int i = 0;
      for (AdsMultiRequestItem element : items) {
        boolean last = ++i >= items.size();
        lengthInBits += element.getLengthInBits();
      }
    }

    // Array field
    if (data != null) {
      lengthInBits += 8 * data.length;
    }

    return lengthInBits;
  }

  public static AmsPacketBuilder staticParseAmsPacketBuilder(ReadBuffer readBuffer)
      throws ParseException {
    readBuffer.pullContext("AdsReadWriteRequest");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    long indexGroup = readSimpleField("indexGroup", readUnsignedLong(readBuffer, 32));

    long indexOffset = readSimpleField("indexOffset", readUnsignedLong(readBuffer, 32));

    long readLength = readSimpleField("readLength", readUnsignedLong(readBuffer, 32));

    long writeLength = readImplicitField("writeLength", readUnsignedLong(readBuffer, 32));

    List<AdsMultiRequestItem> items =
        readCountArrayField(
            "items",
            new DataReaderComplexDefault<>(
                () -> AdsMultiRequestItem.staticParse(readBuffer, (long) (indexGroup)), readBuffer),
            (((((((indexGroup) == (61568))) || (((indexGroup) == (61569))))
                    || (((indexGroup) == (61570)))))
                ? indexOffset
                : 0));

    byte[] data =
        readBuffer.readByteArray(
            "data", Math.toIntExact((writeLength) - (((COUNT(items)) * (12)))));

    readBuffer.closeContext("AdsReadWriteRequest");
    // Create the instance
    return new AdsReadWriteRequestBuilderImpl(indexGroup, indexOffset, readLength, items, data);
  }

  public static class AdsReadWriteRequestBuilderImpl implements AmsPacket.AmsPacketBuilder {
    private final long indexGroup;
    private final long indexOffset;
    private final long readLength;
    private final List<AdsMultiRequestItem> items;
    private final byte[] data;

    public AdsReadWriteRequestBuilderImpl(
        long indexGroup,
        long indexOffset,
        long readLength,
        List<AdsMultiRequestItem> items,
        byte[] data) {

      this.indexGroup = indexGroup;
      this.indexOffset = indexOffset;
      this.readLength = readLength;
      this.items = items;
      this.data = data;
    }

    public AdsReadWriteRequest build(
        AmsNetId targetAmsNetId,
        int targetAmsPort,
        AmsNetId sourceAmsNetId,
        int sourceAmsPort,
        long errorCode,
        long invokeId) {
      AdsReadWriteRequest adsReadWriteRequest =
          new AdsReadWriteRequest(
              targetAmsNetId,
              targetAmsPort,
              sourceAmsNetId,
              sourceAmsPort,
              errorCode,
              invokeId,
              indexGroup,
              indexOffset,
              readLength,
              items,
              data);
      return adsReadWriteRequest;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AdsReadWriteRequest)) {
      return false;
    }
    AdsReadWriteRequest that = (AdsReadWriteRequest) o;
    return (getIndexGroup() == that.getIndexGroup())
        && (getIndexOffset() == that.getIndexOffset())
        && (getReadLength() == that.getReadLength())
        && (getItems() == that.getItems())
        && (getData() == that.getData())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(),
        getIndexGroup(),
        getIndexOffset(),
        getReadLength(),
        getItems(),
        getData());
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
