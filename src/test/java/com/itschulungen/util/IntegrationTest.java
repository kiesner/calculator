package com.itschulungen.util;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Test
@Tag("integration-test")
@Retention(RetentionPolicy.RUNTIME)
@Target({
	ElementType.TYPE,
	ElementType.METHOD
})
public @interface IntegrationTest {}