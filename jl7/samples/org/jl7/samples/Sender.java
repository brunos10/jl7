package org.jl7.samples;

import java.io.IOException;

import org.jl7.hl7.HL7Message;
import org.jl7.hl7.HL7Parser;
import org.jl7.mllp.MLLPMetaData;
import org.jl7.mllp.MLLPTransport;
import org.jl7.mllp.MLLPTransportable;

public class Sender {
    private static final String MESSAGE = "MSH|^~\\&||ABCHS||AUSDHSV|20070103112951||ADT^A08^ADT_A01|12334456778893|P|2.5|||NE|NE|AU|ASCII\rEVN|A08|20060705000000\rPID|1||0000112234^^^100^A||XXXXXXXXXX^^^^^^S||10131113|1||4|^^RICHMOND^^3121||||1201||||||||1100|||||||||AAA\rPV1|1|O|^^^^^1|||||||2|||||1||||654345509^^^100^A|1|||||||||||||||||||||||||200607050000||||||V\rPV2|||||||1||||||||||||||||^^^^^^^^^103\rROL|1|AD|SAHCP|XXXXXXXXXX^^^^^^S|||||6|1\rPR1|1||1||20060705|1\rGT1|1||||||||||||||||||||NOT APPLICABLE";
    private static final String HOST = "localhost";
    private static int PORT = 9991;

    /**
     * @param args
     */
    public static void main(String[] args) {
        HL7Message msg = HL7Parser.parseMessage(MESSAGE, true);
        MLLPTransportable transportable = new MLLPTransportable();
        transportable.message = msg;
        transportable.metaData = new MLLPMetaData(HOST, PORT);
        MLLPTransport transport = new MLLPTransport();
        for (int i = 0; i < 10; i++) {
            try {
                transport.sendMessage(transportable);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}