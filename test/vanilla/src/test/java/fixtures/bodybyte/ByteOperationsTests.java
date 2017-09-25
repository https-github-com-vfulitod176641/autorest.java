package fixtures.bodybyte;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import fixtures.bodybyte.implementation.AutoRestSwaggerBATByteServiceImpl;

public class ByteOperationsTests {
    private static AutoRestSwaggerBATByteService client;

    @BeforeClass
    public static void setup() {
        client = new AutoRestSwaggerBATByteServiceImpl("http://localhost:3000");
    }

    @Test
    public void getEmpty() throws Exception {
        byte[] result = client.bytes().getNull();
        Assert.assertEquals(0, result.length);
    }

    @Test
    public void getNonAscii() throws Exception {
        byte[] result = client.bytes().getNonAscii();
        // Previously, byte[] response bodies were automatically base64 decoded by the runtime.
        // This conflicts with the octet-stream  (e.g. file/media download) use case,
        // so we're now passing the byte[] through as-is.
        byte[] expected = new byte[] { 34, 47, 47, 55, 57, 47, 80, 118, 54, 43, 102, 106, 51, 57, 103, 61, 61, 34 };
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void putNonAscii() throws Exception {
        byte[] body = new byte[] { 34, 47, 47, 55, 57, 47, 80, 118, 54, 43, 102, 106, 51, 57, 103, 61, 61, 34 };
        client.bytes().putNonAscii(body);
    }
}
