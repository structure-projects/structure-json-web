package cn.structure.starter.web.restful.configuration;

import cn.structure.starter.web.restful.properties.RestfulWebConfigProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;


/**
 * <p>
 *     自动装载配置类
 * </p>
 * @author chuck
 * @since 2021-01-03
 * @version 1.0.1
 */
@Configuration
@ConditionalOnClass(value = {RestfulWebConfigProperties.class})
public class AutoConfiguration {

}
