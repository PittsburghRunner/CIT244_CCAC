/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.timeline.components;

/**
 *
 * @author christopher.eckles
 */
public enum ComponentType {
    COMPONENT("Component", "week4.timeline.components.Component"),
    COMPUTER_COMPONENT("ComputerComponent", "week4.timeline.components.ComputerComponent");

    private final String className;
    private final String classPath;

    private ComponentType(String className, String classPath) {
        this.className = className;
        this.classPath = classPath;
    }

    public String getClassName() {
        return className;
    }

    public String getClassPath() {
        return classPath;
    }



}
