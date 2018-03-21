package com.project.pmalek_project.repository.model.results.impl;

import com.project.pmalek_project.repository.model.results.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

///@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class LibraryActionResult implements Result {

    private int errorCode;
    private String errorDescription;

    public LibraryActionResult(){
        this.errorCode = 0;
        this.errorDescription = "SUCCES";
    }
    
    @Override
    public int getErrorCode() {
        return errorCode;
    }
    @Override
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    @Override
    public String getErrorDescription() {
        return errorDescription;
    }
    @Override
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
    
    
}
