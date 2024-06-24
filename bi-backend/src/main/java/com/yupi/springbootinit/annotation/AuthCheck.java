package com.yupi.springbootinit.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 权限校验
 */
@Target(ElementType.METHOD)      //元注解，指明该注解可以用于方法上
@Retention(RetentionPolicy.RUNTIME)    //元注解，指定了该注解在运行时可见，这意味着可以通过反射机制来读取该注解信息
public @interface AuthCheck {     //这定义了一个名为 AuthCheck 的注解，它可以被应用于方法上。

    /**
     * 必须有某个角色
     *
     * @return
     */
    String mustRole() default "";

    //该注解的一个属性，名为 mustRole，它用于指定在执行方法时必须具备的角色。
    // 默认情况下，它的值为空字符串，这意味着如果没有指定角色，则不进行角色校验。

}

//该注解的使用方式是将其应用于需要进行权限校验的方法上，并通过 mustRole 属性指定必须具备的角色。例如：
//

//java
//Copy code
//@AuthCheck(mustRole = "admin")
//public void someMethod() {
//    // 这里是需要权限校验的方法体
//}

//上面的代码表示 someMethod() 方法需要具备 "admin" 角色才能执行，否则将会被拒绝访问。