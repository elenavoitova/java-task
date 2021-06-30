package app;

public class EmailAttachment {
    private String filename;
    private String contentType;
    private int size;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\t\t\t\t\t" + "filename:'" + filename + '\'' + "\n" +
                "\t\t\t\t\t" + "contentType='" + contentType + '\'' + "\n" +
                "\t\t\t\t\t" + "size=" + size +
                "\n\t\t\t\t }";
    }
}
