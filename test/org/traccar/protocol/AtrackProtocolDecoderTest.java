package org.traccar.protocol;

import org.traccar.helper.TestDataManager;
import org.jboss.netty.buffer.ChannelBuffers;
import static org.traccar.helper.DecoderVerifier.verify;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.traccar.helper.ChannelBufferTools;

public class AtrackProtocolDecoderTest {

    @Test
    public void testDecode() throws Exception {

        AtrackProtocolDecoder decoder = new AtrackProtocolDecoder(new TestDataManager(), null, null);

        assertNull(decoder.decode(null, null, null, ChannelBuffers.wrappedBuffer(ChannelBufferTools.convertArray(
                new int[] {0xfe,0x02,0x00,0x01,0x41,0x04,0xd8,0xf1,0x96,0x82,0x00,0x01}))));

        verify(decoder.decode(null, null, null, ChannelBuffers.wrappedBuffer(ChannelBufferTools.convertArray(
                new int[] {0x40,0x50,0x99,0x3f,0x00,0x5c,0x00,0x02,0x00,0x01,0x41,0x04,0xd8,0xf1,0x96,0x82,0x52,0x56,0x66,0xc2,0x52,0x56,0x8c,0x3c,0x52,0x56,0x8c,0x63,0xff,0xc8,0x33,0x84,0x02,0x69,0x88,0x85,0x00,0x00,0x02,0x00,0x00,0x09,0xcf,0x03,0xde,0x01,0x00,0x00,0x00,0x00,0x00,0x00,0x07,0xd0,0x07,0xd0,0x00,0x52,0x56,0x66,0xc2,0x52,0x56,0x8c,0x5a,0x52,0x56,0x8c,0x63,0xff,0xc8,0x33,0x84,0x02,0x69,0x88,0x85,0x00,0x00,0x02,0x00,0x00,0x09,0xcf,0x03,0xde,0x01,0x00,0x00,0x00,0x00,0x00,0x00,0x07,0xd0,0x07,0xd0,0x00}))));

        verify(decoder.decode(null, null, null, ChannelBuffers.wrappedBuffer(ChannelBufferTools.convertArray(
                new int[] {0x40,0x50,0x1e,0x58,0x00,0x33,0x01,0xe0,0x00,0x01,0x41,0x04,0xd8,0xf1,0x96,0x82,0x52,0x5e,0xcd,0x5d,0x52,0x5e,0xe3,0x44,0x52,0x5e,0xe3,0x5e,0xff,0xc8,0x88,0x15,0x02,0x6a,0xb4,0xd7,0x00,0x00,0x02,0x00,0x00,0x10,0x44,0x03,0xde,0x01,0x00,0x0b,0x00,0x00,0x00,0x00,0x07,0xd0,0x07,0xd0,0x00}))));

        // 7-byte date
        //verify(decoder.decode(null, null, ChannelBuffers.wrappedBuffer(ChannelBufferTools.convertArray(
        //        new int[] {0x02,0x03,0xb4,0x94,0x00,0x3c,0x00,0xeb,0x00,0x01,0x41,0x04,0xd8,0xdd,0x3a,0x3e,0x07,0xde,0x01,0x1b,0x0b,0x1f,0x03,0x07,0xde,0x01,0x1b,0x0b,0x1f,0x03,0x07,0xde,0x01,0x1b,0x0b,0x1f,0x03,0x00,0x30,0x7f,0x28,0x03,0x05,0x74,0xd3,0x00,0x00,0x02,0x00,0x00,0x00,0x06,0x00,0x16,0x01,0x00,0x02,0x00,0x00,0x00,0x00,0x07,0xd0,0x07,0xd0,0x00}))));

        //verify(decoder.decode(null, null, ChannelBuffers.wrappedBuffer(ChannelBufferTools.convertArray(
        //        new int[] {0x40,0x50,0xd2,0xc5,0x00,0xda,0x05,0x52,0x00,0x01,0x41,0x04,0xd8,0xf1,0x96,0x82,0x53,0x07,0x55,0x51,0x53,0x07,0x55,0x50,0x53,0x07,0x55,0x81,0xff,0xbb,0xa6,0x6a,0x02,0x31,0x29,0x5c,0x00,0x19,0x02,0x00,0x00,0x00,0xda,0x00,0x0a,0x01,0x00,0x83,0x00,0x00,0x00,0x00,0x07,0xd0,0x07,0xd0,0x00,0x00,0x00,0x00,0x00,0x12,0x00,0x08,0x0e,0x09,0x00,0x85,0x53,0x07,0x55,0x60,0x53,0x07,0x55,0x5f,0x53,0x07,0x55,0x82,0xff,0xbb,0xb0,0x41,0x02,0x31,0x3b,0x4b,0x00,0x18,0x02,0x00,0x00,0x00,0xe0,0x00,0x0c,0x01,0x00,0x85,0x00,0x00,0x00,0x00,0x07,0xd0,0x07,0xd0,0x00,0x00,0x00,0x00,0x00,0x12,0x00,0x08,0x0d,0x00,0x00,0x86,0x53,0x07,0x55,0x6f,0x53,0x07,0x55,0x6e,0x53,0x07,0x55,0x82,0xff,0xbb,0xbb,0xea,0x02,0x31,0x4b,0x49,0x00,0x24,0x02,0x00,0x00,0x00,0xe5,0x00,0x0a,0x01,0x00,0x7b,0x00,0x00,0x00,0x00,0x07,0xd0,0x07,0xd0,0x00,0x00,0x00,0x00,0x00,0x12,0x00,0x08,0x0d,0x02,0x00,0x85,0x53,0x07,0x55,0x7e,0x53,0x07,0x55,0x7d,0x53,0x07,0x55,0x82,0xff,0xbb,0xc9,0x87,0x02,0x31,0x59,0x82,0x00,0x25,0x02,0x00,0x00,0x00,0xea,0x00,0x09,0x01,0x00,0x7a,0x00,0x00,0x00,0x00,0x07,0xd0,0x07,0xd0,0x00,0x00,0x00,0x00,0x00,0x13,0x00,0x18,0x0d,0x08,0x00,0x7b}))));
        
    }

}
