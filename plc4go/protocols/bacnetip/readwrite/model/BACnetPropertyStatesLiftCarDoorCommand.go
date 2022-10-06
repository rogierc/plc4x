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
	"github.com/apache/plc4x/plc4go/spi/utils"
	"github.com/pkg/errors"
)

// Code generated by code-generation. DO NOT EDIT.

// BACnetPropertyStatesLiftCarDoorCommand is the corresponding interface of BACnetPropertyStatesLiftCarDoorCommand
type BACnetPropertyStatesLiftCarDoorCommand interface {
	utils.LengthAware
	utils.Serializable
	BACnetPropertyStates
	// GetLiftCarDoorCommand returns LiftCarDoorCommand (property field)
	GetLiftCarDoorCommand() BACnetLiftCarDoorCommandTagged
}

// BACnetPropertyStatesLiftCarDoorCommandExactly can be used when we want exactly this type and not a type which fulfills BACnetPropertyStatesLiftCarDoorCommand.
// This is useful for switch cases.
type BACnetPropertyStatesLiftCarDoorCommandExactly interface {
	BACnetPropertyStatesLiftCarDoorCommand
	isBACnetPropertyStatesLiftCarDoorCommand() bool
}

// _BACnetPropertyStatesLiftCarDoorCommand is the data-structure of this message
type _BACnetPropertyStatesLiftCarDoorCommand struct {
	*_BACnetPropertyStates
	LiftCarDoorCommand BACnetLiftCarDoorCommandTagged
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for discriminator values.
///////////////////////

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

func (m *_BACnetPropertyStatesLiftCarDoorCommand) InitializeParent(parent BACnetPropertyStates, peekedTagHeader BACnetTagHeader) {
	m.PeekedTagHeader = peekedTagHeader
}

func (m *_BACnetPropertyStatesLiftCarDoorCommand) GetParent() BACnetPropertyStates {
	return m._BACnetPropertyStates
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for property fields.
///////////////////////

func (m *_BACnetPropertyStatesLiftCarDoorCommand) GetLiftCarDoorCommand() BACnetLiftCarDoorCommandTagged {
	return m.LiftCarDoorCommand
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

// NewBACnetPropertyStatesLiftCarDoorCommand factory function for _BACnetPropertyStatesLiftCarDoorCommand
func NewBACnetPropertyStatesLiftCarDoorCommand(liftCarDoorCommand BACnetLiftCarDoorCommandTagged, peekedTagHeader BACnetTagHeader) *_BACnetPropertyStatesLiftCarDoorCommand {
	_result := &_BACnetPropertyStatesLiftCarDoorCommand{
		LiftCarDoorCommand:    liftCarDoorCommand,
		_BACnetPropertyStates: NewBACnetPropertyStates(peekedTagHeader),
	}
	_result._BACnetPropertyStates._BACnetPropertyStatesChildRequirements = _result
	return _result
}

// Deprecated: use the interface for direct cast
func CastBACnetPropertyStatesLiftCarDoorCommand(structType interface{}) BACnetPropertyStatesLiftCarDoorCommand {
	if casted, ok := structType.(BACnetPropertyStatesLiftCarDoorCommand); ok {
		return casted
	}
	if casted, ok := structType.(*BACnetPropertyStatesLiftCarDoorCommand); ok {
		return *casted
	}
	return nil
}

func (m *_BACnetPropertyStatesLiftCarDoorCommand) GetTypeName() string {
	return "BACnetPropertyStatesLiftCarDoorCommand"
}

func (m *_BACnetPropertyStatesLiftCarDoorCommand) GetLengthInBits() uint16 {
	return m.GetLengthInBitsConditional(false)
}

func (m *_BACnetPropertyStatesLiftCarDoorCommand) GetLengthInBitsConditional(lastItem bool) uint16 {
	lengthInBits := uint16(m.GetParentLengthInBits())

	// Simple field (liftCarDoorCommand)
	lengthInBits += m.LiftCarDoorCommand.GetLengthInBits()

	return lengthInBits
}

func (m *_BACnetPropertyStatesLiftCarDoorCommand) GetLengthInBytes() uint16 {
	return m.GetLengthInBits() / 8
}

func BACnetPropertyStatesLiftCarDoorCommandParse(readBuffer utils.ReadBuffer, peekedTagNumber uint8) (BACnetPropertyStatesLiftCarDoorCommand, error) {
	positionAware := readBuffer
	_ = positionAware
	if pullErr := readBuffer.PullContext("BACnetPropertyStatesLiftCarDoorCommand"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for BACnetPropertyStatesLiftCarDoorCommand")
	}
	currentPos := positionAware.GetPos()
	_ = currentPos

	// Simple Field (liftCarDoorCommand)
	if pullErr := readBuffer.PullContext("liftCarDoorCommand"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for liftCarDoorCommand")
	}
	_liftCarDoorCommand, _liftCarDoorCommandErr := BACnetLiftCarDoorCommandTaggedParse(readBuffer, uint8(peekedTagNumber), TagClass(TagClass_CONTEXT_SPECIFIC_TAGS))
	if _liftCarDoorCommandErr != nil {
		return nil, errors.Wrap(_liftCarDoorCommandErr, "Error parsing 'liftCarDoorCommand' field of BACnetPropertyStatesLiftCarDoorCommand")
	}
	liftCarDoorCommand := _liftCarDoorCommand.(BACnetLiftCarDoorCommandTagged)
	if closeErr := readBuffer.CloseContext("liftCarDoorCommand"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for liftCarDoorCommand")
	}

	if closeErr := readBuffer.CloseContext("BACnetPropertyStatesLiftCarDoorCommand"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for BACnetPropertyStatesLiftCarDoorCommand")
	}

	// Create a partially initialized instance
	_child := &_BACnetPropertyStatesLiftCarDoorCommand{
		_BACnetPropertyStates: &_BACnetPropertyStates{},
		LiftCarDoorCommand:    liftCarDoorCommand,
	}
	_child._BACnetPropertyStates._BACnetPropertyStatesChildRequirements = _child
	return _child, nil
}

func (m *_BACnetPropertyStatesLiftCarDoorCommand) Serialize(writeBuffer utils.WriteBuffer) error {
	positionAware := writeBuffer
	_ = positionAware
	ser := func() error {
		if pushErr := writeBuffer.PushContext("BACnetPropertyStatesLiftCarDoorCommand"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for BACnetPropertyStatesLiftCarDoorCommand")
		}

		// Simple Field (liftCarDoorCommand)
		if pushErr := writeBuffer.PushContext("liftCarDoorCommand"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for liftCarDoorCommand")
		}
		_liftCarDoorCommandErr := writeBuffer.WriteSerializable(m.GetLiftCarDoorCommand())
		if popErr := writeBuffer.PopContext("liftCarDoorCommand"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for liftCarDoorCommand")
		}
		if _liftCarDoorCommandErr != nil {
			return errors.Wrap(_liftCarDoorCommandErr, "Error serializing 'liftCarDoorCommand' field")
		}

		if popErr := writeBuffer.PopContext("BACnetPropertyStatesLiftCarDoorCommand"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for BACnetPropertyStatesLiftCarDoorCommand")
		}
		return nil
	}
	return m.SerializeParent(writeBuffer, m, ser)
}

func (m *_BACnetPropertyStatesLiftCarDoorCommand) isBACnetPropertyStatesLiftCarDoorCommand() bool {
	return true
}

func (m *_BACnetPropertyStatesLiftCarDoorCommand) String() string {
	if m == nil {
		return "<nil>"
	}
	writeBuffer := utils.NewWriteBufferBoxBasedWithOptions(true, true)
	if err := writeBuffer.WriteSerializable(m); err != nil {
		return err.Error()
	}
	return writeBuffer.GetBox().String()
}
