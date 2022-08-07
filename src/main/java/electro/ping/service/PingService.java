/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electro.ping.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import electro.ping.model.Appliance;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
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

    public String getRandomStatus() {
        String[] s = {"Connected", "Disconnected"};

        Random ran = new Random();
        String s_ran = s[ran.nextInt(s.length)];

        return s_ran;
    }

    public void sendPing() {

        final String uri = apiPath + "/api/status/list";

        String result = "";
        String jsonData = "";
        Appliance[] apl = null;

        try {

            ResponseEntity<Appliance[]> response
                    = restTemplate.getForEntity(
                            uri,
                            Appliance[].class);
            apl = response.getBody();

            System.out.println(apl);
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

            while (true) {
                System.out.println(new Date());

                for (Appliance item : apl) {
                    String aid = item.getId();
                    String stat = getRandomStatus();
                    String uri2 = apiPath + "/api/status/upd/"+aid+"/"+stat;
                    System.out.println(uri2);
                    restTemplate.getForEntity(
                            uri2,Object.class);
                    
                }

                Thread.sleep(10 * 1000);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
