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

// RequestEmpty is the corresponding interface of RequestEmpty
type RequestEmpty interface {
	utils.LengthAware
	utils.Serializable
	Request
}

// RequestEmptyExactly can be used when we want exactly this type and not a type which fulfills RequestEmpty.
// This is useful for switch cases.
type RequestEmptyExactly interface {
	RequestEmpty
	isRequestEmpty() bool
}

// _RequestEmpty is the data-structure of this message
type _RequestEmpty struct {
	*_Request
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for discriminator values.
///////////////////////

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

func (m *_RequestEmpty) InitializeParent(parent Request, peekedByte RequestType, startingCR *RequestType, resetMode *RequestType, secondPeek RequestType, termination RequestTermination) {
	m.PeekedByte = peekedByte
	m.StartingCR = startingCR
	m.ResetMode = resetMode
	m.SecondPeek = secondPeek
	m.Termination = termination
}

func (m *_RequestEmpty) GetParent() Request {
	return m._Request
}

// NewRequestEmpty factory function for _RequestEmpty
func NewRequestEmpty(peekedByte RequestType, startingCR *RequestType, resetMode *RequestType, secondPeek RequestType, termination RequestTermination, cBusOptions CBusOptions) *_RequestEmpty {
	_result := &_RequestEmpty{
		_Request: NewRequest(peekedByte, startingCR, resetMode, secondPeek, termination, cBusOptions),
	}
	_result._Request._RequestChildRequirements = _result
	return _result
}

// Deprecated: use the interface for direct cast
func CastRequestEmpty(structType interface{}) RequestEmpty {
	if casted, ok := structType.(RequestEmpty); ok {
		return casted
	}
	if casted, ok := structType.(*RequestEmpty); ok {
		return *casted
	}
	return nil
}

func (m *_RequestEmpty) GetTypeName() string {
	return "RequestEmpty"
}

func (m *_RequestEmpty) GetLengthInBits() uint16 {
	return m.GetLengthInBitsConditional(false)
}

func (m *_RequestEmpty) GetLengthInBitsConditional(lastItem bool) uint16 {
	lengthInBits := uint16(m.GetParentLengthInBits())

	return lengthInBits
}

func (m *_RequestEmpty) GetLengthInBytes() uint16 {
	return m.GetLengthInBits() / 8
}

func RequestEmptyParse(readBuffer utils.ReadBuffer, cBusOptions CBusOptions) (RequestEmpty, error) {
	positionAware := readBuffer
	_ = positionAware
	if pullErr := readBuffer.PullContext("RequestEmpty"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for RequestEmpty")
	}
	currentPos := positionAware.GetPos()
	_ = currentPos

	if closeErr := readBuffer.CloseContext("RequestEmpty"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for RequestEmpty")
	}

	// Create a partially initialized instance
	_child := &_RequestEmpty{
		_Request: &_Request{
			CBusOptions: cBusOptions,
		},
	}
	_child._Request._RequestChildRequirements = _child
	return _child, nil
}

func (m *_RequestEmpty) Serialize(writeBuffer utils.WriteBuffer) error {
	positionAware := writeBuffer
	_ = positionAware
	ser := func() error {
		if pushErr := writeBuffer.PushContext("RequestEmpty"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for RequestEmpty")
		}

		if popErr := writeBuffer.PopContext("RequestEmpty"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for RequestEmpty")
		}
		return nil
	}
	return m.SerializeParent(writeBuffer, m, ser)
}

func (m *_RequestEmpty) isRequestEmpty() bool {
	return true
}

func (m *_RequestEmpty) String() string {
	if m == nil {
		return "<nil>"
	}
	writeBuffer := utils.NewWriteBufferBoxBasedWithOptions(true, true)
	if err := writeBuffer.WriteSerializable(m); err != nil {
		return err.Error()
	}
	return writeBuffer.GetBox().String()
}
