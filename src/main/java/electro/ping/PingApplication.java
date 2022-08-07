package electro.ping;

import electro.ping.service.PingService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PingApplication implements CommandLineRunner {

    @Autowired
    private PingService ps;

    public static void main(String[] args) {
        SpringApplication.run(PingApplication.class, args);
    }
    
    
    @Override
    public void run(String[] args) throws IOException, InterruptedException {
    ps.sendPing();
        
    }
    

}
