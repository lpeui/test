package invaders;

public class DifficultyLevel {
    // Enum to represent the different difficulty levels, each with a configuration file
    public enum Level {
        EASY("config_easy.json"),
        MEDIUM("config_medium.json"),
        HARD("config_hard.json");

        private String configFile;
        // Constructor for enum to set the config file for each level
        Level(String configFile) {
            this.configFile = configFile;
        }
        // Getter for the config file associated with the level
        public String getConfigFile() {
            return configFile;
        }
    }
    // Static instance for the singleton pattern
    private static DifficultyLevel instance = null;
    private Level currentLevel;

    private DifficultyLevel(Level level) {
        this.currentLevel = level;
    }
    // Static method to get the singleton instance or create it if it doesn't exist
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
