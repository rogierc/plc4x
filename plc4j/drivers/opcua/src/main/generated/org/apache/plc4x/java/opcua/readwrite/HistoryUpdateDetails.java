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
package org.apache.plc4x.java.opcua.readwrite;

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

public class HistoryUpdateDetails extends ExtensionObjectDefinition implements Message {

  // Accessors for discriminator values.
  public String getIdentifier() {
    return (String) "679";
  }

  // Properties.
  protected final NodeId nodeId;

  public HistoryUpdateDetails(NodeId nodeId) {
    super();
    this.nodeId = nodeId;
  }

  public NodeId getNodeId() {
    return nodeId;
  }

  @Override
  protected void serializeExtensionObjectDefinitionChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("HistoryUpdateDetails");

    // Simple Field (nodeId)
    writeSimpleField("nodeId", nodeId, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("HistoryUpdateDetails");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    HistoryUpdateDetails _value = this;

    // Simple field (nodeId)
    lengthInBits += nodeId.getLengthInBits();

    return lengthInBits;
  }

  public static ExtensionObjectDefinitionBuilder staticParseExtensionObjectDefinitionBuilder(
      ReadBuffer readBuffer, String identifier) throws ParseException {
    readBuffer.pullContext("HistoryUpdateDetails");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    NodeId nodeId =
        readSimpleField(
            "nodeId",
            new DataReaderComplexDefault<>(() -> NodeId.staticParse(readBuffer), readBuffer));

    readBuffer.closeContext("HistoryUpdateDetails");
    // Create the instance
    return new HistoryUpdateDetailsBuilderImpl(nodeId);
  }

  public static class HistoryUpdateDetailsBuilderImpl
      implements ExtensionObjectDefinition.ExtensionObjectDefinitionBuilder {
    private final NodeId nodeId;

    public HistoryUpdateDetailsBuilderImpl(NodeId nodeId) {

      this.nodeId = nodeId;
    }

    public HistoryUpdateDetails build() {
      HistoryUpdateDetails historyUpdateDetails = new HistoryUpdateDetails(nodeId);
      return historyUpdateDetails;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof HistoryUpdateDetails)) {
      return false;
    }
    HistoryUpdateDetails that = (HistoryUpdateDetails) o;
    return (getNodeId() == that.getNodeId()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getNodeId());
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
