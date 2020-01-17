package com.github.nkul.swagger2.annotation;
/*
 * @author  nkul
 * @date  2020/1/17 2:32 下午
 * @url   https://www.github.com/nkulpj
 * @web   https://www.hwater.site
 * @version 1.0
 */


import com.github.nkul.swagger2.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SwaggerAutoConfiguration.class})
public @interface EnableNkulxSwagger2 {
}
