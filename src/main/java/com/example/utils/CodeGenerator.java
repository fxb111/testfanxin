//package com.example.utils;
//
//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//import com.baomidou.mybatisplus.generator.config.po.TableFill;
//import com.baomidou.mybatisplus.generator.config.rules.DateType;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class CodeGenerator {
//  public static void main(String[] args) {
//    FastAutoGenerator.create(new DataSourceConfig.Builder("jdbc:mysql://localhost:3306/your_db_name", "username", "password"))
//      .globalConfig(builder -> {
//        builder.author("Your Name") // 设置作者
//          .outputDir(System.getProperty("user.dir") + "/src/main/java"); // 指定输出目录
//      })
//      .packageConfig(builder -> {
//        builder.parent("com.example.projectDemo") // 设置父包名
//          .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir") + "/src/main/resources/mapper")); // 设置mapperXml生成路径
//      })
//      .strategyConfig(builder -> {
//        builder.addInclude("your_table_name") // 设置需要生成的表名
//          .entityBuilder().naming(NamingStrategy.underline_to_camel).enableLombok() // 生成的实体类使用Lombok
//          .controllerBuilder().enableRestStyle() // 生成 @RestController 控制器
//          .mapperBuilder().enableBaseResultMap(); // 启用 BaseResultMap
//      })
//      .templateEngine(new VelocityTemplateEngine()) // 使用Velocity模板引擎
//      .execute();
//  }
//
//}
