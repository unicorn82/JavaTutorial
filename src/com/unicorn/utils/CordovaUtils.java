package com.unicorn.utils;

import net.lingala.zip4j.model.ZipParameters;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionMethod;

public class CordovaUtils {

    private static final String template = "<source-file src=\"%s\" target-dir=\"%s\"/>";

    public static File getGraphicFile(File graphicFile, File graphicCompanionFile) throws Exception {

        if (graphicFile != null) {
            if (graphicCompanionFile != null) {
                ZipParameters parameters = new ZipParameters();
                File zipFile = new File("/Users/eyin/Downloads/mcp/temp/"+ graphicFile.getName()+"");
                ZipFile zipFileObj = new ZipFile(zipFile);
                parameters.setCompressionMethod(CompressionMethod.DEFLATE);
                parameters.setFileNameInZip(graphicFile.getName());

                zipFileObj.addStream(new FileInputStream(graphicFile), parameters);
                parameters.setFileNameInZip(graphicCompanionFile.getName());
                zipFileObj.addStream(new FileInputStream(graphicCompanionFile), parameters);
                zipFileObj.close();

                return zipFile;
            } else {
                return graphicFile;
            }
        } else {
            return null;
        }

    }

    private static void getAllFiles(String dirPath, List<File> files){
        File dir = new File(dirPath);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null ) {
            for (File child : directoryListing) {
                // Do something with child
                if(child.isDirectory()){
                    getAllFiles(child.getAbsolutePath(), files);
                }
                if(child.isFile()){
                    files.add(child);
                }
            }
        }
    }

    public static String generateCordovaPluginSourceFile(String dirPath){
        List<File> files = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        getAllFiles(dirPath, files);
        for(File file:files){
//            sb.append(template.format(f, f));
            String f = file.getAbsolutePath();
            String filename = file.getName();

            System.out.println(String.format(template,f.replace(dirPath, "src/android"), f.replace(dirPath, "src").replace("/android", "").replace(filename, "")));
        }
        return "";


    }

    public static void main(String[] args) {
//        String dirPath = "/Users/eyin/Project/PinpointMobile/pinpoint-mobile-85/cordova-plugins/offline_restapi/src/android";
//        System.out.println(CordovaUtils.generateCordovaPluginSourceFile(dirPath));

        Map<String, String> map = new HashMap<>();
        map.put("1", "3");
        map.put("2", "4");
        File graphicFile = new File("/Users/eyin/Downloads/mcp/mcp/n_pc_249292_03_a_01_00.wrl");
        File graphicCompanionFile = new File("/Users/eyin/Downloads/mcp/mcp/n_pc_249292_03_a_01_00.interactivity.xml");
//        File graphicFile = new File("/Users/eyin/Downloads/ICN-LEAP-1B-742105-B-07482-02010-A-003-01/ICN-LEAP-1B-742105-B-07482-02010-A-003-01.WRL");
//        File graphicCompanionFile = new File("/Users/eyin/Downloads/ICN-LEAP-1B-742105-B-07482-02010-A-003-01/ICN-LEAP-1B-742105-B-07482-02010-A-003-01.interactivity.XML");

        try {
            CordovaUtils.getGraphicFile(graphicFile, graphicCompanionFile);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
