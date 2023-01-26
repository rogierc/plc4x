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

public class CBusPointToPointCommandIndirect extends CBusPointToPointCommand implements Message {

  // Accessors for discriminator values.

  // Properties.
  protected final BridgeAddress bridgeAddress;
  protected final NetworkRoute networkRoute;
  protected final UnitAddress unitAddress;

  // Arguments.
  protected final CBusOptions cBusOptions;

  public CBusPointToPointCommandIndirect(
      int bridgeAddressCountPeek,
      CALData calData,
      BridgeAddress bridgeAddress,
      NetworkRoute networkRoute,
      UnitAddress unitAddress,
      CBusOptions cBusOptions) {
    super(bridgeAddressCountPeek, calData, cBusOptions);
    this.bridgeAddress = bridgeAddress;
    this.networkRoute = networkRoute;
    this.unitAddress = unitAddress;
    this.cBusOptions = cBusOptions;
  }

  public BridgeAddress getBridgeAddress() {
    return bridgeAddress;
  }

  public NetworkRoute getNetworkRoute() {
    return networkRoute;
  }

  public UnitAddress getUnitAddress() {
    return unitAddress;
  }

  @Override
  protected void serializeCBusPointToPointCommandChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("CBusPointToPointCommandIndirect");

    // Simple Field (bridgeAddress)
    writeSimpleField("bridgeAddress", bridgeAddress, new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (networkRoute)
    writeSimpleField("networkRoute", networkRoute, new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (unitAddress)
    writeSimpleField("unitAddress", unitAddress, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("CBusPointToPointCommandIndirect");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    CBusPointToPointCommandIndirect _value = this;

    // Simple field (bridgeAddress)
    lengthInBits += bridgeAddress.getLengthInBits();

    // Simple field (networkRoute)
    lengthInBits += networkRoute.getLengthInBits();

    // Simple field (unitAddress)
    lengthInBits += unitAddress.getLengthInBits();

    return lengthInBits;
  }

  public static CBusPointToPointCommandBuilder staticParseCBusPointToPointCommandBuilder(
      ReadBuffer readBuffer, CBusOptions cBusOptions) throws ParseException {
    readBuffer.pullContext("CBusPointToPointCommandIndirect");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    BridgeAddress bridgeAddress =
        readSimpleField(
            "bridgeAddress",
            new DataReaderComplexDefault<>(
                () -> BridgeAddress.staticParse(readBuffer), readBuffer));

    NetworkRoute networkRoute =
        readSimpleField(
            "networkRoute",
            new DataReaderComplexDefault<>(() -> NetworkRoute.staticParse(readBuffer), readBuffer));

    UnitAddress unitAddress =
        readSimpleField(
            "unitAddress",
            new DataReaderComplexDefault<>(() -> UnitAddress.staticParse(readBuffer), readBuffer));

    readBuffer.closeContext("CBusPointToPointCommandIndirect");
    // Create the instance
    return new CBusPointToPointCommandIndirectBuilderImpl(
        bridgeAddress, networkRoute, unitAddress, cBusOptions);
  }

  public static class CBusPointToPointCommandIndirectBuilderImpl
      implements CBusPointToPointCommand.CBusPointToPointCommandBuilder {
    private final BridgeAddress bridgeAddress;
    private final NetworkRoute networkRoute;
    private final UnitAddress unitAddress;
    private final CBusOptions cBusOptions;

    public CBusPointToPointCommandIndirectBuilderImpl(
        BridgeAddress bridgeAddress,
        NetworkRoute networkRoute,
        UnitAddress unitAddress,
        CBusOptions cBusOptions) {

      this.bridgeAddress = bridgeAddress;
      this.networkRoute = networkRoute;
      this.unitAddress = unitAddress;
      this.cBusOptions = cBusOptions;
    }

    public CBusPointToPointCommandIndirect build(
        int bridgeAddressCountPeek, CALData calData, CBusOptions cBusOptions) {
      CBusPointToPointCommandIndirect cBusPointToPointCommandIndirect =
          new CBusPointToPointCommandIndirect(
              bridgeAddressCountPeek,
              calData,
              bridgeAddress,
              networkRoute,
              unitAddress,
              cBusOptions);
      return cBusPointToPointCommandIndirect;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CBusPointToPointCommandIndirect)) {
      return false;
    }
    CBusPointToPointCommandIndirect that = (CBusPointToPointCommandIndirect) o;
    return (getBridgeAddress() == that.getBridgeAddress())
        && (getNetworkRoute() == that.getNetworkRoute())
        && (getUnitAddress() == that.getUnitAddress())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getBridgeAddress(), getNetworkRoute(), getUnitAddress());
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
