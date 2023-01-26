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
package org.apache.plc4x.java.firmata.readwrite;

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

public class FirmataCommandSysex extends FirmataCommand implements Message {

  // Accessors for discriminator values.
  public Byte getCommandCode() {
    return (byte) 0x0;
  }

  // Properties.
  protected final SysexCommand command;

  // Arguments.
  protected final Boolean response;
  // Reserved Fields
  private Short reservedField0;

  public FirmataCommandSysex(SysexCommand command, Boolean response) {
    super(response);
    this.command = command;
    this.response = response;
  }

  public SysexCommand getCommand() {
    return command;
  }

  @Override
  protected void serializeFirmataCommandChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("FirmataCommandSysex");

    // Simple Field (command)
    writeSimpleField("command", command, new DataWriterComplexDefault<>(writeBuffer));

    // Reserved Field (reserved)
    writeReservedField(
        "reserved",
        reservedField0 != null ? reservedField0 : (short) 0xF7,
        writeUnsignedShort(writeBuffer, 8));

    writeBuffer.popContext("FirmataCommandSysex");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    FirmataCommandSysex _value = this;

    // Simple field (command)
    lengthInBits += command.getLengthInBits();

    // Reserved Field (reserved)
    lengthInBits += 8;

    return lengthInBits;
  }

  public static FirmataCommandBuilder staticParseFirmataCommandBuilder(
      ReadBuffer readBuffer, Boolean response) throws ParseException {
    readBuffer.pullContext("FirmataCommandSysex");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    SysexCommand command =
        readSimpleField(
            "command",
            new DataReaderComplexDefault<>(
                () -> SysexCommand.staticParse(readBuffer, (boolean) (response)), readBuffer));

    Short reservedField0 =
        readReservedField("reserved", readUnsignedShort(readBuffer, 8), (short) 0xF7);

    readBuffer.closeContext("FirmataCommandSysex");
    // Create the instance
    return new FirmataCommandSysexBuilderImpl(command, response, reservedField0);
  }

  public static class FirmataCommandSysexBuilderImpl
      implements FirmataCommand.FirmataCommandBuilder {
    private final SysexCommand command;
    private final Boolean response;
    private final Short reservedField0;

    public FirmataCommandSysexBuilderImpl(
        SysexCommand command, Boolean response, Short reservedField0) {
      this.command = command;
      this.response = response;
      this.reservedField0 = reservedField0;
    }

    public FirmataCommandSysex build(Boolean response) {

      FirmataCommandSysex firmataCommandSysex = new FirmataCommandSysex(command, response);
      firmataCommandSysex.reservedField0 = reservedField0;
      return firmataCommandSysex;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof FirmataCommandSysex)) {
      return false;
    }
    FirmataCommandSysex that = (FirmataCommandSysex) o;
    return (getCommand() == that.getCommand()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getCommand());
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
