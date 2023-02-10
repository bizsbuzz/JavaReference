package com.ip.general;/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import com.google.common.base.Strings;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * https://howtodoinjava.com/log4j2/log4j2-xml-configuration-example/
 *
 * @author iprasla
 */


public class Playground {

    //
    private static final Logger logger = LoggerFactory.getLogger(Playground.class);


//    public static void main(String[] args) {
//        Playground app = new Playground();
//        StopWatch watch = new StopWatch();
//
//        Function fn = Function.ARRAYS;
//
//        switch (fn) {
//            case LOGFILE: {
//
//                zipLogFiles(app.getLogFiles("DATA_PROCESSING", "C:\\birst\\Repositories\\data\\fd5b8a85-4f79-4535-bcac-4b96026cee15", String.format("%010d", 11)));
//                break;
//            }
//            case READFILEBYTOKEN: {
//                String filePath1 = "C:\\\\birst\\\\Repositories\\\\data\\\\fd5b8a85-4f79-4535-bcac-4b96026cee15\\\\logs\\\\smiengine.PSC01-BQUC-S010.0000000011.log";
//                System.out.println(readFilebyToken(filePath1, "acbu793twywj4e"));
//                break;
//
//            }
//            case HASTOE: {
//
//                watch.start();
//                System.out.println("Is Toe acbu793twywj4e matching? " + hasToe("C:\\birst\\Repositories\\data\\fd5b8a85-4f79-4535-bcac-4b96026cee15\\logs\\smiengine.PSC01-BQUC-S010.0000000011.log", "acbu793twywj4e"));
//                watch.stop();
//                System.out.println("Time Elapsed: " + watch.getTime());
//                watch.reset();
//                watch.start();
//                System.out.println("Is Toe acbu793twywj4e matching? " + hasToe("C:\\birst\\Repositories\\data\\fd5b8a85-4f79-4535-bcac-4b96026cee15\\logs\\smiengine.PSC01-BQUC-S012.0000000011.log", "acbu793twywj4e"));
//                watch.stop();
//                System.out.println("Time Elapsed: " + watch.getTime());
//                watch.reset();
//                watch.start();
//                System.out.println("Is Toe acbu793twywj4e matching? " + hasToe("C:\\birst\\Repositories\\data\\fd5b8a85-4f79-4535-bcac-4b96026cee15\\logs\\smiengine.PSC01-BQUC-S0122.0000000011.log", "acbu793twywj4e"));
//                watch.stop();
//                System.out.println("Time Elapsed: " + watch.getTime());
//                break;
//
//            }
//            case ISNULLOREMPTY: {
//
//                String filePath1 = "C:\\\\birst\\\\Repositories\\\\data\\\\fd5b8a85-4f79-4535-bcac-4b96026cee15\\\\logs\\\\smiengine.PSC01-BQUC-S010.0000000011.log";
//                System.out.println(isNullOREmpty("acbu793twywj4e"));
//                System.out.println(isNullOREmpty(""));
//                System.out.println(isNullOREmpty(null));
//
//                System.out.println(isNullOREmpty(new File(filePath1), "acbu793twywj4e"));
////			System.out.println(isNullOREmpty("","acbu793twywj4e"));
//                System.out.println(isNullOREmpty(null, "acbu793twywj4e"));
//
//                System.out.println("  ".isBlank());
//                System.out.println("  ".isEmpty());
//
//                break;
//
//            }
//            case ARRAYS: {
//                multidimensionalArrays();
//                break;
//
//            }
//            default:
//                throw new IllegalArgumentException("Unexpected value: " + fn);
//        }
//
//    }

    public void multidimensionalArrays() {
        int[][] twoDimensionalArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(String.format("Array[%d][%d]: ", i, j) + twoDimensionalArray[i][j]);
            }
        }

        int[][][] threeDArray = {
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                },
                {
                        {10, 11, 12},
                        {13, 14, 15},
                        {16, 17, 18}
                },
                {
                        {19, 20, 21},
                        {22, 23, 24},
                        {25, 26, 27}
                }
        };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.println("3DArray[" + i + "][" + j + "][" + k + "] = " + threeDArray[i][j][k]);
                }
            }
        }
        // Access the values in the array
