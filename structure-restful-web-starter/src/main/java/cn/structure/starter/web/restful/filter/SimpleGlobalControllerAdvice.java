package cn.structure.starter.web.restful.filter;

import cn.structure.common.entity.ResResultVO;
import cn.structure.common.entity.ResultVO;
import cn.structure.common.enums.ErrorCodeEnum;
import cn.structure.common.enums.ResultCodeEnum;
import cn.structure.common.exception.CommonException;
import cn.structure.starter.web.restful.exception.SystemException;
import cn.structure.starter.web.restful.exception.ThirdPartyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 简易公共异常处理
 * </p>
 *
 * @author chuck
 * @version 1.0.1
 * @since 2021/1/3 20:59
 */
@Slf4j
@ControllerAdvice
public class SimpleGlobalControllerAdvice {

    /**
     * 全局异常捕捉处理
     *
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResResultVO exceptionHandler(Exception ex) {
        log.error("全局未知异常捕获======》", ex);
        return ResResultVO.exception(ResultCodeEnum.ERR.getCode(),ex.getMessage());
    }

    /**
     * 全局异常捕捉处理
     */
    @ResponseBody
    @ExceptionHandler(value = Throwable.class)
    public ResResultVO errorHandler(Throwable ex) {
        log.error("全局未知异常捕获======》", ex);
        return ResResultVO.exception(ResultCodeEnum.ERR.getCode(),ex.getMessage());
    }

    /**
     * 业务自定义异常
     */
    @ResponseBody
    @ExceptionHandler(value = CommonException.class)
    public ResResultVO structureErrorHandler(CommonException ex) {
        log.error("全局业务异常捕捉======》", ex);
        return ResResultVO.fail(ex.getCode(), ex.getMsg());
    }
}
