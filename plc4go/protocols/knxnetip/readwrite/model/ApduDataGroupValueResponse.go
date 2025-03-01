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

package model

import (
	"context"
	"fmt"
	"github.com/apache/plc4x/plc4go/spi/utils"
	"github.com/pkg/errors"
	"github.com/rs/zerolog"
)

// Code generated by code-generation. DO NOT EDIT.

// ApduDataGroupValueResponse is the corresponding interface of ApduDataGroupValueResponse
type ApduDataGroupValueResponse interface {
	fmt.Stringer
	utils.LengthAware
	utils.Serializable
	ApduData
	// GetDataFirstByte returns DataFirstByte (property field)
	GetDataFirstByte() int8
	// GetData returns Data (property field)
	GetData() []byte
}

// ApduDataGroupValueResponseExactly can be used when we want exactly this type and not a type which fulfills ApduDataGroupValueResponse.
// This is useful for switch cases.
type ApduDataGroupValueResponseExactly interface {
	ApduDataGroupValueResponse
	isApduDataGroupValueResponse() bool
}

// _ApduDataGroupValueResponse is the data-structure of this message
type _ApduDataGroupValueResponse struct {
	*_ApduData
	DataFirstByte int8
	Data          []byte
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for discriminator values.
///////////////////////

func (m *_ApduDataGroupValueResponse) GetApciType() uint8 {
	return 0x1
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

func (m *_ApduDataGroupValueResponse) InitializeParent(parent ApduData) {}

func (m *_ApduDataGroupValueResponse) GetParent() ApduData {
	return m._ApduData
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for property fields.
///////////////////////

func (m *_ApduDataGroupValueResponse) GetDataFirstByte() int8 {
	return m.DataFirstByte
}

func (m *_ApduDataGroupValueResponse) GetData() []byte {
	return m.Data
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

// NewApduDataGroupValueResponse factory function for _ApduDataGroupValueResponse
func NewApduDataGroupValueResponse(dataFirstByte int8, data []byte, dataLength uint8) *_ApduDataGroupValueResponse {
	_result := &_ApduDataGroupValueResponse{
		DataFirstByte: dataFirstByte,
		Data:          data,
		_ApduData:     NewApduData(dataLength),
	}
	_result._ApduData._ApduDataChildRequirements = _result
	return _result
}

// Deprecated: use the interface for direct cast
func CastApduDataGroupValueResponse(structType any) ApduDataGroupValueResponse {
	if casted, ok := structType.(ApduDataGroupValueResponse); ok {
		return casted
	}
	if casted, ok := structType.(*ApduDataGroupValueResponse); ok {
		return *casted
	}
	return nil
}

func (m *_ApduDataGroupValueResponse) GetTypeName() string {
	return "ApduDataGroupValueResponse"
}

func (m *_ApduDataGroupValueResponse) GetLengthInBits(ctx context.Context) uint16 {
	lengthInBits := uint16(m.GetParentLengthInBits(ctx))

	// Simple field (dataFirstByte)
	lengthInBits += 6

	// Array field
	if len(m.Data) > 0 {
		lengthInBits += 8 * uint16(len(m.Data))
	}

	return lengthInBits
}

func (m *_ApduDataGroupValueResponse) GetLengthInBytes(ctx context.Context) uint16 {
	return m.GetLengthInBits(ctx) / 8
}

func ApduDataGroupValueResponseParse(ctx context.Context, theBytes []byte, dataLength uint8) (ApduDataGroupValueResponse, error) {
	return ApduDataGroupValueResponseParseWithBuffer(ctx, utils.NewReadBufferByteBased(theBytes), dataLength)
}

func ApduDataGroupValueResponseParseWithBuffer(ctx context.Context, readBuffer utils.ReadBuffer, dataLength uint8) (ApduDataGroupValueResponse, error) {
	positionAware := readBuffer
	_ = positionAware
	log := zerolog.Ctx(ctx)
	_ = log
	if pullErr := readBuffer.PullContext("ApduDataGroupValueResponse"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for ApduDataGroupValueResponse")
	}
	currentPos := positionAware.GetPos()
	_ = currentPos

	// Simple Field (dataFirstByte)
	_dataFirstByte, _dataFirstByteErr := readBuffer.ReadInt8("dataFirstByte", 6)
	if _dataFirstByteErr != nil {
		return nil, errors.Wrap(_dataFirstByteErr, "Error parsing 'dataFirstByte' field of ApduDataGroupValueResponse")
	}
	dataFirstByte := _dataFirstByte
	// Byte Array field (data)
	numberOfBytesdata := int(utils.InlineIf((bool((dataLength) < (1))), func() any { return uint16(uint16(0)) }, func() any { return uint16(uint16(dataLength) - uint16(uint16(1))) }).(uint16))
	data, _readArrayErr := readBuffer.ReadByteArray("data", numberOfBytesdata)
	if _readArrayErr != nil {
		return nil, errors.Wrap(_readArrayErr, "Error parsing 'data' field of ApduDataGroupValueResponse")
	}

	if closeErr := readBuffer.CloseContext("ApduDataGroupValueResponse"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for ApduDataGroupValueResponse")
	}

	// Create a partially initialized instance
	_child := &_ApduDataGroupValueResponse{
		_ApduData: &_ApduData{
			DataLength: dataLength,
		},
		DataFirstByte: dataFirstByte,
		Data:          data,
	}
	_child._ApduData._ApduDataChildRequirements = _child
	return _child, nil
}

func (m *_ApduDataGroupValueResponse) Serialize() ([]byte, error) {
	wb := utils.NewWriteBufferByteBased(utils.WithInitialSizeForByteBasedBuffer(int(m.GetLengthInBytes(context.Background()))))
	if err := m.SerializeWithWriteBuffer(context.Background(), wb); err != nil {
		return nil, err
	}
	return wb.GetBytes(), nil
}

func (m *_ApduDataGroupValueResponse) SerializeWithWriteBuffer(ctx context.Context, writeBuffer utils.WriteBuffer) error {
	positionAware := writeBuffer
	_ = positionAware
	log := zerolog.Ctx(ctx)
	_ = log
	ser := func() error {
		if pushErr := writeBuffer.PushContext("ApduDataGroupValueResponse"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for ApduDataGroupValueResponse")
		}

		// Simple Field (dataFirstByte)
		dataFirstByte := int8(m.GetDataFirstByte())
		_dataFirstByteErr := writeBuffer.WriteInt8("dataFirstByte", 6, int8((dataFirstByte)))
		if _dataFirstByteErr != nil {
			return errors.Wrap(_dataFirstByteErr, "Error serializing 'dataFirstByte' field")
		}

		// Array Field (data)
		// Byte Array field (data)
		if err := writeBuffer.WriteByteArray("data", m.GetData()); err != nil {
			return errors.Wrap(err, "Error serializing 'data' field")
		}

		if popErr := writeBuffer.PopContext("ApduDataGroupValueResponse"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for ApduDataGroupValueResponse")
		}
		return nil
	}
	return m.SerializeParent(ctx, writeBuffer, m, ser)
}

func (m *_ApduDataGroupValueResponse) isApduDataGroupValueResponse() bool {
	return true
}

func (m *_ApduDataGroupValueResponse) String() string {
	if m == nil {
		return "<nil>"
	}
	writeBuffer := utils.NewWriteBufferBoxBasedWithOptions(true, true)
	if err := writeBuffer.WriteSerializable(context.Background(), m); err != nil {
		return err.Error()
	}
	return writeBuffer.GetBox().String()
}
