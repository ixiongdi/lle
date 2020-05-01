package fun.xruo.lle.util.generator;

import lombok.Data;

import java.util.List;

@Data
public class Table {
    private String name;
    private String remarks;

    private List<Column> columns;


    private String upperCamelName;
}
