package com.vikentiev.mycalc2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created with IntelliJ IDEA.
 * User: Ryslan
 * Date: 18.05.13
 * Time: 15:40
 * To change this template use File | Settings | File Templates.
 */


@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.FIELD)
public @interface Res{
    Param[] type();
}