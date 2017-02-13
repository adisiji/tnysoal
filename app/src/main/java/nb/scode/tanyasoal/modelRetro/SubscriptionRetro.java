package nb.scode.tanyasoal.modelRetro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by neobyte on 2/13/2017.
 */

public class SubscriptionRetro {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("max_active_days")
    @Expose
    private Integer maxActiveDays;
    @SerializedName("max_active_questions")
    @Expose
    private Integer maxActiveQuestions;
    @SerializedName("max_question_per_day")
    @Expose
    private Integer maxQuestionPerDay;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getMaxActiveDays() {
        return maxActiveDays;
    }

    public void setMaxActiveDays(Integer maxActiveDays) {
        this.maxActiveDays = maxActiveDays;
    }

    public Integer getMaxActiveQuestions() {
        return maxActiveQuestions;
    }

    public void setMaxActiveQuestions(Integer maxActiveQuestions) {
        this.maxActiveQuestions = maxActiveQuestions;
    }

    public Integer getMaxQuestionPerDay() {
        return maxQuestionPerDay;
    }

    public void setMaxQuestionPerDay(Integer maxQuestionPerDay) {
        this.maxQuestionPerDay = maxQuestionPerDay;
    }
}
