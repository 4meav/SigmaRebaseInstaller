//import com.mentalfrostbyte.installer.util.MinecraftVersionUpdater;
//import org.junit.jupiter.api.*;
//import org.mockito.*;
//import javax.swing.*;
//import java.io.*;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//class MinecraftVersionUpdaterTest {
//
//    @Mock
//    private JProgressBar mockProgressBar;
//
//    @Test
//    void testSetupVersion() throws Exception {
//        // Mock the download method to not actually download files
//        doNothing().when(mockProgressBar).setValue(anyInt());
//
//        // Call the setupVersion method (we don't need actual URLs for this test)
//        MinecraftVersionUpdater.setupVersion("http://example.com/file.jar", "http://example.com/file.json", "SigmaRebase-Test", mockProgressBar);
//
//        // Verify the progress bar was updated during setup
//        verify(mockProgressBar, atLeastOnce()).setValue(anyInt());
//    }
//}
