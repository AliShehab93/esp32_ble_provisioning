// DO NOT EDIT.
//
// Generated by the Swift generator plugin for the protocol buffer compiler.
// Source: sec0.proto
//
// For information on using the generated types, please see the documentation:
//   https://github.com/apple/swift-protobuf/

// Copyright 2020 Espressif Systems
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import Foundation
import SwiftProtobuf

// If the compiler emits an error on this type, it is because this file
// was generated by a version of the `protoc` Swift plug-in that is
// incompatible with the version of SwiftProtobuf to which you are linking.
// Please ensure that your are building against the same version of the API
// that was used to generate this file.
private struct _GeneratedWithProtocGenSwiftVersion: SwiftProtobuf.ProtobufAPIVersionCheck {
    struct _2: SwiftProtobuf.ProtobufAPIVersion_2 {}
    typealias Version = _2
}

enum Espressif_Sec0MsgType: SwiftProtobuf.Enum {
    typealias RawValue = Int
    case s0SessionCommand // = 0
    case s0SessionResponse // = 1
    case UNRECOGNIZED(Int)

    init() {
        self = .s0SessionCommand
    }

    init?(rawValue: Int) {
        switch rawValue {
        case 0: self = .s0SessionCommand
        case 1: self = .s0SessionResponse
        default: self = .UNRECOGNIZED(rawValue)
        }
    }

    var rawValue: Int {
        switch self {
        case .s0SessionCommand: return 0
        case .s0SessionResponse: return 1
        case let .UNRECOGNIZED(i): return i
        }
    }
}

#if swift(>=4.2)

    extension Espressif_Sec0MsgType: CaseIterable {
        // The compiler won't synthesize support with the UNRECOGNIZED case.
        static var allCases: [Espressif_Sec0MsgType] = [
            .s0SessionCommand,
            .s0SessionResponse,
        ]
    }

#endif // swift(>=4.2)

struct Espressif_S0SessionCmd {
    // SwiftProtobuf.Message conformance is added in an extension below. See the
    // `Message` and `Message+*Additions` files in the SwiftProtobuf library for
    // methods supported on all messages.

    var unknownFields = SwiftProtobuf.UnknownStorage()

    init() {}
}

struct Espressif_S0SessionResp {
    // SwiftProtobuf.Message conformance is added in an extension below. See the
    // `Message` and `Message+*Additions` files in the SwiftProtobuf library for
    // methods supported on all messages.

    var status: Espressif_Status = .success

    var unknownFields = SwiftProtobuf.UnknownStorage()

    init() {}
}

struct Espressif_Sec0Payload {
    // SwiftProtobuf.Message conformance is added in an extension below. See the
    // `Message` and `Message+*Additions` files in the SwiftProtobuf library for
    // methods supported on all messages.

    var msg: Espressif_Sec0MsgType {
        get { return _storage._msg }
        set { _uniqueStorage()._msg = newValue }
    }

    var payload: OneOf_Payload? {
        get { return _storage._payload }
        set { _uniqueStorage()._payload = newValue }
    }

    var sc: Espressif_S0SessionCmd {
        get {
            if case let .sc(v)? = _storage._payload { return v }
            return Espressif_S0SessionCmd()
        }
        set { _uniqueStorage()._payload = .sc(newValue) }
    }

    var sr: Espressif_S0SessionResp {
        get {
            if case let .sr(v)? = _storage._payload { return v }
            return Espressif_S0SessionResp()
        }
        set { _uniqueStorage()._payload = .sr(newValue) }
    }

    var unknownFields = SwiftProtobuf.UnknownStorage()

    enum OneOf_Payload: Equatable {
        case sc(Espressif_S0SessionCmd)
        case sr(Espressif_S0SessionResp)

        #if !swift(>=4.1)
            static func == (lhs: Espressif_Sec0Payload.OneOf_Payload, rhs: Espressif_Sec0Payload.OneOf_Payload) -> Bool {
                switch (lhs, rhs) {
                case let (.sc(l), .sc(r)): return l == r
                case let (.sr(l), .sr(r)): return l == r
                default: return false
                }
            }
        #endif
    }

    init() {}

    fileprivate var _storage = _StorageClass.defaultInstance
}

// MARK: - Code below here is support for the SwiftProtobuf runtime.

private let _protobuf_package = "espressif"

extension Espressif_Sec0MsgType: SwiftProtobuf._ProtoNameProviding {
    static let _protobuf_nameMap: SwiftProtobuf._NameMap = [
        0: .same(proto: "S0_Session_Command"),
        1: .same(proto: "S0_Session_Response"),
    ]
}

extension Espressif_S0SessionCmd: SwiftProtobuf.Message, SwiftProtobuf._MessageImplementationBase, SwiftProtobuf._ProtoNameProviding {
    static let protoMessageName: String = _protobuf_package + ".S0SessionCmd"
    static let _protobuf_nameMap = SwiftProtobuf._NameMap()

    mutating func decodeMessage<D: SwiftProtobuf.Decoder>(decoder: inout D) throws {
        while let _ = try decoder.nextFieldNumber() {}
    }

