//import com.mentalfrostbyte.installer.util.GitHubReleaseFetcher;
//import org.apache.http.client.HttpClient;
//import org.apache.http.entity.BasicHttpEntity;
//import org.junit.jupiter.api.*;
//import org.mockito.*;
//import org.apache.http.*;
//import org.apache.http.impl.client.*;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.HttpResponse;
//import org.apache.http.util.EntityUtils;
//import org.json.JSONObject;
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//class GitHubReleaseFetcherTest {
//
//    @Mock
//    private HttpClient mockHttpClient;
//
//    @Mock
//    private HttpResponse mockHttpResponse;
//
//    @BeforeEach
//    void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testFetchReleaseInfo_Nightly() throws Exception {
//        // Mocking the HTTP client to return a mocked response for the nightly release.
//        String mockJsonResponse = "{ \"assets\": [{ \"browser_download_url\": \"http://example.com/nightly.jar\" }, { \"browser_download_url\": \"http://example.com/nightly.json\" }]}";
//
//        when(mockHttpClient.execute(any(HttpGet.class))).thenReturn(mockHttpResponse);
//        when(mockHttpResponse.getEntity()).thenReturn(new BasicHttpEntity());
//        when(EntityUtils.toString(mockHttpResponse.getEntity())).thenReturn(mockJsonResponse);
//
//        // Calling the method
//        JSONObject result = GitHubReleaseFetcher.fetchReleaseInfo(true);
//
//        // Assert the result
//        assertNotNull(result);
//        assertEquals("http://example.com/nightly.jar", result.getJSONArray("assets").getJSONObject(0).getString("browser_download_url"));
//    }
//
//    @Test
//    void testFetchReleaseInfo_Release() throws Exception {
//        // Mocking the HTTP client to return a mocked response for the latest release.
//        String mockJsonResponse = "{ \"assets\": [{ \"browser_download_url\": \"http://example.com/release.jar\" }, { \"browser_download_url\": \"http://example.com/release.json\" }]}";
//
//        when(mockHttpClient.execute(any(HttpGet.class))).thenReturn(mockHttpResponse);
//        when(mockHttpResponse.getEntity()).thenReturn(new BasicHttpEntity());
//        when(EntityUtils.toString(mockHttpResponse.getEntity())).thenReturn(mockJsonResponse);
//
//        // Calling the method
//        JSONObject result = GitHubReleaseFetcher.fetchReleaseInfo(false);
//
//        // Assert the result
//        assertNotNull(result);
//        assertEquals("http://example.com/release.jar", result.getJSONArray("assets").getJSONObject(0).getString("browser_download_url"));
//    }
//}