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

public class NLMWhoIsRouterToNetwork extends NLM implements Message {

  // Accessors for discriminator values.
  public Short getMessageType() {
    return (short) 0x00;
  }

  // Properties.
  protected final Integer destinationNetworkAddress;

  // Arguments.
  protected final Integer apduLength;

  public NLMWhoIsRouterToNetwork(Integer destinationNetworkAddress, Integer apduLength) {
    super(apduLength);
    this.destinationNetworkAddress = destinationNetworkAddress;
    this.apduLength = apduLength;
  }

  public Integer getDestinationNetworkAddress() {
    return destinationNetworkAddress;
  }

  @Override
  protected void serializeNLMChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("NLMWhoIsRouterToNetwork");

    // Optional Field (destinationNetworkAddress) (Can be skipped, if the value is null)
    writeOptionalField(
        "destinationNetworkAddress", destinationNetworkAddress, writeUnsignedInt(writeBuffer, 16));

    writeBuffer.popContext("NLMWhoIsRouterToNetwork");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    NLMWhoIsRouterToNetwork _value = this;

    // Optional Field (destinationNetworkAddress)
    if (destinationNetworkAddress != null) {
      lengthInBits += 16;
    }

    return lengthInBits;
  }

  public static NLMBuilder staticParseNLMBuilder(ReadBuffer readBuffer, Integer apduLength)
      throws ParseException {
    readBuffer.pullContext("NLMWhoIsRouterToNetwork");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    Integer destinationNetworkAddress =
        readOptionalField("destinationNetworkAddress", readUnsignedInt(readBuffer, 16));

    readBuffer.closeContext("NLMWhoIsRouterToNetwork");
    // Create the instance
    return new NLMWhoIsRouterToNetworkBuilderImpl(destinationNetworkAddress, apduLength);
  }

  public static class NLMWhoIsRouterToNetworkBuilderImpl implements NLM.NLMBuilder {
    private final Integer destinationNetworkAddress;
    private final Integer apduLength;

    public NLMWhoIsRouterToNetworkBuilderImpl(
        Integer destinationNetworkAddress, Integer apduLength) {

      this.destinationNetworkAddress = destinationNetworkAddress;
      this.apduLength = apduLength;
    }

    public NLMWhoIsRouterToNetwork build(Integer apduLength) {

      NLMWhoIsRouterToNetwork nLMWhoIsRouterToNetwork =
          new NLMWhoIsRouterToNetwork(destinationNetworkAddress, apduLength);
      return nLMWhoIsRouterToNetwork;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NLMWhoIsRouterToNetwork)) {
      return false;
    }
    NLMWhoIsRouterToNetwork that = (NLMWhoIsRouterToNetwork) o;
    return (getDestinationNetworkAddress() == that.getDestinationNetworkAddress())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getDestinationNetworkAddress());
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
