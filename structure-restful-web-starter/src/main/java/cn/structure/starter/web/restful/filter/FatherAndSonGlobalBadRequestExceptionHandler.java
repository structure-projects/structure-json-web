package cn.structure.starter.web.restful.filter;

import cn.structure.common.entity.ResultVO;
import cn.structure.common.entity.VerificationFailedMsg;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     参数校验异常
 * </p>
 * @author chuck
 * @since 2021-01-03
 * @version 1.0.1
 */
@Slf4j
@RestControllerAdvice
public class FatherAndSonGlobalBadRequestExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(FatherAndSonGlobalBadRequestExceptionHandler.class);

    /**
     * 校验错误拦截处理
     *
     * @param exception 错误信息集合
     * @return 错误信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO validationBodyException(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        List<VerificationFailedMsg> verificationFailedMsgArrayList = new ArrayList<>();
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            errors.forEach(p -> {
                FieldError fieldError = (FieldError) p;
                logger.error("Data check failure : object{" + fieldError.getObjectName() + "},field{" + fieldError.getField() +
                        "},errorMessage{" + fieldError.getDefaultMessage() + "}");
                VerificationFailedMsg vfs = new VerificationFailedMsg();
                vfs.setField(fieldError.getField());
                vfs.setErrorMessage(fieldError.getDefaultMessage());
                verificationFailedMsgArrayList.add(vfs);
            });
        }
        return ResultVO.verificationFailed(verificationFailedMsgArrayList);
    }

    /**
     * 参数类型转换错误
     *
     * @param exception 错误
     * @return 错误信息
     */
    @ExceptionHandler(HttpMessageConversionException.class)
    public ResultVO parameterTypeException(HttpMessageConversionException exception) {
        logger.error(exception.getCause().getLocalizedMessage());
        return ResultVO.fail("类型转换错误");
    }

}