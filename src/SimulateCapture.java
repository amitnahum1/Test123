//package <set your test package>;
import com.experitest.client.*;
import org.testng.annotations.*;
/**
 *
*/
public class SimulateCapture {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\amit.nahum\\workspace\\project8";
    protected Client client = null;

    @BeforeMethod
    public void setUp(){
        client = new Client(host, port, true);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "EHI");
    }

    @Test(groups = {"seetest"})
    public void testEHI(){
        client.setDevice("00db17d862b2bd18");
        client.install("me.scan.android.client/.ui.ScanActivity", true, false);
        client.launch("me.scan.android.client/.ui.ScanActivity", true, true);
        client.click("NATIVE", "xpath=//*[@text='Allow']", 0, 1);
        client.sleep(1000);
        client.simulateCapture("C:\\Users\\amit.nahum\\Downloads\\Checks\\QR\\Capture1.JPG");
        client.sleep(2000);
        client.click("NATIVE", "xpath=//*[@text='OK']", 0, 1);
        client.sleep(5000);
    }

    @AfterMethod
    public void tearDown(){
        // Generates a report of the test case.
        // For more information - https://docs.experitest.com/display/public/SA/Report+Of+Executed+Test
        client.generateReport(false);
        // Releases the client so that other clients can approach the agent in the near future. 
        client.releaseClient();
    }
}
