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
package org.apache.plc4x.java.openprotocol.readwrite;

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

public class ApplicationCommunicationStartAcknowledgeBlockStationId
    extends ApplicationCommunicationStartAcknowledgeBlock implements Message {

  // Accessors for discriminator values.
  public Integer getBlockType() {
    return (int) 14;
  }

  // Properties.
  protected final String stationId;

  public ApplicationCommunicationStartAcknowledgeBlockStationId(String stationId) {
    super();
    this.stationId = stationId;
  }

  public String getStationId() {
    return stationId;
  }

  @Override
  protected void serializeApplicationCommunicationStartAcknowledgeBlockChild(
      WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("ApplicationCommunicationStartAcknowledgeBlockStationId");

    // Simple Field (stationId)
    writeSimpleField(
        "stationId", stationId, writeString(writeBuffer, 80), WithOption.WithEncoding("ASCII"));

    writeBuffer.popContext("ApplicationCommunicationStartAcknowledgeBlockStationId");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    ApplicationCommunicationStartAcknowledgeBlockStationId _value = this;

    // Simple field (stationId)
    lengthInBits += 80;

    return lengthInBits;
  }

  public static ApplicationCommunicationStartAcknowledgeBlockBuilder
      staticParseApplicationCommunicationStartAcknowledgeBlockBuilder(ReadBuffer readBuffer)
          throws ParseException {
    readBuffer.pullContext("ApplicationCommunicationStartAcknowledgeBlockStationId");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    String stationId =
        readSimpleField("stationId", readString(readBuffer, 80), WithOption.WithEncoding("ASCII"));

    readBuffer.closeContext("ApplicationCommunicationStartAcknowledgeBlockStationId");
    // Create the instance
    return new ApplicationCommunicationStartAcknowledgeBlockStationIdBuilderImpl(stationId);
  }

  public static class ApplicationCommunicationStartAcknowledgeBlockStationIdBuilderImpl
      implements ApplicationCommunicationStartAcknowledgeBlock
          .ApplicationCommunicationStartAcknowledgeBlockBuilder {
    private final String stationId;

    public ApplicationCommunicationStartAcknowledgeBlockStationIdBuilderImpl(String stationId) {

      this.stationId = stationId;
    }

    public ApplicationCommunicationStartAcknowledgeBlockStationId build() {
      ApplicationCommunicationStartAcknowledgeBlockStationId
          applicationCommunicationStartAcknowledgeBlockStationId =
              new ApplicationCommunicationStartAcknowledgeBlockStationId(stationId);
      return applicationCommunicationStartAcknowledgeBlockStationId;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ApplicationCommunicationStartAcknowledgeBlockStationId)) {
      return false;
    }
    ApplicationCommunicationStartAcknowledgeBlockStationId that =
        (ApplicationCommunicationStartAcknowledgeBlockStationId) o;
    return (getStationId() == that.getStationId()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getStationId());
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
