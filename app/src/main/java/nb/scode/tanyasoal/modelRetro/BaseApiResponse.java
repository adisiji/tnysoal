package nb.scode.tanyasoal.modelRetro;

import com.google.gson.annotations.SerializedName;

/**
 * Created by neobyte on 2/13/2017.
 */

public class BaseApiResponse {

    @SerializedName("isSuccess")
    private Boolean isSuccess;

    @SerializedName("message")
    private String message;

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
