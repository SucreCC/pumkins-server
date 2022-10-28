package com.pumkins.querydsl;

import com.querydsl.core.QueryModifiers;
import com.querydsl.core.types.CollectionExpression;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.MapExpression;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAUpdateClause;
import javax.annotation.Nonnegative;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author Sucre
 * @date 2021-03-29 20:27:06
 * <p>
 * 包装JPAQuery类，实现动态的SQL操作,处理类似于
 * where(判断条件,name.like('参数'))
 * 这种根据 判断条件 是true or false来决定后面的语句是否需要
 * @see JPAQuery
 * <p>
 * 目前是尽可能的按照JPAQuery提供的接口来进行包裹处理，可能中间有遗失，所以，如果大家有用到直接加方法就行
 */
public class JPAQueryWrapper<T> {
    private final JPAQuery<T> jpaQuery;
    private final JPAUpdateClause updateClause;

    public JPAQueryWrapper(JPAQuery<T> jpaQuery, JPAUpdateClause updateClause) {
        this.jpaQuery = jpaQuery;
        this.updateClause = updateClause;
    }

    public static <T> JPAQueryWrapper<T> create(JPAQuery<T> jpaQuery) {
        return new JPAQueryWrapper<>(jpaQuery, null);
    }

    public JPAQueryWrapper<T> distinct(boolean flag) {
        if (flag) {
            jpaQuery.distinct();
        }
        return this;
    }

    public JPAQueryWrapper<T> distinct() {
        return distinct(true);
    }

    public JPAQueryWrapper<T> groupBy(boolean flag, Expression<?> expression) {
        if (flag) {
            jpaQuery.groupBy(expression);
        }
        return this;
    }

    public JPAQueryWrapper<T> groupBy(Expression<T> expression) {
        return groupBy(true, expression);
    }

    public JPAQueryWrapper<T> groupBy(boolean flag, Expression<?>... expressions) {
        if (flag) {
            jpaQuery.groupBy(expressions);
        }
        return this;
    }

    public JPAQueryWrapper<T> groupBy(Expression<?>... expressions) {
        return groupBy(true, expressions);
    }

    public JPAQueryWrapper<T> having(boolean flag, Predicate predicate) {
        if (flag) {
            jpaQuery.having(predicate);
        }
        return this;
    }

    public JPAQueryWrapper<T> having(Predicate predicate) {
        return having(true, predicate);
    }

    public JPAQueryWrapper<T> having(boolean flag, Predicate... predicates) {
        if (flag) {
            jpaQuery.having(predicates);
        }
        return this;
    }

    public JPAQueryWrapper<T> having(Predicate... predicates) {
        return having(true, predicates);
    }

    public JPAQueryWrapper<T> orderBy(boolean flag, OrderSpecifier<?> specifier) {
        if (flag) {
            jpaQuery.orderBy(specifier);
        }
        return this;
    }

    public JPAQueryWrapper<T> orderBy(OrderSpecifier<?> specifier) {
        return orderBy(true, specifier);
    }


    public JPAQueryWrapper<T> orderBy(boolean flag, OrderSpecifier<?>... specifiers) {
        if (flag) {
            jpaQuery.orderBy(specifiers);
        }
        return this;
    }

    public JPAQueryWrapper<T> orderBy(OrderSpecifier<?>... specifiers) {
        return orderBy(true, specifiers);
    }

    public JPAQueryWrapper<T> whereNonNull(Object param, Predicate predicate) {
        return where(Objects.nonNull(param), predicate);
    }

    public JPAQueryWrapper<T> where(boolean flag, Predicate predicate) {
        if (flag) {
            this.jpaQuery.where(predicate);
        }
        return this;
    }

    public JPAQueryWrapper<T> where(boolean flag, PredicateFunction predicateFunction) {
        if (flag) {
            this.jpaQuery.where(predicateFunction.predicate());
        }
        return this;
    }

    public JPAQueryWrapper<T> where(boolean flag, List<PredicateFunction> predicateFunctionList) {
        if (flag && predicateFunctionList != null) {
            predicateFunctionList.forEach(predicateFunction -> this.jpaQuery.where(predicateFunction.predicate()));
        }
        return this;
    }

    public JPAQueryWrapper<T> where(boolean flag, PredicateFunction... predicates) {
        List<PredicateFunction> result = Optional.ofNullable(predicates)
                .map(Arrays::asList)
                .orElse(null);
        return where(flag, result);
    }

    public JPAQueryWrapper<T> where(Predicate predicate) {
        return where(true, predicate);
    }

