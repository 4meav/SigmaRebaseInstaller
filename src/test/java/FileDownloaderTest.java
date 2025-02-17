//import com.mentalfrostbyte.installer.util.FileDownloader;
//import org.junit.jupiter.api.*;
//import org.mockito.*;
//import javax.swing.*;
//
//import java.io.*;
//import java.net.*;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//class FileDownloaderTest {
//
//    @Test
//    void testDownloadFile() throws Exception {
//        // Mock the URL and the input stream
//        URL mockUrl = mock(URL.class);
//        InputStream mockInputStream = mock(InputStream.class);
//        FileOutputStream mockFileOutputStream = mock(FileOutputStream.class);
//
//        when(mockUrl.openStream()).thenReturn(mockInputStream);
//
//        JProgressBar mockProgressBar = mock(JProgressBar.class);
//
//        // Run the downloadFile method in a separate thread to simulate downloading
//        new Thread(() -> {
//            try {
//                FileDownloader.downloadFile("http://example.com/file.jar", "test.jar", mockProgressBar);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        // Simulate progress updates
//        verify(mockProgressBar, atLeast(1)).setValue(anyInt());
//    }
//}