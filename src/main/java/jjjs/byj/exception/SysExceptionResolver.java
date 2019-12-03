package jjjs.byj.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author： BaYongJian
 * @date： 10.19  13:24
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, Exception ex) {
        ex.printStackTrace();
        SysException e = null;
        //获取异常对象
        if(ex instanceof SysException){
            e = (SysException)ex;
        }else{
            e = new SysException("请联系管理员");
        }
        ModelAndView mv = new ModelAndView();
        //存入错误的提示信息
        mv.addObject("message",e.getMessage());
        //跳转的jsp页面
        mv.setViewName("Error/error");
        return mv;
    }
}
