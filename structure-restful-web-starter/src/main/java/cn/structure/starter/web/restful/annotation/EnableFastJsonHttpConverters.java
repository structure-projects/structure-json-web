package cn.structure.starter.web.restful.annotation;

import cn.structure.starter.web.restful.filter.FastJsonHttpMessageConverters;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * <p>
 *     开启fastJson出参转换
 * </p>
 * @author chuck
 * @since 2021-01-03
 * @version 1.0.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(FastJsonHttpMessageConverters.class)
public @interface EnableFastJsonHttpConverters {

    boolean longToString() default false;

    boolean nullShowValue() default false;


}
