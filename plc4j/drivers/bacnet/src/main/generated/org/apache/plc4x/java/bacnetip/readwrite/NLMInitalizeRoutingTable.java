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

public class NLMInitalizeRoutingTable extends NLM implements Message {

  // Accessors for discriminator values.
  public Short getMessageType() {
    return (short) 0x06;
  }

  // Properties.
  protected final short numberOfPorts;
  protected final List<NLMInitalizeRoutingTablePortMapping> portMappings;

  // Arguments.
  protected final Integer apduLength;

  public NLMInitalizeRoutingTable(
      short numberOfPorts,
      List<NLMInitalizeRoutingTablePortMapping> portMappings,
      Integer apduLength) {
    super(apduLength);
    this.numberOfPorts = numberOfPorts;
    this.portMappings = portMappings;
    this.apduLength = apduLength;
  }

  public short getNumberOfPorts() {
    return numberOfPorts;
  }

  public List<NLMInitalizeRoutingTablePortMapping> getPortMappings() {
    return portMappings;
  }

  @Override
  protected void serializeNLMChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("NLMInitalizeRoutingTable");

    // Simple Field (numberOfPorts)
    writeSimpleField("numberOfPorts", numberOfPorts, writeUnsignedShort(writeBuffer, 8));

    // Array Field (portMappings)
    writeComplexTypeArrayField("portMappings", portMappings, writeBuffer);

    writeBuffer.popContext("NLMInitalizeRoutingTable");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    NLMInitalizeRoutingTable _value = this;

    // Simple field (numberOfPorts)
    lengthInBits += 8;

    // Array field
    if (portMappings != null) {
      int i = 0;
      for (NLMInitalizeRoutingTablePortMapping element : portMappings) {
        boolean last = ++i >= portMappings.size();
        lengthInBits += element.getLengthInBits();
      }
    }

    return lengthInBits;
  }

  public static NLMBuilder staticParseNLMBuilder(ReadBuffer readBuffer, Integer apduLength)
      throws ParseException {
    readBuffer.pullContext("NLMInitalizeRoutingTable");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    short numberOfPorts = readSimpleField("numberOfPorts", readUnsignedShort(readBuffer, 8));

    List<NLMInitalizeRoutingTablePortMapping> portMappings =
        readCountArrayField(
            "portMappings",
            new DataReaderComplexDefault<>(
                () -> NLMInitalizeRoutingTablePortMapping.staticParse(readBuffer), readBuffer),
            numberOfPorts);

    readBuffer.closeContext("NLMInitalizeRoutingTable");
    // Create the instance
    return new NLMInitalizeRoutingTableBuilderImpl(numberOfPorts, portMappings, apduLength);
  }

  public static class NLMInitalizeRoutingTableBuilderImpl implements NLM.NLMBuilder {
    private final short numberOfPorts;
    private final List<NLMInitalizeRoutingTablePortMapping> portMappings;
    private final Integer apduLength;

    public NLMInitalizeRoutingTableBuilderImpl(
        short numberOfPorts,
        List<NLMInitalizeRoutingTablePortMapping> portMappings,
        Integer apduLength) {

      this.numberOfPorts = numberOfPorts;
      this.portMappings = portMappings;
      this.apduLength = apduLength;
    }

    public NLMInitalizeRoutingTable build(Integer apduLength) {

      NLMInitalizeRoutingTable nLMInitalizeRoutingTable =
          new NLMInitalizeRoutingTable(numberOfPorts, portMappings, apduLength);
      return nLMInitalizeRoutingTable;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NLMInitalizeRoutingTable)) {
      return false;
    }
    NLMInitalizeRoutingTable that = (NLMInitalizeRoutingTable) o;
    return (getNumberOfPorts() == that.getNumberOfPorts())
        && (getPortMappings() == that.getPortMappings())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getNumberOfPorts(), getPortMappings());
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
