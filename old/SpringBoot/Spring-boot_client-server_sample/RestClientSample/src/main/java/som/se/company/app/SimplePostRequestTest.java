package som.se.company.app;

import java.io.*;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;

public class SimplePostRequestTest {

    /**
     * upload api get param like org.springframework.web.multipart.MultipartFile
     * worked
     * @throws IOException
     */
    public void multipartFileUpload() throws IOException {

        String filePath = System.getProperty("user.home") + "/test/2_6.gif";
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost uploadFile = new HttpPost("http://localhost:8086/api/upload-multipartFileUpload");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();

        // This attaches the file to the POST:
        File f = new File(filePath);
        builder.addBinaryBody(
                "file",
                new FileInputStream(f),
                ContentType.MULTIPART_FORM_DATA,
                f.getName()
        );

        HttpEntity multipart = builder.build();
        uploadFile.setEntity(multipart);
        CloseableHttpResponse response = httpClient.execute(uploadFile);

        System.out.println("status : " + response.getStatusLine());

        HttpEntity responseEntity = response.getEntity();
    }


    public void multipartFileUpload2() throws IOException {

        String filePath = System.getProperty("user.home") + "/test/2_6.gif";
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost uploadFile = new HttpPost("http://localhost:8086/api/upload-multipartFileUpload2");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();

        // This attaches the file to the POST:
        File f = new File(filePath);
        builder.addBinaryBody(
                "file",
                new FileInputStream(f),
                ContentType.MULTIPART_FORM_DATA,
                f.getName()
        );

        HttpEntity multipart = builder.build();
        uploadFile.setEntity(multipart);
        CloseableHttpResponse response = httpClient.execute(uploadFile);

        Car car = new Car();
        car.setModel("KamAZ 55102");

        Gson gson = new Gson();
        String json = gson.toJson(car);

        StringEntity entity = new StringEntity(json);
        //  uploadFile.setEntity(entity);
        uploadFile.setEntity(entity);
        uploadFile.setHeader("Accept", "application/json");
        uploadFile.setHeader("Content-type", "application/json");

        System.out.println("status : " + response.getStatusLine());

        HttpEntity responseEntity = response.getEntity();
    }


    public void runWithCustomMultipart() throws IOException {

        String filePath = System.getProperty("user.home") + "/test/2_6.gif";
        String filePath2 = System.getProperty("user.home") + "/test/33333.jpg";
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost uploadFile = new HttpPost("http://localhost:8086/rest/uploadMultiFiles");

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addTextBody("description", "test", ContentType.MULTIPART_FORM_DATA);
        builder.addTextBody("testFields", "Test fields", ContentType.MULTIPART_FORM_DATA);

        // This attaches the file to the POST:
        // передаем два файла
        File f = new File(filePath);
        builder.addBinaryBody(
                "files",
                new FileInputStream(f),
                ContentType.MULTIPART_FORM_DATA,
                f.getName()
        );

        f = new File(filePath2);
        builder.addBinaryBody(
                "files",
                new FileInputStream(f),
                ContentType.MULTIPART_FORM_DATA,
                f.getName()
        );

        HttpEntity multipart = builder.build();
        uploadFile.setEntity(multipart);
        CloseableHttpResponse response = httpClient.execute(uploadFile);

        System.out.println("status : " + response.getStatusLine());

        // TODO: for unit test
        //assertThat(response.getStatusLine().getStatusCode(), equalTo(200));

        HttpEntity responseEntity = response.getEntity();

        httpClient.close();
    }



    public void runMultiFile() throws IOException {

        //http://localhost:8086/api/upload-car
        String filePath = System.getProperty("user.home") + "/test/2_6.gif";
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost uploadFile = new HttpPost("http://localhost:8086/api/upload-car");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();

        // если составной объект который содержит MultipartFile[], то таким образом инициализируем другие поля
        builder.addTextBody("name", "yes", ContentType.MULTIPART_FORM_DATA);

        Car car = new Car();
        car.setModel("KamAZ 55102");

        Gson gson = new Gson();
        String json = gson.toJson(car);



        StringEntity entity = new StringEntity(json);
      //  uploadFile.setEntity(entity);
     //   uploadFile.setHeader("Accept", "application/json");
      //  uploadFile.setHeader("Content-type", "application/json");

        // This attaches the file to the POST:
        File f = new File(filePath);
        builder.addBinaryBody(
                "file ",
                new FileInputStream(f),
                ContentType.MULTIPART_FORM_DATA,
                f.getName()
        );

        HttpEntity multipart = builder.build();
        uploadFile.setEntity(multipart);
        CloseableHttpResponse response = httpClient.execute(uploadFile);
        HttpEntity responseEntity = response.getEntity();

    }

}
