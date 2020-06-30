/*
  Licensed to the Apache Software Foundation (ASF) under one
  or more contributor license agreements.  See the NOTICE file
  distributed with this work for additional information
  regarding copyright ownership.  The ASF licenses this file
  to you under the Apache License, Version 2.0 (the
  "License"); you may not use this file except in compliance
  with the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing,
  software distributed under the License is distributed on an
  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
  KIND, either express or implied.  See the License for the
  specific language governing permissions and limitations
  under the License.
*/

#include <stdio.h>
#include <plc4c/spi/read_buffer.h>
#include <plc4c/spi/write_buffer.h>
#include <plc4c/spi/evaluation_helper.h>
#include "s7_parameter_user_data_item.h"

// Array of discriminator values that match the enum type constants.
// (The order is identical to the enum constants so we can use the
// enum constant to directly access a given types discriminator values)
const plc4c_s7_read_write_s7_parameter_user_data_item_discriminator plc4c_s7_read_write_s7_parameter_user_data_item_discriminators[] = {
  {/* plc4c_s7_read_write_s7_parameter_user_data_item_cpu_functions */
   .itemType = 0x12}
};

// Function returning the discriminator values for a given type constant.
plc4c_s7_read_write_s7_parameter_user_data_item_discriminator plc4c_s7_read_write_s7_parameter_user_data_item_get_discriminator(plc4c_s7_read_write_s7_parameter_user_data_item_type type) {
  return plc4c_s7_read_write_s7_parameter_user_data_item_discriminators[type];
}

