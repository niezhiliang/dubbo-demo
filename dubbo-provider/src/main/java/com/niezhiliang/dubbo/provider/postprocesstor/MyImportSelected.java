package com.niezhiliang.dubbo.provider.postprocesstor;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/8/17 11:22
 */
public class MyImportSelected implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("MyImportSelected------------");
        return new String[0];
    }
}
