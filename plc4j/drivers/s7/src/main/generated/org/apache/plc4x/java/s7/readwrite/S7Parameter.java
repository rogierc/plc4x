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
package org.apache.plc4x.java.s7.readwrite;

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

public abstract class S7Parameter implements Message {

  // Abstract accessors for discriminator values.
  public abstract Short getMessageType();

  public abstract Short getParameterType();

  public S7Parameter() {
    super();
  }

  protected abstract void serializeS7ParameterChild(WriteBuffer writeBuffer)
      throws SerializationException;

  public void serialize(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("S7Parameter");

    // Discriminator Field (parameterType) (Used as input to a switch field)
    writeDiscriminatorField(
        "parameterType", getParameterType(), writeUnsignedShort(writeBuffer, 8));

    // Switch field (Serialize the sub-type)
    serializeS7ParameterChild(writeBuffer);

    writeBuffer.popContext("S7Parameter");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = 0;
    S7Parameter _value = this;

    // Discriminator Field (parameterType)
    lengthInBits += 8;

    // Length of sub-type elements will be added by sub-type...

    return lengthInBits;
  }

  public static S7Parameter staticParse(ReadBuffer readBuffer, Object... args)
      throws ParseException {
    PositionAware positionAware = readBuffer;
    if ((args == null) || (args.length != 1)) {
      throw new PlcRuntimeException(
          "Wrong number of arguments, expected 1, but got " + args.length);
    }
    Short messageType;
    if (args[0] instanceof Short) {
      messageType = (Short) args[0];
    } else if (args[0] instanceof String) {
      messageType = Short.valueOf((String) args[0]);
    } else {
      throw new PlcRuntimeException(
          "Argument 0 expected to be of type Short or a string which is parseable but was "
              + args[0].getClass().getName());
    }
    return staticParse(readBuffer, messageType);
  }

  public static S7Parameter staticParse(ReadBuffer readBuffer, Short messageType)
      throws ParseException {
    readBuffer.pullContext("S7Parameter");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    short parameterType = readDiscriminatorField("parameterType", readUnsignedShort(readBuffer, 8));

    // Switch Field (Depending on the discriminator values, passes the instantiation to a sub-type)
    S7ParameterBuilder builder = null;
    if (EvaluationHelper.equals(parameterType, (short) 0xF0)) {
      builder =
          S7ParameterSetupCommunication.staticParseS7ParameterBuilder(readBuffer, messageType);
    } else if (EvaluationHelper.equals(parameterType, (short) 0x04)
        && EvaluationHelper.equals(messageType, (short) 0x01)) {
      builder = S7ParameterReadVarRequest.staticParseS7ParameterBuilder(readBuffer, messageType);
    } else if (EvaluationHelper.equals(parameterType, (short) 0x04)
        && EvaluationHelper.equals(messageType, (short) 0x03)) {
      builder = S7ParameterReadVarResponse.staticParseS7ParameterBuilder(readBuffer, messageType);
    } else if (EvaluationHelper.equals(parameterType, (short) 0x05)
        && EvaluationHelper.equals(messageType, (short) 0x01)) {
      builder = S7ParameterWriteVarRequest.staticParseS7ParameterBuilder(readBuffer, messageType);
    } else if (EvaluationHelper.equals(parameterType, (short) 0x05)
        && EvaluationHelper.equals(messageType, (short) 0x03)) {
      builder = S7ParameterWriteVarResponse.staticParseS7ParameterBuilder(readBuffer, messageType);
    } else if (EvaluationHelper.equals(parameterType, (short) 0x00)
        && EvaluationHelper.equals(messageType, (short) 0x07)) {
      builder = S7ParameterUserData.staticParseS7ParameterBuilder(readBuffer, messageType);
    } else if (EvaluationHelper.equals(parameterType, (short) 0x01)
        && EvaluationHelper.equals(messageType, (short) 0x07)) {
      builder = S7ParameterModeTransition.staticParseS7ParameterBuilder(readBuffer, messageType);
    }
    if (builder == null) {
      throw new ParseException(
          "Unsupported case for discriminated type"
              + " parameters ["
              + "parameterType="
              + parameterType
              + " "
              + "messageType="
              + messageType
              + "]");
    }

    readBuffer.closeContext("S7Parameter");
    // Create the instance
    S7Parameter _s7Parameter = builder.build();
    return _s7Parameter;
  }

  public interface S7ParameterBuilder {
    S7Parameter build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof S7Parameter)) {
      return false;
    }
    S7Parameter that = (S7Parameter) o;
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash();
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
