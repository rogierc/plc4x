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
	"fmt"
	"github.com/apache/plc4x/plc4go/internal/spi/utils"
	"github.com/pkg/errors"
)

// Code generated by code-generation. DO NOT EDIT.

// Constant values.
const PowerUp_POWERUPINDICATOR byte = 0x2B

// PowerUp is the corresponding interface of PowerUp
type PowerUp interface {
	utils.LengthAware
	utils.Serializable
	// GetGarbage returns Garbage (property field)
	GetGarbage() []byte
	// GetReqTermination returns ReqTermination (property field)
	GetReqTermination() RequestTermination
	// GetResTermination returns ResTermination (property field)
	GetResTermination() ResponseTermination
}

// PowerUpExactly can be used when we want exactly this type and not a type which fulfills PowerUp.
// This is useful for switch cases.
type PowerUpExactly interface {
	PowerUp
	isPowerUp() bool
}

// _PowerUp is the data-structure of this message
type _PowerUp struct {
	Garbage        []byte
	ReqTermination RequestTermination
	ResTermination ResponseTermination
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for property fields.
///////////////////////

func (m *_PowerUp) GetGarbage() []byte {
	return m.Garbage
}

func (m *_PowerUp) GetReqTermination() RequestTermination {
	return m.ReqTermination
}

func (m *_PowerUp) GetResTermination() ResponseTermination {
	return m.ResTermination
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for const fields.
///////////////////////

func (m *_PowerUp) GetPowerUpIndicator() byte {
	return PowerUp_POWERUPINDICATOR
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

// NewPowerUp factory function for _PowerUp
func NewPowerUp(garbage []byte, reqTermination RequestTermination, resTermination ResponseTermination) *_PowerUp {
	return &_PowerUp{Garbage: garbage, ReqTermination: reqTermination, ResTermination: resTermination}
}

// Deprecated: use the interface for direct cast
func CastPowerUp(structType interface{}) PowerUp {
	if casted, ok := structType.(PowerUp); ok {
		return casted
	}
	if casted, ok := structType.(*PowerUp); ok {
		return *casted
	}
	return nil
}

func (m *_PowerUp) GetTypeName() string {
	return "PowerUp"
}

func (m *_PowerUp) GetLengthInBits() uint16 {
	return m.GetLengthInBitsConditional(false)
}

func (m *_PowerUp) GetLengthInBitsConditional(lastItem bool) uint16 {
	lengthInBits := uint16(0)

	// Const Field (powerUpIndicator)
	lengthInBits += 8

	// Array field
	if len(m.Garbage) > 0 {
		lengthInBits += 8 * uint16(len(m.Garbage))
	}

	// Simple field (reqTermination)
	lengthInBits += m.ReqTermination.GetLengthInBits()

	// Simple field (resTermination)
	lengthInBits += m.ResTermination.GetLengthInBits()

	return lengthInBits
}

func (m *_PowerUp) GetLengthInBytes() uint16 {
	return m.GetLengthInBits() / 8
}

func PowerUpParse(readBuffer utils.ReadBuffer) (PowerUp, error) {
	positionAware := readBuffer
	_ = positionAware
	if pullErr := readBuffer.PullContext("PowerUp"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for PowerUp")
	}
	currentPos := positionAware.GetPos()
	_ = currentPos

	// Const Field (powerUpIndicator)
	powerUpIndicator, _powerUpIndicatorErr := readBuffer.ReadByte("powerUpIndicator")
	if _powerUpIndicatorErr != nil {
		return nil, errors.Wrap(_powerUpIndicatorErr, "Error parsing 'powerUpIndicator' field")
	}
	if powerUpIndicator != PowerUp_POWERUPINDICATOR {
		return nil, errors.New("Expected constant value " + fmt.Sprintf("%d", PowerUp_POWERUPINDICATOR) + " but got " + fmt.Sprintf("%d", powerUpIndicator))
	}
	// Byte Array field (garbage)
	numberOfBytesgarbage := int(0x0D)
	garbage, _readArrayErr := readBuffer.ReadByteArray("garbage", numberOfBytesgarbage)
	if _readArrayErr != nil {
		return nil, errors.Wrap(_readArrayErr, "Error parsing 'garbage' field")
	}

	// Simple Field (reqTermination)
	if pullErr := readBuffer.PullContext("reqTermination"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for reqTermination")
	}
	_reqTermination, _reqTerminationErr := RequestTerminationParse(readBuffer)
	if _reqTerminationErr != nil {
		return nil, errors.Wrap(_reqTerminationErr, "Error parsing 'reqTermination' field")
	}
	reqTermination := _reqTermination.(RequestTermination)
	if closeErr := readBuffer.CloseContext("reqTermination"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for reqTermination")
	}

	// Simple Field (resTermination)
	if pullErr := readBuffer.PullContext("resTermination"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for resTermination")
	}
	_resTermination, _resTerminationErr := ResponseTerminationParse(readBuffer)
	if _resTerminationErr != nil {
		return nil, errors.Wrap(_resTerminationErr, "Error parsing 'resTermination' field")
	}
	resTermination := _resTermination.(ResponseTermination)
	if closeErr := readBuffer.CloseContext("resTermination"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for resTermination")
	}

	if closeErr := readBuffer.CloseContext("PowerUp"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for PowerUp")
	}

	// Create the instance
	return NewPowerUp(garbage, reqTermination, resTermination), nil
}

func (m *_PowerUp) Serialize(writeBuffer utils.WriteBuffer) error {
	positionAware := writeBuffer
	_ = positionAware
	if pushErr := writeBuffer.PushContext("PowerUp"); pushErr != nil {
		return errors.Wrap(pushErr, "Error pushing for PowerUp")
	}

	// Const Field (powerUpIndicator)
	_powerUpIndicatorErr := writeBuffer.WriteByte("powerUpIndicator", 0x2B)
	if _powerUpIndicatorErr != nil {
		return errors.Wrap(_powerUpIndicatorErr, "Error serializing 'powerUpIndicator' field")
	}

	// Array Field (garbage)
	// Byte Array field (garbage)
	if err := writeBuffer.WriteByteArray("garbage", m.GetGarbage()); err != nil {
		return errors.Wrap(err, "Error serializing 'garbage' field")
	}

	// Simple Field (reqTermination)
	if pushErr := writeBuffer.PushContext("reqTermination"); pushErr != nil {
		return errors.Wrap(pushErr, "Error pushing for reqTermination")
	}
	_reqTerminationErr := writeBuffer.WriteSerializable(m.GetReqTermination())
	if popErr := writeBuffer.PopContext("reqTermination"); popErr != nil {
		return errors.Wrap(popErr, "Error popping for reqTermination")
	}
	if _reqTerminationErr != nil {
		return errors.Wrap(_reqTerminationErr, "Error serializing 'reqTermination' field")
	}

	// Simple Field (resTermination)
	if pushErr := writeBuffer.PushContext("resTermination"); pushErr != nil {
		return errors.Wrap(pushErr, "Error pushing for resTermination")
	}
	_resTerminationErr := writeBuffer.WriteSerializable(m.GetResTermination())
	if popErr := writeBuffer.PopContext("resTermination"); popErr != nil {
		return errors.Wrap(popErr, "Error popping for resTermination")
	}
	if _resTerminationErr != nil {
		return errors.Wrap(_resTerminationErr, "Error serializing 'resTermination' field")
	}

	if popErr := writeBuffer.PopContext("PowerUp"); popErr != nil {
		return errors.Wrap(popErr, "Error popping for PowerUp")
	}
	return nil
}

func (m *_PowerUp) isPowerUp() bool {
	return true
}

func (m *_PowerUp) String() string {
	if m == nil {
		return "<nil>"
	}
	writeBuffer := utils.NewBoxedWriteBufferWithOptions(true, true)
	if err := writeBuffer.WriteSerializable(m); err != nil {
		return err.Error()
	}
	return writeBuffer.GetBox().String()
}
