package cn.link.frame.druid.muldatasource;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.util.DruidPasswordCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class DBPasswordDecoder extends DruidPasswordCallback {

    private Logger logger = LoggerFactory.getLogger(DBPasswordDecoder.class);

    private String publicKey;
    private String ciphertext;

    public DBPasswordDecoder(String publicKey, String ciphertext) {
        super();
        this.publicKey = publicKey;
        this.ciphertext = ciphertext;
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        try {
            String password = ConfigTools.decrypt(publicKey, ciphertext);
            logger.debug("decode success and password is {}", password);
            setPassword(password.toCharArray());
        } catch (Exception e) {
            logger.warn("try decode fail");
        }
    }

}
