package com.company;


import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;


public class scanrun {

    public static void main(String[] args) throws IOException, InterruptedException {

        WatchService watchService= FileSystems.getDefault().newWatchService();
        Path directory= Paths.get("C:\\dbms");
        // FileUtils.cleanDirectory(new File(String.valueOf(directory)));
        WatchKey watchKey = directory.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);
        int countmodified=0;
        int flag1=0;
        while (true) {
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                if(event.kind()==StandardWatchEventKinds.ENTRY_CREATE){ countmodified=0; flag1=1; }
                if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY ) countmodified++;

                // will redirect to next class for checking data....

                if(countmodified==1&&flag1==1) {
                    parser p = new parser();
                    WatchEvent<Path> ev = (WatchEvent<Path>) event;
                    Path filename = ev.context();
                    p.parsing(filename);
                }
                else if(countmodified>2||flag1==0) System.out.println("Please do in new file");



            }
        }
    }
}