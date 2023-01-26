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
package org.apache.plc4x.java.canopen.readwrite;

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

public class CANOpenPDOPayload extends CANOpenPayload implements Message {

  // Accessors for discriminator values.
  public CANOpenService getService() {
    return CANOpenService.TRANSMIT_PDO_4;
  }

  // Properties.
  protected final CANOpenPDO pdo;

  public CANOpenPDOPayload(CANOpenPDO pdo) {
    super();
    this.pdo = pdo;
  }

  public CANOpenPDO getPdo() {
    return pdo;
  }

  @Override
  protected void serializeCANOpenPayloadChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("CANOpenPDOPayload");

    // Simple Field (pdo)
    writeSimpleField("pdo", pdo, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("CANOpenPDOPayload");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    CANOpenPDOPayload _value = this;

    // Simple field (pdo)
    lengthInBits += pdo.getLengthInBits();

    return lengthInBits;
  }

  public static CANOpenPayloadBuilder staticParseCANOpenPayloadBuilder(
      ReadBuffer readBuffer, CANOpenService service) throws ParseException {
    readBuffer.pullContext("CANOpenPDOPayload");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    CANOpenPDO pdo =
        readSimpleField(
            "pdo",
            new DataReaderComplexDefault<>(() -> CANOpenPDO.staticParse(readBuffer), readBuffer));

    readBuffer.closeContext("CANOpenPDOPayload");
    // Create the instance
    return new CANOpenPDOPayloadBuilderImpl(pdo);
  }

  public static class CANOpenPDOPayloadBuilderImpl implements CANOpenPayload.CANOpenPayloadBuilder {
    private final CANOpenPDO pdo;

    public CANOpenPDOPayloadBuilderImpl(CANOpenPDO pdo) {

      this.pdo = pdo;
    }

    public CANOpenPDOPayload build() {
      CANOpenPDOPayload cANOpenPDOPayload = new CANOpenPDOPayload(pdo);
      return cANOpenPDOPayload;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CANOpenPDOPayload)) {
      return false;
    }
    CANOpenPDOPayload that = (CANOpenPDOPayload) o;
    return (getPdo() == that.getPdo()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getPdo());
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
