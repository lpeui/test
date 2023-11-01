package invaders;

public class DifficultyLevel {

    public enum Level {
        EASY("config_easy.json"),
        MEDIUM("config_medium.json"),
        HARD("config_hard.json");

        private String configFile;

        Level(String configFile) {
            this.configFile = configFile;
        }

        public String getConfigFile() {
            return configFile;
        }
    }

    private static DifficultyLevel instance = null;
    private Level currentLevel;

    private DifficultyLevel(Level level) {
        this.currentLevel = level;
    }

    public static DifficultyLevel getInstance(Level level) {
        if(instance == null) {
            instance = new DifficultyLevel(level);
        }
        return instance;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }
}
