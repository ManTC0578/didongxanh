package com.congman.ddd.util.file;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class FileUtil {

    public static String upload(HttpServletRequest request,
                                String destForder,
                                MultipartFile multipartFile) throws IOException, ServletException {
        String fileName = normalizeFilename(multipartFile.getOriginalFilename());
        File path2Save = buildDestinationFile(request, destForder, fileName);
        try{
            multipartFile.transferTo(path2Save);
        }catch (Exception e){
            System.out.print(e.getMessage());
        }

        return path2Save.getName();
    }

    private static String normalizeFilename(String fileName) {
        String res = fileName.replaceAll(" ", "_");
        return res;
    }

    public static File buildDestinationFile(HttpServletRequest request,
                                            String destFolder, String fileName) {
        ServletContext context = request.getSession().getServletContext();
        String commonDirpath = context.getRealPath(destFolder);
        File baseFile = new File(commonDirpath);
        if (!baseFile.exists()) {
            baseFile.mkdir();
        }

        String newName = "";
        // Parse the request
        // Get just file name of upload file

        newName = normalizeFilename(fileName);
        // Get name withoout exension , get extension
        String nameWithoutExt = normalizeFilename(
                (fileName.indexOf(".") > 0) ?
                        fileName.substring(0, fileName.lastIndexOf("."))
                        : fileName);

        String ext = fileName.indexOf(".") < fileName.length()
                ? fileName.substring(fileName.indexOf(".") + 1)
                : "";

        // ********************PATH to SAVE FILE************************
        File pathToSave = new File(commonDirpath, fileName);

        int counter = 1;
        // Check if existed, generating new file name
        while (pathToSave.exists()) {
            // New filename = name(counter).ext
            StringBuffer buffer = new StringBuffer();
            buffer.append(nameWithoutExt).append("(").append(counter).append(")").append(".").append(ext);
            newName = buffer.toString();

            // Create new file to receive uploaded file
            pathToSave = new File(commonDirpath, newName);

            counter++;
        }
        return pathToSave;
    }
    public static void remove(String filename){
        File file = new File(filename);
        file.delete();
    }
}
