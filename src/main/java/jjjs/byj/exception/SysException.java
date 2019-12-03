package jjjs.byj.exception;

/**
 * @author： BaYongJian
 * @date： 10.19  13:28
 */
public class SysException extends Exception{

    //异常提示信息
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SysException(String message){
        this.message = message;
    }
}
