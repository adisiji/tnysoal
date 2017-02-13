package nb.scode.tanyasoal.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neobyte on 1/28/2017.
 */

public class Academics {

    private List<AcademicLevels> academicLevels = new ArrayList<>();
    private List<AcademicTypes> academicTypes = new ArrayList<>();

    public List<AcademicLevels> getAcademicLevelList() {
        return academicLevels;
    }

    public void setAcademicLevelList(List<AcademicLevels> academicLevels) {
        this.academicLevels = academicLevels;
    }

    public List<AcademicTypes> getAcademicTypeList() {
        return academicTypes;
    }

    public void setAcademicTypeList(List<AcademicTypes> academicTypes) {
        this.academicTypes = academicTypes;
    }
}
