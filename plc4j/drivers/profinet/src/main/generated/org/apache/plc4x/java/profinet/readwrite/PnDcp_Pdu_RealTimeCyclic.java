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
package org.apache.plc4x.java.profinet.readwrite;

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

public class PnDcp_Pdu_RealTimeCyclic extends PnDcp_Pdu implements Message {

  // Accessors for discriminator values.

  // Properties.
  protected final int cycleCounter;
  protected final boolean ignore;
  protected final boolean stationProblemIndicatorOk;
  protected final boolean providerStateRun;
  protected final boolean dataValid;
  protected final boolean redundancy;
  protected final boolean statePrimary;
  // Reserved Fields
  private Boolean reservedField0;
  private Boolean reservedField1;
  private Short reservedField2;

  public PnDcp_Pdu_RealTimeCyclic(
      int frameIdValue,
      int cycleCounter,
      boolean ignore,
      boolean stationProblemIndicatorOk,
      boolean providerStateRun,
      boolean dataValid,
      boolean redundancy,
      boolean statePrimary) {
    super(frameIdValue);
    this.cycleCounter = cycleCounter;
    this.ignore = ignore;
    this.stationProblemIndicatorOk = stationProblemIndicatorOk;
    this.providerStateRun = providerStateRun;
    this.dataValid = dataValid;
    this.redundancy = redundancy;
    this.statePrimary = statePrimary;
  }

  public int getCycleCounter() {
    return cycleCounter;
  }

  public boolean getIgnore() {
    return ignore;
  }

  public boolean getStationProblemIndicatorOk() {
    return stationProblemIndicatorOk;
  }

  public boolean getProviderStateRun() {
    return providerStateRun;
  }

  public boolean getDataValid() {
    return dataValid;
  }

  public boolean getRedundancy() {
    return redundancy;
  }

  public boolean getStatePrimary() {
    return statePrimary;
  }

  @Override
  protected void serializePnDcp_PduChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("PnDcp_Pdu_RealTimeCyclic");

    // Simple Field (cycleCounter)
    writeSimpleField("cycleCounter", cycleCounter, writeUnsignedInt(writeBuffer, 16));

    // Simple Field (ignore)
    writeSimpleField("ignore", ignore, writeBoolean(writeBuffer));

    // Reserved Field (reserved)
    writeReservedField(
        "reserved",
        reservedField0 != null ? reservedField0 : (boolean) false,
        writeBoolean(writeBuffer));

    // Simple Field (stationProblemIndicatorOk)
    writeSimpleField(
        "stationProblemIndicatorOk", stationProblemIndicatorOk, writeBoolean(writeBuffer));

    // Simple Field (providerStateRun)
    writeSimpleField("providerStateRun", providerStateRun, writeBoolean(writeBuffer));

    // Reserved Field (reserved)
    writeReservedField(
        "reserved",
        reservedField1 != null ? reservedField1 : (boolean) false,
        writeBoolean(writeBuffer));

    // Simple Field (dataValid)
    writeSimpleField("dataValid", dataValid, writeBoolean(writeBuffer));

    // Simple Field (redundancy)
    writeSimpleField("redundancy", redundancy, writeBoolean(writeBuffer));

    // Simple Field (statePrimary)
    writeSimpleField("statePrimary", statePrimary, writeBoolean(writeBuffer));

    // Reserved Field (reserved)
    writeReservedField(
        "reserved",
        reservedField2 != null ? reservedField2 : (short) 0x00,
        writeUnsignedShort(writeBuffer, 8));

    writeBuffer.popContext("PnDcp_Pdu_RealTimeCyclic");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    PnDcp_Pdu_RealTimeCyclic _value = this;

    // Simple field (cycleCounter)
    lengthInBits += 16;

    // Simple field (ignore)
    lengthInBits += 1;

    // Reserved Field (reserved)
    lengthInBits += 1;

    // Simple field (stationProblemIndicatorOk)
    lengthInBits += 1;

    // Simple field (providerStateRun)
    lengthInBits += 1;

    // Reserved Field (reserved)
    lengthInBits += 1;

    // Simple field (dataValid)
    lengthInBits += 1;

    // Simple field (redundancy)
    lengthInBits += 1;

    // Simple field (statePrimary)
    lengthInBits += 1;

    // Reserved Field (reserved)
    lengthInBits += 8;

