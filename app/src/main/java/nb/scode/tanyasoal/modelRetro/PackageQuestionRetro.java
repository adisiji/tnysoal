package nb.scode.tanyasoal.modelRetro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by neobyte on 2/13/2017.
 */

public class PackageQuestionRetro {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("start_operational_hour")
    @Expose
    private Integer startOperationalHour;
    @SerializedName("end_operational_hour")
    @Expose
    private Integer endOperationalHour;
    @SerializedName("interval_active_hour")
    @Expose
    private Integer intervalActiveHour;
    @SerializedName("using_text")
    @Expose
    private Integer usingText;
    @SerializedName("using_photo")
    @Expose
    private Integer usingPhoto;
    @SerializedName("using_video")
    @Expose
    private Integer usingVideo;
    @SerializedName("price_per_question")
    @Expose
    private Integer pricePerQuestion;
    @SerializedName("is_active")
    @Expose
    private Integer isActive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStartOperationalHour() {
        return startOperationalHour;
    }

    public void setStartOperationalHour(Integer startOperationalHour) {
        this.startOperationalHour = startOperationalHour;
    }

    public Integer getEndOperationalHour() {
        return endOperationalHour;
    }

    public void setEndOperationalHour(Integer endOperationalHour) {
        this.endOperationalHour = endOperationalHour;
    }

    public Integer getIntervalActiveHour() {
        return intervalActiveHour;
    }

    public void setIntervalActiveHour(Integer intervalActiveHour) {
        this.intervalActiveHour = intervalActiveHour;
    }

    public Integer getUsingText() {
        return usingText;
    }

    public void setUsingText(Integer usingText) {
        this.usingText = usingText;
    }

    public Integer getUsingPhoto() {
        return usingPhoto;
    }

    public void setUsingPhoto(Integer usingPhoto) {
        this.usingPhoto = usingPhoto;
    }

    public Integer getUsingVideo() {
        return usingVideo;
    }

    public void setUsingVideo(Integer usingVideo) {
        this.usingVideo = usingVideo;
    }

    public Integer getPricePerQuestion() {
        return pricePerQuestion;
    }

    public void setPricePerQuestion(Integer pricePerQuestion) {
        this.pricePerQuestion = pricePerQuestion;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
}
