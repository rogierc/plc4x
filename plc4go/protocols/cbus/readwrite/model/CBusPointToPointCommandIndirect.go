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

// CBusPointToPointCommandIndirect is the corresponding interface of CBusPointToPointCommandIndirect
type CBusPointToPointCommandIndirect interface {
	fmt.Stringer
	utils.LengthAware
	utils.Serializable
	CBusPointToPointCommand
	// GetBridgeAddress returns BridgeAddress (property field)
	GetBridgeAddress() BridgeAddress
	// GetNetworkRoute returns NetworkRoute (property field)
	GetNetworkRoute() NetworkRoute
	// GetUnitAddress returns UnitAddress (property field)
	GetUnitAddress() UnitAddress
}

// CBusPointToPointCommandIndirectExactly can be used when we want exactly this type and not a type which fulfills CBusPointToPointCommandIndirect.
// This is useful for switch cases.
type CBusPointToPointCommandIndirectExactly interface {
	CBusPointToPointCommandIndirect
	isCBusPointToPointCommandIndirect() bool
}

// _CBusPointToPointCommandIndirect is the data-structure of this message
type _CBusPointToPointCommandIndirect struct {
	*_CBusPointToPointCommand
	BridgeAddress BridgeAddress
	NetworkRoute  NetworkRoute
	UnitAddress   UnitAddress
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for discriminator values.
///////////////////////

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

func (m *_CBusPointToPointCommandIndirect) InitializeParent(parent CBusPointToPointCommand, bridgeAddressCountPeek uint16, calData CALData) {
	m.BridgeAddressCountPeek = bridgeAddressCountPeek
	m.CalData = calData
}

func (m *_CBusPointToPointCommandIndirect) GetParent() CBusPointToPointCommand {
	return m._CBusPointToPointCommand
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for property fields.
///////////////////////

func (m *_CBusPointToPointCommandIndirect) GetBridgeAddress() BridgeAddress {
	return m.BridgeAddress
}

func (m *_CBusPointToPointCommandIndirect) GetNetworkRoute() NetworkRoute {
	return m.NetworkRoute
}

func (m *_CBusPointToPointCommandIndirect) GetUnitAddress() UnitAddress {
	return m.UnitAddress
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

// NewCBusPointToPointCommandIndirect factory function for _CBusPointToPointCommandIndirect
func NewCBusPointToPointCommandIndirect(bridgeAddress BridgeAddress, networkRoute NetworkRoute, unitAddress UnitAddress, bridgeAddressCountPeek uint16, calData CALData, cBusOptions CBusOptions) *_CBusPointToPointCommandIndirect {
	_result := &_CBusPointToPointCommandIndirect{
		BridgeAddress:            bridgeAddress,
		NetworkRoute:             networkRoute,
		UnitAddress:              unitAddress,
		_CBusPointToPointCommand: NewCBusPointToPointCommand(bridgeAddressCountPeek, calData, cBusOptions),
	}
	_result._CBusPointToPointCommand._CBusPointToPointCommandChildRequirements = _result
	return _result
}

// Deprecated: use the interface for direct cast
func CastCBusPointToPointCommandIndirect(structType any) CBusPointToPointCommandIndirect {
	if casted, ok := structType.(CBusPointToPointCommandIndirect); ok {
		return casted
	}
	if casted, ok := structType.(*CBusPointToPointCommandIndirect); ok {
		return *casted
	}
	return nil
}

func (m *_CBusPointToPointCommandIndirect) GetTypeName() string {
	return "CBusPointToPointCommandIndirect"
}

func (m *_CBusPointToPointCommandIndirect) GetLengthInBits(ctx context.Context) uint16 {
	lengthInBits := uint16(m.GetParentLengthInBits(ctx))

	// Simple field (bridgeAddress)
	lengthInBits += m.BridgeAddress.GetLengthInBits(ctx)

	// Simple field (networkRoute)
	lengthInBits += m.NetworkRoute.GetLengthInBits(ctx)

	// Simple field (unitAddress)
	lengthInBits += m.UnitAddress.GetLengthInBits(ctx)

	return lengthInBits
}

func (m *_CBusPointToPointCommandIndirect) GetLengthInBytes(ctx context.Context) uint16 {
	return m.GetLengthInBits(ctx) / 8
}

func CBusPointToPointCommandIndirectParse(ctx context.Context, theBytes []byte, cBusOptions CBusOptions) (CBusPointToPointCommandIndirect, error) {
	return CBusPointToPointCommandIndirectParseWithBuffer(ctx, utils.NewReadBufferByteBased(theBytes), cBusOptions)
}

func CBusPointToPointCommandIndirectParseWithBuffer(ctx context.Context, readBuffer utils.ReadBuffer, cBusOptions CBusOptions) (CBusPointToPointCommandIndirect, error) {
	positionAware := readBuffer
	_ = positionAware
	log := zerolog.Ctx(ctx)
	_ = log
	if pullErr := readBuffer.PullContext("CBusPointToPointCommandIndirect"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for CBusPointToPointCommandIndirect")
	}
	currentPos := positionAware.GetPos()
	_ = currentPos

	// Simple Field (bridgeAddress)
	if pullErr := readBuffer.PullContext("bridgeAddress"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for bridgeAddress")
	}
	_bridgeAddress, _bridgeAddressErr := BridgeAddressParseWithBuffer(ctx, readBuffer)
	if _bridgeAddressErr != nil {
		return nil, errors.Wrap(_bridgeAddressErr, "Error parsing 'bridgeAddress' field of CBusPointToPointCommandIndirect")
	}
	bridgeAddress := _bridgeAddress.(BridgeAddress)
	if closeErr := readBuffer.CloseContext("bridgeAddress"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for bridgeAddress")
	}

	// Simple Field (networkRoute)
	if pullErr := readBuffer.PullContext("networkRoute"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for networkRoute")
	}
	_networkRoute, _networkRouteErr := NetworkRouteParseWithBuffer(ctx, readBuffer)
	if _networkRouteErr != nil {
		return nil, errors.Wrap(_networkRouteErr, "Error parsing 'networkRoute' field of CBusPointToPointCommandIndirect")
	}
	networkRoute := _networkRoute.(NetworkRoute)
	if closeErr := readBuffer.CloseContext("networkRoute"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for networkRoute")
	}

	// Simple Field (unitAddress)
	if pullErr := readBuffer.PullContext("unitAddress"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for unitAddress")
	}
	_unitAddress, _unitAddressErr := UnitAddressParseWithBuffer(ctx, readBuffer)
	if _unitAddressErr != nil {
		return nil, errors.Wrap(_unitAddressErr, "Error parsing 'unitAddress' field of CBusPointToPointCommandIndirect")
	}
	unitAddress := _unitAddress.(UnitAddress)
	if closeErr := readBuffer.CloseContext("unitAddress"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for unitAddress")
	}

	if closeErr := readBuffer.CloseContext("CBusPointToPointCommandIndirect"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for CBusPointToPointCommandIndirect")
	}

	// Create a partially initialized instance
	_child := &_CBusPointToPointCommandIndirect{
		_CBusPointToPointCommand: &_CBusPointToPointCommand{
			CBusOptions: cBusOptions,
		},
		BridgeAddress: bridgeAddress,
		NetworkRoute:  networkRoute,
		UnitAddress:   unitAddress,
	}
	_child._CBusPointToPointCommand._CBusPointToPointCommandChildRequirements = _child
	return _child, nil
}

func (m *_CBusPointToPointCommandIndirect) Serialize() ([]byte, error) {
	wb := utils.NewWriteBufferByteBased(utils.WithInitialSizeForByteBasedBuffer(int(m.GetLengthInBytes(context.Background()))))
	if err := m.SerializeWithWriteBuffer(context.Background(), wb); err != nil {
		return nil, err
	}
	return wb.GetBytes(), nil
}

func (m *_CBusPointToPointCommandIndirect) SerializeWithWriteBuffer(ctx context.Context, writeBuffer utils.WriteBuffer) error {
	positionAware := writeBuffer
	_ = positionAware
	log := zerolog.Ctx(ctx)
	_ = log
	ser := func() error {
		if pushErr := writeBuffer.PushContext("CBusPointToPointCommandIndirect"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for CBusPointToPointCommandIndirect")
		}

		// Simple Field (bridgeAddress)
		if pushErr := writeBuffer.PushContext("bridgeAddress"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for bridgeAddress")
		}
		_bridgeAddressErr := writeBuffer.WriteSerializable(ctx, m.GetBridgeAddress())
		if popErr := writeBuffer.PopContext("bridgeAddress"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for bridgeAddress")
		}
		if _bridgeAddressErr != nil {
			return errors.Wrap(_bridgeAddressErr, "Error serializing 'bridgeAddress' field")
		}

		// Simple Field (networkRoute)
		if pushErr := writeBuffer.PushContext("networkRoute"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for networkRoute")
		}
		_networkRouteErr := writeBuffer.WriteSerializable(ctx, m.GetNetworkRoute())
		if popErr := writeBuffer.PopContext("networkRoute"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for networkRoute")
		}
		if _networkRouteErr != nil {
			return errors.Wrap(_networkRouteErr, "Error serializing 'networkRoute' field")
		}

		// Simple Field (unitAddress)
		if pushErr := writeBuffer.PushContext("unitAddress"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for unitAddress")
		}
		_unitAddressErr := writeBuffer.WriteSerializable(ctx, m.GetUnitAddress())
		if popErr := writeBuffer.PopContext("unitAddress"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for unitAddress")
		}
		if _unitAddressErr != nil {
			return errors.Wrap(_unitAddressErr, "Error serializing 'unitAddress' field")
		}

		if popErr := writeBuffer.PopContext("CBusPointToPointCommandIndirect"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for CBusPointToPointCommandIndirect")
		}
		return nil
	}
	return m.SerializeParent(ctx, writeBuffer, m, ser)
}

func (m *_CBusPointToPointCommandIndirect) isCBusPointToPointCommandIndirect() bool {
	return true
}

func (m *_CBusPointToPointCommandIndirect) String() string {
	if m == nil {
		return "<nil>"
	}
	writeBuffer := utils.NewWriteBufferBoxBasedWithOptions(true, true)
	if err := writeBuffer.WriteSerializable(context.Background(), m); err != nil {
		return err.Error()
	}
	return writeBuffer.GetBox().String()
}
