// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: sec0.proto

package com.ash93.esp32_ble_provisioning_plugin.ESPProvision.espressif;

public final class Sec0 {
  private Sec0() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }
  /**
   * Protobuf enum {@code Sec0MsgType}
   */
  public enum Sec0MsgType
      implements com.google.protobuf.Internal.EnumLite {
    /**
     * <code>S0_Session_Command = 0;</code>
     */
    S0_Session_Command(0),
    /**
     * <code>S0_Session_Response = 1;</code>
     */
    S0_Session_Response(1),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>S0_Session_Command = 0;</code>
     */
    public static final int S0_Session_Command_VALUE = 0;
    /**
     * <code>S0_Session_Response = 1;</code>
     */
    public static final int S0_Session_Response_VALUE = 1;


    @Override
    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @Deprecated
    public static Sec0MsgType valueOf(int value) {
      return forNumber(value);
    }

    public static Sec0MsgType forNumber(int value) {
      switch (value) {
        case 0: return S0_Session_Command;
        case 1: return S0_Session_Response;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<Sec0MsgType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        Sec0MsgType> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<Sec0MsgType>() {
            @Override
            public Sec0MsgType findValueByNumber(int number) {
              return Sec0MsgType.forNumber(number);
            }
          };

    public static com.google.protobuf.Internal.EnumVerifier
        internalGetVerifier() {
      return Sec0MsgTypeVerifier.INSTANCE;
    }

    private static final class Sec0MsgTypeVerifier implements
         com.google.protobuf.Internal.EnumVerifier {
            static final com.google.protobuf.Internal.EnumVerifier           INSTANCE = new Sec0MsgTypeVerifier();
            @Override
            public boolean isInRange(int number) {
              return Sec0MsgType.forNumber(number) != null;
            }
          };

    private final int value;

    private Sec0MsgType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:Sec0MsgType)
  }

  public interface S0SessionCmdOrBuilder extends
      // @@protoc_insertion_point(interface_extends:S0SessionCmd)
      com.google.protobuf.MessageLiteOrBuilder {
  }
  /**
   * Protobuf type {@code S0SessionCmd}
   */
  public  static final class S0SessionCmd extends
      com.google.protobuf.GeneratedMessageLite<
          S0SessionCmd, S0SessionCmd.Builder> implements
      // @@protoc_insertion_point(message_implements:S0SessionCmd)
      S0SessionCmdOrBuilder {
    private S0SessionCmd() {
    }
    public static Sec0.S0SessionCmd parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static Sec0.S0SessionCmd parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static Sec0.S0SessionCmd parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static Sec0.S0SessionCmd parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static Sec0.S0SessionCmd parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static Sec0.S0SessionCmd parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static Sec0.S0SessionCmd parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static Sec0.S0SessionCmd parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static Sec0.S0SessionCmd parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }
    public static Sec0.S0SessionCmd parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static Sec0.S0SessionCmd parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static Sec0.S0SessionCmd parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
      return (Builder) DEFAULT_INSTANCE.createBuilder();
    }
    public static Builder newBuilder(Sec0.S0SessionCmd prototype) {
      return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    /**
     * Protobuf type {@code S0SessionCmd}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.Builder<
          Sec0.S0SessionCmd, Builder> implements
        // @@protoc_insertion_point(builder_implements:S0SessionCmd)
        Sec0.S0SessionCmdOrBuilder {
      // Construct using Sec0.S0SessionCmd.newBuilder()
      private Builder() {
        super(DEFAULT_INSTANCE);
      }


      // @@protoc_insertion_point(builder_scope:S0SessionCmd)
    }
    @Override
    @SuppressWarnings({"unchecked", "fallthrough"})
    protected final Object dynamicMethod(
        MethodToInvoke method,
        Object arg0, Object arg1) {
      switch (method) {
        case NEW_MUTABLE_INSTANCE: {
          return new Sec0.S0SessionCmd();
        }
        case NEW_BUILDER: {
          return new Builder();
        }
        case BUILD_MESSAGE_INFO: {
            Object[] objects = null;
            String info =
                "\u0000\u0000";
            return newMessageInfo(DEFAULT_INSTANCE, info, objects);
        }
        // fall through
        case GET_DEFAULT_INSTANCE: {
          return DEFAULT_INSTANCE;
        }
        case GET_PARSER: {
          com.google.protobuf.Parser<Sec0.S0SessionCmd> parser = PARSER;
          if (parser == null) {
            synchronized (Sec0.S0SessionCmd.class) {
              parser = PARSER;
              if (parser == null) {
                parser = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                PARSER = parser;
              }
            }
          }
          return parser;
      }
      case GET_MEMOIZED_IS_INITIALIZED: {
        return (byte) 1;
      }
      case SET_MEMOIZED_IS_INITIALIZED: {
        return null;
      }
      }
      throw new UnsupportedOperationException();
    }


    // @@protoc_insertion_point(class_scope:S0SessionCmd)
    private static final Sec0.S0SessionCmd DEFAULT_INSTANCE;
    static {
      // New instances are implicitly immutable so no need to make
      // immutable.
      DEFAULT_INSTANCE = new S0SessionCmd();
    }

    static {
      com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
        S0SessionCmd.class, DEFAULT_INSTANCE);
    }
    public static Sec0.S0SessionCmd getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static volatile com.google.protobuf.Parser<S0SessionCmd> PARSER;

    public static com.google.protobuf.Parser<S0SessionCmd> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
  }

  public interface S0SessionRespOrBuilder extends
      // @@protoc_insertion_point(interface_extends:S0SessionResp)
      com.google.protobuf.MessageLiteOrBuilder {

    /**
     * <code>.Status status = 1;</code>
     */
    int getStatusValue();
    /**
     * <code>.Status status = 1;</code>
     */
    Constants.Status getStatus();
  }
  /**
   * Protobuf type {@code S0SessionResp}
   */
  public  static final class S0SessionResp extends
      com.google.protobuf.GeneratedMessageLite<
          S0SessionResp, S0SessionResp.Builder> implements
      // @@protoc_insertion_point(message_implements:S0SessionResp)
      S0SessionRespOrBuilder {
    private S0SessionResp() {
    }
    public static final int STATUS_FIELD_NUMBER = 1;
    private int status_;
    /**
     * <code>.Status status = 1;</code>
     */
    @Override
    public int getStatusValue() {
      return status_;
    }
    /**
     * <code>.Status status = 1;</code>
     */
    @Override
    public Constants.Status getStatus() {
      Constants.Status result = Constants.Status.forNumber(status_);
      return result == null ? Constants.Status.UNRECOGNIZED : result;
    }
    /**
     * <code>.Status status = 1;</code>
     */
    private void setStatusValue(int value) {
        status_ = value;
    }
    /**
     * <code>.Status status = 1;</code>
     */
    private void setStatus(Constants.Status value) {
      if (value == null) {
        throw new NullPointerException();
      }

      status_ = value.getNumber();
    }
    /**
     * <code>.Status status = 1;</code>
     */
    private void clearStatus() {

      status_ = 0;
    }

    public static Sec0.S0SessionResp parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static Sec0.S0SessionResp parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static Sec0.S0SessionResp parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static Sec0.S0SessionResp parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static Sec0.S0SessionResp parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static Sec0.S0SessionResp parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static Sec0.S0SessionResp parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static Sec0.S0SessionResp parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static Sec0.S0SessionResp parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }
    public static Sec0.S0SessionResp parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static Sec0.S0SessionResp parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static Sec0.S0SessionResp parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
      return (Builder) DEFAULT_INSTANCE.createBuilder();
    }
    public static Builder newBuilder(Sec0.S0SessionResp prototype) {
      return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    /**
     * Protobuf type {@code S0SessionResp}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.Builder<
          Sec0.S0SessionResp, Builder> implements
        // @@protoc_insertion_point(builder_implements:S0SessionResp)
        Sec0.S0SessionRespOrBuilder {
      // Construct using Sec0.S0SessionResp.newBuilder()
      private Builder() {
        super(DEFAULT_INSTANCE);
      }


      /**
       * <code>.Status status = 1;</code>
       */
      @Override
      public int getStatusValue() {
        return instance.getStatusValue();
      }
      /**
       * <code>.Status status = 1;</code>
       */
      public Builder setStatusValue(int value) {
        copyOnWrite();
        instance.setStatusValue(value);
        return this;
      }
      /**
       * <code>.Status status = 1;</code>
       */
      @Override
      public Constants.Status getStatus() {
        return instance.getStatus();
      }
      /**
       * <code>.Status status = 1;</code>
       */
      public Builder setStatus(Constants.Status value) {
        copyOnWrite();
        instance.setStatus(value);
        return this;
      }
      /**
       * <code>.Status status = 1;</code>
       */
      public Builder clearStatus() {
        copyOnWrite();
        instance.clearStatus();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:S0SessionResp)
    }
    @Override
    @SuppressWarnings({"unchecked", "fallthrough"})
    protected final Object dynamicMethod(
        MethodToInvoke method,
        Object arg0, Object arg1) {
      switch (method) {
        case NEW_MUTABLE_INSTANCE: {
          return new Sec0.S0SessionResp();
        }
        case NEW_BUILDER: {
          return new Builder();
        }
        case BUILD_MESSAGE_INFO: {
            Object[] objects = new Object[] {
              "status_",
            };
            String info =
                "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f";
            return newMessageInfo(DEFAULT_INSTANCE, info, objects);
        }
        // fall through
        case GET_DEFAULT_INSTANCE: {
          return DEFAULT_INSTANCE;
        }
        case GET_PARSER: {
          com.google.protobuf.Parser<Sec0.S0SessionResp> parser = PARSER;
          if (parser == null) {
            synchronized (Sec0.S0SessionResp.class) {
              parser = PARSER;
              if (parser == null) {
                parser = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                PARSER = parser;
              }
            }
          }
          return parser;
      }
      case GET_MEMOIZED_IS_INITIALIZED: {
        return (byte) 1;
      }
      case SET_MEMOIZED_IS_INITIALIZED: {
        return null;
      }
      }
      throw new UnsupportedOperationException();
    }


    // @@protoc_insertion_point(class_scope:S0SessionResp)
    private static final Sec0.S0SessionResp DEFAULT_INSTANCE;
    static {
      // New instances are implicitly immutable so no need to make
      // immutable.
      DEFAULT_INSTANCE = new S0SessionResp();
    }

    static {
      com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
        S0SessionResp.class, DEFAULT_INSTANCE);
    }
    public static Sec0.S0SessionResp getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static volatile com.google.protobuf.Parser<S0SessionResp> PARSER;

    public static com.google.protobuf.Parser<S0SessionResp> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
  }

  public interface Sec0PayloadOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Sec0Payload)
      com.google.protobuf.MessageLiteOrBuilder {

    /**
     * <code>.Sec0MsgType msg = 1;</code>
     */
    int getMsgValue();
    /**
     * <code>.Sec0MsgType msg = 1;</code>
     */
    Sec0.Sec0MsgType getMsg();

    /**
     * <code>.S0SessionCmd sc = 20;</code>
     */
    boolean hasSc();
    /**
     * <code>.S0SessionCmd sc = 20;</code>
     */
    Sec0.S0SessionCmd getSc();

    /**
     * <code>.S0SessionResp sr = 21;</code>
     */
    boolean hasSr();
    /**
     * <code>.S0SessionResp sr = 21;</code>
     */
    Sec0.S0SessionResp getSr();

    public Sec0.Sec0Payload.PayloadCase getPayloadCase();
  }
  /**
   * Protobuf type {@code Sec0Payload}
   */
  public  static final class Sec0Payload extends
      com.google.protobuf.GeneratedMessageLite<
          Sec0Payload, Sec0Payload.Builder> implements
      // @@protoc_insertion_point(message_implements:Sec0Payload)
      Sec0PayloadOrBuilder {
    private Sec0Payload() {
    }
    private int payloadCase_ = 0;
    private Object payload_;
    public enum PayloadCase
        implements com.google.protobuf.Internal.EnumLite {
      SC(20),
      SR(21),
      PAYLOAD_NOT_SET(0);
      private final int value;
      private PayloadCase(int value) {
        this.value = value;
      }
      /**
       * @deprecated Use {@link #forNumber(int)} instead.
       */
      @Deprecated
      public static PayloadCase valueOf(int value) {
        return forNumber(value);
      }

      public static PayloadCase forNumber(int value) {
        switch (value) {
          case 20: return SC;
          case 21: return SR;
          case 0: return PAYLOAD_NOT_SET;
          default: return null;
        }
      }
      @Override
      public int getNumber() {
        return this.value;
      }
    };

    @Override
    public PayloadCase
    getPayloadCase() {
      return PayloadCase.forNumber(
          payloadCase_);
    }

    private void clearPayload() {
      payloadCase_ = 0;
      payload_ = null;
    }

    public static final int MSG_FIELD_NUMBER = 1;
    private int msg_;
    /**
     * <code>.Sec0MsgType msg = 1;</code>
     */
    @Override
    public int getMsgValue() {
      return msg_;
    }
    /**
     * <code>.Sec0MsgType msg = 1;</code>
     */
    @Override
    public Sec0.Sec0MsgType getMsg() {
      Sec0.Sec0MsgType result = Sec0.Sec0MsgType.forNumber(msg_);
      return result == null ? Sec0.Sec0MsgType.UNRECOGNIZED : result;
    }
    /**
     * <code>.Sec0MsgType msg = 1;</code>
     */
    private void setMsgValue(int value) {
        msg_ = value;
    }
    /**
     * <code>.Sec0MsgType msg = 1;</code>
     */
    private void setMsg(Sec0.Sec0MsgType value) {
      if (value == null) {
        throw new NullPointerException();
      }

      msg_ = value.getNumber();
    }
    /**
     * <code>.Sec0MsgType msg = 1;</code>
     */
    private void clearMsg() {

      msg_ = 0;
    }

    public static final int SC_FIELD_NUMBER = 20;
    /**
     * <code>.S0SessionCmd sc = 20;</code>
     */
    @Override
    public boolean hasSc() {
      return payloadCase_ == 20;
    }
    /**
     * <code>.S0SessionCmd sc = 20;</code>
     */
    @Override
    public Sec0.S0SessionCmd getSc() {
      if (payloadCase_ == 20) {
         return (Sec0.S0SessionCmd) payload_;
      }
      return Sec0.S0SessionCmd.getDefaultInstance();
    }
    /**
     * <code>.S0SessionCmd sc = 20;</code>
     */
    private void setSc(Sec0.S0SessionCmd value) {
      if (value == null) {
        throw new NullPointerException();
      }
      payload_ = value;
      payloadCase_ = 20;
    }
    /**
     * <code>.S0SessionCmd sc = 20;</code>
     */
    private void setSc(
        Sec0.S0SessionCmd.Builder builderForValue) {
      payload_ = builderForValue.build();
      payloadCase_ = 20;
    }
    /**
     * <code>.S0SessionCmd sc = 20;</code>
     */
    private void mergeSc(Sec0.S0SessionCmd value) {
      if (value == null) {
        throw new NullPointerException();
      }
      if (payloadCase_ == 20 &&
          payload_ != Sec0.S0SessionCmd.getDefaultInstance()) {
        payload_ = Sec0.S0SessionCmd.newBuilder((Sec0.S0SessionCmd) payload_)
            .mergeFrom(value).buildPartial();
      } else {
        payload_ = value;
      }
      payloadCase_ = 20;
    }
    /**
     * <code>.S0SessionCmd sc = 20;</code>
     */
    private void clearSc() {
      if (payloadCase_ == 20) {
        payloadCase_ = 0;
        payload_ = null;
      }
    }

    public static final int SR_FIELD_NUMBER = 21;
    /**
     * <code>.S0SessionResp sr = 21;</code>
     */
    @Override
    public boolean hasSr() {
      return payloadCase_ == 21;
    }
    /**
     * <code>.S0SessionResp sr = 21;</code>
     */
    @Override
    public Sec0.S0SessionResp getSr() {
      if (payloadCase_ == 21) {
         return (Sec0.S0SessionResp) payload_;
      }
      return Sec0.S0SessionResp.getDefaultInstance();
    }
    /**
     * <code>.S0SessionResp sr = 21;</code>
     */
    private void setSr(Sec0.S0SessionResp value) {
      if (value == null) {
        throw new NullPointerException();
      }
      payload_ = value;
      payloadCase_ = 21;
    }
    /**
     * <code>.S0SessionResp sr = 21;</code>
     */
    private void setSr(
        Sec0.S0SessionResp.Builder builderForValue) {
      payload_ = builderForValue.build();
      payloadCase_ = 21;
    }
    /**
     * <code>.S0SessionResp sr = 21;</code>
     */
    private void mergeSr(Sec0.S0SessionResp value) {
      if (value == null) {
        throw new NullPointerException();
      }
      if (payloadCase_ == 21 &&
          payload_ != Sec0.S0SessionResp.getDefaultInstance()) {
        payload_ = Sec0.S0SessionResp.newBuilder((Sec0.S0SessionResp) payload_)
            .mergeFrom(value).buildPartial();
      } else {
        payload_ = value;
      }
      payloadCase_ = 21;
    }
    /**
     * <code>.S0SessionResp sr = 21;</code>
     */
    private void clearSr() {
      if (payloadCase_ == 21) {
        payloadCase_ = 0;
        payload_ = null;
      }
    }

    public static Sec0.Sec0Payload parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static Sec0.Sec0Payload parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static Sec0.Sec0Payload parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static Sec0.Sec0Payload parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static Sec0.Sec0Payload parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static Sec0.Sec0Payload parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static Sec0.Sec0Payload parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static Sec0.Sec0Payload parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static Sec0.Sec0Payload parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }
    public static Sec0.Sec0Payload parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static Sec0.Sec0Payload parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static Sec0.Sec0Payload parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
      return (Builder) DEFAULT_INSTANCE.createBuilder();
    }
    public static Builder newBuilder(Sec0.Sec0Payload prototype) {
      return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    /**
     * Protobuf type {@code Sec0Payload}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.Builder<
          Sec0.Sec0Payload, Builder> implements
        // @@protoc_insertion_point(builder_implements:Sec0Payload)
        Sec0.Sec0PayloadOrBuilder {
      // Construct using Sec0.Sec0Payload.newBuilder()
      private Builder() {
        super(DEFAULT_INSTANCE);
      }

      @Override
      public PayloadCase
          getPayloadCase() {
        return instance.getPayloadCase();
      }

      public Builder clearPayload() {
        copyOnWrite();
        instance.clearPayload();
        return this;
      }


      /**
       * <code>.Sec0MsgType msg = 1;</code>
       */
      @Override
      public int getMsgValue() {
        return instance.getMsgValue();
      }
      /**
       * <code>.Sec0MsgType msg = 1;</code>
       */
      public Builder setMsgValue(int value) {
        copyOnWrite();
        instance.setMsgValue(value);
        return this;
      }
      /**
       * <code>.Sec0MsgType msg = 1;</code>
       */
      @Override
      public Sec0.Sec0MsgType getMsg() {
        return instance.getMsg();
      }
      /**
       * <code>.Sec0MsgType msg = 1;</code>
       */
      public Builder setMsg(Sec0.Sec0MsgType value) {
        copyOnWrite();
        instance.setMsg(value);
        return this;
      }
      /**
       * <code>.Sec0MsgType msg = 1;</code>
       */
      public Builder clearMsg() {
        copyOnWrite();
        instance.clearMsg();
        return this;
      }

      /**
       * <code>.S0SessionCmd sc = 20;</code>
       */
      @Override
      public boolean hasSc() {
        return instance.hasSc();
      }
      /**
       * <code>.S0SessionCmd sc = 20;</code>
       */
      @Override
      public Sec0.S0SessionCmd getSc() {
        return instance.getSc();
      }
      /**
       * <code>.S0SessionCmd sc = 20;</code>
       */
      public Builder setSc(Sec0.S0SessionCmd value) {
        copyOnWrite();
        instance.setSc(value);
        return this;
      }
      /**
       * <code>.S0SessionCmd sc = 20;</code>
       */
      public Builder setSc(
          Sec0.S0SessionCmd.Builder builderForValue) {
        copyOnWrite();
        instance.setSc(builderForValue);
        return this;
      }
      /**
       * <code>.S0SessionCmd sc = 20;</code>
       */
      public Builder mergeSc(Sec0.S0SessionCmd value) {
        copyOnWrite();
        instance.mergeSc(value);
        return this;
      }
      /**
       * <code>.S0SessionCmd sc = 20;</code>
       */
      public Builder clearSc() {
        copyOnWrite();
        instance.clearSc();
        return this;
      }

      /**
       * <code>.S0SessionResp sr = 21;</code>
       */
      @Override
      public boolean hasSr() {
        return instance.hasSr();
      }
      /**
       * <code>.S0SessionResp sr = 21;</code>
       */
      @Override
      public Sec0.S0SessionResp getSr() {
        return instance.getSr();
      }
      /**
       * <code>.S0SessionResp sr = 21;</code>
       */
      public Builder setSr(Sec0.S0SessionResp value) {
        copyOnWrite();
        instance.setSr(value);
        return this;
      }
      /**
       * <code>.S0SessionResp sr = 21;</code>
       */
      public Builder setSr(
          Sec0.S0SessionResp.Builder builderForValue) {
        copyOnWrite();
        instance.setSr(builderForValue);
        return this;
      }
      /**
       * <code>.S0SessionResp sr = 21;</code>
       */
      public Builder mergeSr(Sec0.S0SessionResp value) {
        copyOnWrite();
        instance.mergeSr(value);
        return this;
      }
      /**
       * <code>.S0SessionResp sr = 21;</code>
       */
      public Builder clearSr() {
        copyOnWrite();
        instance.clearSr();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:Sec0Payload)
    }
    @Override
    @SuppressWarnings({"unchecked", "fallthrough"})
    protected final Object dynamicMethod(
        MethodToInvoke method,
        Object arg0, Object arg1) {
      switch (method) {
        case NEW_MUTABLE_INSTANCE: {
          return new Sec0.Sec0Payload();
        }
        case NEW_BUILDER: {
          return new Builder();
        }
        case BUILD_MESSAGE_INFO: {
            Object[] objects = new Object[] {
              "payload_",
              "payloadCase_",
              "msg_",
              Sec0.S0SessionCmd.class,
              Sec0.S0SessionResp.class,
            };
            String info =
                "\u0000\u0003\u0001\u0000\u0001\u0015\u0003\u0000\u0000\u0000\u0001\f\u0014<\u0000" +
                "\u0015<\u0000";
            return newMessageInfo(DEFAULT_INSTANCE, info, objects);
        }
        // fall through
        case GET_DEFAULT_INSTANCE: {
          return DEFAULT_INSTANCE;
        }
        case GET_PARSER: {
          com.google.protobuf.Parser<Sec0.Sec0Payload> parser = PARSER;
          if (parser == null) {
            synchronized (Sec0.Sec0Payload.class) {
              parser = PARSER;
              if (parser == null) {
                parser = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                PARSER = parser;
              }
            }
          }
          return parser;
      }
      case GET_MEMOIZED_IS_INITIALIZED: {
        return (byte) 1;
      }
      case SET_MEMOIZED_IS_INITIALIZED: {
        return null;
      }
      }
      throw new UnsupportedOperationException();
    }


    // @@protoc_insertion_point(class_scope:Sec0Payload)
    private static final Sec0.Sec0Payload DEFAULT_INSTANCE;
    static {
      // New instances are implicitly immutable so no need to make
      // immutable.
      DEFAULT_INSTANCE = new Sec0Payload();
    }

    static {
      com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
        Sec0Payload.class, DEFAULT_INSTANCE);
    }
    public static Sec0.Sec0Payload getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static volatile com.google.protobuf.Parser<Sec0Payload> PARSER;

    public static com.google.protobuf.Parser<Sec0Payload> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
  }


  static {
  }

  // @@protoc_insertion_point(outer_class_scope)
}
