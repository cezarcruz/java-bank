package br.com.cezarcruz.arch

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import io.kotest.core.spec.style.StringSpec
import io.micronaut.http.annotation.Controller

class ControllerArchTest : StringSpec({

    val importedClasses: JavaClasses =
        ClassFileImporter()
            .importPackages("br.com.cezarcruz")

    "should ensure controllers package" {
        classes().that().areAnnotatedWith(Controller::class.java)
            .should().resideInAPackage("br.com.cezarcruz.rest")
            .check(importedClasses)
    }

    "should ensure controllers name"{
        classes().that().areAnnotatedWith(Controller::class.java)
            .should().haveSimpleNameEndingWith("Controller")
            .check(importedClasses)
    }

})