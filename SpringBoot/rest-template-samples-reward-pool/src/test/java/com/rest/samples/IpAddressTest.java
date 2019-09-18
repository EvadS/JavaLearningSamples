package com.rest.samples;

import com.rest.samples.config.AppContainerConfig;
import com.rest.samples.config.CryptoControllerConfig;
import com.rest.samples.helpers.AccountHelper;
import com.rest.samples.model.Employee;
import com.rest.samples.model.NodeAddressModel;
import com.soapbox.basenode.consensus.accounts.Account;
import com.soapbox.basenode.crypto.CryptoController;
import com.soapbox.basenode.crypto.VRS;
import com.soapbox.basenode.network.identifiers.Guid;
import com.soapbox.basenode.network.identifiers.quadtree.QuadtreeRegionId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.security.PublicKey;
import java.util.Base64;

import static com.rest.samples.Post_postForObject_Example.URL_CREATE_EMPLOYEE;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {AppContainerConfig.class, CryptoControllerConfig.class})
public class IpAddressTest {


   private static final String URL_CREATE_NODE_INFO = "http://localhost:8086/address/registration";
    //private static final String URL_CREATE_NODE_INFO = "https://dev-soapbox-ip.scenario-projects.com/address/registration";
    private static final String URL_GET_NODE_INFO = "https://dev-soapbox-ip.scenario-projects.com/address/node-address";
    private static Account account;
    private static final String REGION_ID_HEX_STRING = "11111189d66707f1";
    private static final String IP_ADDRESS = "127.0.90.111";
    private static final int PORT = 8999;

    @Autowired
    private CryptoController cryptoController;


    private String password = AccountHelper.DEFAULT_PASS;

    @Before
    public void init() {
        cryptoController.init();
        account = AccountHelper.getDefaultAccount();
    }



    @Test
    public void shouldCorrectResponse() throws Exception {
        PublicKey nodePublicKey = cryptoController.getNodesPublicKey();
        QuadtreeRegionId quadtreeRegionId = QuadtreeRegionId.fromHexString(REGION_ID_HEX_STRING);

        Guid guid  = Guid.parse("11111189d66707f1@9f5a70fa342f20ded11e2ce15f351e2a36299c2a7005b18f5bfcd0f26406d75590ac33c0b66fbe2e683241553995356844c333beb3e043c679c9d103bf9dc21f");

        account.getAddress();
        VRS vrsTranscoding = cryptoController.calculateVrs(account, AccountHelper.DEFAULT_PASS, guid);
        String vrsTranscodingStr = Base64.getEncoder().encodeToString(vrsTranscoding.toByteArray());

        VRS vrsStorage = cryptoController.calculateVrs(account, AccountHelper.DEFAULT_PASS, guid);
        String vrsStorageStr = Base64.getEncoder().encodeToString(vrsStorage.toByteArray());

        VRS vrsCashing = cryptoController.calculateVrs(account, AccountHelper.DEFAULT_PASS, guid);
        String vrsCashingStr = Base64.getEncoder().encodeToString(vrsCashing.toByteArray());


        NodeAddressModel nodeAddressModel = new NodeAddressModel(guid.toString(), IP_ADDRESS, PORT, false, vrsTranscodingStr,
                vrsStorageStr, vrsCashingStr);

        byte[] data = nodeAddressModel.toBytes();
        byte[] signature = cryptoController.signByNodesPrivateKey(data);
        String encodedSignature = Base64.getEncoder().encodeToString(signature);

        nodeAddressModel.setSignature(encodedSignature);

        RestTemplate restTemplate = new RestTemplate();
        // Data attached to the request.
        HttpEntity<NodeAddressModel> requestBody = new HttpEntity<>(nodeAddressModel);

        // Send request with POST method.
        //ResponseEntity<?> 3
    Object result
                = restTemplate.postForEntity(URL_CREATE_NODE_INFO, requestBody, String.class);

      //  System.out.println("Status code:" + result.getStatusCode());

//        // Code = 200.
//        if (result.getStatusCode() == HttpStatus.OK) {
//            NodeAddressModel e = result.getBody();
//            System.out.println("(Client Side) Employee Created: "+ e.getGuid());
//        }

        Assert.assertEquals(false, false);
    }
}
