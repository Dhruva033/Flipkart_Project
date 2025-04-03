import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailReader {
    public static String fetchOTPFromEmail(String email, String password) {
        String otp = null;
        try {
            // Set up properties for IMAP connection
            Properties properties = new Properties();
            properties.put("mail.store.protocol", "imaps");
            properties.put("mail.imaps.host", "imap.gmail.com");
            properties.put("mail.imaps.port", "993");
            properties.put("mail.imaps.ssl.enable", "true");

            // Connect to email
            Session session = Session.getDefaultInstance(properties, null);
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", email, password);

            // Open INBOX folder
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Fetch unread emails
            Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

            for (Message message : messages) {
                String subject = message.getSubject();
                String content = message.getContent().toString();

                // Print email details (optional)
                System.out.println("Subject: " + subject);
                System.out.println("Content: " + content);

                // Extract OTP using Regex (Assuming OTP is a 6-digit number)
                Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
                Matcher matcher = pattern.matcher(content);
                if (matcher.find()) {
                    otp = matcher.group(0);
                    System.out.println("Extracted OTP: " + otp);
                    break;  // Stop after finding the first OTP
                }
            }

            // Close resources
            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return otp;
    }
}
