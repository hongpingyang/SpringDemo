package com.hong.py.serviceImpl;

import com.hong.py.service.IAccountService;

import java.util.*;

public class AccountServiceImpl3 implements IAccountService {

    private List<String> mylist;
    private String[] myStrs;
    private Set<String> mySets;
    private Map<String,String> myMaps;
    private Properties properties;

    public void AddAccount() {
        System.out.println(Arrays.toString(myStrs));
        System.out.println(mylist);
        System.out.println(mySets);
        System.out.println(myMaps);
        System.out.println(properties);
    }


    public List<String> getMylist() {
        return mylist;
    }

    public void setMylist(List<String> mylist) {
        this.mylist = mylist;
    }

    public String[] getMyStrs() {
        return myStrs;
    }

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public Set<String> getMySets() {
        return mySets;
    }

    public void setMySets(Set<String> mySets) {
        this.mySets = mySets;
    }

    public Map<String, String> getMyMaps() {
        return myMaps;
    }

    public void setMyMaps(Map<String, String> myMaps) {
        this.myMaps = myMaps;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
