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

#include <stdio.h>
#include <string.h>
#include <time.h>
#include <plc4c/data.h>
#include <plc4c/utils/list.h>
#include <plc4c/spi/evaluation_helper.h>
#include <plc4c/spi/types_private.h>
#include <plc4c/driver_modbus_static.h>

#include "data_item.h"

// Code generated by code-generation. DO NOT EDIT.

// Parse function.
plc4c_return_code plc4c_modbus_read_write_data_item_parse(plc4c_spi_read_buffer* readBuffer, plc4c_modbus_read_write_modbus_data_type dataType, uint16_t numberOfValues, plc4c_data** data_item) {
    uint16_t startPos = plc4c_spi_read_get_pos(readBuffer);
    uint16_t curPos;
    plc4c_return_code _res = OK;

        if((dataType == plc4c_modbus_read_write_modbus_data_type_BOOL) && (numberOfValues == 1)) { /* BOOL */

                // Reserved Field (Compartmentalized so the "reserved" variable can't leak)
                {
                    uint16_t _reserved = 0;
                    _res = plc4c_spi_read_unsigned_short(readBuffer, 15, (uint16_t*) &_reserved);
                    if(_res != OK) {
                        return _res;
                    }
                    if(_reserved != 0x0000) {
                      printf("Expected constant value '%d' but got '%d' for reserved field.", 0x0000, _reserved);
                    }
                }

                // Simple Field (value)
                bool value = false;
                _res = plc4c_spi_read_bit(readBuffer, (bool*) &value);
                if(_res != OK) {
                    return _res;
                }

                *data_item = plc4c_data_create_bool_data(value);

    } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_BOOL) { /* List */

        // Array field (value)
        // Count array
        plc4c_list* value;
        plc4c_utils_list_create(&value);
        int itemCount = (int) numberOfValues;
        for(int curItem = 0; curItem < itemCount; curItem++) {
            bool* _val = malloc(sizeof(bool) * 1);
            _res = plc4c_spi_read_bit(readBuffer, (bool*) _val);
            if(_res != OK) {
                return _res;
            }
            plc4c_data* _item = plc4c_data_create_bool_data(*_val);
            plc4c_utils_list_insert_head_value(value, _item);
        }
        *data_item = plc4c_data_create_list_data(value);

    } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_BYTE) && (numberOfValues == 1)) { /* BYTE */

                // Reserved Field (Compartmentalized so the "reserved" variable can't leak)
                {
                    uint8_t _reserved = 0;
                    _res = plc4c_spi_read_unsigned_byte(readBuffer, 8, (uint8_t*) &_reserved);
                    if(_res != OK) {
                        return _res;
                    }
                    if(_reserved != 0x00) {
                      printf("Expected constant value '%d' but got '%d' for reserved field.", 0x00, _reserved);
                    }
                }

                // Simple Field (value)
                uint8_t value = 0;
                _res = plc4c_spi_read_unsigned_byte(readBuffer, 8, (uint8_t*) &value);
                if(_res != OK) {
                    return _res;
                }

                *data_item = plc4c_data_create_byte_data(value);

    } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_BYTE) { /* List */

        // Array field (value)
        // Count array
        plc4c_list* value;
        plc4c_utils_list_create(&value);
        int itemCount = (int) (numberOfValues) * (8);
        for(int curItem = 0; curItem < itemCount; curItem++) {
            bool* _val = malloc(sizeof(bool) * 1);
            _res = plc4c_spi_read_bit(readBuffer, (bool*) _val);
            if(_res != OK) {
                return _res;
            }
            plc4c_data* _item = plc4c_data_create_bool_data(*_val);
            plc4c_utils_list_insert_head_value(value, _item);
        }
        *data_item = plc4c_data_create_list_data(value);

    } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_WORD) { /* WORD */

                // Simple Field (value)
                uint16_t value = 0;
                _res = plc4c_spi_read_unsigned_short(readBuffer, 16, (uint16_t*) &value);
                if(_res != OK) {
                    return _res;
                }

                *data_item = plc4c_data_create_word_data(value);

    } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_DWORD) { /* DWORD */

                // Simple Field (value)
                uint32_t value = 0;
                _res = plc4c_spi_read_unsigned_int(readBuffer, 32, (uint32_t*) &value);
                if(_res != OK) {
                    return _res;
                }

                *data_item = plc4c_data_create_dword_data(value);

    } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_LWORD) { /* LWORD */

                // Simple Field (value)
                uint64_t value = 0;
                _res = plc4c_spi_read_unsigned_long(readBuffer, 64, (uint64_t*) &value);
                if(_res != OK) {
                    return _res;
                }

                *data_item = plc4c_data_create_lword_data(value);

    } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_SINT) && (numberOfValues == 1)) { /* SINT */

                // Reserved Field (Compartmentalized so the "reserved" variable can't leak)
                {
                    uint8_t _reserved = 0;
                    _res = plc4c_spi_read_unsigned_byte(readBuffer, 8, (uint8_t*) &_reserved);
                    if(_res != OK) {
                        return _res;
                    }
                    if(_reserved != 0x00) {
                      printf("Expected constant value '%d' but got '%d' for reserved field.", 0x00, _reserved);
                    }
                }

                // Simple Field (value)
                int8_t value = 0;
                _res = plc4c_spi_read_signed_byte(readBuffer, 8, (int8_t*) &value);
                if(_res != OK) {
                    return _res;
                }

                *data_item = plc4c_data_create_sint_data(value);

    } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_SINT) { /* List */

        // Array field (value)
        // Count array
        plc4c_list* value;
        plc4c_utils_list_create(&value);
        int itemCount = (int) numberOfValues;
        for(int curItem = 0; curItem < itemCount; curItem++) {
            int8_t* _val = malloc(sizeof(int8_t) * 1);
            _res = plc4c_spi_read_signed_byte(readBuffer, 8, (int8_t*) _val);
            if(_res != OK) {
                return _res;
            }
            plc4c_data* _item = plc4c_data_create_sint_data(*_val);
            plc4c_utils_list_insert_head_value(value, _item);
        }
        *data_item = plc4c_data_create_list_data(value);

    } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_INT) && (numberOfValues == 1)) { /* INT */

                // Simple Field (value)
                int16_t value = 0;
                _res = plc4c_spi_read_signed_short(readBuffer, 16, (int16_t*) &value);
                if(_res != OK) {
                    return _res;
                }

                *data_item = plc4c_data_create_int_data(value);

    } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_INT) { /* List */

        // Array field (value)
        // Count array
        plc4c_list* value;
        plc4c_utils_list_create(&value);
        int itemCount = (int) numberOfValues;
        for(int curItem = 0; curItem < itemCount; curItem++) {
            int16_t* _val = malloc(sizeof(int16_t) * 1);
            _res = plc4c_spi_read_signed_short(readBuffer, 16, (int16_t*) _val);
            if(_res != OK) {
                return _res;
            }
            plc4c_data* _item = plc4c_data_create_int_data(*_val);
            plc4c_utils_list_insert_head_value(value, _item);
        }
        *data_item = plc4c_data_create_list_data(value);

    } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_DINT) && (numberOfValues == 1)) { /* DINT */

                // Simple Field (value)
                int32_t value = 0;
                _res = plc4c_spi_read_signed_int(readBuffer, 32, (int32_t*) &value);
                if(_res != OK) {
                    return _res;
                }

                *data_item = plc4c_data_create_dint_data(value);

    } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_DINT) { /* List */

        // Array field (value)
        // Count array
        plc4c_list* value;
        plc4c_utils_list_create(&value);
        int itemCount = (int) numberOfValues;
        for(int curItem = 0; curItem < itemCount; curItem++) {
            int32_t* _val = malloc(sizeof(int32_t) * 1);
            _res = plc4c_spi_read_signed_int(readBuffer, 32, (int32_t*) _val);
            if(_res != OK) {
                return _res;
            }
            plc4c_data* _item = plc4c_data_create_dint_data(*_val);
            plc4c_utils_list_insert_head_value(value, _item);
        }
        *data_item = plc4c_data_create_list_data(value);

    } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_LINT) && (numberOfValues == 1)) { /* LINT */

                // Simple Field (value)
                int64_t value = 0;
                _res = plc4c_spi_read_signed_long(readBuffer, 64, (int64_t*) &value);
                if(_res != OK) {
                    return _res;
                }

                *data_item = plc4c_data_create_lint_data(value);

    } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_LINT) { /* List */

        // Array field (value)
        // Count array
        plc4c_list* value;
        plc4c_utils_list_create(&value);
        int itemCount = (int) numberOfValues;
        for(int curItem = 0; curItem < itemCount; curItem++) {
            int64_t* _val = malloc(sizeof(int64_t) * 1);
            _res = plc4c_spi_read_signed_long(readBuffer, 64, (int64_t*) _val);
            if(_res != OK) {
                return _res;
            }
            plc4c_data* _item = plc4c_data_create_lint_data(*_val);
            plc4c_utils_list_insert_head_value(value, _item);
        }
        *data_item = plc4c_data_create_list_data(value);

    } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_USINT) && (numberOfValues == 1)) { /* USINT */

                // Reserved Field (Compartmentalized so the "reserved" variable can't leak)
                {
                    uint8_t _reserved = 0;
                    _res = plc4c_spi_read_unsigned_byte(readBuffer, 8, (uint8_t*) &_reserved);
                    if(_res != OK) {
                        return _res;
                    }
                    if(_reserved != 0x00) {
                      printf("Expected constant value '%d' but got '%d' for reserved field.", 0x00, _reserved);
                    }
                }

                // Simple Field (value)
                uint8_t value = 0;
                _res = plc4c_spi_read_unsigned_byte(readBuffer, 8, (uint8_t*) &value);
                if(_res != OK) {
                    return _res;
                }

                *data_item = plc4c_data_create_usint_data(value);

    } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_USINT) { /* List */

        // Array field (value)
        // Count array
        plc4c_list* value;
        plc4c_utils_list_create(&value);
        int itemCount = (int) numberOfValues;
        for(int curItem = 0; curItem < itemCount; curItem++) {
            uint8_t* _val = malloc(sizeof(uint8_t) * 1);
            _res = plc4c_spi_read_unsigned_byte(readBuffer, 8, (uint8_t*) _val);
            if(_res != OK) {
                return _res;
            }
            plc4c_data* _item = plc4c_data_create_usint_data(*_val);
            plc4c_utils_list_insert_head_value(value, _item);
        }
        *data_item = plc4c_data_create_list_data(value);

    } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_UINT) && (numberOfValues == 1)) { /* UINT */

                // Simple Field (value)
                uint16_t value = 0;
                _res = plc4c_spi_read_unsigned_short(readBuffer, 16, (uint16_t*) &value);
                if(_res != OK) {
                    return _res;
                }

                *data_item = plc4c_data_create_uint_data(value);

    } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_UINT) { /* List */

        // Array field (value)
        // Count array
        plc4c_list* value;
        plc4c_utils_list_create(&value);
        int itemCount = (int) numberOfValues;
        for(int curItem = 0; curItem < itemCount; curItem++) {
            uint16_t* _val = malloc(sizeof(uint16_t) * 1);
            _res = plc4c_spi_read_unsigned_short(readBuffer, 16, (uint16_t*) _val);
            if(_res != OK) {
                return _res;
            }
            plc4c_data* _item = plc4c_data_create_uint_data(*_val);
            plc4c_utils_list_insert_head_value(value, _item);
        }
        *data_item = plc4c_data_create_list_data(value);

    } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_UDINT) && (numberOfValues == 1)) { /* UDINT */

                // Simple Field (value)
                uint32_t value = 0;
                _res = plc4c_spi_read_unsigned_int(readBuffer, 32, (uint32_t*) &value);
                if(_res != OK) {
                    return _res;
                }

                *data_item = plc4c_data_create_udint_data(value);

    } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_UDINT) { /* List */

        // Array field (value)
        // Count array
        plc4c_list* value;
        plc4c_utils_list_create(&value);
        int itemCount = (int) numberOfValues;
        for(int curItem = 0; curItem < itemCount; curItem++) {
            uint32_t* _val = malloc(sizeof(uint32_t) * 1);
            _res = plc4c_spi_read_unsigned_int(readBuffer, 32, (uint32_t*) _val);
            if(_res != OK) {
                return _res;
            }
            plc4c_data* _item = plc4c_data_create_udint_data(*_val);
            plc4c_utils_list_insert_head_value(value, _item);
        }
        *data_item = plc4c_data_create_list_data(value);

    } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_ULINT) && (numberOfValues == 1)) { /* ULINT */

                // Simple Field (value)
                uint64_t value = 0;
                _res = plc4c_spi_read_unsigned_long(readBuffer, 64, (uint64_t*) &value);
                if(_res != OK) {
                    return _res;
                }

                *data_item = plc4c_data_create_ulint_data(value);

    } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_ULINT) { /* List */

        // Array field (value)
        // Count array
        plc4c_list* value;
        plc4c_utils_list_create(&value);
        int itemCount = (int) numberOfValues;
        for(int curItem = 0; curItem < itemCount; curItem++) {
            uint64_t* _val = malloc(sizeof(uint64_t) * 1);
            _res = plc4c_spi_read_unsigned_long(readBuffer, 64, (uint64_t*) _val);
            if(_res != OK) {
                return _res;
            }
            plc4c_data* _item = plc4c_data_create_ulint_data(*_val);
            plc4c_utils_list_insert_head_value(value, _item);
        }
        *data_item = plc4c_data_create_list_data(value);

    } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_REAL) && (numberOfValues == 1)) { /* REAL */

                // Simple Field (value)
                float value = 0.0f;
                _res = plc4c_spi_read_float(readBuffer, 32, (float*) &value);
                if(_res != OK) {
                    return _res;
                }

                *data_item = plc4c_data_create_real_data(value);

    } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_REAL) { /* List */

        // Array field (value)
        // Count array
        plc4c_list* value;
        plc4c_utils_list_create(&value);
        int itemCount = (int) numberOfValues;
        for(int curItem = 0; curItem < itemCount; curItem++) {
            float* _val = malloc(sizeof(float) * 1);
            _res = plc4c_spi_read_float(readBuffer, 32, (float*) _val);
            if(_res != OK) {
                return _res;
            }
            plc4c_data* _item = plc4c_data_create_real_data(*_val);
            plc4c_utils_list_insert_head_value(value, _item);
        }
        *data_item = plc4c_data_create_list_data(value);

    } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_LREAL) && (numberOfValues == 1)) { /* LREAL */

                // Simple Field (value)
                double value = 0.0f;
                _res = plc4c_spi_read_double(readBuffer, 64, (double*) &value);
                if(_res != OK) {
                    return _res;
                }

                *data_item = plc4c_data_create_lreal_data(value);

    } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_LREAL) { /* List */

        // Array field (value)
        // Count array
        plc4c_list* value;
        plc4c_utils_list_create(&value);
        int itemCount = (int) numberOfValues;
        for(int curItem = 0; curItem < itemCount; curItem++) {
            double* _val = malloc(sizeof(double) * 1);
            _res = plc4c_spi_read_double(readBuffer, 64, (double*) _val);
            if(_res != OK) {
                return _res;
            }
            plc4c_data* _item = plc4c_data_create_lreal_data(*_val);
            plc4c_utils_list_insert_head_value(value, _item);
        }
        *data_item = plc4c_data_create_list_data(value);

    } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_CHAR) && (numberOfValues == 1)) { /* CHAR */

                // Simple Field (value)
                char* value = "";
                _res = plc4c_spi_read_string(readBuffer, 8, "UTF-8", (char**) &value);
                if(_res != OK) {
                    return _res;
                }

                *data_item = plc4c_data_create_char_data(value);

    } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_CHAR) { /* List */

        // Array field (value)
        // Count array
        plc4c_list* value;
        plc4c_utils_list_create(&value);
        int itemCount = (int) numberOfValues;
        for(int curItem = 0; curItem < itemCount; curItem++) {
            char** _val = malloc(sizeof(char*) * 1);
            _res = plc4c_spi_read_string(readBuffer, 8, "UTF-8", (char**) _val);
            if(_res != OK) {
                return _res;
            }
            plc4c_data* _item = plc4c_data_create_char_data(*_val);
            plc4c_utils_list_insert_head_value(value, _item);
        }
        *data_item = plc4c_data_create_list_data(value);

    } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_WCHAR) && (numberOfValues == 1)) { /* WCHAR */

                // Simple Field (value)
                char* value = "";
                _res = plc4c_spi_read_string(readBuffer, 16, "UTF-16", (char**) &value);
                if(_res != OK) {
                    return _res;
                }

                *data_item = plc4c_data_create_wchar_data(value);

    } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_WCHAR) { /* List */

        // Array field (value)
        // Count array
        plc4c_list* value;
        plc4c_utils_list_create(&value);
        int itemCount = (int) numberOfValues;
        for(int curItem = 0; curItem < itemCount; curItem++) {
            char** _val = malloc(sizeof(char*) * 1);
            _res = plc4c_spi_read_string(readBuffer, 16, "UTF-16", (char**) _val);
            if(_res != OK) {
                return _res;
            }
            plc4c_data* _item = plc4c_data_create_char_data(*_val);
            plc4c_utils_list_insert_head_value(value, _item);
        }
        *data_item = plc4c_data_create_list_data(value);

    }

  return OK;
}

