package fun.xruo.lle.util.generator;

import lombok.Data;

@Data
public class TemplateFile {
    private String name;
    private String type;
    private String srcPath;
    private String dstPath;

    public TemplateFile(String name, String type, String srcPath, String dstPath) {
        this.name = name;
        this.type = type;
        this.srcPath = srcPath;
        this.dstPath = dstPath;
    }
}
