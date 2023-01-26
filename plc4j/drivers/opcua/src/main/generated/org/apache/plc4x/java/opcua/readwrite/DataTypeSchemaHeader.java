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

public class DataTypeSchemaHeader extends ExtensionObjectDefinition implements Message {

  // Accessors for discriminator values.
  public String getIdentifier() {
    return (String) "15536";
  }

  // Properties.
  protected final int noOfNamespaces;
  protected final List<PascalString> namespaces;
  protected final int noOfStructureDataTypes;
  protected final List<DataTypeDescription> structureDataTypes;
  protected final int noOfEnumDataTypes;
  protected final List<DataTypeDescription> enumDataTypes;
  protected final int noOfSimpleDataTypes;
  protected final List<DataTypeDescription> simpleDataTypes;

  public DataTypeSchemaHeader(
      int noOfNamespaces,
      List<PascalString> namespaces,
      int noOfStructureDataTypes,
      List<DataTypeDescription> structureDataTypes,
      int noOfEnumDataTypes,
      List<DataTypeDescription> enumDataTypes,
      int noOfSimpleDataTypes,
      List<DataTypeDescription> simpleDataTypes) {
    super();
    this.noOfNamespaces = noOfNamespaces;
    this.namespaces = namespaces;
    this.noOfStructureDataTypes = noOfStructureDataTypes;
    this.structureDataTypes = structureDataTypes;
    this.noOfEnumDataTypes = noOfEnumDataTypes;
    this.enumDataTypes = enumDataTypes;
    this.noOfSimpleDataTypes = noOfSimpleDataTypes;
    this.simpleDataTypes = simpleDataTypes;
  }

  public int getNoOfNamespaces() {
    return noOfNamespaces;
  }

  public List<PascalString> getNamespaces() {
    return namespaces;
  }

  public int getNoOfStructureDataTypes() {
    return noOfStructureDataTypes;
  }

  public List<DataTypeDescription> getStructureDataTypes() {
    return structureDataTypes;
  }

  public int getNoOfEnumDataTypes() {
    return noOfEnumDataTypes;
  }

  public List<DataTypeDescription> getEnumDataTypes() {
    return enumDataTypes;
  }

  public int getNoOfSimpleDataTypes() {
    return noOfSimpleDataTypes;
  }

  public List<DataTypeDescription> getSimpleDataTypes() {
    return simpleDataTypes;
  }

  @Override
  protected void serializeExtensionObjectDefinitionChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("DataTypeSchemaHeader");

    // Simple Field (noOfNamespaces)
    writeSimpleField("noOfNamespaces", noOfNamespaces, writeSignedInt(writeBuffer, 32));

    // Array Field (namespaces)
    writeComplexTypeArrayField("namespaces", namespaces, writeBuffer);

    // Simple Field (noOfStructureDataTypes)
    writeSimpleField(
        "noOfStructureDataTypes", noOfStructureDataTypes, writeSignedInt(writeBuffer, 32));

    // Array Field (structureDataTypes)
    writeComplexTypeArrayField("structureDataTypes", structureDataTypes, writeBuffer);

    // Simple Field (noOfEnumDataTypes)
    writeSimpleField("noOfEnumDataTypes", noOfEnumDataTypes, writeSignedInt(writeBuffer, 32));

    // Array Field (enumDataTypes)
    writeComplexTypeArrayField("enumDataTypes", enumDataTypes, writeBuffer);

    // Simple Field (noOfSimpleDataTypes)
    writeSimpleField("noOfSimpleDataTypes", noOfSimpleDataTypes, writeSignedInt(writeBuffer, 32));

    // Array Field (simpleDataTypes)
    writeComplexTypeArrayField("simpleDataTypes", simpleDataTypes, writeBuffer);

    writeBuffer.popContext("DataTypeSchemaHeader");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    DataTypeSchemaHeader _value = this;

    // Simple field (noOfNamespaces)
    lengthInBits += 32;

    // Array field
    if (namespaces != null) {
      int i = 0;
      for (PascalString element : namespaces) {
        boolean last = ++i >= namespaces.size();
        lengthInBits += element.getLengthInBits();
      }
    }

    // Simple field (noOfStructureDataTypes)
    lengthInBits += 32;

    // Array field
    if (structureDataTypes != null) {
      int i = 0;
      for (DataTypeDescription element : structureDataTypes) {
        boolean last = ++i >= structureDataTypes.size();
        lengthInBits += element.getLengthInBits();
      }
    }

    // Simple field (noOfEnumDataTypes)
    lengthInBits += 32;

    // Array field
    if (enumDataTypes != null) {
      int i = 0;
      for (DataTypeDescription element : enumDataTypes) {
        boolean last = ++i >= enumDataTypes.size();
        lengthInBits += element.getLengthInBits();
      }
    }

    // Simple field (noOfSimpleDataTypes)
    lengthInBits += 32;

    // Array field
    if (simpleDataTypes != null) {
      int i = 0;
      for (DataTypeDescription element : simpleDataTypes) {
        boolean last = ++i >= simpleDataTypes.size();
        lengthInBits += element.getLengthInBits();
      }
    }

