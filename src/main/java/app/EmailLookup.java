package app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class EmailLookup {

    private static final String API_URL = "https://www.1secmail.com/api/v1/";

    // Parameters List
    private static final String ACTION = "action";
    private static final String LOGIN = "login";
    private static final String DOMAIN = "domain";
    private static final String ID = "id";
    private static final String FILE = "file";

    // Actions List
    private static final String DOMAINS = "getDomainList";
    private static final String MESSAGES = "getMessages";
    private static final String MESSAGE = "readMessage";
    private static final String DOWNLOAD = "download";


    private static String[] parseEmail(String emailAddress){
        return emailAddress.split("@");
    }

    private static String getEmailIdentifier(String[] parsedEmail){
        return LOGIN + "=" + parsedEmail[0] + "&" + DOMAIN + "=" + parsedEmail[1];
    }

    private static HttpResponse<String> getMessagesList(String[] parsedEmail) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(API_URL + "?" + ACTION + "=" + MESSAGES + "&" + getEmailIdentifier(parsedEmail)))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private static int[] getIdList(String[] parsedEmail) throws IOException, InterruptedException {
        HttpResponse<String> response = getMessagesList(parsedEmail);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List <EmailMessage> messagesList = mapper.readValue(response.body(), new TypeReference<>() {});

        return  messagesList.stream().map(EmailMessage::getId).mapToInt(num -> Integer.parseInt(String.valueOf(num))).toArray();
    }

    public static Collection<EmailMessage> getEmailsFromAddress(String emailAddress) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Collection <EmailMessage> collection = new ArrayList<>();
        String[] parsedEmail = parseEmail(emailAddress);
        int[] idList = getIdList(parsedEmail);

        for (int i = 0; i < idList.length; i++) {
            EmailMessage message = mapper.readValue(new URL(API_URL + "?" + ACTION + "=" + MESSAGE + "&" + getEmailIdentifier(parsedEmail) + "&id="+ idList[i]), EmailMessage.class);
            collection.add(message);
        }

        return collection;

    }

}
