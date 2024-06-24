package com.yupi.springbootinit.common;

import java.io.Serializable;
import lombok.Data;

/**
 * 通用返回类    通用
 *
 * @param <T>
 */
@Data
public class BaseResponse<T> implements Serializable {    //定义了一个泛型类 BaseResponse，它实现了 Serializable 接口，表示该类可以被序列化

    private int code;

    private T data;       //泛型字段，通过泛型 T 可以灵活适配不同类型的返回数据。

    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }
    //有参构造方法，用于创建一个指定状态码、数据和消息的 BaseResponse 对象

    public BaseResponse(int code, T data) {
        this(code, data, "");
    }
       //简化的有参构造方法，用于创建一个指定状态码和数据的 BaseResponse 对象，并将消息设置为空字符串。

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage());
    }

    //这是另一个构造方法，接受一个 ErrorCode 枚举类型的参数，用于创建一个状态码和消息由枚举提供的 BaseResponse 对象。
}

//用构造    直接调用
//public BaseResponse<User> getUserInfo(int userId) {
//    User user = userService.getUserById(userId);
//    if (user != null) {
//        return new BaseResponse<>(200, user, "获取用户信息成功");
//    } else {
//        return new BaseResponse<>(404, null, "用户不存在");
//    }
//}



//创建了一个 BaseResponse 对象，然后分别设置了状态码、数据和消息
//public BaseResponse<User> getUserInfo(int userId) {
//    User user = userService.getUserById(userId);


//    BaseResponse<User> response = new BaseResponse<>();


//    if (user != null) {
//        response.setCode(200);
//        response.setData(user);
//        response.setMessage("获取用户信息成功");
//    } else {
//        response.setCode(404);
//        response.setData(null);
//        response.setMessage("用户不存在");
//    }
//    return response;
//}