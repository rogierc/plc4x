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
package org.apache.plc4x.java.cbus.readwrite;

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

public class LevelInformationCorrupted extends LevelInformation implements Message {

  // Accessors for discriminator values.

  // Properties.
  protected final byte corruptedNibble1;
  protected final byte corruptedNibble2;
  protected final byte corruptedNibble3;
  protected final byte corruptedNibble4;

  public LevelInformationCorrupted(
      int raw,
      byte corruptedNibble1,
      byte corruptedNibble2,
      byte corruptedNibble3,
      byte corruptedNibble4) {
    super(raw);
    this.corruptedNibble1 = corruptedNibble1;
    this.corruptedNibble2 = corruptedNibble2;
    this.corruptedNibble3 = corruptedNibble3;
    this.corruptedNibble4 = corruptedNibble4;
  }

  public byte getCorruptedNibble1() {
    return corruptedNibble1;
  }

  public byte getCorruptedNibble2() {
    return corruptedNibble2;
  }

  public byte getCorruptedNibble3() {
    return corruptedNibble3;
  }

  public byte getCorruptedNibble4() {
    return corruptedNibble4;
  }

  @Override
  protected void serializeLevelInformationChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("LevelInformationCorrupted");

    // Simple Field (corruptedNibble1)
    writeSimpleField("corruptedNibble1", corruptedNibble1, writeUnsignedByte(writeBuffer, 4));

    // Simple Field (corruptedNibble2)
    writeSimpleField("corruptedNibble2", corruptedNibble2, writeUnsignedByte(writeBuffer, 4));

    // Simple Field (corruptedNibble3)
    writeSimpleField("corruptedNibble3", corruptedNibble3, writeUnsignedByte(writeBuffer, 4));

    // Simple Field (corruptedNibble4)
    writeSimpleField("corruptedNibble4", corruptedNibble4, writeUnsignedByte(writeBuffer, 4));

    writeBuffer.popContext("LevelInformationCorrupted");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    LevelInformationCorrupted _value = this;

    // Simple field (corruptedNibble1)
    lengthInBits += 4;

    // Simple field (corruptedNibble2)
    lengthInBits += 4;

    // Simple field (corruptedNibble3)
    lengthInBits += 4;

    // Simple field (corruptedNibble4)
    lengthInBits += 4;

    return lengthInBits;
  }

  public static LevelInformationBuilder staticParseLevelInformationBuilder(ReadBuffer readBuffer)
      throws ParseException {
    readBuffer.pullContext("LevelInformationCorrupted");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    byte corruptedNibble1 = readSimpleField("corruptedNibble1", readUnsignedByte(readBuffer, 4));

    byte corruptedNibble2 = readSimpleField("corruptedNibble2", readUnsignedByte(readBuffer, 4));

    byte corruptedNibble3 = readSimpleField("corruptedNibble3", readUnsignedByte(readBuffer, 4));

    byte corruptedNibble4 = readSimpleField("corruptedNibble4", readUnsignedByte(readBuffer, 4));

    readBuffer.closeContext("LevelInformationCorrupted");
    // Create the instance
    return new LevelInformationCorruptedBuilderImpl(
        corruptedNibble1, corruptedNibble2, corruptedNibble3, corruptedNibble4);
  }

  public static class LevelInformationCorruptedBuilderImpl
      implements LevelInformation.LevelInformationBuilder {
    private final byte corruptedNibble1;
    private final byte corruptedNibble2;
    private final byte corruptedNibble3;
    private final byte corruptedNibble4;

    public LevelInformationCorruptedBuilderImpl(
        byte corruptedNibble1,
        byte corruptedNibble2,
        byte corruptedNibble3,
        byte corruptedNibble4) {

      this.corruptedNibble1 = corruptedNibble1;
      this.corruptedNibble2 = corruptedNibble2;
      this.corruptedNibble3 = corruptedNibble3;
      this.corruptedNibble4 = corruptedNibble4;
    }

    public LevelInformationCorrupted build(int raw) {
      LevelInformationCorrupted levelInformationCorrupted =
          new LevelInformationCorrupted(
              raw, corruptedNibble1, corruptedNibble2, corruptedNibble3, corruptedNibble4);
      return levelInformationCorrupted;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LevelInformationCorrupted)) {
      return false;
    }
    LevelInformationCorrupted that = (LevelInformationCorrupted) o;
    return (getCorruptedNibble1() == that.getCorruptedNibble1())
        && (getCorruptedNibble2() == that.getCorruptedNibble2())
        && (getCorruptedNibble3() == that.getCorruptedNibble3())
        && (getCorruptedNibble4() == that.getCorruptedNibble4())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(),
        getCorruptedNibble1(),
        getCorruptedNibble2(),
        getCorruptedNibble3(),
        getCorruptedNibble4());
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
