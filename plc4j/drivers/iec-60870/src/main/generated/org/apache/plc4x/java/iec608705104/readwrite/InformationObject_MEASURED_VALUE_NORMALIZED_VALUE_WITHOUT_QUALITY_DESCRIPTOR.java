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
package org.apache.plc4x.java.iec608705104.readwrite;

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

public class InformationObject_MEASURED_VALUE_NORMALIZED_VALUE_WITHOUT_QUALITY_DESCRIPTOR
    extends InformationObject implements Message {

  // Accessors for discriminator values.
  public TypeIdentification getTypeIdentification() {
    return TypeIdentification.MEASURED_VALUE_NORMALIZED_VALUE_WITHOUT_QUALITY_DESCRIPTOR;
  }

  // Properties.
  protected final NormalizedValue nva;

  public InformationObject_MEASURED_VALUE_NORMALIZED_VALUE_WITHOUT_QUALITY_DESCRIPTOR(
      int address, NormalizedValue nva) {
    super(address);
    this.nva = nva;
  }

  public NormalizedValue getNva() {
    return nva;
  }

  @Override
  protected void serializeInformationObjectChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    boolean _lastItem = ThreadLocalHelper.lastItemThreadLocal.get();
    writeBuffer.pushContext(
        "InformationObject_MEASURED_VALUE_NORMALIZED_VALUE_WITHOUT_QUALITY_DESCRIPTOR");

    // Simple Field (nva)
    writeSimpleField(
        "nva",
        nva,
        new DataWriterComplexDefault<>(writeBuffer),
        WithOption.WithByteOrder(ByteOrder.LITTLE_ENDIAN));

    writeBuffer.popContext(
        "InformationObject_MEASURED_VALUE_NORMALIZED_VALUE_WITHOUT_QUALITY_DESCRIPTOR");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    InformationObject_MEASURED_VALUE_NORMALIZED_VALUE_WITHOUT_QUALITY_DESCRIPTOR _value = this;
    boolean _lastItem = ThreadLocalHelper.lastItemThreadLocal.get();

    // Simple field (nva)
    lengthInBits += nva.getLengthInBits();

    return lengthInBits;
  }

  public static InformationObjectBuilder staticParseInformationObjectBuilder(
      ReadBuffer readBuffer, TypeIdentification typeIdentification) throws ParseException {
    readBuffer.pullContext(
        "InformationObject_MEASURED_VALUE_NORMALIZED_VALUE_WITHOUT_QUALITY_DESCRIPTOR");
    PositionAware positionAware = readBuffer;
    boolean _lastItem = ThreadLocalHelper.lastItemThreadLocal.get();

    NormalizedValue nva =
        readSimpleField(
            "nva",
            new DataReaderComplexDefault<>(
                () -> NormalizedValue.staticParse(readBuffer), readBuffer),
            WithOption.WithByteOrder(ByteOrder.LITTLE_ENDIAN));

    readBuffer.closeContext(
        "InformationObject_MEASURED_VALUE_NORMALIZED_VALUE_WITHOUT_QUALITY_DESCRIPTOR");
    // Create the instance
    return new InformationObject_MEASURED_VALUE_NORMALIZED_VALUE_WITHOUT_QUALITY_DESCRIPTORBuilderImpl(
        nva);
  }

  public static
  class InformationObject_MEASURED_VALUE_NORMALIZED_VALUE_WITHOUT_QUALITY_DESCRIPTORBuilderImpl
      implements InformationObject.InformationObjectBuilder {
    private final NormalizedValue nva;

    public InformationObject_MEASURED_VALUE_NORMALIZED_VALUE_WITHOUT_QUALITY_DESCRIPTORBuilderImpl(
        NormalizedValue nva) {
      this.nva = nva;
    }

    public InformationObject_MEASURED_VALUE_NORMALIZED_VALUE_WITHOUT_QUALITY_DESCRIPTOR build(
        int address) {
      InformationObject_MEASURED_VALUE_NORMALIZED_VALUE_WITHOUT_QUALITY_DESCRIPTOR
          informationObject_MEASURED_VALUE_NORMALIZED_VALUE_WITHOUT_QUALITY_DESCRIPTOR =
              new InformationObject_MEASURED_VALUE_NORMALIZED_VALUE_WITHOUT_QUALITY_DESCRIPTOR(
                  address, nva);
      return informationObject_MEASURED_VALUE_NORMALIZED_VALUE_WITHOUT_QUALITY_DESCRIPTOR;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o
        instanceof InformationObject_MEASURED_VALUE_NORMALIZED_VALUE_WITHOUT_QUALITY_DESCRIPTOR)) {
      return false;
    }
    InformationObject_MEASURED_VALUE_NORMALIZED_VALUE_WITHOUT_QUALITY_DESCRIPTOR that =
        (InformationObject_MEASURED_VALUE_NORMALIZED_VALUE_WITHOUT_QUALITY_DESCRIPTOR) o;
    return (getNva() == that.getNva()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getNva());
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
