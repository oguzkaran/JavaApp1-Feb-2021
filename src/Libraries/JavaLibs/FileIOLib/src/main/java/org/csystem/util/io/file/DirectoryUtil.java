package org.csystem.util.io.file;

import java.io.IOException;
import java.nio.file.*;

public class DirectoryUtil {
    private DirectoryUtil()
    {
    }

    public static void watchDirectory(String pathStr, IConsumer<WatchEvent<?>> consumer, WatchEvent.Kind<?>... events)
            throws Exception
    {
        Path path = Path.of(System.getProperty(pathStr));
        WatchService watchService = FileSystems.getDefault().newWatchService();

        path.register(
                watchService, events);

        WatchKey key;

        while ((key = watchService.take()) != null) {
            while ((key = watchService.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents())
                    consumer.accept(event);
                key.reset();
            }
        }
    }
}