    return lengthInBits;
  }

  public static ExtensionObjectDefinitionBuilder staticParseExtensionObjectDefinitionBuilder(
      ReadBuffer readBuffer, String identifier) throws ParseException {
    readBuffer.pullContext("DataTypeSchemaHeader");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    int noOfNamespaces = readSimpleField("noOfNamespaces", readSignedInt(readBuffer, 32));

    List<PascalString> namespaces =
        readCountArrayField(
            "namespaces",
            new DataReaderComplexDefault<>(() -> PascalString.staticParse(readBuffer), readBuffer),
            noOfNamespaces);

    int noOfStructureDataTypes =
        readSimpleField("noOfStructureDataTypes", readSignedInt(readBuffer, 32));

    List<DataTypeDescription> structureDataTypes =
        readCountArrayField(
            "structureDataTypes",
            new DataReaderComplexDefault<>(
                () ->
                    (DataTypeDescription)
                        ExtensionObjectDefinition.staticParse(readBuffer, (String) ("14525")),
                readBuffer),
            noOfStructureDataTypes);

    int noOfEnumDataTypes = readSimpleField("noOfEnumDataTypes", readSignedInt(readBuffer, 32));

    List<DataTypeDescription> enumDataTypes =
        readCountArrayField(
            "enumDataTypes",
            new DataReaderComplexDefault<>(
                () ->
                    (DataTypeDescription)
                        ExtensionObjectDefinition.staticParse(readBuffer, (String) ("14525")),
                readBuffer),
            noOfEnumDataTypes);

    int noOfSimpleDataTypes = readSimpleField("noOfSimpleDataTypes", readSignedInt(readBuffer, 32));

    List<DataTypeDescription> simpleDataTypes =
        readCountArrayField(
            "simpleDataTypes",
            new DataReaderComplexDefault<>(
                () ->
                    (DataTypeDescription)
                        ExtensionObjectDefinition.staticParse(readBuffer, (String) ("14525")),
                readBuffer),
            noOfSimpleDataTypes);

    readBuffer.closeContext("DataTypeSchemaHeader");
    // Create the instance
    return new DataTypeSchemaHeaderBuilderImpl(
        noOfNamespaces,
        namespaces,
        noOfStructureDataTypes,
        structureDataTypes,
        noOfEnumDataTypes,
        enumDataTypes,
        noOfSimpleDataTypes,
        simpleDataTypes);
  }

  public static class DataTypeSchemaHeaderBuilderImpl
      implements ExtensionObjectDefinition.ExtensionObjectDefinitionBuilder {
    private final int noOfNamespaces;
    private final List<PascalString> namespaces;
    private final int noOfStructureDataTypes;
    private final List<DataTypeDescription> structureDataTypes;
    private final int noOfEnumDataTypes;
    private final List<DataTypeDescription> enumDataTypes;
    private final int noOfSimpleDataTypes;
    private final List<DataTypeDescription> simpleDataTypes;

    public DataTypeSchemaHeaderBuilderImpl(
        int noOfNamespaces,
        List<PascalString> namespaces,
        int noOfStructureDataTypes,
        List<DataTypeDescription> structureDataTypes,
        int noOfEnumDataTypes,
        List<DataTypeDescription> enumDataTypes,
        int noOfSimpleDataTypes,
        List<DataTypeDescription> simpleDataTypes) {

      this.noOfNamespaces = noOfNamespaces;
      this.namespaces = namespaces;
      this.noOfStructureDataTypes = noOfStructureDataTypes;
      this.structureDataTypes = structureDataTypes;
      this.noOfEnumDataTypes = noOfEnumDataTypes;
      this.enumDataTypes = enumDataTypes;
      this.noOfSimpleDataTypes = noOfSimpleDataTypes;
      this.simpleDataTypes = simpleDataTypes;
    }

    public DataTypeSchemaHeader build() {
      DataTypeSchemaHeader dataTypeSchemaHeader =
          new DataTypeSchemaHeader(
              noOfNamespaces,
              namespaces,
              noOfStructureDataTypes,
              structureDataTypes,
              noOfEnumDataTypes,
              enumDataTypes,
              noOfSimpleDataTypes,
              simpleDataTypes);
      return dataTypeSchemaHeader;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DataTypeSchemaHeader)) {
      return false;
    }
    DataTypeSchemaHeader that = (DataTypeSchemaHeader) o;
    return (getNoOfNamespaces() == that.getNoOfNamespaces())
        && (getNamespaces() == that.getNamespaces())
        && (getNoOfStructureDataTypes() == that.getNoOfStructureDataTypes())
        && (getStructureDataTypes() == that.getStructureDataTypes())
        && (getNoOfEnumDataTypes() == that.getNoOfEnumDataTypes())
        && (getEnumDataTypes() == that.getEnumDataTypes())
        && (getNoOfSimpleDataTypes() == that.getNoOfSimpleDataTypes())
        && (getSimpleDataTypes() == that.getSimpleDataTypes())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(),
        getNoOfNamespaces(),
        getNamespaces(),
        getNoOfStructureDataTypes(),
        getStructureDataTypes(),
        getNoOfEnumDataTypes(),
        getEnumDataTypes(),
        getNoOfSimpleDataTypes(),
        getSimpleDataTypes());
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
