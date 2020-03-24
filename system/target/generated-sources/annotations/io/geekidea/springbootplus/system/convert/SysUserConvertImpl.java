package io.geekidea.springbootplus.system.convert;

import io.geekidea.springbootplus.framework.shiro.vo.LoginSysUserVo;
import io.geekidea.springbootplus.system.entity.SysUser;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-24T16:13:47+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
public class SysUserConvertImpl implements SysUserConvert {

    @Override
    public LoginSysUserVo sysUserToLoginSysUserVo(SysUser sysUser) {
        if ( sysUser == null ) {
            return null;
        }

        LoginSysUserVo loginSysUserVo = new LoginSysUserVo();

        loginSysUserVo.setId( sysUser.getId() );
        loginSysUserVo.setUsername( sysUser.getUsername() );
        loginSysUserVo.setNickname( sysUser.getNickname() );
        loginSysUserVo.setGender( sysUser.getGender() );
        loginSysUserVo.setState( sysUser.getState() );
        loginSysUserVo.setDepartmentId( sysUser.getDepartmentId() );
        loginSysUserVo.setRoleId( sysUser.getRoleId() );

        return loginSysUserVo;
    }
}