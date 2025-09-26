package support;

import com.aventstack.extentreports.Status;

public class LoggerHelper {
    public static void log(Status status, String message) {
        extentReportClass.extentTest.log(status, message);
    }
}