/*
 * Copyright 2010-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.jetbrains.jet.di;

import org.jetbrains.jet.lang.resolve.java.JavaSemanticServices;
import org.jetbrains.jet.lang.resolve.java.JavaDescriptorResolver;
import org.jetbrains.jet.lang.resolve.BindingTrace;
import org.jetbrains.jet.lang.resolve.java.JavaBridgeConfiguration;
import org.jetbrains.jet.lang.resolve.java.PsiClassFinderForJvm;
import org.jetbrains.jet.lang.descriptors.ModuleDescriptor;
import org.jetbrains.jet.lang.resolve.java.CompilerDependencies;
import org.jetbrains.jet.lang.resolve.java.CompilerSpecialMode;
import com.intellij.openapi.project.Project;
import org.jetbrains.jet.lang.resolve.java.JavaTypeTransformer;
import org.jetbrains.jet.lang.resolve.NamespaceFactoryImpl;
import org.jetbrains.jet.lang.resolve.java.CompilerDependencies;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/* This file is generated by org.jetbrains.jet.di.AllInjectorsGenerator. DO NOT EDIT! */
public class InjectorForJavaSemanticServices {

    private JavaSemanticServices javaSemanticServices;
    private JavaDescriptorResolver javaDescriptorResolver;
    private BindingTrace bindingTrace;
    private PsiClassFinderForJvm psiClassFinderForJvm;
    private final Project project;

    public InjectorForJavaSemanticServices(
        @NotNull CompilerDependencies compilerDependencies,
        @NotNull Project project
    ) {
        this.javaSemanticServices = new JavaSemanticServices();
        this.javaDescriptorResolver = new JavaDescriptorResolver();
        this.bindingTrace = new org.jetbrains.jet.lang.resolve.BindingTraceContext();
        JavaBridgeConfiguration javaBridgeConfiguration = new JavaBridgeConfiguration();
        this.psiClassFinderForJvm = new PsiClassFinderForJvm();
        ModuleDescriptor moduleDescriptor = new org.jetbrains.jet.lang.descriptors.ModuleDescriptor("<dummy>");
        CompilerSpecialMode compilerSpecialMode = compilerDependencies.getCompilerSpecialMode();
        this.project = project;
        JavaTypeTransformer javaTypeTransformer = new JavaTypeTransformer();
        NamespaceFactoryImpl namespaceFactoryImpl = new NamespaceFactoryImpl();

        this.javaSemanticServices.setDescriptorResolver(javaDescriptorResolver);
        this.javaSemanticServices.setPsiClassFinder(psiClassFinderForJvm);
        this.javaSemanticServices.setTrace(bindingTrace);
        this.javaSemanticServices.setTypeTransformer(javaTypeTransformer);

        this.javaDescriptorResolver.setNamespaceFactory(namespaceFactoryImpl);
        this.javaDescriptorResolver.setProject(project);
        this.javaDescriptorResolver.setPsiClassFinder(psiClassFinderForJvm);
        this.javaDescriptorResolver.setSemanticServices(javaSemanticServices);
        this.javaDescriptorResolver.setTrace(bindingTrace);

        javaBridgeConfiguration.setJavaSemanticServices(javaSemanticServices);
        javaBridgeConfiguration.setMode(compilerSpecialMode);
        javaBridgeConfiguration.setProject(project);

        this.psiClassFinderForJvm.setCompilerDependencies(compilerDependencies);
        this.psiClassFinderForJvm.setProject(project);

        javaTypeTransformer.setJavaSemanticServices(javaSemanticServices);
        javaTypeTransformer.setResolver(javaDescriptorResolver);

        namespaceFactoryImpl.setConfiguration(javaBridgeConfiguration);
        namespaceFactoryImpl.setModuleDescriptor(moduleDescriptor);
        namespaceFactoryImpl.setTrace(bindingTrace);

        javaBridgeConfiguration.init();

        psiClassFinderForJvm.initialize();

    }

    public JavaSemanticServices getJavaSemanticServices() {
        return this.javaSemanticServices;
    }

    public JavaDescriptorResolver getJavaDescriptorResolver() {
        return this.javaDescriptorResolver;
    }

    public BindingTrace getBindingTrace() {
        return this.bindingTrace;
    }

    public PsiClassFinderForJvm getPsiClassFinderForJvm() {
        return this.psiClassFinderForJvm;
    }

    public Project getProject() {
        return this.project;
    }

}
