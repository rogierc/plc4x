#
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
#
import time

import pytest

from plc4py.PlcDriverManager import PlcDriverManager
from plc4py.api.value.PlcValue import PlcResponseCode
import logging

logger = logging.getLogger("testing")


@pytest.mark.asyncio
async def manual_test_plc_driver_modbus_connect():
    driver_manager = PlcDriverManager()
    async with driver_manager.connection("modbus://127.0.0.1:5555") as connection:
        assert connection.is_connected()
    assert not connection.is_connected()


@pytest.mark.asyncio
async def manual_test_plc_driver_modbus_read():
    driver_manager = PlcDriverManager()
    async with driver_manager.connection("modbus://192.168.1.177:502") as connection:
        with connection.read_request_builder() as builder:
            builder.add_item("Random Tag", "4x00001[10]")
            request = builder.build()

        future = connection.execute(request)
        await future
        response = future.result()

        for tag_name in response.tag_names:
            if response.tags[tag_name].response_code == PlcResponseCode.OK:
                num_values: int = len(response.tags[tag_name].value)
                # If it's just one element, output just one single line.
                if num_values == 1:
                    logger.info(
                        "Value[" + tag_name + "]: " + response.tags[tag_name].value
                    )

                # If it's more than one element, output each in a single row.
                else:
                    logger.info("Value[" + tag_name + "]:")
                    for i in response.tags[tag_name].value.get_list():
                        logger.info(" - " + str(i))

            # Something went wrong, to output an error message instead.
            else:
                logger.error(
                    "Error[" + tag_name + "]: " + response.tags[tag_name].name()
                )
    pass
