package Exercise_11;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class TestDataStream {
    @Test
    public void bytesDataStream() throws IOException {
        ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
        DataOutputStream outputStream = new DataOutputStream(byteArrayOutput);
        outputStream.writeByte(1);
        assertEquals(1,byteArrayOutput.size());
    }
    @Test
    public void shortDataStream() throws IOException {
        ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
        DataOutputStream outputStream = new DataOutputStream(byteArrayOutput);
        outputStream.writeShort(1);
        assertEquals(2,byteArrayOutput.size());
    }
    @Test
    public void integerDataStream() throws IOException {
        ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
        DataOutputStream outputStream = new DataOutputStream(byteArrayOutput);
        outputStream.writeInt(1);
        assertEquals(4,byteArrayOutput.size());
    }
    @Test
    public void longDataStream() throws IOException {
        ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
        DataOutputStream outputStream = new DataOutputStream(byteArrayOutput);
        outputStream.writeLong(1);
        assertEquals(8,byteArrayOutput.size());
    }
    @Test
    public void floatDataStream() throws IOException {
        ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
        DataOutputStream outputStream = new DataOutputStream(byteArrayOutput);
        outputStream.writeFloat(1);
        assertEquals(4,byteArrayOutput.size());
    }
    @Test
    public void doubleDataStream() throws IOException {
        ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
        DataOutputStream outputStream = new DataOutputStream(byteArrayOutput);
        outputStream.writeDouble(1);
        assertEquals(8,byteArrayOutput.size());
    }
}
