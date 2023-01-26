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

public class SALDataMediaTransport extends SALData implements Message {

  // Accessors for discriminator values.
  public ApplicationId getApplicationId() {
    return ApplicationId.MEDIA_TRANSPORT_CONTROL;
  }

  // Properties.
  protected final MediaTransportControlData mediaTransportControlData;

  public SALDataMediaTransport(
      SALData salData, MediaTransportControlData mediaTransportControlData) {
    super(salData);
    this.mediaTransportControlData = mediaTransportControlData;
  }

  public MediaTransportControlData getMediaTransportControlData() {
    return mediaTransportControlData;
  }

  @Override
  protected void serializeSALDataChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("SALDataMediaTransport");

    // Simple Field (mediaTransportControlData)
    writeSimpleField(
        "mediaTransportControlData",
        mediaTransportControlData,
        new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("SALDataMediaTransport");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    SALDataMediaTransport _value = this;

    // Simple field (mediaTransportControlData)
    lengthInBits += mediaTransportControlData.getLengthInBits();

    return lengthInBits;
  }

  public static SALDataBuilder staticParseSALDataBuilder(
      ReadBuffer readBuffer, ApplicationId applicationId) throws ParseException {
    readBuffer.pullContext("SALDataMediaTransport");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    MediaTransportControlData mediaTransportControlData =
        readSimpleField(
            "mediaTransportControlData",
            new DataReaderComplexDefault<>(
                () -> MediaTransportControlData.staticParse(readBuffer), readBuffer));

    readBuffer.closeContext("SALDataMediaTransport");
    // Create the instance
    return new SALDataMediaTransportBuilderImpl(mediaTransportControlData);
  }

  public static class SALDataMediaTransportBuilderImpl implements SALData.SALDataBuilder {
    private final MediaTransportControlData mediaTransportControlData;

    public SALDataMediaTransportBuilderImpl(MediaTransportControlData mediaTransportControlData) {

      this.mediaTransportControlData = mediaTransportControlData;
    }

    public SALDataMediaTransport build(SALData salData) {
      SALDataMediaTransport sALDataMediaTransport =
          new SALDataMediaTransport(salData, mediaTransportControlData);
      return sALDataMediaTransport;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SALDataMediaTransport)) {
      return false;
    }
    SALDataMediaTransport that = (SALDataMediaTransport) o;
    return (getMediaTransportControlData() == that.getMediaTransportControlData())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getMediaTransportControlData());
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