    public JPAQueryWrapper<T> where(boolean flag, Predicate... predicates) {
        if (flag) {
            jpaQuery.where(predicates);
        }
        return this;
    }

    public JPAQueryWrapper<T> where(Predicate... predicates) {
        return where(true, predicates);
    }

    public JPAQueryWrapper<T> limit(@Nonnegative long limit) {
        jpaQuery.limit(limit);
        return this;
    }

    public JPAQueryWrapper<T> offset(long offset) {
        jpaQuery.offset(offset);
        return this;
    }

    public JPAQueryWrapper<T> restrict(QueryModifiers modifiers) {
        jpaQuery.restrict(modifiers);
        return this;
    }

    public <P> JPAQueryWrapper<T> leftJoin(CollectionExpression<?, P> target, Path<P> alias) {
        jpaQuery.leftJoin(target, alias);
        return this;
    }

    public <P> JPAQueryWrapper<T> leftJoin(EntityPath<P> target) {
        jpaQuery.leftJoin(target);
        return this;
    }

    public <P> JPAQueryWrapper<T> leftJoin(EntityPath<P> target, Path<P> alias) {
        jpaQuery.leftJoin(target, alias);
        return this;
    }

    public <P> JPAQueryWrapper<T> leftJoin(MapExpression<?, P> target) {
        jpaQuery.leftJoin(target);
        return this;
    }

    public <P> JPAQueryWrapper<T> leftJoin(MapExpression<?, P> target, Path<P> alias) {
        jpaQuery.leftJoin(target, alias);
        return this;
    }


    public <P> JPAQueryWrapper<T> join(EntityPath<P> target) {
        jpaQuery.join(target);
        return this;
    }

    public <P> JPAQueryWrapper<T> join(EntityPath<P> target, Path<P> alias) {
        jpaQuery.join(target, alias);
        return this;
    }

    public <P> JPAQueryWrapper<T> join(CollectionExpression<?, P> target) {
        jpaQuery.join(target);
        return this;
    }

    public <P> JPAQueryWrapper<T> join(CollectionExpression<?, P> target, Path<P> alias) {
        jpaQuery.join(target, alias);
        return this;
    }


    public <P> JPAQueryWrapper<T> join(MapExpression<?, P> target) {
        jpaQuery.join(target);
        return this;
    }

    public <P> JPAQueryWrapper<T> join(MapExpression<?, P> target, Path<P> alias) {
        jpaQuery.join(target, alias);
        return this;
    }


    public JPAQueryWrapper<T> on(Predicate condition) {
        jpaQuery.on(condition);
        return this;
    }

    public JPAQueryWrapper<T> on(Predicate... conditions) {
        jpaQuery.on(conditions);
        return this;
    }

    public JPAQuery<T> build() {
        return this.jpaQuery;
    }

    /**
     * Update的封装语句，对应控制null和where操作语句
     */

    public static JPAQueryWrapper<?> create(JPAUpdateClause updateClause) {
        return new JPAQueryWrapper<>(null, updateClause);
    }

    public <R> JPAQueryWrapper<?> set(Path<R> path, R value) {
        this.updateClause.set(path, value);
        return this;
    }

    public <R> JPAQueryWrapper<?> set(boolean flag, Path<R> path, R value) {
        if (flag) {
            this.updateClause.set(path, value);
        }
        return this;
    }

    public <L, R> JPAQueryWrapper<?> set(boolean flag, Path<R> path, Function<L, R> converter, L value) {
        if (flag) {
            return set(true, path, converter.apply(value));
        }
        return this;
    }

    public <R> JPAQueryWrapper<?> setNonNull(Path<R> path, R value) {
        return set(Objects.nonNull(value), path, value);
    }

    public JPAQueryWrapper<?> updateWhere(Predicate... predicates) {
        this.updateClause.where(predicates);
        return this;
    }

    public JPAQueryWrapper<?> updateWhere(boolean flag, Predicate... predicates) {
        if (flag) {
            this.updateClause.where(predicates);
        }
        return this;
    }

    public JPAQueryWrapper<?> updateWhere(boolean flag, PredicateFunction... predicateFunctions) {
        if (flag) {
            Arrays.stream(predicateFunctions)
                    .forEach(predicateFunction -> this.updateClause.where(predicateFunction.predicate()));
        }
        return this;
    }

    public JPAQueryWrapper<?> updateWhereNonNull(Object param, Predicate... predicates) {
        return updateWhere(Objects.nonNull(param), predicates);
    }

    public JPAUpdateClause updateBuild() {
        return this.updateClause;
    }
}
