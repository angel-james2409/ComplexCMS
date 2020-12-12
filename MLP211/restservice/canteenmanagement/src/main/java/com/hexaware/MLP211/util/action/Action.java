package com.hexaware.MLP211.util.action;

abstract public class Action{
    public abstract void begin();
    public abstract void end();
    public abstract void execute();
    final public void go(){
        begin();
        execute();
        end();
    } 
}