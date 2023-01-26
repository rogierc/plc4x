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
package org.apache.plc4x.java.opcua.readwrite;

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

public class SignedSoftwareCertificate extends ExtensionObjectDefinition implements Message {

  // Accessors for discriminator values.
  public String getIdentifier() {
    return (String) "346";
  }

  // Properties.
  protected final PascalByteString certificateData;
  protected final PascalByteString signature;

  public SignedSoftwareCertificate(PascalByteString certificateData, PascalByteString signature) {
    super();
    this.certificateData = certificateData;
    this.signature = signature;
  }

  public PascalByteString getCertificateData() {
    return certificateData;
  }

  public PascalByteString getSignature() {
    return signature;
  }

  @Override
  protected void serializeExtensionObjectDefinitionChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("SignedSoftwareCertificate");

    // Simple Field (certificateData)
    writeSimpleField(
        "certificateData", certificateData, new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (signature)
    writeSimpleField("signature", signature, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("SignedSoftwareCertificate");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    SignedSoftwareCertificate _value = this;

    // Simple field (certificateData)
    lengthInBits += certificateData.getLengthInBits();

    // Simple field (signature)
    lengthInBits += signature.getLengthInBits();

    return lengthInBits;
  }

  public static ExtensionObjectDefinitionBuilder staticParseExtensionObjectDefinitionBuilder(
      ReadBuffer readBuffer, String identifier) throws ParseException {
    readBuffer.pullContext("SignedSoftwareCertificate");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    PascalByteString certificateData =
        readSimpleField(
            "certificateData",
            new DataReaderComplexDefault<>(
                () -> PascalByteString.staticParse(readBuffer), readBuffer));

    PascalByteString signature =
        readSimpleField(
            "signature",
            new DataReaderComplexDefault<>(
                () -> PascalByteString.staticParse(readBuffer), readBuffer));

    readBuffer.closeContext("SignedSoftwareCertificate");
    // Create the instance
    return new SignedSoftwareCertificateBuilderImpl(certificateData, signature);
  }

  public static class SignedSoftwareCertificateBuilderImpl
      implements ExtensionObjectDefinition.ExtensionObjectDefinitionBuilder {
    private final PascalByteString certificateData;
    private final PascalByteString signature;

    public SignedSoftwareCertificateBuilderImpl(
        PascalByteString certificateData, PascalByteString signature) {

      this.certificateData = certificateData;
      this.signature = signature;
    }

    public SignedSoftwareCertificate build() {
      SignedSoftwareCertificate signedSoftwareCertificate =
          new SignedSoftwareCertificate(certificateData, signature);
      return signedSoftwareCertificate;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SignedSoftwareCertificate)) {
      return false;
    }
    SignedSoftwareCertificate that = (SignedSoftwareCertificate) o;
    return (getCertificateData() == that.getCertificateData())
        && (getSignature() == that.getSignature())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getCertificateData(), getSignature());
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