// Parse function.
plc4c_return_code plc4c_s7_read_write_s7_parameter_user_data_item_parse(plc4c_spi_read_buffer* buf, plc4c_s7_read_write_s7_parameter_user_data_item** _message) {
  uint16_t startPos = plc4c_spi_read_get_pos(buf);
  uint16_t curPos;
  plc4c_return_code _res = OK;

  // Allocate enough memory to contain this data structure.
  (*_message) = malloc(sizeof(plc4c_s7_read_write_s7_parameter_user_data_item));
  if(*_message == NULL) {
    return NO_MEMORY;
  }

  // Discriminator Field (itemType) (Used as input to a switch field)
  uint8_t itemType = 0;
  _res = plc4c_spi_read_unsigned_byte(buf, 8, (uint8_t*) &itemType);
  if(_res != OK) {
    return _res;
  }

  // Switch Field (Depending on the discriminator values, passes the instantiation to a sub-type)
  if(itemType == 0x12) { /* S7ParameterUserDataItemCPUFunctions */
    (*_message)->_type = plc4c_s7_read_write_s7_parameter_user_data_item_type_plc4c_s7_read_write_s7_parameter_user_data_item_cpu_functions;
                    
    // Implicit Field (itemLength) (Used for parsing, but it's value is not stored as it's implicitly given by the objects content)
    uint8_t itemLength = 0;
    _res = plc4c_spi_read_unsigned_byte(buf, 8, (uint8_t*) &itemLength);
    if(_res != OK) {
      return _res;
    }


                    
    // Simple Field (method)
    uint8_t method = 0;
    _res = plc4c_spi_read_unsigned_byte(buf, 8, (uint8_t*) &method);
    if(_res != OK) {
      return _res;
    }
    (*_message)->s7_parameter_user_data_item_cpu_functions_method = method;


                    
    // Simple Field (cpuFunctionType)
    unsigned int cpuFunctionType = 0;
    _res = plc4c_spi_read_unsigned_byte(buf, 4, (uint8_t*) &cpuFunctionType);
    if(_res != OK) {
      return _res;
    }
    (*_message)->s7_parameter_user_data_item_cpu_functions_cpu_function_type = cpuFunctionType;


                    
    // Simple Field (cpuFunctionGroup)
    unsigned int cpuFunctionGroup = 0;
    _res = plc4c_spi_read_unsigned_byte(buf, 4, (uint8_t*) &cpuFunctionGroup);
    if(_res != OK) {
      return _res;
    }
    (*_message)->s7_parameter_user_data_item_cpu_functions_cpu_function_group = cpuFunctionGroup;


                    
    // Simple Field (cpuSubfunction)
    uint8_t cpuSubfunction = 0;
    _res = plc4c_spi_read_unsigned_byte(buf, 8, (uint8_t*) &cpuSubfunction);
    if(_res != OK) {
      return _res;
    }
    (*_message)->s7_parameter_user_data_item_cpu_functions_cpu_subfunction = cpuSubfunction;


                    
    // Simple Field (sequenceNumber)
    uint8_t sequenceNumber = 0;
    _res = plc4c_spi_read_unsigned_byte(buf, 8, (uint8_t*) &sequenceNumber);
    if(_res != OK) {
      return _res;
    }
    (*_message)->s7_parameter_user_data_item_cpu_functions_sequence_number = sequenceNumber;


                    
    // Optional Field (dataUnitReferenceNumber) (Can be skipped, if a given expression evaluates to false)
    uint8_t* dataUnitReferenceNumber = NULL;
    if((cpuFunctionType) == (8)) {
      dataUnitReferenceNumber = malloc(sizeof(uint8_t));
      if(dataUnitReferenceNumber == NULL) {
        return NO_MEMORY;
      }
      *dataUnitReferenceNumber = 0;
      _res = plc4c_spi_read_unsigned_byte(buf, 8, (uint8_t*) &dataUnitReferenceNumber);
      if(_res != OK) {
        return _res;
      }
      (*_message)->s7_parameter_user_data_item_cpu_functions_data_unit_reference_number = dataUnitReferenceNumber;
    }


                    
    // Optional Field (lastDataUnit) (Can be skipped, if a given expression evaluates to false)
    uint8_t* lastDataUnit = NULL;
    if((cpuFunctionType) == (8)) {
      lastDataUnit = malloc(sizeof(uint8_t));
      if(lastDataUnit == NULL) {
        return NO_MEMORY;
      }
      *lastDataUnit = 0;
      _res = plc4c_spi_read_unsigned_byte(buf, 8, (uint8_t*) &lastDataUnit);
      if(_res != OK) {
        return _res;
      }
      (*_message)->s7_parameter_user_data_item_cpu_functions_last_data_unit = lastDataUnit;
    }


                    
    // Optional Field (errorCode) (Can be skipped, if a given expression evaluates to false)
    uint16_t* errorCode = NULL;
    if((cpuFunctionType) == (8)) {
      errorCode = malloc(sizeof(uint16_t));
      if(errorCode == NULL) {
        return NO_MEMORY;
      }
      *errorCode = 0;
      _res = plc4c_spi_read_unsigned_short(buf, 16, (uint16_t*) &errorCode);
      if(_res != OK) {
        return _res;
      }
      (*_message)->s7_parameter_user_data_item_cpu_functions_error_code = errorCode;
    }

  }

  return OK;
}