plc4c_return_code plc4c_modbus_read_write_data_item_serialize(plc4c_spi_write_buffer* writeBuffer, plc4c_modbus_read_write_modbus_data_type dataType, uint16_t numberOfValues, plc4c_data** data_item) {
  plc4c_return_code _res = OK;
        if((dataType == plc4c_modbus_read_write_modbus_data_type_BOOL) && (numberOfValues == 1)) { /* BOOL */

                    // Reserved Field (reserved)

                    // Simple field (value)
                    _res = plc4c_spi_write_bit(writeBuffer, (*data_item)->data.bool_value);
                    if(_res != OK) {
                        return _res;
                    }
        } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_BOOL) { /* List */

                    // Array field
        } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_BYTE) && (numberOfValues == 1)) { /* BYTE */

                    // Reserved Field (reserved)

                    // Simple field (value)
                    _res = plc4c_spi_write_unsigned_byte(writeBuffer, 8, (*data_item)->data.byte_value);
                    if(_res != OK) {
                        return _res;
                    }
        } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_BYTE) { /* List */

                    // Array field
        } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_WORD) { /* WORD */

                    // Simple field (value)
                    _res = plc4c_spi_write_unsigned_short(writeBuffer, 16, (*data_item)->data.word_value);
                    if(_res != OK) {
                        return _res;
                    }
        } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_DWORD) { /* DWORD */

                    // Simple field (value)
                    _res = plc4c_spi_write_unsigned_int(writeBuffer, 32, (*data_item)->data.dword_value);
                    if(_res != OK) {
                        return _res;
                    }
        } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_LWORD) { /* LWORD */

                    // Simple field (value)
                    _res = plc4c_spi_write_unsigned_long(writeBuffer, 64, (*data_item)->data.lword_value);
                    if(_res != OK) {
                        return _res;
                    }
        } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_SINT) && (numberOfValues == 1)) { /* SINT */

                    // Reserved Field (reserved)

                    // Simple field (value)
                    _res = plc4c_spi_write_signed_byte(writeBuffer, 8, (*data_item)->data.sint_value);
                    if(_res != OK) {
                        return _res;
                    }
        } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_SINT) { /* List */

                    // Array field
        } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_INT) && (numberOfValues == 1)) { /* INT */

                    // Simple field (value)
                    _res = plc4c_spi_write_signed_short(writeBuffer, 16, (*data_item)->data.int_value);
                    if(_res != OK) {
                        return _res;
                    }
        } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_INT) { /* List */

                    // Array field
        } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_DINT) && (numberOfValues == 1)) { /* DINT */

                    // Simple field (value)
                    _res = plc4c_spi_write_signed_int(writeBuffer, 32, (*data_item)->data.dint_value);
                    if(_res != OK) {
                        return _res;
                    }
        } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_DINT) { /* List */

                    // Array field
        } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_LINT) && (numberOfValues == 1)) { /* LINT */

                    // Simple field (value)
                    _res = plc4c_spi_write_signed_long(writeBuffer, 64, (*data_item)->data.lint_value);
                    if(_res != OK) {
                        return _res;
                    }
        } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_LINT) { /* List */

                    // Array field
        } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_USINT) && (numberOfValues == 1)) { /* USINT */

                    // Reserved Field (reserved)

                    // Simple field (value)
                    _res = plc4c_spi_write_unsigned_byte(writeBuffer, 8, (*data_item)->data.usint_value);
                    if(_res != OK) {
                        return _res;
                    }
        } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_USINT) { /* List */

                    // Array field
        } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_UINT) && (numberOfValues == 1)) { /* UINT */

                    // Simple field (value)
                    _res = plc4c_spi_write_unsigned_short(writeBuffer, 16, (*data_item)->data.uint_value);
                    if(_res != OK) {
                        return _res;
                    }
        } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_UINT) { /* List */

                    // Array field
        } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_UDINT) && (numberOfValues == 1)) { /* UDINT */

                    // Simple field (value)
                    _res = plc4c_spi_write_unsigned_int(writeBuffer, 32, (*data_item)->data.udint_value);
                    if(_res != OK) {
                        return _res;
                    }
        } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_UDINT) { /* List */

                    // Array field
        } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_ULINT) && (numberOfValues == 1)) { /* ULINT */

                    // Simple field (value)
                    _res = plc4c_spi_write_unsigned_long(writeBuffer, 64, (*data_item)->data.ulint_value);
                    if(_res != OK) {
                        return _res;
                    }
        } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_ULINT) { /* List */

                    // Array field
        } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_REAL) && (numberOfValues == 1)) { /* REAL */

                    // Simple field (value)
                    _res = plc4c_spi_write_float(writeBuffer, 32, (*data_item)->data.real_value);
                    if(_res != OK) {
                        return _res;
                    }
        } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_REAL) { /* List */

                    // Array field
        } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_LREAL) && (numberOfValues == 1)) { /* LREAL */

                    // Simple field (value)
                    _res = plc4c_spi_write_double(writeBuffer, 64, (*data_item)->data.lreal_value);
                    if(_res != OK) {
                        return _res;
                    }
        } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_LREAL) { /* List */

                    // Array field
        } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_CHAR) && (numberOfValues == 1)) { /* CHAR */

                    // Simple field (value)
                    _res = plc4c_spi_write_string(writeBuffer, 8, "UTF-8", (*data_item)->data.char_value);
                    if(_res != OK) {
                        return _res;
                    }
        } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_CHAR) { /* List */

                    // Array field
        } else         if((dataType == plc4c_modbus_read_write_modbus_data_type_WCHAR) && (numberOfValues == 1)) { /* WCHAR */

                    // Simple field (value)
                    _res = plc4c_spi_write_string(writeBuffer, 16, "UTF-16", (*data_item)->data.wchar_value);
                    if(_res != OK) {
                        return _res;
                    }
        } else         if(dataType == plc4c_modbus_read_write_modbus_data_type_WCHAR) { /* List */

                    // Array field
        }
  return OK;
}

