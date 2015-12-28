package com.zpeng.framework.thrift.protocol;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TTransport;

public class ExtendedThriftProtocolFactory implements TProtocolFactory {

	private static final long serialVersionUID = -1248716643340473991L;

	protected boolean strictRead_ = false;
	protected boolean strictWrite_ = true;
	protected int readLength_;

	public ExtendedThriftProtocolFactory() {
		this(false, true);
	}

	public ExtendedThriftProtocolFactory(boolean strictRead, boolean strictWrite) {
		this(strictRead, strictWrite, 0);
	}

	public ExtendedThriftProtocolFactory(boolean strictRead, boolean strictWrite, int readLength) {
		this.strictRead_ = strictRead;
		this.strictWrite_ = strictWrite;
		this.readLength_ = readLength;
	}

	@Override
	public TProtocol getProtocol(TTransport transport) {
		TBinaryProtocol proto = new ExtendedThriftProtocol(transport, strictRead_, strictWrite_);
		return proto;
	}

}
