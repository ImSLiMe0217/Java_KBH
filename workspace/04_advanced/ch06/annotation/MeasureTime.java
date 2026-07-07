package ch06.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 메서드를 대상으로 지정
@Target(ElementType.METHOD)
// 실행 시점에 사용 가능하도록 유지정책을 RUNTIME으로 지정
@Retention(RetentionPolicy.RUNTIME)
// 지정된 메서드의 실행 시간을 출력하는 어노테이션
public @interface MeasureTime {
    String taskName() default "";
}
