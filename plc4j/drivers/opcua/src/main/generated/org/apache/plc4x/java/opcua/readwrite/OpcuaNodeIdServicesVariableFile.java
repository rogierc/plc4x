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
package org.apache.plc4x.java.opcua.readwrite;

import java.util.HashMap;
import java.util.Map;

// Code generated by code-generation. DO NOT EDIT.

public enum OpcuaNodeIdServicesVariableFile {
  FileType_Size((int) 11576L),
  FileType_OpenCount((int) 11579L),
  FileType_Open_InputArguments((int) 11581L),
  FileType_Open_OutputArguments((int) 11582L),
  FileType_Close_InputArguments((int) 11584L),
  FileType_Read_InputArguments((int) 11586L),
  FileType_Read_OutputArguments((int) 11587L),
  FileType_Write_InputArguments((int) 11589L),
  FileType_GetPosition_InputArguments((int) 11591L),
  FileType_GetPosition_OutputArguments((int) 11592L),
  FileType_SetPosition_InputArguments((int) 11594L),
  FileType_Writable((int) 12686L),
  FileType_UserWritable((int) 12687L),
  FileType_MimeType((int) 13341L),
  FileDirectoryType_FileDirectoryName_Placeholder_CreateDirectory_InputArguments((int) 13356L),
  FileDirectoryType_FileDirectoryName_Placeholder_CreateDirectory_OutputArguments((int) 13357L),
  FileDirectoryType_FileDirectoryName_Placeholder_CreateFile_InputArguments((int) 13359L),
  FileDirectoryType_FileDirectoryName_Placeholder_CreateFile_OutputArguments((int) 13360L),
  FileDirectoryType_FileDirectoryName_Placeholder_MoveOrCopy_InputArguments((int) 13364L),
  FileDirectoryType_FileDirectoryName_Placeholder_MoveOrCopy_OutputArguments((int) 13365L),
  FileDirectoryType_FileName_Placeholder_Size((int) 13367L),
  FileDirectoryType_FileName_Placeholder_Writable((int) 13368L),
  FileDirectoryType_FileName_Placeholder_UserWritable((int) 13369L),
  FileDirectoryType_FileName_Placeholder_OpenCount((int) 13370L),
  FileDirectoryType_FileName_Placeholder_MimeType((int) 13371L),
  FileDirectoryType_FileName_Placeholder_Open_InputArguments((int) 13373L),
  FileDirectoryType_FileName_Placeholder_Open_OutputArguments((int) 13374L),
  FileDirectoryType_FileName_Placeholder_Close_InputArguments((int) 13376L),
  FileDirectoryType_FileName_Placeholder_Read_InputArguments((int) 13378L),
  FileDirectoryType_FileName_Placeholder_Read_OutputArguments((int) 13379L),
  FileDirectoryType_FileName_Placeholder_Write_InputArguments((int) 13381L),
  FileDirectoryType_FileName_Placeholder_GetPosition_InputArguments((int) 13383L),
  FileDirectoryType_FileName_Placeholder_GetPosition_OutputArguments((int) 13384L),
  FileDirectoryType_FileName_Placeholder_SetPosition_InputArguments((int) 13386L),
  FileDirectoryType_CreateDirectory_InputArguments((int) 13388L),
  FileDirectoryType_CreateDirectory_OutputArguments((int) 13389L),
  FileDirectoryType_CreateFile_InputArguments((int) 13391L),
  FileDirectoryType_CreateFile_OutputArguments((int) 13392L),
  FileDirectoryType_DeleteFileSystemObject_InputArguments((int) 13394L),
  FileDirectoryType_MoveOrCopy_InputArguments((int) 13396L),
  FileDirectoryType_MoveOrCopy_OutputArguments((int) 13397L),
  FileTransferStateMachineType_Idle_StateNumber((int) 15816L),
  FileTransferStateMachineType_ReadPrepare_StateNumber((int) 15818L),
  FileTransferStateMachineType_ReadTransfer_StateNumber((int) 15820L),
  FileTransferStateMachineType_ApplyWrite_StateNumber((int) 15822L),
  FileTransferStateMachineType_Error_StateNumber((int) 15824L),
  FileTransferStateMachineType_IdleToReadPrepare_TransitionNumber((int) 15826L),
  FileTransferStateMachineType_ReadPrepareToReadTransfer_TransitionNumber((int) 15828L),
  FileTransferStateMachineType_ReadTransferToIdle_TransitionNumber((int) 15830L),
  FileTransferStateMachineType_IdleToApplyWrite_TransitionNumber((int) 15832L),
  FileTransferStateMachineType_ApplyWriteToIdle_TransitionNumber((int) 15834L),
  FileTransferStateMachineType_ReadPrepareToError_TransitionNumber((int) 15836L),
  FileTransferStateMachineType_ReadTransferToError_TransitionNumber((int) 15838L),
  FileTransferStateMachineType_ApplyWriteToError_TransitionNumber((int) 15840L),
  FileTransferStateMachineType_ErrorToIdle_TransitionNumber((int) 15842L),
  FileSystem_CreateDirectory_InputArguments((int) 16349L),
  FileSystem_CreateDirectory_OutputArguments((int) 16350L),
  FileSystem_CreateFile_InputArguments((int) 16352L),
  FileSystem_CreateFile_OutputArguments((int) 16353L),
  FileSystem_DeleteFileSystemObject_InputArguments((int) 16355L),
  FileSystem_MoveOrCopy_InputArguments((int) 16357L),
  FileSystem_MoveOrCopy_OutputArguments((int) 16358L),
  FileDirectoryType_FileDirectoryName_Placeholder_DeleteFileSystemObject_InputArguments(
      (int) 17719L),
  FileType_MaxByteStringLength((int) 24244L),
  FileDirectoryType_FileName_Placeholder_MaxByteStringLength((int) 24248L),
  FileType_LastModifiedTime((int) 25200L),
  FileDirectoryType_FileName_Placeholder_LastModifiedTime((int) 25204L);
  private static final Map<Integer, OpcuaNodeIdServicesVariableFile> map;

  static {
    map = new HashMap<>();
    for (OpcuaNodeIdServicesVariableFile value : OpcuaNodeIdServicesVariableFile.values()) {
      map.put((int) value.getValue(), value);
    }
  }

  private final int value;

  OpcuaNodeIdServicesVariableFile(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static OpcuaNodeIdServicesVariableFile enumForValue(int value) {
    return map.get(value);
  }

  public static Boolean isDefined(int value) {
    return map.containsKey(value);
  }
}
