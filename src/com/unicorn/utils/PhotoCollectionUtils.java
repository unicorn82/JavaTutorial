package com.unicorn.utils;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PhotoCollectionUtils {

    static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    static String targetPath = "/Users/eyin/Pictures/Photos Library.photoslibrary/originals";

    public static void main(String[] args) {
        String dirPath = "/Users/eyin/Pictures/Photos Library.photoslibrary/originals";

        File dirs = new File(dirPath);
        PhotoCollectionUtils utils = new PhotoCollectionUtils();
        utils.loopAllSubs(dirs);



    }

    public void loopAllSubs(File root){
        if(root.isDirectory()) {

            File[] subs = root.listFiles();
            for (File subDirecotry : subs) {
                splitDirectoryHandler(subDirecotry);
            }
        }
    }

    public void splitDirectoryHandler(File file){

        if(file.isDirectory()){

            File[] subs = file.listFiles();
            int count = 0;

            int directory = 0;

//            File target = new File(file, directory+"");

            if(subs.length > 300){
                for(File f: subs){
                    count++;
                    if(count > 200){
                        File target = new File(file, count/200+"");
                        if(!target.exists()){
                            target.mkdirs();
                        }
                        try {
                            System.out.println("move file "+f.getAbsolutePath()+" to target "+target.getAbsolutePath());
                            Files.move(Paths.get(f.getAbsolutePath()), Paths.get(target.getAbsolutePath()+File.separator+f.getName()), StandardCopyOption.REPLACE_EXISTING);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                }

            }
        }
    }

    public void directoryHandler(File file){
        if(file.isDirectory()){
            File[] subs = file.listFiles();
            for(File sub: subs){
                directoryHandler(sub);

            }
        }else{
            try {
                pictureHandler(file);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void pictureHandler(File picture) throws IOException {
        System.out.println(picture.getAbsolutePath());
        FileTime creationTime = (FileTime) Files.getAttribute(picture.toPath(), "creationTime");


        String dateCreated = df.format(creationTime.toMillis());
        System.out.println(dateCreated.substring(0,4));
        File targetDir = new File(targetPath, dateCreated.substring(0,4));
        if(!targetDir.exists()){
            targetDir.mkdirs();
        }

        Files.move(Paths.get(picture.getAbsolutePath()), Paths.get(targetDir.getAbsolutePath()+File.separator+picture.getName()), StandardCopyOption.REPLACE_EXISTING);


    }
}
