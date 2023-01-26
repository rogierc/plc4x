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
package org.apache.plc4x.java.profinet.readwrite;

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

public class Ethernet_FramePayload_PnDcp extends Ethernet_FramePayload implements Message {

  // Accessors for discriminator values.
  public Integer getPacketType() {
    return (int) 0x8892;
  }

  // Properties.
  protected final PnDcp_Pdu pdu;

  public Ethernet_FramePayload_PnDcp(PnDcp_Pdu pdu) {
    super();
    this.pdu = pdu;
  }

  public PnDcp_Pdu getPdu() {
    return pdu;
  }

  @Override
  protected void serializeEthernet_FramePayloadChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("Ethernet_FramePayload_PnDcp");

    // Simple Field (pdu)
    writeSimpleField("pdu", pdu, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("Ethernet_FramePayload_PnDcp");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    Ethernet_FramePayload_PnDcp _value = this;

    // Simple field (pdu)
    lengthInBits += pdu.getLengthInBits();

    return lengthInBits;
  }

  public static Ethernet_FramePayloadBuilder staticParseEthernet_FramePayloadBuilder(
      ReadBuffer readBuffer) throws ParseException {
    readBuffer.pullContext("Ethernet_FramePayload_PnDcp");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    PnDcp_Pdu pdu =
        readSimpleField(
            "pdu",
            new DataReaderComplexDefault<>(() -> PnDcp_Pdu.staticParse(readBuffer), readBuffer));

    readBuffer.closeContext("Ethernet_FramePayload_PnDcp");
    // Create the instance
    return new Ethernet_FramePayload_PnDcpBuilderImpl(pdu);
  }

  public static class Ethernet_FramePayload_PnDcpBuilderImpl
      implements Ethernet_FramePayload.Ethernet_FramePayloadBuilder {
    private final PnDcp_Pdu pdu;

    public Ethernet_FramePayload_PnDcpBuilderImpl(PnDcp_Pdu pdu) {

      this.pdu = pdu;
    }

    public Ethernet_FramePayload_PnDcp build() {
      Ethernet_FramePayload_PnDcp ethernet_FramePayload_PnDcp =
          new Ethernet_FramePayload_PnDcp(pdu);
      return ethernet_FramePayload_PnDcp;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Ethernet_FramePayload_PnDcp)) {
      return false;
    }
    Ethernet_FramePayload_PnDcp that = (Ethernet_FramePayload_PnDcp) o;
    return (getPdu() == that.getPdu()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getPdu());
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
