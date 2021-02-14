package no.hvl.dat110.system.display;

import no.hvl.dat110.rpc.RPCImpl;
import no.hvl.dat110.rpc.RPCUtils;

public class DisplayImpl implements RPCImpl {

	public void write(String message) {
		System.out.println("DISPLAY:" + message);
	}
	
	public byte[] invoke(byte[] request) {

		byte rpcid = request[0];
		byte[] reply;

		String msg = RPCUtils.unmarshallString(request);
		write(msg);
		
		reply = RPCUtils.marshallVoid(rpcid);
		
		return reply;
	}
}
