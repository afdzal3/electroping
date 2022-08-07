/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electro.ping.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author afdzal
 */
@Service
public class PingService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${api.path}")
    private String apiPath;

    public void sendPing() {

        final String uri = apiPath + "/api/status/list";

        String result = "";
        String jsonData = "";

        try {
            jsonData = restTemplate.getForObject(uri, String.class);
            System.out.println(jsonData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

            while (true) {
                System.out.println(new Date());
                Thread.sleep(1 * 1000);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
