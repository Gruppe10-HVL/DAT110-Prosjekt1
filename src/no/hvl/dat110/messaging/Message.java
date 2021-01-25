package no.hvl.dat110.messaging;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		this.payload = payload.length < MessageConfig.SEGMENTSIZE 
			? payload : null;
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded;
		encoded = new byte[MessageConfig.SEGMENTSIZE];
		encoded[0] = (byte) payload.length;
		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format

		for (int i = 0; i < payload.length; i++) {
			encoded[i + 1] = payload[i];
		}

		return encoded;
		
	}

	public void decapsulate(byte[] received) {

		payload = new byte[received[0]];
		// TODO
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message
		
		for (int i = 0; i < received[0]; i++) {
			payload[i]= received[i + 1];
		}

	}
}
