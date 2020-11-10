package com.se.sample.controlling_task_finishing;

import java.util.concurrent.FutureTask;

public class ResultTask extends FutureTask<String> {
    private final String name;

    public ResultTask(ExecutableTask callable) {
        super(callable);
        this.name= callable.getName();
    }

    @Override
    protected void done() {
        if (isCancelled()) {
            System.out.printf("%s: Has been canceled\n",name);
        } else {
            System.out.printf("%s: Has finished\n",name);
        }
    }

}
