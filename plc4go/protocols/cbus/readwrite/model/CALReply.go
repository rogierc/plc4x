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

// CALReply is the corresponding interface of CALReply
type CALReply interface {
	utils.LengthAware
	utils.Serializable
	// GetCalType returns CalType (property field)
	GetCalType() byte
	// GetCalData returns CalData (property field)
	GetCalData() CALData
	// GetTermination returns Termination (property field)
	GetTermination() ResponseTermination
}

// CALReplyExactly can be used when we want exactly this type and not a type which fulfills CALReply.
// This is useful for switch cases.
type CALReplyExactly interface {
	CALReply
	isCALReply() bool
}

// _CALReply is the data-structure of this message
type _CALReply struct {
	_CALReplyChildRequirements
	CalType     byte
	CalData     CALData
	Termination ResponseTermination
}

type _CALReplyChildRequirements interface {
	utils.Serializable
	GetLengthInBits() uint16
	GetLengthInBitsConditional(lastItem bool) uint16
}

type CALReplyParent interface {
	SerializeParent(writeBuffer utils.WriteBuffer, child CALReply, serializeChildFunction func() error) error
	GetTypeName() string
}

type CALReplyChild interface {
	utils.Serializable
	InitializeParent(parent CALReply, calType byte, calData CALData, termination ResponseTermination)
	GetParent() *CALReply

	GetTypeName() string
	CALReply
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for property fields.
///////////////////////

func (m *_CALReply) GetCalType() byte {
	return m.CalType
}

func (m *_CALReply) GetCalData() CALData {
	return m.CalData
}

func (m *_CALReply) GetTermination() ResponseTermination {
	return m.Termination
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

// NewCALReply factory function for _CALReply
func NewCALReply(calType byte, calData CALData, termination ResponseTermination) *_CALReply {
	return &_CALReply{CalType: calType, CalData: calData, Termination: termination}
}

// Deprecated: use the interface for direct cast
func CastCALReply(structType interface{}) CALReply {
	if casted, ok := structType.(CALReply); ok {
		return casted
	}
	if casted, ok := structType.(*CALReply); ok {
		return *casted
	}
	return nil
}

func (m *_CALReply) GetTypeName() string {
	return "CALReply"
}

func (m *_CALReply) GetParentLengthInBits() uint16 {
	lengthInBits := uint16(0)

	// Simple field (calData)
	lengthInBits += m.CalData.GetLengthInBits()

	// Simple field (termination)
	lengthInBits += m.Termination.GetLengthInBits()

	return lengthInBits
}

func (m *_CALReply) GetLengthInBytes() uint16 {
	return m.GetLengthInBits() / 8
}

func CALReplyParse(readBuffer utils.ReadBuffer) (CALReply, error) {
	positionAware := readBuffer
	_ = positionAware
	if pullErr := readBuffer.PullContext("CALReply"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for CALReply")
	}
	currentPos := positionAware.GetPos()
	_ = currentPos

	// Peek Field (calType)
	currentPos = positionAware.GetPos()
	calType, _err := readBuffer.ReadByte("calType")
	if _err != nil {
		return nil, errors.Wrap(_err, "Error parsing 'calType' field")
	}

	readBuffer.Reset(currentPos)

	// Switch Field (Depending on the discriminator values, passes the instantiation to a sub-type)
	type CALReplyChildSerializeRequirement interface {
		CALReply
		InitializeParent(CALReply, byte, CALData, ResponseTermination)
		GetParent() CALReply
	}
	var _childTemp interface{}
	var _child CALReplyChildSerializeRequirement
	var typeSwitchError error
	switch {
	case calType == 0x86: // CALReplyLong
		_childTemp, typeSwitchError = CALReplyLongParse(readBuffer)
	case true: // CALReplyShort
		_childTemp, typeSwitchError = CALReplyShortParse(readBuffer)
	default:
		// TODO: return actual type
		typeSwitchError = errors.New("Unmapped type")
	}
	if typeSwitchError != nil {
		return nil, errors.Wrap(typeSwitchError, "Error parsing sub-type for type-switch.")
	}
	_child = _childTemp.(CALReplyChildSerializeRequirement)

	// Simple Field (calData)
	if pullErr := readBuffer.PullContext("calData"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for calData")
	}
	_calData, _calDataErr := CALDataParse(readBuffer)
	if _calDataErr != nil {
		return nil, errors.Wrap(_calDataErr, "Error parsing 'calData' field")
	}
	calData := _calData.(CALData)
	if closeErr := readBuffer.CloseContext("calData"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for calData")
	}

	// Simple Field (termination)
	if pullErr := readBuffer.PullContext("termination"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for termination")
	}
	_termination, _terminationErr := ResponseTerminationParse(readBuffer)
	if _terminationErr != nil {
		return nil, errors.Wrap(_terminationErr, "Error parsing 'termination' field")
	}
	termination := _termination.(ResponseTermination)
	if closeErr := readBuffer.CloseContext("termination"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for termination")
	}

	if closeErr := readBuffer.CloseContext("CALReply"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for CALReply")
	}

	// Finish initializing
	_child.InitializeParent(_child, calType, calData, termination)
	return _child, nil
}

func (pm *_CALReply) SerializeParent(writeBuffer utils.WriteBuffer, child CALReply, serializeChildFunction func() error) error {
	// We redirect all calls through client as some methods are only implemented there
	m := child
	_ = m
	positionAware := writeBuffer
	_ = positionAware
	if pushErr := writeBuffer.PushContext("CALReply"); pushErr != nil {
		return errors.Wrap(pushErr, "Error pushing for CALReply")
	}

	// Switch field (Depending on the discriminator values, passes the serialization to a sub-type)
	if _typeSwitchErr := serializeChildFunction(); _typeSwitchErr != nil {
		return errors.Wrap(_typeSwitchErr, "Error serializing sub-type field")
	}

	// Simple Field (calData)
	if pushErr := writeBuffer.PushContext("calData"); pushErr != nil {
		return errors.Wrap(pushErr, "Error pushing for calData")
	}
	_calDataErr := writeBuffer.WriteSerializable(m.GetCalData())
	if popErr := writeBuffer.PopContext("calData"); popErr != nil {
		return errors.Wrap(popErr, "Error popping for calData")
	}
	if _calDataErr != nil {
		return errors.Wrap(_calDataErr, "Error serializing 'calData' field")
	}

	// Simple Field (termination)
	if pushErr := writeBuffer.PushContext("termination"); pushErr != nil {
		return errors.Wrap(pushErr, "Error pushing for termination")
	}
	_terminationErr := writeBuffer.WriteSerializable(m.GetTermination())
	if popErr := writeBuffer.PopContext("termination"); popErr != nil {
		return errors.Wrap(popErr, "Error popping for termination")
	}
	if _terminationErr != nil {
		return errors.Wrap(_terminationErr, "Error serializing 'termination' field")
	}

	if popErr := writeBuffer.PopContext("CALReply"); popErr != nil {
		return errors.Wrap(popErr, "Error popping for CALReply")
	}
	return nil
}

func (m *_CALReply) isCALReply() bool {
	return true
}

func (m *_CALReply) String() string {
	if m == nil {
		return "<nil>"
	}
	writeBuffer := utils.NewBoxedWriteBufferWithOptions(true, true)
	if err := writeBuffer.WriteSerializable(m); err != nil {
		return err.Error()
	}
	return writeBuffer.GetBox().String()
}
