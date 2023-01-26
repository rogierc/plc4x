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
package org.apache.plc4x.java.knxnetip.readwrite;

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

public class SearchResponse extends KnxNetIpMessage implements Message {

  // Accessors for discriminator values.
  public Integer getMsgType() {
    return (int) 0x0202;
  }

  // Properties.
  protected final HPAIControlEndpoint hpaiControlEndpoint;
  protected final DIBDeviceInfo dibDeviceInfo;
  protected final DIBSuppSvcFamilies dibSuppSvcFamilies;

  public SearchResponse(
      HPAIControlEndpoint hpaiControlEndpoint,
      DIBDeviceInfo dibDeviceInfo,
      DIBSuppSvcFamilies dibSuppSvcFamilies) {
    super();
    this.hpaiControlEndpoint = hpaiControlEndpoint;
    this.dibDeviceInfo = dibDeviceInfo;
    this.dibSuppSvcFamilies = dibSuppSvcFamilies;
  }

  public HPAIControlEndpoint getHpaiControlEndpoint() {
    return hpaiControlEndpoint;
  }

  public DIBDeviceInfo getDibDeviceInfo() {
    return dibDeviceInfo;
  }

  public DIBSuppSvcFamilies getDibSuppSvcFamilies() {
    return dibSuppSvcFamilies;
  }

  @Override
  protected void serializeKnxNetIpMessageChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("SearchResponse");

    // Simple Field (hpaiControlEndpoint)
    writeSimpleField(
        "hpaiControlEndpoint",
        hpaiControlEndpoint,
        new DataWriterComplexDefault<>(writeBuffer),
        WithOption.WithByteOrder(ByteOrder.BIG_ENDIAN));

    // Simple Field (dibDeviceInfo)
    writeSimpleField(
        "dibDeviceInfo",
        dibDeviceInfo,
        new DataWriterComplexDefault<>(writeBuffer),
        WithOption.WithByteOrder(ByteOrder.BIG_ENDIAN));

    // Simple Field (dibSuppSvcFamilies)
    writeSimpleField(
        "dibSuppSvcFamilies",
        dibSuppSvcFamilies,
        new DataWriterComplexDefault<>(writeBuffer),
        WithOption.WithByteOrder(ByteOrder.BIG_ENDIAN));

    writeBuffer.popContext("SearchResponse");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    SearchResponse _value = this;

    // Simple field (hpaiControlEndpoint)
    lengthInBits += hpaiControlEndpoint.getLengthInBits();

    // Simple field (dibDeviceInfo)
    lengthInBits += dibDeviceInfo.getLengthInBits();

    // Simple field (dibSuppSvcFamilies)
    lengthInBits += dibSuppSvcFamilies.getLengthInBits();

    return lengthInBits;
  }

  public static KnxNetIpMessageBuilder staticParseKnxNetIpMessageBuilder(ReadBuffer readBuffer)
      throws ParseException {
    readBuffer.pullContext("SearchResponse");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    HPAIControlEndpoint hpaiControlEndpoint =
        readSimpleField(
            "hpaiControlEndpoint",
            new DataReaderComplexDefault<>(
                () -> HPAIControlEndpoint.staticParse(readBuffer), readBuffer),
            WithOption.WithByteOrder(ByteOrder.BIG_ENDIAN));

    DIBDeviceInfo dibDeviceInfo =
        readSimpleField(
            "dibDeviceInfo",
            new DataReaderComplexDefault<>(() -> DIBDeviceInfo.staticParse(readBuffer), readBuffer),
            WithOption.WithByteOrder(ByteOrder.BIG_ENDIAN));

    DIBSuppSvcFamilies dibSuppSvcFamilies =
        readSimpleField(
            "dibSuppSvcFamilies",
            new DataReaderComplexDefault<>(
                () -> DIBSuppSvcFamilies.staticParse(readBuffer), readBuffer),
            WithOption.WithByteOrder(ByteOrder.BIG_ENDIAN));

    readBuffer.closeContext("SearchResponse");
    // Create the instance
    return new SearchResponseBuilderImpl(hpaiControlEndpoint, dibDeviceInfo, dibSuppSvcFamilies);
  }

  public static class SearchResponseBuilderImpl implements KnxNetIpMessage.KnxNetIpMessageBuilder {
    private final HPAIControlEndpoint hpaiControlEndpoint;
    private final DIBDeviceInfo dibDeviceInfo;
    private final DIBSuppSvcFamilies dibSuppSvcFamilies;

    public SearchResponseBuilderImpl(
        HPAIControlEndpoint hpaiControlEndpoint,
        DIBDeviceInfo dibDeviceInfo,
        DIBSuppSvcFamilies dibSuppSvcFamilies) {

      this.hpaiControlEndpoint = hpaiControlEndpoint;
      this.dibDeviceInfo = dibDeviceInfo;
      this.dibSuppSvcFamilies = dibSuppSvcFamilies;
    }

    public SearchResponse build() {
      SearchResponse searchResponse =
          new SearchResponse(hpaiControlEndpoint, dibDeviceInfo, dibSuppSvcFamilies);
      return searchResponse;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SearchResponse)) {
      return false;
    }
    SearchResponse that = (SearchResponse) o;
    return (getHpaiControlEndpoint() == that.getHpaiControlEndpoint())
        && (getDibDeviceInfo() == that.getDibDeviceInfo())
        && (getDibSuppSvcFamilies() == that.getDibSuppSvcFamilies())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(), getHpaiControlEndpoint(), getDibDeviceInfo(), getDibSuppSvcFamilies());
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
