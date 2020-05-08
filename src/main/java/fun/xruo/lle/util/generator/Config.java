package fun.xruo.lle.util.generator;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author kevin
 */
@Data
@ConfigurationProperties("my.framework")
public class Config {
    private String group;
    private String artifact;
    private String module;

    public String getPackageName() {
        return group + '.' + artifact + '.' + module;
    }
}
