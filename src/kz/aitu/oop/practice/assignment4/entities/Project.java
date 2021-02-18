package kz.aitu.oop.practice.assignment4.entities;

public class Project {
    protected int code;
    protected String name;
    protected String application;

    public Project() { };

    public Project(String name, String application) {
        setName(name);
        setApplication(application); }

    public Project(int code, String name, String application) {
        setCode(code);
        setName(name);
        setApplication(application);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    @Override
    public String toString() {
        return "Project{" + "code=" + code + ", name='" + name + '\'' +
                ", application='" + application + '\'' + '}'; }
}
