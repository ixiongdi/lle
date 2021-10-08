package fun.xruo.lle.util.generator;

import lombok.Data;

/**
 * @author kevin
 */
@Data
public class Column {
    private String name;
    private Integer type;
    private String javaType;
    private String typeName;
    private String className;
    private String label;
    private Integer displaySize;

    private String lowerCamelName;

    private Boolean required;


    static public String getJavaClassNameByType(Integer type) {
        switch (type) {
            case -5:
                return "java.lang.Long";
            case 12:
                return "java.lang.String";
            case 93:
                return "java.time.LocalDateTime";
            case -7:
                return "java.lang.Boolean";
            default:
                return "java.lang.Object";
        }
    }

    static public String getJavaClassNameByTypeName(String name) {
        switch (name) {
            case "INT":
                return "java.lang.Integer";
            case "BIGINT UNSIGNED":
                return "java.lang.Long";
            case "VARCHAR":
                return "java.lang.String";
            case "DATETIME":
                return "java.time.LocalDateTime";
            case "BIT":
                return "java.lang.Boolean";
            default:
                return "java.lang.Object";
        }
    }
}
