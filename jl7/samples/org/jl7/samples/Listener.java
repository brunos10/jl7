package org.jl7.samples;

import java.io.IOException;

import org.jl7.hl7.HL7Message;
import org.jl7.mllp.MLLPMetaData;
import org.jl7.mllp.MLLPTransport;
import org.jl7.mllp.MLLPTransportable;

public class Listener {
    private static final String HOST = "localhost";
    private static int PORT = 9991;
    private static MLLPMetaData metaData = new MLLPMetaData(HOST, PORT);

    /**
     * @param args
     */
    public static void main(String[] args) {
        MLLPTransport transport = new MLLPTransport();
        MLLPTransportable transportable = null;
        for (int i = 0; i < 10; i++) {
            try {
                transportable = transport.receiveMessageReconnectOnError(metaData);
                HL7Message msg = transportable.message;
                System.out.println(msg);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
