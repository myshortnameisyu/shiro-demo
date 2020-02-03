package cn.shiro.common;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.Realm;

public class ShiroRealm extends AuthenticatingRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.把AuthenticationToken转换为UsernamePasswordToken
        UsernamePasswordToken token =(UsernamePasswordToken) authenticationToken;
        //2.从UsernamePasswordToken中获取username
        String username = token.getUsername();
        //3.调用数据库的方法查询对应的username对应的用户记录
        System.out.println("从数据库获取的username："+username+"对应的用户信息。");
        //4.若用户不存在，则可以抛出UnKnownAccountException异常
        if ("unknow".equals(username)){
            throw  new UnknownAccountException("用户不存在");
        }
        //5.根据用户的信息情况，确定是否需要抛出其他AuthenticationException异常
        if ("monster".equals(username)){
            throw  new LockedAccountException("用户被锁定");
        }
        //6.根据用户的情况,来构建 AuthenticationInfo 对象并返回 通常使用的实现类为SimpleAuthenticationInfo
        //以下信息是从数据库中获取的.
        //1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
        Object principal = username;
        //2). credentials: 密码.
        Object credentials = "123456";
        //3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
        String realmName = getName();
        SimpleAuthenticationInfo info =new SimpleAuthenticationInfo(principal,credentials,realmName);
        return info;
    }
}
