package fun.xruo.lle.util.generator;

import lombok.Data;

import java.util.List;

/**
 * @author xiongdi
 */
@Data
public class Table {
    private String name;
    private String comment;
    private List<Column> columns;
    private String upperCamelName;
    private String lowerCamelName;
    private String packageName;
}
