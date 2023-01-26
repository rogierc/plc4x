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

public class SDOSegmentDownloadRequest extends SDORequest implements Message {

  // Accessors for discriminator values.
  public SDORequestCommand getCommand() {
    return SDORequestCommand.SEGMENT_DOWNLOAD;
  }

  // Properties.
  protected final boolean toggle;
  protected final boolean last;
  protected final byte[] data;

  public SDOSegmentDownloadRequest(boolean toggle, boolean last, byte[] data) {
    super();
    this.toggle = toggle;
    this.last = last;
    this.data = data;
  }

  public boolean getToggle() {
    return toggle;
  }

  public boolean getLast() {
    return last;
  }

  public byte[] getData() {
    return data;
  }

  @Override
  protected void serializeSDORequestChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("SDOSegmentDownloadRequest");

    // Simple Field (toggle)
    writeSimpleField("toggle", toggle, writeBoolean(writeBuffer));

    // Implicit Field (size) (Used for parsing, but its value is not stored as it's implicitly given
    // by the objects content)
    byte size = (byte) ((7) - (COUNT(getData())));
    writeImplicitField("size", size, writeUnsignedByte(writeBuffer, 3));

    // Simple Field (last)
    writeSimpleField("last", last, writeBoolean(writeBuffer));

    // Array Field (data)
    writeByteArrayField("data", data, writeByteArray(writeBuffer, 8));

    // Padding Field (padding)
    writePaddingField(
        "padding", (int) ((7) - (COUNT(data))), (short) 0x00, writeUnsignedShort(writeBuffer, 8));

    writeBuffer.popContext("SDOSegmentDownloadRequest");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    SDOSegmentDownloadRequest _value = this;

    // Simple field (toggle)
    lengthInBits += 1;

    // Implicit Field (size)
    lengthInBits += 3;

    // Simple field (last)
    lengthInBits += 1;

    // Array field
    if (data != null) {
      lengthInBits += 8 * data.length;
    }

    // Padding Field (padding)
    int _timesPadding = (int) ((7) - (COUNT(data)));
    while (_timesPadding-- > 0) {
      lengthInBits += 8;
    }

    return lengthInBits;
  }

  public static SDORequestBuilder staticParseSDORequestBuilder(
      ReadBuffer readBuffer, SDORequestCommand command) throws ParseException {
    readBuffer.pullContext("SDOSegmentDownloadRequest");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    boolean toggle = readSimpleField("toggle", readBoolean(readBuffer));

    byte size = readImplicitField("size", readUnsignedByte(readBuffer, 3));

    boolean last = readSimpleField("last", readBoolean(readBuffer));

    byte[] data = readBuffer.readByteArray("data", Math.toIntExact((7) - (size)));

    readPaddingField(readUnsignedShort(readBuffer, 8), (int) ((7) - (COUNT(data))));

    readBuffer.closeContext("SDOSegmentDownloadRequest");
    // Create the instance
    return new SDOSegmentDownloadRequestBuilderImpl(toggle, last, data);
  }

  public static class SDOSegmentDownloadRequestBuilderImpl implements SDORequest.SDORequestBuilder {
    private final boolean toggle;
    private final boolean last;
    private final byte[] data;

    public SDOSegmentDownloadRequestBuilderImpl(boolean toggle, boolean last, byte[] data) {

      this.toggle = toggle;
      this.last = last;
      this.data = data;
    }

    public SDOSegmentDownloadRequest build() {
      SDOSegmentDownloadRequest sDOSegmentDownloadRequest =
          new SDOSegmentDownloadRequest(toggle, last, data);
      return sDOSegmentDownloadRequest;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SDOSegmentDownloadRequest)) {
      return false;
    }
    SDOSegmentDownloadRequest that = (SDOSegmentDownloadRequest) o;
    return (getToggle() == that.getToggle())
        && (getLast() == that.getLast())
        && (getData() == that.getData())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getToggle(), getLast(), getData());
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
