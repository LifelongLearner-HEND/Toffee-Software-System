package MembershipManager;
import java.util.Random;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * This class is used to generate a random OTP and send it to the user's email
 */
public class OTPgenerated {


    static String otp;

    /**
     * This method is used to send the OTP to the user's email, it will call the generateOTP() method, and then send the OTP by using the JavaMail API, The user will be asked to enter the OTP to verify their email, If the OTP is correct, the user will be registered successfully, If not, the user will be asked to re-enter the OTP, The user will be given 3 attempts to enter the correct OTP, If the user fails to enter the correct OTP, the registration process will be terminated, The user will be asked to re-enter their data.
     * @param email
     */
    public static void sendOTP(String email) {
        otp = generateOTP();
        // Send the OTP by email
        String to = email;
        String from = "storetoffee7@gmail.com";
        String host = "smtp.gmail.com";
        String username = "storetoffee7@gmail.com";
        String password = "dqxyvawaeqsgxcty";


        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("OTP Verification.");
            message.setText("Your OTP is: " + otp);

            Transport.send(message);

            System.out.println("OTP sent successfully! ☺");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is used to generate a random OTP
     * @return
     */
    // Generate a random OTP, this method is called in sendOTP() method,
    private static String generateOTP() {
        int length = 4;
        String numbers = "0123456789";
        Random random = new Random();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(numbers.length());
            char digit = numbers.charAt(index);
            sb.append(digit);
        }

        return sb.toString();
    }

    /**
     * This method is used to get the OTP
     * @return
     */
    public static String getOTP() {
        return otp;
    }
}

