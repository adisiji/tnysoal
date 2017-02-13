package nb.scode.tanyasoal.modelRetro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by neobyte on 2/13/2017.
 */

public class QuestionRetro {

    @SerializedName("lessons")
    @Expose
    private List<Lesson> lessons = null;
    @SerializedName("packages")
    @Expose
    private List<PackageQuestionRetro> packages = null;

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<PackageQuestionRetro> getPackages() {
        return packages;
    }

    public void setPackages(List<PackageQuestionRetro> packages) {
        this.packages = packages;
    }
}
