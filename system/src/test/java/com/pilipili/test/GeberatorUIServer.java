//package com.pilipili.test;
//
//
//import com.github.davidfantasy.mybatisplus.generatorui.GeneratorConfig;
//import com.github.davidfantasy.mybatisplus.generatorui.MybatisPlusToolsApplication;
//import com.github.davidfantasy.mybatisplus.generatorui.mbp.NameConverter;
//
//public class GeberatorUIServer {
//
//    public static void main(String[] args) {
//        GeneratorConfig config = GeneratorConfig.builder().jdbcUrl("jdbc:mysql://10.4.110.247:3306/pilipili?useUnicode=true&useSSL=false&characterEncoding=utf8&autoReconnect=true")
//                .userName("pilipiliUser")
//                .password("123456")
//                .driverClassName("com.mysql.jdbc.Driver")
//                //数据库schema，POSTGRE_SQL,ORACLE,DB2类型的数据库需要指定
//                .schemaName("myBusiness")
//                //如果需要修改各类生成文件的默认命名规则，可自定义一个NameConverter实例，覆盖相应的名称转换方法：
//                .nameConverter(new NameConverter() {
//                    /**
//                     * 自定义Service类文件的名称规则
//                     */
//                    @Override
//                    public String serviceNameConvert(String tableName) {
//                        return this.entityNameConvert(tableName) + "Service";
//                    }
//                    /**
//                     * 自定义Controller类文件的名称规则
//                     */
//                    @Override
//                    public String controllerNameConvert(String tableName) {
//                        return this.entityNameConvert(tableName) + "Controller";
//                    }
//                })
//                .basePackage("com.pilipili.system")
//                .port(8068)
//                .build();
//        MybatisPlusToolsApplication.run(config);
//    }
//
//}