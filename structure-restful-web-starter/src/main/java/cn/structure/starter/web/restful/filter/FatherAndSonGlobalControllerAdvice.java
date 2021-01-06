package cn.structure.starter.web.restful.filter;

import cn.structure.common.entity.ResultVO;
import cn.structure.common.enums.ErrorCodeEnum;
import cn.structure.common.exception.CommonException;
import cn.structure.starter.web.restful.exception.SystemException;
import cn.structure.starter.web.restful.exception.ThirdPartyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * <p>
 *     ResultVO 全局异常处理
 * </p>
 * @author chuck
 * @since 2020-01-03
 * @version 1.0.1
 */
@Slf4j
@ControllerAdvice
public class FatherAndSonGlobalControllerAdvice {

    /**
     * 全局异常捕捉处理
     *
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultVO exceptionHandler(Exception ex) {
        log.error("全局未知异常捕获======》", ex);
        return ResultVO.exception(ErrorCodeEnum.SYSTEM_ERROR.getErrorType(),"500",ex.getMessage());
    }

    /**
     * 全局异常捕捉处理
     */
    @ResponseBody
    @ExceptionHandler(value = Throwable.class)
    public ResultVO errorHandler(Throwable ex) {
        log.error("全局未知异常捕获======》", ex);
        return ResultVO.exception(ErrorCodeEnum.SYSTEM_ERROR.getErrorType(), "500", ex.getMessage());
    }

    /**
     * 业务自定义异常
     */
    @ResponseBody
    @ExceptionHandler(value = CommonException.class)
    public ResultVO structureErrorHandler(CommonException ex) {
        log.error("全局业务异常捕捉======》", ex);
        return ResultVO.fail( ex.getCode(), ex.getMsg());
    }

    /**
     * 第三方异常
     */
    @ResponseBody
    @ExceptionHandler(value = ThirdPartyException.class)
    public ResultVO thirdPartyErrorHandler(ThirdPartyException ex) {
        log.error("全局第三方异常捕捉======》", ex);
        return ResultVO.exception(ErrorCodeEnum.THIRD_PARTY_ERROR.getErrorType(), ex.getCode(), ex.getMsg());
    }

    /**
     * 系统异常
     */
    @ResponseBody
    @ExceptionHandler(value = SystemException.class)
    public ResultVO systemErrorHandler(SystemException ex) {
        log.error("全局系统异常捕捉======》", ex);
        return ResultVO.exception(ErrorCodeEnum.SYSTEM_ERROR.getErrorType(), ex.getCode(), ex.getMsg());
    }
}
