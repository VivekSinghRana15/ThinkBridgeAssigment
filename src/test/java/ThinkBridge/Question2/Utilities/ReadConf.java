package ThinkBridge.Question2.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConf{

        Properties prop;

        public ReadConf(){
            File src = new File("src/Configurations/config.properties");

            try {
                FileInputStream fis = new FileInputStream(src);
                prop = new Properties();
                prop.load(fis);
            } catch (Exception e) {
                System.out.println("The exception in loading properties file is: " + e);
            }
        }

        public String getApplicationURL() {
            return prop.getProperty("demoURL");
        }


}
