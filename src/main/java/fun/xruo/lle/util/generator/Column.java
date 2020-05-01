package fun.xruo.lle.util.generator;

import lombok.Data;

@Data
public class Column {
    private String name;
    private Integer type;
    private String typeName;
    private String className;
    private String label;
    private Integer displaySize;

    private String lowerCamelName;
}
