package io.quarkus.jaeger.runtime;

import io.opentracing.Scope;
import io.opentracing.ScopeManager;
import io.opentracing.Span;

public class MDCScopeManager implements ScopeManager {

    private final ScopeManager wrapped;

    public MDCScopeManager(ScopeManager scopeManager) {
        this.wrapped = scopeManager;
    }

    @Override
    public Scope activate(Span span, boolean finishSpanOnClose) {
        return new MDCScope(wrapped.activate(span, finishSpanOnClose));
    }

    @Override
    public Scope active() {
        return wrapped.active();
    }
}
