import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * Code copied and ajusted from:
 * https://github.com/aggarwalankush/push-notification-server.git
 * 
 * Run 'javac .\AndroidPush.java' to compile the changes
 * Run 'java AndroidPush' to execute de program and push to device configured.
 * 
 */

public class AndroidPush {

    /**
     * Replace SERVER_KEY with your SERVER_KEY generated from FCM Replace
     * DEVICE_TOKEN with your DEVICE_TOKEN
     */
    private static String SERVER_KEY = "<SERVER_KEY>";
    // private static String DEVICE_TOKEN =
    // "eiIIVAsMupM:APA91bE31P0uoG3PUfY7bvBaz9MsVY04GYnaGEYt3H9-ChdJ3D5STDPHMg8XlJdGK9j2nkAoBbdszH8Qvz4lvH2Ml_kHEXCBP0IHuhoSQb-gVVTIjfg6xK9MX0jHr-f76ad2WfoDy0MY";
    private static String DEVICE_TOKEN = "<DEVICE_TOKEN>";

    /**
     * USE THIS METHOD to send push notification
     */
    public static void main(String[] args) throws Exception {
        String title = "Java says:";
        String message = "Push with Java works well!";
        sendPushNotification(title, message);
    }

    /**
     * Sends notification to mobile, YOU DON'T NEED TO UNDERSTAND THIS METHOD
     */
    private static void sendPushNotification(String title, String message) throws Exception {
        String pushMessage = "{\"data\":{\"title\":\"" + title + "\",\"message\":\"" + message + "\"},\"to\":\""
                + DEVICE_TOKEN + "\"}";
        // Create connection to send FCM Message request.
        URL url = new URL("https://fcm.googleapis.com/fcm/send");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Authorization", "key=" + SERVER_KEY);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        // Send FCM message content.
        OutputStream outputStream = conn.getOutputStream();
        outputStream.write(pushMessage.getBytes());

        System.out.println(conn.getResponseCode());
        System.out.println(conn.getResponseMessage());
    }
}
