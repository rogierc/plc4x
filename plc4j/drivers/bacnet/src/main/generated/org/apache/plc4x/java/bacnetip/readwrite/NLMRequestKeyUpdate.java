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

public class NLMRequestKeyUpdate extends NLM implements Message {

  // Accessors for discriminator values.
  public Short getMessageType() {
    return (short) 0x0D;
  }

  // Properties.
  protected final byte set1KeyRevision;
  protected final long set1ActivationTime;
  protected final long set1ExpirationTime;
  protected final byte set2KeyRevision;
  protected final long set2ActivationTime;
  protected final long set2ExpirationTime;
  protected final byte distributionKeyRevision;

  // Arguments.
  protected final Integer apduLength;

  public NLMRequestKeyUpdate(
      byte set1KeyRevision,
      long set1ActivationTime,
      long set1ExpirationTime,
      byte set2KeyRevision,
      long set2ActivationTime,
      long set2ExpirationTime,
      byte distributionKeyRevision,
      Integer apduLength) {
    super(apduLength);
    this.set1KeyRevision = set1KeyRevision;
    this.set1ActivationTime = set1ActivationTime;
    this.set1ExpirationTime = set1ExpirationTime;
    this.set2KeyRevision = set2KeyRevision;
    this.set2ActivationTime = set2ActivationTime;
    this.set2ExpirationTime = set2ExpirationTime;
    this.distributionKeyRevision = distributionKeyRevision;
    this.apduLength = apduLength;
  }

  public byte getSet1KeyRevision() {
    return set1KeyRevision;
  }

  public long getSet1ActivationTime() {
    return set1ActivationTime;
  }

  public long getSet1ExpirationTime() {
    return set1ExpirationTime;
  }

  public byte getSet2KeyRevision() {
    return set2KeyRevision;
  }

  public long getSet2ActivationTime() {
    return set2ActivationTime;
  }

  public long getSet2ExpirationTime() {
    return set2ExpirationTime;
  }

  public byte getDistributionKeyRevision() {
    return distributionKeyRevision;
  }

  @Override
  protected void serializeNLMChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("NLMRequestKeyUpdate");

    // Simple Field (set1KeyRevision)
    writeSimpleField("set1KeyRevision", set1KeyRevision, writeByte(writeBuffer, 8));

    // Simple Field (set1ActivationTime)
    writeSimpleField("set1ActivationTime", set1ActivationTime, writeUnsignedLong(writeBuffer, 32));

    // Simple Field (set1ExpirationTime)
    writeSimpleField("set1ExpirationTime", set1ExpirationTime, writeUnsignedLong(writeBuffer, 32));

    // Simple Field (set2KeyRevision)
    writeSimpleField("set2KeyRevision", set2KeyRevision, writeByte(writeBuffer, 8));

    // Simple Field (set2ActivationTime)
    writeSimpleField("set2ActivationTime", set2ActivationTime, writeUnsignedLong(writeBuffer, 32));

    // Simple Field (set2ExpirationTime)
    writeSimpleField("set2ExpirationTime", set2ExpirationTime, writeUnsignedLong(writeBuffer, 32));

    // Simple Field (distributionKeyRevision)
    writeSimpleField("distributionKeyRevision", distributionKeyRevision, writeByte(writeBuffer, 8));

    writeBuffer.popContext("NLMRequestKeyUpdate");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    NLMRequestKeyUpdate _value = this;

    // Simple field (set1KeyRevision)
    lengthInBits += 8;

    // Simple field (set1ActivationTime)
    lengthInBits += 32;

    // Simple field (set1ExpirationTime)
    lengthInBits += 32;

    // Simple field (set2KeyRevision)
    lengthInBits += 8;

    // Simple field (set2ActivationTime)
    lengthInBits += 32;

    // Simple field (set2ExpirationTime)
    lengthInBits += 32;

    // Simple field (distributionKeyRevision)
    lengthInBits += 8;

