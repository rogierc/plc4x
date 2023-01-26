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
package org.apache.plc4x.java.bacnetip.readwrite;

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

public abstract class BACnetConfirmedServiceRequestConfirmedTextMessageMessageClass
    implements Message {

  // Abstract accessors for discriminator values.

  // Properties.
  protected final BACnetOpeningTag openingTag;
  protected final BACnetTagHeader peekedTagHeader;
  protected final BACnetClosingTag closingTag;

  // Arguments.
  protected final Short tagNumber;

  public BACnetConfirmedServiceRequestConfirmedTextMessageMessageClass(
      BACnetOpeningTag openingTag,
      BACnetTagHeader peekedTagHeader,
      BACnetClosingTag closingTag,
      Short tagNumber) {
    super();
    this.openingTag = openingTag;
    this.peekedTagHeader = peekedTagHeader;
    this.closingTag = closingTag;
    this.tagNumber = tagNumber;
  }

  public BACnetOpeningTag getOpeningTag() {
    return openingTag;
  }

  public BACnetTagHeader getPeekedTagHeader() {
    return peekedTagHeader;
  }

  public BACnetClosingTag getClosingTag() {
    return closingTag;
  }

  public short getPeekedTagNumber() {
    return (short) (getPeekedTagHeader().getActualTagNumber());
  }

  protected abstract void
      serializeBACnetConfirmedServiceRequestConfirmedTextMessageMessageClassChild(
          WriteBuffer writeBuffer) throws SerializationException;

  public void serialize(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetConfirmedServiceRequestConfirmedTextMessageMessageClass");

    // Simple Field (openingTag)
    writeSimpleField("openingTag", openingTag, new DataWriterComplexDefault<>(writeBuffer));

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    short peekedTagNumber = getPeekedTagNumber();
    writeBuffer.writeVirtual("peekedTagNumber", peekedTagNumber);

    // Switch field (Serialize the sub-type)
    serializeBACnetConfirmedServiceRequestConfirmedTextMessageMessageClassChild(writeBuffer);

    // Simple Field (closingTag)
    writeSimpleField("closingTag", closingTag, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("BACnetConfirmedServiceRequestConfirmedTextMessageMessageClass");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = 0;
    BACnetConfirmedServiceRequestConfirmedTextMessageMessageClass _value = this;

    // Simple field (openingTag)
    lengthInBits += openingTag.getLengthInBits();

    // A virtual field doesn't have any in- or output.

    // Length of sub-type elements will be added by sub-type...

    // Simple field (closingTag)
    lengthInBits += closingTag.getLengthInBits();

    return lengthInBits;
  }

  public static BACnetConfirmedServiceRequestConfirmedTextMessageMessageClass staticParse(
      ReadBuffer readBuffer, Object... args) throws ParseException {
    PositionAware positionAware = readBuffer;
    if ((args == null) || (args.length != 1)) {
      throw new PlcRuntimeException(
          "Wrong number of arguments, expected 1, but got " + args.length);
    }
    Short tagNumber;
    if (args[0] instanceof Short) {
      tagNumber = (Short) args[0];
    } else if (args[0] instanceof String) {
      tagNumber = Short.valueOf((String) args[0]);
    } else {
      throw new PlcRuntimeException(
          "Argument 0 expected to be of type Short or a string which is parseable but was "
              + args[0].getClass().getName());
    }
    return staticParse(readBuffer, tagNumber);
  }

  public static BACnetConfirmedServiceRequestConfirmedTextMessageMessageClass staticParse(
      ReadBuffer readBuffer, Short tagNumber) throws ParseException {
    readBuffer.pullContext("BACnetConfirmedServiceRequestConfirmedTextMessageMessageClass");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    BACnetOpeningTag openingTag =
        readSimpleField(
            "openingTag",
            new DataReaderComplexDefault<>(
                () -> BACnetOpeningTag.staticParse(readBuffer, (short) (tagNumber)), readBuffer));

    BACnetTagHeader peekedTagHeader =
        readPeekField(
            "peekedTagHeader",
            new DataReaderComplexDefault<>(
                () -> BACnetTagHeader.staticParse(readBuffer), readBuffer));
    short peekedTagNumber =
        readVirtualField("peekedTagNumber", short.class, peekedTagHeader.getActualTagNumber());

    // Switch Field (Depending on the discriminator values, passes the instantiation to a sub-type)
    BACnetConfirmedServiceRequestConfirmedTextMessageMessageClassBuilder builder = null;
    if (EvaluationHelper.equals(peekedTagNumber, (short) 0)) {
      builder =
          BACnetConfirmedServiceRequestConfirmedTextMessageMessageClassNumeric
              .staticParseBACnetConfirmedServiceRequestConfirmedTextMessageMessageClassBuilder(
                  readBuffer, tagNumber);
    } else if (EvaluationHelper.equals(peekedTagNumber, (short) 1)) {
      builder =
          BACnetConfirmedServiceRequestConfirmedTextMessageMessageClassCharacter
              .staticParseBACnetConfirmedServiceRequestConfirmedTextMessageMessageClassBuilder(
                  readBuffer, tagNumber);
    }
    if (builder == null) {
      throw new ParseException(
          "Unsupported case for discriminated type"
              + " parameters ["
              + "peekedTagNumber="
              + peekedTagNumber
              + "]");
    }

    BACnetClosingTag closingTag =
        readSimpleField(
            "closingTag",
            new DataReaderComplexDefault<>(
                () -> BACnetClosingTag.staticParse(readBuffer, (short) (tagNumber)), readBuffer));

    readBuffer.closeContext("BACnetConfirmedServiceRequestConfirmedTextMessageMessageClass");
    // Create the instance
    BACnetConfirmedServiceRequestConfirmedTextMessageMessageClass
        _bACnetConfirmedServiceRequestConfirmedTextMessageMessageClass =
            builder.build(openingTag, peekedTagHeader, closingTag, tagNumber);
    return _bACnetConfirmedServiceRequestConfirmedTextMessageMessageClass;
  }

  public interface BACnetConfirmedServiceRequestConfirmedTextMessageMessageClassBuilder {
    BACnetConfirmedServiceRequestConfirmedTextMessageMessageClass build(
        BACnetOpeningTag openingTag,
        BACnetTagHeader peekedTagHeader,
        BACnetClosingTag closingTag,
        Short tagNumber);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetConfirmedServiceRequestConfirmedTextMessageMessageClass)) {
      return false;
    }
    BACnetConfirmedServiceRequestConfirmedTextMessageMessageClass that =
        (BACnetConfirmedServiceRequestConfirmedTextMessageMessageClass) o;
    return (getOpeningTag() == that.getOpeningTag())
        && (getPeekedTagHeader() == that.getPeekedTagHeader())
        && (getClosingTag() == that.getClosingTag())
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getOpeningTag(), getPeekedTagHeader(), getClosingTag());
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
