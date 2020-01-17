

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

```
/**
 * 响应信息主体
 *
 * @param <T>
 * @author lengleng
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "响应信息主体")
public class R<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@ApiModelProperty(required = true,notes = "结果码",example = "1")
	private int code;

	@Getter
	@Setter
	@ApiModelProperty(required = true,notes = "结果提示",example = "SUCCESS")
	private String msg;


	@Getter
	@Setter
	@ApiModelProperty(required = true,notes = "结果体",example = "{\"name\":\"nkul\"}")
	private T data;

	public static <T> R<T> ok() {
		return restResult(null, 1, null);
	}

	public static <T> R<T> ok(T data) {
		return restResult(data, 1, null);
	}

	public static <T> R<T> ok(T data, String msg) {
		return restResult(data, 1, msg);
	}

	public static <T> R<T> failed() {
		return restResult(null, 0, null);
	}

	public static <T> R<T> failed(String msg) {
		return restResult(null, 0, msg);
	}

	public static <T> R<T> failed(T data) {
		return restResult(data, 0, null);
	}

	public static <T> R<T> failed(T data, String msg) {
		return restResult(data, 0, msg);
	}

	private static <T> R<T> restResult(T data, int code, String msg) {
		R<T> apiResult = new R<>();
		apiResult.setCode(code);
		apiResult.setData(data);
		apiResult.setMsg(msg);
		return apiResult;
	}
}
```

```
@RestController
@Api(tags = "UserController")
public class UserController {

/*    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "path")
    })*/
    @GetMapping("/hello")
    public R<User> hello( String username,String password){
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        return R.ok(user);
    }
}
```

