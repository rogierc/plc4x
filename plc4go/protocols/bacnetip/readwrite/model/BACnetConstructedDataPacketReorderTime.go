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
	"github.com/apache/plc4x/plc4go/internal/spi/utils"
	"github.com/pkg/errors"
)

// Code generated by code-generation. DO NOT EDIT.

// BACnetConstructedDataPacketReorderTime is the corresponding interface of BACnetConstructedDataPacketReorderTime
type BACnetConstructedDataPacketReorderTime interface {
	BACnetConstructedData
	// GetPacketReorderTime returns PacketReorderTime (property field)
	GetPacketReorderTime() BACnetApplicationTagUnsignedInteger
	// GetActualValue returns ActualValue (virtual field)
	GetActualValue() BACnetApplicationTagUnsignedInteger
	// GetLengthInBytes returns the length in bytes
	GetLengthInBytes() uint16
	// GetLengthInBits returns the length in bits
	GetLengthInBits() uint16
	// Serialize serializes this type
	Serialize(writeBuffer utils.WriteBuffer) error
}

// _BACnetConstructedDataPacketReorderTime is the data-structure of this message
type _BACnetConstructedDataPacketReorderTime struct {
	*_BACnetConstructedData
	PacketReorderTime BACnetApplicationTagUnsignedInteger

	// Arguments.
	TagNumber          uint8
	ArrayIndexArgument BACnetTagPayloadUnsignedInteger
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for discriminator values.
///////////////////////

func (m *_BACnetConstructedDataPacketReorderTime) GetObjectTypeArgument() BACnetObjectType {
	return 0
}

func (m *_BACnetConstructedDataPacketReorderTime) GetPropertyIdentifierArgument() BACnetPropertyIdentifier {
	return BACnetPropertyIdentifier_PACKET_REORDER_TIME
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

func (m *_BACnetConstructedDataPacketReorderTime) InitializeParent(parent BACnetConstructedData, openingTag BACnetOpeningTag, peekedTagHeader BACnetTagHeader, closingTag BACnetClosingTag) {
	m.OpeningTag = openingTag
	m.PeekedTagHeader = peekedTagHeader
	m.ClosingTag = closingTag
}

func (m *_BACnetConstructedDataPacketReorderTime) GetParent() BACnetConstructedData {
	return m._BACnetConstructedData
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for property fields.
///////////////////////

func (m *_BACnetConstructedDataPacketReorderTime) GetPacketReorderTime() BACnetApplicationTagUnsignedInteger {
	return m.PacketReorderTime
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for virtual fields.
///////////////////////

func (m *_BACnetConstructedDataPacketReorderTime) GetActualValue() BACnetApplicationTagUnsignedInteger {
	return CastBACnetApplicationTagUnsignedInteger(m.GetPacketReorderTime())
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

// NewBACnetConstructedDataPacketReorderTime factory function for _BACnetConstructedDataPacketReorderTime
func NewBACnetConstructedDataPacketReorderTime(packetReorderTime BACnetApplicationTagUnsignedInteger, openingTag BACnetOpeningTag, peekedTagHeader BACnetTagHeader, closingTag BACnetClosingTag, tagNumber uint8, arrayIndexArgument BACnetTagPayloadUnsignedInteger) *_BACnetConstructedDataPacketReorderTime {
	_result := &_BACnetConstructedDataPacketReorderTime{
		PacketReorderTime:      packetReorderTime,
		_BACnetConstructedData: NewBACnetConstructedData(openingTag, peekedTagHeader, closingTag, tagNumber, arrayIndexArgument),
	}
	_result._BACnetConstructedData._BACnetConstructedDataChildRequirements = _result
	return _result
}

// Deprecated: use the interface for direct cast
func CastBACnetConstructedDataPacketReorderTime(structType interface{}) BACnetConstructedDataPacketReorderTime {
	if casted, ok := structType.(BACnetConstructedDataPacketReorderTime); ok {
		return casted
	}
	if casted, ok := structType.(*BACnetConstructedDataPacketReorderTime); ok {
		return *casted
	}
	return nil
}

func (m *_BACnetConstructedDataPacketReorderTime) GetTypeName() string {
	return "BACnetConstructedDataPacketReorderTime"
}

func (m *_BACnetConstructedDataPacketReorderTime) GetLengthInBits() uint16 {
	return m.GetLengthInBitsConditional(false)
}

func (m *_BACnetConstructedDataPacketReorderTime) GetLengthInBitsConditional(lastItem bool) uint16 {
	lengthInBits := uint16(m.GetParentLengthInBits())

	// Simple field (packetReorderTime)
	lengthInBits += m.PacketReorderTime.GetLengthInBits()

	// A virtual field doesn't have any in- or output.

	return lengthInBits
}

func (m *_BACnetConstructedDataPacketReorderTime) GetLengthInBytes() uint16 {
	return m.GetLengthInBits() / 8
}

func BACnetConstructedDataPacketReorderTimeParse(readBuffer utils.ReadBuffer, tagNumber uint8, objectTypeArgument BACnetObjectType, propertyIdentifierArgument BACnetPropertyIdentifier, arrayIndexArgument BACnetTagPayloadUnsignedInteger) (BACnetConstructedDataPacketReorderTime, error) {
	positionAware := readBuffer
	_ = positionAware
	if pullErr := readBuffer.PullContext("BACnetConstructedDataPacketReorderTime"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for BACnetConstructedDataPacketReorderTime")
	}
	currentPos := positionAware.GetPos()
	_ = currentPos

	// Simple Field (packetReorderTime)
	if pullErr := readBuffer.PullContext("packetReorderTime"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for packetReorderTime")
	}
	_packetReorderTime, _packetReorderTimeErr := BACnetApplicationTagParse(readBuffer)
	if _packetReorderTimeErr != nil {
		return nil, errors.Wrap(_packetReorderTimeErr, "Error parsing 'packetReorderTime' field")
	}
	packetReorderTime := _packetReorderTime.(BACnetApplicationTagUnsignedInteger)
	if closeErr := readBuffer.CloseContext("packetReorderTime"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for packetReorderTime")
	}

	// Virtual field
	_actualValue := packetReorderTime
	actualValue := _actualValue
	_ = actualValue

	if closeErr := readBuffer.CloseContext("BACnetConstructedDataPacketReorderTime"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for BACnetConstructedDataPacketReorderTime")
	}

	// Create a partially initialized instance
	_child := &_BACnetConstructedDataPacketReorderTime{
		PacketReorderTime:      packetReorderTime,
		_BACnetConstructedData: &_BACnetConstructedData{},
	}
	_child._BACnetConstructedData._BACnetConstructedDataChildRequirements = _child
	return _child, nil
}

func (m *_BACnetConstructedDataPacketReorderTime) Serialize(writeBuffer utils.WriteBuffer) error {
	positionAware := writeBuffer
	_ = positionAware
	ser := func() error {
		if pushErr := writeBuffer.PushContext("BACnetConstructedDataPacketReorderTime"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for BACnetConstructedDataPacketReorderTime")
		}

		// Simple Field (packetReorderTime)
		if pushErr := writeBuffer.PushContext("packetReorderTime"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for packetReorderTime")
		}
		_packetReorderTimeErr := writeBuffer.WriteSerializable(m.GetPacketReorderTime())
		if popErr := writeBuffer.PopContext("packetReorderTime"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for packetReorderTime")
		}
		if _packetReorderTimeErr != nil {
			return errors.Wrap(_packetReorderTimeErr, "Error serializing 'packetReorderTime' field")
		}
		// Virtual field
		if _actualValueErr := writeBuffer.WriteVirtual("actualValue", m.GetActualValue()); _actualValueErr != nil {
			return errors.Wrap(_actualValueErr, "Error serializing 'actualValue' field")
		}

		if popErr := writeBuffer.PopContext("BACnetConstructedDataPacketReorderTime"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for BACnetConstructedDataPacketReorderTime")
		}
		return nil
	}
	return m.SerializeParent(writeBuffer, m, ser)
}

func (m *_BACnetConstructedDataPacketReorderTime) String() string {
	if m == nil {
		return "<nil>"
	}
	writeBuffer := utils.NewBoxedWriteBufferWithOptions(true, true)
	if err := writeBuffer.WriteSerializable(m); err != nil {
		return err.Error()
	}
	return writeBuffer.GetBox().String()
}
