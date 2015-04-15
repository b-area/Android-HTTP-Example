package lu.cct.profileproject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by Eddy C. Borera on 4/12/15.
 * HTTPClient program for HTTP GET/POST
 * request to get/post JSON data to
 * a back end server.
 */

public class HttpClient
{
    private URL main_url;

    // ------------------------
    // Overloading constructor
    // ------------------------
    public HttpClient(String url)
    {
        try {
            main_url = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    // --------------------------
    // Retrieve data using GET
    // --------------------------
    public String getData()
    {
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();

        try {
            HttpURLConnection connection = (HttpURLConnection) main_url.openConnection();
            connection.setRequestMethod("GET");
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ( (line = reader.readLine()) != null) {
                sb.append(line);
            }

            reader.close(); // closing the buffer
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }


    // -------------------------
    // Post JSON data to an URL
    // -------------------------
    public void postData()
    {

    }


    // ------------------------
    // Testing the class
    // ------------------------
    public static void main(String [] args)
    {
        HttpClient client = new HttpClient("http://66.147.235.233:3000/api/news");
        System.out.println(client.getData());
    }

}
