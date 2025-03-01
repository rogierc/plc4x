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

// Code generated by mockery v2.32.4. DO NOT EDIT.

package model

import mock "github.com/stretchr/testify/mock"

// MockPlcResponse is an autogenerated mock type for the PlcResponse type
type MockPlcResponse struct {
	mock.Mock
}

type MockPlcResponse_Expecter struct {
	mock *mock.Mock
}

func (_m *MockPlcResponse) EXPECT() *MockPlcResponse_Expecter {
	return &MockPlcResponse_Expecter{mock: &_m.Mock}
}

// IsAPlcMessage provides a mock function with given fields:
func (_m *MockPlcResponse) IsAPlcMessage() bool {
	ret := _m.Called()

	var r0 bool
	if rf, ok := ret.Get(0).(func() bool); ok {
		r0 = rf()
	} else {
		r0 = ret.Get(0).(bool)
	}

	return r0
}

// MockPlcResponse_IsAPlcMessage_Call is a *mock.Call that shadows Run/Return methods with type explicit version for method 'IsAPlcMessage'
type MockPlcResponse_IsAPlcMessage_Call struct {
	*mock.Call
}

// IsAPlcMessage is a helper method to define mock.On call
func (_e *MockPlcResponse_Expecter) IsAPlcMessage() *MockPlcResponse_IsAPlcMessage_Call {
	return &MockPlcResponse_IsAPlcMessage_Call{Call: _e.mock.On("IsAPlcMessage")}
}

func (_c *MockPlcResponse_IsAPlcMessage_Call) Run(run func()) *MockPlcResponse_IsAPlcMessage_Call {
	_c.Call.Run(func(args mock.Arguments) {
		run()
	})
	return _c
}

func (_c *MockPlcResponse_IsAPlcMessage_Call) Return(_a0 bool) *MockPlcResponse_IsAPlcMessage_Call {
	_c.Call.Return(_a0)
	return _c
}

func (_c *MockPlcResponse_IsAPlcMessage_Call) RunAndReturn(run func() bool) *MockPlcResponse_IsAPlcMessage_Call {
	_c.Call.Return(run)
	return _c
}

// String provides a mock function with given fields:
func (_m *MockPlcResponse) String() string {
	ret := _m.Called()

	var r0 string
	if rf, ok := ret.Get(0).(func() string); ok {
		r0 = rf()
	} else {
		r0 = ret.Get(0).(string)
	}

	return r0
}

// MockPlcResponse_String_Call is a *mock.Call that shadows Run/Return methods with type explicit version for method 'String'
type MockPlcResponse_String_Call struct {
	*mock.Call
}

// String is a helper method to define mock.On call
func (_e *MockPlcResponse_Expecter) String() *MockPlcResponse_String_Call {
	return &MockPlcResponse_String_Call{Call: _e.mock.On("String")}
}

func (_c *MockPlcResponse_String_Call) Run(run func()) *MockPlcResponse_String_Call {
	_c.Call.Run(func(args mock.Arguments) {
		run()
	})
	return _c
}

func (_c *MockPlcResponse_String_Call) Return(_a0 string) *MockPlcResponse_String_Call {
	_c.Call.Return(_a0)
	return _c
}

func (_c *MockPlcResponse_String_Call) RunAndReturn(run func() string) *MockPlcResponse_String_Call {
	_c.Call.Return(run)
	return _c
}

// NewMockPlcResponse creates a new instance of MockPlcResponse. It also registers a testing interface on the mock and a cleanup function to assert the mocks expectations.
// The first argument is typically a *testing.T value.
func NewMockPlcResponse(t interface {
	mock.TestingT
	Cleanup(func())
}) *MockPlcResponse {
	mock := &MockPlcResponse{}
	mock.Mock.Test(t)

	t.Cleanup(func() { mock.AssertExpectations(t) })

	return mock
}
