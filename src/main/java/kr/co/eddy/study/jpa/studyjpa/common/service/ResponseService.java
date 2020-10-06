package kr.co.eddy.study.jpa.studyjpa.common.service;

import kr.co.eddy.study.jpa.studyjpa.common.CommonResult;
import kr.co.eddy.study.jpa.studyjpa.common.ListResult;
import kr.co.eddy.study.jpa.studyjpa.common.SingleResult;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    @Getter
    public enum CommonResponse {
        SUCCESS(0000, "SUCCESS"),
        FAIL(9999, "FAIL");

        int resultCode;
        String resultMessage;

        CommonResponse(int resultCode, String resultMessage) {
            this.resultCode = resultCode;
            this.resultMessage = resultMessage;
        }
    }

    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        seSuccessResult(result);
        return result;
    }

    public <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> result = new ListResult<>();
        result.setList(list);
        seSuccessResult(result);
        return result;
    }

    private void seSuccessResult(CommonResult result) {
        result.setSuccess(true);
        result.setResultCode(CommonResponse.SUCCESS.getResultCode());
        result.setResultMessage(CommonResponse.SUCCESS.getResultMessage());
    }

}