uint16_t plc4c_modbus_read_write_data_item_length_in_bytes(plc4c_data* data_item, plc4c_modbus_read_write_modbus_data_type data_type, uint16_t number_of_values) {
  return plc4c_modbus_read_write_data_item_length_in_bits(data_item, data_type, number_of_values) / 8;
}

uint16_t plc4c_modbus_read_write_data_item_length_in_bits(plc4c_data* data_item, plc4c_modbus_read_write_modbus_data_type dataType, uint16_t numberOfValues) {
  uint16_t lengthInBits = 0;
    if((dataType == plc4c_modbus_read_write_modbus_data_type_BOOL) && (numberOfValues == 1)) { /* BOOL */

        // Reserved Field (reserved)
        lengthInBits += 15;

        // Simple field (value)
        lengthInBits += 1;
    } else     if(dataType == plc4c_modbus_read_write_modbus_data_type_BOOL) { /* List */

        // Array field
        lengthInBits += 1 * plc4c_utils_list_size(data_item->data.list_value);
    } else     if((dataType == plc4c_modbus_read_write_modbus_data_type_BYTE) && (numberOfValues == 1)) { /* BYTE */

        // Reserved Field (reserved)
        lengthInBits += 8;

        // Simple field (value)
        lengthInBits += 8;
    } else     if(dataType == plc4c_modbus_read_write_modbus_data_type_BYTE) { /* List */

        // Array field
        lengthInBits += 1 * plc4c_utils_list_size(data_item->data.list_value);
    } else     if(dataType == plc4c_modbus_read_write_modbus_data_type_WORD) { /* WORD */

        // Simple field (value)
        lengthInBits += 16;
    } else     if(dataType == plc4c_modbus_read_write_modbus_data_type_DWORD) { /* DWORD */

        // Simple field (value)
        lengthInBits += 32;
    } else     if(dataType == plc4c_modbus_read_write_modbus_data_type_LWORD) { /* LWORD */

        // Simple field (value)
        lengthInBits += 64;
    } else     if((dataType == plc4c_modbus_read_write_modbus_data_type_SINT) && (numberOfValues == 1)) { /* SINT */

        // Reserved Field (reserved)
        lengthInBits += 8;

        // Simple field (value)
        lengthInBits += 8;
    } else     if(dataType == plc4c_modbus_read_write_modbus_data_type_SINT) { /* List */

        // Array field
        lengthInBits += 8 * plc4c_utils_list_size(data_item->data.list_value);
    } else     if((dataType == plc4c_modbus_read_write_modbus_data_type_INT) && (numberOfValues == 1)) { /* INT */

        // Simple field (value)
        lengthInBits += 16;
    } else     if(dataType == plc4c_modbus_read_write_modbus_data_type_INT) { /* List */

        // Array field
        lengthInBits += 16 * plc4c_utils_list_size(data_item->data.list_value);
    } else     if((dataType == plc4c_modbus_read_write_modbus_data_type_DINT) && (numberOfValues == 1)) { /* DINT */

        // Simple field (value)
        lengthInBits += 32;
    } else     if(dataType == plc4c_modbus_read_write_modbus_data_type_DINT) { /* List */

        // Array field
        lengthInBits += 32 * plc4c_utils_list_size(data_item->data.list_value);
    } else     if((dataType == plc4c_modbus_read_write_modbus_data_type_LINT) && (numberOfValues == 1)) { /* LINT */

        // Simple field (value)
        lengthInBits += 64;
    } else     if(dataType == plc4c_modbus_read_write_modbus_data_type_LINT) { /* List */

        // Array field
        lengthInBits += 64 * plc4c_utils_list_size(data_item->data.list_value);
    } else     if((dataType == plc4c_modbus_read_write_modbus_data_type_USINT) && (numberOfValues == 1)) { /* USINT */

        // Reserved Field (reserved)
        lengthInBits += 8;

        // Simple field (value)
        lengthInBits += 8;
    } else     if(dataType == plc4c_modbus_read_write_modbus_data_type_USINT) { /* List */

        // Array field
        lengthInBits += 8 * plc4c_utils_list_size(data_item->data.list_value);
    } else     if((dataType == plc4c_modbus_read_write_modbus_data_type_UINT) && (numberOfValues == 1)) { /* UINT */

        // Simple field (value)
        lengthInBits += 16;
    } else     if(dataType == plc4c_modbus_read_write_modbus_data_type_UINT) { /* List */

        // Array field
        lengthInBits += 16 * plc4c_utils_list_size(data_item->data.list_value);
    } else     if((dataType == plc4c_modbus_read_write_modbus_data_type_UDINT) && (numberOfValues == 1)) { /* UDINT */

        // Simple field (value)
        lengthInBits += 32;
    } else     if(dataType == plc4c_modbus_read_write_modbus_data_type_UDINT) { /* List */

        // Array field
        lengthInBits += 32 * plc4c_utils_list_size(data_item->data.list_value);
    } else     if((dataType == plc4c_modbus_read_write_modbus_data_type_ULINT) && (numberOfValues == 1)) { /* ULINT */

        // Simple field (value)
        lengthInBits += 64;
    } else     if(dataType == plc4c_modbus_read_write_modbus_data_type_ULINT) { /* List */

        // Array field
        lengthInBits += 64 * plc4c_utils_list_size(data_item->data.list_value);
    } else     if((dataType == plc4c_modbus_read_write_modbus_data_type_REAL) && (numberOfValues == 1)) { /* REAL */

        // Simple field (value)
        lengthInBits += 32;
    } else     if(dataType == plc4c_modbus_read_write_modbus_data_type_REAL) { /* List */

        // Array field
        lengthInBits += 32 * plc4c_utils_list_size(data_item->data.list_value);
    } else     if((dataType == plc4c_modbus_read_write_modbus_data_type_LREAL) && (numberOfValues == 1)) { /* LREAL */

        // Simple field (value)
        lengthInBits += 64;
    } else     if(dataType == plc4c_modbus_read_write_modbus_data_type_LREAL) { /* List */

        // Array field
        lengthInBits += 64 * plc4c_utils_list_size(data_item->data.list_value);
    } else     if((dataType == plc4c_modbus_read_write_modbus_data_type_CHAR) && (numberOfValues == 1)) { /* CHAR */

        // Simple field (value)
        lengthInBits += 8;
    } else     if(dataType == plc4c_modbus_read_write_modbus_data_type_CHAR) { /* List */

        // Array field
        lengthInBits += 8 * plc4c_utils_list_size(data_item->data.list_value);
    } else     if((dataType == plc4c_modbus_read_write_modbus_data_type_WCHAR) && (numberOfValues == 1)) { /* WCHAR */

        // Simple field (value)
        lengthInBits += 16;
    } else     if(dataType == plc4c_modbus_read_write_modbus_data_type_WCHAR) { /* List */

        // Array field
        lengthInBits += 16 * plc4c_utils_list_size(data_item->data.list_value);
    }
  return lengthInBits;
}

