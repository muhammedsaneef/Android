package RetrofitClass;

/**
 * Created by saneef on 26/9/16.
 */
public class ProfileData {

    String firstContent;
    String secondContent;

    public ProfileData(String firstContent, String secondContent) {
        this.firstContent = firstContent;
        this.secondContent = secondContent;
    }

    public String getFirstContent() {
        return firstContent;
    }

    public void setFirstContent(String firstContent) {
        this.firstContent = firstContent;
    }

    public String getSecondContent() {
        return secondContent;
    }

    public void setSecondContent(String secondContent) {
        this.secondContent = secondContent;
    }
}
