

## 发布

```
mvn install:install-file -Dfile=./swagger2-1.0.0.jar -DgroupId=com.github.nkul -DartifactId=swagger2 -Dversion=1.0.0 -Dpackaging=jar
```





## 使用

```
<dependency>
		<groupId>com.github.nkul</groupId>
		<artifactId>swagger2</artifactId>
		<version>1.0.0</version>
</dependency>
```



## 配置

```
启动类开启swagger2
@EnableNkulxSwagger2
application.yml配置
nkul:
  swagger:
    enabled: true
    host: 127.0.0.1
    base-package: com.github.nkul.swaggerdemo.controller
    contact:
      name: nkul
      email: 1471260166@qq.com
      url: https://www.hwater.site
    title: swagger2demo接口文档
    version: 1.0.0
    description: 描述
    license: 许可证
    license-url: https://www.hwater.site
    terms-of-service-url: https://www.hwater.site
    group-name: swaggerdeomo
```

