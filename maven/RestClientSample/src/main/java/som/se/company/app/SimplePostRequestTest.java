package som.se.company.app;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SimplePostRequestTest {


    private final String corda_Address = "http://localhost:8899/contracts/uploadAttachment";

    private final String my_test_server = "http://localhost:8086";
    private final String upload_attach_Api = "/upload-attachments";

    /**
     * заюзать  этот метод для кордЫ
     *
     * @throws IOException
     */
    public void multipartFileUploadToCorda() throws IOException {

        String filePath = System.getProperty("user.home") + "/test/2_6.gif";

        byte[] bFile2 = Files.readAllBytes(new File(filePath).toPath());
        //or this
        byte[] bFile = Files.readAllBytes(Paths.get(filePath));


        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = corda_Address;
        //String.format("%s%s",my_test_server,upload_attach_Api);

        HttpPost uploadFile = new HttpPost(url);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();

        // This attaches the file to the POST:
        File f = new File(filePath);
        builder.addBinaryBody(
                "file",
                bFile,
                ContentType.MULTIPART_FORM_DATA,
                f.getName()
        );

        HttpEntity multipart = builder.build();
        uploadFile.setEntity(multipart);
        CloseableHttpResponse response = httpClient.execute(uploadFile);

        System.out.println("status : " + response.getStatusLine());

        HttpEntity responseEntity = response.getEntity();

        String content = EntityUtils.toString(responseEntity);

      /*  String inputLine;
        BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        try {
            while ((inputLine = br.readLine()) != null) {
                System.out.println(inputLine);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String responseXml = EntityUtils.toString(response.getEntity());
        EntityUtils.consume(response.getEntity());

        String res = EntityUtils.toString(response.getEntity(), "UTF-8");
        */
    }

    /**
     * upload api get param like org.springframework.web.multipart.MultipartFile
     * worked
     *
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