plc4c_return_code plc4c_s7_read_write_s7_parameter_user_data_item_serialize(plc4c_spi_write_buffer* buf, plc4c_s7_read_write_s7_parameter_user_data_item* _message) {
  plc4c_return_code _res = OK;

  // Discriminator Field (itemType)
  plc4c_spi_write_unsigned_byte(buf, 8, plc4c_s7_read_write_s7_parameter_user_data_item_get_discriminator(_message->_type).itemType);

  // Switch Field (Depending of the current type, serialize the sub-type elements)
  switch(_message->_type) {
    case plc4c_s7_read_write_s7_parameter_user_data_item_type_plc4c_s7_read_write_s7_parameter_user_data_item_cpu_functions: {

      // Implicit Field (itemLength) (Used for parsing, but it's value is not stored as it's implicitly given by the objects content)
      _res = plc4c_spi_write_unsigned_byte(buf, 8, (plc4c_s7_read_write_s7_parameter_user_data_item_length_in_bytes(_message)) - (2));
      if(_res != OK) {
        return _res;
      }

      // Simple Field (method)
      _res = plc4c_spi_write_unsigned_byte(buf, 8, _message->s7_parameter_user_data_item_cpu_functions_method);
      if(_res != OK) {
        return _res;
      }

      // Simple Field (cpuFunctionType)
      _res = plc4c_spi_write_unsigned_byte(buf, 4, _message->s7_parameter_user_data_item_cpu_functions_cpu_function_type);
      if(_res != OK) {
        return _res;
      }

      // Simple Field (cpuFunctionGroup)
      _res = plc4c_spi_write_unsigned_byte(buf, 4, _message->s7_parameter_user_data_item_cpu_functions_cpu_function_group);
      if(_res != OK) {
        return _res;
      }

      // Simple Field (cpuSubfunction)
      _res = plc4c_spi_write_unsigned_byte(buf, 8, _message->s7_parameter_user_data_item_cpu_functions_cpu_subfunction);
      if(_res != OK) {
        return _res;
      }

      // Simple Field (sequenceNumber)
      _res = plc4c_spi_write_unsigned_byte(buf, 8, _message->s7_parameter_user_data_item_cpu_functions_sequence_number);
      if(_res != OK) {
        return _res;
      }

      // Optional Field (dataUnitReferenceNumber)
      if(_message->s7_parameter_user_data_item_cpu_functions_data_unit_reference_number != NULL) {
        _res = plc4c_spi_write_unsigned_byte(buf, 8, *_message->s7_parameter_user_data_item_cpu_functions_data_unit_reference_number);
        if(_res != OK) {
          return _res;
        }
      }

      // Optional Field (lastDataUnit)
      if(_message->s7_parameter_user_data_item_cpu_functions_last_data_unit != NULL) {
        _res = plc4c_spi_write_unsigned_byte(buf, 8, *_message->s7_parameter_user_data_item_cpu_functions_last_data_unit);
        if(_res != OK) {
          return _res;
        }
      }

      // Optional Field (errorCode)
      if(_message->s7_parameter_user_data_item_cpu_functions_error_code != NULL) {
        _res = plc4c_spi_write_unsigned_short(buf, 16, *_message->s7_parameter_user_data_item_cpu_functions_error_code);
        if(_res != OK) {
          return _res;
        }
      }

      break;
    }
  }

  return OK;
}

uint8_t plc4c_s7_read_write_s7_parameter_user_data_item_length_in_bytes(plc4c_s7_read_write_s7_parameter_user_data_item* _message) {
  return plc4c_s7_read_write_s7_parameter_user_data_item_length_in_bits(_message) / 8;
}

uint8_t plc4c_s7_read_write_s7_parameter_user_data_item_length_in_bits(plc4c_s7_read_write_s7_parameter_user_data_item* _message) {
  uint8_t lengthInBits = 0;

  // Discriminator Field (itemType)
  lengthInBits += 8;

  // Depending of the current type, add the length of sub-type elements ...
  switch(_message->_type) {
    case plc4c_s7_read_write_s7_parameter_user_data_item_type_plc4c_s7_read_write_s7_parameter_user_data_item_cpu_functions: {

      // Implicit Field (itemLength)
      lengthInBits += 8;


      // Simple field (method)
      lengthInBits += 8;


      // Simple field (cpuFunctionType)
      lengthInBits += 4;


      // Simple field (cpuFunctionGroup)
      lengthInBits += 4;


      // Simple field (cpuSubfunction)
      lengthInBits += 8;


      // Simple field (sequenceNumber)
      lengthInBits += 8;


      // Optional Field (dataUnitReferenceNumber)
      if(_message->s7_parameter_user_data_item_cpu_functions_data_unit_reference_number != NULL) {
        lengthInBits += 8;
      }


      // Optional Field (lastDataUnit)
      if(_message->s7_parameter_user_data_item_cpu_functions_last_data_unit != NULL) {
        lengthInBits += 8;
      }


      // Optional Field (errorCode)
      if(_message->s7_parameter_user_data_item_cpu_functions_error_code != NULL) {
        lengthInBits += 16;
      }

      break;
    }
  }

  return lengthInBits;
}