//        for (int[] innerArray : twoDimensionalArray) {
//            for (int value : innerArray) {
//                System.out.println("value = " + value);
//            }
//        }

    }

    public void zipLogFiles(File[] logFiles) {

        if (logFiles.length > 0) {

            FileOutputStream fos = null;
            ZipOutputStream zipOut = null;
            try {
                fos = new FileOutputStream(Paths.get(logFiles[0].getAbsolutePath()).getParent().toAbsolutePath() + "/compressed.zip");

                zipOut = new ZipOutputStream(fos);

                for (File srcFile : logFiles) {
                    FileInputStream fis = new FileInputStream(srcFile);
//          ZipEntry zipEntry = new ZipEntry(srcFile.getName());
                    zipOut.putNextEntry(new ZipEntry("publishing" + (srcFile.toString().contains(".catch.up.log") ? ".catch.up.log" : ".log")));
                    IOUtils.copy(fis, zipOut);
                    fis.close();

                    zipOut.closeEntry();
                }

                fos.close();

            } catch (IOException e) {
                logger.error(e.getMessage());
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }

    public File[] getLogFiles(String jobType, String spaceDir, String id) {
        final Pattern logPattern;
        Path logDir = null;

        if (jobType.equals("DATA_PROCESSING")) {
            logDir = Paths.get(spaceDir + File.separator + "logs");
            logPattern = Pattern.compile("smiengine.*\\." + id + "(\\.catch\\.up)?\\.log");
        } else if (jobType.equals("DATA_EXTRACTION")) {
            logDir = Paths.get(spaceDir + File.separator + "connectorLogs");
            logPattern = Pattern.compile(id + "_.+\\.log");
        } else if (jobType.equals("MIGRATING_FROM") || jobType.equals("MIGRATING_TO")) {
            logDir = Paths.get(spaceDir + File.separator + "logs");
            logPattern = Pattern.compile(".*MigrateDatastore\\.log");
        } else {
            logger.error(String.format("Job type for run '%s' is '%s' and does not match DATA_PROCESSING or DATA_EXTRACTION.", id, jobType));
            return null;
        }
        final List<File> returnFile = new ArrayList<>();
        FileVisitor<Path> fv = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path filePath, BasicFileAttributes attrs) throws IOException {
                Matcher m = logPattern.matcher(filePath.toFile().getName());
                if (m.find()) {
                    returnFile.add(filePath.toFile());
                }
                return FileVisitResult.CONTINUE;
            }
        };

        if (!logDir.toFile().exists() || !logDir.toFile().isDirectory()) {
            logger.error(String.format("Unable to retrieve run logs. Log directory '%s' is missing.", logDir.toFile().getName()));
            return null;
        }
        try {
            Files.walkFileTree(logDir, fv);
        } catch (IOException ex) {
            logger.error(String.format("Unable to find log for run '%s'.", id), ex);
            return null;
        }
        if (returnFile.size() > 0) {
            for (Iterator<File> iterator = returnFile.iterator(); iterator.hasNext(); ) {
                File file = (File) iterator.next();
                logger.info(file.getName());

            }
            return returnFile.toArray(new File[0]);
        }

        logger.debug(String.format("Unable to find log for run '%s'.", id));
        return null;
    }

    public List<String> readFilebyToken(String pathFile, String token) {

        try (InputStream inputStream = new FileInputStream(pathFile); BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            Stream<String> linesStream = bufferedReader.lines();
            return linesStream.filter(a -> a.contains(token)).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public boolean hasToe(String pathFile, String toe) {

        try (FileReader fileReader = new FileReader(pathFile); BufferedReader bufferedReader = new BufferedReader(fileReader);) {

            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (line.contains(toe)) {
                    System.out.println(line);
                    return true;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + pathFile);
        } catch (IOException e) {
            System.out.println("IO Exception occurred:" + e.getMessage());
        }

        return false;

    }

    public boolean isNullOREmpty(String toe) {
        return Strings.isNullOrEmpty(toe);
    }

    public boolean isNullOREmpty(File file, String toe) {
        return file != null && !Strings.isNullOrEmpty(toe);
    }
}
