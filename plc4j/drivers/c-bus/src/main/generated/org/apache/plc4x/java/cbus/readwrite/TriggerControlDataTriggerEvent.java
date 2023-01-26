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

public class TriggerControlDataTriggerEvent extends TriggerControlData implements Message {

  // Accessors for discriminator values.

  // Properties.
  protected final byte actionSelector;

  public TriggerControlDataTriggerEvent(
      TriggerControlCommandTypeContainer commandTypeContainer,
      byte triggerGroup,
      byte actionSelector) {
    super(commandTypeContainer, triggerGroup);
    this.actionSelector = actionSelector;
  }

  public byte getActionSelector() {
    return actionSelector;
  }

  @Override
  protected void serializeTriggerControlDataChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("TriggerControlDataTriggerEvent");

    // Simple Field (actionSelector)
    writeSimpleField("actionSelector", actionSelector, writeByte(writeBuffer, 8));

    writeBuffer.popContext("TriggerControlDataTriggerEvent");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    TriggerControlDataTriggerEvent _value = this;

    // Simple field (actionSelector)
    lengthInBits += 8;

    return lengthInBits;
  }

  public static TriggerControlDataBuilder staticParseTriggerControlDataBuilder(
      ReadBuffer readBuffer) throws ParseException {
    readBuffer.pullContext("TriggerControlDataTriggerEvent");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    byte actionSelector = readSimpleField("actionSelector", readByte(readBuffer, 8));

    readBuffer.closeContext("TriggerControlDataTriggerEvent");
    // Create the instance
    return new TriggerControlDataTriggerEventBuilderImpl(actionSelector);
  }

  public static class TriggerControlDataTriggerEventBuilderImpl
      implements TriggerControlData.TriggerControlDataBuilder {
    private final byte actionSelector;

    public TriggerControlDataTriggerEventBuilderImpl(byte actionSelector) {

      this.actionSelector = actionSelector;
    }

    public TriggerControlDataTriggerEvent build(
        TriggerControlCommandTypeContainer commandTypeContainer, byte triggerGroup) {
      TriggerControlDataTriggerEvent triggerControlDataTriggerEvent =
          new TriggerControlDataTriggerEvent(commandTypeContainer, triggerGroup, actionSelector);
      return triggerControlDataTriggerEvent;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TriggerControlDataTriggerEvent)) {
      return false;
    }
    TriggerControlDataTriggerEvent that = (TriggerControlDataTriggerEvent) o;
    return (getActionSelector() == that.getActionSelector()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getActionSelector());
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
