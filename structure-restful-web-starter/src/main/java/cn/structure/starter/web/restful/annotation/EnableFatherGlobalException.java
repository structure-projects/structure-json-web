package cn.structure.starter.web.restful.annotation;

import cn.structure.starter.web.restful.filter.FastJsonHttpMessageConverters;
import cn.structure.starter.web.restful.filter.FatherAndSonGlobalBadRequestExceptionHandler;
import cn.structure.starter.web.restful.filter.FatherAndSonGlobalControllerAdvice;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * <p>
 *     自动装配父子关系的异常处理
 * </p>
 * @author chuck
 * @since 2021-01-03
 * @version 1.0.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(value = {FatherAndSonGlobalBadRequestExceptionHandler.class, FatherAndSonGlobalControllerAdvice.class})
public @interface EnableFatherGlobalException {
}
