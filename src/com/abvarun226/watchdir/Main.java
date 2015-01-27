package com.abvarun226.watchdir;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bharghav on 10/13/14.
 */

public class Main {
    public static void main(String[] args) {

        Path watchDir = Paths.get("/Users/bharghav/tools");

        try (WatchService service = FileSystems.getDefault().newWatchService()) {

            Map<WatchKey,Path> keyMap = new HashMap<>();
            keyMap.put(watchDir.register(service,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY),
                    watchDir);

            WatchKey watchKey;

            do {

                watchKey = service.take();
                Path eventDir = keyMap.get(watchKey);

                for (WatchEvent<?> event : watchKey.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    Path eventPath = (Path) event.context();
                    System.out.println(eventDir + " : " + kind + " : " + eventPath);
                }

            } while(watchKey.reset());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
