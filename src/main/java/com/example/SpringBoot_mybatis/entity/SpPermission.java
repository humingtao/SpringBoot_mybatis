package com.example.SpringBoot_mybatis.entity;

import java.io.Serializable;

/**
 * 权限表(SpPermission)实体类
 *
 * @author makejava
 * @since 2020-03-29 00:13:23
 */
public class SpPermission implements Serializable {
    private static final long serialVersionUID = 249214858787391042L;
    
    private String psId;
    /**
    * 权限名称
    */
    private String psName;
    /**
    * 父id
    */
    private String psPid;
    /**
    * 控制器
    */
    private String psC;
    /**
    * 操作方法
    */
    private String psA;
    /**
    * 权限等级
    */
    private String psLevel;


    public String getPsId() {
        return psId;
    }

    public void setPsId(String psId) {
        this.psId = psId;
    }

    public String getPsName() {
        return psName;
    }

    public void setPsName(String psName) {
        this.psName = psName;
    }

    public String getPsPid() {
        return psPid;
    }

    public void setPsPid(String psPid) {
        this.psPid = psPid;
    }

    public String getPsC() {
        return psC;
    }

    public void setPsC(String psC) {
        this.psC = psC;
    }

    public String getPsA() {
        return psA;
    }

    public void setPsA(String psA) {
        this.psA = psA;
    }

    public String getPsLevel() {
        return psLevel;
    }

    public void setPsLevel(String psLevel) {
        this.psLevel = psLevel;
    }

}