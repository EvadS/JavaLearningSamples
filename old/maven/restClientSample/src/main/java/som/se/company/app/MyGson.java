package som.se.company.app;

import com.google.gson.Gson;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * саммый простой вариант дернуть запрос
 */
public class MyGson {
    public HttpResponse http(String url, String body) {

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpPost request = new HttpPost(url);
            StringEntity params = new StringEntity(body);
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse result = httpClient.execute(request);
            String json = EntityUtils.toString(result.getEntity(), "UTF-8");

            Gson gson = new Gson();
            Response respuesta = gson.fromJson(json, Response.class);

            System.out.println(respuesta.getModel());


        } catch (IOException ex) {
            System.out.println("------------------------");
            ex.printStackTrace();
        }
        return null;
    }

    public class Response{

        private String model;

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }
    }
}
