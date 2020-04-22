/**
 * 
 */
package com.example.demo.service.domain;

import java.io.Serializable;

/**
 * 复杂请求对象
 * 
 * @author harold
 *
 */
public class ComplexReqDto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    Long id;
    String name;
    Integer level;
    Boolean isMarried;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    public Boolean getIsMarried() {
        return isMarried;
    }
    public void setIsMarried(Boolean isMarried) {
        this.isMarried = isMarried;
    }
    

}