    return lengthInBits;
  }

  public static PnDcp_PduBuilder staticParsePnDcp_PduBuilder(ReadBuffer readBuffer)
      throws ParseException {
    readBuffer.pullContext("PnDcp_Pdu_RealTimeCyclic");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    int cycleCounter = readSimpleField("cycleCounter", readUnsignedInt(readBuffer, 16));

    boolean ignore = readSimpleField("ignore", readBoolean(readBuffer));

    Boolean reservedField0 =
        readReservedField("reserved", readBoolean(readBuffer), (boolean) false);

    boolean stationProblemIndicatorOk =
        readSimpleField("stationProblemIndicatorOk", readBoolean(readBuffer));

    boolean providerStateRun = readSimpleField("providerStateRun", readBoolean(readBuffer));

    Boolean reservedField1 =
        readReservedField("reserved", readBoolean(readBuffer), (boolean) false);

    boolean dataValid = readSimpleField("dataValid", readBoolean(readBuffer));

    boolean redundancy = readSimpleField("redundancy", readBoolean(readBuffer));

    boolean statePrimary = readSimpleField("statePrimary", readBoolean(readBuffer));

    Short reservedField2 =
        readReservedField("reserved", readUnsignedShort(readBuffer, 8), (short) 0x00);

    readBuffer.closeContext("PnDcp_Pdu_RealTimeCyclic");
    // Create the instance
    return new PnDcp_Pdu_RealTimeCyclicBuilderImpl(
        cycleCounter,
        ignore,
        stationProblemIndicatorOk,
        providerStateRun,
        dataValid,
        redundancy,
        statePrimary,
        reservedField0,
        reservedField1,
        reservedField2);
  }

  public static class PnDcp_Pdu_RealTimeCyclicBuilderImpl implements PnDcp_Pdu.PnDcp_PduBuilder {
    private final int cycleCounter;
    private final boolean ignore;
    private final boolean stationProblemIndicatorOk;
    private final boolean providerStateRun;
    private final boolean dataValid;
    private final boolean redundancy;
    private final boolean statePrimary;
    private final Boolean reservedField0;
    private final Boolean reservedField1;
    private final Short reservedField2;

    public PnDcp_Pdu_RealTimeCyclicBuilderImpl(
        int cycleCounter,
        boolean ignore,
        boolean stationProblemIndicatorOk,
        boolean providerStateRun,
        boolean dataValid,
        boolean redundancy,
        boolean statePrimary,
        Boolean reservedField0,
        Boolean reservedField1,
        Short reservedField2) {
      this.cycleCounter = cycleCounter;
      this.ignore = ignore;
      this.stationProblemIndicatorOk = stationProblemIndicatorOk;
      this.providerStateRun = providerStateRun;
      this.dataValid = dataValid;
      this.redundancy = redundancy;
      this.statePrimary = statePrimary;
      this.reservedField0 = reservedField0;
      this.reservedField1 = reservedField1;
      this.reservedField2 = reservedField2;
    }

    public PnDcp_Pdu_RealTimeCyclic build(int frameIdValue) {
      PnDcp_Pdu_RealTimeCyclic pnDcp_Pdu_RealTimeCyclic =
          new PnDcp_Pdu_RealTimeCyclic(
              frameIdValue,
              cycleCounter,
              ignore,
              stationProblemIndicatorOk,
              providerStateRun,
              dataValid,
              redundancy,
              statePrimary);
      pnDcp_Pdu_RealTimeCyclic.reservedField0 = reservedField0;
      pnDcp_Pdu_RealTimeCyclic.reservedField1 = reservedField1;
      pnDcp_Pdu_RealTimeCyclic.reservedField2 = reservedField2;
      return pnDcp_Pdu_RealTimeCyclic;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PnDcp_Pdu_RealTimeCyclic)) {
      return false;
    }
    PnDcp_Pdu_RealTimeCyclic that = (PnDcp_Pdu_RealTimeCyclic) o;
    return (getCycleCounter() == that.getCycleCounter())
        && (getIgnore() == that.getIgnore())
        && (getStationProblemIndicatorOk() == that.getStationProblemIndicatorOk())
        && (getProviderStateRun() == that.getProviderStateRun())
        && (getDataValid() == that.getDataValid())
        && (getRedundancy() == that.getRedundancy())
        && (getStatePrimary() == that.getStatePrimary())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(),
        getCycleCounter(),
        getIgnore(),
        getStationProblemIndicatorOk(),
        getProviderStateRun(),
        getDataValid(),
        getRedundancy(),
        getStatePrimary());
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
