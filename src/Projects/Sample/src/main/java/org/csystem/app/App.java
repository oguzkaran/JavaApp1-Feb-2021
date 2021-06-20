/*----------------------------------------------------------------------------------------------------------------------
    Özyinelemeli olarak dizinin dolaşılmasını da içeren DirectoryInfo sınıfı
    Sınıfın daha detaylı bir versiyonu için IOLib kütüphanesine bakınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;

class App {
    public static void main(String[] args)
    {
        if (args.length != 1) {
            Console.Error.writeLine("Wrong number of arguments");
            System.exit(1);
        }

        try {
            DirectoryInfo directoryInfo = new DirectoryInfo(args[0]);

            directoryInfo.walkDir(f -> Console.writeLine("%s %s", f.getName(), f.isDirectory() ? "<DIR>" : f.length() + ""));
        }
        catch (IOException ex) {
            Console.Error.writeLine("Message:%s", ex.getMessage());
        }
    }
}


final class DirectoryInfo {
    private final File m_dir;
    private long m_length;

    private void walkDir(File dir)
    {
        walkDir(dir, f -> m_length += f.length());
    }

    public void walkDir(File dir, Consumer<File> consumer)
    {
        for (File file : dir.listFiles()) {
            if (file.isDirectory())
                walkDir(file, consumer);

            consumer.accept(file);
        }
    }

    public DirectoryInfo(String path) throws IOException
    {
        m_dir = new File(path);

        if (!m_dir.isDirectory())
            throw new IOException(String.format("%s is not a directory", path));
    }

    public long length()
    {
        walkDir(m_dir);

        return m_length;
    }

    public void walkDir(Consumer<File> consumer)
    {
        walkDir(m_dir, consumer);
    }
}