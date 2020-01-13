package fn.service.core.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel
public class SecretDoorResponse {
    @ApiModelProperty
    private String message;

    protected SecretDoorResponse() {}


    public SecretDoorResponse(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}