package com.ig.intellimeet.impl ;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import java.util.ArrayList;


public class NavigationByTagsComponent {


    java.util.List<String> tagList;
    String path;
    String tags;


    public NavigationByTagsComponent(Resource resource) {
        ValueMap properties = resource.adaptTo(ValueMap.class);

        this.tagList=getTagList(resource);

    }

     public java.util.List<String> getTagList(Resource resource) {
        if ( resource == null) {
            return null;
        }
        ResourceResolver resourceResolver = resource.getResourceResolver();
        ValueMap parValMap = org.apache.sling.api.resource.ResourceUtil.getValueMap(resource.getParent());
        java.util.List<String> tagValue = new ArrayList<String>();
        String [] cqtags = parValMap.get("cq:tags", String[].class);
        for(String eachtag:cqtags) {
            tagValue.add(eachtag);
        }
        return tagValue;
    }
}
