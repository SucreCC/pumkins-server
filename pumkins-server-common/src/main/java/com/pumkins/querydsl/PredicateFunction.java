package com.pumkins.querydsl;


import com.querydsl.core.types.Predicate;

/**
 * @author YaokeHu
 * @description
 * @date 2021-03-31 19:27
 **/
@FunctionalInterface
public interface PredicateFunction {

    Predicate predicate();
}
