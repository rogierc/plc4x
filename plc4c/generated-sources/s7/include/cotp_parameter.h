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

#ifndef PLC4C_S7_READ_WRITE_COTP_PARAMETER_H_
#define PLC4C_S7_READ_WRITE_COTP_PARAMETER_H_

#include <stdbool.h>
#include <stdint.h>
#include <plc4c/spi/read_buffer.h>
#include <plc4c/spi/write_buffer.h>
#include <plc4c/utils/list.h>
#include "cotp_tpdu_size.h"

// Code generated by code-generation. DO NOT EDIT.


// Structure used to contain the discriminator values for discriminated types using this as a parent
struct plc4c_s7_read_write_cotp_parameter_discriminator {
  uint8_t parameterType;
};
typedef struct plc4c_s7_read_write_cotp_parameter_discriminator plc4c_s7_read_write_cotp_parameter_discriminator;

// Enum assigning each subtype an individual id.
enum plc4c_s7_read_write_cotp_parameter_type {
  plc4c_s7_read_write_cotp_parameter_type_plc4c_s7_read_write_cotp_parameter_tpdu_size = 0,
  plc4c_s7_read_write_cotp_parameter_type_plc4c_s7_read_write_cotp_parameter_calling_tsap = 1,
  plc4c_s7_read_write_cotp_parameter_type_plc4c_s7_read_write_cotp_parameter_called_tsap = 2,
  plc4c_s7_read_write_cotp_parameter_type_plc4c_s7_read_write_cotp_parameter_checksum = 3,
  plc4c_s7_read_write_cotp_parameter_type_plc4c_s7_read_write_cotp_parameter_disconnect_additional_information = 4};
typedef enum plc4c_s7_read_write_cotp_parameter_type plc4c_s7_read_write_cotp_parameter_type;

// Function to get the discriminator values for a given type.
plc4c_s7_read_write_cotp_parameter_discriminator plc4c_s7_read_write_cotp_parameter_get_discriminator(plc4c_s7_read_write_cotp_parameter_type type);

struct plc4c_s7_read_write_cotp_parameter {
  /* This is an abstract type so this property saves the type of this typed union */
  plc4c_s7_read_write_cotp_parameter_type _type;
  /* Properties */
  union {
    struct { /* COTPParameterTpduSize */
      plc4c_s7_read_write_cotp_tpdu_size cotp_parameter_tpdu_size_tpdu_size;
    };
    struct { /* COTPParameterCallingTsap */
      uint16_t cotp_parameter_calling_tsap_tsap_id;
    };
    struct { /* COTPParameterCalledTsap */
      uint16_t cotp_parameter_called_tsap_tsap_id;
    };
    struct { /* COTPParameterChecksum */
      uint8_t cotp_parameter_checksum_crc;
    };
    struct { /* COTPParameterDisconnectAdditionalInformation */
      plc4c_list* cotp_parameter_disconnect_additional_information_data;
    };
  };
};
typedef struct plc4c_s7_read_write_cotp_parameter plc4c_s7_read_write_cotp_parameter;

// Create an empty NULL-struct
plc4c_s7_read_write_cotp_parameter plc4c_s7_read_write_cotp_parameter_null();

plc4c_return_code plc4c_s7_read_write_cotp_parameter_parse(plc4c_spi_read_buffer* readBuffer, uint8_t rest, plc4c_s7_read_write_cotp_parameter** message);

plc4c_return_code plc4c_s7_read_write_cotp_parameter_serialize(plc4c_spi_write_buffer* writeBuffer, plc4c_s7_read_write_cotp_parameter* message);

uint16_t plc4c_s7_read_write_cotp_parameter_length_in_bytes(plc4c_s7_read_write_cotp_parameter* message);

uint16_t plc4c_s7_read_write_cotp_parameter_length_in_bits(plc4c_s7_read_write_cotp_parameter* message);

#endif  // PLC4C_S7_READ_WRITE_COTP_PARAMETER_H_
