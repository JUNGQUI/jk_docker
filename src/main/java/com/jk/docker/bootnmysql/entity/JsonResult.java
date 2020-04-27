package com.jk.docker.bootnmysql.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class JsonResult {

    private boolean success;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public static JsonResult success (Object data) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setData(data);

        return jsonResult;
    }

    public static JsonResult success () {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);

        return jsonResult;
    }

    public static JsonResult fail (String message) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(false);
        jsonResult.setMessage(message);

        return jsonResult;
    }
}
