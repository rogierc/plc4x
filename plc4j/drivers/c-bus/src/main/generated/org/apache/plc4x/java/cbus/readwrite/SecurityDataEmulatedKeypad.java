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

public class SecurityDataEmulatedKeypad extends SecurityData implements Message {

  // Accessors for discriminator values.

  // Properties.
  protected final byte key;

  public SecurityDataEmulatedKeypad(
      SecurityCommandTypeContainer commandTypeContainer, byte argument, byte key) {
    super(commandTypeContainer, argument);
    this.key = key;
  }

  public byte getKey() {
    return key;
  }

  public boolean getIsAscii() {
    return (boolean) (((getKey()) >= (0x00)) && ((getKey()) <= (0x7F)));
  }

  public boolean getIsCustom() {
    return (boolean) ((getKey()) >= (0x80));
  }

  public boolean getIsEnter() {
    return (boolean) ((getKey()) == (0x0D));
  }

  public boolean getIsShift() {
    return (boolean) ((getKey()) == (0x80));
  }

  public boolean getIsPanic() {
    return (boolean) ((getKey()) == (0x81));
  }

  public boolean getIsFire() {
    return (boolean) ((getKey()) == (0x82));
  }

  public boolean getIsARM() {
    return (boolean) ((getKey()) == (0x83));
  }

  public boolean getIsAway() {
    return (boolean) ((getKey()) == (0x84));
  }

  public boolean getIsNight() {
    return (boolean) ((getKey()) == (0x85));
  }

  public boolean getIsDay() {
    return (boolean) ((getKey()) == (0x86));
  }

  public boolean getIsVacation() {
    return (boolean) ((getKey()) == (0x87));
  }

  @Override
  protected void serializeSecurityDataChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("SecurityDataEmulatedKeypad");

    // Simple Field (key)
    writeSimpleField("key", key, writeByte(writeBuffer, 8));

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    boolean isAscii = getIsAscii();
    writeBuffer.writeVirtual("isAscii", isAscii);

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    boolean isCustom = getIsCustom();
    writeBuffer.writeVirtual("isCustom", isCustom);

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    boolean isEnter = getIsEnter();
    writeBuffer.writeVirtual("isEnter", isEnter);

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    boolean isShift = getIsShift();
    writeBuffer.writeVirtual("isShift", isShift);

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    boolean isPanic = getIsPanic();
    writeBuffer.writeVirtual("isPanic", isPanic);

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    boolean isFire = getIsFire();
    writeBuffer.writeVirtual("isFire", isFire);

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    boolean isARM = getIsARM();
    writeBuffer.writeVirtual("isARM", isARM);

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    boolean isAway = getIsAway();
    writeBuffer.writeVirtual("isAway", isAway);

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    boolean isNight = getIsNight();
    writeBuffer.writeVirtual("isNight", isNight);

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    boolean isDay = getIsDay();
    writeBuffer.writeVirtual("isDay", isDay);

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    boolean isVacation = getIsVacation();
    writeBuffer.writeVirtual("isVacation", isVacation);

    writeBuffer.popContext("SecurityDataEmulatedKeypad");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    SecurityDataEmulatedKeypad _value = this;

    // Simple field (key)
    lengthInBits += 8;

    // A virtual field doesn't have any in- or output.

    // A virtual field doesn't have any in- or output.

    // A virtual field doesn't have any in- or output.

    // A virtual field doesn't have any in- or output.

    // A virtual field doesn't have any in- or output.

    // A virtual field doesn't have any in- or output.

    // A virtual field doesn't have any in- or output.

    // A virtual field doesn't have any in- or output.

    // A virtual field doesn't have any in- or output.

    // A virtual field doesn't have any in- or output.

    // A virtual field doesn't have any in- or output.

    return lengthInBits;
  }

  public static SecurityDataBuilder staticParseSecurityDataBuilder(ReadBuffer readBuffer)
      throws ParseException {
    readBuffer.pullContext("SecurityDataEmulatedKeypad");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    byte key = readSimpleField("key", readByte(readBuffer, 8));
    boolean isAscii =
        readVirtualField("isAscii", boolean.class, ((key) >= (0x00)) && ((key) <= (0x7F)));
    boolean isCustom = readVirtualField("isCustom", boolean.class, (key) >= (0x80));
    boolean isEnter = readVirtualField("isEnter", boolean.class, (key) == (0x0D));
    boolean isShift = readVirtualField("isShift", boolean.class, (key) == (0x80));
    boolean isPanic = readVirtualField("isPanic", boolean.class, (key) == (0x81));
    boolean isFire = readVirtualField("isFire", boolean.class, (key) == (0x82));
    boolean isARM = readVirtualField("isARM", boolean.class, (key) == (0x83));
    boolean isAway = readVirtualField("isAway", boolean.class, (key) == (0x84));
    boolean isNight = readVirtualField("isNight", boolean.class, (key) == (0x85));
    boolean isDay = readVirtualField("isDay", boolean.class, (key) == (0x86));
    boolean isVacation = readVirtualField("isVacation", boolean.class, (key) == (0x87));

    readBuffer.closeContext("SecurityDataEmulatedKeypad");
    // Create the instance
    return new SecurityDataEmulatedKeypadBuilderImpl(key);
  }

  public static class SecurityDataEmulatedKeypadBuilderImpl
      implements SecurityData.SecurityDataBuilder {
    private final byte key;

    public SecurityDataEmulatedKeypadBuilderImpl(byte key) {

      this.key = key;
    }

    public SecurityDataEmulatedKeypad build(
        SecurityCommandTypeContainer commandTypeContainer, byte argument) {
      SecurityDataEmulatedKeypad securityDataEmulatedKeypad =
          new SecurityDataEmulatedKeypad(commandTypeContainer, argument, key);
      return securityDataEmulatedKeypad;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SecurityDataEmulatedKeypad)) {
      return false;
    }
    SecurityDataEmulatedKeypad that = (SecurityDataEmulatedKeypad) o;
    return (getKey() == that.getKey()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getKey());
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
