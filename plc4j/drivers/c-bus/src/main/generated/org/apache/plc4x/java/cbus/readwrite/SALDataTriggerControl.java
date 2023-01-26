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

public class SALDataTriggerControl extends SALData implements Message {

  // Accessors for discriminator values.
  public ApplicationId getApplicationId() {
    return ApplicationId.TRIGGER_CONTROL;
  }

  // Properties.
  protected final TriggerControlData triggerControlData;

  public SALDataTriggerControl(SALData salData, TriggerControlData triggerControlData) {
    super(salData);
    this.triggerControlData = triggerControlData;
  }

  public TriggerControlData getTriggerControlData() {
    return triggerControlData;
  }

  @Override
  protected void serializeSALDataChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("SALDataTriggerControl");

    // Simple Field (triggerControlData)
    writeSimpleField(
        "triggerControlData", triggerControlData, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("SALDataTriggerControl");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    SALDataTriggerControl _value = this;

    // Simple field (triggerControlData)
    lengthInBits += triggerControlData.getLengthInBits();

    return lengthInBits;
  }

  public static SALDataBuilder staticParseSALDataBuilder(
      ReadBuffer readBuffer, ApplicationId applicationId) throws ParseException {
    readBuffer.pullContext("SALDataTriggerControl");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    TriggerControlData triggerControlData =
        readSimpleField(
            "triggerControlData",
            new DataReaderComplexDefault<>(
                () -> TriggerControlData.staticParse(readBuffer), readBuffer));

    readBuffer.closeContext("SALDataTriggerControl");
    // Create the instance
    return new SALDataTriggerControlBuilderImpl(triggerControlData);
  }

  public static class SALDataTriggerControlBuilderImpl implements SALData.SALDataBuilder {
    private final TriggerControlData triggerControlData;

    public SALDataTriggerControlBuilderImpl(TriggerControlData triggerControlData) {

      this.triggerControlData = triggerControlData;
    }

    public SALDataTriggerControl build(SALData salData) {
      SALDataTriggerControl sALDataTriggerControl =
          new SALDataTriggerControl(salData, triggerControlData);
      return sALDataTriggerControl;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SALDataTriggerControl)) {
      return false;
    }
    SALDataTriggerControl that = (SALDataTriggerControl) o;
    return (getTriggerControlData() == that.getTriggerControlData()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getTriggerControlData());
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
