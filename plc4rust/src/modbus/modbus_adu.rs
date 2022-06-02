use std::io::{Error, Read, Write};
use std::io::ErrorKind::InvalidInput;
use crate::{Message, ReadBuffer, WriteBuffer};
use crate::modbus::{DriverType, ModbusPDU};

// [discriminatedType ModbusADU(DriverType driverType, bit response) byteOrder='BIG_ENDIAN'
//     [typeSwitch driverType
//         ['MODBUS_TCP' ModbusTcpADU
//             // It is used for transaction pairing, the MODBUS server copies in the response the transaction
//             // identifier of the request.
//             [simple         uint 16     transactionIdentifier]
//
//             // It is used for intra-system multiplexing. The MODBUS protocol is identified by the value 0.
//             [const          uint 16     protocolIdentifier    0x0000]
//
//             // The length field is a byte count of the following fields, including the Unit Identifier and
//             // data fields.
//             [implicit       uint 16     length                'pdu.lengthInBytes + 1']
//
//             // This field is used for intra-system routing purpose. It is typically used to communicate to
//             // a MODBUS+ or a MODBUS serial line slave through a gateway between an Ethernet TCP-IP network
//             // and a MODBUS serial line. This field is set by the MODBUS Client in the request and must be
//             // returned with the same value in the response by the server.
//             [simple         uint 8      unitIdentifier]
//
//             // The actual modbus payload
//             [simple         ModbusPDU('response')   pdu]
//         ]
//         ['MODBUS_RTU' ModbusRtuADU
//             [simple         uint 8                  address]
//
//             // The actual modbus payload
//             [simple         ModbusPDU('response')   pdu    ]
//
//             [checksum       uint 16                 crc     'STATIC_CALL("rtuCrcCheck", address, pdu)']
//         ]
//         ['MODBUS_ASCII' ModbusAsciiADU
//             [simple         uint 8                  address]
//
//             // The actual modbus payload
//             [simple         ModbusPDU('response')   pdu    ]
//
//             [checksum       uint 8                  crc     'STATIC_CALL("asciiLrcCheck", address, pdu)']
//         ]
//     ]
// ]
pub enum ModbusADU {
    ModbusTcpADU(ModbusTcpADU),
    ModbusRtuADU(ModbusRtuADU),
}

impl ModbusADU {

    fn deserialize_special<T: Read>(reader: &mut ReadBuffer<T>, driver_type: DriverType, bit_response: bool) -> Result<ModbusADU, Error> {
        match driver_type {
            DriverType::MODBUS_TCP => {
                Ok(ModbusADU::ModbusTcpADU(ModbusTcpADU::deserialize(reader)?))
            }
            DriverType::MODBUS_RTU => {
                Ok(ModbusADU::ModbusRtuADU(ModbusRtuADU::deserialize(reader)?))
            }
            _ => {
                Err(Error::new(InvalidInput, format!("Unable to deserialize from {:?}, {:?}", driver_type, bit_response)))
            }
        }
    }

}

impl Message for ModbusADU {
    type M = ModbusADU;

    fn get_length(&self) -> u32 {
        todo!()
    }

    fn serialize<T: Write>(&self, writer: &mut WriteBuffer<T>) -> Result<usize, Error> {
        todo!()
    }

    fn deserialize<T: Read>(reader: &mut ReadBuffer<T>) -> Result<Self::M, Error> {
        Err(Error::new(InvalidInput, "Cannot parse directly!"))
    }
}

pub struct ModbusTcpADU {
    transaction_identifier: u16,
    protocol_identifier: u16,
    unit_identifier: u8,
    pdu: ModbusPDU
}

impl ModbusTcpADU {
    fn length(&self) -> u16 {
        return (self.pdu.get_length() + 1) as u16
    }
}

impl Message for ModbusTcpADU {
    type M = ModbusTcpADU;

    fn get_length(&self) -> u32 {
        todo!()
    }

    fn serialize<T: Write>(&self, writer: &mut WriteBuffer<T>) -> Result<usize, Error> {
        todo!()
    }

    fn deserialize<T: Read>(reader: &mut ReadBuffer<T>) -> Result<Self::M, Error> {
        todo!()
    }
}

pub struct ModbusRtuADU {

}

impl Message for ModbusRtuADU {
    type M = ModbusRtuADU;

    fn get_length(&self) -> u32 {
        todo!()
    }

    fn serialize<T: Write>(&self, writer: &mut WriteBuffer<T>) -> Result<usize, Error> {
        todo!()
    }

    fn deserialize<T: Read>(reader: &mut ReadBuffer<T>) -> Result<Self::M, Error> {
        todo!()
    }
}