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

public class InformationObject_EVENT_OF_PROTECTION_EQUIPMENT_WITH_TIME_TAG_CP56TIME2A
    extends InformationObject implements Message {

  // Accessors for discriminator values.
  public TypeIdentification getTypeIdentification() {
    return TypeIdentification.EVENT_OF_PROTECTION_EQUIPMENT_WITH_TIME_TAG_CP56TIME2A;
  }

  // Properties.
  protected final TwoOctetBinaryTime cp16Time2a;
  protected final SevenOctetBinaryTime cp56Time2a;

  public InformationObject_EVENT_OF_PROTECTION_EQUIPMENT_WITH_TIME_TAG_CP56TIME2A(
      int address, TwoOctetBinaryTime cp16Time2a, SevenOctetBinaryTime cp56Time2a) {
    super(address);
    this.cp16Time2a = cp16Time2a;
    this.cp56Time2a = cp56Time2a;
  }

  public TwoOctetBinaryTime getCp16Time2a() {
    return cp16Time2a;
  }

  public SevenOctetBinaryTime getCp56Time2a() {
    return cp56Time2a;
  }

  @Override
  protected void serializeInformationObjectChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    boolean _lastItem = ThreadLocalHelper.lastItemThreadLocal.get();
    writeBuffer.pushContext(
        "InformationObject_EVENT_OF_PROTECTION_EQUIPMENT_WITH_TIME_TAG_CP56TIME2A");

    // Simple Field (cp16Time2a)
    writeSimpleField(
        "cp16Time2a",
        cp16Time2a,
        new DataWriterComplexDefault<>(writeBuffer),
        WithOption.WithByteOrder(ByteOrder.LITTLE_ENDIAN));

    // Simple Field (cp56Time2a)
    writeSimpleField(
        "cp56Time2a",
        cp56Time2a,
        new DataWriterComplexDefault<>(writeBuffer),
        WithOption.WithByteOrder(ByteOrder.LITTLE_ENDIAN));

    writeBuffer.popContext(
        "InformationObject_EVENT_OF_PROTECTION_EQUIPMENT_WITH_TIME_TAG_CP56TIME2A");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    InformationObject_EVENT_OF_PROTECTION_EQUIPMENT_WITH_TIME_TAG_CP56TIME2A _value = this;
    boolean _lastItem = ThreadLocalHelper.lastItemThreadLocal.get();

    // Simple field (cp16Time2a)
    lengthInBits += cp16Time2a.getLengthInBits();

    // Simple field (cp56Time2a)
    lengthInBits += cp56Time2a.getLengthInBits();

    return lengthInBits;
  }

  public static InformationObjectBuilder staticParseInformationObjectBuilder(
      ReadBuffer readBuffer, TypeIdentification typeIdentification) throws ParseException {
    readBuffer.pullContext(
        "InformationObject_EVENT_OF_PROTECTION_EQUIPMENT_WITH_TIME_TAG_CP56TIME2A");
    PositionAware positionAware = readBuffer;
    boolean _lastItem = ThreadLocalHelper.lastItemThreadLocal.get();

    TwoOctetBinaryTime cp16Time2a =
        readSimpleField(
            "cp16Time2a",
            new DataReaderComplexDefault<>(
                () -> TwoOctetBinaryTime.staticParse(readBuffer), readBuffer),
            WithOption.WithByteOrder(ByteOrder.LITTLE_ENDIAN));

    SevenOctetBinaryTime cp56Time2a =
        readSimpleField(
            "cp56Time2a",
            new DataReaderComplexDefault<>(
                () -> SevenOctetBinaryTime.staticParse(readBuffer), readBuffer),
            WithOption.WithByteOrder(ByteOrder.LITTLE_ENDIAN));

    readBuffer.closeContext(
        "InformationObject_EVENT_OF_PROTECTION_EQUIPMENT_WITH_TIME_TAG_CP56TIME2A");
    // Create the instance
    return new InformationObject_EVENT_OF_PROTECTION_EQUIPMENT_WITH_TIME_TAG_CP56TIME2ABuilderImpl(
        cp16Time2a, cp56Time2a);
  }

  public static
  class InformationObject_EVENT_OF_PROTECTION_EQUIPMENT_WITH_TIME_TAG_CP56TIME2ABuilderImpl
      implements InformationObject.InformationObjectBuilder {
    private final TwoOctetBinaryTime cp16Time2a;
    private final SevenOctetBinaryTime cp56Time2a;

    public InformationObject_EVENT_OF_PROTECTION_EQUIPMENT_WITH_TIME_TAG_CP56TIME2ABuilderImpl(
        TwoOctetBinaryTime cp16Time2a, SevenOctetBinaryTime cp56Time2a) {
      this.cp16Time2a = cp16Time2a;
      this.cp56Time2a = cp56Time2a;
    }

    public InformationObject_EVENT_OF_PROTECTION_EQUIPMENT_WITH_TIME_TAG_CP56TIME2A build(
        int address) {
      InformationObject_EVENT_OF_PROTECTION_EQUIPMENT_WITH_TIME_TAG_CP56TIME2A
          informationObject_EVENT_OF_PROTECTION_EQUIPMENT_WITH_TIME_TAG_CP56TIME2A =
              new InformationObject_EVENT_OF_PROTECTION_EQUIPMENT_WITH_TIME_TAG_CP56TIME2A(
                  address, cp16Time2a, cp56Time2a);
      return informationObject_EVENT_OF_PROTECTION_EQUIPMENT_WITH_TIME_TAG_CP56TIME2A;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof InformationObject_EVENT_OF_PROTECTION_EQUIPMENT_WITH_TIME_TAG_CP56TIME2A)) {
      return false;
    }
    InformationObject_EVENT_OF_PROTECTION_EQUIPMENT_WITH_TIME_TAG_CP56TIME2A that =
        (InformationObject_EVENT_OF_PROTECTION_EQUIPMENT_WITH_TIME_TAG_CP56TIME2A) o;
    return (getCp16Time2a() == that.getCp16Time2a())
        && (getCp56Time2a() == that.getCp56Time2a())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getCp16Time2a(), getCp56Time2a());
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
