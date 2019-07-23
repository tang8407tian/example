package com.ttac.service.myabtis.config.swagger;/**
// * Created by tkmttt on 2019/5/13 17:14.
// */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: marketing
 * @description: Swagger2配置类
 * @author: Bao Hongbin
 * @create: 2019-05-13 17:14
*/

@Configuration
@EnableSwagger2
public class Swagger2Configuration {



    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("user")
                .apiInfo(userApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ttac.service.myabtis.controller.user"))
                .build();

    }
    private ApiInfo userApiInfo() {
        return new ApiInfoBuilder().title("TTAC Api Docs : user").version("1.0.0").build();
    }




   /* private OAuth securitySchema() {

        List<AuthorizationScope> authorizationScopeList = newArrayList();
        authorizationScopeList.add(new AuthorizationScope("read", "read all"));
        authorizationScopeList.add(new AuthorizationScope("write", "access all"));
        List<GrantType> grantTypes               = newArrayList();
        GrantType passwordCredentialsGrant = new ResourceOwnerPasswordCredentialsGrant(accessTokenUri);
        grantTypes.add(passwordCredentialsGrant);

        return new OAuth("oauth2", authorizationScopeList, grantTypes);
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {

        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[3];
        authorizationScopes[0] = new AuthorizationScope("read", "read all");
        authorizationScopes[1] = new AuthorizationScope("trust", "trust all");
        authorizationScopes[2] = new AuthorizationScope("write", "write all");

        return Collections.singletonList(new SecurityReference("oauth2", authorizationScopes));
    }

    @Bean
    SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder().clientId("test").clientSecret("test").realm("test-app-realm")
            .appName("test-app").scopeSeparator(",").additionalQueryStringParams(null)
            .useBasicAuthenticationWithAccessCodeGrant(false).build();
    }*/

//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(new ApiInfoBuilder()
//                        .title("Api Docs")
//                        .version("1.0.0")
//                        .build())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.biz.primus.ms.activity.api.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }

}
