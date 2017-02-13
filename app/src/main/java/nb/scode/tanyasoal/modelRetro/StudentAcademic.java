
package nb.scode.tanyasoal.modelRetro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentAcademic {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("academic_level_id")
    @Expose
    private Integer academicLevelId;
    @SerializedName("academic_type_id")
    @Expose
    private Integer academicTypeId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("school_name")
    @Expose
    private String schoolName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAcademicLevelId() {
        return academicLevelId;
    }

    public void setAcademicLevelId(Integer academicLevelId) {
        this.academicLevelId = academicLevelId;
    }

    public Integer getAcademicTypeId() {
        return academicTypeId;
    }

    public void setAcademicTypeId(Integer academicTypeId) {
        this.academicTypeId = academicTypeId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

}
