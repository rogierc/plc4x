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
package org.apache.plc4x.java.knxnetip.readwrite;

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

public abstract class ApduDataExt implements Message {

  // Abstract accessors for discriminator values.
  public abstract Short getExtApciType();

  // Arguments.
  protected final Short length;

  public ApduDataExt(Short length) {
    super();
    this.length = length;
  }

  protected abstract void serializeApduDataExtChild(WriteBuffer writeBuffer)
      throws SerializationException;

  public void serialize(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("ApduDataExt");

    // Discriminator Field (extApciType) (Used as input to a switch field)
    writeDiscriminatorField("extApciType", getExtApciType(), writeUnsignedShort(writeBuffer, 6));

    // Switch field (Serialize the sub-type)
    serializeApduDataExtChild(writeBuffer);

    writeBuffer.popContext("ApduDataExt");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = 0;
    ApduDataExt _value = this;

    // Discriminator Field (extApciType)
    lengthInBits += 6;

    // Length of sub-type elements will be added by sub-type...

    return lengthInBits;
  }

  public static ApduDataExt staticParse(ReadBuffer readBuffer, Object... args)
      throws ParseException {
    PositionAware positionAware = readBuffer;
    if ((args == null) || (args.length != 1)) {
      throw new PlcRuntimeException(
          "Wrong number of arguments, expected 1, but got " + args.length);
    }
    Short length;
    if (args[0] instanceof Short) {
      length = (Short) args[0];
    } else if (args[0] instanceof String) {
      length = Short.valueOf((String) args[0]);
    } else {
      throw new PlcRuntimeException(
          "Argument 0 expected to be of type Short or a string which is parseable but was "
              + args[0].getClass().getName());
    }
    return staticParse(readBuffer, length);
  }

  public static ApduDataExt staticParse(ReadBuffer readBuffer, Short length) throws ParseException {
    readBuffer.pullContext("ApduDataExt");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    short extApciType = readDiscriminatorField("extApciType", readUnsignedShort(readBuffer, 6));

    // Switch Field (Depending on the discriminator values, passes the instantiation to a sub-type)
    ApduDataExtBuilder builder = null;
    if (EvaluationHelper.equals(extApciType, (short) 0x00)) {
      builder =
          ApduDataExtOpenRoutingTableRequest.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x01)) {
      builder =
          ApduDataExtReadRoutingTableRequest.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x02)) {
      builder =
          ApduDataExtReadRoutingTableResponse.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x03)) {
      builder =
          ApduDataExtWriteRoutingTableRequest.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x08)) {
      builder =
          ApduDataExtReadRouterMemoryRequest.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x09)) {
      builder =
          ApduDataExtReadRouterMemoryResponse.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x0A)) {
      builder =
          ApduDataExtWriteRouterMemoryRequest.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x0D)) {
      builder =
          ApduDataExtReadRouterStatusRequest.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x0E)) {
      builder =
          ApduDataExtReadRouterStatusResponse.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x0F)) {
      builder =
          ApduDataExtWriteRouterStatusRequest.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x10)) {
      builder = ApduDataExtMemoryBitWrite.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x11)) {
      builder = ApduDataExtAuthorizeRequest.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x12)) {
      builder = ApduDataExtAuthorizeResponse.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x13)) {
      builder = ApduDataExtKeyWrite.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x14)) {
      builder = ApduDataExtKeyResponse.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x15)) {
      builder = ApduDataExtPropertyValueRead.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x16)) {
      builder = ApduDataExtPropertyValueResponse.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x17)) {
      builder = ApduDataExtPropertyValueWrite.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x18)) {
      builder =
          ApduDataExtPropertyDescriptionRead.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x19)) {
      builder =
          ApduDataExtPropertyDescriptionResponse.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x1A)) {
      builder = ApduDataExtNetworkParameterRead.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x1B)) {
      builder =
          ApduDataExtNetworkParameterResponse.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x1C)) {
      builder =
          ApduDataExtIndividualAddressSerialNumberRead.staticParseApduDataExtBuilder(
              readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x1D)) {
      builder =
          ApduDataExtIndividualAddressSerialNumberResponse.staticParseApduDataExtBuilder(
              readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x1E)) {
      builder =
          ApduDataExtIndividualAddressSerialNumberWrite.staticParseApduDataExtBuilder(
              readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x20)) {
      builder = ApduDataExtDomainAddressWrite.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x21)) {
      builder = ApduDataExtDomainAddressRead.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x22)) {
      builder = ApduDataExtDomainAddressResponse.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x23)) {
      builder =
          ApduDataExtDomainAddressSelectiveRead.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x24)) {
      builder = ApduDataExtNetworkParameterWrite.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x25)) {
      builder = ApduDataExtLinkRead.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x26)) {
      builder = ApduDataExtLinkResponse.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x27)) {
      builder = ApduDataExtLinkWrite.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x28)) {
      builder = ApduDataExtGroupPropertyValueRead.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x29)) {
      builder =
          ApduDataExtGroupPropertyValueResponse.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x2A)) {
      builder =
          ApduDataExtGroupPropertyValueWrite.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x2B)) {
      builder =
          ApduDataExtGroupPropertyValueInfoReport.staticParseApduDataExtBuilder(readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x2C)) {
      builder =
          ApduDataExtDomainAddressSerialNumberRead.staticParseApduDataExtBuilder(
              readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x2D)) {
      builder =
          ApduDataExtDomainAddressSerialNumberResponse.staticParseApduDataExtBuilder(
              readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x2E)) {
      builder =
          ApduDataExtDomainAddressSerialNumberWrite.staticParseApduDataExtBuilder(
              readBuffer, length);
    } else if (EvaluationHelper.equals(extApciType, (short) 0x30)) {
      builder = ApduDataExtFileStreamInfoReport.staticParseApduDataExtBuilder(readBuffer, length);
    }
    if (builder == null) {
      throw new ParseException(
          "Unsupported case for discriminated type"
              + " parameters ["
              + "extApciType="
              + extApciType
              + "]");
    }

    readBuffer.closeContext("ApduDataExt");
    // Create the instance
    ApduDataExt _apduDataExt = builder.build(length);

    return _apduDataExt;
  }

  public interface ApduDataExtBuilder {
    ApduDataExt build(Short length);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ApduDataExt)) {
      return false;
    }
    ApduDataExt that = (ApduDataExt) o;
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