    func traverse<V: SwiftProtobuf.Visitor>(visitor: inout V) throws {
        try unknownFields.traverse(visitor: &visitor)
    }

    static func == (lhs: Espressif_S0SessionCmd, rhs: Espressif_S0SessionCmd) -> Bool {
        if lhs.unknownFields != rhs.unknownFields { return false }
        return true
    }
}

extension Espressif_S0SessionResp: SwiftProtobuf.Message, SwiftProtobuf._MessageImplementationBase, SwiftProtobuf._ProtoNameProviding {
    static let protoMessageName: String = _protobuf_package + ".S0SessionResp"
    static let _protobuf_nameMap: SwiftProtobuf._NameMap = [
        1: .same(proto: "status"),
    ]

    mutating func decodeMessage<D: SwiftProtobuf.Decoder>(decoder: inout D) throws {
        while let fieldNumber = try decoder.nextFieldNumber() {
            switch fieldNumber {
            case 1: try decoder.decodeSingularEnumField(value: &status)
            default: break
            }
        }
    }

    func traverse<V: SwiftProtobuf.Visitor>(visitor: inout V) throws {
        if status != .success {
            try visitor.visitSingularEnumField(value: status, fieldNumber: 1)
        }
        try unknownFields.traverse(visitor: &visitor)
    }

    static func == (lhs: Espressif_S0SessionResp, rhs: Espressif_S0SessionResp) -> Bool {
        if lhs.status != rhs.status { return false }
        if lhs.unknownFields != rhs.unknownFields { return false }
        return true
    }
}

extension Espressif_Sec0Payload: SwiftProtobuf.Message, SwiftProtobuf._MessageImplementationBase, SwiftProtobuf._ProtoNameProviding {
    static let protoMessageName: String = _protobuf_package + ".Sec0Payload"
    static let _protobuf_nameMap: SwiftProtobuf._NameMap = [
        1: .same(proto: "msg"),
        20: .same(proto: "sc"),
        21: .same(proto: "sr"),
    ]

    fileprivate class _StorageClass {
        var _msg: Espressif_Sec0MsgType = .s0SessionCommand
        var _payload: Espressif_Sec0Payload.OneOf_Payload?

        static let defaultInstance = _StorageClass()

        private init() {}

        init(copying source: _StorageClass) {
            _msg = source._msg
            _payload = source._payload
        }
    }

    fileprivate mutating func _uniqueStorage() -> _StorageClass {
        if !isKnownUniquelyReferenced(&_storage) {
            _storage = _StorageClass(copying: _storage)
        }
        return _storage
    }

    mutating func decodeMessage<D: SwiftProtobuf.Decoder>(decoder: inout D) throws {
        _ = _uniqueStorage()
        try withExtendedLifetime(_storage) { (_storage: _StorageClass) in
            while let fieldNumber = try decoder.nextFieldNumber() {
                switch fieldNumber {
                case 1: try decoder.decodeSingularEnumField(value: &_storage._msg)
                case 20:
                    var v: Espressif_S0SessionCmd?
                    if let current = _storage._payload {
                        try decoder.handleConflictingOneOf()
                        if case let .sc(m) = current { v = m }
                    }
                    try decoder.decodeSingularMessageField(value: &v)
                    if let v = v { _storage._payload = .sc(v) }
                case 21:
                    var v: Espressif_S0SessionResp?
                    if let current = _storage._payload {
                        try decoder.handleConflictingOneOf()
                        if case let .sr(m) = current { v = m }
                    }
                    try decoder.decodeSingularMessageField(value: &v)
                    if let v = v { _storage._payload = .sr(v) }
                default: break
                }
            }
        }
    }

    func traverse<V: SwiftProtobuf.Visitor>(visitor: inout V) throws {
        try withExtendedLifetime(_storage) { (_storage: _StorageClass) in
            if _storage._msg != .s0SessionCommand {
                try visitor.visitSingularEnumField(value: _storage._msg, fieldNumber: 1)
            }
            switch _storage._payload {
            case let .sc(v)?:
                try visitor.visitSingularMessageField(value: v, fieldNumber: 20)
            case let .sr(v)?:
                try visitor.visitSingularMessageField(value: v, fieldNumber: 21)
            case nil: break
            }
        }
        try unknownFields.traverse(visitor: &visitor)
    }

    static func == (lhs: Espressif_Sec0Payload, rhs: Espressif_Sec0Payload) -> Bool {
        if lhs._storage !== rhs._storage {
            let storagesAreEqual: Bool = withExtendedLifetime((lhs._storage, rhs._storage)) { (_args: (_StorageClass, _StorageClass)) in
                let _storage = _args.0
                let rhs_storage = _args.1
                if _storage._msg != rhs_storage._msg { return false }
                if _storage._payload != rhs_storage._payload { return false }
                return true
            }
            if !storagesAreEqual { return false }
        }
        if lhs.unknownFields != rhs.unknownFields { return false }
        return true
    }
}
