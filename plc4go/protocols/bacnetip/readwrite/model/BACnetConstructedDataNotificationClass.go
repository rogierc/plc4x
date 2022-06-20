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

// BACnetConstructedDataNotificationClass is the corresponding interface of BACnetConstructedDataNotificationClass
type BACnetConstructedDataNotificationClass interface {
	BACnetConstructedData
	// GetNotificationClass returns NotificationClass (property field)
	GetNotificationClass() BACnetApplicationTagUnsignedInteger
	// GetActualValue returns ActualValue (virtual field)
	GetActualValue() BACnetApplicationTagUnsignedInteger
	// GetLengthInBytes returns the length in bytes
	GetLengthInBytes() uint16
	// GetLengthInBits returns the length in bits
	GetLengthInBits() uint16
	// Serialize serializes this type
	Serialize(writeBuffer utils.WriteBuffer) error
}

// _BACnetConstructedDataNotificationClass is the data-structure of this message
type _BACnetConstructedDataNotificationClass struct {
	*_BACnetConstructedData
	NotificationClass BACnetApplicationTagUnsignedInteger

	// Arguments.
	TagNumber          uint8
	ArrayIndexArgument BACnetTagPayloadUnsignedInteger
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for discriminator values.
///////////////////////

func (m *_BACnetConstructedDataNotificationClass) GetObjectTypeArgument() BACnetObjectType {
	return 0
}

func (m *_BACnetConstructedDataNotificationClass) GetPropertyIdentifierArgument() BACnetPropertyIdentifier {
	return BACnetPropertyIdentifier_NOTIFICATION_CLASS
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

func (m *_BACnetConstructedDataNotificationClass) InitializeParent(parent BACnetConstructedData, openingTag BACnetOpeningTag, peekedTagHeader BACnetTagHeader, closingTag BACnetClosingTag) {
	m.OpeningTag = openingTag
	m.PeekedTagHeader = peekedTagHeader
	m.ClosingTag = closingTag
}

func (m *_BACnetConstructedDataNotificationClass) GetParent() BACnetConstructedData {
	return m._BACnetConstructedData
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for property fields.
///////////////////////

func (m *_BACnetConstructedDataNotificationClass) GetNotificationClass() BACnetApplicationTagUnsignedInteger {
	return m.NotificationClass
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for virtual fields.
///////////////////////

func (m *_BACnetConstructedDataNotificationClass) GetActualValue() BACnetApplicationTagUnsignedInteger {
	return CastBACnetApplicationTagUnsignedInteger(m.GetNotificationClass())
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

// NewBACnetConstructedDataNotificationClass factory function for _BACnetConstructedDataNotificationClass
func NewBACnetConstructedDataNotificationClass(notificationClass BACnetApplicationTagUnsignedInteger, openingTag BACnetOpeningTag, peekedTagHeader BACnetTagHeader, closingTag BACnetClosingTag, tagNumber uint8, arrayIndexArgument BACnetTagPayloadUnsignedInteger) *_BACnetConstructedDataNotificationClass {
	_result := &_BACnetConstructedDataNotificationClass{
		NotificationClass:      notificationClass,
		_BACnetConstructedData: NewBACnetConstructedData(openingTag, peekedTagHeader, closingTag, tagNumber, arrayIndexArgument),
	}
	_result._BACnetConstructedData._BACnetConstructedDataChildRequirements = _result
	return _result
}

// Deprecated: use the interface for direct cast
func CastBACnetConstructedDataNotificationClass(structType interface{}) BACnetConstructedDataNotificationClass {
	if casted, ok := structType.(BACnetConstructedDataNotificationClass); ok {
		return casted
	}
	if casted, ok := structType.(*BACnetConstructedDataNotificationClass); ok {
		return *casted
	}
	return nil
}

func (m *_BACnetConstructedDataNotificationClass) GetTypeName() string {
	return "BACnetConstructedDataNotificationClass"
}

func (m *_BACnetConstructedDataNotificationClass) GetLengthInBits() uint16 {
	return m.GetLengthInBitsConditional(false)
}

func (m *_BACnetConstructedDataNotificationClass) GetLengthInBitsConditional(lastItem bool) uint16 {
	lengthInBits := uint16(m.GetParentLengthInBits())

	// Simple field (notificationClass)
	lengthInBits += m.NotificationClass.GetLengthInBits()

	// A virtual field doesn't have any in- or output.

	return lengthInBits
}

func (m *_BACnetConstructedDataNotificationClass) GetLengthInBytes() uint16 {
	return m.GetLengthInBits() / 8
}

func BACnetConstructedDataNotificationClassParse(readBuffer utils.ReadBuffer, tagNumber uint8, objectTypeArgument BACnetObjectType, propertyIdentifierArgument BACnetPropertyIdentifier, arrayIndexArgument BACnetTagPayloadUnsignedInteger) (BACnetConstructedDataNotificationClass, error) {
	positionAware := readBuffer
	_ = positionAware
	if pullErr := readBuffer.PullContext("BACnetConstructedDataNotificationClass"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for BACnetConstructedDataNotificationClass")
	}
	currentPos := positionAware.GetPos()
	_ = currentPos

	// Simple Field (notificationClass)
	if pullErr := readBuffer.PullContext("notificationClass"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for notificationClass")
	}
	_notificationClass, _notificationClassErr := BACnetApplicationTagParse(readBuffer)
	if _notificationClassErr != nil {
		return nil, errors.Wrap(_notificationClassErr, "Error parsing 'notificationClass' field")
	}
	notificationClass := _notificationClass.(BACnetApplicationTagUnsignedInteger)
	if closeErr := readBuffer.CloseContext("notificationClass"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for notificationClass")
	}

	// Virtual field
	_actualValue := notificationClass
	actualValue := _actualValue
	_ = actualValue

	if closeErr := readBuffer.CloseContext("BACnetConstructedDataNotificationClass"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for BACnetConstructedDataNotificationClass")
	}

	// Create a partially initialized instance
	_child := &_BACnetConstructedDataNotificationClass{
		NotificationClass:      notificationClass,
		_BACnetConstructedData: &_BACnetConstructedData{},
	}
	_child._BACnetConstructedData._BACnetConstructedDataChildRequirements = _child
	return _child, nil
}

func (m *_BACnetConstructedDataNotificationClass) Serialize(writeBuffer utils.WriteBuffer) error {
	positionAware := writeBuffer
	_ = positionAware
	ser := func() error {
		if pushErr := writeBuffer.PushContext("BACnetConstructedDataNotificationClass"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for BACnetConstructedDataNotificationClass")
		}

		// Simple Field (notificationClass)
		if pushErr := writeBuffer.PushContext("notificationClass"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for notificationClass")
		}
		_notificationClassErr := writeBuffer.WriteSerializable(m.GetNotificationClass())
		if popErr := writeBuffer.PopContext("notificationClass"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for notificationClass")
		}
		if _notificationClassErr != nil {
			return errors.Wrap(_notificationClassErr, "Error serializing 'notificationClass' field")
		}
		// Virtual field
		if _actualValueErr := writeBuffer.WriteVirtual("actualValue", m.GetActualValue()); _actualValueErr != nil {
			return errors.Wrap(_actualValueErr, "Error serializing 'actualValue' field")
		}

		if popErr := writeBuffer.PopContext("BACnetConstructedDataNotificationClass"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for BACnetConstructedDataNotificationClass")
		}
		return nil
	}
	return m.SerializeParent(writeBuffer, m, ser)
}

func (m *_BACnetConstructedDataNotificationClass) String() string {
	if m == nil {
		return "<nil>"
	}
	writeBuffer := utils.NewBoxedWriteBufferWithOptions(true, true)
	if err := writeBuffer.WriteSerializable(m); err != nil {
		return err.Error()
	}
	return writeBuffer.GetBox().String()
}
