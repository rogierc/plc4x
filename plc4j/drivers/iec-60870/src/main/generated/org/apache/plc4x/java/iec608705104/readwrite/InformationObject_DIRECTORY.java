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

public class InformationObject_DIRECTORY extends InformationObject implements Message {

  // Accessors for discriminator values.
  public TypeIdentification getTypeIdentification() {
    return TypeIdentification.DIRECTORY;
  }

  // Properties.
  protected final NameOfFile nof;
  protected final LengthOfFile lof;
  protected final StatusOfFile sof;
  protected final SevenOctetBinaryTime cp56Time2a;

  public InformationObject_DIRECTORY(
      int address,
      NameOfFile nof,
      LengthOfFile lof,
      StatusOfFile sof,
      SevenOctetBinaryTime cp56Time2a) {
    super(address);
    this.nof = nof;
    this.lof = lof;
    this.sof = sof;
    this.cp56Time2a = cp56Time2a;
  }

  public NameOfFile getNof() {
    return nof;
  }

  public LengthOfFile getLof() {
    return lof;
  }

  public StatusOfFile getSof() {
    return sof;
  }

  public SevenOctetBinaryTime getCp56Time2a() {
    return cp56Time2a;
  }

  @Override
  protected void serializeInformationObjectChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    boolean _lastItem = ThreadLocalHelper.lastItemThreadLocal.get();
    writeBuffer.pushContext("InformationObject_DIRECTORY");

    // Simple Field (nof)
    writeSimpleField(
        "nof",
        nof,
        new DataWriterComplexDefault<>(writeBuffer),
        WithOption.WithByteOrder(ByteOrder.LITTLE_ENDIAN));

    // Simple Field (lof)
    writeSimpleField(
        "lof",
        lof,
        new DataWriterComplexDefault<>(writeBuffer),
        WithOption.WithByteOrder(ByteOrder.LITTLE_ENDIAN));

    // Simple Field (sof)
    writeSimpleField(
        "sof",
        sof,
        new DataWriterComplexDefault<>(writeBuffer),
        WithOption.WithByteOrder(ByteOrder.LITTLE_ENDIAN));

    // Simple Field (cp56Time2a)
    writeSimpleField(
        "cp56Time2a",
        cp56Time2a,
        new DataWriterComplexDefault<>(writeBuffer),
        WithOption.WithByteOrder(ByteOrder.LITTLE_ENDIAN));

    writeBuffer.popContext("InformationObject_DIRECTORY");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    InformationObject_DIRECTORY _value = this;
    boolean _lastItem = ThreadLocalHelper.lastItemThreadLocal.get();

    // Simple field (nof)
    lengthInBits += nof.getLengthInBits();

    // Simple field (lof)
    lengthInBits += lof.getLengthInBits();

    // Simple field (sof)
    lengthInBits += sof.getLengthInBits();

    // Simple field (cp56Time2a)
    lengthInBits += cp56Time2a.getLengthInBits();

    return lengthInBits;
  }

  public static InformationObjectBuilder staticParseInformationObjectBuilder(
      ReadBuffer readBuffer, TypeIdentification typeIdentification) throws ParseException {
    readBuffer.pullContext("InformationObject_DIRECTORY");
    PositionAware positionAware = readBuffer;
    boolean _lastItem = ThreadLocalHelper.lastItemThreadLocal.get();

    NameOfFile nof =
        readSimpleField(
            "nof",
            new DataReaderComplexDefault<>(() -> NameOfFile.staticParse(readBuffer), readBuffer),
            WithOption.WithByteOrder(ByteOrder.LITTLE_ENDIAN));

    LengthOfFile lof =
        readSimpleField(
            "lof",
            new DataReaderComplexDefault<>(() -> LengthOfFile.staticParse(readBuffer), readBuffer),
            WithOption.WithByteOrder(ByteOrder.LITTLE_ENDIAN));

    StatusOfFile sof =
        readSimpleField(
            "sof",
            new DataReaderComplexDefault<>(() -> StatusOfFile.staticParse(readBuffer), readBuffer),
            WithOption.WithByteOrder(ByteOrder.LITTLE_ENDIAN));

    SevenOctetBinaryTime cp56Time2a =
        readSimpleField(
            "cp56Time2a",
            new DataReaderComplexDefault<>(
                () -> SevenOctetBinaryTime.staticParse(readBuffer), readBuffer),
            WithOption.WithByteOrder(ByteOrder.LITTLE_ENDIAN));

    readBuffer.closeContext("InformationObject_DIRECTORY");
    // Create the instance
    return new InformationObject_DIRECTORYBuilderImpl(nof, lof, sof, cp56Time2a);
  }

  public static class InformationObject_DIRECTORYBuilderImpl
      implements InformationObject.InformationObjectBuilder {
    private final NameOfFile nof;
    private final LengthOfFile lof;
    private final StatusOfFile sof;
    private final SevenOctetBinaryTime cp56Time2a;

    public InformationObject_DIRECTORYBuilderImpl(
        NameOfFile nof, LengthOfFile lof, StatusOfFile sof, SevenOctetBinaryTime cp56Time2a) {
      this.nof = nof;
      this.lof = lof;
      this.sof = sof;
      this.cp56Time2a = cp56Time2a;
    }

    public InformationObject_DIRECTORY build(int address) {
      InformationObject_DIRECTORY informationObject_DIRECTORY =
          new InformationObject_DIRECTORY(address, nof, lof, sof, cp56Time2a);
      return informationObject_DIRECTORY;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof InformationObject_DIRECTORY)) {
      return false;
    }
    InformationObject_DIRECTORY that = (InformationObject_DIRECTORY) o;
    return (getNof() == that.getNof())
        && (getLof() == that.getLof())
        && (getSof() == that.getSof())
        && (getCp56Time2a() == that.getCp56Time2a())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getNof(), getLof(), getSof(), getCp56Time2a());
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
