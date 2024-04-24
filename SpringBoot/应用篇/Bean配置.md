# 自动配置原理

@SpringConfiguration注解中重要的两个注解

`@Import(AutoConfigurationPackages.Registrar.class)`,用来设置当前配置所在的包作为扫描包，后续针对当前包进行扫描

`@Import(AutoConfigurationImportSelector.class)`