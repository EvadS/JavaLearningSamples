package com.se.sample;


import com.sun.deploy.net.HttpResponse;
import sun.net.www.http.HttpClient;


import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class SimplePostRequestTest {
    public void run (){


        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

            FileBody uploadFilePart = new FileBody(uploadFile);
            MultipartEntity reqEntity = new MultipartEntity();
            reqEntity.addPart("upload-file", uploadFilePart);
            httpPost.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(httpPost);

        } catch (ClientProtocolException e) {

        } finally {
            httpclient.getConnectionManager().shutdown();
        }
    }
}
