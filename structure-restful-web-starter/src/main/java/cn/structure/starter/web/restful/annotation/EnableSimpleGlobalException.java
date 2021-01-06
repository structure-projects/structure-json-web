package cn.structure.starter.web.restful.annotation;

import cn.structure.starter.web.restful.filter.SimpleGlobalBadRequestExceptionHandler;
import cn.structure.starter.web.restful.filter.SimpleGlobalControllerAdvice;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * <p>
 *     自动装配简易的异常处理
 * </p>
 * @author chuck
 * @since 2021-01-03
 * @version 1.0.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(value = {SimpleGlobalBadRequestExceptionHandler.class,SimpleGlobalControllerAdvice.class})
public @interface EnableSimpleGlobalException {

}