    return lengthInBits;
  }

  public static NLMBuilder staticParseNLMBuilder(ReadBuffer readBuffer, Integer apduLength)
      throws ParseException {
    readBuffer.pullContext("NLMRequestKeyUpdate");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    byte set1KeyRevision = readSimpleField("set1KeyRevision", readByte(readBuffer, 8));

    long set1ActivationTime =
        readSimpleField("set1ActivationTime", readUnsignedLong(readBuffer, 32));

    long set1ExpirationTime =
        readSimpleField("set1ExpirationTime", readUnsignedLong(readBuffer, 32));

    byte set2KeyRevision = readSimpleField("set2KeyRevision", readByte(readBuffer, 8));

    long set2ActivationTime =
        readSimpleField("set2ActivationTime", readUnsignedLong(readBuffer, 32));

    long set2ExpirationTime =
        readSimpleField("set2ExpirationTime", readUnsignedLong(readBuffer, 32));

    byte distributionKeyRevision =
        readSimpleField("distributionKeyRevision", readByte(readBuffer, 8));

    readBuffer.closeContext("NLMRequestKeyUpdate");
    // Create the instance
    return new NLMRequestKeyUpdateBuilderImpl(
        set1KeyRevision,
        set1ActivationTime,
        set1ExpirationTime,
        set2KeyRevision,
        set2ActivationTime,
        set2ExpirationTime,
        distributionKeyRevision,
        apduLength);
  }

  public static class NLMRequestKeyUpdateBuilderImpl implements NLM.NLMBuilder {
    private final byte set1KeyRevision;
    private final long set1ActivationTime;
    private final long set1ExpirationTime;
    private final byte set2KeyRevision;
    private final long set2ActivationTime;
    private final long set2ExpirationTime;
    private final byte distributionKeyRevision;
    private final Integer apduLength;

    public NLMRequestKeyUpdateBuilderImpl(
        byte set1KeyRevision,
        long set1ActivationTime,
        long set1ExpirationTime,
        byte set2KeyRevision,
        long set2ActivationTime,
        long set2ExpirationTime,
        byte distributionKeyRevision,
        Integer apduLength) {

      this.set1KeyRevision = set1KeyRevision;
      this.set1ActivationTime = set1ActivationTime;
      this.set1ExpirationTime = set1ExpirationTime;
      this.set2KeyRevision = set2KeyRevision;
      this.set2ActivationTime = set2ActivationTime;
      this.set2ExpirationTime = set2ExpirationTime;
      this.distributionKeyRevision = distributionKeyRevision;
      this.apduLength = apduLength;
    }

    public NLMRequestKeyUpdate build(Integer apduLength) {

      NLMRequestKeyUpdate nLMRequestKeyUpdate =
          new NLMRequestKeyUpdate(
              set1KeyRevision,
              set1ActivationTime,
              set1ExpirationTime,
              set2KeyRevision,
              set2ActivationTime,
              set2ExpirationTime,
              distributionKeyRevision,
              apduLength);
      return nLMRequestKeyUpdate;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NLMRequestKeyUpdate)) {
      return false;
    }
    NLMRequestKeyUpdate that = (NLMRequestKeyUpdate) o;
    return (getSet1KeyRevision() == that.getSet1KeyRevision())
        && (getSet1ActivationTime() == that.getSet1ActivationTime())
        && (getSet1ExpirationTime() == that.getSet1ExpirationTime())
        && (getSet2KeyRevision() == that.getSet2KeyRevision())
        && (getSet2ActivationTime() == that.getSet2ActivationTime())
        && (getSet2ExpirationTime() == that.getSet2ExpirationTime())
        && (getDistributionKeyRevision() == that.getDistributionKeyRevision())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(),
        getSet1KeyRevision(),
        getSet1ActivationTime(),
        getSet1ExpirationTime(),
        getSet2KeyRevision(),
        getSet2ActivationTime(),
        getSet2ExpirationTime(),
        getDistributionKeyRevision());
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
