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

public abstract class CALData implements Message {

  // Abstract accessors for discriminator values.

  // Properties.
  protected final CALCommandTypeContainer commandTypeContainer;
  protected final CALData additionalData;

  // Arguments.
  protected final RequestContext requestContext;

  public CALData(
      CALCommandTypeContainer commandTypeContainer,
      CALData additionalData,
      RequestContext requestContext) {
    super();
    this.commandTypeContainer = commandTypeContainer;
    this.additionalData = additionalData;
    this.requestContext = requestContext;
  }

  public CALCommandTypeContainer getCommandTypeContainer() {
    return commandTypeContainer;
  }

  public CALData getAdditionalData() {
    return additionalData;
  }

  public CALCommandType getCommandType() {
    return (CALCommandType) (getCommandTypeContainer().getCommandType());
  }

  public boolean getSendIdentifyRequestBefore() {
    return (boolean)
        ((((requestContext) != (null)) ? requestContext.getSendIdentifyRequestBefore() : false));
  }

  protected abstract void serializeCALDataChild(WriteBuffer writeBuffer)
      throws SerializationException;

  public void serialize(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("CALData");

    // Simple Field (commandTypeContainer)
    writeSimpleEnumField(
        "commandTypeContainer",
        "CALCommandTypeContainer",
        commandTypeContainer,
        new DataWriterEnumDefault<>(
            CALCommandTypeContainer::getValue,
            CALCommandTypeContainer::name,
            writeUnsignedShort(writeBuffer, 8)));

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    CALCommandType commandType = getCommandType();
    writeBuffer.writeVirtual("commandType", commandType);

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    boolean sendIdentifyRequestBefore = getSendIdentifyRequestBefore();
    writeBuffer.writeVirtual("sendIdentifyRequestBefore", sendIdentifyRequestBefore);

    // Switch field (Serialize the sub-type)
    serializeCALDataChild(writeBuffer);

    // Optional Field (additionalData) (Can be skipped, if the value is null)
    writeOptionalField(
        "additionalData", additionalData, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("CALData");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = 0;
    CALData _value = this;

    // Simple field (commandTypeContainer)
    lengthInBits += 8;

    // A virtual field doesn't have any in- or output.

    // A virtual field doesn't have any in- or output.

    // Length of sub-type elements will be added by sub-type...

    // Optional Field (additionalData)
    if (additionalData != null) {
      lengthInBits += additionalData.getLengthInBits();
    }

    return lengthInBits;
  }

  public static CALData staticParse(ReadBuffer readBuffer, Object... args) throws ParseException {
    PositionAware positionAware = readBuffer;
    if ((args == null) || (args.length != 1)) {
      throw new PlcRuntimeException(
          "Wrong number of arguments, expected 1, but got " + args.length);
    }
    RequestContext requestContext;
    if (args[0] instanceof RequestContext) {
      requestContext = (RequestContext) args[0];
    } else {
      throw new PlcRuntimeException(
          "Argument 0 expected to be of type RequestContext or a string which is parseable but was "
              + args[0].getClass().getName());
    }
    return staticParse(readBuffer, requestContext);
  }

  public static CALData staticParse(ReadBuffer readBuffer, RequestContext requestContext)
      throws ParseException {
    readBuffer.pullContext("CALData");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;
    // Validation
    if (!(org.apache.plc4x.java.cbus.readwrite.utils.StaticHelper.knowsCALCommandTypeContainer(
        readBuffer))) {
      throw new ParseAssertException("no command type could be found");
    }

    CALCommandTypeContainer commandTypeContainer =
        readEnumField(
            "commandTypeContainer",
            "CALCommandTypeContainer",
            new DataReaderEnumDefault<>(
                CALCommandTypeContainer::enumForValue, readUnsignedShort(readBuffer, 8)));
    CALCommandType commandType =
        readVirtualField(
            "commandType", CALCommandType.class, commandTypeContainer.getCommandType());
    boolean sendIdentifyRequestBefore =
        readVirtualField(
            "sendIdentifyRequestBefore",
            boolean.class,
            (((requestContext) != (null)) ? requestContext.getSendIdentifyRequestBefore() : false));

    // Switch Field (Depending on the discriminator values, passes the instantiation to a sub-type)
    CALDataBuilder builder = null;
    if (EvaluationHelper.equals(commandType, CALCommandType.RESET)) {
      builder = CALDataReset.staticParseCALDataBuilder(readBuffer, requestContext);
    } else if (EvaluationHelper.equals(commandType, CALCommandType.RECALL)) {
      builder = CALDataRecall.staticParseCALDataBuilder(readBuffer, requestContext);
    } else if (EvaluationHelper.equals(commandType, CALCommandType.IDENTIFY)) {
      builder = CALDataIdentify.staticParseCALDataBuilder(readBuffer, requestContext);
    } else if (EvaluationHelper.equals(commandType, CALCommandType.GET_STATUS)) {
      builder = CALDataGetStatus.staticParseCALDataBuilder(readBuffer, requestContext);
    } else if (EvaluationHelper.equals(commandType, CALCommandType.WRITE)) {
      builder =
          CALDataWrite.staticParseCALDataBuilder(readBuffer, requestContext, commandTypeContainer);
    } else if (EvaluationHelper.equals(commandType, CALCommandType.REPLY)
        && EvaluationHelper.equals(sendIdentifyRequestBefore, (boolean) true)) {
      builder =
          CALDataIdentifyReply.staticParseCALDataBuilder(
              readBuffer, requestContext, commandTypeContainer);
    } else if (EvaluationHelper.equals(commandType, CALCommandType.REPLY)) {
      builder =
          CALDataReply.staticParseCALDataBuilder(readBuffer, requestContext, commandTypeContainer);
    } else if (EvaluationHelper.equals(commandType, CALCommandType.ACKNOWLEDGE)) {
      builder = CALDataAcknowledge.staticParseCALDataBuilder(readBuffer, requestContext);
    } else if (EvaluationHelper.equals(commandType, CALCommandType.STATUS)) {
      builder =
          CALDataStatus.staticParseCALDataBuilder(readBuffer, requestContext, commandTypeContainer);
    } else if (EvaluationHelper.equals(commandType, CALCommandType.STATUS_EXTENDED)) {
      builder =
          CALDataStatusExtended.staticParseCALDataBuilder(
              readBuffer, requestContext, commandTypeContainer);
    }
    if (builder == null) {
      throw new ParseException(
          "Unsupported case for discriminated type"
              + " parameters ["
              + "commandType="
              + commandType
              + " "
              + "sendIdentifyRequestBefore="
              + sendIdentifyRequestBefore
              + "]");
    }

    CALData additionalData =
        readOptionalField(
            "additionalData",
            new DataReaderComplexDefault<>(
                () -> CALData.staticParse(readBuffer, (RequestContext) (null)), readBuffer));

    readBuffer.closeContext("CALData");
    // Create the instance
    CALData _cALData = builder.build(commandTypeContainer, additionalData, requestContext);
    return _cALData;
  }

  public interface CALDataBuilder {
    CALData build(
        CALCommandTypeContainer commandTypeContainer,
        CALData additionalData,
        RequestContext requestContext);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CALData)) {
      return false;
    }
    CALData that = (CALData) o;
    return (getCommandTypeContainer() == that.getCommandTypeContainer())
        && (getAdditionalData() == that.getAdditionalData())
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCommandTypeContainer(), getAdditionalData());
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
