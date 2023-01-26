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

public class AdsReadWriteResponse extends AmsPacket implements Message {

  // Accessors for discriminator values.
  public CommandId getCommandId() {
    return CommandId.ADS_READ_WRITE;
  }

  public Boolean getResponse() {
    return (boolean) true;
  }

  // Properties.
  protected final ReturnCode result;
  protected final byte[] data;

  public AdsReadWriteResponse(
      AmsNetId targetAmsNetId,
      int targetAmsPort,
      AmsNetId sourceAmsNetId,
      int sourceAmsPort,
      long errorCode,
      long invokeId,
      ReturnCode result,
      byte[] data) {
    super(targetAmsNetId, targetAmsPort, sourceAmsNetId, sourceAmsPort, errorCode, invokeId);
    this.result = result;
    this.data = data;
  }

  public ReturnCode getResult() {
    return result;
  }

  public byte[] getData() {
    return data;
  }

  @Override
  protected void serializeAmsPacketChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("AdsReadWriteResponse");

    // Simple Field (result)
    writeSimpleEnumField(
        "result",
        "ReturnCode",
        result,
        new DataWriterEnumDefault<>(
            ReturnCode::getValue, ReturnCode::name, writeUnsignedLong(writeBuffer, 32)));

    // Implicit Field (length) (Used for parsing, but its value is not stored as it's implicitly
    // given by the objects content)
    long length = (long) (COUNT(getData()));
    writeImplicitField("length", length, writeUnsignedLong(writeBuffer, 32));

    // Array Field (data)
    writeByteArrayField("data", data, writeByteArray(writeBuffer, 8));

    writeBuffer.popContext("AdsReadWriteResponse");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    AdsReadWriteResponse _value = this;

    // Simple field (result)
    lengthInBits += 32;

    // Implicit Field (length)
    lengthInBits += 32;

    // Array field
    if (data != null) {
      lengthInBits += 8 * data.length;
    }

    return lengthInBits;
  }

  public static AmsPacketBuilder staticParseAmsPacketBuilder(ReadBuffer readBuffer)
      throws ParseException {
    readBuffer.pullContext("AdsReadWriteResponse");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    ReturnCode result =
        readEnumField(
            "result",
            "ReturnCode",
            new DataReaderEnumDefault<>(
                ReturnCode::enumForValue, readUnsignedLong(readBuffer, 32)));

    long length = readImplicitField("length", readUnsignedLong(readBuffer, 32));

    byte[] data = readBuffer.readByteArray("data", Math.toIntExact(length));

    readBuffer.closeContext("AdsReadWriteResponse");
    // Create the instance
    return new AdsReadWriteResponseBuilderImpl(result, data);
  }

  public static class AdsReadWriteResponseBuilderImpl implements AmsPacket.AmsPacketBuilder {
    private final ReturnCode result;
    private final byte[] data;

    public AdsReadWriteResponseBuilderImpl(ReturnCode result, byte[] data) {

      this.result = result;
      this.data = data;
    }

    public AdsReadWriteResponse build(
        AmsNetId targetAmsNetId,
        int targetAmsPort,
        AmsNetId sourceAmsNetId,
        int sourceAmsPort,
        long errorCode,
        long invokeId) {
      AdsReadWriteResponse adsReadWriteResponse =
          new AdsReadWriteResponse(
              targetAmsNetId,
              targetAmsPort,
              sourceAmsNetId,
              sourceAmsPort,
              errorCode,
              invokeId,
              result,
              data);
      return adsReadWriteResponse;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AdsReadWriteResponse)) {
      return false;
    }
    AdsReadWriteResponse that = (AdsReadWriteResponse) o;
    return (getResult() == that.getResult())
        && (getData() == that.getData())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getResult(), getData());
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
