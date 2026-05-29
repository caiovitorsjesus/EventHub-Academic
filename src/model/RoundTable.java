package model;

import utils.ValidationUtils;

public class RoundTable extends Activity {

    private String theme;
    private String moderator;

    public RoundTable(String code, String title, int workloadHours, int maxCapacity, Speaker speaker, String theme, String moderator) {
        super(code, title, workloadHours, maxCapacity, speaker);
        setTheme(theme);
        setModerator(moderator);
    }

    @Override
    public double calculateCost() {
        return 25.0;
    }

    @Override
    public String getActivityType() {
        return "Round Table";
    }

    public String getTheme() {
        return theme;
    }

    public String getModerator() {
        return moderator;
    }

    public void setTheme(String theme) {
        ValidationUtils.validateText(theme, "Theme");
        this.theme = theme;
    }

    public void setModerator(String moderator) {
        ValidationUtils.validateText(moderator, "Moderator");
        this.moderator = moderator;
    }

    @Override
    public String toString() {
        return "RoundTable: " +
                "code='" + getCode() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", theme='" + theme + '\'' +
                ", moderator='" + moderator + '\'';
    }
}