package com.bisa.shop.client.core;

import org.apache.shiro.authz.Permission;
import java.util.Collection;

/**
 * 获取用户角色所对应的 权限,
 * CAS单点登入已经返回用户的所有权限其中报告角色的权限
 * @author Administrator
 *
 */
public class RolePermissionResolver implements org.apache.shiro.authz.permission.RolePermissionResolver {
    @Override
    public Collection<Permission> resolvePermissionsInRole(String roleString) {
        return null;
    }
}
