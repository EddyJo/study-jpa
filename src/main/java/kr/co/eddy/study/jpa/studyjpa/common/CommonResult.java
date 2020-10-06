package kr.co.eddy.study.jpa.studyjpa.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResult {

    private boolean success;
    private int resultCode;
    private String resultMessage;

}
