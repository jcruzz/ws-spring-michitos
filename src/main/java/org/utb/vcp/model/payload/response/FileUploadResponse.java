package org.utb.vcp.model.payload.response;

public class FileUploadResponse {
    private String fileName;
    private String fileUri;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUri() {
        return fileUri;
    }

    public void setFileUri(String fileUri) {
        this.fileUri = fileUri;
    }

    @Override
    public String toString() {
        return "FileUploadResponse [fileName=" + fileName + ", fileUri=" + fileUri + "]";
    }

}
