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

public class NLMReserved extends NLM implements Message {

  // Accessors for discriminator values.
  public Short getMessageType() {
    return 0;
  }

  // Properties.
  protected final byte[] unknownBytes;

  // Arguments.
  protected final Integer apduLength;

  public NLMReserved(byte[] unknownBytes, Integer apduLength) {
    super(apduLength);
    this.unknownBytes = unknownBytes;
    this.apduLength = apduLength;
  }

  public byte[] getUnknownBytes() {
    return unknownBytes;
  }

  @Override
  protected void serializeNLMChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("NLMReserved");

    // Array Field (unknownBytes)
    writeByteArrayField("unknownBytes", unknownBytes, writeByteArray(writeBuffer, 8));

    writeBuffer.popContext("NLMReserved");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    NLMReserved _value = this;

    // Array field
    if (unknownBytes != null) {
      lengthInBits += 8 * unknownBytes.length;
    }

    return lengthInBits;
  }

  public static NLMBuilder staticParseNLMBuilder(ReadBuffer readBuffer, Integer apduLength)
      throws ParseException {
    readBuffer.pullContext("NLMReserved");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    byte[] unknownBytes =
        readBuffer.readByteArray(
            "unknownBytes", Math.toIntExact(((((apduLength) > (0))) ? ((apduLength) - (1)) : 0)));

    readBuffer.closeContext("NLMReserved");
    // Create the instance
    return new NLMReservedBuilderImpl(unknownBytes, apduLength);
  }

  public static class NLMReservedBuilderImpl implements NLM.NLMBuilder {
    private final byte[] unknownBytes;
    private final Integer apduLength;

    public NLMReservedBuilderImpl(byte[] unknownBytes, Integer apduLength) {

      this.unknownBytes = unknownBytes;
      this.apduLength = apduLength;
    }

    public NLMReserved build(Integer apduLength) {

      NLMReserved nLMReserved = new NLMReserved(unknownBytes, apduLength);
      return nLMReserved;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NLMReserved)) {
      return false;
    }
    NLMReserved that = (NLMReserved) o;
    return (getUnknownBytes() == that.getUnknownBytes()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getUnknownBytes());
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
