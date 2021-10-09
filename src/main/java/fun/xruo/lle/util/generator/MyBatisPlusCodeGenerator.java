package fun.xruo.lle.util.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;

import java.util.Collections;

public class MyBatisPlusCodeGenerator {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://mysql.ca3zw9ojro1a.rds.cn-northwest-1.amazonaws.com.cn:3306/lle", "lle", "lle")
                .globalConfig(builder -> {
                    builder.author("baomidou") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("/Users/xiongdi/Documents/gen"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.baomidou.mybatisplus.samples.generator") // 设置父包名
                            .moduleName("sys");// 设置父包模块名
                })
                .strategyConfig(builder -> {
                    builder.addInclude("sys_user", "sys_menu", "sys_role"); // 设置需要生成的表名
                })
                .injectionConfig(builder -> {
                    builder.beforeOutputFile((tableInfo, objectMap) -> {
                                System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
                            })
                            .customMap(Collections.singletonMap("test", "baomidou"))
                            .customFile(Collections.singletonMap("test.txt", "/templates/test.vm"));
                })
                .execute();
    }
}
