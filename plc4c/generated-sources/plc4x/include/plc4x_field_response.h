/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

#ifndef PLC4C_PLC4X_READ_WRITE_PLC4X_FIELD_RESPONSE_H_
#define PLC4C_PLC4X_READ_WRITE_PLC4X_FIELD_RESPONSE_H_

#include <stdbool.h>
#include <stdint.h>
#include <plc4c/spi/read_buffer.h>
#include <plc4c/spi/write_buffer.h>
#include <plc4c/utils/list.h>
#include "plc4x_field.h"
#include "plc4x_response_code.h"

// Code generated by code-generation. DO NOT EDIT.


struct plc4c_plc4x_read_write_plc4x_field_response {
  /* Properties */
  plc4c_plc4x_read_write_plc4x_field* field;
  plc4c_plc4x_read_write_plc4x_response_code response_code;
};
typedef struct plc4c_plc4x_read_write_plc4x_field_response plc4c_plc4x_read_write_plc4x_field_response;

// Create an empty NULL-struct
plc4c_plc4x_read_write_plc4x_field_response plc4c_plc4x_read_write_plc4x_field_response_null();

plc4c_return_code plc4c_plc4x_read_write_plc4x_field_response_parse(plc4c_spi_read_buffer* readBuffer, plc4c_plc4x_read_write_plc4x_field_response** message);

plc4c_return_code plc4c_plc4x_read_write_plc4x_field_response_serialize(plc4c_spi_write_buffer* writeBuffer, plc4c_plc4x_read_write_plc4x_field_response* message);

uint16_t plc4c_plc4x_read_write_plc4x_field_response_length_in_bytes(plc4c_plc4x_read_write_plc4x_field_response* message);

uint16_t plc4c_plc4x_read_write_plc4x_field_response_length_in_bits(plc4c_plc4x_read_write_plc4x_field_response* message);

#endif  // PLC4C_PLC4X_READ_WRITE_PLC4X_FIELD_RESPONSE_H_
