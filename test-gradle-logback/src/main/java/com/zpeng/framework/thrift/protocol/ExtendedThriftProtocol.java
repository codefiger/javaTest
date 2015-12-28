package com.zpeng.framework.thrift.protocol;

import java.util.Date;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMessage;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.zpeng.framework.logger.CallInfo;
import com.zpeng.framework.logger.RequestIdentityHolder;

public class ExtendedThriftProtocol extends TBinaryProtocol {
	private static Logger logger = LoggerFactory.getLogger(ExtendedThriftProtocol.class);
    protected static final String EXTENSION_BEGIN_MARK = ",extension_begin_mark:";
	
	public ExtendedThriftProtocol(TTransport trans) {
        super(trans);
    }
	
	public ExtendedThriftProtocol(TTransport trans, boolean strictRead, boolean strictWrite) {
		super(trans, strictRead, strictWrite);
	}
	
	
	private class Extension{
		private CallInfo callInfo;

		public CallInfo getCallInfo() {
			return callInfo;
		}

		public void setCallInfo(CallInfo callInfo) {
			this.callInfo = callInfo;
		}
	}

	/**
	 * add traceId info into transform message 
	 */
	@Override
	public void writeMessageBegin(TMessage message) throws TException {
		Extension extension = createExtension();
		extension.setCallInfo(RequestIdentityHolder.get());
    	String newMessageName = composeNewMessageName(message, extension);
		TMessage tm = new TMessage(newMessageName, message.type, message.seqid);
		super.writeMessageBegin(tm);
	}

	private String composeNewMessageName(TMessage message, Extension extension) {
		return message.name + EXTENSION_BEGIN_MARK + new Gson().toJson(extension);
	}

	private Extension createExtension() {
		Extension extension = new Extension();
		extension.setCallInfo(RequestIdentityHolder.get());//traceId
		return extension;
	}
	
	/**
	 * get traceId info from transform message 
	 */
	@Override
	public TMessage readMessageBegin() throws TException {
		TMessage tm  = super.readMessageBegin();
		
		String originalMessageName = null;
		Extension extension = new Extension();
		String[] parts = tm.name.split(EXTENSION_BEGIN_MARK);
		if(parts.length > 1){
			originalMessageName = parts[0];
			try{
				extension = new Gson().fromJson(parts[1], Extension.class);
			}catch(Exception e){
				logger.error("", e);
			}
		}
		
		CallInfo callInfo = extension.getCallInfo();
		callInfo.setTime(new Date().getTime());
		RequestIdentityHolder.set(callInfo);
        return new TMessage(originalMessageName, tm.type, tm.seqid);
	}

	@Override
	public void readMessageEnd() {
		super.readMessageEnd();
	}

	@Override
	public void writeMessageEnd() {
		super.writeMessageEnd();
	}
}
