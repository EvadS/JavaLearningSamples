package som.se.company.app;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientUtils {
    public static String post(String postUrl, Map<String, String> params,
                              Map<String, String> files) throws ClientProtocolException,
            IOException {
        CloseableHttpResponse response = null;
        InputStream is = null;
        String results = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {

            HttpPost httppost = new HttpPost(postUrl);

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();

            if (params != null) {
                for (String key : params.keySet()) {
                    StringBody value = new StringBody(params.get(key),
                            ContentType.TEXT_PLAIN);
                    builder.addPart(key, value);
                }
            }

            if (files != null && files.size() > 0) {
                for (String key : files.keySet()) {
                    String value = files.get(key);
                    FileBody body = new FileBody(new File(value));
                    builder.addPart(key, body);
                }
            }

            HttpEntity reqEntity = builder.build();
            httppost.setEntity(reqEntity);

            response = httpclient.execute(httppost);
            // assertEquals(200, response.getStatusLine().getStatusCode());

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                is = entity.getContent();
                StringWriter writer = new StringWriter();
                IOUtils.copy(is, writer, "UTF-8");
                results = writer.toString();
            }

        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Throwable t) {
                // No-op
            }

            try {
                if (response != null) {
                    response.close();
                }
            } catch (Throwable t) {
                // No-op
            }

            httpclient.close();
        }

        return results;
    }

    public static String get(String getStr) throws IOException,
            ClientProtocolException {
        CloseableHttpResponse response = null;
        InputStream is = null;
        String results = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {
            HttpGet httpGet = new HttpGet(getStr);
            response = httpclient.execute(httpGet);

        //    assertEquals(200, response.getStatusLine().getStatusCode());

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                is = entity.getContent();
                StringWriter writer = new StringWriter();
                IOUtils.copy(is, writer, "UTF-8");
                results = writer.toString();
            }

        } finally {

            try {
                if (is != null) {
                    is.close();
                }
            } catch (Throwable t) {
                // No-op
            }

            try {
                if (response != null) {
                    response.close();
                }
            } catch (Throwable t) {
                // No-op
            }

            httpclient.close();
        }

        return results;
    }
}
