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

public class RequestCommand extends Request implements Message {

  // Accessors for discriminator values.

  // Constant values.
  public static final Byte INITIATOR = 0x5C;

  // Properties.
  protected final CBusCommand cbusCommand;
  protected final Checksum chksum;
  protected final Alpha alpha;

  // Arguments.
  protected final CBusOptions cBusOptions;

  public RequestCommand(
      RequestType peekedByte,
      RequestType startingCR,
      RequestType resetMode,
      RequestType secondPeek,
      RequestTermination termination,
      CBusCommand cbusCommand,
      Checksum chksum,
      Alpha alpha,
      CBusOptions cBusOptions) {
    super(peekedByte, startingCR, resetMode, secondPeek, termination, cBusOptions);
    this.cbusCommand = cbusCommand;
    this.chksum = chksum;
    this.alpha = alpha;
    this.cBusOptions = cBusOptions;
  }

  public CBusCommand getCbusCommand() {
    return cbusCommand;
  }

  public Checksum getChksum() {
    return chksum;
  }

  public Alpha getAlpha() {
    return alpha;
  }

  public CBusCommand getCbusCommandDecoded() {
    return (CBusCommand) (getCbusCommand());
  }

  public Checksum getChksumDecoded() {
    return (Checksum) (getChksum());
  }

  public byte getInitiator() {
    return INITIATOR;
  }

  @Override
  protected void serializeRequestChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("RequestCommand");

    // Const Field (initiator)
    writeConstField("initiator", INITIATOR, writeByte(writeBuffer, 8));

    // Manual Field (cbusCommand)
    writeManualField(
        "cbusCommand",
        () ->
            org.apache.plc4x.java.cbus.readwrite.utils.StaticHelper.writeCBusCommand(
                writeBuffer, cbusCommand),
        writeBuffer);

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    CBusCommand cbusCommandDecoded = getCbusCommandDecoded();
    writeBuffer.writeVirtual("cbusCommandDecoded", cbusCommandDecoded);

    // Manual Field (chksum)
    writeManualField(
        "chksum",
        () ->
            org.apache.plc4x.java.cbus.readwrite.utils.StaticHelper.calculateChecksum(
                writeBuffer, cbusCommand, cBusOptions.getSrchk()),
        writeBuffer);

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    Checksum chksumDecoded = getChksumDecoded();
    writeBuffer.writeVirtual("chksumDecoded", chksumDecoded);

    // Optional Field (alpha) (Can be skipped, if the value is null)
    writeOptionalField("alpha", alpha, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("RequestCommand");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    RequestCommand _value = this;

    // Const Field (initiator)
    lengthInBits += 8;

    // Manual Field (cbusCommand)
    lengthInBits += (((cbusCommand.getLengthInBytes()) * (2))) * (8);

    // A virtual field doesn't have any in- or output.

    // Manual Field (chksum)
    lengthInBits += (((cBusOptions.getSrchk())) ? (16) : (0));

    // A virtual field doesn't have any in- or output.

    // Optional Field (alpha)
    if (alpha != null) {
      lengthInBits += alpha.getLengthInBits();
    }

    return lengthInBits;
  }

  public static RequestBuilder staticParseRequestBuilder(
      ReadBuffer readBuffer, CBusOptions cBusOptions) throws ParseException {
    readBuffer.pullContext("RequestCommand");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    byte initiator = readConstField("initiator", readByte(readBuffer, 8), RequestCommand.INITIATOR);

    CBusCommand cbusCommand =
        readManualField(
            "cbusCommand",
            readBuffer,
            () ->
                (CBusCommand)
                    (org.apache.plc4x.java.cbus.readwrite.utils.StaticHelper.readCBusCommand(
                        readBuffer, cBusOptions, cBusOptions.getSrchk())));
    CBusCommand cbusCommandDecoded =
        readVirtualField("cbusCommandDecoded", CBusCommand.class, cbusCommand);

    Checksum chksum =
        readManualField(
            "chksum",
            readBuffer,
            () ->
                (Checksum)
                    (org.apache.plc4x.java.cbus.readwrite.utils.StaticHelper
                        .readAndValidateChecksum(readBuffer, cbusCommand, cBusOptions.getSrchk())));
    Checksum chksumDecoded = readVirtualField("chksumDecoded", Checksum.class, chksum);

    Alpha alpha =
        readOptionalField(
            "alpha",
            new DataReaderComplexDefault<>(() -> Alpha.staticParse(readBuffer), readBuffer));

    readBuffer.closeContext("RequestCommand");
    // Create the instance
    return new RequestCommandBuilderImpl(cbusCommand, chksum, alpha, cBusOptions);
  }

  public static class RequestCommandBuilderImpl implements Request.RequestBuilder {
    private final CBusCommand cbusCommand;
    private final Checksum chksum;
    private final Alpha alpha;
    private final CBusOptions cBusOptions;

    public RequestCommandBuilderImpl(
        CBusCommand cbusCommand, Checksum chksum, Alpha alpha, CBusOptions cBusOptions) {

      this.cbusCommand = cbusCommand;
      this.chksum = chksum;
      this.alpha = alpha;
      this.cBusOptions = cBusOptions;
    }

    public RequestCommand build(
        RequestType peekedByte,
        RequestType startingCR,
        RequestType resetMode,
        RequestType secondPeek,
        RequestTermination termination,
        CBusOptions cBusOptions) {
      RequestCommand requestCommand =
          new RequestCommand(
              peekedByte,
              startingCR,
              resetMode,
              secondPeek,
              termination,
              cbusCommand,
              chksum,
              alpha,
              cBusOptions);
      return requestCommand;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RequestCommand)) {
      return false;
    }
    RequestCommand that = (RequestCommand) o;
    return (getCbusCommand() == that.getCbusCommand())
        && (getChksum() == that.getChksum())
        && (getAlpha() == that.getAlpha())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getCbusCommand(), getChksum(), getAlpha());
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
