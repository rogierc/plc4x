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

public class DeleteNodesItem extends ExtensionObjectDefinition implements Message {

  // Accessors for discriminator values.
  public String getIdentifier() {
    return (String) "384";
  }

  // Properties.
  protected final NodeId nodeId;
  protected final boolean deleteTargetReferences;
  // Reserved Fields
  private Short reservedField0;

  public DeleteNodesItem(NodeId nodeId, boolean deleteTargetReferences) {
    super();
    this.nodeId = nodeId;
    this.deleteTargetReferences = deleteTargetReferences;
  }

  public NodeId getNodeId() {
    return nodeId;
  }

  public boolean getDeleteTargetReferences() {
    return deleteTargetReferences;
  }

  @Override
  protected void serializeExtensionObjectDefinitionChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("DeleteNodesItem");

    // Simple Field (nodeId)
    writeSimpleField("nodeId", nodeId, new DataWriterComplexDefault<>(writeBuffer));

    // Reserved Field (reserved)
    writeReservedField(
        "reserved",
        reservedField0 != null ? reservedField0 : (short) 0x00,
        writeUnsignedShort(writeBuffer, 7));

    // Simple Field (deleteTargetReferences)
    writeSimpleField("deleteTargetReferences", deleteTargetReferences, writeBoolean(writeBuffer));

    writeBuffer.popContext("DeleteNodesItem");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    DeleteNodesItem _value = this;

    // Simple field (nodeId)
    lengthInBits += nodeId.getLengthInBits();

    // Reserved Field (reserved)
    lengthInBits += 7;

    // Simple field (deleteTargetReferences)
    lengthInBits += 1;

    return lengthInBits;
  }

  public static ExtensionObjectDefinitionBuilder staticParseExtensionObjectDefinitionBuilder(
      ReadBuffer readBuffer, String identifier) throws ParseException {
    readBuffer.pullContext("DeleteNodesItem");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    NodeId nodeId =
        readSimpleField(
            "nodeId",
            new DataReaderComplexDefault<>(() -> NodeId.staticParse(readBuffer), readBuffer));

    Short reservedField0 =
        readReservedField("reserved", readUnsignedShort(readBuffer, 7), (short) 0x00);

    boolean deleteTargetReferences =
        readSimpleField("deleteTargetReferences", readBoolean(readBuffer));

    readBuffer.closeContext("DeleteNodesItem");
    // Create the instance
    return new DeleteNodesItemBuilderImpl(nodeId, deleteTargetReferences, reservedField0);
  }

  public static class DeleteNodesItemBuilderImpl
      implements ExtensionObjectDefinition.ExtensionObjectDefinitionBuilder {
    private final NodeId nodeId;
    private final boolean deleteTargetReferences;
    private final Short reservedField0;

    public DeleteNodesItemBuilderImpl(
        NodeId nodeId, boolean deleteTargetReferences, Short reservedField0) {
      this.nodeId = nodeId;
      this.deleteTargetReferences = deleteTargetReferences;
      this.reservedField0 = reservedField0;
    }

    public DeleteNodesItem build() {
      DeleteNodesItem deleteNodesItem = new DeleteNodesItem(nodeId, deleteTargetReferences);
      deleteNodesItem.reservedField0 = reservedField0;
      return deleteNodesItem;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DeleteNodesItem)) {
      return false;
    }
    DeleteNodesItem that = (DeleteNodesItem) o;
    return (getNodeId() == that.getNodeId())
        && (getDeleteTargetReferences() == that.getDeleteTargetReferences())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getNodeId(), getDeleteTargetReferences());
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
