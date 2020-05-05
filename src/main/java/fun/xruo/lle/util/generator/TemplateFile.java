package fun.xruo.lle.util.generator;

import lombok.Data;

@Data
public class TemplateFile {
    private String name;
    private String path;
    private String type;

    public TemplateFile(String name, String path, String type) {
        this.name = name;
        this.path = path;
        this.type = type;
    }
}
