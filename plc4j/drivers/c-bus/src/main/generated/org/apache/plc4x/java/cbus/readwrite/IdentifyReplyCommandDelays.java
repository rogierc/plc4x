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

public class IdentifyReplyCommandDelays extends IdentifyReplyCommand implements Message {

  // Accessors for discriminator values.
  public Attribute getAttribute() {
    return Attribute.Delays;
  }

  // Properties.
  protected final byte[] terminalLevels;
  protected final byte reStrikeDelay;

  // Arguments.
  protected final Short numBytes;

  public IdentifyReplyCommandDelays(byte[] terminalLevels, byte reStrikeDelay, Short numBytes) {
    super(numBytes);
    this.terminalLevels = terminalLevels;
    this.reStrikeDelay = reStrikeDelay;
    this.numBytes = numBytes;
  }

  public byte[] getTerminalLevels() {
    return terminalLevels;
  }

  public byte getReStrikeDelay() {
    return reStrikeDelay;
  }

  @Override
  protected void serializeIdentifyReplyCommandChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("IdentifyReplyCommandDelays");

    // Array Field (terminalLevels)
    writeByteArrayField("terminalLevels", terminalLevels, writeByteArray(writeBuffer, 8));

    // Simple Field (reStrikeDelay)
    writeSimpleField("reStrikeDelay", reStrikeDelay, writeByte(writeBuffer, 8));

    writeBuffer.popContext("IdentifyReplyCommandDelays");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    IdentifyReplyCommandDelays _value = this;

    // Array field
    if (terminalLevels != null) {
      lengthInBits += 8 * terminalLevels.length;
    }

    // Simple field (reStrikeDelay)
    lengthInBits += 8;

    return lengthInBits;
  }

  public static IdentifyReplyCommandBuilder staticParseIdentifyReplyCommandBuilder(
      ReadBuffer readBuffer, Attribute attribute, Short numBytes) throws ParseException {
    readBuffer.pullContext("IdentifyReplyCommandDelays");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    byte[] terminalLevels =
        readBuffer.readByteArray("terminalLevels", Math.toIntExact((numBytes) - (1)));

    byte reStrikeDelay = readSimpleField("reStrikeDelay", readByte(readBuffer, 8));

    readBuffer.closeContext("IdentifyReplyCommandDelays");
    // Create the instance
    return new IdentifyReplyCommandDelaysBuilderImpl(terminalLevels, reStrikeDelay, numBytes);
  }

  public static class IdentifyReplyCommandDelaysBuilderImpl
      implements IdentifyReplyCommand.IdentifyReplyCommandBuilder {
    private final byte[] terminalLevels;
    private final byte reStrikeDelay;
    private final Short numBytes;

    public IdentifyReplyCommandDelaysBuilderImpl(
        byte[] terminalLevels, byte reStrikeDelay, Short numBytes) {

      this.terminalLevels = terminalLevels;
      this.reStrikeDelay = reStrikeDelay;
      this.numBytes = numBytes;
    }

    public IdentifyReplyCommandDelays build(Short numBytes) {

      IdentifyReplyCommandDelays identifyReplyCommandDelays =
          new IdentifyReplyCommandDelays(terminalLevels, reStrikeDelay, numBytes);
      return identifyReplyCommandDelays;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof IdentifyReplyCommandDelays)) {
      return false;
    }
    IdentifyReplyCommandDelays that = (IdentifyReplyCommandDelays) o;
    return (getTerminalLevels() == that.getTerminalLevels())
        && (getReStrikeDelay() == that.getReStrikeDelay())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getTerminalLevels(), getReStrikeDelay());
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
